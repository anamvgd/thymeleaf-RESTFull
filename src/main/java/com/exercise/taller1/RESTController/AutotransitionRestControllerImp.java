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

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.service.AutotransitionService;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.validations.AutotranAddValidation;
import com.exercise.taller1.validations.AutotranEditValidation;


@RestController
public class AutotransitionRestControllerImp implements AutotransitionController{
	
	@Autowired
	private AutotransitionService autotransitionService;
	@Autowired
	private FevInstitutionService fevInstitutionService;
	
	
	@Override
	@PutMapping("/api/autotransitions")
	public Autotransition edit(@RequestBody Autotransition auto) throws Exception {
		// TODO Auto-generated method stub
		String name = auto.getAutotranName();
		String logicalOperand = auto.getAutotranLogicaloperand();
		String isActive = auto.getAutotranIsactive();
				
		autotransitionService.edit(auto.getAutotranId(),name,logicalOperand,isActive);
		return auto;
	}
	
	@Override
	@PostMapping("/api/autotransitions/adds")
	public Autotransition add(@RequestBody Autotransition auto) {
		
		
		return null;
	}
	
	@Override
	@GetMapping("/api/autotransitions")
	public List<Autotransition> findAll() {
		// TODO Auto-generated method stub
		return autotransitionService.findAll();
	}
	
	@Override
	@PostMapping("/api/autotransitions")
	public void save(@RequestBody Autotransition autotransition) {
		// TODO Auto-generated method stub
		autotransitionService.save(autotransition);
	}
	
	@Override
	@DeleteMapping("/api/autotransitions/{id}")
	public void delete(@PathVariable long id) {
		// TODO Auto-generated method stub
		Autotransition autotran = autotransitionService.findById(id);
		autotransitionService.delete(autotran);
		
	}
	
	@Override
	@GetMapping("/api/autotransitions/{id}")
	public Autotransition findById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return autotransitionService.findById(id);
	}
	
	@Override
	@GetMapping("/api/fevInstitutions")
	public Iterable<FevInstitution> findAllFev() {
		// TODO Auto-generated method stub
		return fevInstitutionService.findAll();
	}
	@Override
	@PostMapping("/api/fevInstitutions")
	public void addFev(@RequestBody FevInstitution fevInstitution) {
		// TODO Auto-generated method stub
		fevInstitutionService.add(fevInstitution);
	}
	@Override
	@GetMapping("/api/fevInstitutions/{id}")
	public FevInstitution findByIdFev(@PathVariable long id) {
		// TODO Auto-generated method stub
		return fevInstitutionService.findById(id);
	}

	
	

	
}