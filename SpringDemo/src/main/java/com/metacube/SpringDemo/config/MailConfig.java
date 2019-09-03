/*
 * Configuration File
 */
package com.metacube.SpringDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.SpringDemo.service.MailSender;
import com.metacube.SpringDemo.service.impl.MockMailSender;
import com.metacube.SpringDemo.service.impl.SmtpMailSender;

@Configuration
public class MailConfig {
	
	/**
	 * Returns Object of SmtpMailSender
	 * @return Object
	 */
	@Bean
	public MailSender sendSMTP(){
		return new SmtpMailSender();
	}

	/**
	 * Returns Object of MockMailSender
	 * @return Object
	 */
	@Bean
	public MailSender sendMock(){
		return new MockMailSender();
	}
	
	/**
	 * Returns Object of MockMailSender as primary
	 * @return Object
	 */
	/*@Bean
	@Primary
	public MailSender sendMock(){
		return new MockMailSender();
	}*/
}