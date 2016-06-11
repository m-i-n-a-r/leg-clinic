<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.ExaminationType"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Amplia offerta</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci una nuova tipologia di esame</font>
			</h1><br>
				
				<f:view>
				<h:form>
				
				<div align="center">
					Nome Tipologia: <h:inputText value="#{ExaminationTypeController.name}" required="true"
					requiredMessage="Nome Tipologia Esame obbligatorio!" id="TypeName"/>
				</div>
				
				<div align="center">
					Prezzo: <h:inputText value="#{ExaminationTypeController.cost}" required="true"
					requiredMessage="Specificare un costo" id="TypeCost"/>
				</div>
				
				<div align="center">
					Descrizione Tipologia: <h:inputText value="#{ExaminationTypeController.description}" required="true"
					requiredMessage="E' richiesta una descrizione" id="TypeDescription"/>
				</div>
				<br><br>
				<div align="center">
					Nomi degli indicatori, separati da una virgola: 
					<h:inputText value="#{ExaminationTypeController.indicatorNames}" required="true"
					requiredMessage="Specificare almeno un indicatore" id="IndicatorNames"/>
				</div>
				<br><br>
				<div align="center">
					<h:commandButton value="Crea tipologia" action="#{ExaminationTypeController.createExaminationType}"/>
				</div>
			</h:form>
			</f:view>
			<h2> <a href="index.jsp">Torna alla Homepage</a> </h2>
		</header>
		</div>
	</body>
</html>