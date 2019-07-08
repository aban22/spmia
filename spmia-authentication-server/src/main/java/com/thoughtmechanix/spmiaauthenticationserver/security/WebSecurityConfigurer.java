package com.thoughtmechanix.spmiaauthenticationserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//TODO => Search example auth.jdbcAuthentication()
		auth
			.inMemoryAuthentication()
				.withUser("john.carnell").password(passwordEncoder.encode("password1")).roles("USER")
				.and()
				.withUser("william.woodward").password(passwordEncoder.encode("password2")).roles("USER", "ADMIN");
	}
}
