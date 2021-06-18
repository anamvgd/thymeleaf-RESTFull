package com.exercise.taller1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.DocumentDao;
import com.exercise.taller1.daos.PersonDao;
import com.exercise.taller1.model.Docstateinstance;
import com.exercise.taller1.repository.DocstateInstanceRepository;

@Service
public class DocStateInstanceServiceImpl implements DocStateInstanceService{
	
	private DocstateInstanceRepository docstateInstanceRepo;
	
	@Autowired
	public DocStateInstanceServiceImpl(DocstateInstanceRepository docstateInstanceRepo) {
		this.docstateInstanceRepo = docstateInstanceRepo;
	}
	
	@Override
	public Iterable<Docstateinstance> findAll() {
		return docstateInstanceRepo.findAll();
	}
	
	@Override
	public void add(Docstateinstance docstateInstance) {
		docstateInstanceRepo.save(docstateInstance);
	}
	
	@Override
	public Docstateinstance findById(long id) {
		return docstateInstanceRepo.findById(id).get();
	}

}
