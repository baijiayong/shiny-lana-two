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
    
    public List<Contact> getList() {

        return contactRepository.findAll();
    }
    
    public Contact show(Long id) {
        return getById(id);
    }
    
    public Contact getById(Long id) {
        Contact contact = new Contact();
        contact.setName("shihang");
        contact.setMobile("18235100872");
        contact.setEmail("1335932576@qq.com");
        contact.setVpmn("652994");
        contact.setOfficeAddress("beizhang");
        contact.setHomeAddress("taiyuan");
        contact.setMemo("memo");
        contact.setJob("HR");
        contact.setJobLevel(3L);
        
        return contact;
    }

}