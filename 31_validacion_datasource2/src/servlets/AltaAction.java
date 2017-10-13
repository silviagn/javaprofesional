package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionClientes gclientes=new GestionClientes();
		System.out.println(request.getParameter("user"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("email"));
		System.out.println(Integer.parseInt(request.getParameter("telefono")));
		gclientes.insertarCliente(request.getParameter("user"),
									request.getParameter("pwd"),
									request.getParameter("email"),
									Integer.parseInt(request.getParameter("telefono")));
		request.getRequestDispatcher("login.html").forward(request, response);
	}

}
