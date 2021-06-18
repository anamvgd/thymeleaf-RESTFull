package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Documenttype;

public interface DocumenttypeController {
	
	public Documenttype edit(Documenttype doc) throws Exception;

	//public Documenttype add(Documenttype doc);
	
	public List<Documenttype> findAll();
	
	public void save(Documenttype document);
	
	public void delete(long id);
	
	public Documenttype findById(long id);

}
