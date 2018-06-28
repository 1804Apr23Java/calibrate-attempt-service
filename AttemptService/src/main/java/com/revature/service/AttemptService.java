package com.revature.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Attempt;
import com.revature.beans.AttemptAnswer;
import com.revature.repository.AttemptAnswerRepository;
import com.revature.repository.AttemptRepository;

@Service
@Transactional
public class AttemptService {

	@Autowired
	private AttemptRepository attemptRepository;
	
	@Autowired 
	private AttemptAnswerRepository attemptAnswerRepository;
	
	public Attempt getAttemptById(int id) {
		Attempt attempt = attemptRepository.findAttemptById(id);
		return attempt;
	}
	
	public List<Attempt> getAttemptsByUser(int accountId) {
		List<Attempt> attempts = attemptRepository.findAttemptsByAccountId(accountId);
		return attempts;
	}
	
	public List<Attempt> getCompleteAttemptsByUser(int accountId) {
		List<Attempt> attempts = attemptRepository.findAttemptsByAccountIdAndIsComplete(accountId, true);
		return attempts;
	}
	
	public List<Attempt> getIncompleteAttemptsByUser(int accountId) {
		List<Attempt> attempts = attemptRepository.findAttemptsByAccountIdAndIsComplete(accountId, false);
		return attempts;
	}
	
	public List<Attempt> getCompleteAttemptsByUserAndQuiz(int accountId, int quizId) {
		List<Attempt> attempts = attemptRepository.findAttemptsByAccountIdAndIsComplete(accountId, true);
		for (Attempt a : attempts) {
			if (a.getQuizId() != quizId) {
				attempts.remove(a);
			}
		}
		return attempts;
	}
	
	@Transactional
	public Attempt addAttempt(Attempt attempt) {
		return attemptRepository.save(attempt);
	}
	
	public Attempt updateAttempt(int id, double score) {
		Attempt attempt = attemptRepository.findAttemptById(id);
		attempt.setScore(score);
		return attempt;
	}
	
	public void deleteAttempt(int id) {
		attemptRepository.deleteById(id);
	}
	
	public Set<AttemptAnswer> getAttemptAnswersByAttempt(Attempt a) {
		return attemptAnswerRepository.findByAttempt(a);
	}
	
	public AttemptAnswer addAttemptAnswer(AttemptAnswer a) {
		return attemptAnswerRepository.save(a);
	}
	
	public void deleteAttemptAnswerById(int id) {
		attemptAnswerRepository.deleteById(id);
	}
}
