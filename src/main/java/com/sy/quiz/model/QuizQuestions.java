package com.sy.quiz.model;

import lombok.Data;

@Data
public class QuizQuestions 
{
	private int idquiz;
	private String questions;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

	public QuizQuestions(int idquiz, String questions, String option1, String option2, String option3,
			String option4) {
		super();
		this.idquiz = idquiz;
		this.questions = questions;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	

}
