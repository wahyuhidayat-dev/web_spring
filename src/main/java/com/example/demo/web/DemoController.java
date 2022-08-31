package com.example.demo.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String save(@Valid Persons persons, Errors errors){

        if(errors.hasErrors()){
            return "create";
        }
         personService.savePerson(persons);
         return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Persons persons, Model model){
        persons = personService.findbyID(persons);
        model.addAttribute("persons", persons);
        return "create";
    }
    @GetMapping("/delete")
    public String delete(Persons persons){
        personService.deletePerson(persons);
        return "redirect:/";
    }
}
