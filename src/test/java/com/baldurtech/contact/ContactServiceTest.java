package com.baldurtech.contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;

public class ContactServiceTest {
    @InjectMocks
    ContactService contactService;
    
    @Mock
    ContactRepository contactRepository;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void thatwillGetContactList() {
        contactService.getContactList();
        verify(contactRepository).findAllContacts();
    }
}