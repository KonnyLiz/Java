package tableUtil;

public class detalleProformaLista {
	// ID_PROFORMA, NOMBRE, FECHA, SUBTOTAL, TOTAL, IVA, ESTADO
	String idProforma;
	String nombre;
	String fecha;
	String subtotal;
	String total;
	String iva;
	String estado;
	Boolean ver;
	Boolean recibo;
	Boolean eliminar;

	public detalleProformaLista(String idProforma, String nombre, String fecha,
			String subtotal, String total, String iva, String estado,
			Boolean ver, Boolean recibo, Boolean eliminar) {

		this.idProforma = idProforma;
		this.nombre = nombre;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.total = total;
		this.iva = iva;
		this.estado = estado;
		this.ver = ver;
		this.recibo = recibo;
		this.eliminar = eliminar;

	}

	public void setEliminar(Boolean eliminar) {
		this.eliminar = eliminar;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdProforma(String idProforma) {
		this.idProforma = idProforma;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRecibo(Boolean recibo) {
		this.recibo = recibo;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setVer(Boolean ver) {
		this.ver = ver;
	}

	public Boolean getEliminar() {
		return eliminar;
	}

	public String getEstado() {
		return estado;
	}

	public String getFecha() {
		return fecha;
	}

	public String getIdProforma() {
		return idProforma;
	}

	public String getIva() {
		return iva;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean getRecibo() {
		return recibo;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public String getTotal() {
		return total;
	}

	public Boolean getVer() {
		return ver;
	}

}
