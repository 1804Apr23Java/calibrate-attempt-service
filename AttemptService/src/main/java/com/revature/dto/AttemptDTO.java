package com.revature.dto;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import com.revature.beans.Attempt;

public class AttemptDTO {
	
	private int id;
	private int accountId;
	private int quizId;
	private Set<Integer> answers;
	private Date dateCreated;
	private double score;
	private boolean isComplete;
	
	public AttemptDTO(int id, int accountId, int quizId, Set<Integer> answers, Date dateCreated, double score, boolean isComplete) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.quizId = quizId;
		this.dateCreated = dateCreated;
		this.score = score;
		this.isComplete = isComplete;
	}
	
	public AttemptDTO(Attempt attempt) {
		super();
		this.id = attempt.getId();
		this.accountId = attempt.getAccountId();
		this.quizId = attempt.getQuizId();
		this.answers = attempt.getAttemptAnswers().stream().map(a -> a.getAnswerId()).collect(Collectors.toSet());
		this.dateCreated = attempt.getDateCreated();
		this.score = attempt.getScore();
		this.isComplete = attempt.getIsComplete();
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

	public Set<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Integer> answers) {
		this.answers = answers;
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
}
