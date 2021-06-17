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
import com.exercise.taller1.delegate.UserrSelectDelegate;
import com.exercise.taller1.model.Userselect;
import com.exercise.taller1.validations.UserrSelectAddValidation;
import com.exercise.taller1.validations.UserrSelectEditValidation;


@Controller
public class UserrSelectControllerImp {

	public UserrSelectDelegate userSelectService;
	public TriggerDelegate triggerService;

	@Autowired
	public UserrSelectControllerImp(UserrSelectDelegate userSelectService, TriggerDelegate triggerService) {
		this.userSelectService = userSelectService;
		this.triggerService = triggerService;
	}

	@GetMapping("/userselect/")
	public String indexUserselect(Model model) {
		model.addAttribute("userselect", userSelectService.findAll());
		return "userselect/index";
	}

	@GetMapping("/userselect/add-userselect")
	public String addUserSelect(Model model, @ModelAttribute("autotransition") Userselect userselect) {
		model.addAttribute("userselect", new Userselect());
		model.addAttribute("triggerr", triggerService.findAll());
		return "userselect/add-userselect";
	}

	@PostMapping("/userselect/add-userselect")
	public String saveUserSelect(@Validated(UserrSelectAddValidation.class) Userselect userselect,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("triggerr", triggerService.findAll());
				return "userselect/add-userselect";
			} else {
				userSelectService.save(userselect);
			}
		return "redirect:/userselect/";
	}

	@GetMapping("/userselect/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Userselect userselect = userSelectService.findById(id);
		if (userselect == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("userselect", userselect);
		model.addAttribute("triggerr", triggerService.findAll());
		return "userselect/edit-userselect";
	}

	@PostMapping("/userselect/edit/{id}")
	public String updateUserSelect(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(UserrSelectEditValidation.class) Userselect userselect, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("userselect", userselect);
				model.addAttribute("triggerr", triggerService.findAll());
				return "userselect/edit-userselect";
			}
			userSelectService.save(userselect);
		}
		return "redirect:/userselect/";
	}

	@GetMapping("/userselect/del/{id}")
	public String deleteUserSelect(@PathVariable("id") long id, Model model) {
		Userselect userselect = userSelectService.findById(id);
		userSelectService.delete(userselect);
		return "redirect:/userselect/";
	}
}