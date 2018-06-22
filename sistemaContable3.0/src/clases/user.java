package clases;

/**
 * Write a description of class user here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class user {
	// instance variables - replace the example below with your own
	private int idUser;
	private int idRol;
	private String nombreCompleto;
	private String userName;
	private String contrasena;

	public user(int idUser, int idRol, String nombreCompleto, String userName,
			String contrasena) {
		this.idUser = idUser;
		this.idRol = idRol;
		this.nombreCompleto = nombreCompleto;
		this.userName = userName;
		this.contrasena = contrasena;

	}

	/**
	 * Constructor for objects of class user
	 */
	public void setIdUser(int value) {
		this.idUser = value;
		// this.idRol=value;
	}

	public void setIdRol(int value) {
		this.idRol = value;
		// this.idRol=value;
	}

	public void setNombreCompleto(String value) {
		this.nombreCompleto = value;
		// this.idRol=value;
	}

	public void setUserName(String value) {
		this.userName = value;
		// this.idRol=value;
	}

	public void setContrasena(String value) {
		this.contrasena = value;
		// this.idRol=value;
	}

	// metodos Get
	public int getIdUser() {
		return this.idUser;
		// this.idRol=value;
	}

	public int getIdRol() {
		return this.idRol;
		// this.idRol=value;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
		// this.idRol=value;
	}

	public String getUserName() {
		return this.userName;
		// this.idRol=value;
	}

	public String getContrasena() {
		return this.contrasena;
		// this.idRol=value;
	}
}
