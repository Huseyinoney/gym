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
		List<Meal> mealResult = mealRepository.findAll();
		
		for(MealList mealList: MealListResult) {
			
			MealListGetAll mealListGetAll  = new MealListGetAll();
			mealListGetAll.setId(mealList.getId());
			mealListGetAll.setNutrition(mealList.getNutrition());
			mealListGetAll.setWeight(mealList.getWeight());
			mealListGetAll.setCreatedDate(mealList.getCreatedDate());
			mealListResponse.add(mealListGetAll);
		
			
		}
		return mealListResponse;
	}

	@Override
	public void add(CreateMealList createMealList) {
		List<Meal> MealResult = mealRepository.findAll();
		List<Nutrition> nutritionResult = nutritionRepository.findAll();
		ArrayList<Nutrition> nutritions =  new ArrayList<Nutrition>();
		MealList mealList = new MealList();
		
		for(String nutrition:createMealList.getNutrition()) {
			for(Nutrition nutrition2:nutritionResult) {
				if(nutrition.equals(nutrition2.getName())) {
					nutritions.add(nutrition2);
				}
			}
		}
		
		mealList.setNutrition(nutritions);
		mealList.setWeight(createMealList.getWeight());
		mealList.setCreatedDate(createMealList.getCreatedDate());
		for(Meal meal:MealResult) {
			
			if(meal.getName().equals(createMealList.getMeal())) {
				mealList.setMeal(meal);
			}
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
