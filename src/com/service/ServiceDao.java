package com.service;

import java.util.ArrayList;

import com.beans.Customer;
import com.beans.TaxDetails;
import com.dao.Dao;

public class ServiceDao 
{
	public boolean addCustomer(Customer custobj)
	{
		return new Dao().addCustomer(custobj);
	}
	
	public boolean addTaxDetails(TaxDetails taxobj)
	{
		return new Dao().addTaxDetails(taxobj);
	}
	
	public ArrayList<Customer> getCustomers()
	{
		return new Dao().getCustomers();
	}
	
	public ArrayList<TaxDetails> getTaxDetails()
	{
		return new Dao().getTaxDetails();
	}
	
	public TaxDetails getTaxDetailById (int customerId)
	{
		return new Dao().getTaxDetailById(customerId);
	}
	
	public Customer getCustomerById(int customerId)
	{
		return new Dao().getCustomerById(customerId);
	}
	
	public TaxDetails getTaxDetailsByYear(int customerId, String financialyear)
	{
		return new Dao().getTaxDetailsByYear(customerId, financialyear);
	}
}
