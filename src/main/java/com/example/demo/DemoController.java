package com.example.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Persons;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoController {

    

    @GetMapping("/")
    public String index(Model model)
    {
        var message = "Data User";

        var person = new Persons();
        person.setFirstname("Wahyu");
        person.setLastname("Hidayat");
        person.setEmail("whyhid47@gmail.com");
        person.setPhone("089654472617");

        var person2 = new Persons();
        person2.setFirstname("Wahyu");
        person2.setLastname("Hidayat");
        person2.setEmail("whyhid47@gmail.com");
        person2.setPhone("089654472617");

        var persons = Arrays.asList(person, person2);

        log.info("Test123");
        log.debug("Test123");
        model.addAttribute("message", message);
        //model.addAttribute("person", person);
        model.addAttribute("persons", persons);
        return "index";

    }
}
