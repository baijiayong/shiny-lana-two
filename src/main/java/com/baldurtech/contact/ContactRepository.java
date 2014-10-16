package com.baldurtech.contact;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Repository
@Transactional
public class ContactRepository {
    @PersistenceContext
    EntityManager entityManager;
    
    public List<Contact> findAll() {
        try {
            return entityManager.createNamedQuery(Contact.FIND_ALL, Contact.class)
                .getResultList();
        } catch (PersistenceException e) {
			return null;
		}
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