package main;
import java.math.BigDecimal;
//import entidad.Categoria;
import entidad.Producto;
import dao.DaoCategoria;
import dao.DaoProducto;


public class Principal {

	public static void main(String[] args) {
		int filasAfectadas=0;
		
		
		//Prueba Metodo agregarCategoria
		
		/*Categoria catego1 = new Categoria();
		catego1.setNombre("Nueva Categoria");
		
		DaoCategoria daoCatego1 = new DaoCategoria();
		filasAfectadas = daoCatego1.agregarCategoria(catego1);
		
		if(filasAfectadas == 1) {
			System.out.println("Categoria agregada");
		}else {
			System.out.println("Categoria no agregada");
		}*/
		
		//Prueba Metodo borrarCategoria
		/*
		 * DaoCategoria daoCatego1 = new DaoCategoria();
		 * filasAfectadas=daoCatego1.borrarCategoria(4);
		 * 
		 * if(filasAfectadas == 1) { System.out.println("Categoría eliminada"); }else {
		 * System.out.println("categoría no eliminada"); }
		 */



		// PRODUCTOS
		DaoProducto daoProducto = new DaoProducto();
		Producto p1 = new Producto("P001", "Notebook", new BigDecimal("1500.00"), 10, 1);
		int filas = daoProducto.agregarProducto(p1);
		System.out.println(filas == 1 ? "Producto agregado" : "Error al agregar");

	}

}
