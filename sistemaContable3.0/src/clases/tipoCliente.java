package clases;

/**
 * Write a description of class tipoCliente here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoCliente {
	// instance variables - replace the example below with your own
	private int idTc;
	private String descripcion;

	/**
	 * Constructor for objects of class tipoCliente
	 */
	public tipoCliente(int idTc1, String descripcion1) {
		this.idTc = idTc1;
		this.descripcion = descripcion1.toUpperCase();
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTc(int value) {
		this.idTc = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value.toUpperCase();
	}

	// get
	public int getIdTc() {
		return this.idTc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
