<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adivina el numero con JSP</title>
</head>
<body>
	<div align ="center">
		<h3>Piensa en un numero</h3>
		<form action = "AdivinarNumero.jsp">
			<label>Estabas pensando en:</label><input type="text" name = "adivinar" value=""/>
			<br>
			<select name = "option">
				<option id="mayor">MAYOR</option> 
				<option id="menor">MENOR</option>
				<option id="igual">IGUAL</option>
			</select>
			<input type="submit" value="Confirmar"/>
		</form>
	</div>
<%  %>

</body>
</html>