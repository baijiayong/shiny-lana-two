package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("contact")
public class ContactController {
    ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contactList", contactService.list());
        return "contact/list";
    }
    
    @RequestMapping(value="/show", method = RequestMethod.GET)
    public String show(@RequestParam(value = "id", required = true) String id, Model model) {
        Contact contact = new Contact();
        contact.setName("ShiHang");
        contact.setMobile("15235432994");
        contact.setEmail("ShiHang@qq.com");
        contact.setVpmn("4333");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("TaiYuan");
        contact.setJob("HR");
        contact.setJobLevel(333L);
        contact.setMemo("memo");
        
        model.addAttribute("contact", contact);
        return "contact/show";
    }
}