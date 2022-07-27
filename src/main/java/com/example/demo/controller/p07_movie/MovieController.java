package com.example.demo.controller.p07_movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@GetMapping
	public String  view() {
		return "p07_movie/movie";
	}

}
