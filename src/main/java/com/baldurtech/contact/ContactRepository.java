package com.baldurtech.contact;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class ContactRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Contact> findAll() {
        try {       
            return entityManager.createNamedQuery(Contact.FIND_ALL, Contact.class).getResultList();
        } catch(PersistenceException pe) {
            return null;
        }
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