<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>SignUp</title>
<link rel="stylesheet" type="text/css" href="resources/Design.css">
</head>

<body>
<img src="resources/KidReadingBook.png"  style="float:right;width:250px;height:300px;">
<h1>SignUp </h1><br><br>
<form:form action="Login" method="post">

Name: 
<input type=text size=25 name="username"><br><br>
EnterDOB: 
<input type="date" name="bday"><br><br>
Enter emailId:
<input type="email" name="email"><br><br>
Address:
<textarea rows="10" cols="5"></textarea><br><br>
City:
<input type="text" name="city"><br><br>
EnterPassword:
<input type="password" name="pass"><br><br>
ConfirmPassword:
<input type="password" name="pas2"><br><br><br>
<p><input type="submit" value="Ok"></p>

</form:form>
</body>
</html>