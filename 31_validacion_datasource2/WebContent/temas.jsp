<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.List,beans.Tema, modelo.GestionTemas"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>
	<center>
            <h1>Seleccione Tema a consultar</h1>
            <br/><br/>
		<form  action="Controller?op=doTemas" method="post">
			<select name="tema">
				<option value="0">Todos</option>
				
				<%List<Tema> temas=(List<Tema>)request.getAttribute("temas");
				for(Tema t:temas){%>
				
					<option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>
				<%}%>
			</select>
			<br/>
			<input type="submit" value="Ver libros"/>
			
		</form>

	
	</center>

</body>
</html>