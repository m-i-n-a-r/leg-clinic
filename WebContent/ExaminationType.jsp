<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<title>Tipologie di esame inserita</title>
	</head>
	<body>
	<div id="main">
	<header class="major container 75%">
		<ul>
			<c:forEach var="exam" items="${examinationTypeList}">
				<li>${exam.name}: ${exam.description}</li>
			</c:forEach>
		</ul>
		</header>
		</div>
		<h3><a href="administrationArea.jsp">Torna all'area amministrativa</a></h3>

	</body>
</html>