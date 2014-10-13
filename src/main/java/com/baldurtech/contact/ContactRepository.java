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
}