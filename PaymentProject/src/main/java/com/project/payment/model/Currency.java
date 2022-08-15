package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Currency {
	@Id
	@Column(name="currencycode")
	private String currencyCode;
	
	@Column(name="currencyname")
	private String currencyName;
	
	@Column(name="conversionrate")
	private double conversionRate;
	public Currency() {
		// TODO Auto-generated constructor stub
	}
	
	public Currency(String currencyname, double conversionrate) {
		super();
		this.currencyName = currencyname;
		this.conversionRate = conversionrate;
	}
	public String getCurrencycode() {
		return currencyCode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencyCode = currencycode;
	}
	public String getCurrencyname() {
		return currencyName;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyName = currencyname;
	}
	public double getConversionrate() {
		return conversionRate;
	}
	public void setConversionrate(double conversionrate) {
		this.conversionRate = conversionrate;
	}
	@Override
	public String toString() {
		return "Currency [currencycode=" + currencyCode + ", currencyname=" + currencyName + ", conversionrate="
				+ conversionRate + "]";
	}
	

}
