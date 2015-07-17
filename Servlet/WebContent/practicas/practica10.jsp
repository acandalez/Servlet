<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='main.dto_hibernate.DepartamentoDTO' %>
<%@ page import='java.util.List' %>
<%@ page import='java.util.Iterator' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Lista de Departamentos</h2>
<%

List<DepartamentoDTO> listaDepartamentos = (List<DepartamentoDTO>)request.getAttribute("listaDepartamentos");
Iterator it = listaDepartamentos.iterator();
%>


</body>
</html>