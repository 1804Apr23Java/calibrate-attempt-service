package com.revature.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ATTEMPT")
public class Attempt {
	
	private int id;
	private int accountId;
	private int quizId; 
	private Set<AttemptAnswer> attemptAnswers;
	private Date dateCreated;
	private double score;
	private boolean isComplete;

	public Attempt(int id, int accountId, int quizId, Set<AttemptAnswer> attemptAnswers, double score, boolean isComplete) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.quizId = quizId;
		this.attemptAnswers = attemptAnswers;
	}

	public Attempt(int accountId, int quizId, Set<AttemptAnswer> attemptAnswers) {
		super();
		this.accountId = accountId;
		this.quizId = quizId;
		this.attemptAnswers = attemptAnswers;
	}

	public Attempt(int accountId, int quizId) {
		super();
		this.accountId = accountId;
		this.quizId = quizId;
		this.attemptAnswers = new HashSet<AttemptAnswer>();
	}
	
	public Attempt() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attemptSequence")
	@SequenceGenerator(allocationSize = 1, name = "attemptSequence", sequenceName = "SQ_ATTEMPT_PK")
	@Column(name = "ATTEMPT_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ACCOUNT_ID")
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int id) {
		this.accountId = id;
	}

	@Column(name = "QUIZ_ID")
	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	
	@OneToMany
	public Set<AttemptAnswer> getAttemptAnswers() {
		return attemptAnswers;
	}
	
	public void setAttemptAnswers(Set<AttemptAnswer> attemptAnswers) {
		this.attemptAnswers = attemptAnswers;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "DATE_CREATED", updatable = false)
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "SCORE")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Column(name = "ISCOMPLETE")
	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
}
