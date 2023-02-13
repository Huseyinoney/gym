package com.pinsoft.gym.service.requests.Nutrition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNutrition {

	private String name;
    private Double kcal;
    private Double protein;
    private Double carbonhydrate;
    private Double fat;
    private String nutritionType;
    private Double baseWeight;
}
