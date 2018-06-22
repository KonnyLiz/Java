package clases;

import java.util.Date;

/**
 * Write a description of class tipoVentaFactura here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class tipoVentaFactura {
	// instance variables - replace the example below with your own
	private int idTipoVenta;
	private int idFactura;
	private float cantidad;
	private String detalle;
	private Date plazo;

	/**
	 * Constructor for objects of class tipoVentaFactura
	 */
	public tipoVentaFactura(int idTipoVenta, int idFactura, float cantidad,
			String detalle, Date plazo) {
		this.idTipoVenta = idTipoVenta;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.detalle = detalle;
		this.plazo = plazo;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdTipoVenta(int value) {
		this.idTipoVenta = value;
	}

	public void setIdFactura(int value) {
		this.idFactura = value;
	}

	public void setcantidad(int value) {
		this.cantidad = value;
	}

	public void setDetalle(String value) {
		this.detalle = value;
	}

	public void setPlazo(Date value) {
		this.plazo = value;
	}

	// Metodos Get

	public int getIdTipoVenta() {
		return this.idTipoVenta;
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public float getcantidad() {
		return this.cantidad;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public Date getPlazo() {
		return this.plazo;
	}

}
