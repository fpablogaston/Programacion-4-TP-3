package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

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
		
		public ArrayList<Categoria> obtenerTodasLasCategorias(){
			
			ArrayList<Categoria> lsCategoria = new ArrayList<Categoria>();
			
	        Connection cn = null;
			
			try {
				
				
				cn = DriverManager.getConnection(this.host + this.dbName, this.user, this.pass);
				String query = "Select * from Categorias ";
				Statement st = cn.createStatement();//ST ESTA PREPARADO PARA RECIBIR UNA CONSULTA
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(rs.getInt(1));
					categoria.setNombre(rs.getNString(2));
					
					lsCategoria.add(categoria);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return lsCategoria;
			
			
		}
		
		public int borrarCategoria(int idCategoria) {
			String query = "Delete from Categorias where IdCategoria ="+idCategoria;
			Connection cn = null;//DECLARAMOS UN OBJETO DE TIPO CONEXION
			int filas = 0;
			
			
			try {//INTENTAMOS CARGAR LA CONEXION
				//CN ES LA VARIABLE DE TIPO CONEXION
				
				cn = DriverManager.getConnection(this.host + this.dbName, this.user, this.pass);//INSTANCIAMO CN HACIA UNA BASE DE DATOS
				Statement st = cn.createStatement();//CREAMOS UNA CONSULTA PARA HACERLA SOBRE ESA BASE DE DATOS
				filas = st.executeUpdate(query);
				
			} catch (Exception e) {// y ACA SI NO PODEMOS CONCRETAR LA CONEXION
				e.printStackTrace();
			} finally {
				try {
					cn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			return filas;
		}
		
		
		public int ActualizarCategoria(Categoria categoria) {
			String query = "UPDATE Categorias set  Nombre= ? where IdCategoria = ? ";
			Connection cn = null;//DECLARAMOS UN OBJETO DE TIPO CONEXION
			int filas = 0;
			
			
			try {//INTENTAMOS CARGAR LA CONEXION
				//CN ES LA VARIABLE DE TIPO CONEXION
				
				cn = DriverManager.getConnection(this.host + this.dbName, this.user, this.pass);//INSTANCIAMO CN HACIA UNA BASE DE DATOS
				PreparedStatement pst = cn.prepareStatement(query);//CREAMOS UNA CONSULTA PARA HACERLA SOBRE ESA BASE DE DATOS
				pst.setString(1,categoria.getNombre());
				pst.setInt(2, categoria.getIdCategoria());
				filas = pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					cn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			return filas;
		}



}
