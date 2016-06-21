<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message} 
<form:form action="isValid" method="post">
<center> <h2>Hello user..<br>U need to login here..</h2></center>
<center>Name: <input type=text name="name"><br><br>
Code: <input type=password name="password"><br><br></center>
<center><input type=submit value="Login">
<input type= reset value="Clear"></center>


</form:form>
</body>
</html>