package com.baldurtech.contact;

import org.junit.Test;
import com.baldurtech.config.WebAppConfigurationAware;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ContactControllerTest extends WebAppConfigurationAware {
    @Test
    public void 当URI为contact_list时应该由ContactController处理() throws Exception {
        mockMvc.perform(get("/contact/list"))
               .andExpect(view().name("contact/list"));

    }

}