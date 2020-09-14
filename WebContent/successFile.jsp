<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String customerName = request.getAttribute("customerName")+"";
		String financialYear = request.getAttribute("financialYear")+"";
		int incomeTaxPin = Integer.parseInt(request.getAttribute("incomeTaxPin")+"");
	%>
	<%@include file="header.jsp" %>
	<hr>
<br><br>
		<center>
			<h2 align="center"><font color="green">
			Income tax of <%=customerName%> for 
			financial year <%=financialYear%> is filed Successfully
			Generated IncomeTaxPIN: <%=incomeTaxPin%>
			</font></h2>
			
		</center>
	<br><br>
<hr>
<a href="index.jsp">Home</a>
	<%@include file="footer.jsp" %>

</body>
</html>