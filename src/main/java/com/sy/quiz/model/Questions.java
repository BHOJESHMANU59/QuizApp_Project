package com.sy.quiz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Questions 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idquiz")
	private int idquiz;
	private String category;
	private String difficulty_level;
	private String questions;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String right_answer;

}
