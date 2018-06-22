package clases;

public class pagosPorGastos {
	// instance variables - replace the example below with your own

	private int idPagoPorGasto;// pk
	private int idCompraGasto;
	private int idTipoDePago;
	private int idCuentaTablaBanco;
	private int idNumeroComprobante;
	private float total;
	private String fechaGeneracion;
	private String plazoPago;
	private String beneficiario;

	/**
	 * Constructor for objects of class pago por gasto
	 */
	public pagosPorGastos(int idPagoPorGasto, int idCompraPorGasto,
			int idComprobante, int idTipoDePago, int idCuentaTablaBanco,
			int idNumeroComprobante, float total, String fechaGeneracion,
			String plazoPago, String beneficiario) {
		this.idPagoPorGasto = idPagoPorGasto;//
		this.idCompraGasto = idCompraPorGasto;//
		this.idTipoDePago = idTipoDePago;
		this.idCuentaTablaBanco = idCuentaTablaBanco;
		this.idNumeroComprobante = idNumeroComprobante;
		this.total = total;
		this.fechaGeneracion = fechaGeneracion;
		this.plazoPago = plazoPago;
		this.beneficiario = beneficiario;
		// initialise instance variables
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdPagoPorGasto(int value) {
		this.idPagoPorGasto = value;
	}

	public void setIdCompraPago(int value) {
		this.idCompraGasto = value;
	}

	public void setIdTipoDePago(int value) {
		this.idTipoDePago = value;
	}

	public void setIdCuentaTablaBanco(int value) {
		this.idCuentaTablaBanco = value;
	}

	public void setNumeroComprobante(int value) {
		this.idNumeroComprobante = value;
	}

	public void setTotal(float value) {
		this.total = value;
	}

	public void setFechaGeneracionDeuda(String value) {
		this.fechaGeneracion = value;
	}

	public void setPlazoDePago(String value) {
		this.plazoPago = value;
	}

	public void setBeneficiario(String value) {
		this.beneficiario = value;
	}

	// metodos Get

	public int getIdPagoPorGasto() {
		return this.idPagoPorGasto;
	}

	public int getIdCompraGasto() {
		return this.idCompraGasto;
	}

	public int getIdTipoDePago() {
		return this.idTipoDePago;
	}

	public int getIdCuentaTablaBanco() {
		return this.idCuentaTablaBanco;
	}

	public int getNumeroComprobante() {
		return this.idNumeroComprobante;
	}

	public float getTotal() {
		return this.total;
	}

	public String getFechaGeneracionDeuda() {
		return this.fechaGeneracion;
	}

	public String getPlazoDePago() {
		return this.plazoPago;
	}

	public String getBeneficiario() {
		return this.beneficiario;
	}

}
