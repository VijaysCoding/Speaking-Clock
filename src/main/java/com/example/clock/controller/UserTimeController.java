package com.example.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clock.service.TimeService;

@RestController
@RequestMapping("/api/clock")
public class UserTimeController {
	@Autowired
	private TimeService service;
	
	@GetMapping("/convert")
	public ResponseEntity<String> convert(@RequestParam("time") String time){
		return ResponseEntity.ok(service.convert(time));
	}

}
