package com.exercise.taller1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exercise.taller1.delegate.PersonDelegate;

import com.exercise.taller1.model.Person;
import com.exercise.taller1.validations.DocumentEditValidation;
import com.exercise.taller1.validations.PersonValidation;

@Controller
public class PersonControllerImpl {
	
	private PersonDelegate personService;
	
	@Autowired
	public PersonControllerImpl(PersonDelegate personService) {
		this.personService = personService;
	}
	
/*	@GetMapping("/login")
	public String login() {
		return "/login";
	}*/

	@GetMapping("/person/")
	public String indexDocument(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "person/index";
	}

	@GetMapping("/person/add-person")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("person", new Person());
		//model.addAttribute("fevInstitution", personService.findAllFev());
		return "person/add-person";
	}

	@PostMapping("/person/add-person")
	public String savePerson(@Validated(PersonValidation.class) Person person,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				//model.addAttribute("fevInstitution", personService.findAllFev());
				return "person/add-person";
			} else {
				System.out.println(person.getPersName());
				personService.savePerson(person);
			}
		return "redirect:/person/";
	}


	@GetMapping("/person/del/{id}")
	public String deleteDocument(@PathVariable("id") long id, Model model) {
		Person doc = personService.findById(id);
		personService.delete(doc);
		return "redirect:/person/";
	}

}
