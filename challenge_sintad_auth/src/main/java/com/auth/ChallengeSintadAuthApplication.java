package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.auth.security.JWTAuthorizationFilter;

@SpringBootApplication
public class ChallengeSintadAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSintadAuthApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@EnableWebSecurity
	@Configuration
	class SecurityConfig extends WebSecurityConfigurerAdapter {

		private UserDetailsService jwtUserDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/login").permitAll()
					.antMatchers(HttpMethod.POST, "/register").permitAll()
					.anyRequest()
					.authenticated();
		}
	}
}