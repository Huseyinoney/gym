package com.pinsoft.gym.service.requests.MealList;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMealList {

	 private String meal;
	 private List<String> nutrition;
	 private Double weight;	
	 private LocalDateTime createdDate;
	}

