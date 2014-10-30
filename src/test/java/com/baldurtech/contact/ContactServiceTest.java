package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class ContactServiceTest {
    
    @Mock
    ContactRepository contactRepository;
    
    @InjectMocks
    ContactService contactService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 在ContactService中的list方法中调用contactRepository中的findAll方法() {
        contactService.list();
        verify(contactRepository).findAll();
    }
}