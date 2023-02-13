package com.pinsoft.gym.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.model.NutritionType;
import com.pinsoft.gym.repository.abstracts.NutritionRepository;
import com.pinsoft.gym.repository.abstracts.NutritionTypeRepository;
import com.pinsoft.gym.service.abstracts.NutritionService;
import com.pinsoft.gym.service.requests.Nutrition.CreateNutrition;
import com.pinsoft.gym.service.requests.Nutrition.UpdateNutrition;
@Service
public class NutritionManager implements NutritionService {
	private NutritionRepository nutritionRepository;
	private NutritionTypeRepository nutritionTypeRepository;
	
	public NutritionManager(NutritionRepository nutritionRepository, NutritionTypeRepository nutritionTypeRepository) {
		super();
		this.nutritionRepository = nutritionRepository;
		this.nutritionTypeRepository = nutritionTypeRepository;
	}

	@Override
	public List<Nutrition> getAll() {
		
		return nutritionRepository.findAll();
	}

	@Override
	public void add(CreateNutrition createNutrition) {
		List<NutritionType> nutritionTypes = nutritionTypeRepository.findAll();
		
		Nutrition nutrition = new Nutrition();
		nutrition.setName(createNutrition.getName());
		nutrition.setBaseWeight(createNutrition.getBaseWeight());
		nutrition.setCarbonhydrate(createNutrition.getCarbonhydrate());
		nutrition.setFat(createNutrition.getFat());
		nutrition.setKcal(createNutrition.getKcal());
		nutrition.setProtein(createNutrition.getProtein());
		
		for(NutritionType nutritionType:nutritionTypes) {
			if(createNutrition.getNutritionType()==nutritionType.getName()) {
				nutrition.setNutritionType(nutritionType);
			}
		}
		
		nutritionRepository.save(nutrition);
	}

	@Override
	public void delete(int id) {
		nutritionRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateNutrition updateNutrition) {
		Nutrition nutrition = new Nutrition();
		
		nutrition.setName(updateNutrition.getName());
		nutrition.setBaseWeight(updateNutrition.getBaseWeight());
		nutrition.setCarbonhydrate(updateNutrition.getCarbonhydrate());
		nutrition.setFat(updateNutrition.getFat());
		nutrition.setKcal(updateNutrition.getKcal());
		nutrition.setNutritionType(updateNutrition.getNutritionType());
		nutrition.setProtein(updateNutrition.getProtein());
		
		nutritionRepository.save(nutrition);
		
		
		
	}

}
