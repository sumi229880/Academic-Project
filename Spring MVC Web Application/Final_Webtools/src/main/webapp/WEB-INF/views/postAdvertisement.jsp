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
    }else{
    	text = ""
    } 
    document.getElementById("demo").innerHTML = text;
}
</script>
</head>
<body>

<div id="box" class="container row">

   <h2>Enter details of the Advertisement</h2> 
  <form:form action="postadd.htm" commandName="advertisements" method="post" enctype="multipart/form-data">

<div class="form-group col-md-12">

        <label>Select Category:</label><form:select  path="category" class="form-control">
      	 <option value="ElectronicInstruments">Electronics and Instruments</option>
      	 <option value="LeaseRent">Lease and Rent</option>
      	 <option value="Furniture">Furniture</option>
      	 <option value="Mobiles">Mobile</option>
      	 <option value="Vehicles">Vehicles</option>
      	 <option value="TicketsPasses">Tickets and Passes</option>
      	 <option value="Freebie">Freebie</option>
      	 <option value="Books">Books</option>
      	 <option selected="selected" value="Others">Others</option>
       </form:select>

</div>
<div class="form-group col-md-12">
      <label for="title">Title:</label>
       <form:input class="form-control" path="title" size="30" placeholder="Enter title"/><font color="red"><form:errors path="title"/></font>
</div>
			<div class="form-group col-md-12">
				<label for="price">Price:</label>
				<form:input class="form-control" path="price" type="number" id="price"
					onblur="myFunction()" size="30" min="0" step="0.1" maxlength="15"
					placeholder="Enter price" />
				<font color="red"><form:errors path="price" />
					<div id="demo"></div></font>
			</div>
			<div class="form-group col-md-12">
      <label for="descripition">Description:</label>
       <form:textarea class="form-control" path="descripition" placeholder="Product description"/><font color="red"><form:errors path="descripition"/></font> 
    </div>
    <div class="form-group col-md-12">

        <label>Select How old:</label><form:select  class="form-control" path="yearOld">
      	 <form:option selected="selected" value="less than half a year">less than half a year</form:option>
      	 <form:option value="less than a year">less than a year</form:option>
      	 <form:option value="less than 2 years">less than 2 years</form:option>
      	 <form:option value="less than 3 years">less than 3 years</form:option>
      	 <form:option value="less than 4 years">less than 4 years</form:option>
      	 <form:option value="less than 5 years">less than 5 years</form:option>
      	 <form:option value="between 5 to 10 years">between 5 to 10 years</form:option>
      	 <form:option value="above 10 years">above 10 years</form:option>
      	 <form:option value="for rent/lease">for rent/lease</form:option>
       </form:select>

    </div>
        <div class="form-group col-md-12">
      <label for="imageFile">Photos(8mb max):</label>
       <form:input class="form-control" path="imageFile" size="30" type="file" /><font color="red"><form:errors path="imageFile"/></font> 
    </div>

    <button type="submit" class="btn btn-primary form-control">Post Add</button></form:form>
    
</div>

</body>
</html>