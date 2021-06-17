package com.exercise.taller1.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.model.Triggertype;
import com.exercise.taller1.repository.FevInstitutionRepository;
import com.exercise.taller1.repository.TriggertypeRepository;

@Service
public class TriggerTypeServiceImp implements TriggerTypeService {
	
	public FevInstitutionRepository fevInstitutionRepository;
	public TriggertypeRepository triggertypeRepository;

	@Autowired
	public TriggerTypeServiceImp(FevInstitutionRepository fevInstitutionRepository, TriggertypeRepository triggertypeRepository) {
		this.fevInstitutionRepository = fevInstitutionRepository;
		this.triggertypeRepository = triggertypeRepository;
	}
	
	@Override
	public Triggertype add(long idInstitution) {
		FevInstitution institution = fevInstitutionRepository.findById(idInstitution).get();
		Triggertype triggerDummy = new Triggertype();
		BigDecimal x = new BigDecimal(institution.getInstId());
		triggerDummy.setInstInstId(x);
		triggerDummy.setTrigtypeId(idInstitution);
		triggerDummy.setTrigtypeName("Venetar");
		triggertypeRepository.save(triggerDummy);
		
		return triggerDummy;
	}

	@Override
	public Triggertype edit(BigDecimal instInstId, long trigtypeId, String trigtypeName) {
		Triggertype triggerDummy = new Triggertype();
		triggerDummy.setInstInstId(instInstId);
		triggerDummy.setTrigtypeId(trigtypeId);
		triggerDummy.setTrigtypeName(trigtypeName);
		triggertypeRepository.save(triggerDummy);
		
		return triggerDummy;
	}

	@Override
	public Optional<Triggertype> findById(long id) {
		 return triggertypeRepository.findById(id);
	}

	@Override
	public Iterable<Triggertype> findAll() {
		 return triggertypeRepository.findAll();
	}

	@Override
	public Triggertype save(Triggertype triggertype) {
		 return triggertypeRepository.save(triggertype);
	}

	@Override
	public void delete(Triggertype triggertype) {
		triggertypeRepository.delete(triggertype);
	}
}