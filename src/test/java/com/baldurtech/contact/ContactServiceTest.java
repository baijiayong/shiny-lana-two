package com.baldurtech.contact;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class ContactServiceTest {
    private Long CONTACT_ID = 1L;
    Contact contact;
    
    @Mock
    ContactRepository contactRepository;
    
    @InjectMocks
    ContactService contactService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setup() {
        contact = new Contact();
        contact.setName("Xiaobai");
        contact.setMobile("18233333333");
        contact.setVpmn("63333");
        contact.setEmail("xiaobai@gmail.com");
        contact.setHomeAddress("Taiyuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
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
    
    @Test
    public void 在ContactService中将会调用ContactRepository的save方法() {
        contactService.save(contact);
        verify(contactRepository).save(any(Contact.class));
    }
    
    @Test
    public void 在ContactService中将会调用ContactRepository的update方法() {
        contactService.update(contact);
        verify(contactRepository).update(any(Contact.class));
    }
    
    @Test
    public void 在ContactService中将会调用ContactRepository的delete方法() {
        contactService.delete(CONTACT_ID);
        verify(contactRepository).delete(CONTACT_ID);
    }
}