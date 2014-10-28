package com.baldurtech.contact;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;

@Table(name = "contact")
@NamedQueries({
    @NamedQuery(name = Contact.FIND_ALL, query = "from Contact"),
    @NamedQuery(name = Contact.GET_BY_ID, query = "SELECT c FROM Contact c WHERE c.id = :id")
})
@Entity
public class Contact implements java.io.Serializable {
    public static final String FIND_ALL = "Contact.findAll";
    public static final String GET_BY_ID = "Contact.getById";
    
    @Id
	@GeneratedValue
	private Long id;

    @NotBlank
    private String name;
    
    @NotNull
    @Pattern(regexp="\\b1\\d{10}", message="not a valid mobile format")
    private String mobile;
    
    @NotNull
    @Pattern(regexp="\\d{4,6}", message="elements must be digits and must between 4 to 6")
    private String vpmn;
    
    @NotBlank
    @Email(message = "not a valid email format")
    private String email;
    
    @NotNull
    @NotBlank
    private String homeAddress;

    @NotNull
    @NotBlank
    private String officeAddress;

    private String memo;
    
    @NotNull
    @NotBlank
    private String job;
    
    @NotNull
    private Long jobLevel;

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return this.id;
    }
     
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public String getMobile()
    {
        return this.mobile;
    }

    public void setVpmn(String vpmn)
    {
        this.vpmn = vpmn;
    }
    public String getVpmn()
    {
        return this.vpmn;
    }
     
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
          
    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }
    public String getHomeAddress()
    {
        return this.homeAddress;
    }
    public void setOfficeAddress(String officeAddress)
    {
        this.officeAddress = officeAddress;
    }
    public String getOfficeAddress()
    {
        return this.officeAddress;
    }
    public void setMemo(String memo)
    {
        this.memo = memo;
    }
    public String getMemo()
    {
        return this.memo;
    }
    public void setJob(String job)
    {
        this.job = job;
    }
    public String getJob()
    {
        return this.job;
    }
    public void setJobLevel(Long jobLevel)
    {
        this.jobLevel = jobLevel;
    }
    public Long getJobLevel()
    {
        return this.jobLevel;
    }
}

