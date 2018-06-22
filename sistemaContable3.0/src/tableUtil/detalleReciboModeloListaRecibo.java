package tableUtil;

public class detalleReciboModeloListaRecibo {
	String idRecibo;
	String numeroRecibo;
	String id_odt;
	String cliente;
	String Total;
	String Fecha;
	boolean cobro;
	boolean ver;

	public detalleReciboModeloListaRecibo() {
		// TODO Auto-generated constructor stub
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setCobro(boolean cobro) {
		this.cobro = cobro;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public void setId_odt(String id_odt) {
		this.id_odt = id_odt;
	}

	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public void setTotal(String total) {
		Total = total;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

	public void setIdRecibo(String idRecibo) {
		this.idRecibo = idRecibo;
	}

	// get
	public String getCliente() {
		return cliente;
	}

	public String getFecha() {
		return Fecha;
	}

	public String getId_odt() {
		return id_odt;
	}

	public String getIdRecibo() {
		return idRecibo;
	}

	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	public String getTotal() {
		return Total;
	}

	public Boolean getCobro() {
		return this.cobro;
	}

	public Boolean getVer() {
		return this.ver;
	}

	/**
	 * SELECt ID_RECIBO, NUMERO_RECIBO, ID_OT, c.NOMBRE,TOTAL,FECHA FROM
	 * recibo_venta r,cliente c where r.CI_RUC=c.CI_RUC order by FECHA
	 */
}
