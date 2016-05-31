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
<title>Nuovo Paziente</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Registra un paziente</font>
			</h1><br>
				<f:view>
				<h:form>
				<div>Email: <h:inputText value = "#{PatientController.email}"
					required="true"
                 	requiredMessage="Email obbligatoria" id="email"/> <strong><h:message for="email" /></strong>
				 </div>
				
				<div>Nome: <h:inputText value = "#{PatientController.name}"
					required="true"
                 	requiredMessage="Nome obbligatorio" id="nome"/> <strong><h:message for="nome" />
				</div>
				
				<div>Cognome: <h:inputText value = "#{PatientController.surname}"
					required="true"
                 	requiredMessage="Cognome obbligatorio" id="cognome"/> <strong><h:message for="cognome" />
				</div>
				
				<div>Password: <h:inputText value = "#{PatientController.password}"
					required="true"
                 	requiredMessage="Password obbligatoria" id="password"/> <strong><h:message for="password" />
				</div>	
				
				<div><h:commandButton value="Submit"  action="#{PatientController.createPatient}"/></div>
				</h:form>
				</f:view>
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>