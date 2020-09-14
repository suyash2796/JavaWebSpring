package com.beans;

import java.util.ArrayList;

public class Customer 
{
	private int customerId;
	private String customerName;
	
	private ArrayList<TaxDetails> taxDetailList;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ArrayList<TaxDetails> getTaxDetailList() {
		return taxDetailList;
	}

	public void setTaxDetailList(ArrayList<TaxDetails> taxDetailList) {
		this.taxDetailList = taxDetailList;
	}

	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	
	
	
}
