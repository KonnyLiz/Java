package clases;

/**
 * Write a description of class tipoProducto here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoProducto {
	// instance variables - replace the example below with your own
	private int idTipoProducto;
	private String descripcion;

	/**
	 * Constructor for objects of class tipoProducto
	 */
	public tipoProducto(int idTipoProducto, String descripcion) {
		// initialise instance variables
		this.idTipoProducto = idTipoProducto;
		this.descripcion = descripcion;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTipoProducto(int value) {
		this.idTipoProducto = value;
	}

	public void setDescripcionTipoProducto(String value) {
		this.descripcion = value;
	}

	// métodos Get
	public int getIdTipoProducto() {
		return this.idTipoProducto;
	}

	public String getDescripcionTipoProducto() {
		return this.descripcion;
	}

}
