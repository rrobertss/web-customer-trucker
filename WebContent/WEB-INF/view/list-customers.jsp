<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Simple CRM - view Customers</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<input type="button" class="add-button" value="Add customer" onclick="window.location.href='showFormForAdd'; return false;"/>
		
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email address</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>