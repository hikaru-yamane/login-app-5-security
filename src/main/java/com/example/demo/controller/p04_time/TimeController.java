package com.example.demo.controller.p04_time;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/time")
public class TimeController {
	
	@GetMapping
	public String  view() {
		return "p04_time/time";
	}

}
