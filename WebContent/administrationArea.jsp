<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Admin"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Area amministrativa</title>
</head>
<body>
	<div id="wrap">
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
		
		<h1><a href="newExaminationType.jsp">Amplia offerta</a></h1>
		<h1><a href="newExamination.jsp">Nuovo esame</a></h1>
		<h1><a href="newCondition.jsp">Nuovo requisito</a></h1>
		<h1><a href="newExamResult.jsp">Inserisci risultati</a></h1>
		<h1><a href="newPatient.jsp">Nuovo paziente</a></h1>
		<h1><a href="newDoctor.jsp">Nuovo medico</a></h1>
		<h1><a href="newAdmin.jsp">Nuovo admin</a></h1>
		<h1><a href="searchDoctor.jsp">Cerca esami per medico</a></h1>
		<br>
		<h1><a href="login.jsp">Log out</a></h1>
	</center>
</body>
</html>