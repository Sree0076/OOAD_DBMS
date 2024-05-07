package com.moop.entity;
import java.sql.Date;

public class Milestone
 {
	
    int id;
    Contracts contract; 
    int milestoneNo;
    Date startDate;
    Date endDate;
    double amount;
    String status;
    Date createDate;
    Date updateDate;
    Employees createdBy; 
    Employees updatedBy;
    
    
    
	public Milestone(int id, Contracts contract, int milestoneNo, Date startDate, Date endDate, double amount,
			String status, Date createDate, Date updateDate, Employees createdBy, Employees updatedBy) {
		super();
		this.id = id;
		this.contract = contract;
		this.milestoneNo = milestoneNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createdBy = createdBy;
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
	public int getMilestoneNo() {
		return milestoneNo;
	}
	public void setMilestoneNo(int milestoneNo) {
		this.milestoneNo = milestoneNo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Employees getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Employees createdBy) {
		this.createdBy = createdBy;
	}
	public Employees getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Employees updatedBy) {
		this.updatedBy = updatedBy;
	} 

    
}
