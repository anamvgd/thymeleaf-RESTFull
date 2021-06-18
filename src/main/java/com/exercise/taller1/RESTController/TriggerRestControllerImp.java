package com.exercise.taller1.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.service.TriggerService;
import com.exercise.taller1.service.TriggerTypeService;
import com.exercise.taller1.validations.TriggerrAddValidation;
import com.exercise.taller1.validations.TriggerrEditValidation;

@RestController
public class TriggerRestControllerImp implements TriggerController {

	@Autowired
	private TriggerService triggerService;
	@Autowired
	private TriggerTypeService triggerTypeService;
	
	@Override
	@PutMapping("/api/triggers")
	public Triggerr edit(@RequestBody Triggerr auto) throws Exception {
		// TODO Auto-generated method stub
		
		triggerService.edit(auto.getTrigId(),auto.getTrigName(),auto.getTrigScope());
		return auto;
	}
	@Override
	@PostMapping("/api/triggers/adds")
	public Triggerr add(@RequestBody Triggerr auto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@GetMapping("/api/triggers")
	public List<Triggerr> findAll() {
		// TODO Auto-generated method stub
		return triggerService.findAll();
	}
	@Override
	@PostMapping("/api/triggers")
	public void save(@RequestBody Triggerr autotransition) {
		// TODO Auto-generated method stub
		triggerService.save(autotransition);
	}
	@Override
	@DeleteMapping("/api/triggers/{id}")
	public void delete(@PathVariable long id) {
		// TODO Auto-generated method stub
		Triggerr autotran = triggerService.findById(id);
		triggerService.delete(autotran);
	}
	@Override
	@GetMapping("/api/triggers/{id}")
	public Triggerr findById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return triggerService.findById(id);
	}

	
	
	
	
}