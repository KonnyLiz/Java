package clases;

/**
 * Write a description of class inventario here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class inventario {
	// instance variables - replace the example below with your own
	private int idProducto;
	private int idProveedor;
	private int unidadDeMedida;
	private int IdTipoProducto;
	private int idPagoRealizado;
	private String descripcion;
	private float equivalente;
	private int cantidad;
	private int idBodega;
	private float pvp;
	private float pvpSocio;

	/**
	 * Constructor for objects of class inventario
	 */
	public inventario(int idProducto, int idProveedor, int unidadDeMedida,
			int IdTipoProducto, int idPagoRealizado, String descripcion,
			float pvp, float pvpSocio, float equivalente, int cantidad,
			int idBodega) {
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
		this.unidadDeMedida = unidadDeMedida;
		this.IdTipoProducto = IdTipoProducto;
		this.idPagoRealizado = idPagoRealizado;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.pvpSocio = pvpSocio;
		this.equivalente = equivalente;
		this.cantidad = cantidad;
		this.idBodega = idBodega;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdProducto(int value) {
		this.idProducto = value;
	}

	public void setIdProveedor(int value) {
		this.idProveedor = value;
	}

	public void setUnidadDeMedida(int value) {
		this.unidadDeMedida = value;
	}

	public void setIdTipoProducto(int value) {
		this.IdTipoProducto = value;
	}

	public void setIdPagoRealizado(int value) {
		this.idPagoRealizado = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value.toUpperCase();
	}

	public void setPvp(float value) {
		this.pvp = value;
	}

	public void setEquivalente(float value) {
		this.equivalente = value;
	}

	public void setCantidad(int value) {
		this.cantidad = value;
	}

	public void setIdBodega(int value) {
		this.idBodega = value;
	}

	// métodos Get

	public int getIdProducto() {
		return this.idProducto;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public int getUnidadDeMedida() {
		return this.unidadDeMedida;
	}

	public int getIdTipoProducto() {
		return this.IdTipoProducto;
	}

	public int getIdPagoRealizado() {
		return this.idPagoRealizado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public float getPvp() {
		return this.pvp;
	}

	public float getEquivalente() {
		return this.equivalente;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public int getIdBodega() {
		return this.idBodega;
	}

	public void setPvpSocio(float pvpSocio) {
		this.pvpSocio = pvpSocio;
	}

	public float getPvpSocio() {
		return pvpSocio;
	}

}
