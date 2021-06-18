package com.exercise.taller1.RESTController;

import com.exercise.taller1.model.Person;

public interface PersonController {

	public Person add(Person per);
	
	public Iterable<Person> findAll();
	
	public void save(Person per);
	
	public void delete(long id);
	
	public Person findById(long id);

}
