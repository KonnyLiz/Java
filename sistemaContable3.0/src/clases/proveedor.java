package clases;

/**
 * Write a description of class proveedor here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class proveedor {
	// instance variables
	private int idProveedor;
	private String descripcion;
	private String telefono1;
	private String telefono2;
	private String pais;
	private String ciudad;
	private String contacto;
	private String ruc;

	/**
	 * Constructor for objects of class proveedor
	 */
	public proveedor(int idProveedor, String descripcion, String telefono1,
			String telefono2, String pais, String ciudad, String contacto,
			String ruc) {
		this.idProveedor = idProveedor;
		this.descripcion = descripcion;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.pais = pais;
		this.ciudad = ciudad;
		this.contacto = contacto;
		this.ruc = ruc;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdProveedor(int value) {
		this.idProveedor = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setTelefono(String value) {
		this.telefono1 = value;
	}

	public void setTelefono2(String value) {
		this.telefono2 = value;
	}

	public void setPais(String value) {
		this.pais = value;
	}

	public void setCiudad(String value) {
		this.ciudad = value;
	}

	public void setContacto(String value) {
		this.contacto = value;
	}

	public void setRuc(String value) {
		this.ruc = value;
	}

	// métodos get
	public int getIdProveedor() {
		return this.idProveedor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getTelefono() {
		return this.telefono1;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getContacto() {
		return this.contacto;
	}

	public String getRuc() {
		return this.ruc;
	}

}
