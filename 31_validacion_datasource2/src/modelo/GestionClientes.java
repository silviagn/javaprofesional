package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import beans.Cliente;

public class GestionClientes {
	DataSource ds;

	public GestionClientes() {
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }    
	
	public boolean estaRegistrado(String user, String pass) {
		boolean res=false;
		try(Connection con=ds.getConnection();) { 
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public void insertarCliente(String usuario, String password, String email, int telefono) {
		boolean res=false;
		try(Connection con=ds.getConnection();) { 
			String sql="insert into clientes (usuario,password,email,telefono) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, telefono);
		    ps.execute();
	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	
	}
	

}
