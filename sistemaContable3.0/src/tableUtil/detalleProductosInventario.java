package tableUtil;

public class detalleProductosInventario {
	String tipoProducto;
	String producto;
	String nomenclatura;
	String bodega;
	String precioVenta;
	Boolean actualizar;

	public detalleProductosInventario(String tipoProducto, String producto,
			String nomenclatura, String bodega, String precioVenta,
			Boolean actualizar) {

		this.tipoProducto = tipoProducto;
		this.producto = producto;
		this.nomenclatura = nomenclatura;
		this.bodega = bodega;
		this.precioVenta = precioVenta;
		this.actualizar = actualizar;

	}

	public void setActualizar(Boolean actualizar) {
		this.actualizar = actualizar;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Boolean getActualizar() {
		return actualizar;
	}

	public String getBodega() {
		return bodega;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public String getProducto() {
		return producto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

}