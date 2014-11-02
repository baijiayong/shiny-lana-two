package com.baldurtech.contact;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.mock.web.MockHttpSession;

import org.springframework.ui.Model;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.baldurtech.config.WebSecurityConfigurationAware;

import org.springframework.validation.BindingResult;

public class ContactControllerTest extends WebSecurityConfigurationAware {
    private Long CONTACT_ID = 3L;
    private Contact contact;

    private static String SEC_CONTEXT_ATTR = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

    @Mock
    BindingResult result;
    
    @Mock
    Model model;
    
    @Mock
    ContactService contactService;
    
    @InjectMocks
    ContactController contactController;
    
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setup() {
        initMocks();
        
        contact = new Contact();
        contact.setName("ShiHang");
        contact.setMobile("18222222222");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("Memo");
    }
    
    protected MockHttpSession userSession() {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        Authentication userAuthentication = 
            new UsernamePasswordAuthenticationToken("user","demo", authorities);
            
        SecurityContext securityContext = org.mockito.Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(userAuthentication);
        
        MockHttpSession userSession = new MockHttpSession();
        userSession.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, 
                securityContext);
                
        return userSession;
    }
    
    protected org.springframework.test.web.servlet.ResultActions userPerform(org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder request)
        throws Exception {
        return mockMvc.perform(request.session(userSession()));
    }
    
    @Test
    public void 当URL为contact_list时应该访问list页面() throws Exception {
        userPerform(get("/contact/list"))
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
        userPerform(get("/contact/show")
                        .param("id", String.valueOf(CONTACT_ID)))
               .andExpect(view().name("contact/show"))
               .andExpect(model().attributeExists("contact"));
    }
    
    @Test
    public void 在ContactController中的show方法调用ContactService中的show方法() {
        contactController.show(String.valueOf(CONTACT_ID), model);
        verify(contactService).show(CONTACT_ID);
    }
    
    @Test
    public void 当URL为contact_create时且用户角色为ROLE_ADMIN时应该访问create页面() throws Exception {
        userPerform(get("/contact/create"))
               .andExpect(view().name("contact/forbidden"));
    }
    
    @Test
    public void 当URLcontact_save时应该重定向到list页面() throws Exception {
        userPerform(post("/contact/save") 
                        .param("name", String.valueOf(contact.getName()))
                        .param("mobile", String.valueOf(contact.getMobile()))
                        .param("vpmn", String.valueOf(contact.getVpmn()))
                        .param("email", String.valueOf(contact.getEmail()))
                        .param("homeAddress", String.valueOf(contact.getHomeAddress()))
                        .param("officeAddress", String.valueOf(contact.getOfficeAddress()))
                        .param("job", String.valueOf(contact.getJob()))
                        .param("jobLevel", String.valueOf(contact.getJobLevel()))
                        .param("memo", String.valueOf(contact.getMemo())))
               .andExpect(redirectedUrl("show?id=8"));
    }
    
    @Test
    public void 在ContactController中的save方法中调ContactService中的save方法() {
        contactController.save(contact, result, model);
        verify(contactService).save(contact);
    }
    
    @Test
    public void 当URL为contact_update时应该访问update页面() throws Exception {
        userPerform(get("/contact/update")
                        .param("id", String.valueOf(CONTACT_ID)))
               .andExpect(view().name("contact/update"))
               .andExpect(model().attributeExists("contact"));
    }
    
    @Test @Ignore
    public void 在ContactController中的update方法中调用了ContactService中的show方法 () {
        contactController.update(String.valueOf(CONTACT_ID), model);
        verify(contactService).show(CONTACT_ID);
    }
    
    @Test @Ignore
    public void 当点击update页面的update时应该重定向到show页面() throws Exception {
        mockMvc.perform(post("/contact/update")
                        .param("id", String.valueOf(CONTACT_ID))
                        .param("name", String.valueOf(contact.getName()))
                        .param("mobile", String.valueOf(contact.getMobile()))
                        .param("vpmn", String.valueOf(contact.getVpmn()))
                        .param("email", String.valueOf(contact.getEmail()))
                        .param("homeAddress", String.valueOf(contact.getHomeAddress()))
                        .param("officeAddress", String.valueOf(contact.getOfficeAddress()))
                        .param("job", String.valueOf(contact.getJob()))
                        .param("jobLevel", String.valueOf(contact.getJobLevel()))
                        .param("memo", String.valueOf(contact.getMemo())))
               .andExpect(redirectedUrl("show?id=" + CONTACT_ID))
               .andExpect(model().attributeExists("id"));
    }
    
    @Test @Ignore
    public void 在ContactController中的update方法中调用了ContactService中的update方法() {
        contactController.update(contact, model);
        verify(contactService).update(contact);
    }
    
    @Test @Ignore
    public void 但点击update页面的delete时应该重定向到list页面() throws Exception {
        mockMvc.perform(post("/contact/delete")
                        .param("id", String.valueOf(CONTACT_ID)))
               .andExpect(redirectedUrl("list"));
    }
    
    @Test @Ignore
    public void 在contactController的delete中调用了contactService中的delete方法() {
        contactController.delete(String.valueOf(CONTACT_ID));
        verify(contactService).delete(CONTACT_ID);
    }
}