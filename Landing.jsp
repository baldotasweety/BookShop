<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Book Addicts</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <style>
   
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 30%;
      margin-bottom: auto;
  }
    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */
     
     .jumbotron {
      background-image: url("resources/perfect.jpg");
      background-color: white;
      /* min-height: 50px; */
    padding: 10em 6em; 
     
      margin-bottom: 0;
      background-size: cover;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
     
    <!-- <h1>Book Addicts</h1> -->
    ${errorMessage}<br>
  </div>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Landing">Home</a></li>
        <li><a href="#">Products</a></li>
       
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <li><a href="#" data-toggle="modal" data-target="#login"> Login </a></li>
        <li><a href="displayCart"><!-- <span class="glyphicon glyphicon-shopping-cart"></span> -->Cart</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
<c:set var="size" scope="page" value="${fn:length(productList)}"></c:set>
<c:forEach begin="0" step="3" end="${size}" varStatus="count" var="product">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">>${productList[count.index].name}<br> ${productList[count.index].price}</div>
        <div class="panel-body"><img src="resources/nov.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer"><a href="user/addToCart/${productList[count.index].pId}/${productList[count.index].category_FK.ct_id}" class="btn btn-sm btn-hover btn-info cartButton">Add to Cart</a></div>
      </div>
    </div>
    </c:forEach>
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading">Mystery</div>
        <div class="panel-body"><img src="resources/mystery.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Suspense Lovers</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Educational</div>
        <div class="panel-body"><img src="resources/edu.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">All types of educational books</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Fiction</div>
        <div class="panel-body"><img src="resources/fic.png" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Fictional stories</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading">TragicComedy</div>
        <div class="panel-body"><img src="resources/tracom.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Tragic comedies are fun</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Comedy</div>
        <div class="panel-body"><img src="resources/Funny.jpg" class="img-responsive" style="width:50%" alt="Image"></div>
        <div class="panel-footer">Laughing out loud..LOL!!</div>
      </div>
    </div>
  </div>
</div><br><br> 

<!-- <footer class="container-fluid text-center">
  <p>Online Store Copyright</p>
  <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/4.jpg" alt="Read" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/3.jpg" alt="Read" width="460" height="320">
      </div>
    
      <div class="item">
        <img src="resources/1.jpg" alt="Read" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/2.jpg" alt="Read" width="460" height="345">
      </div>
    </div>

    Left and right controls
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  
</footer>  -->






<!-- Modal Login-->
<div id="login" class="modal fade" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<!-- <form method="post" action="login"> -->
	<form method="post" action="j_spring_security_check"> 
		<div class="modal-header">
		<b>Login</b>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
		</div>
		<div class="modal-body">
		
				
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message} <br>
				<input type="text" name="j_username" placeholder="Name" size="30" required><br><br>
				<input type="password" name="j_password" placeholder="Password" size="30" required><br><br>
		</div>
		<div class="modal-footer">
		     <h6>NewUser?<a href="#" data-toggle="modal" data-target="#signup"> Signup </a></h6>
			<button type="button" data-dismiss="modal">Cancel</button>
			<button type="submit">Login</button>
		</div>
	</form>
</div><!-- modal content -->
</div>
</div><!-- modal -->




<!-- Modal Signup-->
<div id="signup" class="modal fade" role="dialog">
<div class="modal-dialog">
<div class="modal-content">

	<form method="post" action="OK"> 
		<div class="modal-header">
		<b>Signup</b>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
		</div>
		<div class="modal-body">
		${errorMessage}<br>
				
				<img src="resources/KidReadingBook.png"  style="float:right;width:150px;height:150px;">


<table cellpadding="20px">
<tr>
<td>Name:</td> 
<td><input type=text  name="username"></td>
</tr>

<tr>
<td>Enter emailId:</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>City: </td>
<td><input type="text" name="city"></td>
</tr>
<tr>
<td>EnterPassword:</td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td>ConfirmPassword:</td>
<td><input type="password" name="pas2"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="OK">
<input type="reset" value="RESET">
</td>
</tr>
</table>
</form>
</div>
</div>
		</div>
		
	


</body>
</html>
