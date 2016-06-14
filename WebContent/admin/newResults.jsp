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
				
				<font color = green> Completa i valori con gli indicatori di riferimento:
				<br><br>
				<div align="center">
			   		<h:dataTable binding="#{table1}" value="#{ExaminationResultController.indicators}" var="row">
					    <h:column>
					    	<f:facet name="header"><h:outputText value="Indicatori"/></f:facet>  
    					    <h:inputText value="#{ExaminationResultController.indicators[table1.rowIndex]}" />
    					    
 					   </h:column>
					</h:dataTable> 		
 		
 					<h:dataTable binding="#{table2}" value="#{ExaminationResultController.values}" var="row">
 					   <h:column>
					    	<f:facet name="header"><h:outputText value="Valori"/></f:facet>  
    					    <h:inputText value="#{ExaminationResultController.values[table2.rowIndex]}" required="true"
    					     requiredMessage="valori obbligatori" id="value">
    					     <f:validateLength minimum="3" maximum="40"/> </h:inputText>
    					     <strong> <h:message for="value" style="color:red"/> </strong>
 					   </h:column>
   					</h:dataTable>
				</div>
				<div><h:commandButton value="Completa compilazione" action="#{ExaminationResultController.insertExaminationResult}"/></div>
				</font>
			</h:form>
			</f:view>
				
		</header>
		</div>
	<center>
		<a href="newFilling.jsp">Torna alla scelta dell'esame</a>
		<h2><a href="administrationArea.jsp">Torna all'area amministrativa</a></h2>
	</center>
</body>
</html>