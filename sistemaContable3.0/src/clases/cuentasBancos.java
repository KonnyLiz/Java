package clases;

public class cuentasBancos {
	// instance variables - replace the example below with your own
	private int idCuentaTabla;
	private int idBanco;
	private String numeroCuenta;
	private String tipoCuenta;
	private String propietarioCuenta;

	/**
	 * Constructor for objects of class cuentas bancos
	 */
	public cuentasBancos(int idBanco, int idCuentaTabla, String numeroCuenta,
			String tipoCuenta, String propietarioCuenta) {
		this.idCuentaTabla = idCuentaTabla;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.propietarioCuenta = propietarioCuenta;
		this.idBanco = idBanco;
		// initialise instance variables
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdCuentaTabla(int value) {
		this.idCuentaTabla = value;
	}

	public void setIdBanco(int value) {
		this.idBanco = value;
	}

	public void setNumeroCuenta(String value) {
		this.numeroCuenta = value;
	}

	public void setTipoCuenta(String value) {
		this.tipoCuenta = value;
	}

	public void setPropietarioCuenta(String value) {
		this.propietarioCuenta = value;
	}

	// metodos get
	public int getIdCuentaTabla() {
		return this.idCuentaTabla;
	}

	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public String getTipoCuenta() {
		return this.tipoCuenta;
	}

	public String getPropietarioCuenta() {
		return this.propietarioCuenta;
	}

	public int getIdBanco() {
		return this.idBanco;
	}

}
