package clases;

public class InventarioDetalle {
	private int idInventario;
	private int idProducto;
	private float precioCompra;
	private float totalBruto;
	private String fechaIngreso;
	private String fechaCaducidad;

	public InventarioDetalle(int idInventario, int idProducto,
			float precioCompra, float totalBruto, String fechaIngreso,
			String fechaCaducidad) {
		this.idInventario = idInventario;
		this.idProducto = idProducto;
		this.totalBruto = totalBruto;
		this.fechaIngreso = fechaIngreso;
		this.fechaCaducidad = fechaCaducidad;
		this.precioCompra = precioCompra;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public void setTotalBruto(float totalBruto) {
		this.totalBruto = totalBruto;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public float getTotalBruto() {
		return totalBruto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}

}
