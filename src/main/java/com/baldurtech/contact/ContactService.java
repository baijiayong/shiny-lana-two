package com.baldurtech.contact;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class ContactService {
    ContactRepository contactRepository;
    
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> list() {
        return contactRepository.findAll();
    }
    
    public Contact show(Long id) {
        return getById(id);
    }
    public Contact getById(Long id) {
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
        
        return contact;
    }
}