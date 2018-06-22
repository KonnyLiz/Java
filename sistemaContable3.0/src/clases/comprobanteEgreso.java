package clases;

public class comprobanteEgreso {
	// instance variables - replace the example below with your own
	private int idComprobante;
	private int numeroRecibo;
	private String tipoComprobante;
	private float total;
	private String Descripcion;
	private String fecha;

	public comprobanteEgreso() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for objects of class rol
	 */
	public comprobanteEgreso(int idComprobante, int numeroRecibo,
			String tipoComprobante, float total, String Descripcion,
			String fecha) {
		this.idComprobante = idComprobante;
		this.numeroRecibo = numeroRecibo;
		this.tipoComprobante = tipoComprobante;
		this.total = total;
		this.Descripcion = Descripcion;
		this.fecha = fecha;
		// initialise instance variables
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdComprobante(int value) {
		this.idComprobante = value;
	}

	public void setTipoComprobante(String value) {
		this.tipoComprobante = value;
	}

	public void setTotal(float value) {
		this.total = value;
	}

	public void setDescripcion(String value) {
		this.Descripcion = value;
	}

	public void setFecha(String value) {
		this.fecha = value;
	}

	public void setNumeroRecibo(int numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	// metodos Get
	public int getIdComprobante() {
		return this.idComprobante;
	}

	public String getTipoComprobante() {
		return this.tipoComprobante;
	}

	public float getTotal() {
		return this.total;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public int getNumeroRecibo() {
		return numeroRecibo;
	}
}
