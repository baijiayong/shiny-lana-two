package com.baldurtech.contact;

import org.junit.Before;
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
    private Contact contact;
    private Set<ConstraintViolation<Contact>> constraintViolations;
    
    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();      
    }
    
    @Before
    public void createValidContact() {
        contact = new Contact();
        contact.setName("Shihang");
        contact.setMobile("18235100872");
        contact.setVpmn("62222");
        contact.setEmail("a@a.com");
        contact.setHomeAddress("TaiYuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setMemo("memo");
        contact.setJob("HR");
        contact.setJobLevel(9L);
    }
    
    @Test
    public void name_cannot_be_null() {     
        contact.setName(null);
        
        constraintViolations = validator.validate(contact);
        assertEquals( 1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void nameIsBlank() {
        contact = new Contact("    "
                            , "18235100872"
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNull() {
        contact = new Contact("XiaoBai"
                            , null
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsBlank() {
        contact = new Contact("XiaoBai"
                            , "    "
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void MobileIsNotDigits() {
        contact = new Contact("XiaoBai"
                            , "abcdefghijk"
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
                                    
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsTooShot() {
        contact = new Contact("XiaoBai"
                            , "182"
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsTooLong() {
        contact = new Contact("XiaoBai"
                            , "182222222222"
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void mobileIsNotStartWithOne() {
        contact = new Contact("XiaoBai"
                            , "22222222222"
                            , "62222"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid mobile format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , null
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsBlank() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "   "
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsTooShot() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "6"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsTooLong() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "6666666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void vpmnIsNotDigit() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "abcde"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("elements must be digits and must between 4 to 6", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , null
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsBlank() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "    "
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void emailIsNotValidFormat() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "sdfsf"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a valid email format", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void homeAddressIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , null
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void homeAddressIsBlank() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "   "
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void officeAddressIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , null
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void officeAddressIsBlank() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "    "
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , null
                            , 9L);
        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobIsBlank() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "     "
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为空", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void jobLevelIsNull() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , null);

        constraintViolations = validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());
    }
        
    @Test
    public void theContactIsValid() {
        contact = new Contact("XiaoBai"
                            , "18222222222"
                            , "66666"
                            , "a@a.com"
                            , "TaiYuan"
                            , "BeiZhang"
                            , "memo"
                            , "HR"
                            , 9L);

        constraintViolations = validator.validate(contact);
        assertEquals(0, constraintViolations.size());
    }
}

