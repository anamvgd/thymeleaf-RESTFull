package com.exercise.taller1.daos;

import java.util.List;
import java.util.Optional;

import com.exercise.taller1.model.Person;


public interface PersonDao {
	
	Person save(Person entity);
    Person edit(Person entity);
    void delete(Person entity);
    Person findById(long PersonId);
    List<Person> findAll();
    
    void deleteAll();

}
