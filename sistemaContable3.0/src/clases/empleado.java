package clases;

/**
 * Write a description of class empleado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.mysql.jdbc.Blob;

public class empleado {
	// instance variables - replace the example below with your own
	private int idEmp;
	private int idRol;
	private String ruc;
	private String fechaNacimiento;
	private String nombre;
	private String apellido;
	private String fechaIngreso;
	private String estado;
	private String cargo;
	private float salario;
	private String direccion;
	private String telefono;
	private String sexo;
	private Blob foto;

	/**
	 * Constructor for objects of class empleado
	 */
	public empleado(int idEmp, int idRol, String ruc, String fechaNacimiento,
			String nombre, String apellido, String fechaIngreso, String estado,
			String cargo, float salario, String direccion, String telefono,
			String sexo, Blob foto) {

		this.idEmp = idEmp;
		this.idRol = idRol;
		this.ruc = ruc;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.cargo = cargo;
		this.salario = salario;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.foto = foto;
	}

	/**
	 * Metodos set para la clase rol
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdEMp(int value) {
		this.idEmp = value;
	}

	public void setIdRol(int value) {
		this.idRol = value;
		// this.idRol=value;
	}

	public void setRuc(String value) {
		this.ruc = value;
		// this.idRol=value;
	}

	public void setFechaNacimiento(String value) {
		this.fechaNacimiento = value;
		// this.idRol=value;
	}

	public void setNombre(String value) {
		this.nombre = value.toUpperCase();
		// this.idRol=value;
	}

	public void setApellido(String value) {
		this.apellido = value;
		// this.idRol=value;
	}

	public void setFechaIngreso(String value) {
		this.fechaIngreso = value;
		// this.idRol=value;
	}

	public void setEstado(String value) {
		this.estado = value;
		// this.idRol=value;
	}

	public void setCargo(String value) {
		this.cargo = value;
		// this.idRol=value;
	}

	public void setSalario(float value) {
		this.salario = value;
		// this.idRol=value;
	}

	public void setDireccion(String value) {
		this.direccion = value;
		// this.idRol=value;
	}

	public void setTelefono(String value) {
		this.telefono = value;
		// this.idRol=value;
	}

	public void setSexo(String value) {
		this.sexo = value;
		// this.idRol=value;
	}

	public void setFoto(Blob value) {
		this.foto = value;
		// this.idRol=value;
	}

	// metodos Get
	public int getIdEMp() {
		return this.idEmp;
	}

	public int getIdRol() {
		return this.idRol;
		// this.idRol=value;
	}

	public String getRuc() {
		return this.ruc;
		// this.idRol=value;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
		// this.idRol=value;
	}

	public String getNombre() {
		return this.nombre;
		// this.idRol=value;
	}

	public String getApellido() {
		return this.apellido;
		// this.idRol=value;
	}

	public String getFechaIngreso() {
		return this.fechaIngreso;
		// this.idRol=value;
	}

	public String getEstado() {
		return this.estado;
		// this.idRol=value;
	}

	public String getCargo() {
		return this.cargo;
		// this.idRol=value;
	}

	public float getSalario() {
		return this.salario;
		// this.idRol=value;
	}

	public String getDireccion() {
		return this.direccion;
		// this.idRol=value;
	}

	public String getTelefono() {
		return this.telefono;
		// this.idRol=value;
	}

	public String getSexo() {
		return this.sexo;
		// this.idRol=value;
	}

	public Blob getFoto() {
		return this.foto;
		// this.idRol=value;
	}

}
