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
	    <f:view>
		    <h:form>
				<div align="center">
					Esami del Dr. <h:outputText value="#{DoctorExamsListController.doctor.surname}"></h:outputText>
					<h:dataTable value="#{DoctorExamsListController.examinations}" var="examination">
   						<h:column> 
   							<f:facet name="header"><h:outputText value="Codice"/></f:facet>   					  				
      						<h:outputText value="#{examination.id}"/>
   						</h:column>
   						<h:column> 				
      						<f:facet name="header"><h:outputText value="Tipologia"/></f:facet>    				
      						<h:outputText value="#{examination.examinationType.name}"/>
   						</h:column>
   						<h:column>
      						<f:facet name="header"><h:outputText value="Paziente"/></f:facet> 
      						<h:outputText value="#{examination.patient.name} #{examination.patient.surname}" />
   						</h:column>
      						<h:column>
      						<f:facet name="header"><h:outputText value="Orario"/></f:facet> 
      						<h:outputText value="#{examination.reservationDate}" />
   						</h:column>
					</h:dataTable>
				</div>
			</h:form>
		</f:view>
				
		</header>
		</div>
	<center>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
	</center>
</body>
</html>