package com.baldurtech.contact;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class ContactControllerTest extends WebAppConfigurationAware {
    @Test
    public void displaysContactList() throws Exception {
        mockMvc.perform(get("/contact/list"))
                .andExpect(view().name("contact/list"))
                .andExpect(model().attributeExists("contactList"));
    }
}
