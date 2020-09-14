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
<body>

	<center>
	
		<form action="<%=request.getContextPath()%>
		/Controller?action=clickedSubmitTax" method="post">
		<table>
		<tr>
			<td>
				CustomerID
			</td>
			
			<td>
				<input type="text" name="customerId" id="customerId">
			</td>
		</tr>
		
		<tr>
			<td>
				Customer Name			
			</td>
			
			<td>
				 <input type="text" name="customerName" id="customerName">
			</td>
		</tr>
		
		<tr>
			<td>	
				Gross Income
			</td>
			
			<td>
				 <input type="text" name="grossIncome" id="grossIncome">
			</td>
		</tr>
		
		<tr>
			<td>	
				Financial Year
			</td>
			
			<td>
				<input type="text" name="financialYear" id="financialYear">
			</td>
		</tr>
		
		<tr>
			<td>
				Taxable Income
			</td>
			
			<td>
				  <input type="text" name="taxableIncome" id="taxableIncome" onchange="return validateForm()">
			</td>
		</tr>
		
		
		<tr>
			<td>
				Income Tax Payable 
			</td>
			
			<td>
				 <input type="text" name="incomeTaxPayable" id ="incomeTaxPayable" readonly>
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