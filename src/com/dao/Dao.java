package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Customer;
import com.beans.TaxDetails;
import com.util.DatabaseUtil;

public class Dao 
{
	/*
	 * Legend
	 * 1. 	public boolean addCustomer(Customer custobj)
	 * 2.	public boolean addTaxDetails(TaxDetails taxobj)
	 * 
	 */
	
	//######################################1. 	public boolean addCustomer(Customer custobj)########################################################################
	public boolean addCustomer(Customer custobj)
	{
		Connection cn = null;
		PreparedStatement ps = null;
		//PreparedStatement ps2 = null;
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("insert into Customer_1418560 values (?,?)");
			ps.setInt(1, custobj.getCustomerId());
			ps.setString(2, custobj.getCustomerName());
			
			int rows_affected = ps.executeUpdate();
			
			if(rows_affected>0)
			{
				return true;
			}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		return false;
	}
	
	

	//###########################################2. public boolean addTaxDetails(TaxDetails taxobj)###################################################################
	
	public boolean addTaxDetails(TaxDetails taxobj)
	{
		Connection cn = null;
		PreparedStatement ps = null;
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("insert into Tax_Details_1418560 values (?,taxpin.nextval,?,?,?,?)");
	
			ps.setInt(1, taxobj.getCustomerId());
			ps.setInt(2, taxobj.getGrossIncome());
			ps.setInt(3, taxobj.getTaxableIncome());
			ps.setInt(4, taxobj.getTotalTaxPayable());
			ps.setString(5, taxobj.getFinancialYear());
			
	
			int rows_affected = ps.executeUpdate();
			
			if(rows_affected>0)
			{
				return true;
			}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		return false;
		
	}
	
	//###########################################3. getArraylist of customers###################################################################

	public ArrayList<Customer> getCustomers()
	{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer custobj=null;
		ArrayList<Customer> customerList = new ArrayList<>();
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("select * from Customer_1418560");
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				custobj = new Customer();
				custobj.setCustomerId(rs.getInt(1));
				custobj.setCustomerName(rs.getString(2));
				
				customerList.add(custobj);				
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		return customerList;
		
	}
	
	//###########################################4. getArraylist of taxdetails###################################################################
	
	public ArrayList<TaxDetails> getTaxDetails()
	{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TaxDetails taxobj=null;
		ArrayList<TaxDetails> taxList = new ArrayList<>();
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("select * from Tax_Details_1418560");
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				taxobj = new TaxDetails();
				taxobj.setCustomerId(rs.getInt(1));
				taxobj.setIncomeTaxPin(rs.getInt(2));
				taxobj.setGrossIncome(rs.getInt(3));
				taxobj.setTaxableIncome(rs.getInt(4));
				taxobj.setTotalTaxPayable(rs.getInt(5));
				taxobj.setFinancialYear(rs.getString(6));
				
				taxList.add(taxobj);				
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		return taxList;
		
	}
	
	public TaxDetails getTaxDetailById (int customerId)
	{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TaxDetails taxobj=null;
		
		try
		{
			cn = DatabaseUtil.getConnection();			
			ps = cn.prepareStatement("select * from Tax_Details_1418560 where CustomerID=?");
			
			ps.setInt(1, customerId);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				taxobj = new TaxDetails();
				taxobj.setCustomerId(rs.getInt(1));
				taxobj.setIncomeTaxPin(rs.getInt(2));
				taxobj.setGrossIncome(rs.getInt(3));
				taxobj.setTaxableIncome(rs.getInt(4));
				taxobj.setTotalTaxPayable(rs.getInt(5));
				taxobj.setFinancialYear(rs.getString(6));
								
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		
		return taxobj;
	}
	
	
	public Customer getCustomerById(int customerId)
	{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer custobj=null;
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("select * from Customer_1418560 where CustomerID=?");
			ps.setInt(1, customerId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				custobj = new Customer();
				custobj.setCustomerId(rs.getInt(1));
				custobj.setCustomerName(rs.getString(2));
				
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		return custobj;
			
	}
	
	
	
	
	//###########################################5.get details by customer id and year##################################################################
	
	public TaxDetails getTaxDetailsByYear(int customerId, String financialyear)
	{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TaxDetails taxobj=null;
		
		try
		{
			cn = DatabaseUtil.getConnection();
			ps = cn.prepareStatement("select * from Tax_Details_1418560 where CustomerID=? and financialyear=?");
			ps.setInt(1, customerId);
			ps.setString(2, financialyear);
			
			rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				taxobj = new TaxDetails();
				taxobj.setCustomerId(rs.getInt(1));
				taxobj.setIncomeTaxPin(rs.getInt(2));
				taxobj.setGrossIncome(rs.getInt(3));
				taxobj.setTaxableIncome(rs.getInt(4));
				taxobj.setTotalTaxPayable(rs.getInt(5));
				taxobj.setFinancialYear(rs.getString(6));				
			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(cn);
		}	
		
		return taxobj;
	}
	

}
