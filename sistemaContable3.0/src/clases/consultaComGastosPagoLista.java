package clases;

public class consultaComGastosPagoLista {
	//ID_COM_GAS, COMPROBANTE, DESCRIPCION, TIPO_COMPROBANTE,
	//, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL, NUMERO_RETENCION,
	//TOTAL_RETENCION, FECHA_COMPRA, ESTADO
	//
	String idComGasto;
	String numComprobante;
	String descripcion;
	String tipoComprobante;
	String total;
	String descripcionAdicional;
	String fecha;
	String estado;
	boolean ver;


	public consultaComGastosPagoLista(String idComGasto, String numComprobante,
			String descripcion, String tipoComprobante, String total,
			String descripcionAdicional, String fecha, String estado,
			boolean ver) {
		super();
		this.idComGasto = idComGasto;
		this.numComprobante = numComprobante;
		this.descripcion = descripcion;
		this.tipoComprobante = tipoComprobante;
		this.total = total;
		this.descripcionAdicional = descripcionAdicional;
		this.fecha = fecha;
		this.estado = estado;
		this.ver = ver;
	}




	public String getIdComGasto() {
		return idComGasto;
	}
	public void setIdComGasto(String idComGasto) {
		this.idComGasto = idComGasto;
	}
	public String getNumComprobante() {
		return numComprobante;
	}
	public void setNumComprobante(String numComprobante) {
		this.numComprobante = numComprobante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDescripcionAdicional() {
		return descripcionAdicional;
	}
	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean getVer() {
		return ver;
	}
	public void setVer(boolean ver) {
		this.ver = ver;
	}




}