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

import com.exercise.taller1.delegate.TriggerDelegate;
import com.exercise.taller1.delegate.TriggerTypeDelegate;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.validations.TriggerrAddValidation;
import com.exercise.taller1.validations.TriggerrEditValidation;

@Controller
public class TriggerControllerImp {

	private TriggerDelegate triggerService;
	private TriggerTypeDelegate triggerTypeService;

	@Autowired
	public TriggerControllerImp(TriggerDelegate triggerService,
			TriggerTypeDelegate triggerTypeService) {
		this.triggerService = triggerService;
		this.triggerTypeService = triggerTypeService;
	}

	@GetMapping("/triggerr/")
	public String indexTriggerr(Model model) {
		model.addAttribute("triggerr", triggerService.findAll());
		return "triggerr/index";
	}

	@GetMapping("/triggerr/add-triggerr")
	public String addTriggerr(Model model, @ModelAttribute("triggerr") Triggerr triggerr) {
		model.addAttribute("triggerr", new Triggerr());
		model.addAttribute("triggertype", triggerTypeService.findAll());
		return "triggerr/add-triggerr";
	}

	@PostMapping("/triggerr/add-triggerr")
	public String saveTriggerr(@Validated(TriggerrAddValidation.class) Triggerr triggerr, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("triggertype", triggerTypeService.findAll());
				return "triggerr/add-triggerr";
			} else {
				triggerService.save(triggerr);
			}
		return "redirect:/triggerr/";
	}

	@GetMapping("/triggerr/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Triggerr triggerr = triggerService.findById(id);
		if (triggerr == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("triggerr", triggerr);
		model.addAttribute("triggertype", triggerTypeService.findAll());
		return "trigger/edit-triggerr";
	}

	@PostMapping("/triggerr/edit/{id}")
	public String updateTriggerr(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(TriggerrEditValidation.class) Triggerr triggerr, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("CANCEL")) {
			if (bindingResult.hasErrors()) {
				
				model.addAttribute("triggerr", triggerr);
				model.addAttribute("triggertype", triggerTypeService.findAll());
				return "triggerr/edit-triggerr";
			}
			triggerService.save(triggerr);
		}
		return "redirect:/triggerr/";
	}
	
	@GetMapping("/triggerr/del/{id}")
	public String deleteTriggerr(@PathVariable("id") long id, Model model) {
		Triggerr triggerr = triggerService.findById(id);
		triggerService.delete(triggerr);
		return "redirect:/triggerr/";
	}
	
	
}