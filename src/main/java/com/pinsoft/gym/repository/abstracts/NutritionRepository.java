package com.pinsoft.gym.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.Nutrition;

public interface NutritionRepository  extends JpaRepository<Nutrition, Integer> {

}
