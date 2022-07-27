package com.example.demo.controller.p02_logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@GetMapping
	public String view() {
		return "p02_logout/logout";
	}
	
	@PostMapping("/login")
	public String  login() {
		return "redirect:/login";
	}

}
