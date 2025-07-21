package com.example.clock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.clock.exception.InvalidTimeFormatException;

public class TimeServiceImplTest {
	private TimeServiceImpl service = new TimeServiceImpl();
	
	@Test
	void testMidnight() {
		assertEquals("It's Midnight", service.convert("00:00"));
	}
	
	@Test
	void testMidday() {
		assertEquals("It's Midday", service.convert("12:00"));
	}
	
	@Test
	void testInvalidFormat() {
		assertThrows(InvalidTimeFormatException.class, () ->
		service.convert("25:61"));
	}

}
