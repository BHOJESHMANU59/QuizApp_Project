package com.sy.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sy.quiz.model.Questions;

public interface QuestionDaoRepository extends JpaRepository<Questions, Integer>
{
	public List<Questions> findByCategory(String category);
	
	@Query(value = "SELECT * FROM questions q WHERE q.category=?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	public List<Questions> findRandomQuestionsByCategory(String category, int numQ);



}
