package com.baldurtech.contact;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class ContactServiceTest {
    @Mock
    ContactRepository contactRepository;
    
    @InjectMocks
    ContactService contactService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 在ContactService中将会调用ContactRepository的findAll方法() {
        contactService.getList();
        verify(contactRepository).findAll();
    }
}