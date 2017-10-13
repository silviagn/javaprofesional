<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="Login" method="POST">
		 <%String user="";
		 Cookie[] todas=request.getCookies();
		 if(todas!=null){
			 for(Cookie c:todas){
				 if(c.getName().equals("user")){
					 user=c.getValue();
				 }
			 }
		 }
		  %>
		
			Usuario:<input type="text" name="user" value="<%=user%>"/><br/>
			Contraseña:<input type="password" name="pwd"/><br/>
			Recordar:<input type="checkbox" name="recordar" value="1"/>
			<br/>
			<input type="submit" value="Enviar"/><br/>
		</form>
	
	</center>

</body>
</html>