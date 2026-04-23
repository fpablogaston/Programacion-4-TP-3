package entidad;

public class Producto {
	
	private String codigo;
	private String nombre;
	private double precio;
	private int stock;
	private Categoria categoria; 
	
	public Producto() {
	}

	public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	// Getters y Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [Codigo=" + codigo + ", Nombre=" + nombre + ", Precio=$" + precio + ", Stock=" + stock
				+ ", Categoria=" + categoria.getNombre() + "]";
	}
}