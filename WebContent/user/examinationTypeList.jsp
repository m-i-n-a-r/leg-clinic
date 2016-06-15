<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Esami disponibili - LegClinic</title>
</head>
<body>
	<h1 align="center">Qui puoi visalizzare la nostra offerta</h1>
	<div id="main">
	    <header class="major container 75%">
			<f:view>
			<h:form>
				<div align="center">
					<h:dataTable value="#{ExaminationTypeController.examinationTypeList}" var="examinationType">
   						<h:column> 
   							<f:facet name="header"><h:outputText value="Nome"/></f:facet>   					  				
      						<h:outputText value="#{examinationType.name}"/>
   						</h:column>
   						<h:column> 				
      						<f:facet name="header"><h:outputText value="Descrizione"/></f:facet>    				
      						<h:outputText value="#{examinationType.description}"/>
   						</h:column>
   						<h:column>
      						<f:facet name="header"><h:outputText value="Prezzo in €"/></f:facet> 
      						<h:outputText value="#{examinationType.cost}"/>
   						</h:column>
					</h:dataTable>
				</div>
			</h:form>
			</f:view>
		</header>
	</div>
	<h1><a href="personalArea.jsp">Torna all'area personale</a></h1>
</body>
</html>