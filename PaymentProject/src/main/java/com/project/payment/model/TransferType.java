package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transfertype")
public class TransferType {
	@Id
	@Column(name="transfertype")
	private String transferType;
	
	@Column(name="transfertypedescription")
	private String transferTypeDescription;
	
	public TransferType() {
		
	}
	public TransferType(String transfertype, String transfertypedescription) {
		super();
		this.transferType = transfertype;
		this.transferTypeDescription = transfertypedescription;
	}
	public String getTransfertype() {
		return transferType;
	}
	public void setTransfertype(String transfertype) {
		this.transferType = transfertype;
	}
	public String getTransfertypedescription() {
		return transferTypeDescription;
	}
	public void setTransfertypedescription(String transfertypedescription) {
		this.transferTypeDescription = transfertypedescription;
	}
	@Override
	public String toString() {
		return "TransferType [transfertype=" + transferType + ", transfertypedescription=" + transferTypeDescription
				+ "]";
	}
	
	

}
