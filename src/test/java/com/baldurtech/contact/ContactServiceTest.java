package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

public class ContactServiceTest {
    private Long CONTACT_ID = 333L;
    Contact contact;
    
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
    
    @Test
    public void 在ContactService中的show方法中调用contactRepository中的getById方法() {
        contactService.show(CONTACT_ID);
        verify(contactRepository).getById(CONTACT_ID);
    }
    
    @Test
    public void 在ContactService中的save方法中调用contactRepository中的save方法() {
        contactService.save(any(Contact.class));
        verify(contactRepository).save(any(Contact.class));
    }
    
    @Test
    public void 在ContactService中的update方法中调用contactRepository中的update方法() {
        contactService.update(any(Contact.class));
        verify(contactRepository).update(any(Contact.class));
    }
}