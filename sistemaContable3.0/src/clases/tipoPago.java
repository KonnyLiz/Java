package clases;

/**
 * Write a description of class tipoPago here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoPago {
	// instance variables - replace the example below with your own
	private int idTipoPago;
	private String descripcionTipoPago;

	/**
	 * Constructor for objects of class tipoPago
	 */
	public tipoPago(int idTipoPago, String descripcionTipoPago) {
		this.idTipoPago = idTipoPago;
		this.descripcionTipoPago = descripcionTipoPago;

	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTp(int value) {
		this.idTipoPago = value;
	}

	public void setDescripcionTp(String value) {
		this.descripcionTipoPago = value;
	}

	// métodos get
	public int getIdTp() {
		return this.idTipoPago;
	}

	public String getDescripcionTp() {
		return this.descripcionTipoPago;
	}

}
