package com.example.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	//no-args constructor
	public CricketCoach() {
		System.out.println("CricketCoach : inside the no-args Constructor");
	}

	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : inside the setter method -setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice bowling and feilding for 30 mins";
	}

	@Override
	public String getDiet() {
		return "2 Eggs, 1 chicken, green vegetables";
	}

	@Override
	public String getDailyFortune() {
		return "From CricketCoach : "+ fortuneService.getFortune();
	}

}
