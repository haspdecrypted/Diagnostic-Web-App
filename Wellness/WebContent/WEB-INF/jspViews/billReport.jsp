<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Lab-Test Bill in range of Date of collection Report</h2>
		<form:form modelAttribute="dateRangeBean" action="getBillDetails.html">
		<table border="2">
		<tr>
			<td>From Date[DD:MMM:YYYY]</td>
			<td><form:input path="from"/></td>
		</tr>
		<tr>
			<td>To Date</td>
			<td><form:input path="to"/></td>
		</tr>
		</table>
		<br>
		<input type="submit" value="Fetch Details">
		</form:form>
				<br>
	<br>
	<c:choose>
	<c:when test="${not empty billList }">
	<table border ="1">
	<tr>
	<th>Bill Number</th><th>Patient Name</th><th>Test Name</th><th>Paid Amount</th><th>Balance</th><th>Date Of Collection</th>
	</tr>
	<c:forEach var ="bill" items="${billList}">
		<tr>
		<td align="left">${bill.billNo}</td>
		<td align="left">${bill.patientName}</td>
		<td align="left">${bill.testName}</td>
		<td align="left"><fmt:formatNumber value="${bill.paidAmount}" type="currency" currencySymbol="INR."></fmt:formatNumber></td>
		<td align="left"><fmt:formatNumber value="${bill.balanceAmount}" type="currency" currencySymbol="INR."></fmt:formatNumber></td>
		<td align="left">${bill.dateOfCollection}</td>
	
		</tr>
	</c:forEach>
	</table>
	</c:when>
	</c:choose>
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	</center>
</body>
</html>