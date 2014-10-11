package com.baldurtech.contact;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ContactService {

    public List<Contact> getList() {
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
        
        return list;
    }

}