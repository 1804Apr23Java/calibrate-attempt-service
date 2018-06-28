package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Attempt;
import com.revature.repository.AttemptRepository;
import com.revature.service.AttemptService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AttemptServiceTests {

	
	
	@Autowired
	AttemptService attemptService;
	
	@Test
	public void testInsertAttempt() {
		Attempt a = new Attempt(100, 100);
		Attempt b = attemptService.addAttempt(a);
		// assertNotNull(attemptService.getAttemptsByUser(100));
		assertEquals(100, b.getAccountId());
	}
	
	@Test
	public void testUpdateAttempt() {
		Attempt a = new Attempt(100, 100);
		Attempt b = attemptService.addAttempt(a);
		attemptService.updateAttempt(b.getId(), 100);		
		assertEquals(100.00, attemptService.getAttemptById(b.getId()).getScore(), 0);
	}
	
	@Test
	public void testDeleteAttempt() {
		Attempt a = new Attempt(100, 100);
		Attempt b = attemptService.addAttempt(a);
		attemptService.deleteAttempt(b.getId());
		assertNull(attemptService.getAttemptById(b.getId()));
	}

	@Test
	public void testGetAttemptById() {
		Attempt a = new Attempt(100, 100);
		Attempt b = attemptService.addAttempt(a);
		Attempt c = attemptService.getAttemptById(b.getId());
		assertEquals(b.getAccountId(), c.getAccountId());
	}

	@Test
	public void testGetCompleteAttemptsByUser() {
			
		attemptService.addAttempt(new Attempt(100, 1,true));
		attemptService.addAttempt( new Attempt(100, 2,true));
		attemptService.addAttempt( new Attempt(100, 3,true));		
		List<Attempt> userAttempts = attemptService.getCompleteAttemptsByUser(100);
		assertEquals(3, userAttempts.size());
	}

	@Test
	public void testGetIncompleteAttemptsByUser() {
		attemptService.addAttempt(new Attempt(101, 1));
		attemptService.addAttempt(new Attempt(101, 2));
		attemptService.addAttempt(new Attempt(101, 3));
		List<Attempt> userAttempts = attemptService.getIncompleteAttemptsByUser(101);
		assertEquals(3, userAttempts.size());
	}

	@Test
	public void testGetCompleteAttemptsByUserAndQuiz() {
		attemptService.addAttempt(new Attempt(102, 1,true));
		List<Attempt> a = attemptService.getCompleteAttemptsByUserAndQuiz(102, 1);
		assertEquals(1, a.size());
	}
	@Test
	public void testGetInCompleteAttemptsByUserAndQuiz() {
		attemptService.addAttempt(new Attempt(103, 1));
		List<Attempt> a = attemptService.getIncompleteAttemptsByUser(103);
		assertEquals(1, a.size());
	}
	
	
	
}
