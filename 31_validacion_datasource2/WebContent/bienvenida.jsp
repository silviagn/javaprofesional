<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String usuario=(String)session.getAttribute("user");
	String tema=request.getParameter("tema");%>
	<h1>Bienvenido <%=usuario %></h1>
	<h2>Has elegido el tema <%=tema %></h2>
	<br/>
	<%=LocalTime.now() %>
	<br/>
	<a href="Desconexion">Desconectar</a>
</body>
</html>