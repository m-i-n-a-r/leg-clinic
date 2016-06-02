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
		<form action="loginController" method="post">
			
			Email: <input type="email" name="email" placeholder="Il tuo indirizzo mail" class="form-control"
				value="${param['email']}"><br>
				<font color="red"> ${emailError} </font> <br>
				
			Password: <input type="password" name="password" placeholder="La tua password" class="form-control"
				value="${param['password']}"><br>
				<font color="red">${passwordError} </font> <br>
				
				<input type="submit" value="Invia"><br>
				<font color="red">${loginError}</font><br>
		</form>

      <div>
         Su questo sito è possibile eseguire unicamente l'accesso! Se vuoi entrare a far parte della nostra utenza,
         chiedi la registrazione in sede o via email!
      </div>

		<h2> <a href="index.html">Torna alla Homepage</a> </h2>
		</header>
	</div>
</body>

</html>