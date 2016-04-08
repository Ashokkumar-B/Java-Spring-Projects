<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<style type="text/css">
body {
	/* background-color: #f4f4f4; */
	background-image: url("${pageContext.request.contextPath}/resources/images/background.jpg");
	color: #5a5656;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	font-size: 16px;
	line-height: 1.5em;
}

a {
	text-decoration: none;
}

h1 {
	font-size: 1em;
}

h1,p {
	margin-bottom: 10px;
}

strong {
	font-weight: bold;
}

.uppercase {
	text-transform: uppercase;
}

/* ---------- LOGIN ---------- */
#login {
	margin: 50px auto;
	width: 300px;
}

form fieldset input[type="text"],input[type="password"] {
	background-color: #e5e5e5;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #5a5656;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	font-size: 14px;
	height: 50px;
	outline: none;
	padding: 0px 10px;
	width: 280px;
	-webkit-appearance: none;
}

form fieldset input[type="submit"] {
	background-color: #008D3D;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #f4f4f4;
	cursor: pointer;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	height: 50px;
	text-transform: uppercase;
	width: 300px;
	-webkit-appearance: none;
}

form fieldset a {
	color: #5a5656;
	font-size: 10px;
}

form fieldset a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div id="login">
		<br/>
		<br/>
		<br/>
		<h1>
			<center> <strong> Welcome</strong> <br/> Login Account
		</h1>
		<c:set var="context" value="${pageContext.request.contextPath}" />		
		<span style="color:red">${loginStatus}</span>
		<form action="${context}/validateLogin" method="post">
			<fieldset>
				<p>
					<input type="text" required value="Username" name="userName"
						onBlur="if(this.value=='')this.value='Username'"
						onFocus="if(this.value=='Username')this.value='' ">
				</p>
				<p>
					<input type="password" required value="Password" name="password"
						onBlur="if(this.value=='')this.value='Password'"
						onFocus="if(this.value=='Password')this.value='' ">
				</p>
				<p>
					<a href="#">Forgot Password?</a>
				</p>
				<p>
					<input type="submit" value="Login">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>