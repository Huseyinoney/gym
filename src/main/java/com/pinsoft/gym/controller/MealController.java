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

import com.pinsoft.gym.service.abstracts.MealService;
import com.pinsoft.gym.service.requests.Meal.CreateMeal;
import com.pinsoft.gym.service.requests.Meal.DeleteMeal;
import com.pinsoft.gym.service.requests.Meal.UpdateMeal;
import com.pinsoft.gym.service.responses.MealGetAll;

@RestController
@RequestMapping("/Meal")
public class MealController {

	private MealService mealService;
	
@Autowired	
public MealController(MealService mealService) {
		super();
		this.mealService = mealService;
	}
	@GetMapping("/getAll")
	public List<MealGetAll> getAll() {
		
		return mealService.getAll();
		
	}
	@PostMapping("/Add")
	public void add(@RequestBody CreateMeal createMeal) {
		
		mealService.add(createMeal);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteMeal deleteMeal) { 
		
		mealService.delete(deleteMeal.getId());
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateMeal updateMeal) {
		
		mealService.update(updateMeal);
	}
	
}
