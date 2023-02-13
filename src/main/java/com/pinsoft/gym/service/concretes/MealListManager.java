package com.pinsoft.gym.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.repository.abstracts.MealListRepository;
import com.pinsoft.gym.repository.abstracts.MealRepository;
import com.pinsoft.gym.repository.abstracts.NutritionRepository;
import com.pinsoft.gym.service.abstracts.MealListService;
import com.pinsoft.gym.service.requests.CreateMealList;
import com.pinsoft.gym.service.requests.UpdateMealList;
import com.pinsoft.gym.service.responses.MealListGetAll;
@Service
public class MealListManager implements MealListService{

	private MealListRepository mealListRepository;
	private MealRepository mealRepository;
	private NutritionRepository nutritionRepository;
	
	@Autowired
	public MealListManager(MealListRepository mealListRepository, MealRepository mealRepository,
			NutritionRepository nutritionRepository) {
		super();
		this.mealListRepository = mealListRepository;
		this.mealRepository = mealRepository;
		this.nutritionRepository = nutritionRepository;
	}

	
	
	@Override
	public List<MealListGetAll> getAll() {
		
		List<MealList> MealListResult = mealListRepository.findAll();
		ArrayList<MealListGetAll> mealListResponse = new ArrayList<MealListGetAll>();
		
		
		for(int i=0;i<MealListResult.size();i++) {
				MealListGetAll mealListGetAll = new MealListGetAll();
				mealListGetAll.setMeal(MealListResult.get(i).getMeal().getName());
				mealListGetAll.setCreatedDate(MealListResult.get(i).getCreatedDate());
				mealListGetAll.setWeight(MealListResult.get(i).getWeight());
				mealListGetAll.setNutrition(MealListResult.get(i).getNutrition());
				
				mealListResponse.add(mealListGetAll);
			
		}
			return mealListResponse;
		}
	

	@Override
	public void add(CreateMealList createMealList) {
		List<Meal> meals = mealRepository.findAll();
		List<Nutrition> nutritions = nutritionRepository.findAll();
		MealList mealList = new MealList();
		ArrayList<Nutrition> nutritions2 = new ArrayList<Nutrition>();
		
		for(int i = 0; i < meals.size(); i++) {
			if(meals.get(i).getName().equals(createMealList.getMeal())) {
				mealList.setMeal(meals.get(i));
			}
			for(int j = 0; j <createMealList.getNutrition().size(); j++) {
				for(int z=0; z<nutritions.size();z++) {
					
					if(nutritions.get(z).getName().equals(createMealList.getNutrition().get(j))) {
						nutritions2.add(nutritions.get(z));
					}
				}
				mealList.setNutrition(nutritions2);
				
			}
			
		mealList.setCreatedDate(createMealList.getCreatedDate());
		mealList.setWeight(createMealList.getWeight());
		}
		
		mealListRepository.save(mealList);
	}

	@Override
	public void delete(int id) {
		mealListRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateMealList updateMealList) {
		
		MealList mealList = new MealList();
		List<Meal> MealResult = mealRepository.findAll();
		
		mealList = mealListRepository.findById(updateMealList.getId()).get();
		mealList.setCreatedDate(updateMealList.getCreatedDate());
		mealList.setNutrition(updateMealList.getNutrition());
		mealList.setWeight(updateMealList.getWeight());
		for(Meal meal:MealResult) {
			if(meal.getName()==updateMealList.getMeal()) {
				mealList.setMeal(meal);
			}
		}
		
		mealListRepository.save(mealList);
	}

}
