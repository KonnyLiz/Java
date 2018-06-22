package clases;

/**
 * Write a description of class cliente here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class cliente {
	// instance variables - replace the example below with your own
	private int idTc;
	private String ciRuc;
	private String nombre;
	private String telefono;
	private String clienteDesde;
	private String direccion;
	private String sexo;
	private String email;

	/**
	 * Constructor for objects of class cliente
	 */
	public cliente(int idTc, String ciRuc, String nombre, String telefono,
			String clienteDesde, String direccion, String sexo, String email) {
		this.idTc = idTc;
		this.ciRuc = ciRuc;
		this.nombre = nombre;
		this.telefono = telefono;
		this.clienteDesde = clienteDesde;
		this.direccion = direccion;
		this.sexo = sexo;
		this.email = email;
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

	public void setCiRuc(String value) {
		this.ciRuc = value;
	}

	public void setNombre(String value) {
		this.nombre = value.toUpperCase();
	}

	public void setTelefono(String value) {
		telefono = value;
	}

	public void setClienteDesde(String value) {
		this.clienteDesde = value.toUpperCase();
	}

	public void setDireccion(String value) {
		direccion = value.toUpperCase();
	}

	public void setSexo(String value) {
		this.sexo = value;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	// métodos get

	public int getIdTc() {
		return this.idTc;
	}

	public String getCiRuc() {
		return this.ciRuc;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getClienteDesde() {
		return this.clienteDesde;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getEmail() {
		return this.email;
	}

}
