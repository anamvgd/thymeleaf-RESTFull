package com.exercise.taller1.service;

import java.util.List;
import java.util.Optional;

import com.exercise.taller1.model.Autotransition;
public interface AutotransitionService {

	public Autotransition edit(long id, String name, String logicalOperand, String isActive) throws Exception;

	public Autotransition add(long idInstitution, long idEventStatus);
	
	public List<Autotransition> findAll();
	
	public void save(Autotransition autotransition);
	
	public void delete(Autotransition autotransition);
	
	public Autotransition findById(long id);
}