package Dialog;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.jdesktop.swingworker.SwingWorker;

import ventanas.mostrarImagen;
import clasesBdd.conexionBdd;

public class dialogMostrarRecibosPorPagar extends JFrame {

	private JPanel jContentPane = null;
	private JButton btnStartWorker = null;
	private JLabel jLabel = null;
	private JLabel lblCompletado = null;
	private JLabel lblFinish = null;
	private MiWorker trabajador;
	private JProgressBar bar = null;
	boolean starter = true;
	String fecha1Init;
	String fecha2Init;

	/**
	 * This method initializes btnStartWorker
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnStartWorker() {
		if (btnStartWorker == null) {
			btnStartWorker = new JButton();
			btnStartWorker.setBounds(new Rectangle(-1, 0, 11, 8));
			btnStartWorker.setText("Empezar");
			btnStartWorker
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (trabajador == null) {
								trabajador = new MiWorker();

								// Agrego un Listener para el cambio de la
								// propiedad "progress"
								trabajador
										.addPropertyChangeListener(new PropertyChangeListener() {
											public void propertyChange(
													PropertyChangeEvent evt) {
												if ("progress".equals(evt
														.getPropertyName())) {
													lblCompletado.setText(evt
															.getNewValue()
															+ " %");
												}
											}
										});
							}
							trabajador.execute();
						}
					});
		}
		return btnStartWorker;
	}

	/**
	 * This method initializes bar
	 *
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getBar() {
		if (bar == null) {
			bar = new JProgressBar();
			bar.setMinimum(0);
			bar.setIndeterminate(true);
			bar.setMaximum(100);
			bar.setStringPainted(false);
			bar.setBounds(new Rectangle(18, 48, 266, 21));
		}
		return bar;
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { (new
	 * ProgressBarTest()).setVisible(true); }
	 */

	/**
	 * This is the default constructor
	 */
	public dialogMostrarRecibosPorPagar(String fecha1, String fecha2) {
		super();
		initialize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fecha1Init = fecha1;
		fecha2Init = fecha2;
		btnStartWorker.doClick();
		btnStartWorker.setVisible(false);

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(309, 144);
		this.setContentPane(getJContentPane());
		this.setTitle("Espere por favor");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblFinish = new JLabel();
			lblFinish.setBounds(new Rectangle(73, 13, 153, 28));
			lblFinish.setText("");
			lblCompletado = new JLabel();
			lblCompletado.setBounds(new Rectangle(96, 73, 39, 20));
			lblCompletado
					.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			lblCompletado.setText("0%");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(19, 72, 74, 19));
			jLabel.setText("Completado:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnStartWorker(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(lblCompletado, null);
			jContentPane.add(lblFinish, null);
			jContentPane.add(getBar(), null);
		}
		return jContentPane;
	}

	/*
	 * Esta es mi inner class "MiWorker", si se fijan, estoy instrumentando
	 * Generics para decirle a esta clase, que deberá retornar del
	 * "doInBackGround" un String, y que los demás métodos no deben retornar
	 * nada (void)
	 */
	class MiWorker extends SwingWorker<String, Void> {

		@Override
		protected String doInBackground() throws Exception {
			int i = 0;

			while (i <= 100) {
				if (starter) {
					llamarCompraporGastoReporte(fecha1Init, fecha2Init);
					starter = false;
				}

				bar.setValue(i);
				setProgress(i);
				i++;
				Thread.sleep(5);
				if (!isFocusable())
					cerrar();
			}

			cerrar();
			return "Operacion finalizada";
		}

		@Override
		public void done() {
			try {
				lblFinish.setText(get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cerrar() {
		this.dispose();
	}

	public void cerrarFrameImagen(mostrarImagen frame) {
		frame.dispose();
	}

	/**
	 * reporte egresos
	 *
	 * @param parameterMap
	 * @param Query
	 */
	public void llenarReporteEgresos(HashMap parameterMap, String Query) {
		conexionBdd conn = new conexionBdd();
		ResultSet resultSet = generateReport(conn.getConexion(), Query);
		JasperReport reporte;
		try {
			// if(resultSet.)
			/*
			 * resultSet.last();
			 * if(resultSet.getString(resultSet.getRow())!=null){
			 * resultSet.beforeFirst();
			 */
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/reporteFacturasPorPagar.jasper");
			JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(
					resultSet);
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					parameterMap, resultSetDataSource);//
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);
			jviewer.setTitle("Reporte de Compras ");

			jviewer.setVisible(true);
			resultSet.close();
			/*
			 * }else{ JOptionPane.showMessageDialog(null, "Esta consulta no
			 * tiene registros! ", "Aviso!", JOptionPane.INFORMATION_MESSAGE); }
			 */
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * devuelver el resulset para llenar el reporte
	 *
	 * @param conn
	 * @param Query
	 * @return
	 */
	public ResultSet generateReport(Connection conn, String Query) {
		ResultSet rs2 = null;
		try {

			PreparedStatement statement = conn.prepareStatement(Query);
			ResultSet rs = statement.executeQuery();
			rs2 = rs;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,
					"Error al realizar la consulta!" + e.getMessage(),
					"Alerta!", JOptionPane.ERROR_MESSAGE);

		}

		return rs2;
	}

	/**
	 *
	 * @param fecha1
	 * @param fecha2
	 */
	public void llamarCompraporGastoReporte(String fecha1, String fecha2) {
		String Query = "SELECT "
				+ "     compras_gastos.`ID_COM_GAS` AS compras_gastos_ID_COM_GAS, "
				+ "     compras_gastos.`COMPROBANTE` AS compras_gastos_COMPROBANTE, "
				+ "     compras_gastos.`DESCRIPCION` AS compras_gastos_DESCRIPCION, "
				+ "     compras_gastos.`TIPO_COMPROBANTE` AS compras_gastos_TIPO_COMPROBANTE, "
				+ "     compras_gastos.`IVA` AS compras_gastos_IVA, "
				+ "     compras_gastos.`SUBTOTAL` AS compras_gastos_SUBTOTAL, "
				+ "     compras_gastos.`TOTAL_PAGADO` AS compras_gastos_TOTAL_PAGADO, "
				+ "     compras_gastos.`NUMERO_RETENCION` AS compras_gastos_NUMERO_RETENCION, "
				+ "     compras_gastos.`TOTAL_RETENCION` AS compras_gastos_TOTAL_RETENCION, "
				+ "     compras_gastos.`FECHA_COMPRA` AS compras_gastos_FECHA_COMPRA "
				+ "  FROM     `compras_gastos` compras_gastos "
				+ " where  compras_gastos.`FECHA_COMPRA` BETWEEN '" + fecha1
				+ "' AND '" + fecha2 + "' "
				+ " order by compras_gastos_FECHA_COMPRA";

		HashMap parameterMap = new HashMap();
		parameterMap.put("fecha1", fecha1);
		parameterMap.put("fecha2", fecha2);
		llenarReporteEgresos(parameterMap, Query);
	}

} // @jve:decl-index=0:visual-constraint="10,10"
