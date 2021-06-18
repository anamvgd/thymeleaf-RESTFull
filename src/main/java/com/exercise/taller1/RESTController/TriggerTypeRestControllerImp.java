package com.exercise.taller1.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Triggertype;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.service.TriggerTypeService;
import com.exercise.taller1.validations.TriggerTypeAddValidation;
import com.exercise.taller1.validations.TriggerTypeEditValidation;

@RestController
public class TriggerTypeRestControllerImp implements TriggertypeController{

	@Autowired
	private TriggerTypeService triggerTypeService;
	@Autowired
	private FevInstitutionService fevInstitutionService;

	
	

	@Override
	@PutMapping("/api/triggerstype")
	public Triggertype edit(@RequestBody Triggertype auto) throws Exception {
		// TODO Auto-generated method stub
		return triggerTypeService.edit(auto.getInstInstId(), auto.getTrigtypeId(), auto.getTrigtypeName());
	}

	@Override
	@PostMapping("/api/triggerstype/adds")
	public Triggertype add(@RequestBody Triggertype auto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/api/triggerstype")
	public List<Triggertype> findAll() {
		// TODO Auto-generated method stub
		return (List<Triggertype>) triggerTypeService.findAll();
	}

	@Override
	@PostMapping("/api/triggerstype")
	public void save(@RequestBody Triggertype autotransition) {
		// TODO Auto-generated method stub
		triggerTypeService.save(autotransition);
	}

	@Override
	@DeleteMapping("/api/triggerstype/{id}")
	public void delete(@PathVariable long id) {
		// TODO Auto-generated method stub
		triggerTypeService.delete(triggerTypeService.findById(id));
	}

	@Override
	@GetMapping("/api/triggerstype/{id}")
	public Triggertype findById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return triggerTypeService.findById(id);
	}
}