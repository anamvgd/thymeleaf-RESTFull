package com.exercise.taller1.RESTController;

import java.util.List;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;

public interface AutotransitionController {
	
	public Autotransition edit(Autotransition auto) throws Exception;

	public Autotransition add(Autotransition auto);
	
	public List<Autotransition> findAll();
	
	public void save(Autotransition autotransition);
	
	public void delete(long id);
	
	public Autotransition findById(long id);
	
	public Iterable<FevInstitution> findAllFev();

	public void addFev(FevInstitution fevInstitution);
	
	public FevInstitution findByIdFev(long id);
	
}
