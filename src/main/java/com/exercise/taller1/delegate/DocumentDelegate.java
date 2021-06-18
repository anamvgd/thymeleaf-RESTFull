package com.exercise.taller1.delegate;

import java.util.Optional;

import com.exercise.taller1.model.Documentt;

public interface DocumentDelegate {
	
	public Documentt saveDocumentt(long idDocumentt, String nameDocumentt, long idDoctype, long personId);

	public void saveDocumentt(Documentt tt);
	
	public Documentt editDocumentt(long idDocumentt, String newNameDocumentt, long idDoctype, long personId);

	public void delete(Documentt tt);

	public Documentt findById(long id);

	public Iterable<Documentt> findAll();

}
