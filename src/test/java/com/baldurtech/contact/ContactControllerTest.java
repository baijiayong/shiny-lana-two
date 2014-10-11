package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import com.baldurtech.config.WebAppConfigurationAware;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.ArrayList;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ContactControllerTest extends WebAppConfigurationAware {

    @Mock
    ContactService contactService;
    
    @Mock
    Model model;
    
    @InjectMocks
    ContactController contactController;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    public void setup() {
        List<Contact> list = new ArrayList<Contact>();
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
         
        list.add(contact);
        list.add(contact2);
        
        when(contactService.getList()).thenReturn(list);
    }
    
   @Test
    public void 当URI为contact_list时应该由ContactController处理() throws Exception {
        mockMvc.perform(get("/contact/list"))
               .andExpect(view().name("contact/list"))
               .andExpect(model().attributeExists("list"))
               .andExpect(content().string(
                        allOf(
                                containsString("<title>contactList</title>"),
                                containsString("<td>shihang</td>"),
                                containsString("<td>15235432994</td>"),
                                containsString("<td>shanxi</td>"),
                                containsString("<td>652994</td>")
                        )));

    }
    
    @Test
    public void 在ContactController中调用ContactService中的getList方法() {
        contactController.list(model);
        verify(contactService).getList();
    }

}