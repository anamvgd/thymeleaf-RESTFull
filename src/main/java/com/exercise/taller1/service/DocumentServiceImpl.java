package com.exercise.taller1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.DocumentDao;
import com.exercise.taller1.daos.DocumentTypeDao;
import com.exercise.taller1.daos.PersonDao;
import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.model.Documenttype;
import com.exercise.taller1.model.Person;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentDao docuRepo;
	private PersonDao personRepo;
	private DocumentTypeDao docutypeRepo;
	
	@Autowired
	public DocumentServiceImpl(DocumentDao docuRepo, PersonDao personRepo, DocumentTypeDao docutypeRepo) {
		this.docuRepo = docuRepo;
		this.personRepo = personRepo;
		this.docutypeRepo = docutypeRepo;
	}

	@Override
	public Documentt saveDocumentt(long idDocumentt, String nameDocumentt, long idDoctype, long personId)
			throws RuntimeException {

		if (nameDocumentt.equalsIgnoreCase("") || nameDocumentt == null) {
			throw new RuntimeException("No nameDocumentt - saveDocumentt()");
		}

		Person person;
		Documenttype docType;

		if (personRepo.findById(personId) == null) {
			throw new RuntimeException("No person - saveDocumentt()");
		} else {
			person = personRepo.findById(personId);
		}

		if (docutypeRepo.findById(idDoctype)== null) {
			throw new RuntimeException("No docutype - saveDocumentt()");
		} else {
			docType = docutypeRepo.findById(idDoctype);
		}

		Documentt newDocu = new Documentt();
		// newDocu.setDocId(idDocumentt);
		newDocu.setDocName(nameDocumentt);
		newDocu.setPerson(person);
		newDocu.setDocumenttype(docType);

		docuRepo.save(newDocu);

		return newDocu;
	}

	@Override
	public Documentt saveDocumentt(Documentt tt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documentt editDocumentt(long idDocumentt, String newNameDocumentt, long idDoctype, long personId)
			throws RuntimeException {
		
		Documentt modifiedDoc;
		
		if (docuRepo.findById(idDocumentt) == null) {
			throw new RuntimeException("No document - editDocumentt()");
		}else {
			modifiedDoc = docuRepo.findById(idDocumentt);
		}
		
		if (newNameDocumentt.equalsIgnoreCase("") || newNameDocumentt == null) {
			throw new RuntimeException("No nameDocumentt - editDocumentt()");
		}

		Person person;
		Documenttype docType;

		if (personRepo.findById(personId) == null) {
			throw new RuntimeException("No person - editDocumentt()");
		} else {
			person = personRepo.findById(personId);
		}

		if (docutypeRepo.findById(idDoctype) == null) {
			throw new RuntimeException("No docutype - editDocumentt()");
		} else {
			docType = docutypeRepo.findById(idDoctype);
		}

		// newDocu.setDocId(idDocumentt);
		modifiedDoc.setDocName(newNameDocumentt);
		modifiedDoc.setPerson(person);
		modifiedDoc.setDocumenttype(docType);

		docuRepo.save(modifiedDoc);

		return modifiedDoc;
	}

	@Override
	public Documentt getDocumentt(long idDocumentt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Documentt tt) {
		docuRepo.deleteAll();

	}

	@Override
	public Documentt findById(long id) {
		// TODO Auto-generated method stub
		return docuRepo.findById(id);
	}

	@Override
	public Iterable<Documentt> findAll() {
		// TODO Auto-generated method stub
		return docuRepo.findAll();
	}

}
