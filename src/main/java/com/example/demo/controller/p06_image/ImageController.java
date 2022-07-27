package com.example.demo.controller.p06_image;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.common.CompleteForm;
import com.example.demo.form.p06_image.ImageForm;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@GetMapping
	public String  view() {
		return "p06_image/image";
	}
	
	@PostMapping("/register")
	public String  register(ImageForm form, RedirectAttributes redirect) throws IOException {
		String contentType = form.getImage().getContentType();
		byte[] byteArray = form.getImage().getBytes();
		String base64 = Base64.getEncoder().encodeToString(byteArray);
		String imageSrc = "data:" + contentType + ";base64," + base64;
		
		CompleteForm completeForm = new CompleteForm();
		completeForm.setMessage("画像を登録しました。");
		completeForm.setImageSrc(imageSrc);
		redirect.addFlashAttribute("completeForm", completeForm);
		
		return "redirect:/complete";
	}

}
