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
<title>Storico esami</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Ecco lo storico delle prenotazioni</font>
			</h1><br>
			<f:view>
			<h:form>
				<div align="center">
					<h:dataTable value="#{ExaminationController.patientExamination}" var="examination">
   						<h:column> 
   							<f:facet name="header"><h:outputText value="Codice"/></f:facet>   					  				
      						<h:outputText value="#{examination.id}"/>
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
			</h:form>
			</f:view>
				<!-- TODO - insert code here to display examination results! -->
		</header>
		</div>
	<center>
		<a href="personalArea.jsp">Torna all'area personale</a>
	</center>
</body>
</html>