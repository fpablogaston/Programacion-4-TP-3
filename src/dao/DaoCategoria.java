package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DaoCategoria {

	private String host ="jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public int agregarCategoria(Categoria categoria) {
		String query = "Insert into Categorias(Nombre) values ('" + categoria.getNombre() + "')";
		Connection cn = null; 
		int filas = 0;
		
		try
		{
		cn = DriverManager.getConnection(host+dbName,user,pass);
		Statement st = cn.createStatement();
		filas = st.executeUpdate(query);
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return filas;
		}
	
		
		public Categoria obtenerCategoria(int id)
		{
			Categoria x = new Categoria();
			Connection cn = null;
			
			try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Select * from Categorias where idCategoria = "+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setIdCategoria(rs.getInt("IdCategoria"));
			x.setNombre(rs.getString("nombre"));
			}
			catch(Exception e )
			{
			e.printStackTrace();
			}
			return x;
		}


}
