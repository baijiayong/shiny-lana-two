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
        
        model.addAttribute("list", list);
        return "contact/list";
    }
}