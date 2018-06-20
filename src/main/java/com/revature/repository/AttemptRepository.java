package com.revature.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
	public Attempt findAttemptbyUser(String email);
	public Attempt findAttemptbyId(int id);
}
