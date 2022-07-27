package com.example.demo.entity.p01_login;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String roleName;
	
}
