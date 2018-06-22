package clases;

public class PagoDeReciboPorClienteTemp {
	public String numero;
	public String tipo;
	public String cantidad;
	public String detalle;
	public String plazo;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	public PagoDeReciboPorClienteTemp(String numero, String tipo,
			String cantidad, String detalle, String plazo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.detalle = detalle;
		this.plazo = plazo;
	}






}
