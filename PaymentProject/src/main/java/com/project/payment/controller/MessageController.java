package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.MessageCodeNotFoundException;
import com.project.payment.model.Message;
import com.project.payment.service.MessageService;
@CrossOrigin("*")
@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/message/findbyid/{msg}")
	public Message findMessage(@PathVariable String msg) throws MessageCodeNotFoundException {
		return messageService.findMessage(msg);
	}
	

}
