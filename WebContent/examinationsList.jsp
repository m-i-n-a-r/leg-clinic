<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Esami disponibili - LegClinic</title>
</head>
<body>
	<h1 align="center">Qui puoi visalizzare la nostra offerta</h1>
	<div id="main">
	    <header class="major container 75%">
	    <f:view>
		    <h:form>
				<c:forEach var="tipologiaEsame" items="#{ExaminationTypeController.examinationTypeList}">
					<div align="center">
			     		<h:outputText value="#{tipologiaEsame.name}"/>
					</div>
				</c:forEach>
			</h:form>
		</f:view>
		<a href="index.html">Torna alla Homepage</a>
		</header>
	</div>
</body>

</html>
