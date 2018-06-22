package clases;

public class arregloProductosTempHash {
	int idProd;
	int tipoProducto;
	String Descripcion;
	float pvp;
	float equivalenteUnidad;
	float totalBruto;
	String umedida;

	public void arregloProductosTempHash(int idProd, int tipoProducto,
			String Descripcion, float pvp, float equivalenteUnidad,
			float totalBruto, String umedida) {
		this.idProd = idProd;
		this.tipoProducto = tipoProducto;
		this.Descripcion = Descripcion;
		this.pvp = pvp;
		this.equivalenteUnidad = equivalenteUnidad;
		this.totalBruto = totalBruto;
		this.umedida = umedida;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public void setEquivalenteUnidad(float equivalenteUnidad) {
		this.equivalenteUnidad = equivalenteUnidad;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public void setTotalBruto(float totalBruto) {
		this.totalBruto = totalBruto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public float getEquivalenteUnidad() {
		return equivalenteUnidad;
	}

	public int getIdProd() {
		return idProd;
	}

	public float getPvp() {
		return pvp;
	}

	public float getTotalBruto() {
		return totalBruto;
	}

	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public int getTipoProducto() {
		return tipoProducto;
	}

	public void setUmedida(String umedida) {
		this.umedida = umedida;
	}

	public String getUmedida() {
		return umedida;
	}

}
//
