/*
 * Implements MailSender Interface
 */
package com.metacube.SpringDemo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.SpringDemo.service.MailSender;

//@Component
//@Primary
public class MockMailSender implements MailSender{
	
	/**
	 * Send Mail
	 */
	@Override
	public String send() {
		return "Mock Mail!";
	}
}
