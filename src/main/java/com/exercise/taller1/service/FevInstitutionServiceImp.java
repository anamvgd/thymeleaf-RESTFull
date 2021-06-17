package com.exercise.taller1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.repository.FevInstitutionRepository;

@Service
public class FevInstitutionServiceImp implements FevInstitutionService {
	private FevInstitutionRepository fevInstitutionRepository;
	
	@Autowired
	public FevInstitutionServiceImp(FevInstitutionRepository fevInstitutionRepository) {
		this.fevInstitutionRepository = fevInstitutionRepository;
	}
	
	@Override
	public Iterable<FevInstitution> findAll() {
		return fevInstitutionRepository.findAll();
	}
	
	@Override
	public void add(FevInstitution fevInstitution) {
		fevInstitutionRepository.save(fevInstitution);
	}
	
	@Override
	public FevInstitution findById(long id) {
		return fevInstitutionRepository.findById(id).get();
	}
	
}