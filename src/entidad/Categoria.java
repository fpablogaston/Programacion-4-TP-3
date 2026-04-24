package entidad;

public class Categoria {
	
	private int idCategoria;
	private String nombre;
	
	public  Categoria() {}
	
	public Categoria (int idCategoria, String nombre) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		
	}
	
	@Override
	public String toString() {
		return "Categoria [ID=" + idCategoria + ", Nombre=" + nombre + "]";
	}
	
	
}
