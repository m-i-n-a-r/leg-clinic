<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.leg.model.Doctor"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ page import="it.leg.model.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../assets/css/main.css" />
<title>Area Personale</title>
</head>
<body>
	<div id="main">
	<header class="major container 75%">
		<center>
			<h1>
				<font>Benvenuto nell'area personale</font>
			</h1><br>
		</center>
		<center>
			<f:view>
				<h:form>
					<b>Email: </b><h:outputText value="#{LoginController.email}" />
				</h:form>
			</f:view>
		</center>
		</header>
		
	</div>
	<br>
	<center>
		<a href="../faces/examinationTypeList.jsp">Consulta offerta</a>
		
		<br>
		<h2><a href="../faces/login.jsp">Log out</a></h2>
	</center>
</body>
</html>