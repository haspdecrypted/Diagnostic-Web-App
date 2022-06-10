<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestForm</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Lab-Test bill Details</h2>
		<form:form modelAttribute="billBean" method="POST"
		action="${pageContext.request.contextPath}/addBillDetails.html">
		<br>
		<table border="2">
		<tr>
			<td>Patient Name</td>
			<td><form:input path="patientName"/></td>
		</tr>
		<tr>
			<td>Test Name</td>
			
			<td><form:select path="testId">
			<form:option label="--Select--" value=""/>
			<form:options path="testId" items="${testMap}"/>
			</form:select></td>
		</tr>
		<tr>
			<td>Date of Sample Collection</td>
			<td><form:input path="dateOfCollection"/></td>
		</tr>
		<tr>
			<td>Amount Paid</td>
			<td><form:input path="paidAmount"/></td>
		</tr>
		</table>
		<br>
		<input type="submit" value="Save Details">
				<br>
		<br>
		
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
		<spring:hasBindErrors name="billBean">
		<h3>All Errors</h3>
		<form:errors path="*" cssClass="error"/>
		</spring:hasBindErrors>
		<h2>${message}</h2>
		<h2>${m1}</h2>
		<h2>${m2}</h2>
		</form:form>
	</center>
</body>
</html>