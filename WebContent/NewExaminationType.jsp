<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.ExaminationType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Amplia offerta</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci una nuova tipologia di esame</font>
			</h1><br>
				<form action="ExaminationTypeController" method="post">
			
			Nome: <input type="text" name="name" class="form-control"
				value="${param['name']}"><br>
				<font color="red"> ${nameError} </font> <br>
				
			Descrizione: <input type="text" name="description" class="form-control"
				value="${param['description']}"><br>
				<font color="red"> ${descriptionError} </font> <br>
				
			Costo: <input type="text" name="cost" class="form-control"
				value="${param['cost']}"><br>
				<font color="red"> ${costError} </font> <br>
				
			<input type="checkbox" name="condition1" value="condition"> Inseriremo dopo le condizioni!<br>
				
				<input type="submit" onclick="return confirm('sei sicuro?')" value="Crea Tipologia">
		</form>
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>