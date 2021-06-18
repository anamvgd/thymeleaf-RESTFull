package com.exercise.taller1.RESTController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Person;
import com.exercise.taller1.service.PersonService;

@RestController
public class PersonRestControllerImpl implements PersonController{
	
	@Autowired
	public PersonService personService;

	@Override
	@PostMapping("/api/persons/adds")
	public Person add(@RequestBody Person per) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/api/persons")
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return personService.findAll();
	}

	@Override
	@PostMapping("/api/persons")
	public void save(@RequestBody Person per) {
		personService.savePerson(per);
		
	}

	@Override
	@DeleteMapping("/api/persons/{id}")
	public void delete(long id) {
		personService.delete(personService.findById(id));
		
	}

	@Override
	@GetMapping("/api/persons/{id}")
	public Person findById(long id) {
		// TODO Auto-generated method stub
		return personService.findById(id);
	}
}
