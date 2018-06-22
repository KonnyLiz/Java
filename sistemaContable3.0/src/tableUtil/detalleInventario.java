package tableUtil;

public class detalleInventario {
	float cantidad;
	String fechaIngreso;
	String fechaCaducidad;
	float precioCompra;
	boolean eliminar;

	public detalleInventario(float cantidad, String fechaIngreso,
			String fechaCaducidad, float precioCompra, boolean eliminar) {
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaCaducidad = fechaCaducidad;
		this.precioCompra = precioCompra;
		this.eliminar = eliminar;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getCantidad() {
		return cantidad;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public boolean getEliminar() {
		return eliminar;
	}

}
