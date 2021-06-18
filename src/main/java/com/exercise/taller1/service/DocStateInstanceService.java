package com.exercise.taller1.service;

import com.exercise.taller1.model.Docstateinstance;

public interface DocStateInstanceService {

		public Iterable<Docstateinstance> findAll();

		public void add(Docstateinstance docstateInstance);
		
		public Docstateinstance findById(long id);
	}

