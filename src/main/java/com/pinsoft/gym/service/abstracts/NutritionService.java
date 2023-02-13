package com.pinsoft.gym.service.abstracts;

import java.util.List;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.service.requests.CreateNutrition;
import com.pinsoft.gym.service.requests.UpdateNutrition;

public interface NutritionService {
	
	List<Nutrition> getAll();
	void add(CreateNutrition nutritionCreate);
	void delete(int id);
	void update(UpdateNutrition updateNutrition);
}
