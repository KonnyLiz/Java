package tableUtil;

/**
 * Write a description of class ordenTrabajoDetalle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class detalleOdtRecibo {
	// instance variables - replace the example below with your own
	private float cantidad;
	private String descripcion;
	private String medidaX;
	private float precioU;
	private float precio;
	private boolean eliminar;

	/**
	 * Constructor for objects of class ordenTrabajoDetalle
	 */
	public detalleOdtRecibo(float cantidad, String descripcion, String medidaX,
			float precio, float precio2, boolean eliminar) {
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.medidaX = medidaX;
		this.precioU = precio;
		this.precio = precio2;
		this.eliminar = eliminar;
	}

	public void setCantidad(float value) {
		this.cantidad = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setMedidaX(String value) {
		this.medidaX = value;
	}

	public void setPrecio(float value) {
		this.precio = value;
	}

	public void setEliminar(boolean value) {
		this.eliminar = value;
	}

	public void setPrecioUnidad(float value) {
		this.precioU = value;
	}

	// get metodos

	public float getCantidad() {
		return this.cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getMedidaX() {
		return this.medidaX;
	}

	public float getPrecio() {
		return this.precio;
	}

	public boolean getEliminar() {
		return this.eliminar;
	}

	public float getPrecioUnidad() {
		return this.precioU;
	}
}
