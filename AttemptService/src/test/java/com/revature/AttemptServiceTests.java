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
@Sql("classpath:populatedb.sql")
@SpringBootTest
public class AttemptServiceTests {

	private AttemptRepository ar;
	
	@Autowired AttemptService as;
	
	@Test
	public void testInsertAttempt() {
		Attempt a = new Attempt(100, 100);
		as.addAttempt(a);
		assertNotNull(as.getAttemptsByUser(100));
	}
	
	@Test
	public void testUpdateAttempt() {
		as.updateAttempt(1, 100);
		assertEquals(100.00, as.getAttemptById(1).getScore(),0);
	}
	
	@Test
	public void testDeleteAttempt() {
		as.deleteAttempt(1);
		assertNull(as.getAttemptById(1));
	}
	
	@Test
	public void testGetAttemptById() {
		Attempt a = as.getAttemptById(2);
		assertEquals(2, a.getId());
	}
	
	@Test
	public void testGetCompleteAttemptsByUser() {
		List<Attempt> a = as.getCompleteAttemptsByUser(2);
		assertEquals(0, a.size());
	}
	
	@Test
	public void testGetIncompleteAttemptsByUser() {
		List<Attempt> a = as.getIncompleteAttemptsByUser(2);
		assertEquals(1, a.size());
	}
	
	@Test
	public void testGetCompleteAttemptsByUserAndQuiz() {
		List<Attempt> a = as.getCompleteAttemptsByUserAndQuiz(1, 20);
		assertEquals(1, a.size());
	}
}
