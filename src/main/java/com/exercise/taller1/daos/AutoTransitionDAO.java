package com.exercise.taller1.daos;

import java.util.List;

import com.exercise.taller1.model.Autotransition;

public interface AutoTransitionDAO {
	
	void save(Autotransition entity);
	
	void edit(Autotransition entity);

	void delete(Autotransition entity);

	Autotransition findById(long id);
	
	List<Autotransition>  findAll();

	List<Autotransition> findByName(String n);

	List<Autotransition> findByActive(String act);

}
