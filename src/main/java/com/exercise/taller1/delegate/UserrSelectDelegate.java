package com.exercise.taller1.delegate;

import java.util.List;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

public interface UserrSelectDelegate {
	
public Userselect add(long idUsr, long idTrig);
	
	public Userselect edit(long id, String tableName, String valuekey, String valueUser, String statem);
	
	public List<Userselect> findAll();
	
	public void save(Userselect userselect);
	
	public void delete(Userselect userselect);
	
	public Userselect findById(long id);

}
