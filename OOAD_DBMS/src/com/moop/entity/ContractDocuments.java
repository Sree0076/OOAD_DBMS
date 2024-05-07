package com.moop.entity;

import java.sql.Date;

public class ContractDocuments {
    int id;
    Contracts contract; 
    String documentName;
    String documentPath;
    Date uploadDate;
    Date updateDate;
    Employees uploadedBy;
    Employees updatedBy;
    
	public ContractDocuments(int id, Contracts contract, String documentName, String documentPath, Date uploadDate,
			Date updateDate, Employees uploadedBy, Employees updatedBy) {
		super();
		this.id = id;
		this.contract = contract;
		this.documentName = documentName;
		this.documentPath = documentPath;
		this.uploadDate = uploadDate;
		this.updateDate = updateDate;
		this.uploadedBy = uploadedBy;
		this.updatedBy = updatedBy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Contracts getContract() {
		return contract;
	}
	public void setContract(Contracts contract) {
		this.contract = contract;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Employees getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(Employees uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public Employees getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Employees updatedBy) {
		this.updatedBy = updatedBy;
	}
    
    
}
