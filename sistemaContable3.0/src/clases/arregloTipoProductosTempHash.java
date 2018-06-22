package clases;

public class arregloTipoProductosTempHash {
	int tipoProducto;
	String descripcion;

	public void arregloTipoProductosTempHash(int tipoProducto,
			String descripcion) {
		this.tipoProducto = tipoProducto;
		this.descripcion = descripcion;

	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

}
