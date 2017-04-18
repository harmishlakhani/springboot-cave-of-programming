package com.github.harmishlakhani.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeRequests()
				.antMatchers("/",
							 "/js/*",
							 "/css/*",
							 "/img/*"
							)
				.permitAll()
			.anyRequest()
				.authenticated()
		.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
		.and()
			.logout()
			.permitAll();
		//@formatter:on
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		auth
			.inMemoryAuthentication()
			.withUser("harmish")
			.password("lakhani")
			.roles("USER");
		//@formatter:on
	}
}
