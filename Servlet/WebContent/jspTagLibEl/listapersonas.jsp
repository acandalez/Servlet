<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--Le estamos diciendo que vamos a coger las librerias del prefijo c de la libreria jstl/core --%>
    <%@ page import="ejemploval.Persona, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Persona> lista_personas = new ArrayList<Persona>();
lista_personas.add(new Persona(22, "Eva"));
lista_personas.add(new Persona(38, "Carmen"));
lista_personas.add(new Persona(25, "Juan"));
lista_personas.add(new Persona(61, "Jesús"));
session.setAttribute("lista_personas", lista_personas);
%>

<br>PRIMER FORMA, con puntos, recorrido tipo Iterator<br>
<c:forEach items="${lista_personas}" var="persona" varStatus="i"><%--ITEMS se refiere a el objeto lista personas la cual recorremos por forEach | conjunto de datos al que se refiere --%>
	
	
	<c:out value="${persona.nombre}"></c:out><%--el c:out solo imprime --%>
	<%--Recoge el nombre de la persona, lo que esta pasando es que va a la clase Persona y 
	al poner persona.nombre esta refiriendose a Persona getnombre | con el $ nos referimos a la lista de la que recuperamos
	los objetos de la lista.--%>
	
	
	
	<c:if test="${persona.nombre eq 'Eva'}"><%--el c:if muestra la condicion. Comprueba el nombre de la persona --%>
		<c:out value="${'La persona Eva está en la pos'}"></c:out>
		<c:out value="${i.index}"></c:out>
	</c:if>
	<c:out value="${persona.edad}"></c:out><%--Recoge la edad de la persona --%>
</c:forEach>
<br>


<br>SEGUNDA, especifico inicio y fin, recorrido tipo Array<br>

<c:forEach items="${lista_personas}" begin="0" end="3" varStatus="i">
<%--begind y end son los indices que le indicamos para recorrer una lista desde la posicion "0" a la "3" --%>
	
	
	<c:out value="${lista_personas[i.index].nombre}"></c:out>
	<%--Con esto vamos sacando el nombre y el contador lo indicamos con [i.index] --%>
	
	
	<c:out value="${lista_personas[i.index].edad}"></c:out>
</c:forEach>

</body>
</html>