package com.pinsoft.gym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="NutritionType")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NutritionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	 /*@OneToOne(mappedBy = "nutritionType")
	 private Nutrition nutrition;*/
}
