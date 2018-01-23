<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function callRegister(){
		window.location.href = "http://localhost:8080/Adjetter/registration.jsp";
	}
	function changePassword(){
		window.location.href="http://localhost:8080/Adjetter/ChangePassword.jsp";
	}
	function viewUsers(){
		window.location.href="http://localhost:8080/Adjetter/view_user.jsp"
	}
</script>
<style type="text/css">
* {box-sizing: border-box}

/* Full-width input fields */
  input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

#profile_page {
    position: absolute;
    top: 5%;
    left: 30%;
    right: 30%;
    bottom: 20%;
    font-size: 18px;
}

</style>
</head>
<body id="profile_page">
<div class="container">
<h1>Manage Users</h1>
<div>
<a href="http://localhost:8080/Adjetter/logout.jsp">Logout</a><br><br>
</div>
<div class="manag_user">
	<button type="button" onclick="callRegister()">Add User</button><br><br>
	<button type="button" onclick="viewUsers()">View User</button><br><br>
	<button type="button" onclick="changePassword()">Change Password</button><br><br>
</div>
</div>
</body>
</html>