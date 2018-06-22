package clases;

public class alertaTablaObj {

	// ID ALERTA", "DESCRIPCION", "FECHA INICIO",
	// "FECHA FINAL", "ESTADO", "DETALLE
	String alerta;
	String descripcion;
	String fechaInicio;
	String fechaFinalizacionAlerta;
	String estado;
	String descripcion2;
	Boolean modificar;
	Boolean eliminar;

	public alertaTablaObj() {
		// TODO Auto-generated constructor stub
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFechaFinalizacionAlerta(String fechaFinalizacionAlerta) {
		this.fechaFinalizacionAlerta = fechaFinalizacionAlerta;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setEliminar(Boolean eliminar) {
		this.eliminar = eliminar;
	}

	public void setModificar(Boolean modificar) {
		this.modificar = modificar;
	}

	public String getAlerta() {
		return alerta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaFinalizacionAlerta() {
		return fechaFinalizacionAlerta;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public Boolean getEliminar() {
		return eliminar;
	}

	public Boolean getModificar() {
		return modificar;
	}

}
