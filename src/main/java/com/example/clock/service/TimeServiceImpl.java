package com.example.clock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import com.example.clock.exception.InvalidTimeFormatException;

@Service
public class TimeServiceImpl implements TimeService{
	
	private static final String[] NUM_WORDS = {
			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
	        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
	        "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", 
	        "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", 
	        "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", 
	        "thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", 
	        "thirty nine", "forty", "forty one", "forty two", "forty three", "forty four", 
	        "forty five", "forty six", "forty seven", "forty eight", "forty nine", 
	        "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five", 
	        "fifty six", "fifty seven", "fifty eight", "fifty nine"
	};
	
	private String toWords(int hour, int minute) {
		if(hour == 0 && minute == 0) return "It's Midnight";
		if(hour == 12 && minute == 0) return "It's Midday";
		String h = NUM_WORDS[hour];
		if(minute == 0) {
			return "It's " + h + " o'clock";
		}
		String m = minute  < 10 ? " oh " + NUM_WORDS[minute] : " " + NUM_WORDS[minute];
		
		return "It's " + h + m;
	}

	@Override
	public String nowInWords() {
		LocalTime t = LocalTime.now();
		return toWords(t.getHour(), t.getMinute());
	}

	@Override
	public String convert(String hhmm) {
		try {
			LocalTime t = LocalTime.parse(hhmm, DateTimeFormatter.ofPattern("HH:mm"));
			return toWords(t.getHour(), t.getMinute());
		}catch(DateTimeParseException e) {
			throw new InvalidTimeFormatException("Invalid time: "+hhmm);
		}
	}

}
