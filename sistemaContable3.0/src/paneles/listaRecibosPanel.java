package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import reportes.reciboLlenarForm;
import tableUtil.RenderReciboLista;
import tableUtil.detalleReciboModeloListaRecibo;
import tableUtil.modeloListaRecibo;
import ventanas.TipodePagoRecibo;
import Utilitarios.utilitarios;
import clases.recibo;
import clasesBdd.conexionBdd;
import clasesBdd.reciboBdd;

import com.toedter.calendar.JCalendar;

public class listaRecibosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelVer = null;
	private JPanel jPanel = null;
	private JLabel jLabelFechaInicial = null;
	private JLabel jLabelFechaInicial1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JTextField jTextFieldFecha1 = null;
	private JTextField jTextFieldFecha2 = null;
	private JPanel jPanel1 = null;
	private JComboBox jComboBox = null;
	private JButton jButtonCalendario = null;
	private JButton jButtonCalendario2 = null;
	private JScrollPane jScrollPane = null;
	JDesktopPane JDesktopPanePrin;
	/*
	 * para uso del calendario
	 */
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="701,66"
	protected JPopupMenu popup;
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	protected boolean isInitialized;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	conexionBdd conn = new conexionBdd();
	reciboBdd reciboBdd1 = new reciboBdd(); // @jve:decl-index=0:
	/*
	 * para uso del calendario 2
	 */

	protected JCalendar jcalendar2; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup2;
	String diaAnterior2 = "01"; // @jve:decl-index=0:
	String BufferComparacion2 = "01"; // @jve:decl-index=0:
	private JPanel jPanel2 = null;
	private JLabel jLabelVer1 = null;
	private JLabel jLabelFechaInicial2 = null;
	private JLabel jLabelFechaInicial11 = null;
	private JPanel jPanel11 = null;
	private JTextField jTextFieldFecha11 = null;
	private utilitarios util1 = null;
	private JTextField jTextFieldFecha21 = null;
	private JTextField jTextFieldNumero = null;
	int numRecibo = 0;
	int cliente = 0;
	int rucCliente = 0;
	private JTable jTable = null;
	modeloListaRecibo modelo = new modeloListaRecibo(); // @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public listaRecibosPanel(JDesktopPane JDesktopPane1) {
		super();
		initialize();
		JDesktopPanePrin = JDesktopPane1;
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		jLabelVer = new JLabel();
		jLabelVer.setText("Ver Solo :");
		jLabelVer.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelVer.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setSize(691, 553);
		this.setLayout(null);
		this.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.add(getJPanel(), null);
		this.add(getJButton(), null);
		this.add(getJButton1(), null);
		this.add(getJPanel1(), null);
		this.add(getJButtonCalendario(), null);
		this.add(getJButtonCalendario2(), null);
		this.add(getJScrollPane(), null);
		this.add(getJPanel2(), null);
		this.add(getJPanel11(), null);

	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelFechaInicial1 = new JLabel();
			jLabelFechaInicial1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicial1.setText("Fecha Final  :");
			jLabelFechaInicial1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaInicial = new JLabel();
			jLabelFechaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicial.setText("Fecha inicio  :");
			jLabelFechaInicial.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(3);
			gridLayout.setVgap(20);
			gridLayout.setHgap(20);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.setBounds(new Rectangle(21, 12, 155, 117));
			jPanel.add(jLabelVer, null);
			jPanel.add(jLabelFechaInicial, null);
			jPanel.add(jLabelFechaInicial1, null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(315, 148, 151, 26));
			jButton.setText("Mostrar recientes");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					cargar20Registros(jComboBox.getSelectedItem().toString());
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(202, 148, 100, 26));
			jButton1.setText("Aceptar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					mostrarRegistrosFiltro();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jTextFieldFecha1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha1() {
		if (jTextFieldFecha1 == null) {
			jTextFieldFecha1 = new JTextField();
			jTextFieldFecha1.setEditable(false);
			jTextFieldFecha1.setFont(new Font("Dialog", Font.PLAIN, 14));
			jTextFieldFecha1.setForeground(new Color(51, 0, 176));
			jTextFieldFecha1.setText(util.fechaActual());
		}
		return jTextFieldFecha1;
	}

	/**
	 * This method initializes jTextFieldFecha2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha2() {
		if (jTextFieldFecha2 == null) {
			jTextFieldFecha2 = new JTextField();
			jTextFieldFecha2.setEditable(false);
			jTextFieldFecha2.setFont(new Font("Dialog", Font.PLAIN, 14));
			jTextFieldFecha2.setForeground(new Color(51, 0, 176));
			jTextFieldFecha2.setText(util.fechaActual());
		}
		return jTextFieldFecha2;
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(3);
			gridLayout1.setVgap(20);
			gridLayout1.setHgap(20);
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout1);
			jPanel1.setBounds(new Rectangle(199, 13, 108, 115));
			jPanel1.add(getJComboBox(), null);
			jPanel1.add(getJTextFieldFecha1(), null);
			jPanel1.add(getJTextFieldFecha2(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.addItem("Nota de Venta");
			jComboBox.addItem("Facturas");
		}
		return jComboBox;
	}

	/**
	 * This method initializes jButtonCalendario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setBounds(new Rectangle(317, 58, 27, 24));
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							diaAnterior = jTextFieldFecha1.getText().substring(
									8, 10);

							int x = jButtonCalendario.getWidth()
									- (int) popup.getPreferredSize().getWidth();
							int y = jButtonCalendario.getY()
									+ jButtonCalendario.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar.setCalendar(calendar);
							popup.show(jButtonCalendario, x + 240, y - 85);
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
								Date fecha = jcalendar.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								jTextFieldFecha1.setText(fechaString);
								BufferComparacion = jTextFieldFecha1.getText()
										.substring(8, 10);
								if (BufferComparacion.compareTo(diaAnterior) != 0)
									popup.setVisible(false);

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
	 * This method initializes jButtonCalendario2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario2() {
		if (jButtonCalendario2 == null) {
			jButtonCalendario2 = new JButton();
			jButtonCalendario2.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario2.setBounds(new Rectangle(317, 104, 28, 24));
			jButtonCalendario2
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							diaAnterior2 = jTextFieldFecha2.getText()
									.substring(8, 10);

							int x = jButtonCalendario2.getWidth()
									- (int) popup2.getPreferredSize()
											.getWidth();
							int y = jButtonCalendario2.getY()
									+ jButtonCalendario2.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar2.setCalendar(calendar);
							popup2.show(jButtonCalendario2, x + 240, y - 130);
						}
					});
			/*
			 * Código de Inicialización del calendario boton
			 */
			this.jcalendar2 = new JCalendar();
			jcalendar2
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {

							if ((e.getPropertyName().equals("calendar"))) {
								Date fecha = jcalendar2.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								jTextFieldFecha2.setText(fechaString);
								BufferComparacion = jTextFieldFecha2.getText()
										.substring(8, 10);
								if (BufferComparacion2.compareTo(diaAnterior2) != 0)
									popup2.setVisible(false);

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
		}
		return jButtonCalendario2;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(31, 192, 630, 337));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * SELECt ID_RECIBO, NUMERO_RECIBO, ID_OT, c.NOMBRE,FECHA,TOTAL FROM
	 * recibo_venta r,cliente c where r.CI_RUC=c.CI_RUC
	 *
	 */

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabelFechaInicial11 = new JLabel();
			jLabelFechaInicial11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicial11.setText("RUC Cliente  :");
			jLabelFechaInicial11
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaInicial2 = new JLabel();
			jLabelFechaInicial2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicial2.setText("CLIENTE :");
			jLabelFechaInicial2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelVer1 = new JLabel();
			jLabelVer1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelVer1.setText("Número Recibo :");
			jLabelVer1.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(3);
			gridLayout2.setVgap(20);
			gridLayout2.setHgap(20);
			jPanel2 = new JPanel();
			jPanel2.setLayout(gridLayout2);
			jPanel2.setBounds(new Rectangle(357, 14, 164, 113));
			jPanel2.add(jLabelVer1, null);
			jPanel2.add(jLabelFechaInicial2, null);
			jPanel2.add(jLabelFechaInicial11, null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel11
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			GridLayout gridLayout11 = new GridLayout();
			gridLayout11.setRows(3);
			gridLayout11.setVgap(20);
			gridLayout11.setHgap(20);
			jPanel11 = new JPanel();
			jPanel11.setLayout(gridLayout11);
			jPanel11.setBounds(new Rectangle(534, 14, 122, 112));
			jPanel11.add(getJTextFieldNumero(), null);
			jPanel11.add(getJTextFieldFecha11(), null);
			jPanel11.add(getJTextFieldFecha21(), null);
		}
		return jPanel11;
	}

	/**
	 * This method initializes jTextFieldFecha11
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha11() {
		if (jTextFieldFecha11 == null) {
			jTextFieldFecha11 = new JTextField();
			jTextFieldFecha11.setFont(new Font("Dialog", Font.PLAIN, 14));
			jTextFieldFecha11.setEditable(true);
			jTextFieldFecha11.setForeground(new Color(51, 0, 176));

			jTextFieldFecha11.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldFecha11.setText(util.cortarCadenaString(
							jTextFieldFecha11.getText(), 50));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.verificarTextoConEspacio(e);
				}
			});
		}
		return jTextFieldFecha11;
	}

	/**
	 * This method initializes util1
	 *
	 * @return Utilitarios.utilitarios
	 */
	private utilitarios getUtil1() {
		if (util1 == null) {
			util1 = new utilitarios();
		}
		return util1;
	}

	/**
	 * This method initializes jTextFieldFecha21
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha21() {
		if (jTextFieldFecha21 == null) {
			jTextFieldFecha21 = new JTextField();
			jTextFieldFecha21.setFont(new Font("Dialog", Font.PLAIN, 14));
			jTextFieldFecha21.setEditable(true);
			jTextFieldFecha21.setForeground(new Color(51, 0, 176));

			jTextFieldFecha21.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldFecha21.setText(util.cortarCadenaString(
							jTextFieldFecha21.getText().trim(), 13));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumeros(e);
				}
			});
		}
		return jTextFieldFecha21;
	}

	/**
	 * This method initializes jTextFieldNumero
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setFont(new Font("Dialog", Font.PLAIN, 14));
			jTextFieldNumero.setEditable(true);
			jTextFieldNumero.setForeground(new Color(51, 0, 176));

			jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumeros(e);
				}
			});
		}
		return jTextFieldNumero;
	}

	/**
	 * Muestra los 20 ultimos registros de la base de datos
	 */
	public void cargar20Registros(String TipoRecibo) {

		Object arr[][] = reciboBdd1.ultimos40DiasRegistros(conn.getConexion(),
				TipoRecibo);
		cargarTablas(arr);
	}

	// ultimos40DiasRegistros

	/**
	 * This method initializes jTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(modelo);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable.setToolTipText("Registros Encontrados!");
			jTable.setRowSelectionAllowed(true);
			RenderReciboLista render = new RenderReciboLista();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(30);//
			jTable.getColumnModel().getColumn(1).setPreferredWidth(70);//
			jTable.getColumnModel().getColumn(2).setPreferredWidth(70);//
			jTable.getColumnModel().getColumn(3).setPreferredWidth(210);//
			jTable.getColumnModel().getColumn(4).setPreferredWidth(70);//
			jTable.getColumnModel().getColumn(5).setPreferredWidth(100);//
			jTable.getColumnModel().getColumn(6).setPreferredWidth(70);//
			jTable.getColumnModel().getColumn(7).setPreferredWidth(50);//
			jTable.setRowHeight(40);

			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);

					if (modelo.getRowCount() > 0 && column > 05) {
						int idReciboTabla = Integer.parseInt(""
								+ modelo.getValueAt(row, 1));
						int tipoRecibo = 1;
						if (jComboBox.getSelectedItem().toString()
								.compareToIgnoreCase("facturas") == 0)
							tipoRecibo = 2;
						switch (column) {
						case 6:
							mostrarPantallaPago(tipoRecibo, idReciboTabla,
									Float.parseFloat((String) modelo
											.getValueAt(row, 4)));
							modelo.borraItem(row);
							break;
						case 7:
							verReporte(Integer.parseInt(""+ modelo.getValueAt(row, 0)), tipoRecibo);
							break;

						}// switch
					}// if
				}
			});
		}
		return jTable;
	}

	public void limpiarGrilla() {
		try {
			while (modelo.getRowCount() != 0) {
				for (int i = 0; i < modelo.getRowCount(); i++)
					modelo.borraItem(i);
			}
		} catch (Exception grillaVacia) {

		}

	}// limpiarGrilla

	public void mostrarRegistrosFiltro() {
		String fecha1 = null;
		String fecha2 = null;
		String TipoRecibo = "" + 1;
		if (jComboBox.getSelectedItem().toString().compareToIgnoreCase(
				"facturas") == 0)
			TipoRecibo = "" + 2;
		String order = "  order by 2 and 5";
		String Query = "SELECT " + "" + "  ID_RECIBO, NUMERO_RECIBO,"
				+ " ID_OT, c.NOMBRE,TOTAL,FECHA "
				+ " FROM recibo_venta r,cliente c "
				+ " where r.CI_RUC=c.CI_RUC " + " AND ID_TR = " + TipoRecibo
				+ " ";

		if (jTextFieldFecha2.getText().compareTo(util.fechaActual()) == 0
				&& jTextFieldFecha1.getText().compareTo(util.fechaActual()) == 0) {
			fecha1 = " DATE_SUB(CURRENT_DATE(), INTERVAL 50 DAY)";
			fecha2 = " CURRENT_DATE ";
		} else {

			fecha1 = jTextFieldFecha1.getText();
			fecha2 = jTextFieldFecha2.getText();
		}
		Query += "and  FECHA  BETWEEN '" + fecha1 + "' AND '" + fecha2 + "'";
		String numero = "0";

		if (jTextFieldNumero.getText().trim().compareTo("") != 0
				&& jTextFieldNumero.getText().trim().compareTo("0") != 0) {
			numero = jTextFieldNumero.getText().trim();
			Query += " and NUMERO_RECIBO =" + numero + "";
		}

		if (jTextFieldFecha11.getText().trim().compareTo("") != 0) {
			Query += " and c.NOMBRE like '"
					+ jTextFieldFecha11.getText().trim() + "'";
		}

		if (jTextFieldFecha21.getText().trim().compareTo("") != 0) {
			Query += " and r.CI_RUC like '"
					+ jTextFieldFecha21.getText().trim() + "'";
		}
		Query += order;

		Object arr[][] = reciboBdd1.RegistrosPorFiltro(conn.getConexion(),
				Query);
		cargarTablas(arr);
	}

	public void cargarTablas(Object arr[][]) {
		limpiarGrilla();
		if (arr.length == 0) {
			JOptionPane.showMessageDialog(null,
					"No se encontro registros con la busqueda solicitada! ",
					"Aviso! ", JOptionPane.INFORMATION_MESSAGE);

		}
		for (int i = 0; i < arr.length; i++) {
			detalleReciboModeloListaRecibo detalleReciboModeloListaRecibo1 = new detalleReciboModeloListaRecibo();
			detalleReciboModeloListaRecibo1.setIdRecibo("" + arr[i][0]);
			detalleReciboModeloListaRecibo1.setNumeroRecibo("" + arr[i][1]);
			detalleReciboModeloListaRecibo1.setId_odt("" + arr[i][2]);
			detalleReciboModeloListaRecibo1.setCliente("" + arr[i][3]);
			detalleReciboModeloListaRecibo1.setTotal("" + arr[i][4]);
			detalleReciboModeloListaRecibo1.setFecha("" + arr[i][5]);
			detalleReciboModeloListaRecibo1.setCobro(new Boolean(true));
			detalleReciboModeloListaRecibo1.setVer(new Boolean(true));
			modelo.nuevoItem(detalleReciboModeloListaRecibo1);
		}
	}

	public void verReporte(int idRecibo, int idTipoRecibo) {
		reciboLlenarForm reporteJasper = new reciboLlenarForm();
		recibo reciboDP = new recibo(0, 0, 0, 0, 0, "", "", "", 0, 0, 0);
		reciboDP.setIdTipoRecibo(idTipoRecibo);
		reciboDP.setIdRecibo(idRecibo);
		reporteJasper.recibirDatosExternos(reciboDP.getIdRecibo(), reciboDP
				.getIdTipoRecibo());
	}

	public void mostrarPantallaPago(int tipoRecibo, int idReciboTabla,
			float saldo) {
		int tipoReciboTemp = 1;
		if (jComboBox.getSelectedItem().toString().compareTo("Nota de Venta") != 0)
			tipoReciboTemp = 2;

		TipodePagoRecibo TipodePagoReciboW = new TipodePagoRecibo(
				tipoReciboTemp, idReciboTabla, saldo);

		TipodePagoReciboW.getPreferredSize();
		JDesktopPanePrin.add(TipodePagoReciboW);
		TipodePagoReciboW.setLocation(this.getX() + 40, this.getY() + 40);
		TipodePagoReciboW.setVisible(true);

	}

}// class end

