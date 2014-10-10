package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)    
    public String contactList(Model model) {
        model.addAttribute("contactList", getContactList());
        return "contact/list";
    }
    
    public List<Contact> getContactList() {
        List<Contact> contactList = new ArrayList<Contact>();
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
         
        contactList.add(contact);
        contactList.add(contact2);
        
        return contactList;
    }
}