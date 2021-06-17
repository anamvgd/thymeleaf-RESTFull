package com.exercise.taller1.daos;

import java.util.List;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

public interface UserSelectDAO {
	
	void save(Userselect entity);
	
	void edit(Userselect entity);

	void delete(Userselect entity);

	Triggerr findByIdTrigger(long id);
	
	Userselect findById(long id);

	List<Userselect> findByName(String name);

	List<Userselect> findByValuekeycolumn(String usselValuekeycolumn);

	List<Userselect> findAll();
}

