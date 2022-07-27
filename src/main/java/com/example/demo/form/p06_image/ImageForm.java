package com.example.demo.form.p06_image;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageForm {
	private MultipartFile image;
}
