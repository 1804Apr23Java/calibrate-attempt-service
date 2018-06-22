package com.revature.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private int quizId; //need Quiz object
	private HashSet<Integer> answers; //get from Quiz service
	private Date createdDate;
	private double score;

	public Attempt(int id, int accountId, int quizId, HashSet<Integer> answers) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.quizId = quizId;
		this.answers = answers;
	}

	public Attempt(int accountId, int quizId, HashSet<Integer> answers) {
		super();
		this.accountId = accountId;
		this.quizId = quizId;
		this.answers = answers;
	}

	public Attempt(int accountId, int quizId) {
		super();
		this.accountId = accountId;
		this.quizId = quizId;
		this.answers = new HashSet<Integer>();
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

	@Column(name = "")
	public void setAnswers(HashSet<Integer> answers) {
		this.answers = answers;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "SCORE")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
