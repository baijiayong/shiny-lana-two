package com.baldurtech.contact;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;

import static org.junit.Assert.assertEquals;

public class ContactValidationTest {
    private static Validator validator;
    public Contact contact;
    private Set<ConstraintViolation<Contact>> constraintViolations;
    
    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Before
    public void createValidContact() {
        contact = new Contact();
        
        contact.setName("Xiao Bai");
        contact.setMobile("18222222222");
        contact.setVpmn("6222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(6L);
        contact.setMemo("memo");
    } 
    
    public void assertConstraintViolations(String errorMessage) {
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals(errorMessage, constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void name_cannot_be_null() {
        contact.setName(null);
        assertConstraintViolations("不能为空");
    }
    
    
    @Test
    public void name_cannot_be_Blank() {
        contact.setName("       ");
        assertConstraintViolations("不能为空");
    }
    
    @Test
    public void mobile_cannot_be_null() {
        contact.setMobile(null);
        assertConstraintViolations("不能为null");
    }
    
    @Test
    public void mobile_cannot_be_blank() {
        contact.setMobile("   ");
        assertConstraintViolations("not a valid mobile format!");
    }
    
    @Test
    public void mobile_cannot_be_too_short() {
        contact.setMobile("122");
        assertConstraintViolations("not a valid mobile format!");
    }
    
    @Test
    public void mobile_cannot_be_too_long() {
        contact.setMobile("122333333443");
        assertConstraintViolations("not a valid mobile format!");
    }
    
    @Test
    public void mobile_can_be_start_with_one() {
        contact.setMobile("22225554422");
        assertConstraintViolations("not a valid mobile format!");
    }
    
    @Test
    public void mobile_can_be_digits() {
        contact.setMobile("abcdefghijk");
        assertConstraintViolations("not a valid mobile format!");
    }
    
    @Test
    public void vpmn_cannot_be_null() {
        contact.setVpmn(null);
        assertConstraintViolations("不能为null");
    }
    
    @Test
    public void vpmn_cannot_be_blank() {
        contact.setVpmn("  ");
        assertConstraintViolations("vpmn must be between 4 to 6!");
    }
    
    @Test
    public void vpmn_cannot_be_too_long() {
        contact.setVpmn("1234564");
        assertConstraintViolations("vpmn must be between 4 to 6!");
    }
}