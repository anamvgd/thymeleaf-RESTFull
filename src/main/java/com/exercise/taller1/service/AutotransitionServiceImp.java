package com.exercise.taller1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.AutoTransitionDAO;
import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.Eventstatus;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.repository.AutotransitionRepository;
import com.exercise.taller1.repository.FevEventstatusRepository;
import com.exercise.taller1.repository.FevInstitutionRepository;

@Service
public class AutotransitionServiceImp implements AutotransitionService {

	
	private AutoTransitionDAO autotransitionDao;
	private AutotransitionRepository autotransitionRepository;
	public FevInstitutionRepository fevInstitutionRepository;
	public FevEventstatusRepository fevEventstatusRepository;

	@Autowired
	public AutotransitionServiceImp(AutotransitionRepository autotransitionRepository,
			FevInstitutionRepository fevInstitutionRepository, FevEventstatusRepository fevEventstatusRepository, AutoTransitionDAO autotransitionDao) {
		this.autotransitionDao = autotransitionDao;
		this.autotransitionRepository = autotransitionRepository;
		this.fevEventstatusRepository = fevEventstatusRepository;
		this.fevInstitutionRepository = fevInstitutionRepository;
	}

	@Override
	public Autotransition add(long idInstitution, long idEventStatus) {
		FevInstitution institution = fevInstitutionRepository.findById(idInstitution).get();
		Eventstatus eventstatus = fevEventstatusRepository.findById(idEventStatus).get();

		Autotransition autotransitionDummy = new Autotransition();
		autotransitionDummy.setAutotranName("Mili");
		autotransitionDummy.setAutotranIsactive("Y");
		autotransitionDummy.setAutotranLogicaloperand("AND");
		autotransitionDummy.setEventstatus1(eventstatus);
		

		// Agregar elemento a DB
		autotransitionDao.save(autotransitionDummy);
		return autotransitionDummy;
	}

	@Override
	public Autotransition edit(long id, String name, String logicalOperand, String isActive) throws Exception {
		Autotransition autotransitionDummy = new Autotransition();
		if (name == " " || name == "" || name.equalsIgnoreCase(" ") || name.equalsIgnoreCase("")) {
			throw new Exception("El nombre no debe ser nulo");
		} else {
			Autotransition at = findById(id);
			at.setAutotranName(name);
			at.setAutotranIsactive(isActive);
			at.setAutotranLogicaloperand(logicalOperand);
			autotransitionDao.edit(at);
		}

		return autotransitionDummy;
	}

	@Override
	public List<Autotransition> findAll() {
		return autotransitionDao.findAll();
	}

	@Override
	public void save(Autotransition autotransition) {
		 autotransitionDao.save(autotransition);
	}

	@Override
	public Autotransition findById(long id) {
		return autotransitionDao.findById(id);
	}

	@Override
	public void delete(Autotransition autotransition) {
		autotransitionDao.delete(autotransition);
	}
}