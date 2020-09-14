<%@page import="com.beans.TaxDetails"%>
<%@page import="com.beans.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body>
	<%@include file="header.jsp" %>
	<hr>
<br><br>
	<%ArrayList<Customer>customerList = (ArrayList<Customer>)request.getAttribute("customerList"); %>
	
	<%ArrayList<TaxDetails>taxList = (ArrayList<TaxDetails>)request.getAttribute("taxList");%>

<%if(customerList!=null)
{ %>
		<center>
			<form action="<%=request.getContextPath()%>
			/Controller?action=loadTaxDetails" method="post">
			
			Customers
			<select name="customerId">
			<%for(Customer temp: customerList)
				{
				%>
					<option value="<%=temp.getCustomerId()%>"><%=temp.getCustomerName()%> </option>
				<%
				}%>
			</select>
			
			
				<br><br>
				
			Financial Year
			<select name="year">
			<%for(TaxDetails temp2: taxList)
				{%>
				<option value="<%=temp2.getFinancialYear()%>"><%=temp2.getFinancialYear()%> </option>
				<%
				}%>
			
			</select><br><br>
			<button>Submit</button>
			</form>
			
		
<%} %>		
			<%
			int customerId = Integer.parseInt(request.getAttribute("customerId")+"");
			int taxpin = Integer.parseInt(request.getAttribute("taxpin")+"");
			int grossIncome = Integer.parseInt(request.getAttribute("grossIncome")+"");
			int taxableIncome = Integer.parseInt(request.getAttribute("taxableIncome")+"");
			int incomeTaxPayable = Integer.parseInt(request.getAttribute("incomeTaxPayable")+"");
			String financialYear = request.getAttribute("financialYear")+"";		
		%>
		
	<table>
		<tr>
			<th>Customer ID </th>
			<th>Income tax pin </th>
			<th>Gross income </th>
			<th>Taxable income </th>
			<th>Total tax payable </th>
			<th>Financial year </th>
		</tr>
		
		<tr>
			<td><%=customerId%> </td>
			<td><%=taxpin%> </td>
			<td><%=grossIncome%> </td>
			<td><%=taxableIncome%> </td>
			<td><%=incomeTaxPayable%> </td>
			<td><%=financialYear%> </td>
			
		
		</tr>
		
		
		
	</table>
		
		
		
		</center>
	<br><br>
<hr>
	<%@include file="footer.jsp" %>

	</body>


</body>
</html>