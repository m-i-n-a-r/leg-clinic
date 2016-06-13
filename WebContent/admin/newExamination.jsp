<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Examination"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Inserisci prenotazione</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci una nuova prenotazione</font>
			</h1>
				
				<f:view>
				<h:form>
				
				<div align="center">
					Nome Tipologia: <h:inputText value="#{ExaminationController.examinationTypeName}" required="true"
					requiredMessage="Nome Tipologia Esame obbligatorio!" id="examName"/> <h:message for="examName" />
				</div>
				
				<div align="center">
					Nome Paziente: <h:inputText value="#{ExaminationController.patientName}" required="true"
					requiredMessage="Specificare un paziente" id="patientName"/> <h:message for="patientName" />
				</div>
				
				<div align="center">
					Cognome Medico: <h:inputText value="#{ExaminationController.doctorSurname}" required="true"
					requiredMessage="E' richiesto il cognome del medico" id="doctorSurname"/> <h:message for="doctorSurname" />
				</div>
				<br><br>
				<div align="center">
					<h:commandButton value="Crea prenotazione" action="#{ExaminationController.createExamination}"/>
				</div>
			</h:form>
			</f:view>
			
			<h2><a href="administrationArea.jsp">Torna all'area amministrativa</a></h2>
		</header>
		</div>
	</body>
</html>