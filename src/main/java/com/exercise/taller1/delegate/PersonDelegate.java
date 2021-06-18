package com.exercise.taller1.delegate;

import com.exercise.taller1.model.Person;

public interface PersonDelegate {
	
	public Person savePerson(long idPerson, String namePerson, long idDocument);

	public Person savePerson(Person tt);

	public void delete(Person tt);

	public Person findById(long id);

	public Iterable<Person> findAll();

}
