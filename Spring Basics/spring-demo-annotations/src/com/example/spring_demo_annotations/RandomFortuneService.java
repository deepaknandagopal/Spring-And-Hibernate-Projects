package com.example.spring_demo_annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data= {
			"Reward is waiting",
			"Using the intelligence may help you"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		int index = myRandom.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}
