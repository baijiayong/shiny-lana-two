package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.config.WebAppConfigurationAware;

public class ContactControllerTest extends WebAppConfigurationAware {

    @InjectMocks
    ContactController contactController;
    
    @Mock
    ContactService contactService;
    
    @Mock
    Model model;
    
    @Before 
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    public void setup() {
        
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = new Contact();       
        contact.setName("shihang");
        contact.setMobile("15235432994");
        contact.setHomeAddress("shanxi");
        contact.setVpmn("652994");
         
        Contact contact2 = new Contact();
        contact2.setName("xiaobai");
        contact2.setMobile("18235433333");
        contact2.setHomeAddress("taiyuan");
        contact2.setVpmn("655555");
         
        contactList.add(contact);
        contactList.add(contact2);
        
        when(contactService.getContactList()).thenReturn(contactList);
    }
    
    @Test
    public void displaysContactList() throws Exception{
         mockMvc.perform(get("/contact/list"))
                .andExpect(view().name("contact/list"))
                .andExpect(model().attributeExists("contactList"))
                 .andExpect(content().string(
                        allOf(
                                containsString("<title>contactList</title>"),
                                containsString("<td>shihang</td>"),
                                containsString("<td>15235432994</td>"),
                                containsString("<td>shanxi</td>"),
                                containsString("<td>652994</td>")
                        ))
                );
    }
    
    @Test
    public void contactServiceWillInvokedGetContactList() {
        contactController.contactList(model);
        verify(contactService).getContactList();
    }
}