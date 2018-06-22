package clases;

/**
 * Write a description of class alertas here.
 * 
 * @author (carlos)
 * @version (2)
 */
public class alertas {
	// instance variables - replace the example below with your own
	private int alerta;
	private String descripcion;
	private String fechaInicio;
	private String fechaFinalizacionAlerta;
	private String estado;
	private String descripcion2;

	/**
	 * Constructor for objects of class alertas
	 */
	public alertas(int alerta, String descripcion, String fechaInicio,
			String fechaFinalizacionAlerta, String estado, String descripcion2) {
		this.alerta = alerta;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacionAlerta = fechaFinalizacionAlerta;
		this.estado = estado;
		this.descripcion2 = descripcion2;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setAlerta(int value) {
		this.alerta = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setFechaInicio(String value) {
		this.fechaInicio = value;
	}

	public void setFechaDinalizacion(String value) {
		this.fechaFinalizacionAlerta = value;
	}

	public void setEstado(String value) {
		this.estado = value;
	}

	public void setDescripcion2(String value) {
		this.descripcion2 = value;
	}

	// métodos Get

	public int getAlerta() {
		return this.alerta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public String getFechaDinalizacion() {
		return this.fechaFinalizacionAlerta;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

}
