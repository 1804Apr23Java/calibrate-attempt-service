package com.revature.dto;

import java.util.Date;
import java.util.Set;

import com.revature.beans.Attempt;

public class AttemptDTO {
	
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
		this.score = a.getScore();
		this.isComplete = a.getIsComplete();
		this.dateCreated = a.getDateCreated();
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

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Set<AttemptAnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AttemptAnswerDTO> answers) {
		this.answers = answers;
	}
	
	
}
