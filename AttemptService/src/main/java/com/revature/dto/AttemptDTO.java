package com.revature.dto;

import java.util.Date;

import com.revature.beans.Attempt;

public class AttemptDTO {
	
	private int attemptId;
	private int accountId;
	private int quizId;
	private Date dateCreated;
	private double score;
	
	public AttemptDTO(int attemptId, int accountId, int quizId, Date dateCreated, double score) {
		super();
		this.attemptId = attemptId;
		this.accountId = accountId;
		this.quizId = quizId;
		this.dateCreated = dateCreated;
		this.score = score;
	}
	
	public AttemptDTO(Attempt attempt) {
		// TODO Auto-generated constructor stub
	}
	
	public AttemptDTO() {
		super();
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
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
}
