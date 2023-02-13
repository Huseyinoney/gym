package com.pinsoft.gym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MealList")
public class MealList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	@ManyToOne
    @JoinColumn(name="meal_id")
    private Meal meal;
	 @OneToMany
	 @JoinColumn(name="nutrition_id")
    private List<Nutrition> nutrition;
	@Column(name="weight")
    private Double weight;
	@Column(name="time")
    private LocalDateTime createdDate;
}
