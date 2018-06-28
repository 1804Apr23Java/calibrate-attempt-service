package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.revature.beans.Attempt;
import com.revature.service.AttemptService;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class AttemptServiceApplication implements CommandLineRunner {
	@Autowired
	private AttemptService attemptService;
	
	public static void main(String[] args) {
		SpringApplication.run(AttemptServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Attempt a = attemptService.addAttempt(new Attempt(69,420));
		System.out.println("attempt id = " + a.getId());
	}
}
