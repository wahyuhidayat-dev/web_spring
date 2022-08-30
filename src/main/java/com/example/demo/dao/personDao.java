package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Persons;

public interface personDao extends CrudRepository<Persons, Long>{
}
