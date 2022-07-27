package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.example.demo.service.p01_login.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	UserDetailsServiceImpl service;
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/authenticate").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/user").hasRole("ADMIN")
			.anyRequest().authenticated();
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
				.usernameParameter("email")
				.passwordParameter("password")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error=true");
		http.logout()
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/logout");
		http.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http.sessionManagement()
			.invalidSessionUrl("/login");
		http.exceptionHandling()
			.accessDeniedPage("/login");
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	UserDetailsServiceImpl service;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(service)
//			.passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/authenticate").permitAll()
//			.antMatchers("/logout").permitAll()
//			.antMatchers("/user").hasRole("ADMIN")
//			.anyRequest().authenticated();
//		http.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/authenticate")
//				.usernameParameter("email")
//				.passwordParameter("password")
//			.defaultSuccessUrl("/home")
//			.failureUrl("/login?error=true");
//		http.logout()
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID")
//			.logoutSuccessUrl("/logout");
//		http.csrf()
//			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		http.sessionManagement()
//			.invalidSessionUrl("/login");
//		http.exceptionHandling()
//			.accessDeniedPage("/login");
//	}
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
