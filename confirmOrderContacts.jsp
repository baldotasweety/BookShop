<!DOCTYPE html>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
  <title>Confirm Personal Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */
     .jumbotron {
      margin-bottom: 0;
     
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
    /* filet */
    .filter{
    	
    }
    
    .cartButton{
    	display: block; margin-left: auto; margin-right: auto
    }
    
    .btn-hover {
  font-weight: normal;
  color: #333333;
  cursor: pointer;
  background-color: inherit;
  border-color: transparent;
}
    
  </style>
</head>
<body>
<body>
<div class="jumbotron">
  <div class="container text-center">
    <h1></h1>
    <p></p>
  </div>
</div>
<div class="container">
<table></table>
<h2>Confirm Personal Details</h2>

				<form:form modelAttribute="user"><br />
					<form:input type="hidden" path="id" /><br />
					<!-- to display validation messages -->
					
					<form:label path="username">First Name: </form:label>
					<form:input path="username" /><br/>
					
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('username')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					
					<form:label path="city">City </form:label>
					<form:input path="city" /><br />
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('city')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br /> 
					
					<form:label path="email">Email: </form:label>
					<form:input path="email" /><br />
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					
				
					<form:label path="contactNum">Contact number: </form:label>
					<form:input path="contactNum" /><br />
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('contactNum')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<%-- <a href="${flowExecutionUrl}&_eventId_home">Confirm Details</a> --%>
					<input name="_eventId_submit" type="submit" value="Submit" /><br />
</form:form>

</div>
<br><br>

<footer class="container-fluid text-center">
  <p>Copyright@BookAddict</p>
</footer>

</body>
</html>

