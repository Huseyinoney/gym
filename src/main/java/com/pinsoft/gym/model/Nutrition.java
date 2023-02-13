package com.pinsoft.gym.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="Nutrition")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nutrition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	@Column(name="name")
    private String name;
    
	@Column(name="kcal")
    private Double kcal;
    
	@Column(name="protein")
    private Double protein;
    
	@Column(name="carbonhydrate")
    private Double carbonhydrate;
    
	@Column(name="fat")
    private Double fat;
	@OneToOne
    @JoinColumn(name="nutrition_type_id")
    private NutritionType nutritionType;
    
	@Column(name="baseWeight")
    private Double baseWeight;
	
	/*@OneToMany(mappedBy = "nutrition")
    private List<MealList> mealList;*/
}
