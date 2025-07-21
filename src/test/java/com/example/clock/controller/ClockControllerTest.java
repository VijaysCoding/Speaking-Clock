package com.example.clock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.clock.service.TimeService;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClockController.class)
public class ClockControllerTest {
	@Autowired
	MockMvc mvc;
	
	@MockBean
	TimeService timeService;
	
	@Test
	void testNowEndPoint() throws Exception{
		given(timeService.nowInWords()).willReturn("It's Noon");
        mvc.perform(get("/api/clock/now"))
           .andExpect(status().isOk())
           .andExpect(content().string("It's Noon"));
	}

}
