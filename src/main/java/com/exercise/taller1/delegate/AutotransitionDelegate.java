package com.exercise.taller1.delegate;

import java.util.List;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;

public interface AutotransitionDelegate {
	
	public Autotransition edit(long id, String name, String logicalOperand, String isActive) throws Exception;

	public Autotransition add(long idInstitution, long idEventStatus);
	
	public List<Autotransition> findAll();
	
	public void save(Autotransition autotransition);
	
	public void delete(Autotransition autotransition);
	
	public Autotransition findById(long id);
	
	public Iterable<FevInstitution> findAllFev();

	public void add(FevInstitution fevInstitution);
	
	public FevInstitution findByIdFev(long id);

}
