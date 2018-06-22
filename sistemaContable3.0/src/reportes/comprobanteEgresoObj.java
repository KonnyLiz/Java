package reportes;

public class comprobanteEgresoObj {
	int idComprobante;
	String tipoComprobante;
	float total;
	String descripcion;
	String fecha;
	int numeroComprobante;

	public comprobanteEgresoObj(int idComprobante, String tipoComprobante,
			float total, String descripcion, String fecha, int numeroComprobante) {
		this.idComprobante = idComprobante;
		this.tipoComprobante = tipoComprobante;
		this.total = total;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.numeroComprobante = numeroComprobante;
	}

	public comprobanteEgresoObj() {
		// TODO Auto-generated constructor stub
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}

	public void setNumeroComprobante(int numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public int getIdComprobante() {
		return idComprobante;
	}

	public int getNumeroComprobante() {
		return numeroComprobante;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public float getTotal() {
		return total;
	}

}
