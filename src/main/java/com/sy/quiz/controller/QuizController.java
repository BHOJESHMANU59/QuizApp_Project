package com.sy.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sy.quiz.model.Questions;
import com.sy.quiz.model.QuizQuestions;
import com.sy.quiz.model.Response;
import com.sy.quiz.service.QuizService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired
	private QuizService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
	{
		return service.createQuiz(category,numQ,title);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuizQuestions>> getQuizQuestions(@PathVariable int id)
	{
		return service.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses)
	{
		return service.calculateResult(id,responses);
	}

}
