<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<font>Inserisci i risultati per il seguente esame</font>
			</h1>
			<f:view>
			<h:form>
				<div align="center">
					<h:dataTable value="#{ExaminationResultController.examination}" var="examination" styleClass="examinationTable" headerClass="examinationTableHeader" rowClasses="examinationTableOddRow,examinationTableEvenRow" border="1" width="75%">
   						<h:column> 
   							<f:facet name="header"><h:outputText value="Data"/></f:facet>   					  				
      						<h:outputText value="#{examination.examinationDate}"/>
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


				<div>Inserisci i valori, separati da una virgola nello stesso ordine degli indicatori: <h:inputText value = "#{ExaminationResultController.value}" required="true"
                 	requiredMessage="valori obbligatori" id="value"/> <h:message for="value" />
				</div>
				<br><br>
				<div><h:commandButton value="Completa compilazione" action="#{ExaminationResultController.insertExaminationResult}"/></div>
			
			</h:form>
			</f:view>
				
		</header>
		</div>
	<center>
		<h2><a href="newFilling.jsp">Torna alla scelta dell'esame</a></h2>
		<h2><a href="administrationArea.jsp">Torna all'area amministrativa</a></h2>
	</center>
</body>
</html>