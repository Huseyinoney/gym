package com.pinsoft.gym.service.abstracts;

import java.util.List;

import com.pinsoft.gym.service.requests.MealList.CreateMealList;
import com.pinsoft.gym.service.requests.MealList.UpdateMealList;
import com.pinsoft.gym.service.responses.MealListGetAll;

public interface MealListService {
	List<MealListGetAll> getAll();
	void add(CreateMealList createMealList);
	void delete(int id);
	void update(UpdateMealList updateMealList);
}
