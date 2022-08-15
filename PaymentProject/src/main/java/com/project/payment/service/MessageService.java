package com.project.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payment.exception.MessageCodeNotFoundException;
import com.project.payment.model.Message;
import com.project.payment.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	public Message findMessage(String msg) throws MessageCodeNotFoundException {
		Optional<Message> result= messageRepository.findById(msg);
		if(result.isEmpty()) throw new MessageCodeNotFoundException("Incorrect Message code!/nMessage code not found ");
		
		return result.get();
		
	}
	
	

}
