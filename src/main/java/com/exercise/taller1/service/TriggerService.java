package com.exercise.taller1.service;

import java.util.List;
import com.exercise.taller1.model.Triggerr;

public interface TriggerService {
	
	public Triggerr add(long idAutotran, long idType, long idTrig);

	public Triggerr edit(long idInstitution, String name, String scope);
	
	public Triggerr findById(long id);

	public List<Triggerr> findAll();

	public void save(Triggerr triggerr);

	public void delete(Triggerr triggerr);
}