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
    private static Contact contact;
    private static Set<ConstraintViolation<Contact>> constraintViolations;
    
    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        contact = new Contact();       
    }
    
    @Test
    public void nameIsNull() {
        contact.setName(null);
        
        constraintViolations = validator.validate(contact);
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void nameIsBlank() {
        contact.setName("   ");
        
        constraintViolations = validator.validate(contact);
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());   
    }
    
}