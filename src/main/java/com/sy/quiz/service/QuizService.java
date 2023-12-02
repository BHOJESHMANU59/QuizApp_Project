package com.sy.quiz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sy.quiz.model.QuizQuestions;
import com.sy.quiz.model.Response;
import com.sy.quiz.repository.QuizDao;

@Service
public class QuizService 
{
	@Autowired
	private QuizDao dao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title)
	{
		
		return new ResponseEntity<>(dao.findRandomQuestionsByCategory(category,numQ,title),HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuizQuestions>> getQuizQuestions(int id) 
	{
		return new ResponseEntity<>(dao.getQuizQuestions(id),HttpStatus.FOUND);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) 
	{
		return new ResponseEntity<>(dao.calculateResult(id,responses),HttpStatus.OK);
	}
	

}
