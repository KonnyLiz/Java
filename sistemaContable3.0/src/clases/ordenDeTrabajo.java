package clases;

/**
 * Write a description of class ordenDeTrabajo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ordenDeTrabajo {
	// instance variables - replace the example below with your own
	private int idOrdendeTrabajo;
	private int idUsuario;
	private int idEmpleadoDiseñador;
	private String ciRuc;
	private String Observacion;
	private int numeroOrdenTrabajo;
	private String fecha;
	private String NombredelArchivo;
	private String Impresion;
	private float precio;
	private float abono;
	private float saldo;
	private String estado;

	/**
	 * Constructor for objects of class ordenDeTrabajo
	 */
	public ordenDeTrabajo(int idOrdendeTrabajo, int idUsuario,
			int idEmpleadoDiseñador, String ciRuc, String Observacion,
			int numeroOrdenTrabajo, String fecha, String NombredelArchivo,
			String Impresion, float precio, float abono, float saldo,
			String estado) {
		this.idOrdendeTrabajo = idOrdendeTrabajo;
		this.idUsuario = idUsuario;
		this.idEmpleadoDiseñador = idEmpleadoDiseñador;
		this.ciRuc = ciRuc;
		this.Observacion = Observacion;
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
		this.fecha = fecha;
		this.NombredelArchivo = NombredelArchivo;
		this.Impresion = Impresion;
		this.precio = precio;
		this.abono = abono;
		this.saldo = saldo;
		this.estado = estado;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdOrdenDeTrabajo(int value) {
		this.idOrdendeTrabajo = value;
	}

	public void setIdUsuario(int value) {
		this.idUsuario = value;
	}

	public void setIdEmpleadoDiseñador(int value) {
		this.idEmpleadoDiseñador = value;
	}

	public void setObservacion(String value) {
		this.Observacion = value;
	}

	public void setCiRuc(String Value) {
		this.ciRuc = Value;
	}

	public void setNumeroOrdenTrabajo(int value) {
		this.numeroOrdenTrabajo = value;
	}

	public void setFecha(String value) {
		this.fecha = value;
	}

	public void setNombredelArchivo(String value) {
		this.NombredelArchivo = value;
	}

	public void setImpresion(String value) {
		this.Impresion = value;
	}

	public void setPrecio(float value) {
		this.precio = value;
	}

	public void setAbono(float value) {
		this.abono = value;
	}

	public void setSaldo(float value) {
		this.saldo = value;
	}

	public void setEstado(String value) {
		this.estado = value;
	}

	// Métodos Get

	public int getIdOrdenDeTrabajo() {
		return this.idOrdendeTrabajo;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public int getIdEmpleadoDiseñador() {
		return this.idEmpleadoDiseñador;

	}

	public String getObservacion() {
		return this.Observacion;
	}

	public String getCiRuc() {
		return this.ciRuc;
	}

	public int getNumeroOrdenTrabajo() {
		return this.numeroOrdenTrabajo;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getNombredelArchivo() {
		return this.NombredelArchivo;
	}

	public String getImpresion() {
		return this.Impresion;
	}

	public float getPrecio() {
		return this.precio;
	}

	public float getAbono() {
		return this.abono;
	}

	public float getSaldo() {
		return this.saldo;
	}

	public String getEstado() {
		return this.estado;
	}
}
