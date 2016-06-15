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
<title>Consultazione risultati</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Sono qui mostrati i risultati dell'esame selezionato</font>
			</h1>
			<f:view>
			<h:form>
			
				<div align="center">			   		
				<h:dataTable binding="#{table}" value="#{ExaminationController.examination.results}" var="row">
					    <h:column>
				
					    	<f:facet name="header"><h:outputText value="Valori riscontrati:"/></f:facet>  
    					    <h:outputText value="#{ExaminationController.examination.results[table.rowIndex]}" />
    					    
 					   </h:column>
				</h:dataTable> 	
				</div>
			
			</h:form>
			</f:view>
				
		</header>
		</div>
			
		<center>
		<a href="personalExamination.jsp">Torna allo storico degli esami</a>
		<h2><a href="administrationArea.jsp">Torna all'area amministrativa</a></h2>
		</center>
</body>
</html>