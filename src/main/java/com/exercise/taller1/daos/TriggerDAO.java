package com.exercise.taller1.daos;

import java.util.List;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;

public interface TriggerDAO {
	
	void save(Triggerr entity);
	
	void edit(Triggerr entity);

	void delete(Triggerr entity);

	List<Triggerr> findByScope(String s);

	List<Triggerr> findByName(String n);
	
	Triggerr findById(long id);

	List<Triggerr> findByTriggerType(Triggertype trtype);

	List<Triggerr> findAll();
	
	List<Triggertype> findTriggerrByScope();
	
	List<Triggertype> findTriggerrByUserselect();

}
