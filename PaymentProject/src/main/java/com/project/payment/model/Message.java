package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@Column(name="messagecode")
	private String messageCode;
	
	@Column(name="instruction")
	private String instruction;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(String messagecode, String instruction) {
		super();
		this.messageCode = messagecode;
		this.instruction = instruction;
	}
	public String getMessagecode() {
		return messageCode;
	}
	public void setMessagecode(String messagecode) {
		this.messageCode = messagecode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Message [messagecode=" + messageCode + ", instruction=" + instruction + "]";
	}
	
	

}
