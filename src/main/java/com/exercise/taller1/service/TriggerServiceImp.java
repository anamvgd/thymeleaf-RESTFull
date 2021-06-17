package com.exercise.taller1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.TriggerDAO;
import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;
import com.exercise.taller1.repository.AutotransitionRepository;
import com.exercise.taller1.repository.TriggertypeRepository;

@Service
public class TriggerServiceImp implements TriggerService {

	public TriggerDAO triggerDao;
	public AutotransitionRepository autoRepo;
	public TriggertypeRepository triggertypeRepository;
	

	@Autowired
	public TriggerServiceImp(AutotransitionRepository autoRepo, TriggertypeRepository triggertypeRepository,
			TriggerDAO triggerDao) {
		this.autoRepo = autoRepo;
		this.triggertypeRepository = triggertypeRepository;
		this.triggerDao = triggerDao;
	}

	@Override
	public Triggerr add(long idAutotran, long idType, long idTrig) {
		Autotransition autotran = autoRepo.findById(idAutotran).get();
		Optional<Triggertype> trigType = triggertypeRepository.findById(idType);
		Triggerr triggerDummy = new Triggerr();
		triggerDummy.setTrigId(idTrig);
		triggerDummy.setTrigName("Mili");
		triggerDummy.setTrigScope("L");
		triggerDao.save(triggerDummy);

		return triggerDummy;
	}

	@Override
	public Triggerr edit(long id, String name, String scope) {
		Triggerr triggerDummy = new Triggerr();
		triggerDummy.setTrigId(id);
		triggerDummy.setTrigName(name);
		triggerDummy.setTrigScope(scope);
		triggerDao.save(triggerDummy);
		return triggerDummy;
	}

	@Override
	public Triggerr findById(long id) {
		return triggerDao.findById(id);
	}

	@Override
	public List<Triggerr> findAll() {
		return triggerDao.findAll();
	}

	@Override
	public void save(Triggerr triggerr) {
		triggerDao.save(triggerr);
	}

	@Override
	public void delete(Triggerr triggerr) {
		triggerDao.delete(triggerr);
	}
}