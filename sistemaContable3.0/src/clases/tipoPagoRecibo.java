package clases;

public class tipoPagoRecibo {
	// instance variables - replace the example below with your own
	private int idTipoPagoReciboPK;
	private int idRecibo;
	private int idTipoPago;
	private String cantidad;
	private String fecha;
	private String detalle;
	private String plazo;
	private String estado;
	private String tipoPagoString;
	private Boolean eliminar;
	private int tipoRecibo;

	// ID_TP_RE, ID_RECIBO, ID_TP, CANTIDAD, FECHA, DETALLE, PLAZO, ESTADO
	/**
	 * Constructor for objects of class tipoPagoRecibo
	 */
	public tipoPagoRecibo(int idTipoPagoReciboPK, int idRecibo, int idTipoPago,
			String cantidad, String fecha, String detalle, String plazo,
			String estado, int tipoRecibo2) {
		this.idTipoPagoReciboPK = idTipoPagoReciboPK;
		this.idRecibo = idRecibo;
		this.idTipoPago = idTipoPago;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.detalle = detalle;
		this.plazo = plazo;
		this.estado = estado;
		this.tipoRecibo = tipoRecibo2;
	}

	public tipoPagoRecibo() {
		// TODO Auto-generated constructor stub
	}

	public void setCantidad(String string) {
		this.cantidad = string;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}

	public void setIdTipoPago(int idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public void setIdTipoPagoReciboPK(int idTipoPagoReciboPK) {
		this.idTipoPagoReciboPK = idTipoPagoReciboPK;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public String getDetalle() {
		return detalle;
	}

	public String getFecha() {
		return fecha;
	}

	public int getIdRecibo() {
		return idRecibo;
	}

	public int getIdTipoPago() {
		return idTipoPago;
	}

	public int getIdTipoPagoReciboPK() {
		return idTipoPagoReciboPK;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setTipoPagoString(String tipoPagoString) {
		this.tipoPagoString = tipoPagoString;
	}

	public String getTipoPagoString() {
		return tipoPagoString;
	}

	public void setEliminar(Boolean eliminar) {
		this.eliminar = eliminar;
	}

	public Boolean getEliminar() {
		return eliminar;
	}

	public int getTipoRecibo() {
		return tipoRecibo;
	}

	public void setTipoRecibo(int tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}

}
