package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import modelo.GestionClientes;
import modelo.GestionTemas;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		String us=request.getParameter("user");
		GestionClientes gclientes=new GestionClientes();
		if(gclientes.estaRegistrado(us, pwd)){
		//recuperamos los temas
			GestionTemas gtemas =new GestionTemas();
			List<Tema> temas= gtemas.recuperarTemas();
			if(temas==null||temas.size()==0) {
				request.getRequestDispatcher("sintemas.jsp").forward(request, response);
			}
			request.setAttribute("temas", temas);
			request.getRequestDispatcher("temas.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("error.jsp").forward(request, response);
		
			
	}	

}
