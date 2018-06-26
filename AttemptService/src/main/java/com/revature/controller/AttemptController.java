package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Attempt;
import com.revature.dto.AttemptDTO;
import com.revature.service.AttemptService;

@CrossOrigin
@RestController
@RequestMapping("/attempt")
public class AttemptController {

	@Autowired
	private AttemptService attemptService;
	
	@GetMapping("/{id}")
	public ResponseEntity<AttemptDTO> getAttemptById(@PathVariable int id) {
		return new ResponseEntity<AttemptDTO>(new AttemptDTO(attemptService.getAttemptById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/complete/{accountId}") 
	public ResponseEntity<List<AttemptDTO>> getCompleteAttemptsByAccountId(@PathVariable int accountId) {
		List<Attempt> completeAttempts = attemptService.getCompleteAttemptsByUser(accountId);
		List<AttemptDTO> attempts = new ArrayList<>();
		for (Attempt a: completeAttempts) {
			attempts.add(new AttemptDTO(a));
		}
		return new ResponseEntity<List<AttemptDTO>>(attempts, HttpStatus.OK);
	}
	
	@GetMapping("/incomplete/{accountId}")
	public ResponseEntity<List<AttemptDTO>> getIncompleteAttemptsByAccountId(@PathVariable int accountId) {
		List<Attempt> incompleteAttempts = attemptService.getCompleteAttemptsByUser(accountId);
		List<AttemptDTO> attempts = new ArrayList<>();
		for (Attempt a: incompleteAttempts) {
			attempts.add(new AttemptDTO(a));
		}
		return new ResponseEntity<List<AttemptDTO>>(attempts, HttpStatus.OK);
	}
	
	@GetMapping("/complete/{accountId}/{quizId}")
	public ResponseEntity<List<AttemptDTO>> getCompleteAttemptsByUserAndQuiz(@PathVariable int accountId, @PathVariable int quizId) {
		List<Attempt> completeAttempts = attemptService.getCompleteAttemptsByUserAndQuiz(accountId, quizId);
		List<AttemptDTO> attempts = new ArrayList<>();
		for (Attempt a: completeAttempts) {
			attempts.add(new AttemptDTO(a));
		}
		return new ResponseEntity<List<AttemptDTO>>(attempts, HttpStatus.OK);
	}
}
