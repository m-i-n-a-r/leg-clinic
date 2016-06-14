


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
<title> lista esami</title>
</head>
<body>
	
	<div id="main">
	    <header class="major container 75%">
	    <f:view>
		    <h:form>
		        <ul>
				<c:forEach var="examination" items="#{ExaminationController.patientExamination}">
					<div align="center">
			     		<h:outputText value="#{examination.type.name}"/>
					</div>
				</c:forEach>
				</ul>
			</h:form>
		</f:view>
		<a href="personalArea.jsp">Torna all'area personale</a>
		</header>
	</div>
</body>

</html>
