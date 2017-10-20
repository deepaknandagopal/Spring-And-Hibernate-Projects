package com.example.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String userInput, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		if(userInput != null)
		{
			for (String tempPrefix : coursePrefix) {
                result = userInput.startsWith(tempPrefix);
                
                // if we found a match then break out of the loop
                if (result) {
                    break;
                }
            }
		}
		else {
			return true;
		}
		return result;
	}

}
