package tableUtil;

/**
 * Write a description of class ordenTrabajoDetalle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class detalleOdtLista {
	// instance variables - replace the example below with your own

	private String cliente;
	private String descripcion;
	private String numero;
	private float total;
	private float abono;
	private float saldo;
	private boolean facturar;
	private boolean entregar;
	private boolean eliminar;
	private String id_ot;

	/**
	 * Constructor for objects of class ordenTrabajoDetalle
	 */
	public detalleOdtLista(String cliente, String descripcion, String numero,
			float total, float abono, float saldo, boolean facturar,
			boolean entregar, boolean eliminar, String id_ot) {
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.numero = numero;
		this.total = total;
		this.abono = abono;
		this.saldo = saldo;
		this.facturar = facturar;
		this.entregar = entregar;
		this.eliminar = eliminar;
		this.id_ot = id_ot;
	}

	public void setId_ot(String id_ot) {
		this.id_ot = id_ot;
	}

	public void setAbono(float abono) {
		this.abono = abono;
	}

	public void setCliente(String cantidad) {
		this.cliente = cantidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public void setEntregar(boolean entregar) {
		this.entregar = entregar;
	}

	public void setFacturar(boolean facturar) {
		this.facturar = facturar;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	// get metodos
	public float getAbono() {
		return abono;
	}

	public String getCliente() {
		return cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getSaldo() {
		return saldo;
	}

	public float getTotal() {
		return total;
	}

	public boolean getEliminar() {
		return this.eliminar;
	}

	public boolean getEntregar() {
		return this.entregar;
	}

	public boolean getFacturar() {
		return this.facturar;
	}

	public String getId_ot() {
		return id_ot;
	}

	public String getNumero() {
		return numero;
	}

}
