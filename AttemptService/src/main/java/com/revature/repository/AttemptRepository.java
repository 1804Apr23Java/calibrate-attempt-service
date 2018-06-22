package com.revature.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
	public Attempt findAttemptbyUser(String email);
	public Attempt findAttemptbyId(int id);
}
