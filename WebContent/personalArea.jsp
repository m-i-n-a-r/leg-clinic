<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Area Personale</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
		<center>
			<h1>
				<font>Benvenuto nell'area personale</font>
			</h1><br>
			<h2>Ecco i tuoi dati personali</h2>
		</center>
		<center>
			<font>
			    <b>email:</b> ${patient.email} <br> <br>
				<b>password(lol):</b> ${patient.password} <br> <br> 
		    </font>
		</center>
		</header>
	</div>
	<br>
	<center>
		<h3><a href="login.jsp">Log out</a></h3>
	</center>
</body>
</html>