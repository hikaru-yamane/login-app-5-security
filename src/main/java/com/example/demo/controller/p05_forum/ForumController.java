package com.example.demo.controller.p05_forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	@GetMapping
	public String  view() {
		return "p05_forum/forum";
	}

}
