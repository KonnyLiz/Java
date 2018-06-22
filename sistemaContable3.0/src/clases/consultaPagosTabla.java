package clases;

public class consultaPagosTabla {
	String idComGasto;
	String idTipoPago;
	String idCuentaTabla;
	String numeroComprobante;
	String total;
	String fechaGeneracion;
	String fechaPlazoPago;
	String Beneficiario;
	boolean ver;

	public consultaPagosTabla(String idComGasto, String idTipoPago,
			String idCuentaTabla, String numeroComprobante, String total,
			String fechaGeneracion, String fechaPlazoPago, String beneficiario) {
		super();
		this.idComGasto = idComGasto;
		this.idTipoPago = idTipoPago;
		this.idCuentaTabla = idCuentaTabla;
		this.numeroComprobante = numeroComprobante;
		this.total = total;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaPlazoPago = fechaPlazoPago;
		Beneficiario = beneficiario;
	}

	public consultaPagosTabla() {

	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

	public boolean getVer() {
		return this.ver;
	}

	public String getIdComGasto() {
		return idComGasto;
	}

	public void setIdComGasto(String idComGasto) {
		this.idComGasto = idComGasto;
	}

	public String getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getIdCuentaTabla() {
		return idCuentaTabla;
	}

	public void setIdCuentaTabla(String idCuentaTabla) {
		this.idCuentaTabla = idCuentaTabla;
	}

	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public String getFechaPlazoPago() {
		return fechaPlazoPago;
	}

	public void setFechaPlazoPago(String fechaPlazoPago) {
		this.fechaPlazoPago = fechaPlazoPago;
	}

	public String getBeneficiario() {
		return Beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		Beneficiario = beneficiario;
	}

}
