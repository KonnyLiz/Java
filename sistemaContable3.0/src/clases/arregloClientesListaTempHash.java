package clases;

public class arregloClientesListaTempHash {
	public String tipo;
	public String nombre;
	public String ruc;
	public String telefono;
	public String adicional;
	public String adicional2;
	public boolean editar;

	public arregloClientesListaTempHash(String var1, String var2, String var3,
			String var4, boolean var5) {
		this.tipo = var1;
		this.nombre = var2;
		this.ruc = var3;
		this.telefono = var4;
		this.editar = var5;
	}

	public arregloClientesListaTempHash(String tipo, String nombre, String ruc,
			String telefono,boolean editar, String adicional, String adicional2 ) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.ruc = ruc;
		this.telefono = telefono;
		this.adicional = adicional;
		this.adicional2 = adicional2;
		this.editar = editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public String getTelefono() {
		return telefono;
	}

	public boolean getEditar() {
		return editar;
	}

	public String getTipo() {
		return tipo;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public String getAdicional2() {
		return adicional2;
	}

	public void setAdicional2(String adicional2) {
		this.adicional2 = adicional2;
	}


}
