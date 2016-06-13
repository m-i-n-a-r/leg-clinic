<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Doctor"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Consulta i tuoi esami</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>inserisci nome per visualizzare esami </font>
			</h1><br>

			<f:view>
			<h:form>
				
				<div align="center">
				
				<div>nome: <h:inputText value = "#{ExaminationController.patientName}" required="true"
                 	requiredMessage="nome obbligatorio" id="name"/> <h:message for="name" />
				</div>	
				<h:commandButton value="Mostra" action="#{ExaminationController.showpatientExamination}"></h:commandButton>
			</h:form>
			</f:view>
				
		</header>
		</div>
	<center>
		<h3><a href="personalArea.jsp">Torna all'area personale</a></h3>
	</center>
</body>
</html>