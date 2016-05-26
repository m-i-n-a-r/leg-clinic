<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Doctor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Nuovo medico</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci un nuovo medico della clinica</font>
			</h1><br>
				<form action="DoctorController" method="post">
			
			Nome: <input type="text" name="name" class="form-control"
				value="${param['name']}"><br>
				<font color="red"> ${nameError} </font> <br>
				
			Cognome: <input type="text" name="surname" class="form-control"
				value="${param['surname']}"><br>
				<font color="red"> ${surnameError} </font> <br>
				
			Specializzazione: <input type="text" name="specialization" class="form-control"
				value="${param['specialization']}"><br>
				<font color="red"> ${specializationError} </font> <br>
				
				<input type="submit" onclick="return confirm('sei sicuro?')" value="Inserisci medico">
		</form>
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>