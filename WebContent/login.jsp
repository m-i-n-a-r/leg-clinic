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
<link rel="stylesheet" href="assets/css/main.css" />
<title>Login - LegClinic</title>
</head>
<body>

	<div id="wrap">
	<header class="major container 75%">
	<h1 align="center">BENVENUTO!</h1>
				<f:view>
				<h:form>
				
				<div>Email: <h:inputText value = "#{LoginController.email}"
					required="true"
                 	requiredMessage="Email obbligatoria" id="email"/> <h:message for="email" />
				</div>
					
				<div>Password: <h:inputSecret value = "#{LoginController.password}"
					required="true"
                 	requiredMessage="Password obbligatoria" id="password"/> <h:message for="password" />
				</div>
				<br><br>
				<div><h:commandButton value="Login"  action="#{LoginController.autenticateUser}"/></div>
				</h:form>
				</f:view>

      <div>
         Su questo sito è possibile eseguire unicamente l'accesso! Se vuoi entrare a far parte della nostra utenza,
         chiedi la registrazione in sede o via email!
      </div>

		<h2> <a href="index.jsp">Torna alla Homepage</a> </h2>
		</header>
	</div>
</body>

</html>