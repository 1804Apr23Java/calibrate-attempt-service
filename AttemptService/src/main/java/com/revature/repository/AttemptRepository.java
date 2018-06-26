package com.revature.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
	public Attempt findAttemptById(int id);
	public List<Attempt> findAttemptsByAccountId(int accountId);
	public List<Attempt> findAttemptsByAccountIdAndIsComplete(int accountId, boolean isComplete);
}
