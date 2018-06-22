package clases;

/**
 * Write a description of class tipoVenta here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoVenta {
	// instance variables - replace the example below with your own
	private int idTipoDeVenta;
	private String DescripcionTipoDeVenta;

	/**
	 * Constructor for objects of class tipoVenta
	 */
	public tipoVenta(int idTipoDeVenta, String DescripcionTipoDeVenta) {
		this.idTipoDeVenta = idTipoDeVenta;
		this.DescripcionTipoDeVenta = DescripcionTipoDeVenta;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTipoVenta(int value) {
		this.idTipoDeVenta = value;
	}

	public void setDescripcionTipoDeVenta(String value) {
		this.DescripcionTipoDeVenta = value;
	}

	// Métodos Get
	public int getIdTipoVenta() {
		return this.idTipoDeVenta;
	}

	public String getDescripcionTipoDeVenta() {
		return this.DescripcionTipoDeVenta;
	}
}
