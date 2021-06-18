package com.exercise.taller1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.DocumentDao;
import com.exercise.taller1.daos.PersonDao;
import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDao personRepo;
	private DocumentDao docuRepo;

	@Autowired
	public PersonServiceImpl(PersonDao personRepo, DocumentDao docuRepo) {
		this.personRepo = personRepo;
		this.docuRepo = docuRepo;
	}

	@Override
	public Person savePerson(long idPerson, String namePerson, long idDocument) throws RuntimeException {
		if (namePerson.equalsIgnoreCase("") || namePerson == null) {
			throw new RuntimeException("No namePerson - savePerson()");
		}

		Documentt docu;

		if (docuRepo.findById(idDocument) == null) {
			throw new RuntimeException("No docutype - saveDocumentt()");
		} else {
			docu = docuRepo.findById(idDocument);
		}

		Person person = new Person();
		// newDocu.setDocId(idDocumentt);
		person.setPersName(namePerson);
		person.addDocumentt(docu);

		personRepo.save(person);

		return person;
	}

	@Override
	public Person savePerson(Person tt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person tt) {
		personRepo.deleteAll();

	}

	@Override
	public Person findById(long id) {
		// TODO Auto-generated method stub
		return personRepo.findById(id);
	}

	@Override
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepo.findAll();
	}


}
