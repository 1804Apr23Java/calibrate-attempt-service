package com.revature.dto;

import com.revature.beans.AttemptAnswer;

public class AttemptAnswerDTO {
	
	private int id;
	private int answerId;
	private boolean isCorrect;
	private Integer attemptId;
	
	
	
	public AttemptAnswerDTO(int answerId, boolean isCorrect, Integer attemptId) {
		super();
		this.answerId = answerId;
		this.isCorrect = isCorrect;
		this.attemptId = attemptId;
	}

	public Integer getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(Integer attemptId) {
		this.attemptId = attemptId;
	}

	public AttemptAnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AttemptAnswerDTO(AttemptAnswer a) {
		this.id = a.getId();
		this.answerId = a.getAnswerId();
		this.isCorrect = a.getIsCorrect();
		this.attemptId = a.getAttempt().getId();
	}
	
	public AttemptAnswerDTO(int id, int answerId, boolean isCorrent) {
		super();
		this.id = id;
		this.answerId = answerId;
		this.isCorrect = isCorrent;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	

}
