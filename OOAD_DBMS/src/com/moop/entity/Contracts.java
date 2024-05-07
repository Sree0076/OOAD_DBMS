package com.moop.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Contracts {

	    int contractId;
	    Clients client;
	    Date startDate;
	    Date endDate;
	    double totalAmount;
	    double balanceAmount;
	    String status;
	    Date createDate;
	    Date updateDate;
	    Employees createdBy; 
	    Employees updatedBy;
	    String milestoneType;
	    
	    ArrayList<ContractDocuments> documents; 
	    ArrayList<Milestone> milestones;
	    
//public Contracts(int contractId, Clients client, Date startDate, Date endDate, double totalAmount,
//				double balanceAmount, String status, Date createDate, Date updateDate, Employees createdBy,
//				Employees updatedBy, String milestoneType, ArrayList<ContractDocuments> documents,
//				ArrayList<Milestone> milestones) {
//			super();
//			this.contractId = contractId;
//			this.client = client;
//			this.startDate = startDate;
//			this.endDate = endDate;
//			this.totalAmount = totalAmount;
//			this.balanceAmount = balanceAmount;
//			this.status = status;
//			this.createDate = createDate;
//			this.updateDate = updateDate;
//			this.createdBy = createdBy;
//			this.updatedBy = updatedBy;
//			this.milestoneType = milestoneType;
//			this.documents = documents;
//			this.milestones = milestones;
//		}
	    
		public Contracts(int contractId, Clients client, Date startDate, Date endDate, double totalAmount,
				double balanceAmount, String status, Date createDate, Date updateDate, Employees createdBy,
				Employees updatedBy, String milestoneType) {
			super();
			this.contractId = contractId;
			this.client = client;
			this.startDate = startDate;
			this.endDate = endDate;
			this.totalAmount = totalAmount;
			this.balanceAmount = balanceAmount;
			this.status = status;
			this.createDate = createDate;
			this.updateDate = updateDate;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
			this.milestoneType = milestoneType;
			this.documents = new ArrayList<>();
			this.milestones = new ArrayList<>();
		}
		public int getContractId() {
			return contractId;
		}
		public void setContractId(int contractId) {
			this.contractId = contractId;
		}
		public Clients getClient() {
			return client;
		}
		public void setClient(Clients client) {
			this.client = client;
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
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public double getBalanceAmount() {
			return balanceAmount;
		}
		public void setBalanceAmount(double balanceAmount) {
			this.balanceAmount = balanceAmount;
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
		public String getMilestoneType() {
			return milestoneType;
		}
		public void setMilestoneType(String milestoneType) {
			this.milestoneType = milestoneType;
		}
		public ArrayList<ContractDocuments> getDocuments() {
			return documents;
		}
		public void setDocuments(ArrayList<ContractDocuments> documents) {
			this.documents = documents;
		}
		public ArrayList<Milestone> getMilestones() {
			return milestones;
		}
		public void setMilestones(ArrayList<Milestone> milestones) {
			this.milestones = milestones;
		}
	    
	    
}
