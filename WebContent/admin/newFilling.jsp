<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Inserimento risultati</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Seleziona l'esame da compilare</font>
			</h1><br>
			<f:view>
			<h:form>
				<div align="center">
					<h:dataTable value="#{ExaminationController.allExamination}" var="examination">
   						<h:column> 
   							<f:facet name="header"><h:outputText value="Codice"/></f:facet>   					  				
      						<h:outputText value="#{examination.id}"/>
   						</h:column>
   						<h:column> 				
      						<f:facet name="header"><h:outputText value="Paziente"/></f:facet>   				
      						<h:outputText value="#{examination.patient.name} #{examination.patient.surname}"/>
   						</h:column>
   						<h:column> 				
      						<f:facet name="header"><h:outputText value="Tipologia"/></f:facet>    				
      						<h:outputText value="#{examination.examinationType.name}"/>
   						</h:column>
   						<h:column>
      						<f:facet name="header"><h:outputText value="Medico"/></f:facet> 
      						<h:outputText value="#{examination.doctor.name} #{examination.doctor.surname}" />
   						</h:column>
					</h:dataTable>
				</div>
			
				<div>inserisci Id esame: <h:inputText value = "#{ExaminationResultController.examinationId}" required="true"
                 	requiredMessage="id obbligatorio" id="id"/> <h:message for="id" />
				</div>

				<br><br>
				<div><h:commandButton value="Inizia compilazione"  action="#{ExaminationResultController.retrieveExamination}"/></div>
			
			</h:form>
			</f:view>
				
		</header>
		</div>
	<center>
		<h2><a href="administrationArea.jsp">Torna all'area amministrativa</a></h2>
	</center>
</body>
</html>