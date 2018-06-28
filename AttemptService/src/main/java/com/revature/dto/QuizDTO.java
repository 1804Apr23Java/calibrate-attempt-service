package com.revature.dto;

import java.util.Set;

public class QuizDTO {
	private Integer quizId;
	private String name;
	private Set<QuestionDTO> questions;
	
	public QuizDTO() {
		super();
	}
	
	
	
	public Integer getQuizId() {
		return quizId;
	}



	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	
	public QuizDTO(Integer id, String name, Set<QuestionDTO> questions) {
		super();
		this.quizId = id;
		this.name = name;
		this.questions = questions;
	}

	public QuizDTO(Integer id, String name) {
		super();
		this.quizId = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<QuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<QuestionDTO> questions) {
		this.questions = questions;
	}
	
}
