package clases;

public class bancos {
	// instance variables - replace the example below with your own
	private int idBanco;
	private String descripcionBanco;
	private String telefonoBanco;
	private String ciudadBanco;

	/**
	 * Constructor for objects of class bancos
	 */
	public bancos(int idBanco, String descripcionBanco, String telefonoBanco,
			String ciudadBanco) {
		this.idBanco = idBanco;
		this.descripcionBanco = descripcionBanco;
		this.telefonoBanco = telefonoBanco;
		this.ciudadBanco = ciudadBanco;
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdBanco(int value) {
		this.idBanco = value;
	}

	public void setDescripcionBanco(String value) {
		this.descripcionBanco = value;
	}

	public void setTelefonoBanco(String value) {
		this.telefonoBanco = value;
	}

	public void setCiudadBanco(String value) {
		this.ciudadBanco = value;
	}

	// metodos Get
	public int getIdBanco() {
		return this.idBanco;
	}

	public String getDescripcionBanco() {
		return this.descripcionBanco;
	}

	public String getTelefonoBanco() {
		return this.telefonoBanco;
	}

	public String getCiudadBanco() {
		return this.ciudadBanco;
	}

}
