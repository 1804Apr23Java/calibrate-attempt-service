package com.revature.dto;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Attempt;
import com.revature.service.AttemptService;

public class AttemptDTO {
	
	@Autowired
	private AttemptService attemptService;
	
	private int id;
	private int accountId;
	private int quizId;
	private Date dateCreated;
	private double score;
	private boolean isComplete;
	
	private Set<AttemptAnswerDTO> answers;
	
	public AttemptDTO(Attempt a) {
		this.id = a.getId();
		this.accountId = a.getAccountId();
		this.quizId = a.getQuizId();
		this.dateCreated = a.getDateCreated();
		this.score = a.getScore();
		this.isComplete = a.getIsComplete();		
		answers = attemptService.getAttemptAnswersByAttempt(a)
				.stream().map(e -> new AttemptAnswerDTO(e)).collect(Collectors.toSet());
	}

	public AttemptDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Set<AttemptAnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AttemptAnswerDTO> answers) {
		this.answers = answers;
	}
	
	
}
