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
import clases.comprobanteEgreso;

/**
 * esto es un data source renmbrar a comprobanteEgresoDataSource
 * 
 * @author Administrador
 * 
 */
public class comprobanteEgresoLlenarForm implements JRDataSource {
	private int indiceComprobanteEgresoActual = -1;
	private List<comprobanteEgresoObj> listaComprobantes = new ArrayList<comprobanteEgresoObj>();

	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;

		if ("NumeroComprobante".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getIdComprobante();
		} else if ("TipoRecibo".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getTipoComprobante();
		} else if ("total".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getTotal();
		} else if ("motivoEgreso".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getDescripcion();
		} else if ("emitidoEl".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getFecha();
		} else if ("numeroRecibo".equals(arg0.getName())) {
			valor = listaComprobantes.get(indiceComprobanteEgresoActual)
					.getNumeroComprobante();
		}

		return valor;
	}

	public boolean next() throws JRException {
		return ++indiceComprobanteEgresoActual < listaComprobantes.size();

	}

	public void addItem(comprobanteEgresoObj comprobantes) {
		this.listaComprobantes.add(comprobantes);
	}

	public void recibirDatosExternos(comprobanteEgreso objetoEntrada) {
		comprobanteEgresoLlenarForm datasource = new comprobanteEgresoLlenarForm();
		comprobanteEgresoObj p = new comprobanteEgresoObj(objetoEntrada
				.getIdComprobante(), objetoEntrada.getTipoComprobante(),
				objetoEntrada.getTotal(), objetoEntrada.getDescripcion(),
				objetoEntrada.getFecha(), objetoEntrada.getNumeroRecibo());
		datasource.addItem(p);// ID_COMPROBANTE, TIPO_COMPROBANTE, TOTAL,
		// DESCRIPCION, FECHA, NUMERO_COMPROBANTE
		// cargar reporte
		JasperReport reporte;
		try {
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/ComprobanteEgresoReporte.jasper");

			// reporte = (JasperReport) JRLoader
			// .loadObject("bin/reportes/ODT/reporteOdt.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					null, datasource);
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			jviewer.setVisible(true);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end recibir datos externos

	// public static void main(String[] args) throws JRException {}

	/*
	 * exportar a sin mostar JRExporter exporter = new JRPdfExporter();
	 * exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	 * exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new
	 * java.io.File("reportePDF.pdf")); exporter.exportReport();
	 */

	/*
	 * conexionBdd conn= new conexionBdd(); // TODO Auto-generated method stub
	 * JasperReport reporte = (JasperReport)
	 * JRLoader.loadObject("reportes/ComprobanteEgresoReporte.jasper");
	 * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,
	 * conn.getConexion()); JRExporter exporter = new JRPdfExporter();
	 * //exportar a archivo
	 * exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
	 * exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new
	 * java.io.File("reportePDF.pdf")); exporter.exportReport();
	 */
	/**
	 * otros formatos
	 */
	/*
	 * # PDF -> JRPdfExporter # HTML -> JRHtmlExporter # CSV -> JRCsvExporter #
	 * RTF -> JRRtfExporter # XLS -> JRXlsExporter # XML -> JRXmlExporter # TXT ->
	 * JRTextExporter
	 */

}