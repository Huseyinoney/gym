package com.pinsoft.gym.service.responses;

import java.time.LocalDateTime;
import java.util.List;

import com.pinsoft.gym.model.Nutrition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealListGetAll {
	
	
	private String meal;
	private  List<Nutrition> nutrition;
	private Double weight;
	private LocalDateTime createdDate;
}
