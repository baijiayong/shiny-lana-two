package com.baldurtech.contact;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

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
        contact.setMobile("18235100872");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals( 1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void nameIsBlank() {
        Contact contact = new Contact();
        contact.setName("     ");
        contact.setMobile("18235100872");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNull() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile(null);
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsBlank() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("    ");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNotDigits() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("abcdefghijk");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsTooShot() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("1822222222");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsNotStartWithOne() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("28222222222");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsNull() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("18222222222");
        contact.setVpmn(null);
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsBlank() {
        Contact contact = new Contact();
        contact.setName("XiaoBai");
        contact.setMobile("18222222222");
        contact.setVpmn("    ");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        contact.setMemo("memo");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
}

