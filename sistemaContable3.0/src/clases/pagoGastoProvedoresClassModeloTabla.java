package clases;

public class pagoGastoProvedoresClassModeloTabla {

	public String idTabla;
	public String numeroComprobante;
	public String tipo;
	public String Detalle;
	public String fecha;
	public String proveedor;
	public boolean editarPago;
	public String totalFacturado;

	public pagoGastoProvedoresClassModeloTabla() {
		// TODO Auto-generated constructor stub
	}

	public pagoGastoProvedoresClassModeloTabla(String idTabla,
			String numeroComprobante, String tipo, String detalle,
			String fecha, String proveedor, boolean editarPago,
			String totalFacturado) {
		super();
		this.idTabla = idTabla;
		this.numeroComprobante = numeroComprobante;
		this.tipo = tipo;
		Detalle = detalle;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.editarPago = editarPago;
		this.totalFacturado = totalFacturado;

	}

	public boolean isEditarPago() {
		return editarPago;
	}

	public void setEditarPago(boolean editarPago) {
		this.editarPago = editarPago;
	}

	public String getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(String idTabla) {
		this.idTabla = idTabla;
	}

	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getTotalFacturado() {
		return totalFacturado;
	}

	public void setTotalFacturado(String totalFacturado) {
		this.totalFacturado = totalFacturado;
	}

}
