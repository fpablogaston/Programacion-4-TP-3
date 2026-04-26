package main;

import dao.DaoCategoria;
import entidad.Categoria;

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
		DaoCategoria daoCatego1 = new DaoCategoria();
        filasAfectadas=daoCatego1.borrarCategoria(4);
		
		if(filasAfectadas == 1) {
			System.out.println("Categoría eliminada");
		}else {
			System.out.println("categoría no eliminada");
		}

	}

}
