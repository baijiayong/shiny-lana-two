package com.baldurtech.contact;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ContactService {
    public List<Contact> list() {
        return findAll();
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