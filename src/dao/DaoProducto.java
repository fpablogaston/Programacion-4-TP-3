package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidad.Producto;

public class DaoProducto {

	private String host ="jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public DaoProducto(){}


	public int agregarProducto(Producto producto) {
	    String query = "INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES (?, ?, ?, ?, ?)";
	    int filas = 0;
	    Connection cn = null;
	    PreparedStatement ps = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        ps = cn.prepareStatement(query);
	        ps.setString(1, producto.getCodigo());
	        ps.setString(2, producto.getNombre());
	        ps.setBigDecimal(3, producto.getPrecio());
	        ps.setInt(4, producto.getStock());
	        ps.setInt(5, producto.getIdCategoria());
	        filas = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return filas;
	}


	public void ejecutarSPAgregarProducto(Producto producto) {
	    String query = "{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}";
	    Connection cn = null;
	    CallableStatement cst = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        cst = cn.prepareCall(query);
	        cst.setString(1, producto.getCodigo());
	        cst.setString(2, producto.getNombre());
	        cst.setBigDecimal(3, producto.getPrecio());
	        cst.setInt(4, producto.getStock());
	        cst.setInt(5, producto.getIdCategoria());
	        cst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (cst != null) cst.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}