package com.revature.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.beans.Attempt;
import com.revature.beans.AttemptAnswer;
import com.revature.dto.AttemptAnswerDTO;
import com.revature.dto.AttemptDTO;
import com.revature.service.AttemptService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AttemptControllerTest {
	
	@Autowired
	private AttemptService attemptService;
	
	@Test
	public void getAttemptByIdTest() throws JsonParseException, JsonMappingException, IOException {
		Attempt a = attemptService.addAttempt(new Attempt(55, 1));
		
		RestAssured.port = 8079;
		RequestSpecification request = RestAssured.given();	
		Response response = request.get("/attempt/" + a.getId());
			
		assertEquals(200, response.getStatusCode());
		
		AttemptDTO responseAttempt = new ObjectMapper().readValue(response.asString(), AttemptDTO.class);
		assertEquals(a.getId(), responseAttempt.getId());
		assertEquals(a.getDateCreated(), responseAttempt.getDateCreated());
		assertEquals(a.getQuizId(), responseAttempt.getQuizId());
		
		attemptService.deleteAttempt(a.getId());
	}
	
	@Test
	public void addAttemptTest() throws JsonParseException, JsonMappingException, IOException {
		
		RestAssured.port = 8079;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		AttemptDTO a = new AttemptDTO(new Attempt(42, 6969));
		request.body(a);
		Response response = request.post("/attempt/add");
		
		AttemptDTO responseDTO = new ObjectMapper().readValue(response.asString(), AttemptDTO.class);
		assertEquals(a.getAccountId(), responseDTO.getAccountId());
		assertEquals(a.getQuizId(), responseDTO.getQuizId());
		attemptService.deleteAttempt(responseDTO.getId());
	}
	
	@Test
	public void addAttemptAnswerTest() throws JsonParseException, JsonMappingException, IOException {
		Attempt a = attemptService.addAttempt(new Attempt(4940, 6960));
		
		RestAssured.port = 8079;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		AttemptAnswerDTO aDTO = new AttemptAnswerDTO(5, true, a.getId());
		request.body(aDTO);
		Response response = request.post("/attempt/add/attemptanswer");
		
		AttemptAnswerDTO responseAnswer = new ObjectMapper().readValue(response.asString(), AttemptAnswerDTO.class);
		assertEquals(aDTO.getAnswerId(), responseAnswer.getAnswerId());
		assertEquals(aDTO.getAttemptId(), responseAnswer.getAttemptId());
		
		attemptService.deleteAttemptAnswerById(responseAnswer.getId());
		attemptService.deleteAttempt(a.getId());
	}

	@Test
	public void getAttemptAnswersByAttemptIdTest() throws JsonParseException, JsonMappingException, IOException {
		Attempt a = attemptService.addAttempt(new Attempt(1234, 234));
		AttemptAnswer b = attemptService.addAttemptAnswer(new AttemptAnswer(a, 45, true));
		AttemptAnswer c = attemptService.addAttemptAnswer(new AttemptAnswer(a, 45, true));
		AttemptAnswer d = attemptService.addAttemptAnswer(new AttemptAnswer(a, 45, true));
		AttemptAnswer e = attemptService.addAttemptAnswer(new AttemptAnswer(a, 45, true));
		
		Set<AttemptAnswerDTO> s = new HashSet<>();
		s.add(new AttemptAnswerDTO(b));
		s.add(new AttemptAnswerDTO(c));
		s.add(new AttemptAnswerDTO(d));
		s.add(new AttemptAnswerDTO(e));
		
		RestAssured.port = 8079;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/attempt/attemptanswers/" + a.getId());
		
		Set<AttemptAnswerDTO> attemptAnswerResp = new ObjectMapper().readValue(response.asString(), HashSet.class);
		assertEquals(s.size(), attemptAnswerResp.size());
		
		attemptService.deleteAttemptAnswerById(b.getId());
		attemptService.deleteAttemptAnswerById(c.getId());
		attemptService.deleteAttemptAnswerById(d.getId());
		attemptService.deleteAttemptAnswerById(e.getId());
		attemptService.deleteAttempt(a.getId());
	}
	
}
