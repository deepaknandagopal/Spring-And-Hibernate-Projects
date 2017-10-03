package com.example.springdemo;

public class TrackCoach implements Coach {

	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constant for the dependency Injection
    public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	    
	@Override
	public String getDailyWorkout() {
		return "Run 10 miles hard";
	}
	
	@Override
	public String getDiet() {
		return "2 Eggs, 1 chicken, green vegetables";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it ! :"+ fortuneService.getFortune();
	}
	
	
	//add the init and destory method
	
	public void doMyStartUpStuff() {
		System.out.println("initialize method");
	}

	public void doMyCleanUpStuff() {
		System.out.println("cleanup method");
	}
}
