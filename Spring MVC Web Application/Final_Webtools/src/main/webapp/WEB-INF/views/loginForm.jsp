<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">
 #boxz{
     width: 1000px;
    margin-left: auto;
    margin-right: auto;
    height:100%;
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
  function loginExist() {
	  alert(hi);
      if (xmlHttp == null)
      {
          alert("Your browser does not support AJAX!");
          return;
      }
      var user = document.getElementById("uname").value;
      var pass = document.getElementById("pass").value;
      var query = "action=searchLogin&user=" + user.trim() + "&pass=" + pass.trim();
      xmlHttp.onreadystatechange = function stateChanged()
      {
          if (xmlHttp.readyState == 4)
          {
              document.getElementById("msg").innerHTML = "";
              var json = JSON.parse(xmlHttp.responseText);
              if (json.users.length = 0) {
            	  document.getElementById("uname").value="";
            	  document.getElementById("pass").value="";
            	  document.getElementById("msg").innerHTML="Check your Username and Password";
              } else 
              {
                  document.getElementById("msg").innerHTML="Match Found";
              }
          }
      };
      xmlHttp.open("POST", "searchLogin.htm", true);
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
<div id="boxz">
 <h2>Enter your Login credentials</h2>
 </div>
<div id="box">
  <form:form action="login.htm" commandName="user" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
       <form:input class="form-control" path="username" id="uname" size="30" placeholder="Enter username"/><font color="red"><form:errors path="username"/></font>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
       <form:password class="form-control" path="password" id="pass"  size="30" placeholder="Enter password"/><font color="red"><form:errors path="password"/><div id="msg"></font> 
    </div>
    <div class="checkbox">
      <label><input type="checkbox" > Remember me</label><a href="signUp.htm">Not Registered yet! </a>
    </div>
    <button type="submit" class="btn btn-primary form-control">Submit</button>
    
  </form:form>
</div>

</body>
</html>