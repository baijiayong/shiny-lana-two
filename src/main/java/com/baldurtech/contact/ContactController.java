package com.baldurtech.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("contact")
public class ContactController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Contact> list = new ArrayList<Contact>();
        model.addAttribute("list", list);
        return "contact/list";
    }
}