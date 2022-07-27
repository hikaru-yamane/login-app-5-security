package com.example.demo.controller.p03_home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String  doGet() {
		return view();
	}
	
	@PostMapping
	public String  doPost() {
		return view();
	}
	
	@PostMapping("/time")
	public String  time() {
		return "redirect:/time";
	}
	
	@PostMapping("/forum")
	public String  forum() {
		return "redirect:/forum";
	}
	
	@PostMapping("/image")
	public String  image() {
		return "redirect:/image";
	}
	
	@PostMapping("/movie")
	public String  movie() {
		return "redirect:/movie";
	}
	
	@PostMapping("/user")
	public String  user() {
		return "redirect:/user";
	}
	
	private String view() {
		return "p03_home/home";
	}

}
