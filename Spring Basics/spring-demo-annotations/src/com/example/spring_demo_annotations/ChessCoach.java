package com.example.spring_demo_annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ChessCoach implements Coach {

	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.phoneNo}")
    private String phoneNo;	
	
	public ChessCoach() {
		System.out.println("Inside the default constructor");
	}
	
	//define the init and destroy method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("This is inside startupstuff()");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("This is inside Cleanupstuff()");
	}
	
//  Constructor Injection	
//	@Autowired
//	public ChessCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//	Setter Injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public String getPhoneNo() {
		return phoneNo;
	}


	@Override
	public String getDailyWorkout() {
		return "Play memory games for 10 mins to improve the memory";
	}
	

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


	public String getEmail() {
		return email;
	}
	
}
