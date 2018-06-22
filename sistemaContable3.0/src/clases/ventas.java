package clases;

public class ventas {
	Float ventasTotalODT;
	Float ventasSaldoPorCobrarODT;

	Float VentasAPlazo;
	Float pagosAPlazo;

	Float ventasFacturas;
	Float ivaCobrado;
	Float GastosTotales;
	Float ivaPagado;

	public ventas(Float ventasTotalODT, Float ventasSaldoPorCobrarODT,
			Float ventasAPlazo, Float pagosAPlazo, Float ventasFacturas,
			Float ivaCobrado, Float gastosTotales, Float ivaPagado) {
		super();
		this.ventasTotalODT = ventasTotalODT;
		this.ventasSaldoPorCobrarODT = ventasSaldoPorCobrarODT;
		VentasAPlazo = ventasAPlazo;
		this.pagosAPlazo = pagosAPlazo;
		this.ventasFacturas = ventasFacturas;
		this.ivaCobrado = ivaCobrado;
		this.GastosTotales = gastosTotales;
		this.ivaPagado = ivaPagado;
	}

	public Float getVentasTotalODT() {
		return ventasTotalODT;
	}

	public void setVentasTotalODT(Float ventasTotalODT) {
		this.ventasTotalODT = ventasTotalODT;
	}

	public Float getVentasSaldoPorCobrarODT() {
		return ventasSaldoPorCobrarODT;
	}

	public void setVentasSaldoPorCobrarODT(Float ventasSaldoPorCobrarODT) {
		this.ventasSaldoPorCobrarODT = ventasSaldoPorCobrarODT;
	}

	public Float getVentasAPlazo() {
		return VentasAPlazo;
	}

	public void setVentasAPlazo(Float ventasAPlazo) {
		VentasAPlazo = ventasAPlazo;
	}

	public Float getPagosAPlazo() {
		return pagosAPlazo;
	}

	public void setPagosAPlazo(Float pagosAPlazo) {
		this.pagosAPlazo = pagosAPlazo;
	}

	public Float getVentasFacturas() {
		return ventasFacturas;
	}

	public void setVentasFacturas(Float ventasFacturas) {
		this.ventasFacturas = ventasFacturas;
	}

	public Float getIvaCobrado() {
		return ivaCobrado;
	}

	public void setIvaCobrado(Float ivaCobrado) {
		this.ivaCobrado = ivaCobrado;
	}

	public Float getGastosTotales() {
		return GastosTotales;
	}

	public void setGastosTotales(Float gastosTotales) {
		GastosTotales = gastosTotales;
	}

	public Float getIvaPagado() {
		return ivaPagado;
	}

	public void setIvaPagado(Float ivaPagado) {
		this.ivaPagado = ivaPagado;
	}

}
