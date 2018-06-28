package com.revature.dto;

public class AnswerDTO {
	
	private Integer answerId;
	private String value;
	private boolean isCorrect;
	private Integer questionId;
	
	public AnswerDTO() {}
	

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public AnswerDTO(Integer answerId, String value, boolean isCorrect, Integer questionId) {
		super();
		this.answerId = answerId;
		this.value = value;
		this.isCorrect = isCorrect;
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerDTO other = (AnswerDTO) obj;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		if (isCorrect != other.isCorrect)
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
