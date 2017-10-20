package com.example.spring_demo_annotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is very unlucky for you";
	}

}
