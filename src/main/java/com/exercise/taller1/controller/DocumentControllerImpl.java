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

import com.exercise.taller1.delegate.DocumentDelegate;
import com.exercise.taller1.model.Documentt;


import com.exercise.taller1.validations.DocumentEditValidation;
import com.exercise.taller1.validations.DocumenttValidation;

@Controller
public class DocumentControllerImpl {
	
	private DocumentDelegate delegateService;
	
	@Autowired
	public DocumentControllerImpl(DocumentDelegate delegateService) {
		this.delegateService = delegateService;
	}
	
/*	@GetMapping("/login")
	public String login() {
		return "/login";
	}
*/
	@GetMapping("/document")
	public String indexDocument(Model model) {
		model.addAttribute("documents", delegateService.findAll());
		return "document/index";
	}

	@GetMapping("/document/add-document")
	public String addDocumentt(Model model, @ModelAttribute("document") Documentt document) {
		model.addAttribute("document", new Documentt());
		//model.addAttribute("fevInstitution", delegateService.findAllFev());
		return "document/add-document";
	}

	@PostMapping("/document/add-document")
	public String saveDocumentt(@Validated(DocumenttValidation.class) Documentt document,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				//model.addAttribute("fevInstitution", delegateService.findAllFev());
				return "document/add-document";
			} else {
				System.out.println(document.getDocName());
				delegateService.saveDocumentt(document);
			}
		return "redirect:/document/";
	}

	@GetMapping("/document/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Documentt doc = delegateService.findById(id);
		if (doc == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("document", doc);
		//model.addAttribute("fevInstitution", delegateService.findAllFev());
		return "document/edit-document";
	}

	@PostMapping("/document/edit/{id}")
	public String updateDocument(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(DocumentEditValidation.class) Documentt document, BindingResult bindingResult, Model model) throws Exception {
		if (action != null && !action.equals("CANCEL")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("document", document);
				//model.addAttribute("fevInstitution", delegateService.findAllFev());
				return "document/edit-document";
			}
			
			delegateService.editDocumentt(id, document.getDocName(), document.getDocumenttype().getDoctypeId(), document.getPerson().getPersId());
		}
		return "redirect:/document/";
	}

	@GetMapping("/document/del/{id}")
	public String deleteDocument(@PathVariable("id") long id, Model model) {
		Documentt doc = delegateService.findById(id);
		delegateService.delete(doc);
		return "redirect:/document/";
	}

}
