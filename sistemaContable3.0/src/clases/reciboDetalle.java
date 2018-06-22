package clases;

/**
 * Write a description of class reciboDetalle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class reciboDetalle {
	// instance variables - replace the example below with your own
	private int idRecibo;
	private int idProducto;
	private String descripcion;
	private float medidaX;
	private float medidaY;
	private float precio;

	/**
	 * Constructor for objects of class reciboDetalle
	 */
	public reciboDetalle(int idRecibo, int idProducto, String descripcion,
			float medidaX, float medidaY, float precio) {
		this.idRecibo = idRecibo;
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.medidaX = medidaX;
		this.medidaY = medidaY;
		this.precio = precio;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdRecibo(int value) {
		this.idRecibo = value;
	}

	public void setIdProducto(int value) {
		this.idProducto = value;
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

	public void setPrecio(float value) {
		this.precio = value;
	}

	// métodos get
	public int getIdRecibo() {
		return this.idRecibo;
	}

	public int getIdProducto() {
		return this.idProducto;
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

	public float getPrecio() {
		return this.precio;
	}

}
