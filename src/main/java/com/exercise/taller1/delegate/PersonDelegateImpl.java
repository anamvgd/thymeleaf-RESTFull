package com.exercise.taller1.delegate;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Person;

@Component
public class PersonDelegateImpl implements PersonDelegate{
	
	private RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";
	
	public PersonDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}


	@Override
	public Person savePerson(long idPerson, String namePerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person savePerson(Person person) {
		Person per = restTemplate.postForObject( SERVER + "api/persons", person, Person.class);
		return per;
	}

	@Override
	public void delete(Person person) {
		restTemplate.delete(SERVER + "api/persons/"+ person.getPersId());
		
	}

	@Override
	public Person findById(long id) {
		Person per = restTemplate.getForObject(SERVER+"api/persons/"+id, Person.class); 
		return per;
	}

	@Override
	public Iterable<Person> findAll() {
		Person[] pers = restTemplate.getForObject(SERVER+"api/persons",Person[].class );
		Iterable<Person> persons = Arrays.asList(pers);
		
		return persons;
	}

}
