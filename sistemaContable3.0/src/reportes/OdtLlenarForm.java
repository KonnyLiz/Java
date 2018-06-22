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

public class OdtLlenarForm implements JRDataSource {

	conexionBdd conn = new conexionBdd();

	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirDatosExternos(int numero) {

		// cargar reporte
		JasperReport reporte;

		try {

			HashMap parameterMap = new HashMap();
			parameterMap.put("numeroIdOtTabla", new Integer(numero));
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/odt/reporteOdt.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					parameterMap, conn.getConexion());//
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			jviewer.setTitle("Reporte de la Orden De Trabajo");
			jviewer.setVisible(true);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end recibir datos externos

}
