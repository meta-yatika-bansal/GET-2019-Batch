/*
 * Controller Class
 */
package com.metacube.SpringDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.SpringDemo.service.MailSender;

@RestController
public class MailController {

	private MailSender mailSender;

	/**
	 * Sets Mail as MockMail
	 * @param mailSender type of mail
	 */
	/*@Autowired
	public void setMail(@Qualifier("mockMailSender") MailSender mailSender){
		this.mailSender = mailSender;
	}*/

	/**
	 * Sets Mail as sendSMTP in case of configuration
	 * @param mailSender type of mail
	 */
	/*@Autowired
	public void setMail(@Qualifier("sendSMTP") MailSender mailSender){
		this.mailSender = mailSender;
	}*/

	/**
	 * Sets Mail as mockMailSender
	 * @param mockMailSender type of mail
	 */
	/*@Autowired
	public MailController(MailSender mockMailSender){
		this.mailSender = mockMailSender;
	}*/

	/**
	 * Sets Mail as sendSMTP
	 * @param mailSender type of mail
	 */
	/*@Autowired
	public MailController(@Qualifier("sendSMTP") MailSender mailSender){
		this.mailSender = mailSender;
	}*/

	/**
	 * Sets Mail as sendSMTP
	 * @param sendSMTP type of mail
	 */
	@Autowired
	public MailController(MailSender sendSMTP){
		this.mailSender = sendSMTP;
		System.out.println(send());
	}

	/**
	 * Sends the mail
	 * @return content of mail
	 */
	@RequestMapping("/Mail")
	public String send(){
		return mailSender.send();
	}
}
