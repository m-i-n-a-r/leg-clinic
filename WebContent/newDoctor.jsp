<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Doctor"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
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
				<f:view>
				<h:form>
				<div>Nome: <h:inputText value = "#{DoctorController.name}"
					required="true"
                 	requiredMessage="Nome obbligatorio" id="nome"/> <h:message for="nome" />
				</div>
					
				<div>Cognome: <h:inputText value = "#{DoctorController.surname}"
					required="true"
                 	requiredMessage="Cognome obbligatorio" id="cognome"/> <h:message for="cognome" />
				</div>
				
				<div>Specializzazione: <h:inputText value = "#{DoctorController.specialization}"
					required="true"
                 	requiredMessage="Specializzazione obbligatoria" id="specialization"/> <h:message for="specialization" />
				</div>	
				
				<div><h:commandButton value="Submit"  action="#{DoctorController.createDoctor}"/></div>
				</h:form>
				</f:view>
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>