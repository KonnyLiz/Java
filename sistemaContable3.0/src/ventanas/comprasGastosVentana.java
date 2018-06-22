package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import Utilitarios.utilitarios;
import clases.comprasGastos;
import clasesBdd.comprasGastosBdd;
import clasesBdd.conexionBdd;

import com.toedter.calendar.JCalendar;

public class comprasGastosVentana extends JInternalFrame {
//public class comprasGastosVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JLabel Administracióndeclientes = null;
	private JTextField jTextFieldId = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private Utilitarios.utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private comprasGastos comprasGDp = new comprasGastos(0, 0, "", "", 0, 0, 0,
			"", 0, 0, ""); // @jve:decl-index=0:
	private comprasGastosBdd comprasGMd = new comprasGastosBdd(); // @jve:decl-index=0:
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior; // @jve:decl-index=0:
	private JTextField jTextFieldINumeroComprobante = null;
	private JPanel jPanel = null;
	private JLabel jLabelNumeroRecibo = null;
	private JPanel jPanelLabel2 = null;
	private JLabel jLabelTipoRecibo = null;
	private Choice choiceTipoREcibo = null;
	private JLabel jLabelDescripcion1 = null;
	private JPanel jPanelLabel21 = null;
	private JLabel jLabelSubtotal = null;
	private JLabel jLabelIva = null;
	private JLabel jLabelTotal = null;
	private JTextField jTextFieldFecha = null;
	private JLabel jLabelFEcha = null;
	private JButton jButtonCalendario = null;
	private JTextField jTextFieldISubtotal = null;
	private JTextField jTextFieldTotal = null;
	private JTextField jTextIva = null;
	private JPanel jPanel1 = null;
	private JPanel jPanelLabel211 = null;
	private JLabel jLabelRetencion = null;
	private JLabel jLabelTotalRetencion = null;
	private JTextField jTextFieldINumeroRetencion = null;
	private JTextField jTextFieldITotalRetencion = null;
	private JLabel jLabelDescripcionAdicional = null;
	private JTextArea jTextAreaDescripcionAdicional = null;
	private JLabel jLabelIdentificadorDeRecibo = null;
	private JScrollPane jScrollPane = null;
	/**
	 * para uso del calendario
	 */

	int banderaFecha = 0;
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup;
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	protected boolean isInitialized;
	private JLabel jLabelBiuscar = null;
	private JTextField jTextFieldIdBusqueda = null;
	comprasGastosBdd comprasGastosMd = new comprasGastosBdd(); // @jve:decl-index=0:
	private JTextField jTextAreaDescripcionProducto = null;
	private JButton jButtonBuscarProveedor = null;
	/**
	 * Cargar Lista de proveedores
	 */
	ListaProveedoresVentanaConsulta lista = new ListaProveedoresVentanaConsulta();
	boolean ventanaClienteAbierta = false;
	/**
	 * This is the default constructor
	 */
	public comprasGastosVentana() {
		super();
		initialize();
		lista.setAlwaysOnTop(true);
		lista.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				jTextAreaDescripcionProducto.setText(lista.devolverNombre());
				ventanaClienteAbierta = false;
				lista.cerrar();
				jTextAreaDescripcionProducto.selectAll();
				jTextAreaDescripcionProducto.requestFocus();
				jTextAreaDescripcionProducto.transferFocus();

			}
		});
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		lista.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				lista.setAlwaysOnTop(true);
				lista.cerrar();
			}
		});
		lista.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(542, 648);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Compras y Gastos");
		this.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				lista.cerrar();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelBiuscar = new JLabel();
			jLabelBiuscar.setBounds(new Rectangle(316, 48, 96, 31));
			jLabelBiuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar.setText("Buscar Recibo :");
			jLabelBiuscar.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdentificadorDeRecibo = new JLabel();
			jLabelIdentificadorDeRecibo
					.setBounds(new Rectangle(10, 48, 149, 28));
			jLabelIdentificadorDeRecibo.setText("Identificador del Recibo :");
			jLabelIdentificadorDeRecibo
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelIdentificadorDeRecibo
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcionAdicional = new JLabel();
			jLabelDescripcionAdicional
					.setBounds(new Rectangle(17, 473, 166, 30));
			jLabelDescripcionAdicional.setText("Detalle del Recibo :");
			jLabelDescripcionAdicional
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcionAdicional
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFEcha = new JLabel();
			jLabelFEcha.setBounds(new Rectangle(275, 112, 91, 25));
			jLabelFEcha.setText("Fecha Compra :");
			jLabelFEcha.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFEcha.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNumeroRecibo = new JLabel();
			jLabelNumeroRecibo.setText("Número De Recibo  :");
			jLabelNumeroRecibo.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelNumeroRecibo.setHorizontalAlignment(SwingConstants.RIGHT);
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(119, 15, 305, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes
					.setText("Administración Gastos y Facturas de Compra");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJTextFieldId(), null);

			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanelLabel2(), null);
			jContentPane.add(getChoiceTipoREcibo(), null);
			jContentPane.add(getJTextFieldINumeroComprobante(), null);
			jContentPane.add(getJPanelLabel21(), null);
			jContentPane.add(getJTextFieldFecha(), null);
			jContentPane.add(jLabelFEcha, null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(getJTextFieldISubtotal(), null);
			jContentPane.add(getJTextFieldTotal(), null);
			jContentPane.add(getJTextIva(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJPanelLabel211(), null);
			jContentPane.add(getJTextFieldINumeroRetencion(), null);
			jContentPane.add(getJTextFieldITotalRetencion(), null);
			jContentPane.add(jLabelDescripcionAdicional, null);
			jContentPane.add(jLabelIdentificadorDeRecibo, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabelBiuscar, null);
			jContentPane.add(getJTextFieldIdBusqueda(), null);
			jContentPane.add(getJTextAreaDescripcionProducto(), null);
			jContentPane.add(getJButtonBuscarProveedor(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelBotones
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelBotones() {
		if (jPanelBotones == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			gridLayout2.setHgap(19);
			gridLayout2.setVgap(12);
			gridLayout2.setColumns(4);
			jPanelBotones = new JPanel();
			jPanelBotones.setLayout(gridLayout2);
			jPanelBotones.setBounds(new Rectangle(55, 567, 425, 28));
			jPanelBotones.add(getJButtonIngresar(), null);
			jPanelBotones.add(getJButtonModificar(), null);
			jPanelBotones.add(getJButtonEliminar(), null);
			jPanelBotones.add(getJButtonLimpiar(), null);
		}
		return jPanelBotones;
	}

	/**
	 * This method initializes jButtonIngresar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonIngresar() {
		if (jButtonIngresar == null) {
			jButtonIngresar = new JButton();
			jButtonIngresar.setEnabled(false);
			jButtonIngresar.setText("Ingresar");
			jButtonIngresar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							insertar();
						}
					});
		}
		return jButtonIngresar;
	}

	/**
	 * This method initializes jButtonModificar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setEnabled(false);
			jButtonModificar.setText("Modificar");
			jButtonModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificar();
						}
					});
		}
		return jButtonModificar;
	}

	/**
	 * This method initializes jButtonEliminar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setEnabled(false);
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							eliminar();
						}
					});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonLimpiar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonLimpiar() {
		if (jButtonLimpiar == null) {
			jButtonLimpiar = new JButton();
			jButtonLimpiar.setText("Limpiar");
			jButtonLimpiar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							limpiar();
						}
					});
		}
		return jButtonLimpiar;
	}

	/**
	 * This method initializes jTextFieldId
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setEnabled(true);
			jTextFieldId.setToolTipText("Identificador De Registro en Tabla");
			jTextFieldId.setBounds(new Rectangle(168, 47, 99, 31));
			jTextFieldId.setEditable(false);
			jTextFieldId.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldId.setForeground(new Color(254, 0, 0));
			String secuenciaSiguiente = ""
					+ comprasGastosMd.seleccionarMaxAutoIncrementTabla(con
							.getConexion());
			jTextFieldId.setText("" + secuenciaSiguiente);
		}
		return jTextFieldId;
	}

	private void buscarItem() {

		comprasGDp = comprasGMd.buscarInfoDeUnRegistro(con.getConexion(),
				comprasGDp);
		if (comprasGDp.getIdCompraGasto() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			jTextFieldINumeroComprobante.setEnabled(true);
			jButtonIngresar.setEnabled(true);
			jButtonModificar.setEnabled(false);
			jButtonEliminar.setEnabled(false);
			opcionModulo = 1;
		} else {
			/**
			 * Activa Modificación
			 */
			jTextFieldIdBusqueda.setEnabled(false);
			opcionModulo = 2;
			jTextFieldIdBusqueda.setEnabled(false);
			jTextFieldId.setText("" + comprasGDp.getIdCompraGasto());
			jTextFieldFecha.setText(comprasGDp.getFechaCompra());
			jTextFieldINumeroComprobante.setText(""
					+ comprasGDp.getNumeroComprobante());
			choiceTipoREcibo.select("" + comprasGDp.getTipoComprobante());
			jTextFieldISubtotal.setText("" + comprasGDp.getSubtotal());
			jTextIva.setText("" + comprasGDp.getIva());
			jTextFieldTotal.setText("" + comprasGDp.getTotalPagado());
			jTextFieldINumeroRetencion.setText(""
					+ comprasGDp.getNumeroRetencion());
			jTextFieldITotalRetencion.setText(""
					+ comprasGDp.getTotalRetencion());
			jTextAreaDescripcionProducto.setText(comprasGDp.getDescripcion());
			jTextAreaDescripcionAdicional.setText(comprasGDp
					.getDescripcionAdicional());

			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
		}// end else

	}

	private void limpiar() {

		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		String secuenciaSiguiente = ""
				+ comprasGastosMd.seleccionarMaxAutoIncrementTabla(con
						.getConexion());
		jTextFieldId.setText("" + secuenciaSiguiente);
		jTextFieldFecha.setText(util.fechaActual());
		jTextFieldINumeroComprobante.setEnabled(true);
		jTextFieldINumeroComprobante.setText("0");
		jTextFieldIdBusqueda.setEnabled(true);
		jTextFieldIdBusqueda.setText("0");
		jTextFieldISubtotal.setText("0");
		jTextIva.setText("0");
		jTextFieldTotal.setText("0");
		jTextFieldINumeroRetencion.setText("0");
		jTextFieldITotalRetencion.setText("0");
		jTextAreaDescripcionAdicional.setText("");
		jTextAreaDescripcionProducto.setText("");
		comprasGDp = new comprasGastos(0, 0, "", "", 0, 0, 0, "", 0, 0, "");

		opcionModulo = 0;

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {
		validar();
		if (opcionModulo == 1) {
			mostrar();
			comprasGMd.insertar(con.getConexion(), comprasGDp);

		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();

	}// insertar

	/**
	 * Funcion de Modificación
	 */
	private void modificar() {
		validar();
		if (opcionModulo == 2) {
			comprasGMd.modificar(con.getConexion(), comprasGDp);

		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// modificar

	/**
	 * Función de Eliminación
	 */
	private void eliminar() {
		validar();
		if (opcionModulo == 2) {
			comprasGMd.eliminar(con.getConexion(), comprasGDp);

		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// eliminar

	private void bloquear() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
	}

	/**
	 * This method initializes jTextFieldINumeroComprobante
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldINumeroComprobante() {
		if (jTextFieldINumeroComprobante == null) {
			jTextFieldINumeroComprobante = new JTextField();
			jTextFieldINumeroComprobante.setEnabled(true);
			jTextFieldINumeroComprobante.setText("0");
			jTextFieldINumeroComprobante.setBounds(new Rectangle(151, 109, 91,
					26));
			jTextFieldINumeroComprobante.setFont(new Font("Dialog", Font.PLAIN,
					20));
			jTextFieldINumeroComprobante.setForeground(Color.red);
			jTextFieldINumeroComprobante.setToolTipText("Número del Recibo");
			jTextFieldINumeroComprobante
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);

						}
					});
			jTextFieldINumeroComprobante
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							jTextFieldIdBusqueda.setEnabled(false);
							comprasGDp.setNumeroComprobante(Integer
									.parseInt(jTextFieldINumeroComprobante
											.getText().trim()));
							buscarItem();

						}
					});
		}
		return jTextFieldINumeroComprobante;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jPanel = new JPanel();
			jPanel.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			jPanel.setBounds(new Rectangle(2, 86, 534, 4));
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanelLabel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelLabel2() {
		if (jPanelLabel2 == null) {
			jLabelDescripcion1 = new JLabel();
			jLabelDescripcion1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion1.setText("Proveedor :");
			jLabelTipoRecibo = new JLabel();
			jLabelTipoRecibo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipoRecibo.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTipoRecibo.setText("Tipo de Recibo :");
			GridLayout gridLayout121 = new GridLayout();
			gridLayout121.setRows(4);
			gridLayout121.setVgap(16);
			gridLayout121.setHgap(3);
			gridLayout121.setColumns(1);
			jPanelLabel2 = new JPanel();
			jPanelLabel2.setLayout(gridLayout121);
			jPanelLabel2.setBounds(new Rectangle(9, 107, 134, 164));
			jPanelLabel2.add(jLabelNumeroRecibo, null);
			jPanelLabel2.add(jLabelTipoRecibo, null);
			jPanelLabel2.add(jLabelDescripcion1, null);
		}
		return jPanelLabel2;
	}

	/**
	 * This method initializes choiceTipoREcibo
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceTipoREcibo() {
		if (choiceTipoREcibo == null) {
			choiceTipoREcibo = new Choice();
			choiceTipoREcibo.setBounds(new Rectangle(150, 158, 110, 38));
			choiceTipoREcibo.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					bloquearItemNoRequerido();
				}
			});
			choiceTipoREcibo
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							bloquearItemNoRequerido();
						}
					});
			choiceTipoREcibo.add("FACTURA");
			choiceTipoREcibo.add("NOTA DE VENTA");
		}
		return choiceTipoREcibo;
	}

	/**
	 * This method initializes jPanelLabel21
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelLabel21() {
		if (jPanelLabel21 == null) {
			jLabelTotal = new JLabel();
			jLabelTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTotal.setText("Total :");
			jLabelIva = new JLabel();
			jLabelIva.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIva.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelIva.setText("Iva :");
			jLabelSubtotal = new JLabel();
			jLabelSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelSubtotal.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelSubtotal.setText("Subtotal :");
			GridLayout gridLayout1211 = new GridLayout();
			gridLayout1211.setRows(3);
			gridLayout1211.setVgap(16);
			gridLayout1211.setHgap(3);
			gridLayout1211.setColumns(1);
			jPanelLabel21 = new JPanel();
			jPanelLabel21.setLayout(gridLayout1211);
			jPanelLabel21.setBounds(new Rectangle(18, 324, 68, 121));
			jPanelLabel21.add(jLabelSubtotal, null);
			jPanelLabel21.add(jLabelIva, null);
			jPanelLabel21.add(jLabelTotal, null);
		}
		return jPanelLabel21;
	}

	/**
	 * This method initializes jTextFieldFecha
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha() {
		if (jTextFieldFecha == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				jTextFieldFecha = new JFormattedTextField(mascara);
				jTextFieldFecha.setBounds(new Rectangle(374, 112, 73, 26));
				jTextFieldFecha.setText(util.fechaActual());
				jTextFieldFecha.setToolTipText("Ingrese la fecha");
				jTextFieldFecha.setEditable(false);
				jTextFieldFecha.setEnabled(true);
				jTextFieldFecha
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {
								BufferComparacion = jTextFieldFecha.getText();
								BufferComparacion = BufferComparacion
										.toString();
								// clienteDp.setClienteDesde(jTextFieldFecha.getText());
								if (!util.isDate(BufferComparacion)) {
									banderaFecha = 1;
								} else {
									banderaFecha = 0;
								}
								try {
									BufferComparacion = BufferComparacion
											.substring(8, 10).trim();
								} catch (Exception e1) {
									BufferComparacion = "01";
									/** en caso de ser null el textfield */
								}

								if (diaAnterior
										.compareToIgnoreCase(BufferComparacion) != 0) {

									popup.setVisible(false);

								} else {
									popup.setVisible(true);
								}

								if (jTextFieldFecha.getText() != "") {

									// jTextFieldDireccion.setEnabled(true);

								}

							}
						});
				jTextFieldFecha
						.setToolTipText("Escoja la fecha de inicio con el botón de la derecha");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return jTextFieldFecha;
	}

	/**
	 * This method initializes jButtonCalendario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
		// jButtonCalendario.setBounds(new Rectangle(452, 112, 55, 27));
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
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
								if (jTextFieldFecha.getText().compareTo("") == 0) {

									jTextFieldFecha.setText(fechaString);

								} else {
									jTextFieldFecha.setText(fechaString);
									try {
										diaAnterior = jTextFieldFecha.getText()
												.substring(8, 10);// se
										// requiere
										// para
										// cerrar el
										// popup
									} catch (Exception e2) {
										diaAnterior = "01";
									}
								}

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
			jButtonCalendario.setBounds(new Rectangle(452, 110, 27, 28));
			jButtonCalendario.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario.setEnabled(true);
			jButtonCalendario.setText("");
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
							popup.show(jButtonCalendario, x + 170, y - 140);
						}
					});
		}
		return jButtonCalendario;

	}

	/**
	 * This method initializes jTextFieldISubtotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldISubtotal() {
		if (jTextFieldISubtotal == null) {
			jTextFieldISubtotal = new JTextField();
			jTextFieldISubtotal.setBounds(new Rectangle(91, 327, 91, 26));
			jTextFieldISubtotal.setToolTipText("Ingrese el Subtotal ");
			jTextFieldISubtotal.setText("0");
			jTextFieldISubtotal.setEnabled(true);
			jTextFieldISubtotal.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (jTextFieldISubtotal.getText().trim().compareTo("") == 0)
						jTextFieldISubtotal.setText("0");
					jTextFieldISubtotal.setText(util
							.cortarCadenaFloat(jTextFieldISubtotal.getText()
									.trim()));
					float suma = 0;
					suma = Float.parseFloat(jTextFieldISubtotal.getText()
							.trim())
							+ Float.parseFloat(jTextIva.getText().trim());

					jTextFieldTotal.setText("" + suma);
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
		}
		return jTextFieldISubtotal;
	}

	/**
	 * This method initializes jTextFieldTotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTotal() {
		if (jTextFieldTotal == null) {
			jTextFieldTotal = new JTextField();
			jTextFieldTotal.setBounds(new Rectangle(91, 416, 91, 26));
			jTextFieldTotal.setToolTipText("Total Del Recibo");
			jTextFieldTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldTotal.setForeground(new Color(254, 0, 0));
			jTextFieldTotal.setText("0");
			jTextFieldTotal.setEditable(false);

		}
		return jTextFieldTotal;
	}

	/**
	 * This method initializes jTextIva
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextIva() {
		if (jTextIva == null) {
			jTextIva = new JTextField();
			jTextIva.setBounds(new Rectangle(91, 371, 91, 26));
			jTextIva.setToolTipText("Ingrese el I.V.A");
			jTextIva.setText("0");
			jTextIva.setEnabled(true);
			jTextIva.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (jTextIva.getText().trim().compareTo("") == 0)
						jTextIva.setText("0");
					jTextIva.setText(util.cortarCadenaFloat(jTextIva.getText()
							.trim()));
					if (Float.parseFloat(jTextIva.getText().trim()) > Float
							.parseFloat(jTextFieldISubtotal.getText())) {
						JOptionPane
								.showMessageDialog(
										null,
										"El valor del IVA, no puede ser superior al Subtotal!",
										"Alerta!", JOptionPane.ERROR_MESSAGE);
						jTextIva.setText("0");
					}

					float suma = 0;
					suma = Float.parseFloat(jTextIva.getText().trim())
							+ Float.parseFloat(jTextFieldISubtotal.getText()
									.trim());
					jTextFieldTotal.setText("" + util.Redondear("" + suma, 2));
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
		}
		return jTextIva;
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			jPanel1.setBounds(new Rectangle(2, 301, 533, 4));
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanelLabel211
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelLabel211() {
		if (jPanelLabel211 == null) {
			jLabelTotalRetencion = new JLabel();
			jLabelTotalRetencion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTotalRetencion
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTotalRetencion.setText("Total de la Retención :");
			jLabelRetencion = new JLabel();
			jLabelRetencion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelRetencion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelRetencion.setText("Número de Retención  :");
			GridLayout gridLayout12111 = new GridLayout();
			gridLayout12111.setRows(2);
			gridLayout12111.setVgap(16);
			gridLayout12111.setHgap(3);
			gridLayout12111.setColumns(1);
			jPanelLabel211 = new JPanel();
			jPanelLabel211.setLayout(gridLayout12111);
			jPanelLabel211.setBounds(new Rectangle(269, 349, 157, 68));
			jPanelLabel211.setVisible(false);
			jPanelLabel211.add(jLabelRetencion, null);
			jPanelLabel211.add(jLabelTotalRetencion, null);
		}
		return jPanelLabel211;
	}

	/**
	 * This method initializes jTextFieldINumeroRetencion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldINumeroRetencion() {
		if (jTextFieldINumeroRetencion == null) {
			jTextFieldINumeroRetencion = new JTextField();
			jTextFieldINumeroRetencion
					.setBounds(new Rectangle(433, 350, 69, 26));
			jTextFieldINumeroRetencion
					.setToolTipText("Ingrese el Número de Retención");
			jTextFieldINumeroRetencion.setText("0");
			jTextFieldINumeroRetencion.setForeground(new Color(0, 4, 255));
			jTextFieldINumeroRetencion.setFont(new Font("Dialog", Font.PLAIN,
					20));
			jTextFieldINumeroRetencion.setEnabled(true);
			jTextFieldINumeroRetencion.setVisible(false);
			jTextFieldINumeroRetencion
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							if (jTextFieldINumeroRetencion.getText().trim()
									.compareTo("") == 0)
								jTextFieldINumeroRetencion.setText("0");
							jTextFieldINumeroRetencion
									.setText(util
											.cortarCadenaFloat(jTextFieldINumeroRetencion
													.getText().trim()));
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);

						}
					});
		}
		return jTextFieldINumeroRetencion;
	}

	/**
	 * This method initializes jTextFieldITotalRetencion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldITotalRetencion() {
		if (jTextFieldITotalRetencion == null) {
			jTextFieldITotalRetencion = new JTextField();
			jTextFieldITotalRetencion
					.setBounds(new Rectangle(433, 389, 69, 26));
			jTextFieldITotalRetencion
					.setToolTipText("Ingrese el total retenido");
			jTextFieldITotalRetencion.setText("0");
			jTextFieldITotalRetencion.setEnabled(true);
			jTextFieldITotalRetencion.setVisible(false);
			jTextFieldITotalRetencion
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							if (jTextFieldITotalRetencion.getText().trim()
									.compareTo("") == 0)
								jTextFieldITotalRetencion.setText("0");
							if (Float.parseFloat(jTextFieldITotalRetencion
									.getText().trim()) > Float
									.parseFloat(jTextFieldTotal.getText())) {
								JOptionPane
										.showMessageDialog(
												null,
												"El total de la retención no puede ser superior al total del recibo!",
												"Alerta!",
												JOptionPane.ERROR_MESSAGE);
								jTextFieldITotalRetencion.setText("0");
							}
							jTextFieldITotalRetencion
									.setText(util
											.cortarCadenaFloat(jTextFieldITotalRetencion
													.getText().trim()));

						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
		}
		return jTextFieldITotalRetencion;
	}

	/**
	 * This method initializes jTextAreaDescripcionAdicional
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaDescripcionAdicional() {
		if (jTextAreaDescripcionAdicional == null) {
			jTextAreaDescripcionAdicional = new JTextArea();
			jTextAreaDescripcionAdicional.setBorder(BorderFactory
					.createEtchedBorder(EtchedBorder.LOWERED));
			jTextAreaDescripcionAdicional
					.setToolTipText("Ingrese alguna descripcion adicional del recibo como información del proveedor");
		}
		return jTextAreaDescripcionAdicional;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(188, 472, 308, 74));
			jScrollPane.setViewportView(getJTextAreaDescripcionAdicional());
		}
		return jScrollPane;
	}

	private void bloquearItemNoRequerido() {
		if (choiceTipoREcibo.getSelectedItem().compareTo("FACTURA") != 0) {
			jTextFieldINumeroRetencion.setEnabled(false);
			jTextFieldITotalRetencion.setEnabled(false);
			jTextIva.setEnabled(false);

		} else {
			jTextFieldINumeroRetencion.setEnabled(true);
			jTextFieldITotalRetencion.setEnabled(true);
			jTextIva.setEnabled(true);
		}
	}

	/**
	 * This method initializes jTextFieldIdBusqueda
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIdBusqueda() {
		if (jTextFieldIdBusqueda == null) {
			jTextFieldIdBusqueda = new JTextField();
			jTextFieldIdBusqueda.setBounds(new Rectangle(418, 47, 89, 31));
			jTextFieldIdBusqueda.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldIdBusqueda.setForeground(new Color(254, 0, 0));
			jTextFieldIdBusqueda
					.setToolTipText("Ingrese el Id del Recibo para Buscar");
			jTextFieldIdBusqueda.setText("0");
			jTextFieldIdBusqueda.setEditable(true);
			jTextFieldIdBusqueda.setEnabled(true);
			jTextFieldIdBusqueda
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
			jTextFieldIdBusqueda
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							jTextFieldIdBusqueda.setText(jTextFieldIdBusqueda
									.getText().replace('.', ' '));
							buscarItem();
						}
					});
			jTextFieldIdBusqueda
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							comprasGDp.setIdCompraGasto(Integer
									.parseInt(jTextFieldIdBusqueda.getText()
											.trim()));
							buscarItem();
						}
					});
		}
		return jTextFieldIdBusqueda;
	}

	/**
	 * Revisa que el objeto recoja toda la informaciçon del formulario
	 */
	private void validar() {
		comprasGDp.setNumeroComprobante(Integer
				.parseInt(jTextFieldINumeroComprobante.getText()));
		comprasGDp.setFechaCompra(jTextFieldFecha.getText());
		comprasGDp
				.setDescripcion(jTextAreaDescripcionProducto.getText().trim());
		comprasGDp.setTipoComprobante(choiceTipoREcibo.getSelectedItem());
		comprasGDp.setSubtotal(Float.parseFloat(jTextFieldISubtotal.getText()
				.trim()));
		comprasGDp.setIva(Float.parseFloat(jTextIva.getText().trim()));
		comprasGDp.setTotalPagado(Float.parseFloat(jTextFieldTotal.getText()
				.trim()));
		comprasGDp.setNumeroRetencion(Integer
				.parseInt(jTextFieldINumeroRetencion.getText().trim()));
		comprasGDp.setTotalRetencion(Float.parseFloat(jTextFieldITotalRetencion
				.getText().trim()));
		comprasGDp.setDescripcionAdicional(jTextAreaDescripcionAdicional
				.getText().trim());
		jTextAreaDescripcionProducto.setText("");
		// @jve:decl-index=0:
	}// validar

	/**
	 * This method initializes jTextAreaDescripcionProducto
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextAreaDescripcionProducto() {
		if (jTextAreaDescripcionProducto == null) {
			jTextAreaDescripcionProducto = new JTextField();
			jTextAreaDescripcionProducto.setBounds(new Rectangle(150, 197, 317, 30));
			jTextAreaDescripcionProducto.setColumns(5);
			jTextAreaDescripcionProducto
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextAreaDescripcionProducto.setText(util
									.cortarCadenaString(
											jTextAreaDescripcionProducto
													.getText(), 50));
						}
					});
		}
		return jTextAreaDescripcionProducto;
	}

	public void mostrar() {
		System.out.print("\nDec:" + comprasGDp.getDescripcion());
		System.out.print("\nNumC:" + comprasGDp.getNumeroComprobante());
		System.out.print("\nIdCompGas:" + comprasGDp.getIdCompraGasto());
		System.out.print("\nTotal Pâg:" + comprasGDp.getTotalPagado());
		System.out.print("\n:");
		System.out.print("\n:" + comprasGDp.getIdCompraGasto());
		System.out.print("\n:" + comprasGDp.getNumeroComprobante());
		System.out.print("\n:" + comprasGDp.getDescripcion());
		System.out.print("\n:" + comprasGDp.getTipoComprobante());
		System.out.print("\n:" + comprasGDp.getIva());
		System.out.print("\n:" + comprasGDp.getSubtotal());
		System.out.print("\n:" + comprasGDp.getTotalPagado());
		System.out.print("\n:" + comprasGDp.getDescripcionAdicional());
		System.out.print("\n:" + comprasGDp.getNumeroRetencion());
		System.out.print("\n:" + comprasGDp.getTotalRetencion());
		System.out.print("\n:" + comprasGDp.getFechaCompra());

	}

	/**
	 * This method initializes jButtonBuscarProveedor
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscarProveedor() {
		if (jButtonBuscarProveedor == null) {
			jButtonBuscarProveedor = new JButton();
			jButtonBuscarProveedor.setBounds(new Rectangle(474, 195, 31, 33));
			jButtonBuscarProveedor.setIcon(new ImageIcon(getClass().getResource("/frameIcons/usuario.png")));
			jButtonBuscarProveedor.setToolTipText("Buscar Cliente");
			jButtonBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					lista.getPreferredSize();
					lista.setLocation( jTextAreaDescripcionProducto.getX(),
							jTextAreaDescripcionProducto.getY() + 10);

					lista
							.addFocusListener(new java.awt.event.FocusAdapter() {
								public void focusLost(
										java.awt.event.FocusEvent e) {
									ventanaClienteAbierta = false;
								
								}
							});
					lista.setVisible(true);
					ventanaClienteAbierta = true;
				}
			});
		}
		return jButtonBuscarProveedor;
	}

} // @jve:decl-index=0:visual-constraint="10,10"

