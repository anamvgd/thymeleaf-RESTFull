package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Triggertype;

public interface TriggertypeController {
	
	public Triggertype edit(Triggertype auto) throws Exception;

	public Triggertype add(Triggertype auto);
	
	public List<Triggertype> findAll();
	
	public void save(Triggertype autotransition);
	
	public void delete(long id);
	
	public Triggertype findById(long id);

}
