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
<title>Lista esami per Dottore</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Scegli un medico tra quelli presenti: </font>
			</h1><br>

			<f:view>
			<h:form>
				<div align="center">
					<ul>
						<c:forEach var="medico" items="#{DoctorController.doctors}">
							<li><h:outputText value="#{medico.name} #{medico.surname}"></h:outputText></li>
						</c:forEach>
					</ul>
				</div>
				<div>Cognome: <h:inputText value = "#{DoctorExamsListController.surname}" required="true"
                 	requiredMessage="Cognome obbligatorio" id="surname"/> <h:message for="surname" />
				</div>	
				<br><br>
				<h:commandButton value="Mostra" action="#{DoctorExamsListController.showExams}"></h:commandButton>
			</h:form>
			</f:view>
				
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>