<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>



  <title>Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script>
  	function updateQty(pId, pname, sup_id, name){
  		document.getElementById("updateProductId").value = pId;
  		document.getElementById("updateSupplierId").value = sup_id;
  		document.getElementById("updateProductName").value = pname;
  		document.getElementById("updateSupplierName").value = name;
  		alert("hello");
  	}
  </script>
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

<%-- <%@include file="success.jsp"%> --%>
<div class="container">
<h1>Cart Details</h1>
WELCOME:${pageContext.request.userPrincipal.name}
<%-- <c:url var="addAction" value="user/addToCart/{pId}/{cId}"></c:url>
<form:form action="${action}" commandName="cart"> --%>
<form method = "post" action = "${action}">
<table class="table table-bordered">
<thead>
	<tr>
		<td>Product</td>
		<td>Product Details</td>
		<td>Quantity</td>
		<td>Price</td>
		<td>Sub total</td>
		<td>Delete</td>
		<td>Change Quantity</td>
	</tr>
</thead>
<tbody>
<c:set var="total" scope="page" value="0"></c:set>
<c:forEach  items="${cartList}" var="cartItem">
<tr>
	<td>Image</td>
	<td>${cartItem.product_FK.pname}</td>
	<td>${cartItem.qty}</td>
	<td>${cartItem.price}</td>
	<td>${(cartItem.qty)*(cartItem.price)}</td>
	<td><a href="<c:url value='deleteFromCart/${cartItem.product_FK.id}/${cartItem.category_FK.ct_id}/${cartItem.supplier_FK.sup_id}'/>"><span class="glyphicon glyphicon-remove"></span></a></td>
	
	<td><a href="#" data-toggle="modal" data-target="#updateQty" onclick="updateQty('${cartItem.product_FK.id}','${cartItem.product_FK.pname}','${cartItem.product_FK.getSupplier().name}','${cartItem.product_FK.getSupplier().name}','${cartItem.getQty()}')"><span class="glyphicon glyphicon-edit"></span></a></td>
</tr>
<c:set var="total" value="${total + ((cartItem.qty)*(cartItem.price))}"></c:set>
</c:forEach>
<tr><td></td><td></td><td></td><td>Total</td><td>${total}</td></tr>
</tbody>
</table>
</form>
<br><br>
<a href="ProDemo" class="btn btn-primary">Continue Shopping</a>
<a href="purchase.obj" class="btn btn-primary">Place Order</a>

</div>
<br><br>

<footer class="container-fluid text-center">
  <p>Copyright@BookAddicts</p>
</footer>

<!-- Update quantity Modal -->
<div id="updateQty" class="modal fade" role="dialog">
<div class="modal-dialog">
<div class="modal-content">
<c:url var="supplierAction" value="updateCartItem/{pId}/{cId}/{sId}"/>
<form method="post" action="updateCartItemQty">
	<div class="modal-header">
	<b>Update Qty</b>
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	</div>
	<div class="modal-body">
	<table style="border-collapse: separate; border-spacing: 8px 10px;">
	<input id="updateProductId" name="updateProductId" type="text" name="pId"/>
	<input id="updateSupplierId" name="updateSupplierId" type="text" name="sId"/>
	<tr><td>Product:</td><td><input id="updateProductName" type="text" readonly/></td></tr>
	<tr><td>Supplier Name:</td><td><input id="updateSupplierName" type="text" readonly/></td></tr>
	<tr><td>Product Quantity:</td><td><input type="text" name="qty"></td></tr>
	</table>
	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
	<button type="submit" class="btn btn-primary">Update Quantity</button>
	</div>
</form>
</div>
</div>
</div>


</body>
</html>