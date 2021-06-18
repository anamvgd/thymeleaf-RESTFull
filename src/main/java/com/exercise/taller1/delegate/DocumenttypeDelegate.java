package com.exercise.taller1.delegate;

import java.math.BigDecimal;

import com.exercise.taller1.model.Documenttype;

public interface DocumenttypeDelegate {
	
	public Documenttype saveDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId);

	public void saveDocumenttype(Documenttype tt);
	
	public Documenttype editDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId);

	public void delete(Documenttype tt);

	public Documenttype findById(long id);

	public Iterable<Documenttype> findAll();

}
