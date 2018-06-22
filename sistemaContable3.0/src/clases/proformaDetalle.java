package clases;

/**
 * Write a description of class proformaDetalle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class proformaDetalle {
	// instance variables - replace the example below with your own

	private int idProforma;
	private int idPro;
	private float cantidad;
	private String descripcion;
	private float medidaX;
	private float medidaY;
	private float precio;
	private float total;

	/**
	 * Constructor for objects of class proformaDetalle
	 */
	public proformaDetalle(int idProforma, int idPro, int cantidad,
			String descripcion, int medidaX, float medidaY, float precio,
			float total) {

		this.idProforma = idProforma;
		this.idPro = idPro;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.medidaX = medidaX;
		this.medidaY = medidaY;
		this.precio = precio;
		this.total = total;

	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdProforma(int value) {
		this.idProforma = value;
	}

	public void setIdPro(int value) {
		this.idPro = value;
	}

	public void setIdDescripcion(String value) {
		this.descripcion = value;
	}

	public void setIdMedidaX(float value) {
		this.medidaX = value;
	}

	public void setIdMedidaY(float value) {
		this.medidaY = value;
	}

	public void setIdPrecio(float value) {
		this.precio = value;
	}

	public void setCantidad(float float1) {
		this.cantidad = float1;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	// /get metodos

	public int getIdProforma() {
		return this.idProforma;
	}

	public int getIdPro() {
		return this.idPro;
	}

	public String getIdDescripcion() {
		return this.descripcion;
	}

	public float getIdMedidaX() {
		return this.medidaX;
	}

	public float getIdMedidaY() {
		return this.medidaY;
	}

	public float getIdPrecio() {
		return this.precio;
	}

	public float getCantidad() {
		return cantidad;
	}

	public float getTotal() {
		return total;
	}
}
