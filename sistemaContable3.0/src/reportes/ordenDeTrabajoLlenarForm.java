package reportes;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ordenDeTrabajoLlenarForm implements JRDataSource {
	private int indiceOrdenDeTrabajoActual = -1;

	private List<ordenDeTrabajoObj> listaOrdenesTrabajo = new ArrayList<ordenDeTrabajoObj>();

	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;

		if ("order_trabajo_NUMERO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getNumeroOrdenTrabajo();
		} else if ("cliente_NOMBRE".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getNombreCliente();
		} else if ("order_trabajo_ID_OT".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getNumeroOrdenTrabajoSistema();
		} else if ("order_trabajo_N_ARCHIVO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getNombreDelArchivo();
		} else if ("order_trabajo_IMPRESION".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getTipoDeTrabajo();
		} else if ("order_trabajo_PRECIO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getPrecio();
		} else if ("order_trabajo_ABONO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getAbono();
		} else if ("order_trabajo_SALDO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getSaldo();
		} else if ("order_trabajo_OBSERVACION".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getObservacion();
		} else if ("order_trabajo_ESTADO".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getEstado();
		} else if ("empleado_NOMBRE".equals(arg0.getName())) {
			valor = listaOrdenesTrabajo.get(indiceOrdenDeTrabajoActual)
					.getResponsable();
		}

		return valor;
	}

	public boolean next() throws JRException {
		return ++indiceOrdenDeTrabajoActual < listaOrdenesTrabajo.size();

	}

	public void addItem(ordenDeTrabajoObj comprobantes) {
		this.listaOrdenesTrabajo.add(comprobantes);
	}

	public void recibirDatosExternos(ordenDeTrabajoObj objetoEntrada) {

		ordenDeTrabajoLlenarForm datasource = new ordenDeTrabajoLlenarForm();
		/*
		 * for (int i = 1; i <= 10; i++) { Participante p = new Participante(i,
		 * "Particpante " + i, "Usuario " + i, "Pass " + i, "Comentarios para " +
		 * i); datasource.addParticipante(p); }
		 */
		ordenDeTrabajoObj p = new ordenDeTrabajoObj(

		objetoEntrada.getNumeroOrdenTrabajo(), objetoEntrada
				.getNumeroOrdenTrabajoSistema(), objetoEntrada.getFecha(),
				objetoEntrada.getNombreCliente(), objetoEntrada
						.getNombreDelArchivo(), objetoEntrada
						.getTipoDeTrabajo(), objetoEntrada.getPrecio(),
				objetoEntrada.getAbono(), objetoEntrada.getSaldo(),
				objetoEntrada.getObservacion(), objetoEntrada.getEstado(),
				objetoEntrada.getResponsable());
		datasource.addItem(p);// ID_COMPROBANTE, TIPO_COMPROBANTE, TOTAL,
		// DESCRIPCION, FECHA, NUMERO_COMPROBANTE
		// cargar reporte
		JasperReport reporte;
		try {
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/odt/reporteOdt.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					null, datasource);
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end recibir datos externos

}
