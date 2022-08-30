package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.dao.personDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    private personDao personDao;

    @GetMapping("/")
    public String index(Model model)
    {
        var persons = personDao.findAll();
         log.debug("Test123");
        model.addAttribute("persons", persons);
        return "index";

    }
}
