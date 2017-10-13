<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Libro, modelo.GestionTemas"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%

	List<Libro> libros=(List<Libro>)request.getAttribute("libros");	
	%>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<select name = libro>
	<option value = "0">Todos></option>
	<%for(Libro l:libros){ %>
		<option value =" <%=l.getIsbn()%>"><%=l.getTitulo()%></option>
    <%} %>
	</select>
		<br/><br/><br/><br/><br/>
	<%	
	
	%>
	<a href="Controller?op=toInicio">Volver</a>
</body>
</html>