package clases;

/**
 * Write a description of class unidadMedida here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class unidadMedida {
	// instance variables - replace the example below with your own
	private int idUnidadMedida;
	private String descripcion;
	private String nomenclatura;

	/**
	 * Constructor for objects of class unidadMedida
	 */
	public unidadMedida(int idUnidadMedida, String descripcion,
			String nomenclatura) {
		this.idUnidadMedida = idUnidadMedida;
		this.descripcion = descripcion;
		this.nomenclatura = nomenclatura;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdUnidadMedida(int value) {
		this.idUnidadMedida = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setNomenclatura(String value) {
		this.nomenclatura = value;
	}

	// métodos get
	public int getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getNomenclatura() {
		return this.nomenclatura;
	}

}
