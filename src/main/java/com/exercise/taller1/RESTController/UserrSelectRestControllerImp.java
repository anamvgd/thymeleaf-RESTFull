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

import com.exercise.taller1.model.Userselect;
import com.exercise.taller1.service.TriggerService;
import com.exercise.taller1.service.UserSelectService;
import com.exercise.taller1.validations.UserrSelectAddValidation;
import com.exercise.taller1.validations.UserrSelectEditValidation;


@RestController
public class UserrSelectRestControllerImp implements UserrSelectController {

	@Autowired
	public UserSelectService userSelectService;
	@Autowired
	public TriggerService triggerService;
	
	@Override
	@PutMapping("/api/userselects")
	public Userselect edit(@RequestBody Userselect auto) throws Exception {
		// TODO Auto-generated method stub
		return userSelectService.edit(auto.getUsselId(), auto.getUsselTablename(), auto.getUsselValuekeycolumn(), auto.getUsselValueusercolumn(), auto.getUsselWherestatement());
	}
	@Override
	@PostMapping("/api/userselects/adds")
	public Userselect add(@RequestBody Userselect auto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@GetMapping("/api/userselects")
	public List<Userselect> findAll() {
		// TODO Auto-generated method stub
		return userSelectService.findAll();
	}
	@Override
	@PostMapping("/api/userselects")
	public void save(@RequestBody Userselect autotransition) {
		// TODO Auto-generated method stub
		userSelectService.save(autotransition);
	}
	@Override
	@DeleteMapping("/api/userselects/{id}")
	public void delete(@PathVariable long id) {
		// TODO Auto-generated method stub
		userSelectService.delete(userSelectService.findById(id));
	}
	@Override
	@GetMapping("/api/userselects/{id}")
	public Userselect findById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return userSelectService.findById(id);
	}

	
	
}