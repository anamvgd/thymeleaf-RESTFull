package com.exercise.taller1.service;

import com.exercise.taller1.model.FevInstitution;

public interface FevInstitutionService {

	public Iterable<FevInstitution> findAll();

	public void add(FevInstitution fevInstitution);
	
	public FevInstitution findById(long id);
}