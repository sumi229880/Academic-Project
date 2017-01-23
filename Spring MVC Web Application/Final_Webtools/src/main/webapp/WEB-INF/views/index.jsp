<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>NEU Kraiglist</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    #test {
background-color: transparent;
border-top-style: none;
border-right-style: none;
border-bottom-style: none;
border-left-style: none;
}
    
    /* Remove the jumbotron's default bottom margin */
     .jumbotron {
      margin-bottom: 0;
      
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
     background-color: #f0f0f5;
      padding: 25px;
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1><b>My NEU Kraiglist</b></h1>
    <p><b>Where buyers meet sellers</b></p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">

      <a class="navbar-brand"><b>MyNEU KRAIGLIST</b></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

      <ul class="nav navbar-nav navbar-right">
      	 	<c:choose>
            	<c:when test="${!empty sessionScope.firstname}">
                	<jsp:include page="Loggedin.jsp"/>
            	</c:when>
            	<c:otherwise>
                	<jsp:include page="NotLoggedin.jsp"/>
            	</c:otherwise>
        </c:choose>      	
        <li><a href="postadd.htm"><span class="glyphicon glyphicon-log-in"></span> <b>Post Free Add</b></a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">ELECTRONICS/INSTRUMENTS</div>
        <div class="panel-body"><form action="showElectronics.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/Electronic.jpg" alt="electronics" class="img-responsive" style="width:300px;height:184px"><input type="hidden" name="action" value="ElectronicInstruments"/></form></div>
        <div class="panel-footer">Laptops,TV's,Guitars,Microwave</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">LEASE/RENT ROOM</div>
        <div class="panel-body"><form action="showRent.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/RealEstate.jpg" alt="realestate" class="img-responsive" style="width:300px;height:184px"><input type="hidden" name="action" value="LeaseRent"/></form></div>
        <div class="panel-footer">Single-room,Sharing,3BHK,1BHK</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">FURNITURE</div>
        <div class="panel-body"><form action="showFurniture.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/Furniture.jpg" alt="furniture" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="Furniture"/></form></div>
        <div class="panel-footer">Sofa,Chairs,Dinning,Tables</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">MOBILES</div>
        <div class="panel-body"><form action="showMobiles.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/mobile.jpg" alt="mobiles" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="Mobiles"/></form></div>
        <div class="panel-footer">Iphone,Samsung,Blackberry,Sony</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">VEHICLES</div>
        <div class="panel-body"><form action="showVehicles.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/car.jpg" alt="vehicles" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="Vehicles"/></form></div>
        <div class="panel-footer">Cars,Bikes,Bicycle,Mini-Trucks</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">TICKETS and PASSES</div>
        <div class="panel-body"><form action="showTickets.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/Tickets.jpeg" alt="tickets" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="TicketsPasses"/></form></div>
        <div class="panel-footer">Movies,DJ-Night,Events,Seminars</div>
      </div>
    </div>
  </div>
</div><br><br>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">FREEBIE</div>
        <div class="panel-body"><form action="showFreebie.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/freebie.jpg" alt="freebie" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="Freebie"/></form></div>
        <div class="panel-footer">Any stuff for free</div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">BOOKS</div>
        <div class="panel-body"><form action="showBooks.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/books.jpeg" alt="books" class="img-responsive" style="width:290px;height:184px"><input type="hidden" name="action" value="Books"/></form></div>
        <div class="panel-footer">Scholastic and Non-Scholastic</div>
      </div>
    </div>
        <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">OTHERS</div>
        <div class="panel-body"><form action="showOthers.htm"><input type="image" id="test" src="${pageContext.request.contextPath}/resources/images/other.jpg" alt="others" class="img-responsive" style="width:310px;height:184px"><input type="hidden" name="action" value="Others"/></form></div>
        <div class="panel-footer">All other items could be found here</div>
      </div>
    </div>
  </div>
</div><br><br>

<footer class="container-fluid text-center">
   <p>MyNEU Copyright</p>
  <form action="report.htm" class="form-inline">
    <input type="submit" class="btn btn-danger" value="Terms of use">
  </form>
</footer>

</body>
</html>

