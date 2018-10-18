package com.springlearn.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")	//default scope -->singleton
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");	//--->1 .default constructor will print first.
	}
	
	// define my destroy method
	
	@PreDestroy			// Code will execute before bean is destored.(print:last)
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");		
	}
	
	// define my init method
	
	@PostConstruct		// Code will execute after constructor And after injection of dependencies.(print:after constructor)
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");		
	}
	
	// define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	//Constructor injection.
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
