package com.pinsoft.gym.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.MealList;

public interface MealListRepository extends JpaRepository<MealList, Integer> {

}
