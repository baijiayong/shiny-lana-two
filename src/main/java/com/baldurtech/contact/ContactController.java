package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("contact")
public class ContactController {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contactList", findAll());
        return "contact/list";
    }
    
    public List<Contact> findAll() {
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact1 = new Contact();
        contact1.setName("Shi Hang");
        contact1.setMobile("18233333333");
        contact1.setVpmn("6333");
        contact1.setHomeAddress("TaiYuan");
        
        Contact contact2 = new Contact();
        contact2.setName("Xiao Bai");
        contact2.setMobile("18233333333");
        contact2.setVpmn("6333");
        contact2.setHomeAddress("TaiYuan");
        
        contactList.add(contact1);
        contactList.add(contact2);
        
        return contactList;
    }    
}