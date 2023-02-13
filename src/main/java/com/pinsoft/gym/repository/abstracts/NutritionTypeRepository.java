package com.pinsoft.gym.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.NutritionType;

public interface NutritionTypeRepository extends JpaRepository<NutritionType, Integer> {

}
