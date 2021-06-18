package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Triggerr;

public interface TriggerController {
	
	public Triggerr edit(Triggerr auto) throws Exception;

	public Triggerr add(Triggerr auto);
	
	public List<Triggerr> findAll();
	
	public void save(Triggerr autotransition);
	
	public void delete(long id);
	
	public Triggerr findById(long id);

}
