package com.exercise.taller1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.model.Documentstate;
import com.exercise.taller1.repository.DocstateInstanceRepository;
import com.exercise.taller1.repository.DocumentstateRepository;

@Service
public class DocumentStateServiceImpl implements DocumentStateService{
	
	private DocumentstateRepository docstateRepo;
	private DocstateInstanceRepository docstateInstanceRepo;
	
	@Autowired
	public DocumentStateServiceImpl(DocumentstateRepository docstateRepo) {
		this.docstateRepo = docstateRepo;
	}
	
	@Override
	public Iterable<Documentstate> findAll() {
		return docstateRepo.findAll();
	}
	
	@Override
	public void add(Documentstate docstateInstance) {
		docstateRepo.save(docstateInstance);
	}
	
	@Override
	public Documentstate findById(long id) {
		return docstateRepo.findById(id).get();
	}

	

}
