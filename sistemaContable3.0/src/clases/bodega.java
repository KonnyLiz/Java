package clases;

/**
 * Write a description of class tipoPago here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class bodega {
	// instance variables - replace the example below with your own
	private int idbodega;
	private String descripcionBodega;
	private String datoAdicional;

	/**
	 * Constructor for objects of class tipoPago
	 */
	public bodega(int idbodega, String descripcionBodega, String datoAdicional) {
		this.idbodega = idbodega;
		this.descripcionBodega = descripcionBodega;
		this.datoAdicional = datoAdicional;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdBodega(int value) {
		this.idbodega = value;
	}

	public void setDescripcionBodega(String value) {
		this.descripcionBodega = value;
	}

	public void setDatoAdicional(String value) {
		this.datoAdicional = value;
	}

	// métodos get
	public int getIdBodega() {
		return this.idbodega;
	}

	public String getDescripcionBodega() {
		return this.descripcionBodega;
	}

	public String getDatoAdicional() {
		return this.datoAdicional;
	}

}
