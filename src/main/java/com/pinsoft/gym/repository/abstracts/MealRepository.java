package com.pinsoft.gym.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
