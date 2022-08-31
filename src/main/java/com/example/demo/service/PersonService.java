package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Persons;

public interface PersonService {

    public List<Persons> listPerson();
    
    public void savePerson(Persons persons);

    public void deletePerson(Persons persons);

    public Persons findbyID(Persons persons);
}
