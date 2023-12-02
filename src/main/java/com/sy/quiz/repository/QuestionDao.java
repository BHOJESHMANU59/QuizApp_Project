package com.sy.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.quiz.model.Questions;

@Repository
public class QuestionDao
{
	@Autowired
	private QuestionDaoRepository repo;
	
	public List<Questions> getAllQuestions()
	{
		List<Questions> findAll = repo.findAll();
		return findAll;
	}

	public List<Questions> getAllQuestionsbyCategory(String category)
	{
		return repo.findByCategory(category);
	}


	public String addQuestions(Questions quiz) 
	{
		Questions save = repo.save(quiz);
		return "Success Saved Data "+save;
	}

	

}
