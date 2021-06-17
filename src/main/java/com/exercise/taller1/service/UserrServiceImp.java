package com.exercise.taller1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.taller1.model.Userr;
import com.exercise.taller1.repository.UserrRepository;

@Service
public class UserrServiceImp implements UserrService {

	private UserrRepository userRepo;

	@Autowired
	public UserrServiceImp(UserrRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public void save(Userr userr) {
		userRepo.save(userr);
	}
}
