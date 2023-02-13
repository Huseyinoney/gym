package com.pinsoft.gym.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.repository.abstracts.MealRepository;
import com.pinsoft.gym.service.abstracts.MealService;
import com.pinsoft.gym.service.requests.CreateMeal;
import com.pinsoft.gym.service.requests.UpdateMeal;
import com.pinsoft.gym.service.responses.MealGetAll;

@Service
public class MealManager implements MealService {
	private MealRepository mealRepository;
	
	@Autowired
	public MealManager(MealRepository mealRepository) {
		super();
		this.mealRepository = mealRepository;
	}

	@Override
	public List<MealGetAll> getAll() {
		
		List<Meal> meals = mealRepository.findAll();
		ArrayList<MealGetAll> mealResponse =  new ArrayList<MealGetAll>();
		
		for(Meal meal : meals) {
			MealGetAll responseItem = new MealGetAll();
			responseItem.setName(meal.getName());
			responseItem.setMealList(meal.getMealList());
			responseItem.setId(meal.getId());
			
			mealResponse.add(responseItem);
		}
		return mealResponse;
	}

	@Override
	public void add(CreateMeal createMeal) {
		Meal meal = new Meal();
		meal.setName(createMeal.getName());
		mealRepository.save(meal);
		
	}

	@Override
	public void delete(int id) {
		mealRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateMeal updateMeal) {
		Meal meal = mealRepository.findById(updateMeal.getId()).get();
		meal.setName(updateMeal.getName());
		mealRepository.save(meal);
		
	}

}
