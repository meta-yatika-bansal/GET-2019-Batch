/*
 * Implements MailSender Interface
 */
package com.metacube.SpringDemo.service.impl;

import org.springframework.stereotype.Component;

import com.metacube.SpringDemo.service.MailSender;

//@Component
public class SmtpMailSender implements MailSender{

	/**
	 * Send Mail
	 */
	@Override
	public String send() {
		return "SMTP Mail!";
	}
}
