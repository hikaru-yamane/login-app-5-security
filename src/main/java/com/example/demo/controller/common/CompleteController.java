package com.example.demo.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.common.CompleteForm;

@Controller
@RequestMapping("/complete")
public class CompleteController {
	
	@GetMapping
	public String  view(CompleteForm form) {
		return "common_page/complete";
	}

}
