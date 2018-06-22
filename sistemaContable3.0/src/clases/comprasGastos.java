package clases;

/**
 * Write a description of class tipoPago here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class comprasGastos {
	// instance variables - replace the example below with your own
	private int idCompraGasto;
	private int numeroComprobante;
	private String descripcion;
	private String tipoComprobante;
	private float iva;
	private float subtotal;
	private float totalPagado;
	private String descripcionAdicional;
	private int numeroRetencion;
	private float totalRetencion;
	private String fechaCompra;// getFechaCompra

	/**
	 * Constructor for objects of class tipoPago
	 */
	public comprasGastos(int idCompraGasto, int numeroComprobante,
			String descripcion, String tipoComprobante, float iva,
			float subtotal, float totalPagado, String descripcionAdicional,
			int numeroRetencion, float totalRetencion, String fechaCompra) {
		this.idCompraGasto = idCompraGasto;
		this.numeroComprobante = numeroComprobante;
		this.descripcion = descripcion;
		this.tipoComprobante = tipoComprobante;
		this.iva = iva;
		this.subtotal = subtotal;
		this.totalPagado = totalPagado;
		this.descripcionAdicional = descripcionAdicional;
		this.numeroRetencion = numeroRetencion;
		this.totalRetencion = totalRetencion;
		this.fechaCompra = fechaCompra;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdCompraGasto(int value) {
		this.idCompraGasto = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setNumeroComprobante(int value) {
		this.numeroComprobante = value;
	}

	public void setIva(float value) {
		this.iva = value;
	}

	public void setSubtotal(float value) {
		this.subtotal = value;
	}

	public void setTotalPagado(float value) {
		this.totalPagado = value;
	}

	public void setDescripcionAdicional(String value) {
		this.descripcionAdicional = value;
	}

	public void setNumeroRetencion(int value) {
		this.numeroRetencion = value;
	}

	public void setTotalRetencion(float value) {
		this.totalRetencion = value;
	}

	public void setTipoComprobante(String value) {
		this.tipoComprobante = value;
	}

	public void setFechaCompra(String value) {
		this.fechaCompra = value;
	}

	// métodos get
	public int getIdCompraGasto() {
		return this.idCompraGasto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public int getNumeroComprobante() {
		return this.numeroComprobante;
	}

	public float getIva() {
		return this.iva;
	}

	public float getSubtotal() {
		return this.subtotal;
	}

	public float getTotalPagado() {
		return this.totalPagado;
	}

	public String getDescripcionAdicional() {
		return this.descripcionAdicional;
	}

	public int getNumeroRetencion() {
		return this.numeroRetencion;
	}

	public float getTotalRetencion() {
		return this.totalRetencion;
	}

	public String getTipoComprobante() {
		return this.tipoComprobante;
	}

	public String getFechaCompra() {
		return this.fechaCompra;
	}

}
