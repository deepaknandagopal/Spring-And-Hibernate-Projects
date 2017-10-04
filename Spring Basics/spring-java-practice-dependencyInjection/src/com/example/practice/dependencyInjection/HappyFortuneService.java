package com.example.practice.dependencyInjection;

import java.util.ArrayList;

public class HappyFortuneService implements FortuneService {
	
	ArrayList<String> fortunes = new ArrayList<String>();
	
	public HappyFortuneService() {
		fortunes.add("Today will be the happiest day of the week");
		fortunes.add("New Journey awaits");
		fortunes.add("More concentration is needed for the success");
	}
	

	@Override
	public String getFortune() {
		return fortunes.get((int) (Math.random()*3));
	}

}
