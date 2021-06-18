package com.exercise.taller1.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.DocumentTypeDao;
import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.model.Documenttype;
import com.exercise.taller1.model.Person;

@Service
public class DocumenttypeServiceImpl implements DocumenttypeService {

	private DocumentTypeDao docuRepo;

	@Autowired
	public DocumenttypeServiceImpl(DocumentTypeDao docutypeRepo) {
		this.docuRepo = docutypeRepo;

	}

	@Override
	public Documenttype saveDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId)
			throws RuntimeException {
		if (nameDocumenttype.equalsIgnoreCase("") || nameDocumenttype == null) {
			throw new RuntimeException("No nameDocumenttype - saveDocumenttype()");
		}

		Documenttype newDocutype = new Documenttype();
		newDocutype.setDoctypeId(idDocumenttype);
		newDocutype.setDoctypeName(nameDocumenttype);
		newDocutype.setInstInstId(instId);

		docuRepo.save(newDocutype);

		return newDocutype;
	}

	@Override
	public Documenttype saveDocumenttype(Documenttype tt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documenttype editDocumenttype(long idDocumenttype, String newNameDocumenttype, BigDecimal instId)
			throws RuntimeException {
		
		Documenttype modifiedDoctype;
		
		if (docuRepo.findById(idDocumenttype) == null) {
			throw new RuntimeException("No document - editDocumentt()");
		}else {
			modifiedDoctype = docuRepo.findById(idDocumenttype);
		}
		
		
		if (newNameDocumenttype.equalsIgnoreCase("") || newNameDocumenttype == null) {
			throw new RuntimeException("No nameDocumenttype - saveDocumenttype()");
		}

	
		modifiedDoctype.setDoctypeName(newNameDocumenttype);
		modifiedDoctype.setInstInstId(instId);

		docuRepo.save(modifiedDoctype);

		return modifiedDoctype;
	}

	@Override
	public Documenttype getDocumenttype(long idDocumenttype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Documenttype tt) {
		docuRepo.deleteAll();

	}

	@Override
	public Documenttype findById(long id) {
		// TODO Auto-generated method stub
		return docuRepo.findById(id);
	}

	@Override
	public List<Documenttype> findAll() {
		// TODO Auto-generated method stub
		return docuRepo.findAll();
	}

}
