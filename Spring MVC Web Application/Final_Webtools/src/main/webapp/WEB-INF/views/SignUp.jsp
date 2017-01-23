<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register a New User</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style type="text/css">
  #sign {
 
     text-align: center;
}
#box {
    width: 1000px;
    margin-left: auto;
    margin-right: auto;
    height:100%;
    
}
  </style>
  
  <script>
  //AJAX
  var xmlHttp;
  xmlHttp = GetXmlHttpObject();
  
  function huskyExist() {
      if (xmlHttp == null)
      {
          alert("Your browser does not support AJAX!");
          return;
      }
      var user = document.getElementById("husky").value;      
      var query = "action=searchhusky&user=" + user.trim();
      xmlHttp.onreadystatechange = function stateChanged()
      {
          if (xmlHttp.readyState == 4)
          {
              document.getElementById("msghusky").innerHTML = "";
              var json = JSON.parse(xmlHttp.responseText);
              if (json.users.length > 0) {
            	  document.getElementById("husky").value="";
            	  document.getElementById("msghusky").innerHTML="HuskyId already Exist";
              } else 
              {
                  document.getElementById("msghusky").innerHTML="Nothing Found";
              }
          }
      };
      xmlHttp.open("POST", "searchmail.htm", true);
      xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xmlHttp.send(query);
      return false;
  }
  
  function mailExist() {
      if (xmlHttp == null)
      {
          alert("Your browser does not support AJAX!");
          return;
      }
      var user = document.getElementById("mail").value;      
      var query = "action=searchmail&user=" + user.trim();
      xmlHttp.onreadystatechange = function stateChanged()
      {
          if (xmlHttp.readyState == 4)
          {
              document.getElementById("msgmail").innerHTML = "";
              var json = JSON.parse(xmlHttp.responseText);
              if (json.users.length > 0) {
            	  document.getElementById("mail").value="";
            	  document.getElementById("msgmail").innerHTML="Email Id already Exist";
              } else 
              {
                  document.getElementById("mail").innerHTML="Nothing Found";
              }
          }
      };
      xmlHttp.open("POST", "searchmail.htm", true);
      xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xmlHttp.send(query);
      return false;
  }
  
  function userExist() {
      if (xmlHttp == null)
      {
          alert("Your browser does not support AJAX!");
          return;
      }
      var user = document.getElementById("name").value;      
      var query = "action=searchuser&user=" + user.trim();
      xmlHttp.onreadystatechange = function stateChanged()
      {
          if (xmlHttp.readyState == 4)
          {
              document.getElementById("msg").innerHTML = "";
              var json = JSON.parse(xmlHttp.responseText);
              if (json.users.length > 0) {
            	  document.getElementById("name").value="";
            	  document.getElementById("msg").innerHTML="Username already Exist";
              } else 
              {
                  document.getElementById("msg").innerHTML="Nothing Found";
              }
          }
      };
      xmlHttp.open("POST", "searchuser.htm", true);
      xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xmlHttp.send(query);
      return false;
  }
  function GetXmlHttpObject()
  {
      var xmlHttp = null;
      try
      {
          // Firefox, Opera 8.0+, Safari
          xmlHttp = new XMLHttpRequest();
      } catch (e)
      {
          // Internet Explorer
          try
          {
              xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
          } catch (e)
          {
              xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
          }
      }
      return xmlHttp;
  }
  </script>
  
  
</head>
<body>

  <h1 id="sign">Enter your details for registration</h1>
<div id="box" class="row">
  <form:form action="signUp.htm" commandName="user" method="post">
    <div class="form-group">
      <label for="firstName">Enter your First Name:</label>
      <form:input class="form-control" path="firstName" size="50" /> <font color="red"><form:errors path="firstName"/></font>
    </div>

    <div class="form-group">
      <label for="lastName">Enter your Last Name:</label>
      <form:input class="form-control" path="lastName" size="50" /> <font color="red"><form:errors path="lastName"/></font>
    </div>

    <div class="form-group">
      <label for="huskyId">Enter your Husky Id    :</label>
      <form:input class="form-control" path="huskyId" type="number" id="husky" min="0" maxlength="9" onblur="huskyExist()" size="50" /> <font color="red"><form:errors path="huskyId"/><div id="msghusky"></div></font>
    </div>

    <div class="form-group">
      <label for="email">Enter your Email Id       :</label>
      <form:input class="form-control" path="email" type="email" id="mail" onblur="mailExist()" size="50" /> <font color="red"><form:errors path="email"/><div id="msgmail"></div></font>
    </div>

    <div class="form-group">
      <label for="phone">Enter your Phone No     :</label>
      <form:input class="form-control" path="phone" type="number" min="0" maxlength="10" size="50" /> <font color="red"><form:errors path="phone"/></font>
    </div>

    <div class="form-group">
      <label for="username">Enter new Username   :</label>
      <form:input class="form-control" path="username" size="50" id="name" onblur="userExist()"/> <font color="red"><form:errors path="username"/><div id="msg"></div></font>
    </div>

    <div class="form-group">
      <label for="password">Enter new password    :</label>
      <form:password class="form-control" path="password" size="50" /> <font color="red"><form:errors path="password"/></font>
    </div>

    <button type="submit" class="btn btn-primary form-control" value="Create User">Submit</button>
  </form:form>
</div>

</body>
</html>