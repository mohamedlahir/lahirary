//package com.one.project.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests().antMatchers("/api/login").permitAll().anyRequest().authenticated()
////				.and().addFilter(new JwtAuthenticationFilter(authenticationManager())).sessionManagement()
////				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////	}
//
//}	