package clases;

/**
 * Write a description of class proforma here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class proforma {

	// instance variables - replace the example below with your own
	private int idProforma;
	private String ciRuc;
	private String fecha;
	private String ciudad;
	private float subtotal;
	private float total;
	private float iva;
	private String estado;

	/**
	 * Constructor for objects of class proforma
	 */
	public proforma(int idProforma, String ciRuc, String fecha, String ciudad,
			float subtotal, float total, float iva, String estado) {
		this.idProforma = idProforma;
		this.ciRuc = ciRuc;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.subtotal = subtotal;
		this.total = total;
		this.iva = iva;
		this.estado = estado;
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

	public void setCiRuc(String value) {
		this.ciRuc = value;
	}

	public void setFecha(String value) {
		this.fecha = value;
	}

	public void setCiudad(String value) {
		this.ciudad = value;
	}

	public void setSubtotal(float value) {
		this.subtotal = value;
	}

	public void setTotal(float value) {
		this.total = value;
	}

	public void setIva(float value) {
		this.iva = value;
	}

	public void setEstado(String value) {
		this.estado = value;
	}

	// get metodos

	public int getIdProforma() {
		return this.idProforma;
	}

	public String getCiRuc() {
		return this.ciRuc;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public float getSubtotal() {
		return this.subtotal;
	}

	public float getTotal() {
		return this.total;
	}

	public float getIva() {
		return this.iva;
	}

	public String getEstado() {
		return this.estado;
	}

}
