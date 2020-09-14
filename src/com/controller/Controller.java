package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Customer;
import com.beans.TaxDetails;
import com.service.ServiceDao;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Controller()
    {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//onchange action
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		ServiceDao servicedao = new ServiceDao();
		
		if("clickedFileIncome".equalsIgnoreCase(action))
		{
			System.out.println("Action: "+action);
			
			RequestDispatcher rd = request.getRequestDispatcher("fileTaxPage.jsp");
			rd.forward(request, response);
		}
		
		else if("clickedSubmitTax".equalsIgnoreCase(action))
		{
			System.out.println("Action: "+action);

			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String customerName = request.getParameter("customerName");
			int grossIncome = Integer.parseInt(request.getParameter("grossIncome"));
			String financialYear = request.getParameter("financialYear");
			int taxableIncome = Integer.parseInt(request.getParameter("taxableIncome"));
			
		//int incomeTaxPayable = Integer.parseInt(request.getParameter("incomeTaxPayable"));
			
			//set attributes to customer
			Customer custobj= new Customer();
			custobj.setCustomerId(customerId);
			custobj.setCustomerName(customerName);
			
			System.out.println("CUSTOMER OBJECT"+custobj);
			
			//call service dao method
			boolean check = servicedao.addCustomer(custobj);
			
			/*public TaxDetails(int customerId, int incomeTaxPin, int grossIncome, int taxableIncome, int totalTaxPayable,
			String financialYear)	*/	
			
			
			
			//calculate total tax 
			int totalTaxPayable = 0;
			if(grossIncome<500000)
			{
				totalTaxPayable = (taxableIncome*15)/100;
			}
			
			else if(grossIncome>500000 && grossIncome<1000000)
			{
				totalTaxPayable = (taxableIncome*20)/100;
			}
			
			else if(grossIncome>1000000)
			{
				totalTaxPayable = (taxableIncome*30)/100;
			}
			
			
			//set attributes to taxdetails
			TaxDetails taxobj = new TaxDetails();
			taxobj.setCustomerId(customerId);
			taxobj.setGrossIncome(grossIncome);
			taxobj.setTaxableIncome(taxableIncome);
			taxobj.setFinancialYear(financialYear);
			taxobj.setTotalTaxPayable(totalTaxPayable);
			
			System.out.println("TAXABLE OBJECT:  "+taxobj);
			
			//request.setAttribute("incomeTaxPayable", totalTaxPayable);
			
			//call servicedao to add taxdetails object
			boolean check2 = servicedao.addTaxDetails(taxobj);
			/*
			 * 	int customerId = Integer.parseInt(request.getAttribute("customerId")+"");
			String customerName = request.getAttribute("customerName")+"";
			int grossIncome = Integer.parseInt(request.getAttribute("grossIncome")+"");
			String financialYear = request.getAttribute("financialYear")+"";
			int taxableIncome = Integer.parseInt(request.getAttribute("taxableIncome")+"");
			int incomeTaxPayable = Integer.parseInt(request.getAttribute("incomeTaxPayable")+"");
		
			 */
			if(check==true && check2==true)
			{
				request.setAttribute("customerId", customerId);
				request.setAttribute("customerName", customerName);
				request.setAttribute("grossIncome", grossIncome);
				request.setAttribute("financialYear", financialYear);
				request.setAttribute("taxableIncome", taxableIncome);
				request.setAttribute("incomeTaxPayable", totalTaxPayable);
				
				RequestDispatcher rd = request.getRequestDispatcher("viewTaxPage.jsp");
				rd.forward(request, response);				
			}
				
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);				
			}
			
		}
		
		else if("clickedViewDetails".equalsIgnoreCase(action))
		{
			System.out.println("Action" +action);
			
			ArrayList<Customer> customerList = servicedao.getCustomers();
			request.setAttribute("customerList", customerList);
			
			ArrayList<TaxDetails> taxList = servicedao.getTaxDetails();
			request.setAttribute("taxList", taxList);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("viewDetails.jsp");
			rd.forward(request, response);
		}
		
		else if("loadTaxDetails".equalsIgnoreCase(action))
		{
			System.out.println("Action" +action);

			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String year = request.getParameter("year");
			
			//call dao
			TaxDetails taxobj = servicedao.getTaxDetailsByYear(customerId, year);
			
			request.setAttribute("taxpin", taxobj.getIncomeTaxPin());
			request.setAttribute("customerId", taxobj.getCustomerId());
			request.setAttribute("grossIncome", taxobj.getGrossIncome());
			request.setAttribute("financialYear", taxobj.getFinancialYear());
			request.setAttribute("taxableIncome", taxobj.getTaxableIncome());
			request.setAttribute("incomeTaxPayable", taxobj.getTotalTaxPayable());
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("viewDetails.jsp");
			rd.forward(request, response);
		}
		
		else if("clickedDisplaySuccess".equalsIgnoreCase(action))
		{
			System.out.println("Action" +action);
			int customerId = Integer.parseInt(request.getParameter("custId"));
			
			//call dao
			TaxDetails taxobj = servicedao.getTaxDetailById(customerId);
			
			Customer custobj = servicedao.getCustomerById(customerId);
			
			request.setAttribute("customerName", custobj.getCustomerName());
			request.setAttribute("financialYear", taxobj.getFinancialYear());
			request.setAttribute("incomeTaxPin", taxobj.getIncomeTaxPin());
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("successFile.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		doGet(request, response);
	}

}
