<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<%@include file="header.jsp" %>
<hr>
<br><br>
<body>	<h3><font color="green"> Income Tax Payable  has been calculated.</font></h3>
		<%
			int customerId = Integer.parseInt(request.getAttribute("customerId")+"");
			String customerName = request.getAttribute("customerName")+"";
			int grossIncome = Integer.parseInt(request.getAttribute("grossIncome")+"");
			String financialYear = request.getAttribute("financialYear")+"";
			int taxableIncome = Integer.parseInt(request.getAttribute("taxableIncome")+"");
			int incomeTaxPayable = Integer.parseInt(request.getAttribute("incomeTaxPayable")+"");
		
		%>

	<center>
	
		<form action="<%=request.getContextPath()%>
		/Controller?action=clickedDisplaySuccess" method="post">
		<table>
		<tr>
			<td>
				CustomerID
			</td>
			
			<td>
				<input type="text" name="customerId" id="customerId" value="<%=customerId%>">
				<input type="hidden" name="custId" value="<%=customerId%>">
			</td>
		</tr>
		
		<tr>
			<td>
				Customer Name			
			</td>
			
			<td>
				 <input type="text" name="customerName" id="customerName" value="<%=customerName%>">
			</td>
		</tr>
		
		<tr>
			<td>	
				Gross Income
			</td>
			
			<td>
				 <input type="text" name="grossIncome" id="grossIncome" value="<%=grossIncome%>">
			</td>
		</tr>
		
		<tr>
			<td>	
				Financial Year
			</td>
			
			<td>
				<input type="text" name="financialYear" id="financialYear" value="<%=financialYear%>">
			</td>
		</tr>
		
		<tr>
			<td>
				Taxable Income
			</td>
			
			<td>
				  <input type="text" name="taxableIncome" id="taxableIncome" value="<%=taxableIncome%>">
			</td>
		</tr>
		
		
		<tr>
			<td>
				Income Tax Payable 
			</td>
			
			<td>
				 <input type="text" name="incomeTaxPayable" id ="incomeTaxPayable" value="<%=incomeTaxPayable%>"readonly>
			</td>
		</tr>
		
		<tr>	
			<td>
				<button>Submit</button>	
			</td>
		</tr>
		
		</table>	
				</form>
		
	</center>
	


</body>
<a href="index.jsp">Home</a>
<br><br>
<hr>
<%@include file="footer.jsp" %>
</html>