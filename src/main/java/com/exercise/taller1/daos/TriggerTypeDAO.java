package com.exercise.taller1.daos;

import java.util.List;

import com.exercise.taller1.model.Triggertype;

public interface TriggerTypeDAO {
	
	void save(Triggertype entity);
	
	void edit(Triggertype entity);

	void delete(Triggertype entity);
	
	Triggertype findById(long id);

	List<Triggertype> findAll();

}
