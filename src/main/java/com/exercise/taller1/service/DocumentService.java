package com.exercise.taller1.service;

import java.util.Optional;

import com.exercise.taller1.model.Documentt;


public interface DocumentService {
	
	public Documentt saveDocumentt(long idDocumentt, String nameDocumentt, long idDoctype, long personId);

	public Documentt saveDocumentt(Documentt tt);
	
	public Documentt editDocumentt(long idDocumentt, String newNameDocumentt, long idDoctype, long personId);
	
	public Documentt getDocumentt(long idDocumentt);

	public void delete(Documentt tt);

	public Documentt findById(long id);

	public Iterable<Documentt> findAll();
	

}
