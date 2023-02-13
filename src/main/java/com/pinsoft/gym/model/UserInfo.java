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
@Table(name="UserInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	@OneToOne(mappedBy = "userInfo")
    private User user;
    @Column(name="lenght")
    private Integer lenght;
    @Column(name="weight")
    private Double weight;
    @Column(name="age")
    private Integer age;
}
