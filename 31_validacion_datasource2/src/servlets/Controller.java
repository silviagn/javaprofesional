package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "doLogin":
				url="LoginAction";
				break;
			case "doTemas":
				url="TemasAction";
				break;				
			case "toRegistrar":
				url="registrar.html";
				break;		
			case "doAlta":
				url="AltaAction";
				break;

			case "toInicio":
				url="login2.html";
				break;

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
