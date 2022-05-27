package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.auth.handler.LoginSucessHandler;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled = true)

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private com.example.serviceimpl.JpaUserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private LoginSucessHandler sucessHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
			.antMatchers("/user/**").permitAll()
			.antMatchers("/home/**").access("hasRole('ROLE_USER')")
			.antMatchers("/myProducts/**").access("hasRole('ROLE_USER')")
			.antMatchers("/product/**").access("hasRole('ROLE_USER')")
			.antMatchers("/purchase/**").access("hasRole('ROLE_USER')")
			//.antMatchers("/ejemplo/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			.and().formLogin()
			.successHandler(sucessHandler).loginPage("/login").loginProcessingUrl("/login")
			.defaultSuccessUrl("/home").permitAll()
			.and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll()
			.and().exceptionHandling().accessDeniedPage("/error_403");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}