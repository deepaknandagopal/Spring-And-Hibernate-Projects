package com.example.springdemo;

public class BaseballCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a const for the dependency Injection
    public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDiet() {
		return "2 Eggs, 1 chicken, green vegetables";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
