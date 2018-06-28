package com.revature.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Attempt;
import com.revature.beans.AttemptAnswer;

import com.revature.dto.AttemptAnswerDTO;
import com.revature.dto.AttemptDTO;

import com.revature.service.AttemptService;

@CrossOrigin
@RestController
public class AttemptController {

	@Autowired
	private AttemptService attemptService;
	
	@GetMapping("/{id}")
	public ResponseEntity<AttemptDTO> getAttemptById(@PathVariable int id) {
		return new ResponseEntity<AttemptDTO>(new AttemptDTO(attemptService.getAttemptById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/attemptanswers/{id}")
	public ResponseEntity<Set<AttemptAnswerDTO>> getAttemptAnswersByAttemptId(@PathVariable int id) {
		Set<AttemptAnswer> a = attemptService.getAttemptAnswersByAttempt(attemptService.getAttemptById(id));
		return new ResponseEntity<Set<AttemptAnswerDTO>>(a.stream().map(at -> new AttemptAnswerDTO(at)).collect(Collectors.toSet()), HttpStatus.OK);
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
	
	@PostMapping(path ="/add")
	public ResponseEntity<AttemptDTO> addAttempt(@RequestBody AttemptDTO attempt) {
		Attempt a = attemptService.addAttempt(new Attempt(attempt));
		return new ResponseEntity<AttemptDTO>(new AttemptDTO(a), HttpStatus.OK);
	}
	
	@PostMapping("/add/attemptanswer")
	public ResponseEntity<AttemptAnswerDTO> addAttemptAnswer(@RequestBody AttemptAnswerDTO attemptAnswser) {
		Attempt att = attemptService.getAttemptById(attemptAnswser.getAttemptId());
		AttemptAnswer a = attemptService.addAttemptAnswer(new AttemptAnswer(attemptAnswser, att));
		return new ResponseEntity<AttemptAnswerDTO>(new AttemptAnswerDTO(a), HttpStatus.OK);
	}
}
