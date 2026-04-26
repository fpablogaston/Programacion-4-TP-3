package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Producto;

public class DaoProducto {

	private String host ="jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "wGfrVa12@";
	private String dbName = "bdinventario";
	
	public DaoProducto(){}

	public ArrayList<Producto> ListarProductos() {
		
		ArrayList<Producto> lsProducto = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);

			String query = "SELECT Codigo, Nombre, Precio, Stock, IdCategoria FROM Productos";
			ps = cn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigo(rs.getString("Codigo"));
				p.setNombre(rs.getString("Nombre"));
				p.setPrecio(rs.getBigDecimal("Precio"));
				p.setStock(rs.getInt("Stock"));
				p.setIdCategoria(rs.getInt("IdCategoria"));
				lsProducto.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lsProducto;
	}

	public Producto obtenerProductoPorId(String codigo) {
		Producto p = new Producto();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			

			String query = "SELECT Codigo, Nombre, Precio, Stock, IdCategoria FROM Productos WHERE Codigo = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, codigo); 
			rs = ps.executeQuery();

			if (rs.next()) {
				p.setCodigo(rs.getString("Codigo"));
				p.setNombre(rs.getString("Nombre"));
				p.setPrecio(rs.getBigDecimal("Precio"));
				p.setStock(rs.getInt("Stock"));
				p.setIdCategoria(rs.getInt("IdCategoria"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return p;
	}
	
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
	
	public int actualizarProducto(Producto producto) {
		String query = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";
		int filas = 0;
		Connection cn = null;
		PreparedStatement ps = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			ps = cn.prepareStatement(query);
						
			ps.setString(1, producto.getNombre());
			ps.setBigDecimal(2, producto.getPrecio());
			ps.setInt(3, producto.getStock());
			ps.setInt(4, producto.getIdCategoria());
			ps.setString(5, producto.getCodigo());
			
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

	public int borrarProducto(String codigo) {
		String query = "DELETE FROM Productos WHERE Codigo = ?";
		int filas = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			ps = cn.prepareStatement(query);
			ps.setString(1, codigo);
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
}