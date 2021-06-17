package com.exercise.taller1.RESTController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.service.AutotransitionService;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.validations.AutotranAddValidation;
import com.exercise.taller1.validations.AutotranEditValidation;


@RestController
public class AutotransitionRestControllerImp {

	private AutotransitionService autotransitionService;
	private FevInstitutionService fevInstitutionService;

	@Autowired
	public AutotransitionRestControllerImp(AutotransitionService autotransitionService,
			FevInstitutionService fevInstitutionService) {
		this.autotransitionService = autotransitionService;
		this.fevInstitutionService = fevInstitutionService;
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/autotransition/")
	public String indexAutotran(Model model) {
		model.addAttribute("autotransitions", autotransitionService.findAll());
		return "autotransition/index";
	}

	@GetMapping("/autotransition/add-autotransition")
	public String addAutotransition(Model model, @ModelAttribute("autotransition") Autotransition autotransition) {
		model.addAttribute("autotransition", new Autotransition());
		model.addAttribute("fevInstitution", fevInstitutionService.findAll());
		return "autotransition/add-autotransition";
	}

	@PostMapping("/autotransition/add-autotransition")
	public String saveAutotransition(@Validated(AutotranAddValidation.class) Autotransition autotransition,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", fevInstitutionService.findAll());
				return "autotransition/add-autotransition";
			} else {
				autotransitionService.save(autotransition);
			}
		return "redirect:/autotransition/";
	}

	@GetMapping("/autotransition/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Autotransition autotran = autotransitionService.findById(id);
		if (autotran == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("autotransition", autotran);
		model.addAttribute("fevInstitution", fevInstitutionService.findAll());
		return "autotransition/edit-autotransition";
	}

	@PostMapping("/autotransition/edit/{id}")
	public String updateAutotran(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(AutotranEditValidation.class) Autotransition autotransition, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("CANCEL")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("autotransition", autotransition);
				model.addAttribute("fevInstitution", fevInstitutionService.findAll());
				return "autotransition/edit-autotransition";
			}
			autotransitionService.save(autotransition);
		}
		return "redirect:/autotransition/";
	}

	@GetMapping("/users/del/{id}")
	public String deleteAutotran(@PathVariable("id") long id, Model model) {
		Autotransition autotran = autotransitionService.findById(id);
		autotransitionService.delete(autotran);
		return "redirect:/autotransition/";
	}
}