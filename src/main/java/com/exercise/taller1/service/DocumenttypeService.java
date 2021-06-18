package com.exercise.taller1.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.exercise.taller1.model.Documenttype;

public interface DocumenttypeService {
	
	public Documenttype saveDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId);

	public Documenttype saveDocumenttype(Documenttype tt);
	
	public Documenttype editDocumenttype(long idDocumenttype, String newNameDocumenttype, BigDecimal instId);
	
	public Documenttype getDocumenttype(long idDocumenttype);

	public void delete(Documenttype tt);

	public Documenttype findById(long id);

	public List<Documenttype> findAll();
	

}
