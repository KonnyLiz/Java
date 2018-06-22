package reportes;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import clasesBdd.conexionBdd;

public class comprobanteEgresoReporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JTextField jTextField = null;
	private JInternalFrame jInternalFrame = null;

	/**
	 * This is the default constructor
	 */
	public comprobanteEgresoReporte() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(575, 473);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJInternalFrame(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(219, 10, 142, 37));
			jButton.setText("Mostrar Reporte");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarReporte();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(13, 18, 187, 24));
		}
		return jTextField;
	}

	public void mostrarReporte() {
		try {
			conexionBdd conn = new conexionBdd();
			// TODO Auto-generated method stub
			JasperReport reporte = (JasperReport) JRLoader
					.loadObject("reportes/report5.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					null, conn.getConexion());
			// JRExporter exporter = new JRPdfExporter();
			// exportar a archivo
			// exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			// exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new
			// java.io.File("reportePDF.pdf"));
			// exporter.exportReport();
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			JasperViewer.viewReport(jasperPrint);

		} catch (JRException ad) {
			ad.printStackTrace();
		}

	}

	/**
	 * This method initializes jInternalFrame
	 * 
	 * @return javax.swing.JInternalFrame
	 */
	private JInternalFrame getJInternalFrame() {
		if (jInternalFrame == null) {
			jInternalFrame = new JInternalFrame();
			jInternalFrame.setBounds(new Rectangle(208, 359, 274, 71));
		}
		return jInternalFrame;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
