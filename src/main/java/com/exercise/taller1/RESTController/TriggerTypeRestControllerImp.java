package com.exercise.taller1.RESTController;

import java.util.Optional;
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
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Triggertype;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.service.TriggerTypeService;
import com.exercise.taller1.validations.TriggerTypeAddValidation;
import com.exercise.taller1.validations.TriggerTypeEditValidation;

@RestController
public class TriggerTypeRestControllerImp {

	private TriggerTypeService triggerTypeService;
	private FevInstitutionService fevInstitutionService;

	@Autowired
	public TriggerTypeRestControllerImp(TriggerTypeService triggerTypeService,
			FevInstitutionService fevInstitutionService) {
		this.triggerTypeService = triggerTypeService;
		this.fevInstitutionService = fevInstitutionService;
	}

	@GetMapping("/triggertype/")
	public String indexTriggerType(Model model) {
		model.addAttribute("triggertype", triggerTypeService.findAll());
		return "triggertype/index";
	}

	@GetMapping("/triggertype/add-triggertype")
	public String addTriggertype(Model model, @ModelAttribute("triggertype") Triggertype autotransition) {
		model.addAttribute("triggertype", new Triggertype());
		model.addAttribute("fevInstitution", fevInstitutionService.findAll());
		return "triggertype/add-triggertype";
	}

	@PostMapping("/triggertype/add-triggertype")
	public String saveTriggertype(@Validated(TriggerTypeAddValidation.class) Triggertype trigtype,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("CANCEL"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", fevInstitutionService.findAll());
				return "triggertype/add-triggertype";
			} else {
				triggerTypeService.save(trigtype);
			}
		return "redirect:/triggertype/";
	}

	@GetMapping("/triggertype/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Triggertype> trigtype = triggerTypeService.findById(id);
		if (trigtype == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("triggertype", trigtype.get());
		model.addAttribute("fevInstitution", fevInstitutionService.findAll());
		return "triggertype/edit-triggertype";
	}

	@PostMapping("/triggertype/edit/{id}")
	public String updateTriggerType(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(TriggerTypeEditValidation.class) Triggertype trigtype, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("triggertype", trigtype);
				model.addAttribute("fevInstitution", fevInstitutionService.findAll());
				return "triggertype/edit-triggertype";
			}
			triggerTypeService.save(trigtype);
		}
		return "redirect:/triggertype/";
	}

	@GetMapping("/triggertype/del/{id}")
	public String deleteTriggerType(@PathVariable("id") long id, Model model) {
		Triggertype trigtype = triggerTypeService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		triggerTypeService.delete(trigtype);
		return "redirect:/triggertype/";
	}
}