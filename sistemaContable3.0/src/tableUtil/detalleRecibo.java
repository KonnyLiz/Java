package tableUtil;

public class detalleRecibo {
	private float cantidad;
	private String descripcion;
	private float vUnitario;
	private float vTotal;
	private boolean eliminar;

	public detalleRecibo(float cantidad, String descripcion, float vUnitario,
			float vTotal, boolean eliminar) {
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.vUnitario = vUnitario;
		this.vTotal = vTotal;
		this.eliminar = eliminar;

	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setVTotal(float total) {
		vTotal = total;
	}

	public void setVUnitario(float unitario) {
		vUnitario = unitario;
	}

	// getter
	public float getCantidad() {
		return cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getVTotal() {
		return vTotal;
	}

	public float getVUnitario() {
		return vUnitario;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public boolean getEliminar() {
		return eliminar;
	}

}
