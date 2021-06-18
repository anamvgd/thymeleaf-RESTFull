package com.exercise.taller1.RESTController;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Documenttype;
import com.exercise.taller1.service.DocumenttypeService;

@RestController
public class DocumenttypeRestControllerImpl implements DocumenttypeController{
	
	@Autowired
	public DocumenttypeService doctypeService;
	
	@Override
	@PutMapping("/api/doctypes")
	public Documenttype edit(Documenttype doc) throws Exception {
	
		return doctypeService.editDocumenttype(doc.getDoctypeId(), doc.getDoctypeName(), doc.getInstInstId());
	}

	@Override
	@PostMapping("/api/doctypes/adds")
	public Documenttype add(@RequestBody Documenttype doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/api/doctypes")
	public List<Documenttype> findAll() {
		// TODO Auto-generated method stub
		System.out.println("lista los types"+doctypeService.findAll());
		
		return doctypeService.findAll();
	}

	@Override
	@PostMapping("/api/doctypes")
	public void save(@RequestBody Documenttype document) {
		doctypeService.saveDocumenttype(document);
		
	}

	@Override
	@DeleteMapping("/api/doctypes/{id}")
	public void delete(@PathVariable long id) {
		doctypeService.delete(doctypeService.findById(id));
		
	}

	@Override
	@GetMapping("/api/doctypes/{id}")
	public Documenttype findById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return doctypeService.findById(id);
	}


}
