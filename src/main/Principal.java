package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {
	
	
	public static void main(String[] args) {
		
		DaoCategoria daoCatego1 = new DaoCategoria();
		DaoProducto daoProd = new DaoProducto();
		int filasAfectadas=0;
		
		//CATEGORIAS
		
		//Prueba Metodo agregarCategoria		
		Categoria catego1 = new Categoria();
		catego1.setNombre("Nueva Categoria");		
		
		filasAfectadas = daoCatego1.agregarCategoria(catego1);
		
		if(filasAfectadas == 1) {
			System.out.println("Categoria agregada");
		}else {
			System.out.println("Categoria no agregada");
		}
		
		//Prueba Metodo obtenerTodasLasCategorias
		System.out.println("Listado de categorias: ");
		mostrarCategorias(daoCatego1);
		
	    //Prueba Metodo ActualizarCategoria
		System.out.println("Modificando categoria: ");
		
		Categoria categoriaModificada = new Categoria(4,"Calzado");
		int filasModificadas = daoCatego1.ActualizarCategoria(categoriaModificada);
		if(filasModificadas > 0) {
			System.out.println("Categoria modificada correctamente");
		}else {
			System.out.println("Categoria no modificada");
		}
		
		mostrarCategorias(daoCatego1);
		
					
		
		//Prueba Metodo borrarCategoria
		
        filasAfectadas=daoCatego1.borrarCategoria(4);
		
		if(filasAfectadas == 1) {
			System.out.println("Categoría eliminada");
		}else {
			System.out.println("categoría no eliminada");
		}
		mostrarCategorias(daoCatego1);
		
		
	
	
	// PRODUCTOS
	
		DaoProducto daoProducto = new DaoProducto();
		Producto p1 = new Producto("P0011", "Notebook", new BigDecimal("1500.00"), 10, 1);
		int filas = daoProducto.agregarProducto(p1);
		System.out.println(filas == 1 ? "Producto agregado" : "Error al agregar");
		
	//Prueba cargar 10 productos
		System.out.println("Cargando 10 productos");
		cargar10Productos(daoProd);

		System.out.println("Listado de productos: ");
		mostrarProductos(daoProd);
		
		//Prueba Metodo actualizarProducto
		System.out.println("Modificando producto: ");				
		Producto prodModificado = new Producto("P001", "Producto modificado", new BigDecimal("150000.50"), 15, 1);
		int filasModificadas1 = daoProd.actualizarProducto(prodModificado);
			if(filasModificadas1 > 0) {
				System.out.println("Producto modificado correctamente");
			}else {
				System.out.println("Producto no modificado");
			}
				
		//Prueba Metodo borrarProducto
		System.out.println("Eliminando producto");		 
		int filasBorradas = daoProd.borrarProducto("P0011");
			if(filasBorradas > 0) {
				System.out.println("Producto eliminado correctamente");
			}else {
				System.out.println("Producto no eliminado");
			}

		mostrarCategorias(daoCatego1);
		mostrarProductos(daoProd);		
		
	

	}
	
	private static void mostrarCategorias(DaoCategoria daoCatego1) {
		ArrayList<Categoria> lista = daoCatego1.obtenerTodasLasCategorias();
		for (Categoria c : lista) {
			System.out.println(c.toString());
		}
	}
	
	private static void cargar10Productos(DaoProducto daoProd) {
		// Creamos 8 productos con el INSERT normal
		daoProd.agregarProducto(new Producto("P001", "Notebook Asus", new BigDecimal("120000.00"), 10, 1));
		daoProd.agregarProducto(new Producto("P002", "Mouse Inalámbrico", new BigDecimal("5500.00"), 50, 1));
		daoProd.agregarProducto(new Producto("P003", "Teclado Mecánico", new BigDecimal("15000.00"), 20, 1));
		daoProd.agregarProducto(new Producto("P004", "Remera Puma", new BigDecimal("1200.50"), 100, 2));
		daoProd.agregarProducto(new Producto("P005", "Remera Nike", new BigDecimal("800.00"), 200, 2));
		daoProd.agregarProducto(new Producto("P006", "Short Adidas", new BigDecimal("4500.00"), 30, 2));
		daoProd.agregarProducto(new Producto("P007", "Zapatillas", new BigDecimal("3500.00"), 40, 4));
		daoProd.agregarProducto(new Producto("P008", "Zapatos", new BigDecimal("8900.00"), 15, 4));

		// Creamos 2 usando el SP
		System.out.println("-> Ejecutando SP para agregar los últimos 2 productos...");
		daoProd.ejecutarSPAgregarProducto(new Producto("P009", "Zapatillas Deportivas", new BigDecimal("25000.00"), 12, 4));
		daoProd.ejecutarSPAgregarProducto(new Producto("P010", "Gorra Negra", new BigDecimal("2000.00"), 25, 2));
		
		System.out.println("10 productos cargados correctamente");
	}

	private static void mostrarProductos(DaoProducto daoProd) {
		ArrayList<Producto> lista = daoProd.ListarProductos();
		for (Producto p : lista) {
			System.out.println(p.toString());
		}
	}
	
}
