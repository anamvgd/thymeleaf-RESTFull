package com.exercise.taller1.service;

import java.math.BigDecimal;
import java.util.Optional;
import com.exercise.taller1.model.Triggertype;

public interface TriggerTypeService {
	public Triggertype add(long idInstitution);

	public Triggertype edit(BigDecimal instInstId, long trigtypeId, String trigtypeName);

	public Optional<Triggertype> findById(long id);

	public Iterable<Triggertype> findAll();

	public Triggertype save(Triggertype triggertype);

	public void delete(Triggertype triggertype);
}