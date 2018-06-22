package clases;

/**
 * Write a description of class rol here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class rol {
	// instance variables - replace the example below with your own
	public int idRol;
	public String descripcion;

	/**
	 * Constructor for objects of class rol
	 */
	public rol(int idRol, String desc) {
		this.idRol = idRol;
		this.descripcion = desc;
		// initialise instance variables
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setId(int rol) {
		this.idRol = rol;
	}

	public void setDescripcion(String texto) {
		this.descripcion = texto;
	}

	// metodos Get
	public int getId() {
		return this.idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
