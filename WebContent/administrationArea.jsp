<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Admin"%>
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
				<font>Benvenuto nell'area amministrativa</font>
			</h1><br>
			<h2>Area riservata!</h2>
		</center>
		<center>
			<font>
			    <b>email:</b> ${administrator.email} <br> <br>
		    </font>
		</center>
		</header>
	</div>
	<br>
	<center>
		<h3><a href="login.jsp">Log out</a></h3>
		<h4><a href="newExaminationType.jsp">Amplia offerta</a></h4>
		<h5><a href="newExam.jsp">Nuovo esame</a></h5>
		<h6><a href="newPatient.jsp">Nuovo paziente</a></h6>
	</center>
</body>
</html>