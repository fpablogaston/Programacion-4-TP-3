package entidad;

public class Producto {
	
	private String codigo;
	private String nombre;
	private BigDecimal precio;
	private int stock;
	private int idCategoria; 
	
	public Producto() {
	}

	public Producto(String codigo, String nombre, BigDecimal precio, int stock, int idCategoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Producto [Codigo=" + codigo + ", Nombre=" + nombre + ", Precio=$" + precio + ", Stock=" + stock
				+ ", Categoria=" + categoria.getNombre() + "]";
	}
}