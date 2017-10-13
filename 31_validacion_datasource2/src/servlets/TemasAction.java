package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import beans.Libro;
import modelo.GestionTemas;

/**
 * Servlet implementation class TemasAction
 */
@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("tema"));
		System.out.print("tema elegido"+idTema);
		GestionTemas gtemas =new GestionTemas();
		
		List<Libro> libros= gtemas.recuperarLibro(idTema);
		if(libros==null||libros.size()==0) {
			request.getRequestDispatcher("sinlibros.jsp").forward(request, response);
		}
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
