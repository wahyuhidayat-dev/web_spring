package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Persons;
import com.example.demo.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model)
    {
        var persons = personService.listPerson();
         log.debug("Test123");
        model.addAttribute("persons", persons);
        return "index";

    }
    @GetMapping("/create")
    public String create(Persons persons){
        return "create";
    }

    @PostMapping("/save")
    public String save(Persons persons){
         personService.savePerson(persons);
         return "redirect:/";
    }
}
