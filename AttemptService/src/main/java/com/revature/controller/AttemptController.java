package com.revature.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

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
	
	@PostMapping(path ="/add")
	public ResponseEntity<AttemptDTO> addAttempt(@RequestBody AttemptDTO attempt) {
		Attempt a = attemptService.addAttempt(new Attempt(attempt));
		/*
		 * Set<AnswerDTO> ansd = new HashSet<AnswerDTO>();
		answerService.getAnswersByQuestion(q).forEach((etd) -> {
			ansd.add(new AnswerDTO(etd));
		});
		 */	
		
		Set<AttemptAnswerDTO> aDTOAnswers = new HashSet<AttemptAnswerDTO>();
		attemptService.getAttemptAnswersByAttempt(a).forEach((atd) -> {
			aDTOAnswers.add(new AttemptAnswerDTO(atd));
		});
				
		Set<AttemptAnswer> aAnswers = new HashSet<AttemptAnswer>();
		for(AttemptAnswerDTO aDTO : aDTOAnswers) {
			aAnswers.add(new AttemptAnswer(aDTO, a));
		}
		
		a.setAttemptAnswers(aAnswers);
		attemptService.addAttempt(a);
		
		//a.setAttemptAnswers(aAnswers.stream().map(a->new AttemptAnswerDTO(a).collect(Collectors.toSet());
		System.out.println(a.toString());
		AttemptDTO aDTO = new AttemptDTO(a);
		return new ResponseEntity<AttemptDTO>(aDTO, HttpStatus.OK);
	}
	
}
