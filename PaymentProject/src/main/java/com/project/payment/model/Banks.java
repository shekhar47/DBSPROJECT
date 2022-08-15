package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity 
@Data
public class Banks {
	@Id
	@Column(name="bic")
	private String bic;
	@Column(name="bankname")
	@NotNull
	private String bankName;
	
	
	  public Banks() { // TODO Auto-generated constructor stub
		  }
	  
	  
	  public Banks(String bic, String bankname) { super(); this.bic = bic;
	  this.bankName = bankname; }
	  
	  public String getBic() { return bic; }
	  
	  public void setBic(String bic) { this.bic = bic; }
	  
	  public String getBankname() { return bankName; }
	  
	  public void setBankname(String bankname) { this.bankName = bankname; }
	  
	  @Override public String toString() { return "Banks [bic=" + bic +
	  ", bankname=" + bankName + "]"; }
	  
	 

}
