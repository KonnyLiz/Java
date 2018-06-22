package clases;

/**
 * Write a description of class tipoRecibo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoRecibo {
	// instance variables - replace the example below with your own
	private int idTipoRecibo;
	private String descripcionTipoRecibo;

	/**
	 * Constructor for objects of class tipoRecibo
	 */
	public tipoRecibo(int idTipoRecibo, String DescripcionTipoRecibo) {
		this.idTipoRecibo = idTipoRecibo;
		this.descripcionTipoRecibo = DescripcionTipoRecibo;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTipoDeRecibo(int value) {
		this.idTipoRecibo = value;
	}

	public void setDesTipoDeRecibo(String value) {
		this.descripcionTipoRecibo = value;
	}

	// metodos get

	public int getIdTipoDeRecibo() {
		return this.idTipoRecibo;
	}

	public String getDescripcion() {
		return this.descripcionTipoRecibo;
	}

}
