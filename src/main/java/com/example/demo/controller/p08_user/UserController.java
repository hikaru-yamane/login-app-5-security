package com.example.demo.controller.p08_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.common.CompleteForm;
import com.example.demo.form.p08_user.UserForm;
import com.example.demo.service.p08_user.UserService;
import com.example.demo.validation.p08_user.ValidatorSequence;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public UserForm setUpUserForm() {
		return new UserForm();
	}

	@GetMapping
	public String  view() {
		return "p08_user/user";
	}
	
	@PostMapping("/register")
	public String  register(@Validated({ValidatorSequence.class}) UserForm form, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return view();
		}
		String name = form.getName();
		String email = form.getEmail();
		String password = passwordEncoder.encode(form.getPassword());
		try {
			boolean success = service.registerUser(name, email, password);
			if (!success) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			form.setDoubleEmailError(true);
			redirect.addFlashAttribute("userForm", form);
			return "redirect:/user";
		}
		CompleteForm completeForm = new CompleteForm();
		completeForm.setMessage("ユーザを登録しました。");
		redirect.addFlashAttribute("completeForm", completeForm);
		return "redirect:/complete";
	}

}
