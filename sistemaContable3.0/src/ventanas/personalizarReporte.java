package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Dialog.DialogProductoMenosVendidoRecibo;
import Dialog.dialogMostrar10MasVendidos;
import Dialog.dialogMostrarDocumentosAduana;
import Dialog.dialogMostrarEstadoComprasVentas;
import Dialog.dialogMostrarProdCategoria;
import Dialog.dialogMostrarRecibosPorCobrar;
import Dialog.dialogMostrarRecibosPorPagar;
import Dialog.dialogMostrarReporteEgresosFechas;
import Dialog.dialogMostrarVentasPorTipoCliente;
import Dialog.dialogProdMasvendidoOdt;
import Dialog.dialogProdPruducidoMenosVendido;
import Dialog.dialogREsumenNotasVenta;
import Dialog.dialogResumenFacturas;
import Dialog.dialogRetenciones;
import Dialog.dialogRetencionesCompras;
import Utilitarios.utilitarios;
import clasesBdd.conexionBdd;
import clasesBdd.reportesBdd;

import com.toedter.calendar.JCalendar;

//public class personalizarReporte extends JInternalFrame {
public class personalizarReporte extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JPanel jPanel3 = null;
	private JLabel jLabelFechaInicial = null;
	private JLabel jLabelFechaFinal = null;
	private JButton jButtonCalendario2 = null;
	private JButton jButtonCalendario = null;
	private JTextField JTextFieldFecha1 = null;
	private JTextField JTextFieldFecha2 = null;

	/**
	 * calendario 1
	 */
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup;
	protected boolean isInitialized;
	/**
	 * calendario 2
	 */

	protected JCalendar jcalendar2; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup2;

	String User1;
	int rowTemp = 0;
	int columnTemp = 0;
	conexionBdd conn = new conexionBdd();
	utilitarios util = new utilitarios();
	private JButton jButtonAceptar = null;
	private JLabel jLabelChoose = null;
	private JTree jTreeReportes = null;
	private JScrollPane jScrollPane = null;
	private JTextField jTextFieldSeleccionado = null;
	private JLabel jLabelCategoria = null;
	private JComboBox jComboBoxCategoria = null;
	reportesBdd reporteMd=new reportesBdd();  //  @jve:decl-index=0:
	private JLabel jLabelAlerta = null;




	/**
	 * This is the default constructor
	 */
	public personalizarReporte() {
		super();
		initialize();
		// this.setClosable(true);
		// this.setIconifiable(true);
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(758, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("Personalizar Reporte por fechas");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelAlerta = new JLabel();
			jLabelAlerta.setBounds(new Rectangle(359, 320, 381, 26));
			jLabelAlerta.setForeground(Color.red);
			jLabelAlerta.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabelAlerta.setText(" Estado:");
			jLabelChoose = new JLabel();
			jLabelChoose.setBounds(new Rectangle(375, 40, 117, 20));
			jLabelChoose.setForeground(Color.blue);
			jLabelChoose
					.setToolTipText("Hacer Click para actualizar los mensajes");
			jLabelChoose.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelChoose.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelChoose.setText("Escoja una opción");
			jLabelChoose.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(-2, 15, 751, 20));
			jLabel.setForeground(Color.blue);
			jLabel.setToolTipText("Hacer Click para actualizar los mensajes");
			jLabel.setText("Personalizar Reportes");
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJPanel3(), null);
			jContentPane.add(getJButtonCalendario2(), null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(getJTextFieldFecha1(), null);
			jContentPane.add(getJTextFieldFecha2(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(jLabelChoose, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJTextFieldSeleccionado(), null);
			jContentPane.add(getJComboBoxCategoria(), null);
			jContentPane.add(jLabelAlerta, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel3
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jLabelCategoria = new JLabel();
			jLabelCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCategoria.setText("Fecha Final :");
			jLabelCategoria.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaFinal = new JLabel();
			jLabelFechaFinal.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaFinal.setText("Categoría :");
			jLabelFechaFinal.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaInicial = new JLabel();
			jLabelFechaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicial.setText("Fecha Inicial :");
			jLabelFechaInicial.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(3);
			gridLayout.setHgap(1);
			gridLayout.setVgap(9);
			gridLayout.setColumns(1);
			jPanel3 = new JPanel();
			jPanel3.setLayout(gridLayout);
			jPanel3.setBounds(new Rectangle(377, 116, 95, 93));
			jPanel3.add(jLabelFechaInicial, null);
			jPanel3.add(jLabelCategoria, null);
			jPanel3.add(jLabelFechaFinal, null);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jButtonCalendario2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario2() {
		if (jButtonCalendario2 == null) {
			jButtonCalendario2 = new JButton();
			jButtonCalendario2.setBounds(new Rectangle(574, 148, 27, 21));
			jButtonCalendario2.setText("");
			jButtonCalendario2.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			/*
			 * Código de Inicialización del calendario 2 botón
			 */
			this.jcalendar2 = new JCalendar();

			jcalendar2
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {

							if ((e.getPropertyName().equals("calendar"))) {
								// diaAnterior=jTextFieldFechaInicial.getText().substring(8,10);
								Date fecha = jcalendar2.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								JTextFieldFecha2.setText(fechaString);

							}

						}
					});

			popup2 = new JPopupMenu() {

				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

			};
			popup2.setLightWeightPopupEnabled(true);

			popup2.add(jcalendar2);
			isInitialized = true;

			/*
			 * fin del codigo del calendario boton
			 */

			jButtonCalendario2
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							int x = jButtonCalendario2.getWidth()
									- (int) popup2.getPreferredSize()
											.getWidth();
							int y = jButtonCalendario2.getY()
									+ jButtonCalendario2.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar2.setCalendar(calendar);
							popup2
									.show(jButtonCalendario2, jButtonCalendario
											.getY() - 90, jButtonCalendario
											.getY() - 90);

						}
					});
		}
		return jButtonCalendario2;
	}

	/**
	 * This method initializes jButtonCalendario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setText("");
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario.setBounds(new Rectangle(574, 116, 27, 21));
			jButtonCalendario
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							int x = jButtonCalendario.getWidth()
									- (int) popup.getPreferredSize().getWidth();
							int y = jButtonCalendario.getY()
									+ jButtonCalendario.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar.setCalendar(calendar);
							popup
									.show(jButtonCalendario, jButtonCalendario
											.getY() - 90, jButtonCalendario
											.getY() - 90);
						}
					});
			/*
			 * Código de Inicialización del calendario boton
			 */
			this.jcalendar = new JCalendar();

			jcalendar
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {

							if ((e.getPropertyName().equals("calendar"))) {
								// diaAnterior=jTextFieldFechaInicial.getText().substring(8,10);
								Date fecha = jcalendar.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								JTextFieldFecha1.setText(fechaString);

							}

						}
					});

			popup = new JPopupMenu() {

				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

			};
			popup.setLightWeightPopupEnabled(true);

			popup.add(jcalendar);
			isInitialized = true;

			/*
			 * fin del codigo del calendario boton
			 */
		}
		return jButtonCalendario;
	}

	/**
	 * This method initializes JTextFieldFecha1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha1() {
		try {
			MaskFormatter mascara = new MaskFormatter("####-##-##");
			JTextFieldFecha1 = new JFormattedTextField(mascara);
			JTextFieldFecha1.setText(util.fechaActual());
			JTextFieldFecha1.setEditable(false);
			JTextFieldFecha1.setBounds(new Rectangle(486, 116, 77, 21));
			JTextFieldFecha1
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							activarBoton();
						}

					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JTextFieldFecha1;
	}

	/**
	 * This method initializes JTextFieldFecha2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha2() {
		if (JTextFieldFecha2 == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				JTextFieldFecha2 = new JFormattedTextField(mascara);
				JTextFieldFecha2.setText(util.fechaActual());
				JTextFieldFecha2.setBounds(new Rectangle(486, 148, 77, 21));
				JTextFieldFecha2.setEditable(false);
				JTextFieldFecha2
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {
								activarBoton();
							}

						});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return JTextFieldFecha2;
	}

	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(378, 289, 94, 24));
			jButtonAceptar.setEnabled(false);
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							mostrar("" + jTextFieldSeleccionado.getText(),
									JTextFieldFecha1.getText(),
									JTextFieldFecha2.getText());
						}
					});
		}
		return jButtonAceptar;
	}

	/**
	 * activa el botón si las fechas son diferentes
	 */
	public void activarBoton() {
		String fecha1 = JTextFieldFecha1.getText();
		String fecha2 = JTextFieldFecha2.getText();

		try {
			if (fecha1.trim().compareToIgnoreCase("") == 0)
				fecha1 = util.fechaActual();
			if (fecha2.trim().compareToIgnoreCase("") == 0)
				fecha2 = util.fechaActual();

			if (util.compararFechasString(fecha1, fecha2)
					&& fecha1.compareTo(fecha2) <= 0) {
				jButtonAceptar.setEnabled(true);

			} else {
				jButtonAceptar.setEnabled(false);

			}

		} catch (Exception vacio) {
		}

	}

	/**
	 * carga el reporte especificado requiere el nombre del reporte 2 fechas
	 * inicial y final
	 *
	 * @param reporte
	 * @param fecha1
	 * @param fecha2
	 */
	private void mostrar(String reporte, String fecha1, String fecha2) {

	 if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Egresos") == 0) {
			dialogMostrarReporteEgresosFechas dialogMostrarReporteEgresosFechasw = new dialogMostrarReporteEgresosFechas(
					fecha1, fecha2);
			dialogMostrarReporteEgresosFechasw.getPreferredSize();
			dialogMostrarReporteEgresosFechasw.setLocation(
					this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrarReporteEgresosFechasw.setVisible(true);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Documentos de Aduana") == 0) {
			dialogMostrarDocumentosAduana dialogMostrarDocumentosAduanaWW = new dialogMostrarDocumentosAduana(
					fecha1, fecha2);
			dialogMostrarDocumentosAduanaWW.getPreferredSize();
			dialogMostrarDocumentosAduanaWW.setLocation(this.getHeight() / 2,
					this.getWidth() / 2);
			dialogMostrarDocumentosAduanaWW.setVisible(true);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Cuentas por cobrar") == 0) {
			dialogMostrarRecibosPorCobrar dialogMostrarReporteEgresosFechasw = new dialogMostrarRecibosPorCobrar(
					fecha1, fecha2);
			dialogMostrarReporteEgresosFechasw.getPreferredSize();
			dialogMostrarReporteEgresosFechasw.setLocation(
					this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrarReporteEgresosFechasw.setVisible(true);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Compras Realizadas") == 0) {
			dialogMostrarRecibosPorPagar dialogMostrarRecibosPorPagarWW = new dialogMostrarRecibosPorPagar(
					fecha1, fecha2);
			dialogMostrarRecibosPorPagarWW.getPreferredSize();
			dialogMostrarRecibosPorPagarWW.setLocation(this.getHeight() / 2,
					this.getWidth() / 2);
			dialogMostrarRecibosPorPagarWW.setVisible(true);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Ordenes de Trabajo por Empleados") == 0) {

			llamarOdtClienteReporte(fecha1, fecha2);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Ventas en ODT por tipo de cliente") == 0) {
			dialogMostrarVentasPorTipoCliente dialogMostrarVentasPorTipoClienteWW = new dialogMostrarVentasPorTipoCliente(
					fecha1, fecha2);
			dialogMostrarVentasPorTipoClienteWW.getPreferredSize();
			dialogMostrarVentasPorTipoClienteWW.setLocation(
					this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrarVentasPorTipoClienteWW.setVisible(true);
		}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Cierre de caja") == 0) {
			dialogMostrarEstadoComprasVentas dialogMostrarEstadoComprasVentasWW = new dialogMostrarEstadoComprasVentas(
					fecha1, fecha2);
			dialogMostrarEstadoComprasVentasWW.getPreferredSize();
			dialogMostrarEstadoComprasVentasWW.setLocation(
					this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrarEstadoComprasVentasWW.setVisible(true);
		}
//Nuevos reportes

		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
				"Productos mas vendidos (Recibos) Top 10") == 0) {

			dialogMostrar10MasVendidos dialogMostrar10MasVendidosWW = new dialogMostrar10MasVendidos(
			fecha1, fecha2);
			dialogMostrar10MasVendidosWW.getPreferredSize();
			dialogMostrar10MasVendidosWW.setLocation(
			this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrar10MasVendidosWW.setVisible(true);
}
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Productos menos vendidos (Recibos) Top 10") == 0) {

			DialogProductoMenosVendidoRecibo DialogProductoMenosVendidoReciboWW = new DialogProductoMenosVendidoRecibo(
	fecha1, fecha2);
			DialogProductoMenosVendidoReciboWW.getPreferredSize();
			DialogProductoMenosVendidoReciboWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			DialogProductoMenosVendidoReciboWW.setVisible(true);
}

		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Productos Elaborados mas vendidos (Recibos) Top 10") == 0) {

			dialogProdMasvendidoOdt dialogProdMasvendidoOdtWW = new dialogProdMasvendidoOdt(
	fecha1, fecha2);
			dialogProdMasvendidoOdtWW.getPreferredSize();
			dialogProdMasvendidoOdtWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogProdMasvendidoOdtWW.setVisible(true);
}


		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Productos Elaborados menos vendidos (Recibos) Top 10") == 0) {

			dialogProdPruducidoMenosVendido dialogProdPruducidoMenosVendidoWW = new dialogProdPruducidoMenosVendido(
	fecha1, fecha2);
			dialogProdPruducidoMenosVendidoWW.getPreferredSize();
			dialogProdPruducidoMenosVendidoWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogProdPruducidoMenosVendidoWW.setVisible(true);
}

		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Resumen Notas de Venta ") == 0) {

			dialogREsumenNotasVenta dialogREsumenNotasVentaWW = new dialogREsumenNotasVenta(
	fecha1, fecha2);
			dialogREsumenNotasVentaWW.getPreferredSize();
			dialogREsumenNotasVentaWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogREsumenNotasVentaWW.setVisible(true);
}


		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Resumen Facturas ") == 0) {

			dialogResumenFacturas dialogResumenFacturasWW = new dialogResumenFacturas(
	fecha1, fecha2);
			dialogResumenFacturasWW.getPreferredSize();
			dialogResumenFacturasWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogResumenFacturasWW.setVisible(true);
}

		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Resumen Retenciones de Ventas") == 0) {

			dialogRetenciones dialogRetencionesWW = new dialogRetenciones(
	fecha1, fecha2);
			dialogRetencionesWW.getPreferredSize();
			dialogRetencionesWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogRetencionesWW.setVisible(true);
}

		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Resumen Retenciones de Compras") == 0) {

			dialogRetencionesCompras dialogRetencionesComprasWW = new dialogRetencionesCompras(
	fecha1, fecha2);
			dialogRetencionesComprasWW.getPreferredSize();
			dialogRetencionesComprasWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogRetencionesComprasWW.setVisible(true);
}


	      //reportes de inventario
		if (jTextFieldSeleccionado.getText().toString().compareToIgnoreCase(
		"Lista de productos por Categoria") == 0) {
            String categoria=jComboBoxCategoria.getSelectedItem().toString();
			dialogMostrarProdCategoria dialogMostrarProdCategoriaWW = new dialogMostrarProdCategoria(
	fecha1, fecha2,categoria);
			dialogMostrarProdCategoriaWW.getPreferredSize();
			dialogMostrarProdCategoriaWW.setLocation(
		    this.getHeight() / 2, this.getWidth() / 2);
			dialogMostrarProdCategoriaWW.setVisible(true);
		}








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

			/*
			 * resultSet.last();
			 * if(resultSet.getString(resultSet.getRow())!=null){
			 * resultSet.beforeFirst();
			 */
			// reporte = (JasperReport)
			// JRLoader.loadObject("bin/reportes/reportClienteODTFechas.jasper");
			JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(
					resultSet);
			reporte = (JasperReport) JRLoader
					.loadObject("bin/reportes/reportOrdenesTrabajoEmpleado.jasper");

			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					parameterMap, conn.getConexion());//
			JasperViewer jviewer = new JasperViewer(jasperPrint, false);

			resultSet.close();

			/*
			 * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
			 * parameterMap, resultSetDataSource);//
			 *
			 * JasperViewer jviewer = new JasperViewer(jasperPrint,false);
			 */
			jviewer.setTitle("Reporte Ordenes de trabajo por fechas");
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
	public void llamarOdtClienteReporte(String fecha1, String fecha2) {
		String Query = "SELECT count(o.ID_EMP),e.nombre "
				+ "from order_trabajo o, empleado e "
				+ "where e.ID_EMP=o.ID_EMP " + "and  o.FECHA BETWEEN '"
				+ fecha1 + "' and '" + fecha2 + "'" + "group by 2";

		HashMap parameterMap = new HashMap();
		parameterMap.put("fecha1", fecha1);
		parameterMap.put("fecha2", fecha2);
		llenarReporteEgresos(parameterMap, Query);
	}

	@Override
	public int getX() {
		int x = this.getWidth();
		return x;
	}

	@Override
	public int getY() {
		int y = this.getHeight();
		return y;
	}

	/**
	 * This method initializes jTreeReportes
	 *
	 * @return javax.swing.JTree
	 */
	private JTree getJTreeReportes() {
		if (jTreeReportes == null) {
			jTreeReportes = new JTree();
			jTreeReportes.setToolTipText("Seleccione el reporte");

			jTreeReportes.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mousePressed(java.awt.event.MouseEvent e) {

			         TreePath selPath = jTreeReportes.getPathForLocation(e.getX(), e.getY());
			        try{
			        	  String componente=selPath.getLastPathComponent().toString();
			              	jTextFieldSeleccionado.setText(componente);

			        }catch(Exception nodoOCarpeta){  System.out.print("Problema de conversion a String");}

			      //  System.out.println(selPath.getLastPathComponent().toString() );
				}
			});
			inicializar(jTreeReportes);
		}
		return jTreeReportes;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(25, 35, 327, 295));
			//jScrollPane.setViewportView(getJTreeReportes());
			jScrollPane.setViewportView(getJTreeReportes());
			//jScrollPane.setViewportView(getJTreeReportes());
			//jScrollPane.setViewportView(getJTreeReportes());
		}
		return jScrollPane;
	}
public void inicializar(JTree jTreeReportes){
	/*
	 *
	 *

Recibos por cobrar

Ordenes de Trabajo por Empleados
Ventas en ODT por tipo de cliente
Estado General de Compras  Ventas*/
	  DefaultMutableTreeNode rLista = new DefaultMutableTreeNode("Lista de Reportes");
	  DefaultMutableTreeNode rCobrosPagos = new DefaultMutableTreeNode("Reportes Generales");
	  DefaultMutableTreeNode rVentas = new DefaultMutableTreeNode("Reportes de Ventas");
	  DefaultMutableTreeNode rCompras = new DefaultMutableTreeNode("Reportes de Compras");
	  DefaultMutableTreeNode rFacturas = new DefaultMutableTreeNode("Reportes de Facturación");
	  //2011-06-11
	  DefaultMutableTreeNode rInventarios = new DefaultMutableTreeNode("Reportes de Inventario");

	  DefaultMutableTreeNode rCobrosPagosEgresosHijo1 = new DefaultMutableTreeNode("Egresos");
      DefaultMutableTreeNode rventasRecibosPorPagasHijo1 = new DefaultMutableTreeNode("Compras Realizadas");
      DefaultMutableTreeNode rventasDocuAduanaHijo2 = new DefaultMutableTreeNode("Documentos de Aduana");
      DefaultMutableTreeNode rventasCuentasCobrarHijo3 = new DefaultMutableTreeNode("Cuentas por cobrar");
      //reportes de ventas
      DefaultMutableTreeNode rcomprasProdMasVendidoHijo1 = new DefaultMutableTreeNode("Productos mas vendidos (Recibos) Top 10");
      DefaultMutableTreeNode rventasProdMenosVendidoHijo2 = new DefaultMutableTreeNode("Productos menos vendidos (Recibos) Top 10");
      DefaultMutableTreeNode rcomprasProdMasVendidoODTHijo3 = new DefaultMutableTreeNode("Productos Elaborados mas vendidos (Recibos) Top 10");
      DefaultMutableTreeNode rventasProdMenosVendidoODTHijo4 = new DefaultMutableTreeNode("Productos Elaborados menos vendidos (Recibos) Top 10");
      //reportes de facturacion
      DefaultMutableTreeNode rventasNotasDeVentaHijo1 = new DefaultMutableTreeNode("Resumen Notas de Venta ");
      DefaultMutableTreeNode rventasFacturasHijo2 = new DefaultMutableTreeNode("Resumen Facturas ");
      DefaultMutableTreeNode rventasRetencionesVentasHijo3 = new DefaultMutableTreeNode("Resumen Retenciones de Ventas");
      DefaultMutableTreeNode rventasRetencionesVentasHijo2 = new DefaultMutableTreeNode("Resumen Retenciones de Compras");
     //pagos y compras
      DefaultMutableTreeNode rRecibosPorCobrar = new DefaultMutableTreeNode("Recibos por cobrar");
      //Generales
      DefaultMutableTreeNode rGeneralesHijo1 = new DefaultMutableTreeNode("Ordenes de Trabajo por Empleados");
      DefaultMutableTreeNode rVentasTipoClHijo2 = new DefaultMutableTreeNode("Ventas en ODT por tipo de cliente");
      DefaultMutableTreeNode rCierreCajahijo3 = new DefaultMutableTreeNode("Cierre de Caja");   //Estado General de Compras  Ventas
      //Invetarios
      DefaultMutableTreeNode rCategoria1 = new DefaultMutableTreeNode("Lista de productos por Categoria");
     // DefaultMutableTreeNode rVentasTipoClHijo2 = new DefaultMutableTreeNode("Ventas en ODT por tipo de cliente");
     // DefaultMutableTreeNode rCierreCajahijo3 = new DefaultMutableTreeNode("Cierre de Caja");   //Estado General de Compras  Ventas



      DefaultTreeModel modelo = new DefaultTreeModel(rLista);//modelo por defecto

	  modelo.insertNodeInto(rCompras, rLista, 0);//inserto padres
	  modelo.insertNodeInto(rVentas, rLista, 1);
	  modelo.insertNodeInto(rCobrosPagos, rLista, 2);
	  modelo.insertNodeInto(rFacturas, rLista, 3);
      modelo.insertNodeInto(rInventarios, rLista, 4);//nuevo





	  modelo.insertNodeInto(rventasRecibosPorPagasHijo1,rCompras, 0);//inserto hijos
	  modelo.insertNodeInto(rventasDocuAduanaHijo2,rCompras, 1);
	  modelo.insertNodeInto(rCobrosPagosEgresosHijo1,rCompras, 2);//inserto hijos
	 // modelo.insertNodeInto(rventasCuentasCobrarHijo3,rCompras, 2);//inserto hijos provisional revisar


	  modelo.insertNodeInto(rcomprasProdMasVendidoHijo1,rVentas, 0);//inserto hijos
	  modelo.insertNodeInto(rventasProdMenosVendidoHijo2,rVentas, 1);//inserto hijos
	  modelo.insertNodeInto(rcomprasProdMasVendidoODTHijo3,rVentas, 2);//inserto hijos
	  modelo.insertNodeInto(rventasProdMenosVendidoODTHijo4,rVentas, 3);//inserto hijos
	  modelo.insertNodeInto(rRecibosPorCobrar,rVentas, 4);//inserto hijos

	  modelo.insertNodeInto(rventasNotasDeVentaHijo1,rFacturas, 0);//inserto hijos
	  modelo.insertNodeInto(rventasFacturasHijo2,rFacturas, 1);//inserto hijos
	  modelo.insertNodeInto(rventasRetencionesVentasHijo3,rFacturas, 2);//inserto hijos
	  modelo.insertNodeInto(rventasRetencionesVentasHijo2,rFacturas, 3);//inserto hijos


	  modelo.insertNodeInto(rGeneralesHijo1,rCobrosPagos, 0);//inserto hijos
	  modelo.insertNodeInto(rVentasTipoClHijo2,rCobrosPagos, 1);//inserto hijos
	  modelo.insertNodeInto(rCierreCajahijo3,rCobrosPagos, 2);//inserto hijos


	  modelo.insertNodeInto(rCategoria1,rInventarios, 0);//inserto hijos


	  jTreeReportes.setModel(modelo);

}

/**
 * This method initializes jTextFieldSeleccionado
 *
 * @return javax.swing.JTextField
 */
private JTextField getJTextFieldSeleccionado() {
	if (jTextFieldSeleccionado == null) {
		jTextFieldSeleccionado = new JTextField();
		jTextFieldSeleccionado.setBounds(new Rectangle(376, 74, 357, 26));
		jTextFieldSeleccionado.setForeground(new Color(0, 0, 204));
		jTextFieldSeleccionado.setFont(new Font("Dialog", Font.BOLD, 11));
		jTextFieldSeleccionado.setEditable(false);
		jTextFieldSeleccionado.addCaretListener(new javax.swing.event.CaretListener() {
			public void caretUpdate(javax.swing.event.CaretEvent e) {
				if(jTextFieldSeleccionado.getText().compareTo("Lista de productos por Categoria")==0){
					jComboBoxCategoria.setEnabled(true);
					jLabelAlerta.setText(" Estado: Para este reporte la fechas son ignoradas!");

				}else{
					jComboBoxCategoria.setEnabled(false);
				}
			}
		});
	}
	return jTextFieldSeleccionado;
}

/**
 * This method initializes jComboBoxCategoria
 *
 * @return javax.swing.JComboBox
 */
private JComboBox getJComboBoxCategoria() {
	if (jComboBoxCategoria == null) {
		jComboBoxCategoria = new JComboBox();
		jComboBoxCategoria.setBounds(new Rectangle(487, 183, 118, 23));
		jComboBoxCategoria.setEnabled(false);
		iniciarComboCategoria();
		jComboBoxCategoria.setToolTipText("Tipos de producto existente");
	}
	return jComboBoxCategoria;
}
private void iniciarComboCategoria(){
	conexionBdd con=new conexionBdd();  //  @jve:decl-index=0:
	//descripciones para tipo de producto
	Object[][] descripciones =reporteMd.retornarDescripcionesTipoProd(con.getConexion());  //  @jve:decl-index=0:

	for(int i=0;i<descripciones.length;i++){
		jComboBoxCategoria.addItem(descripciones[i][1]);

	}
}

} // @jve:decl-index=0:visual-constraint="10,10"
