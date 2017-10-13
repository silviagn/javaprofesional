package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Libro;
import beans.Tema;
public class GestionTemas {

	DataSource ds;

	public GestionTemas() {
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }    
	
	public List<Tema> recuperarTemas(){
		ArrayList<Tema> temas=new ArrayList<>();
		//creamos la conexión contra la base de datos
		try(Connection con=ds.getConnection();) { 						
					//definimos la instrucción SQL y la enviamos a través del objeto Statement
					String sql="Select * from temas";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						temas.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
					}										
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				return temas;
	}
	public List<Libro> recuperarLibro(int idTema){
		ArrayList<Libro> libros=new ArrayList<>();
		//creamos la conexión contra la base de datos
		try(Connection con=ds.getConnection();) { 						
					//definimos la instrucción SQL y la enviamos a través del objeto Statement
					String sql="Select * from libros where idTema=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, idTema);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						libros.add(new Libro(rs.getInt("isbn"),
								rs.getString("titulo"),
								rs.getString("autor"),
								rs.getDouble("precio"),
								rs.getInt("paginas"),
								rs.getInt("idTema")));
					}										
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				return libros;
	}
}
