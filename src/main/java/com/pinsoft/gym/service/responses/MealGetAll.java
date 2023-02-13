package com.pinsoft.gym.service.responses;

import java.util.List;

import com.pinsoft.gym.model.MealList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealGetAll {
	private int id ;
	private String name;
	private List<MealList> mealList;
}
