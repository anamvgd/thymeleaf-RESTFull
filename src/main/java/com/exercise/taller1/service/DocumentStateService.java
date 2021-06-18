package com.exercise.taller1.service;

import com.exercise.taller1.model.Documentstate;

public interface DocumentStateService {
	
	public Iterable<Documentstate> findAll();

	public void add(Documentstate docstate);
	
	public Documentstate findById(long id);


}
