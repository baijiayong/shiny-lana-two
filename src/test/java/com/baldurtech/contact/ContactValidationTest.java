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
        Contact contact = new Contact(null
                                    , "18235100872"
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals( 1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void nameIsBlank() {
        Contact contact = new Contact("    "
                                    , "18235100872"
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNull() {
        Contact contact = new Contact("XiaoBai"
                                    , null
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsBlank() {
        Contact contact = new Contact("XiaoBai"
                                    , "    "
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNotDigits() {
       Contact contact = new Contact("XiaoBai"
                                    , "abcdefghijk"
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
                                    
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsTooShot() {
       Contact contact = new Contact("XiaoBai"
                                    , "182"
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsNotStartWithOne() {
        Contact contact = new Contact("XiaoBai"
                                    , "22222222222"
                                    , "62222"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsNull() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , null
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsBlank() {
       Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "   "
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsTooShot() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "6"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsTooLong() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "6666666"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsNotDigit() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "abcde"
                                    , "a@a.com"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsNull() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "66666"
                                    , null
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsBlank() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "66666"
                                    , "    "
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsNotValidFormat() {
        Contact contact = new Contact("XiaoBai"
                                    , "18222222222"
                                    , "66666"
                                    , "sdfsf"
                                    , "TaiYuan"
                                    , "BeiZhang"
                                    , "memo"
                                    , "HR"
                                    , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void homeAddressIsNull() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , null
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void homeAddressIsBlank() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "   "
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void officeAddressIsNull() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , null
                            , "memo"
                            , "HR"
                            , 9L);

        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void officeAddressIsBlank() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "    "
                            , "memo"
                            , "HR"
                            , 9L);

        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobIsNull() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , null
                            , 9L);
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobIsBlank() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "     "
                            , 9L);

        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobLevelIsNull() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , null);

        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void theContactIsValid() {
        Contact contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);

        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);
        assertEquals(0, constraintViolations.size());
    }
}

