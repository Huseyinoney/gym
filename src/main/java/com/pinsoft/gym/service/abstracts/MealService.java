package com.pinsoft.gym.service.abstracts;

import java.util.List;

import com.pinsoft.gym.service.requests.Meal.CreateMeal;
import com.pinsoft.gym.service.requests.Meal.UpdateMeal;
import com.pinsoft.gym.service.responses.MealGetAll;

public interface MealService  {

	List<MealGetAll> getAll();
	void add(CreateMeal createMeal);
	void delete(int id);
	void update(UpdateMeal updateMeal);
}
