package com.baldurtech.contact;

import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class ContactControllerTest extends WebAppConfigurationAware {
    @Test
    public void displaysContactList() throws Exception {
        mockMvc.perform(get("/contact/list"))
                .andExpect(view().name("contact/list"))
                .andExpect(model().attributeExists("contactList"))
                .andExpect(content().string(
                        allOf(
                                containsString("<title>contactList</title>"),
                                containsString("<td>shihang</td>"),
                                containsString("<td>15235432994</td>"),
                                containsString("<td>652994</td>"),
                                containsString("<td>shanxi</td>")
                        )));
    }
}
