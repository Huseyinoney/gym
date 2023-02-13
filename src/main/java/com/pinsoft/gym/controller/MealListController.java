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

import com.pinsoft.gym.service.abstracts.MealListService;
import com.pinsoft.gym.service.requests.CreateMealList;
import com.pinsoft.gym.service.requests.UpdateMealList;
import com.pinsoft.gym.service.responses.MealListGetAll;

@RestController
@RequestMapping("/MealList")
public class MealListController {
	private MealListService mealListService;

	
	@Autowired
	public MealListController(MealListService mealListService) {
		super();
		this.mealListService = mealListService;
	}
	@GetMapping("/getAll")
	public List<MealListGetAll> getAll() {
		
		return mealListService.getAll();
		
	}
	@PostMapping("/Add")
	public void add(@RequestBody CreateMealList createMealList) {
		 
		mealListService.add(createMealList);
	}
	@DeleteMapping("/Delete")
	public void delete(@RequestBody int id) {
		
		mealListService.delete(id);
	}
	@PutMapping("/Update")
	public void update(UpdateMealList updateMealList) {
		 
		mealListService.update(updateMealList);
	}
	
	
	
}
