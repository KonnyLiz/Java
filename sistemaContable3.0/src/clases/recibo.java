package clases;

public class recibo {

	private int idRecibo;// ID_RECIBO
	private int numeroRecibo;// NUMERO_RECIBO
	private int idUser;// ID_USER
	private int idOrdenTrabajo;// ID_OT
	private int idTipoRecibo;// ID_TR
	private String CiRuc;// CI_RUC
	private String fecha;// FECHA
	private String ciudad;// CIUDAD;
	private float subtotal;// SUBTOTAL
	private float total;// total
	private float iva;// iva

	public recibo(int idRecibo, int numeroRecibo, int idUser,
			int idOrdenTrabajo, int idTipoRecibo, String CiRuc, String fecha,
			String ciudad, float subtotal, float total, float iva) {
		this.idRecibo = idRecibo;// ID_RECIBO
		this.numeroRecibo = numeroRecibo;// NUMERO_RECIBO
		this.idUser = idUser;// ID_USER
		this.idOrdenTrabajo = idOrdenTrabajo;// ID_OT
		this.idTipoRecibo = idTipoRecibo;// ID_TR
		this.CiRuc = CiRuc;// CI_RUC
		this.fecha = fecha;// FECHA
		this.ciudad = ciudad;// CIUDAD;
		this.subtotal = subtotal;// SUBTOTAL
		this.total = total;// total
		this.iva = iva;

	}

	public void setCiRuc(String ciRuc) {
		CiRuc = ciRuc;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdOrdenTrabajo(int idOrdenTrabajo) {
		this.idOrdenTrabajo = idOrdenTrabajo;
	}

	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}

	public void setIdTipoRecibo(int idTipoRecibo) {
		this.idTipoRecibo = idTipoRecibo;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public void setNumeroRecibo(int numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	// get
	public String getCiRuc() {
		return CiRuc;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getFecha() {
		return fecha;
	}

	public int getIdOrdenTrabajo() {
		return idOrdenTrabajo;
	}

	public int getIdRecibo() {
		return idRecibo;
	}

	public int getIdTipoRecibo() {
		return idTipoRecibo;
	}

	public int getIdUser() {
		return idUser;
	}

	public float getIva() {
		return iva;
	}

	public int getNumeroRecibo() {
		return numeroRecibo;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public float getTotal() {
		return total;
	}

}
