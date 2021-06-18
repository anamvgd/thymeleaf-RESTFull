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

import com.exercise.taller1.delegate.AutotransitionDelegate;
import com.exercise.taller1.delegate.DocumenttypeDelegate;

import com.exercise.taller1.model.Documenttype;

import com.exercise.taller1.validations.DocumenttypeEditValidation;
import com.exercise.taller1.validations.DocumenttypeValidation;


@Controller
public class DocumenttypeControllerImpl {
	
	private DocumenttypeDelegate doctypeService;
	private AutotransitionDelegate fevInstitutionService;
	
	@Autowired
	public DocumenttypeControllerImpl(DocumenttypeDelegate doctypeService) {
		this.doctypeService = doctypeService;
		this.fevInstitutionService = fevInstitutionService;
	}
	
	/*@GetMapping("/login")
	public String login() {
		return "/login";
	}
*/
	@GetMapping("/doctypes")
	public String indexDocutype(Model model) {
		model.addAttribute("doctypes", doctypeService.findAll());
		return "doctypes/index";
	}

	@GetMapping("/doctypes/add-doctypes")
	public String addDocumenttype(Model model, @ModelAttribute("doctypes") Documenttype doctypes) {
		model.addAttribute("doctypes", new Documenttype());
		//model.addAttribute("fevInstitution", fevInstitutionService.findAllFev());
		return "doctypes/add-doctypes";
	}

	@PostMapping("/doctypes/add-doctypes")
	public String saveDocumenttype(@Validated(DocumenttypeValidation.class) Documenttype doctypes,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				//model.addAttribute("fevInstitution", fevInstitutionService.findAllFev());
				return "doctypes/add-doctypes";
			} else {
				System.out.println(doctypes.getDoctypeName());
				doctypeService.saveDocumenttype(doctypes);
			}
		return "redirect:/doctypes/";
	}

	@GetMapping("/doctypes/edit-doctypes/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Documenttype doc = doctypeService.findById(id);
		if (doc == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("doctypes", doc);
		//model.addAttribute("fevInstitution", fevInstitutionService.findAllFev());
		
		return "doctypes/edit-doctypes";
	}

	@PostMapping("/doctypes/edit-doctypes/{id}")
	public String updateAutotran(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(DocumenttypeEditValidation.class) Documenttype doctypes, BindingResult bindingResult, Model model) throws Exception {
		if (action != null && !action.equals("CANCEL")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("doctypes", doctypes);
				//model.addAttribute("fevInstitution", fevInstitutionService.findAllFev());
				return "doctypes/edit-doctypes";
			}
			
			doctypeService.editDocumenttype(id, doctypes.getDoctypeName(), doctypes.getInstInstId());
		}
		return "redirect:/doctypes/";
	}

	@GetMapping("/doctypes/del/{id}")
	public String deleteAutotran(@PathVariable("id") long id, Model model) {
		Documenttype doc = doctypeService.findById(id);
		doctypeService.delete(doc);
		return "redirect:/doctypes/";
	}


}
