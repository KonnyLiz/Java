package clases;

/**
 * Write a description of class ordenTrabajoDetalle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ordenTrabajoDetalle {
	// instance variables - replace the example below with your own
	private float cantidad;
	private String descripcion;
	private int idOt;
	private int idOTD;
	private float medidaX;
	private float medidaY;
	private float precio;

	/**
	 * Constructor for objects of class ordenTrabajoDetalle
	 */
	public ordenTrabajoDetalle(float cantidad, String descripcion, int idOt,
			int idOTD, float medidaX, float medidaY, float precio) {
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.idOt = idOt;
		this.idOTD = idOTD;
		this.medidaX = medidaX;
		this.medidaY = medidaY;
		this.precio = precio;
	}

	public void setCantidad(float value) {
		this.cantidad = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setIdOtNoUser(int value) {
		this.idOt = value;
	}

	public void setIdOTD(int value) {
		this.idOTD = value;
	}

	public void setMedidaX(float value) {
		this.medidaX = value;
	}

	public void setMedidaY(float value) {
		this.medidaY = value;
	}

	public void setPrecio(float value) {
		this.precio = value;
	}

	// get metodos

	public float getCantidad() {
		return this.cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public int getIdOtNoUser() {
		return this.idOt;
	}

	public int getIdOTD() {
		return this.idOTD;
	}

	public float getMedidaX() {
		return this.medidaX;
	}

	public float getMedidaY() {
		return this.medidaY;
	}

	public float getPrecio() {
		return this.precio;
	}

}
