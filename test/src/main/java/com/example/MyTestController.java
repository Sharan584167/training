package com.example;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String greet(){
		Calendar cal = Calendar.getInstance().getInstance();
		int hour = cal.get(Calendar.HOUR);
		return (hour<12)?"Good morning":"Good Afternoon";
	}
}
