package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Attempt;
import com.revature.repository.AttemptRepository;

public class AttemptService {

	@Autowired
	private AttemptRepository attemptRepository;
	
	public Attempt getAttemptById(int id) {
		Attempt attempt = attemptRepository.findAttemptbyId(id);
		return attempt;
	}
	
	public Attempt getAttemptByUser(String email) {
		Attempt attempt = attemptRepository.findAttemptbyUser(email);
		return attempt;
	}
	
	public Attempt addAttempt(Attempt attempt) {
		return attempt = attemptRepository.save(attempt);
	}
	
	public Attempt updateAttempt(int id, double score) {
		Attempt attempt = attemptRepository.findAttemptbyId(id);
		attempt.setScore(score);
		return attempt;
	}
	
	public void deleteAttempt(Attempt attempt) {
		attemptRepository.delete(attempt);
	}
}
