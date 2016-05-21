<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage - LegClinic</title>
</head>
<body>
	<h1 align="center">Benvenuto!</h1>
	<div class="container">
		<form action="loginController" method="get">
			
			Email: <input type="text" name="email" class="form-control"
				value="${param['email']}"><br>
				<font color="red"> ${emailError} </font> <br>
			
			Passoword: <input type="text" name="password" class="form-control"
				value="${param['password']}"><br>
				<font color="red"> ${passwordError} </font> <br>
				
				<input type="submit" value="Invia">
		</form>

	</div>
</body>

</html>