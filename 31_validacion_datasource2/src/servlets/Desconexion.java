package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Desconexion
 */
@WebServlet("/Desconexion")
public class Desconexion extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos la sesi�n y la invalidamos
		HttpSession s=request.getSession();
		s.invalidate();
		//volvemos p�gina de inicio
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
