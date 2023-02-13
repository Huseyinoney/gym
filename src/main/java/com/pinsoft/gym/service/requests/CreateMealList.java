package com.pinsoft.gym.service.requests;

import java.time.LocalDateTime;
import java.util.List;

import com.pinsoft.gym.model.Nutrition;

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

