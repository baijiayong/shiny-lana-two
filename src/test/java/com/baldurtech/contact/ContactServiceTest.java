package com.baldurtech.contact;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class ContactServiceTest {
    private Long CONTACT_ID = 1L;
    
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
    
    @Test
    public void 在ContactServie中将会调用ContactRepository的getById方法() {
        contactService.show(CONTACT_ID);
        verify(contactRepository).getById(CONTACT_ID);
    }
}