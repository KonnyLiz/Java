package reportes;

import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import clasesBdd.conexionBdd;

public class FacturaCompraLlenarForm implements JRDataSource {

	conexionBdd conn = new conexionBdd();

	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirDatosExternos(String numero) {

		// cargar reporte
		JasperReport reporte;

		try {

			HashMap parameterMap = new HashMap();
			parameterMap.put("idcomgas", numero);
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/reporteFacturaCompra.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					parameterMap, conn.getConexion());//
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			jviewer.setTitle("Reporte de Factura de compra");
			jviewer.setVisible(true);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end recibir datos externos

}
