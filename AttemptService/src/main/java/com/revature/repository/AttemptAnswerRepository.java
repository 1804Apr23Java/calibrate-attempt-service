package com.revature.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Attempt;
import com.revature.beans.AttemptAnswer;

public interface AttemptAnswerRepository extends JpaRepository<AttemptAnswer, Integer> {

	public Set<AttemptAnswer> findByAttempt(Attempt a);
	public void deleteByAttemptId(Integer id);
}
