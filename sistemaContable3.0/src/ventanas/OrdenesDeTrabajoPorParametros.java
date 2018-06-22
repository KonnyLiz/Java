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

import reportes.OdtLlenarForm;
import tableUtil.detalleOdtLista;
import tableUtil.modeloOdtLista;
import tableUtil.renderTablaOdt;
import Utilitarios.utilitarios;
import clases.ordenDeTrabajo;
import clasesBdd.conexionBdd;
import clasesBdd.ordenTrabajoBdd;
import clasesBdd.proformaBdd;

import com.toedter.calendar.JCalendar;

public class OrdenesDeTrabajoPorParametros extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField = null;
	private JLabel jLabelNombre = null;
	private JButton jButton1 = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JLabel jLabelNombre1 = null;
	private JTextField jTextFieldFecha1 = null;
	private JButton jButton11 = null;
	private JLabel jLabel1 = null;
	private JTextField jTextFieldFecha2 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabelNombre2 = null;
	private JTextField jTextField1 = null;
	private JButton jButtonNumero = null;
	private JButton jButtonCalendario = null;
	private modeloOdtLista modelo = null; // @jve:decl-index=0:
	ordenTrabajoBdd ordenTrabajoMd = new ordenTrabajoBdd();
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
	proformaBdd proformaMd = new proformaBdd(); // @jve:decl-index=0:
	utilitarios util = new utilitarios();
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JTextField JTextFieldFecha1 = null;
	private JTextField JTextFieldFecha2 = null;
	private MaskFormatter mascara1 = null;
	private utilitarios util1 = null;
	private JButton jButtonMostrarDatos = null;
	private JButton jButtonBorrar = null;
	private JLabel jLabelNombre3 = null;
	private JLabel jLabelFechaInicial = null;
	private JLabel jLabelFechaFinal = null;
	private JTextField jTextFieldNombre = null;
	private JLabel jLabelNumero = null;
	private JTextField jTextFieldNumero = null;
	private JButton jButtonCalendario2 = null;
	private JLabel jLabelRuc = null;
	private JTextField jTextFieldRuc = null;
	private JPanel jPanel3 = null;
	JDesktopPane desktopPane1;

	/**
	 * This is the default constructor
	 */
	public OrdenesDeTrabajoPorParametros(String User, JDesktopPane desktopPane2) {
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

		jLabelRuc = new JLabel();
		jLabelRuc.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelRuc.setText("Ruc :");
		jLabelRuc.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelNumero = new JLabel();
		jLabelNumero.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelNumero.setText(" Número :");
		jLabelNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelFechaFinal = new JLabel();
		jLabelFechaFinal.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelFechaFinal.setText("Fecha Final :");
		jLabelFechaFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelFechaInicial = new JLabel();
		jLabelFechaInicial.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelFechaInicial.setText("Fecha Inicial :");
		jLabelFechaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelNombre3 = new JLabel();
		jLabelNombre3.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabelNombre3.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabelNombre3.setText("Ingrese Nombre :");

		this.setSize(701, 390);
		this.setLayout(null);
		this.add(getJScrollPane(), null);
		this.add(getJTextFieldFecha1(), null);
		this.add(getJTextFieldFecha2(), null);
		this.add(getJButtonMostrarDatos(), null);
		this.add(getJButtonBorrar(), null);
		this.add(getJButtonCalendario(), null);
		this.add(getJTextFieldNombre(), null);
		this.add(getJTextFieldNumero(), null);

		this.add(jButtonCalendario, null);
		this.add(getJButtonCalendario2(), null);
		this.add(getJTextFieldRuc(), null);
		this.add(getJPanel3(), null);
	}

	/**
	 * This method initializes modelo
	 * 
	 * @return tableUtil.modeloTabla
	 */
	private modeloOdtLista getModelo() {
		if (modelo == null) {
			modelo = new modeloOdtLista();
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
			jScrollPane.setBounds(new Rectangle(31, 174, 637, 183));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jButtonBorrar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setBounds(new Rectangle(300, 360, 100, 23));
			jButtonBorrar.setText("Limpiar");
			jButtonBorrar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							limpiar();
						}
					});
		}
		return jButtonBorrar;
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
			jButtonCalendario.setBounds(new Rectangle(242, 17, 27, 21));
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
	 * This method initializes jTextFieldNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(153, 78, 185, 21));
			jTextFieldNombre.setEnabled(false);

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
								jTextFieldRuc.setText("");
								jTextFieldNumero.setText("");
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
			jTextFieldNumero.setBounds(new Rectangle(153, 137, 63, 21));
			jTextFieldNumero.setEnabled(true);
			jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNumero.setText(util.cortarCadenaString(
							jTextFieldNumero.getText().trim(), 8));
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
								jTextFieldNombre.setText("");
								jTextFieldRuc.setText("");
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
			// jTable.setRowSelectionAllowed(false);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);

			jTable.getColumnModel().getColumn(0).setPreferredWidth(160);// cliente
			jTable.getColumnModel().getColumn(1).setPreferredWidth(90);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(90);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(90);// total
			jTable.getColumnModel().getColumn(4).setPreferredWidth(90);// abono
			jTable.getColumnModel().getColumn(5).setPreferredWidth(90);// saldo
			jTable.getColumnModel().getColumn(6).setPreferredWidth(160);// entregar
			jTable.getColumnModel().getColumn(7).setPreferredWidth(70);// facturar
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
						case 6:
							ordenTrabajoMd.modificarEntregado(conn
									.getConexion(), ""
									+ modelo.getValueAt(row, 9));

							break;

						case 7:
							ordenDeTrabajo ordenDeTrabajoDp = new ordenDeTrabajo(
									0, 0, 0, "", "", 0, "", "", "", 0, 0, 0, "");
							int idTabla = Integer.parseInt(""
									+ modelo.getValueAt(row, 9));
							ordenDeTrabajoDp = ordenTrabajoMd
									.seleccionarOdtEncabezado(conn
											.getConexion(), idTabla);

							reciboVentana facturaVentanaW = new reciboVentana(
									""
											+ ordenDeTrabajoDp
													.getNumeroOrdenTrabajo(),
									true, null, false, User1, desktopPane1,
									Float.parseFloat(""
											+ modelo.getValueAt(row, 3)));
							facturaVentanaW.getPreferredSize();
							desktopPane1.add(facturaVentanaW);
							facturaVentanaW.setVisible(true);
							modelo.borraItem(row);

							break;
						case 8:
							verReporte("" + modelo.getValueAt(row, 9));
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
			JTextFieldFecha1.setEditable(false);
			JTextFieldFecha1.setBounds(new Rectangle(153, 18, 77, 21));
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
				JTextFieldFecha2.setBounds(new Rectangle(153, 49, 77, 21));
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
			jButtonMostrarDatos.setBounds(new Rectangle(310, 138, 100, 23));
			jButtonMostrarDatos.setEnabled(false);
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
			jButtonCalendario2.setBounds(new Rectangle(242, 49, 27, 21));
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
			} else {
				jButtonMostrarDatos.setEnabled(false);
				jTextFieldNombre.setEnabled(false);
				jTextFieldNombre.setText("");

			}

		} catch (Exception vacio) {
		}

	}

	/**
	 * busca la mejor opción a ejecutar según los datos ingresados
	 */
	public void ejecutarOpcionsolicitada() {
		if (jTextFieldNombre.getText().trim().length() > 3
				&& jTextFieldNumero.getText().trim().length() == 0
				&& jTextFieldRuc.getText().trim().length() == 0) {
			if (orden == 0) {
				cargarDatosNombre();
				orden = 1;
			}

		}
		if (jTextFieldNombre.getText().trim().length() < 3
				&& jTextFieldNumero.getText().trim().length() != 0
				&& jTextFieldRuc.getText().trim().length() == 0) {
			if (orden == 0) {
				cargarDatosNumero();
				orden = 1;
			}

		}
		if (jTextFieldNombre.getText().trim().length() < 3
				&& jTextFieldRuc.getText().trim().length() == 0) {
			if (orden == 0) {
				cargarDatosFecha();
				orden = 1;
			}

		}
		if (jTextFieldNombre.getText().trim().length() == 0
				&& jTextFieldRuc.getText().trim().length() > 5) {
			if (orden == 0) {
				cargarDatosRuc();
				orden = 1;
			}

		}

		orden = 0;
	}

	/**
	 * This method initializes jTextFieldRuc
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRuc() {
		if (jTextFieldRuc == null) {
			jTextFieldRuc = new JTextField();
			jTextFieldRuc.setBounds(new Rectangle(153, 108, 110, 21));
			jTextFieldRuc.setEnabled(true);
			jTextFieldRuc.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldRuc.setText(util.cortarCadenaString(jTextFieldRuc
							.getText().trim(), 13));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldRuc
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							if (jTextFieldRuc.getText().length() > 0) {
								jTextFieldNombre.setText("");
								jTextFieldNumero.setText("");
							}
						}
					});
		}
		return jTextFieldRuc;
	}

	/**
	 * This method initializes jPanel3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setHgap(1);
			gridLayout.setVgap(9);
			gridLayout.setColumns(1);
			jPanel3 = new JPanel();
			jPanel3.setLayout(gridLayout);
			jPanel3.setBounds(new Rectangle(31, 17, 108, 143));
			jPanel3.add(jLabelFechaInicial, null);
			jPanel3.add(jLabelFechaFinal, null);
			jPanel3.add(jLabelNombre3, null);
			jPanel3.add(jLabelRuc, null);
			jPanel3.add(jLabelNumero, null);
		}
		return jPanel3;
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

				detalleOdtLista itemClase = new detalleOdtLista(""
						+ items[i][0], "" + items[i][1], "" + items[i][2],
						Float.parseFloat("" + items[i][3]), Float.parseFloat(""
								+ items[i][4]), Float.parseFloat(""
								+ items[i][5]), new Boolean(true), new Boolean(
								true), new Boolean(true), "" + items[i][6]);

				modelo.nuevoItem(itemClase);

			}
		}
	}

	private void verReporte(String numero) {
		OdtLlenarForm reporteJasper = new OdtLlenarForm();
		int numero2 = Integer.parseInt(numero);
		reporteJasper.recibirDatosExternos(numero2);

	}

	/**
	 * cargar Datos por Fecha
	 */
	private void cargarDatosFecha() {
		limpiar();
		Object items[][] = ordenTrabajoMd.seleccionarOdtEncabezadosFechas(conn
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
		Object items[][] = ordenTrabajoMd
				.seleccionarOdtEncabezadosFechasNombre(conn.getConexion(),
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
		Object items[][] = ordenTrabajoMd
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
		Object items[][] = ordenTrabajoMd.seleccionarOdtEncabezadosFechasRuc(
				conn.getConexion(), JTextFieldFecha1.getText().trim(),
				JTextFieldFecha2.getText().trim(), jTextFieldRuc.getText()
						.trim()); // @jve:decl-index=0:
		if (items.length == 0)
			noHayItems();
		else
			cargarDatos(items);

	}

}