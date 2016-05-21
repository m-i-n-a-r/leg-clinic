<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Personale</title>
</head>
<body>
	<div id="footer">
		<br> <br>
		<center>
			<h1>
				<font color="blue">Benvenuto nell'area personale</font>
			</h1>
		</center>
		<center>
			<font>
			    <b>email:</b> ${patient.email} <br> <br>
				<b>password(lol):</b> ${patient.password} <br> <br> 
		    </font>
		</center>
	</div>
	<br>
	<center>
		<a href="login.jsp">Log out</a>
	</center>
</body>
</html>