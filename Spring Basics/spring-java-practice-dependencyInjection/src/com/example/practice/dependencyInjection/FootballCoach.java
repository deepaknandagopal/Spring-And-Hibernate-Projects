package com.example.practice.dependencyInjection;

public class FootballCoach implements Coach{
	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on dribbling practice";
	}

	@Override
	public String getDiet() {
		return  "2 Eggs, 1 chicken, green vegetables";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
