package ventanas;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import reportes.FacturaCompraYPagosLlenarForm;
import tableUtil.modeloCompGastoPagoLista;
import tableUtil.renderTablaOdt;
import Utilitarios.utilitarios;
import clases.consultaComGastosPagoLista;
import clasesBdd.conexionBdd;
import clasesBdd.pagoPorGastosBdd;

import com.toedter.calendar.JCalendar;

//public class ConsultaPagosporCompras extends JInternalFrame {

	public class ConsultaPagosporCompras extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonCalendario = null;
	private modeloCompGastoPagoLista modelo = null; // @jve:decl-index=0:

	int orden = 0;
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
	pagoPorGastosBdd pagoPorGastosmD = new pagoPorGastosBdd(); // @jve:decl-index=0:
	utilitarios util = new utilitarios();
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JTextField JTextFieldFecha1 = null;
	private JTextField JTextFieldFecha2 = null;
	private utilitarios util1 = null;
	private JButton jButtonMostrarDatos = null;
	private JTextField jTextFieldNombre = null;
	private JTextField jTextFieldNumero = null;
	private JButton jButtonCalendario2 = null;
	JDesktopPane desktopPane1;
	private JButton jButtonCalendario21 = null;
	private JPanel jPanel3 = null;
	private JLabel jLabelFecha1 = null;
	private JLabel jLabelFechaFinal = null;
	private JLabel jLabelBeneficiario = null;
	private JLabel jLabelNumeroRecibo = null;

	/**
	 * This is the default constructor
	 */

	public ConsultaPagosporCompras(String User, JDesktopPane desktopPane2) {
		// public VentanaConsultaPagos() {
		// /Administrar Ordenes de proformas por Lista
		// public OrdenesDeTrabajoPorParametros() {
		super();
		User1 = User;
		desktopPane1 = desktopPane2;

		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(764, 489);
		//this.setIconifiable(true);
	//	this.setClosable(true);
		this.setContentPane(getJContentPane());

		this.setTitle("Consulta Pagos realizados según compras");

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
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButtonMostrarDatos(), null);
			jContentPane.add(getJTextFieldFecha1(), null);
			jContentPane.add(getJTextFieldFecha2(), null);
			jContentPane.add(getJButtonCalendario2(), null);
			jContentPane.add(getJTextFieldNumero(), null);
			jContentPane.add(getJButtonCalendario(), null);

			jContentPane.add(getJTextFieldNombre(), null);
			jContentPane.add(getJPanel3(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloTabla
	 */
	private modeloCompGastoPagoLista getModelo() {
		if (modelo == null) {
			modelo = new modeloCompGastoPagoLista();
		}
		return modelo;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(21, 186, 714, 226));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextFieldNombre
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setEnabled(false);

			jTextFieldNombre.setBounds(new Rectangle(221, 87, 185, 21));
			jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNombre.setText(util.cortarCadenaString(
							jTextFieldNombre.getText(), 90));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					// util.soloLetras(e);
				}
			});
			jTextFieldNombre
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							if (jTextFieldNombre.getText().length() > 0) {

							}
						}
					});
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldNumero
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setEnabled(false);
			jTextFieldNumero.setBounds(new Rectangle(221, 116, 120, 21));
			jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNumero.setText(util.cortarCadenaString(
							jTextFieldNumero.getText().trim(), 13));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldNumero
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							if (jTextFieldNumero.getText().length() > 0) {

							}
						}
					});
		}
		return jTextFieldNumero;
	}

	/**
	 * This method initializes jTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(getModelo());
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable.setRowHeight(40);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
//ID_COM_GAS, COMPROBANTE, DESCRIPCION, TIPO_COMPROBANTE, IVA, SUBTOTAL, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL,
			//NUMERO_RETENCION, TOTAL_RETENCION, FECHA_COMPRA, ESTADO

			jTable.getColumnModel().getColumn(0).setPreferredWidth(40);// cliente
			jTable.getColumnModel().getColumn(1).setPreferredWidth(120);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(120);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(130);// total
			jTable.getColumnModel().getColumn(4).setPreferredWidth(90);// abono
			jTable.getColumnModel().getColumn(5).setPreferredWidth(110);// saldo
			jTable.getColumnModel().getColumn(6).setPreferredWidth(110);// entregar
			jTable.getColumnModel().getColumn(7).setPreferredWidth(120);// facturar
			jTable.getColumnModel().getColumn(8).setPreferredWidth(50);// ver

			renderTablaOdt render = new renderTablaOdt();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);
					rowTemp = row;
					columnTemp = column;
					if (modelo.getRowCount() > 0 && column > 05) {
						// System.out.print(column);
						switch (column) {

						case 8:
							verReporte("" + modelo.getValueAt(row, 0));
							break;

						}// switch
					}// if

				}

			});

		}
		return jTable;
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
			JTextFieldFecha1.setBounds(new Rectangle(220, 24, 77, 21));
			JTextFieldFecha1.setEditable(false);
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
	 *
	 *
	 * /** This method initializes JTextFieldFecha2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha2() {
		if (JTextFieldFecha2 == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				JTextFieldFecha2 = new JFormattedTextField(mascara);
				JTextFieldFecha2.setText(util.fechaActual());
				JTextFieldFecha2.setBounds(new Rectangle(221, 57, 77, 21));
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
	 * This method initializes jButtonMostrarDatos
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMostrarDatos() {
		if (jButtonMostrarDatos == null) {
			jButtonMostrarDatos = new JButton();
			jButtonMostrarDatos.setEnabled(false);
			jButtonMostrarDatos.setBounds(new Rectangle(221, 149, 100, 23));
			jButtonMostrarDatos.setText("Mostrar");
			jButtonMostrarDatos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ejecutarOpcionsolicitada();

						}
					});
		}
		return jButtonMostrarDatos;
	}

	private void actualizar() {

	}

	private void limpiar() {
		try {
			int cont = 0;
			while (modelo.getRowCount() != 0)
				modelo.borraItem(cont);
			cont++;
		} catch (Exception nomasFilas) {
		}
	}

	/**
	 * This method initializes jButtonCalendario2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario2() {
		if (jButtonCalendario2 == null) {
			jButtonCalendario2 = new JButton();
			jButtonCalendario2.setText("");
			jButtonCalendario2.setBounds(new Rectangle(308, 58, 27, 21));
			jButtonCalendario2.setToolTipText("Seleecione la fecha final hasta donde se mostrarán las compras realizadas");
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
							popup2.show(jButtonCalendario2, x + 210, y - 45);

						}
					});
		}
		return jButtonCalendario2;
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
					&& fecha1.compareTo(fecha2) != 0) {
				jButtonMostrarDatos.setEnabled(true);
				jTextFieldNombre.setEnabled(true);
				jTextFieldNumero.setEnabled(true);
			} else {
				jButtonMostrarDatos.setEnabled(false);
				jTextFieldNombre.setEnabled(false);
				jTextFieldNumero.setEnabled(false);
				jTextFieldNombre.setText("");
				jTextFieldNumero.setText("");

			}

		} catch (Exception vacio) {
		}

	}

	/**
	 * busca la mejor opción a ejecutar según los datos ingresados
	 */
	public void ejecutarOpcionsolicitada() {
		if (jTextFieldNombre.getText().trim().length() > 3
				&& jTextFieldNumero.getText().trim().length() == 0) {
			if (orden == 0) {
				cargarDatosNombre();
				orden = 1;
			}

		}
		if (jTextFieldNombre.getText().trim().length() < 3
				&& jTextFieldNumero.getText().trim().length() != 0) {
			if (orden == 0) {
				cargarDatosNumero();
				orden = 1;
			}

		}
		if (jTextFieldNombre.getText().trim().length() < 3
				&& jTextFieldNumero.getText().trim().length() == 0) {
			if (orden == 0) {
				cargarDatosFecha();
				orden = 1;
			}

		}

		orden = 0;
	}

	/**
	 * muestra este un mensaje cuando no hay items para mostrar
	 */
	public void noHayItems() {
		JOptionPane.showMessageDialog(null,
				"No se encontraron registros con esta búsqueda! ", "Aviso! ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 *
	 * if(items.length==0) noHayItems();
	 */

	private void cargarDatos(Object[][] items) {
		for (int i = 0; i < items.length; i++) {
			if (items[i][0] != null) {

				consultaComGastosPagoLista itemClase = new consultaComGastosPagoLista(""
						+ items[i][0], "" + items[i][1], "" + items[i][2], ""
						+ items[i][3], "" + items[i][4], "" + items[i][5], ""
						+ items[i][6], "" + items[i][7],true);
				itemClase.setVer(true);
				modelo.nuevoItem(itemClase);

			}
		}
	}

	private void verReporte(String numero) {
		FacturaCompraYPagosLlenarForm reporteJasper = new FacturaCompraYPagosLlenarForm();
		reporteJasper.recibirDatosExternos(numero);

	}

	/**
	 * cargar Datos por Fecha
	 */
	private void cargarDatosFecha() {
		limpiar();

		Object items[][] = pagoPorGastosmD.seleccionarComprasPorFecha(conn
				.getConexion(), JTextFieldFecha1.getText().trim(),
				JTextFieldFecha2.getText().trim()); // @jve:decl-index=0:
		if (items.length == 0)
			noHayItems();
		else
			cargarDatos(items);
	}

	/**
	 * cargar ODT por nombre
	 */
	private void cargarDatosNombre() {
		limpiar();
		Object items[][] = pagoPorGastosmD
				.seleccionarComprasPorNombre(conn.getConexion(),
						JTextFieldFecha1.getText().trim(), JTextFieldFecha2
								.getText().trim(), jTextFieldNombre.getText()
								.trim()); // @jve:decl-index=0:
		if (items.length == 0)
			noHayItems();
		else
			cargarDatos(items);

	}// proformas nombre

	/**
	 * cargar Datos por Número
	 */
	private void cargarDatosNumero() {
		limpiar();
		Object items[][] = pagoPorGastosmD
				.seleccionarOdtEncabezadosFechasNumero(conn.getConexion(),
						JTextFieldFecha1.getText().trim(), JTextFieldFecha2
								.getText().trim(), jTextFieldNumero.getText()
								.trim()); // @jve:decl-index=0:
		if (items.length == 0)
			noHayItems();
		else
			cargarDatos(items);

	}

	/**
	 * cargar Datos por ruc
	 */
	private void cargarDatosRuc() {
		limpiar();
		/*
		 * Object items[][] = ordenTrabajoMd.seleccionarOdtEncabezadosFechasRuc(
		 * conn.getConexion(), JTextFieldFecha1.getText().trim(),
		 * JTextFieldFecha2.getText().trim(), jTextFieldRuc.getText() .trim()); //
		 * @jve:decl-index=0: if (items.length == 0) noHayItems(); else
		 * cargarDatos(items);
		 */
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
			jButtonCalendario.setBounds(new Rectangle(308, 24, 27, 21));
			jButtonCalendario.setToolTipText("Seleccione la fecha desde la que quiere ver las compras");
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
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
							popup.show(jButtonCalendario, x + 210, y - 12);
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
	 * This method initializes jPanel3
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jLabelNumeroRecibo = new JLabel();
			jLabelNumeroRecibo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNumeroRecibo.setText("Número de Comprobante :");
			jLabelNumeroRecibo.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBeneficiario = new JLabel();
			jLabelBeneficiario.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBeneficiario.setText("Beneficiario :");
			jLabelBeneficiario.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaFinal = new JLabel();
			jLabelFechaFinal.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaFinal.setText("Fecha Inicial  :");
			jLabelFechaFinal.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFecha1 = new JLabel();
			jLabelFecha1.setText("Fecha Final :");
			jLabelFecha1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFecha1.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setHgap(4);
			gridLayout.setVgap(8);
			gridLayout.setColumns(1);
			jPanel3 = new JPanel();
			jPanel3.setLayout(gridLayout);
			jPanel3.setBounds(new Rectangle(31, 25, 179, 112));
			jPanel3.add(jLabelFechaFinal, null);
			jPanel3.add(jLabelFecha1, null);
			jPanel3.add(jLabelBeneficiario, null);
			jPanel3.add(jLabelNumeroRecibo, null);
		}
		return jPanel3;
	}

} // @jve:decl-index=0:visual-constraint="10,10"