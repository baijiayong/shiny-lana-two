package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;

import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.ui.Model;

import com.baldurtech.config.WebAppConfigurationAware;

public class ContactControllerTest extends WebAppConfigurationAware {
    private Long CONTACT_ID = 3L;
    @Mock
    Model model;
    
    @Mock
    ContactService contactService;
    
    @InjectMocks
    ContactController contactController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
   
    @Test
    public void 当URL为contact_list时应该访问list页面() throws Exception {
        mockMvc.perform(get("/contact/list"))
               .andExpect(model().attributeExists("contactList"))
               .andExpect(view().name("contact/list"));
    }
    
    @Test
    public void 在ContactController中的list方法中调用ContactService中的list方法() {
        contactController.list(model);
        verify(contactService).list();
    }
    
    @Test
    public void 当URL为contact_show时应该访问show页面() throws Exception{
        mockMvc.perform(get("/contact/show")
                        .param("id", String.valueOf(CONTACT_ID)))
               .andExpect(view().name("contact/show"))
               .andExpect(model().attributeExists("contact"));
    }
}