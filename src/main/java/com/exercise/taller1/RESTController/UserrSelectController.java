package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Userselect;

public interface UserrSelectController {
	
	public Userselect edit(Userselect auto) throws Exception;

	public Userselect add(Userselect auto);
	
	public List<Userselect> findAll();
	
	public void save(Userselect autotransition);
	
	public void delete(long id);
	
	public Userselect findById(long id);

}
