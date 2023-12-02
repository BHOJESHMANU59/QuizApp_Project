package com.sy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sy.quiz.model.Quiz;

public interface QuizDaoRepository extends JpaRepository<Quiz, Integer>
{

}
