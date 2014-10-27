package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("contact")
public class ContactController {
    ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contactList", contactService.findAll());
        return "contact/list";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET) 
    public String create(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/create";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
        if(result.hasErrors()) {
            return "contact/create";
        }
        
        if(contact != null) {
            contactService.save(contact);
        }
        return "redirect:list";
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam(value="id", required=true) String id, Model model) {
        model.addAttribute("contact", contactService.show(Long.valueOf(id)));
        return "contact/show";
        
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("contact") Contact contact) {
        contactService.update(contact);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") String id) {       
        contactService.delete(Long.valueOf(id));
        return "redirect:list";
    }
}