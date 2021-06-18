package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Documentt;


public interface DocumentController {
	
	public Documentt edit(Documentt doc) throws Exception;

	public Documentt add(Documentt doc);
	
	public Iterable<Documentt> findAll();
	
	public void save(Documentt document);
	
	public void delete(long id);
	
	public Documentt findById(long id);
}
