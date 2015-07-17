<%@page import="java.util.Random"%>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%> 
<%@ page import='java.util.Date' %> 
	
<html> 
	<head> 
		<title>Adivina el núumero</title> 
	</head> 
	
	<%!//esto es una declaración.
	int min = 0;
	int max = 100;
	int numAdivina = -1;
	boolean adivina = false;
	
	private int generarNumero(int min, int max)
	{		
		int numAdivina;
		numAdivina = ((max+min)/2);
		return numAdivina;
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	%> 
	<body>
	<%//esto es un Scriptlets.
	/* si acierta el numero*/
	if (adivina==true)
	{
		adivina=false;
		min=0;
		max=100;
		numAdivina=-1;
		%>
		<p>oleeeee</p>
		<%
	
	}
	else
	{/* si no lo acierta empieza el num adivina desde el primer numero que mostró y si es mayor va hacia arriba "hasta el 100" y empieza a descartar*/
		if (numAdivina == -1)
		{
			numAdivina = randInt(min, max);
			%>
			<p>A ver a ver ¿Es este?</p>
			<form action="adivinaNumero.jsp">
			<p>Número <input type="text" name="numero" value="<%=numAdivina%>"></p>
			<p>
				<select name="rdo">
					<option value="IGUAL">SIIII</option>
					<option value="MAYOR">es mayor</option>
					<option value="MENOR">es menor</option>
				</select>
			</p>  
			<input type="submit" value="ADIVINA">
			</form>	
			<%
		}
		else
		{//Si es igual al que piensa el IGUAL va a adivina para decir que el numero es el correcto y salir de la condicion.
			if (request.getParameter("rdo").equals("IGUAL"))
			{
				adivina = true;
				response.sendRedirect("adivinaNumero.jsp");
			}
			else
			{
				if (request.getParameter("rdo").equals("MENOR"))
				{
					adivina = false;
					max = numAdivina;
					%>
					<p>limite minimo <%=min %></p>
					<p>limite máximo <%=numAdivina %></p>
					<% 					
					numAdivina = generarNumero(min, numAdivina);
					%>
					<p>Tu número es menor... mmmm ¿Es este?</p>
					<form action="adivinaNumero.jsp">
					<p>Número <input type="text" name="numero" value="<%=numAdivina%>"></p>
					<p>
						<select name="rdo">
							<option value="IGUAL">SIIII</option>
							<option value="MAYOR">es mayor</option>
							<option value="MENOR">es menor</option>
						</select>
					</p>  
					<input type="submit" value="ADIVINA">
					</form>	
					<%
				}
				else
				{
					adivina = false;
					min = numAdivina;
					%>
					<p>limite minimo <%=numAdivina %></p>
					<p>limite máximo <%=max %></p>
					<% 
					
					numAdivina = generarNumero(numAdivina, max);
					%>
					<p>Tu número es mayor... mmmm ¿Es este?</p>
					<form action="adivinaNumero.jsp">
					<%// en numAdivina es una Expresion. %>
					<p>Número <input type="text" name="numero" value="<%=numAdivina%>"></p>
					<p>
						<select name="rdo">
							<option value="IGUAL">SIIII</option>
							<option value="MAYOR">es mayor</option>
							<option value="MENOR">es menor</option>
						</select>
					</p>
					<input type="submit" value="ADIVINA">  
					</form>	
					<%
				}
			}		
		}
	}
	%>
	</body> 
</html> 