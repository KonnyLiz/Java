package clases;

/**
 * Write a description of class tipoTrabajo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoTrabajo {

	// instance variables - replace the example below with your own
	public int idTp;
	public String descripcion;
	public float precio;
	public float precioM;

	/**
	 * Constructor for objects of class rol
	 */
	public tipoTrabajo(int idTp, String desc, float precio1, float precio2) {
		this.idTp = idTp;
		this.descripcion = desc;
		this.precio = precio1;
		this.precioM = precio2;
		// initialise instance variables
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */

	public void setIdTp(int value) {
		this.idTp = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setPrecio1(float value) {
		this.precio = value;
	}

	public void setPrecio2(float value) {
		this.precioM = value;
	}

	// metodos Get

	public int getIdTp() {
		return this.idTp;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public float getPrecio1() {
		return this.precio;
	}

	public float getPrecio2() {
		return this.precioM;
	}

}
