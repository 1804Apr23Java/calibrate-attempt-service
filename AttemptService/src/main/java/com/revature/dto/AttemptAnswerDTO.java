package com.revature.dto;

import com.revature.beans.AttemptAnswer;

public class AttemptAnswerDTO {
	
	private int id;
	private int answerId;
	private boolean isCorrent;
	
	
	
	public AttemptAnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AttemptAnswerDTO(AttemptAnswer a) {
		this.id = a.getId();
		this.answerId = a.getAnswerId();
		this.isCorrent = a.getIsCorrect();
	}
	
	public AttemptAnswerDTO(int id, int answerId, boolean isCorrent) {
		super();
		this.id = id;
		this.answerId = answerId;
		this.isCorrent = isCorrent;
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
	public boolean isCorrent() {
		return isCorrent;
	}
	public void setCorrent(boolean isCorrent) {
		this.isCorrent = isCorrent;
	}

	

}
