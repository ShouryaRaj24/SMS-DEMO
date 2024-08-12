package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.SMSSendRequest;
import com.demo.service.SMSService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SMSRestController {
	
	@Autowired
	SMSService smsSevice;

	@PostMapping("/processSMS")
	public String processSMS(@RequestBody SMSSendRequest sendRequest) {
		
		log.info("processSMS started sendRequest: "+sendRequest.toString());
		return smsSevice.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessage());
	}
}
