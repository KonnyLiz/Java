package reportes;

public class ordenDeTrabajoObj {

	public Object numeroOrdenTrabajo;
	public Object numeroOrdenTrabajoSistema;
	public Object fecha;
	public Object nombreCliente;
	public Object nombreDelArchivo;
	public Object tipoDeTrabajo;
	public Object precio;
	public Object abono;
	public Object saldo;
	public Object observacion;
	public Object estado;
	public Object responsable;

	/**
	 * constructores
	 */

	public ordenDeTrabajoObj(Object numeroOrdenTrabajo,
			Object numeroOrdenTrabajoSistema, Object fecha,
			Object nombreCliente, Object nombreDelArchivo,
			Object tipoDeTrabajo, Object precio, Object abono, Object saldo,
			Object observacion, Object estado, Object responsable) {
		// TODO Auto-generated constructor stub
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
		this.numeroOrdenTrabajoSistema = numeroOrdenTrabajoSistema;
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
		this.nombreDelArchivo = nombreDelArchivo;
		this.tipoDeTrabajo = tipoDeTrabajo;
		this.precio = precio;
		this.abono = abono;
		this.saldo = saldo;
		this.observacion = observacion;
		this.estado = estado;
		this.responsable = responsable;
	}

	public ordenDeTrabajoObj() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param nombreCliente
	 */

	public void setNombreCliente(Object nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void setNumeroOrdenTrabajoSistema(Object numeroOrdenTrabajoSistema) {
		this.numeroOrdenTrabajoSistema = numeroOrdenTrabajoSistema;
	}

	public void setNumeroOrdenTrabajo(Object numeroOrdenTrabajo) {
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
	}

	public void setFecha(Object fecha) {
		this.fecha = fecha;
	}

	public void setNombreDelArchivo(Object nombreDelArchivo) {
		this.nombreDelArchivo = nombreDelArchivo;
	}

	public void setTipoDeTrabajo(Object tipoDeTrabajo) {
		this.tipoDeTrabajo = tipoDeTrabajo;
	}

	public void setPrecio(Object precio) {
		this.precio = precio;
	}

	public void setAbono(Object abono) {
		this.abono = abono;
	}

	public void setSaldo(Object saldo) {
		this.saldo = saldo;
	}

	public void setObservacion(Object observacion) {
		this.observacion = observacion;
	}

	public void setEstado(Object estado) {
		this.estado = estado;
	}

	public void setResponsable(Object responsable) {
		this.responsable = responsable;
	}

	// getter
	public Object getNumeroOrdenTrabajoSistema() {
		return numeroOrdenTrabajoSistema;
	}

	public Object getAbono() {
		return abono;
	}

	public Object getEstado() {
		return estado;
	}

	public Object getFecha() {
		return fecha;
	}

	public Object getNombreDelArchivo() {
		return nombreDelArchivo;
	}

	public Object getPrecio() {
		return precio;
	}

	public Object getResponsable() {
		return responsable;
	}

	public Object getSaldo() {
		return saldo;
	}

	public Object getTipoDeTrabajo() {
		return tipoDeTrabajo;
	}

	public Object getObservacion() {
		return observacion;
	}

	public Object getNumeroOrdenTrabajo() {
		return numeroOrdenTrabajo;
	}

	public Object getNombreCliente() {
		return nombreCliente;
	}
}
