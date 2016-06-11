<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.ExaminationType"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
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
				<font>Inserisci gli indicatori della tipologia</font>
			</h1><br>
				
				<f:view>
				<h:form>
				<h1>${ExaminationTypeController.name}</h1>
				<div><h:commandButton value="Aggiungi indicatore" 
					action="#{ExaminationTypeController.insertExaminationResult}"/></div>
				
				<br><br>
				<div><h:commandButton value="Crea Tipologia" action="#{ExaminationTypeController.createExaminationType}"/></div>

				</h:form>
				</f:view>

		
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>