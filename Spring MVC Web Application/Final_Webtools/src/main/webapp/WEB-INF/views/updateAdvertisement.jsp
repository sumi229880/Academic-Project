<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Post Advertisement</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">

#box {
    width: 1000px;
    margin-left: auto;
    margin-right: auto;
    height:100%;
    
}
  </style>
  <script>
function myFunction() {
    var x, text;
    x = document.getElementById("price").value;
    if (isNaN(x) || x < 1 || x > 1000000000000000) {
        text = "Price not valid";
        document.getElementById("price").value = ""
    } else{
    	text = ""
    }     
    document.getElementById("demo").innerHTML = text;
}
</script>
</head>
<body>

<div id="box" class="container row">

   <h2>Update your Advertisement</h2> 
  <form:form action="deleteUpdate.htm" commandName="advertisements" method="post">
	    <div class="form-group col-md-12">
      <label for="title">Advert Id:</label>
       <form:input class="form-control" path="advertId" readonly="true" size="30" value= "${advertisements.advertId}" /><font color="red"><form:errors path="advertId"/></font>
    </div>	
    <div class="form-group col-md-12">
      <label for="title">Title:</label>
       <form:input class="form-control" path="title" size="30" value= "${advertisements.title}" /><font color="red"><form:errors path="title"/></font>
    </div>
    <div class="form-group col-md-12">
      <label for="price">Price:</label>
       <form:input class="form-control" path="price" type="number" id="price" value= "${advertisements.price}"  size="30" min="0" step="0.1" maxlength="15" placeholder="Enter price"/><font color="red"><form:errors path="price"/><div id="demo"/></font> 
    </div>
        <div class="form-group col-md-12">
      <label for="descripition">Description:</label>
       <form:textarea class="form-control" path="descripition" value= "${advertisements.descripition}"/><font color="red"><form:errors path="descripition"/></font> 
    </div>

    <button type="submit" class="btn btn-primary form-control">Update my Add</button>
    
  </form:form>
</div>

</body>
</html>