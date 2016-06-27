<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>


<h4>List of available categories</h4>

<table width="50%">
	<tr>
	    <th align="left">S.No</th>
		<th align="left">Id</th>
		<th align="left">Name</th>
		<th align="left">Description</th>
		<th align="left">SupplierId</th>
		
	</tr>
	<c:forEach items="${categoryList}" var="category" varStatus="status">
		<tr>
		
			<td>${status.count}</td>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td>${category.ct_desc}</td>
			<td>${category.sup_id}</td>
		    <td><c:out value="${category.id}" ></c:out></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>