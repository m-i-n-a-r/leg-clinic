<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Doctor"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Nuovo Prerequisito Per Tipologia</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
			<h1>
				<font>Inserisci un nuovo prerequisito</font>
			</h1><br>
			
				<f:view>
				<h:form>
				<div>Id tipologia: <h:inputText value = "#{ExaminationTypeController.examinationTypeId}"
					required="true"
                 	requiredMessage="id obbligatorio" id="typeId"/> <h:message for="typeId" />
				</div>
				<div>Nome Prerequisito: <h:inputText value = "#{ExaminationTypeController.conditionName}"
					required="true"
                 	requiredMessage="Nome obbligatorio" id="typeName"/> <h:message for="nome" />
				</div>
					
				<div>Descrizione Prerequisito: <h:inputText value = "#{ExaminationTypeController.conditionDescr}"
					required="true"
                 	requiredMessage="Descrizione obbligatoria" id="typeDescription"/> <h:message for="typeDescription" />
				</div>
				
					
				<br><br>
				<div><h:commandButton value="Aggiungi prerequisito"  action="#{ExaminationTypeController.addCondition}"/></div>
				</h:form>
				</f:view>
		</header>
		</div>

		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>
</body>
</html>