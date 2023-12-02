package com.sy.quiz.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.quiz.model.Questions;
import com.sy.quiz.model.Quiz;
import com.sy.quiz.model.QuizQuestions;
import com.sy.quiz.model.Response;

@Repository
public class QuizDao 
{
	@Autowired
	private QuizDaoRepository repo;
	
	@Autowired
	private QuestionDaoRepository repoQ;

		public String findRandomQuestionsByCategory(String category, int numQ,String title) 
		{
	         List<Questions> questions=repoQ.findRandomQuestionsByCategory(category,numQ);
			
			Quiz quiz=new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			repo.save(quiz);
			
			return "Succusefully Created "+quiz ;
		}

		public List<QuizQuestions> getQuizQuestions(int id) 
		{
			Optional<Quiz> quiz = repo.findById(id);
			if(quiz.isPresent())
			{
				List<Questions> questions=quiz.get().getQuestions();
				List<QuizQuestions> quizQuestions=new ArrayList<>();
				for (Questions q: questions)
				{
					QuizQuestions quizQ=new QuizQuestions(q.getIdquiz(),q.getQuestions(),q.getOption1(),q.getOption2(), q.getOption3(),q.getOption4());
					quizQuestions.add(quizQ);
					
				}
				return quizQuestions;
			}
			return null;
		}

		public Integer calculateResult(int id, List<Response> responses) 
		{
			Optional<Quiz> quiz = repo.findById(id);
			if(quiz.isPresent())
			{
				Quiz q = quiz.get();
				List<Questions> questions=q.getQuestions();
				int right=0;
				int i=0;
				for (Response response : responses) 
				{
					if(response.getResponse().equals(questions.get(i).getRight_answer()))
					{
						right++;
					}
					i++;
					
				}
				return right;
			}
			return 0;
		}
}
