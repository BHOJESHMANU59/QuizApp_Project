package com.sy.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sy.quiz.model.Questions;
import com.sy.quiz.repository.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao dao;
	public ResponseEntity<List<Questions>> getAllQuestions()
	{
		try
		{
			return new ResponseEntity<>(dao.getAllQuestions(),HttpStatus.OK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Questions>> getAllQuestionsbyCategory(String category)
	{
		try
		{
			return new ResponseEntity<List<Questions>>( dao.getAllQuestionsbyCategory(category),HttpStatus.FOUND);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<List<Questions>>( new ArrayList<>(),HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<String> addQuestion(Questions quiz) 
	{
		
		return new ResponseEntity<String>(dao.addQuestions(quiz), HttpStatus.CREATED);
	}

}
