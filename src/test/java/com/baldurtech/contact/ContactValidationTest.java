package com.baldurtech.contact;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;

import static org.junit.Assert.assertEquals;

public class ContactValidationTest {
    private static Validator validator;
    
    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void nameIsNull() {
        Contact contact = new Contact();
        contact.setName(null);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void nameIsBlank() {
        Contact contact = new Contact();
        contact.setName("   ");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());   
    }
}