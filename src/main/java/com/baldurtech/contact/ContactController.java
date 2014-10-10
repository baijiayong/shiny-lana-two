package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/contact")
public class ContactController {
        
    @RequestMapping(value = "/list", method = RequestMethod.GET)    
    public String contactList(Model model) {
        model.addAttribute("contactList", "ContactList");
        return "contact/list";
    }
}