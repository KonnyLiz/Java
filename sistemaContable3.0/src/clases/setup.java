package clases;

/**
 * Write a description of class setup here.
 * 
 * @author (carlos)
 * @version (a version number or a date)
 */
public class setup {
	// instance variables - replace the example below with your own
	private float iva;
	private String claveAdmin;
	private String impresoraNombre;

	/**
	 * Constructor for objects of class setup
	 */
	public setup(float iva, String claveAdmin, String impresoraNombre) {
		this.iva = iva;
		this.claveAdmin = claveAdmin;
		this.impresoraNombre = impresoraNombre;

	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIva(float value) {
		this.iva = value;
	}

	public void setClaveAdministracion(String value) {
		this.claveAdmin = value;
	}

	public void setImpresoraNombre(String value) {
		this.impresoraNombre = value;
	}

	// métodos get
	public float getIva() {
		return this.iva;
	}

	public String getClaveAdministracion() {
		return this.claveAdmin;
	}

	public String getImpresoraNombre() {
		return this.impresoraNombre;
	}

}
