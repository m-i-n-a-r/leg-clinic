<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.ExaminationType"
	     import="it.leg.model.Examination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Inserisci esame in agenda</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci un esame </font>
			</h1><br>
				<form action="ExaminationController" method="post">
			
			TipologiaEsame: <input type="text" name="type" class="form-control"
				value="${param['type']}"><br>
				<font color="red"> ${typeError} </font> <br>
				
			Paziente: <input type="text" name="patient" class="form-control"
				value="${param['patient']}"><br>
				<font color="red"> ${patientError} </font> <br>
				
			Medico: <input type="text" name="doctor" class="form-control"
				value="${param['doctor']}"><br>
				<font color="red"> ${doctorError} </font> <br>
				
				<input type="submit" onclick="return confirm('sei sicuro?')" value="Crea Esame" >
		</form>
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>