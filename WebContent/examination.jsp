<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>esame inserito</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
	<center>
<h1>
				<font>Dati Esame Inserito </font>
			</h1><br>
			</center>
			<center>
			<font><b>PAZIENTE:</b> ${patient.name} <br>
			<br> <b>MEDICO:</b> ${doctor.name} <br>
			<br> <b>TIPOLOGIA ESAME:</b> ${examination.type} <br>
			<br> <b>DATA ESAME:</b> ${examination.examinationDate} <br>
			</font>
			<br>
			
			</center>
			</header>
			</div>
			
</body>
</html>