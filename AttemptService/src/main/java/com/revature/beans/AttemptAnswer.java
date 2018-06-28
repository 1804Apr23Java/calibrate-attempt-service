package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.dto.AttemptAnswerDTO;

@Entity
@Table(name = "ATTEMPT_ANSWER")
public class AttemptAnswer {

	private Attempt attempt;
	private int id;
	private int answerId;
	private boolean isCorrect; //fetch from quiz service
	
	public AttemptAnswer() {
		super();
	}
	
	public AttemptAnswer(AttemptAnswerDTO a, Attempt att) {
		this.id = a.getId();
		this.answerId = a.getAnswerId();
		this.isCorrect = a.isCorrent();
		this.attempt = att;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attemptAnswerSequence")
	@SequenceGenerator(allocationSize = 1, name = "attemptAnswerSequence", sequenceName = "SQ_ATTEMPT_ANSWER_PK")
	@Column(name = "ATTEMPT_ANSWER_ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ATTEMPT_ID")
	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	@Column(name = "ANSWER_ID")
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	@Column(name = "ISCORRECT")
	public boolean getIsCorrect() {
		return isCorrect;
	}
	
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
