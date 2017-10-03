package com.example.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today will be the happiest day of the week";
	}

}
