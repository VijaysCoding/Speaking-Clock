package com.example.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clock.service.TimeService;

@RestController
@RequestMapping("/api/clock")
public class ClockController {
	
	@Autowired
	private TimeService service;
	
	@GetMapping("/now")
	public ResponseEntity<String> getNow(){
		return ResponseEntity.ok(service.nowInWords());
	}

}
