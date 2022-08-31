package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.personDao;
import com.example.demo.domain.Persons;


@Service

public class PersonServiceImpl implements PersonService{

    @Autowired
    private personDao personDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persons> listPerson() {
        
        return (List<Persons>) personDao.findAll();
    }

    @Override
    @Transactional
    public void savePerson(Persons persons) {
        personDao.save(persons);
        
    }

    @Override
    public void deletePerson(Persons persons) {
        personDao.delete(persons);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Persons findbyID(Persons persons) {
        return personDao.findById(persons.getId()).orElse(null);
    }
    
}
