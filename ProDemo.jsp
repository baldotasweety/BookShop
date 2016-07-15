<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>


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
       
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="logout"><span class="glyphicons glyphicons-power"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Novels</div>
        <div class="panel-body"><img src="resources/nov.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Novelsss..</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading">Mystery</div>
        <div class="panel-body"><img src="resources/mystery.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Suspense Lovers</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-success">
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
      <div class="panel panel-primary">
        <div class="panel-heading">TragicComedy</div>
        <div class="panel-body"><img src="resources/tracom.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Tragic comedies are fun</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Comedy</div>
        <div class="panel-body"><img src="resources/Funny.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Laughing out loud..LOL!!</div>
      </div>
    </div>
  </div>
</div><br><br>
</body>
</html>