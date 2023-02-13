package com.pinsoft.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.service.abstracts.NutritionService;
import com.pinsoft.gym.service.requests.Nutrition.CreateNutrition;
import com.pinsoft.gym.service.requests.Nutrition.DeleteNutrition;
import com.pinsoft.gym.service.requests.Nutrition.UpdateNutrition;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {
	
	private NutritionService nutritionService;
	@Autowired
	public NutritionController(NutritionService nutritionService) {
		super();
		this.nutritionService = nutritionService;
	}

	@GetMapping("/getAll")
	public List<Nutrition> getAll() {
		
		return nutritionService.getAll();
		
	}
	@PostMapping("/Add")
	public void add(@RequestBody CreateNutrition createNutrition) {
		
		nutritionService.add(createNutrition);
	}
	@DeleteMapping("/Delete")
	public void delete(@RequestBody DeleteNutrition deleteNutrition) { 
		
		nutritionService.delete(deleteNutrition.getId());
	}
	@PutMapping("/Update")
	public void update(@RequestBody UpdateNutrition updateNutrition) {
		
		nutritionService.update(updateNutrition);
	}
	
}
