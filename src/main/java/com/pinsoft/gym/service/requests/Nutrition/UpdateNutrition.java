package com.pinsoft.gym.service.requests.Nutrition;

import com.pinsoft.gym.model.NutritionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNutrition {

	private String name;
    private Double kcal;
    private Double protein;
    private Double carbonhydrate;
    private Double fat;
    private NutritionType nutritionType;
    private Double baseWeight;
}
