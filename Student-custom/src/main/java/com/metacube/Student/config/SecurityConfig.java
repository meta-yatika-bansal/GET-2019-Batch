/*
 * Configuration Class
 */
package com.metacube.Student.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.metacube.Student.utils.SecurityProvider;
import com.metacube.Student.utils.UseDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Autowired
	private SecurityProvider provider;
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(provider);
	}
	
	@Override
	protected void configure(final HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/**").authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/home",true)
		.failureUrl("/login?error=true")
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
