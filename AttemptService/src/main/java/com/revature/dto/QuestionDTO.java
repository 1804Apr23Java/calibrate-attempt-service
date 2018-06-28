package com.revature.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


public class QuestionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2324070295258377882L;
	private Integer questionId;
	private String value;
	private Integer difficulty;
	private Integer libraryId;
	
	private Set<AnswerDTO> answers;
	
	public Set<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AnswerDTO> answers) {
		this.answers = answers;
	}

	public QuestionDTO() {
	}
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	
}
