package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import com.baldurtech.config.WebAppConfigurationAware;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.ArrayList;

import org.mockito.Mock;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.validation.BindingResult;

public class ContactControllerTest extends WebAppConfigurationAware {
    private Long CONTACT_ID = 1L;
    private String action;
    private Contact contact;
    
    @Mock
    ContactService contactService;
    
    @Mock
    Model model;
    
    @Mock
    BindingResult result;
    
    @InjectMocks
    ContactController contactController;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);  
    }
    
    @Before
    public void setup() {
        contact = new Contact();
        contact.setId(1L);
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
    public void 当URI为contact_list时应该由ContactController处理() throws Exception {
        mockMvc.perform(get("/contact/list"))
               .andExpect(view().name("contact/list"))
               .andExpect(model().attributeExists("contactList"));

    }
    
    @Test
    public void 在ContactController中调用ContactService中的findAll方法() {
        contactController.list(model);
        verify(contactService).findAll();
    }
    
    @Test
    public void 当URI为contact_create时应该访问create页面() throws Exception {
        mockMvc.perform(get("/contact/create"))
            .andExpect(view().name("contact/create"));
    }

    @Test
    public void 当URI为contact_save时应该访问save页面() throws Exception {
        mockMvc.perform(post("/contact/save")
                       .param("name",String.valueOf(contact.getName()))
                       .param("mobile", String.valueOf(contact.getMobile()))
                       .param("vpmn", String.valueOf(contact.getVpmn()))
                       .param("email", String.valueOf(contact.getEmail()))
                       .param("homeAddress", String.valueOf(contact.getHomeAddress()))
                       .param("officeAddress", String.valueOf(contact.getOfficeAddress()))
                       .param("job", String.valueOf(contact.getJob()))
                       .param("jobLevel", String.valueOf(contact.getJobLevel()))
                       .param("memo", String.valueOf(contact.getMemo())))
               .andExpect(redirectedUrl("list"));
               
    }
    
    @Test
    public void 当URL为contact_show时应该访问show页面() throws Exception {
        mockMvc.perform(get("/contact/show").param("id",String.valueOf(CONTACT_ID)))
            .andExpect(view().name("contact/show"))
            .andExpect(status().isOk()) 
            .andExpect(model().attributeExists("contact"));
    }
    
    @Test
    public void 在ContactController中调用ContactService中的getById方法() {
        contactController.show(String.valueOf(CONTACT_ID), model);
        verify(contactService).show(CONTACT_ID);
    }
    
    @Test
    public void 在ContactController中调用ContactService中的save方法() {
        contactController.save(contact, result);
        verify(contactService).save(any(Contact.class));
    }
    
    @Test
    public void 当action为update时应该访问update页面() throws Exception {
        mockMvc.perform(post("/contact/update")
                       .param("id", String.valueOf(CONTACT_ID))
                       .param("name",String.valueOf(contact.getName()))
                       .param("email", String.valueOf(contact.getEmail()))
                       .param("mobile", String.valueOf(contact.getMobile()))
                       .param("vpmn", String.valueOf(contact.getVpmn()))
                       .param("officeAddress", String.valueOf(contact.getOfficeAddress()))
                       .param("homeAddress", String.valueOf(contact.getHomeAddress()))
                       .param("memo", String.valueOf(contact.getMemo()))
                       .param("job", String.valueOf(contact.getJob()))
                       .param("jobLevel", String.valueOf(contact.getJobLevel())))
               .andExpect(redirectedUrl("list"));
    }
    
    @Test
    public void 在ContactController中的update方法里是否调用了ContactService的update方法() {
        action = "update";
        contactController.update(contact);
        verify(contactService).update(any(Contact.class));                         
    }
    
    @Test
    public void 当action为delete时应该访问delete页面() throws Exception {
        mockMvc.perform(post("/contact/delete")
                        .param("id", String.valueOf(CONTACT_ID)))
               .andExpect(redirectedUrl("list"));
    }
    
    @Test
    public void 在ContactController中的delete方法里是否正常调用了ContactService的delete方法() {
        contactController.delete(String.valueOf(CONTACT_ID));
        verify(contactService).delete(CONTACT_ID);
    }
}