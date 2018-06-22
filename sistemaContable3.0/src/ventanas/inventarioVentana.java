package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
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

import tableUtil.detalleInventario;
import tableUtil.modeloInventario;
import tableUtil.renderTabla;
import Utilitarios.utilitarios;
import clases.InventarioDetalle;
import clases.inventario;
import clasesBdd.bodegaBdd;
import clasesBdd.conexionBdd;
import clasesBdd.inventarioBdd;
import clasesBdd.pagoRealizadoBdd;
import clasesBdd.proveedoresBdd;
import clasesBdd.tipoProductoBdd;
import clasesBdd.unidadMedidaBdd;

import com.toedter.calendar.JCalendar;

public class inventarioVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="17,94"
	private JButton jButtonIngresar = null;
	private JButton jButtonIngresarLote = null;
	private JButton jButtonLimpiar = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administracióninventario = null;
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JTextField jTextFieldDescripcion = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private inventario inventarioDp = new inventario(0, 0, 0, 0, 0, "", 0, 0,
			0, 0, 0); // @jve:decl-index=0:
	private InventarioDetalle inventarioDetalleDP = new InventarioDetalle(0, 0,
			0, 0, "", ""); // @jve:decl-index=0:
	private inventarioBdd inventarioMd = new inventarioBdd();

	private proveedoresBdd proveedorMd = new proveedoresBdd(); // @jve:decl-index=0:
	private tipoProductoBdd tipoProductoMd = new tipoProductoBdd();
	private unidadMedidaBdd unidadMedidaMd = new unidadMedidaBdd();

	private pagoRealizadoBdd pagoRealizadoMd = new pagoRealizadoBdd(); // @jve:decl-index=0:
	private bodegaBdd bodegaMd = new bodegaBdd();
	JDesktopPane JDesktopPanePrin;
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private String fechaAnterior;
	private Boolean botonpressionado = false; // @jve:decl-index=0:

	Hashtable<Object, Object> proveedoresHash = proveedorMd
			.seleccionarDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> tipoProductoHash = tipoProductoMd
			.seleccionarDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> unidadMedidaHash = unidadMedidaMd
			.seleccionarDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> pagoRealizadoHash = pagoRealizadoMd
			.seleccionarDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> bodegaHash = bodegaMd.seleccionarDescripcionesTablaHash(con
			.getConexion()); // @jve:decl-index=0:

	Hashtable<Object, Object> proveedoresIdTablaDescripcionHash = proveedorMd
			.seleccionarIdTablaDescripcionTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> tipoProductoIdTablaDescripcionHash = tipoProductoMd
			.seleccionarIdTAblaDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> unidadMedidaIdTAblaDescripcionHash = unidadMedidaMd
			.seleccionarIdTablaDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> pagoRealizadoIdTablaDescripcionHash = pagoRealizadoMd
			.seleccionarIdTablaDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> bodegaIdTablaDescripcionHash = bodegaMd
			.seleccionarIdTablaDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:

	boolean insertarLista = true;
	boolean insertarBdd = true;

	private JLabel jLabelIdProveedor = null;
	private JLabel jLabelUnidadDeMedida = null;
	private JLabel jLabelTipoDeProducto = null;
	private JLabel jLabelPagoRealizadoId = null;
	private JLabel jLabelPrecioCompra = null;
	private JLabel jLabelPrecioVenta = null;
	private JLabel jLabelMedida = null;
	private JLabel jLabelLongitud = null;
	private JLabel jLabelFechaCaducidad = null;
	private JLabel jLabelFechaCantidad = null;
	private JComboBox ChoiceProveedor = null;
	private JComboBox ChoiceTipoProducto = null;
	private JComboBox ChoiceUnidadDeMedida = null;
	private JComboBox ChoiceReciboDeCompra = null;
	private JTextField jTextFieldPrecioCompra = null;
	private JTextField jTextFieldPrecioVenta = null;
	private JTextField jTextFieldEquivalente = null;
	private JTextField jTextFieldTotalBruto = null;
	private JTextField jTextFieldCantidadDisponible = null;
	private JTextField jTextFieldFecCaduca = null;
	/*
	 * para uso del calendario
	 */
	// protected SimpleDateFormat formatofecha = new SimpleDateFormat("MMMMM d,
	// yyyy"); // @jve:decl-index=0:
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup;
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	int filaQueCambio = 0;
	// bug del primer item
	boolean primerItem = true;
	String UserActual;

	protected boolean isInitialized;
	private JButton jButtonCalendario = null;
	private JComboBox choiceBodega = null;
	private JLabel jLabelBodega = null;
	private JPanel jPanelEtiquetas11 = null;
	private JLabel Administracióninventario1 = null;
	private JPanel jPanelEtiquetas111 = null;
	private JPanel jPanelEtiquetas112 = null;
	private JPanel jPanelEtiquetas1121 = null;
	private JLabel jLabelPrecioVenta1 = null;
	private JTextField jTextFieldPrecioVentaSocio = null;
	private JLabel Administracióninventario11 = null;
	private JTable jTable = null;
	private modeloInventario modelo = null; // @jve:decl-index=0:
	private JScrollPane jScrollPane = null;
	private JLabel jLabelFechaCantidad1 = null;
	private JTextField jTextFieldCantidadDisponible1 = null;
	private JLabel jLabelFechaCantidad11 = null;

	/**
	 * This is the default constructor
	 */
	public inventarioVentana(String User, Boolean modificar,
			String Descripcion, JDesktopPane JDesktopPanePrin1) {
		super();
		initialize();
		UserActual = User;
		JDesktopPanePrin = JDesktopPanePrin1;
		this.setClosable(true);
		this.setIconifiable(true);
		verificarModificarConstructor(modificar, Descripcion);

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(714, 687);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración de inventarios");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFechaCantidad11 = new JLabel();
			jLabelFechaCantidad11.setBounds(new Rectangle(632, 599, 51, 20));
			jLabelFechaCantidad11
					.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelFechaCantidad11.setText("Bruto");
			jLabelFechaCantidad11.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelFechaCantidad1 = new JLabel();
			jLabelFechaCantidad1.setBounds(new Rectangle(631, 626, 52, 18));
			jLabelFechaCantidad1.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelFechaCantidad1.setText("Items");
			jLabelFechaCantidad1.setHorizontalAlignment(SwingConstants.LEFT);
			Administracióninventario11 = new JLabel();
			Administracióninventario11
					.setBounds(new Rectangle(1, 374, 699, 19));
			Administracióninventario11.setForeground(Color.blue);
			Administracióninventario11
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióninventario11.setText("Producto Existente");
			Administracióninventario11
					.setFont(new Font("Dialog", Font.BOLD, 13));
			Administracióninventario1 = new JLabel();
			Administracióninventario1.setBounds(new Rectangle(1, 258, 704, 18));
			Administracióninventario1.setForeground(Color.blue);
			Administracióninventario1
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióninventario1
					.setText("Editor de mercaderia disponible de producto");
			Administracióninventario1
					.setFont(new Font("Dialog", Font.BOLD, 13));
			Administracióninventario = new JLabel();
			Administracióninventario.setBounds(new Rectangle(1, 15, 701, 21));
			Administracióninventario.setForeground(Color.blue);
			Administracióninventario
					.setText("Administración de producto en Inventario");
			Administracióninventario
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióninventario.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióninventario, null);
			jContentPane.add(getJButtonCalendario2(), null);
			jContentPane.add(getJTextFieldCantidadDisponible(), null);
			jContentPane.add(getJPanelEtiquetas11(), null);
			jContentPane.add(jLabelFechaCantidad, null);
			jContentPane.add(Administracióninventario1, null);
			jContentPane.add(getJPanelEtiquetas111(), null);
			jContentPane.add(getJPanelEtiquetas112(), null);
			jContentPane.add(getJPanelEtiquetas1121(), null);
			jContentPane.add(getJButtonIngresar(), null);
			jContentPane.add(getJButtonLimpiar(), null);
			jContentPane.add(getJButtonIngresarLote(), null);
			jContentPane.add(Administracióninventario11, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabelFechaCantidad1, null);
			jContentPane.add(getJTextFieldCantidadDisponible1(), null);
			jContentPane.add(jLabelFechaCantidad11, null);
		}
		return jContentPane;
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
			jButtonIngresar.setBounds(new Rectangle(480, 185, 187, 28));
			jButtonIngresar.setText("Ingresar Nuevo Producto");
			jButtonIngresar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (opcionModulo == 1) {
								crearImagenBlanco();
								insertar();
							} else {
								modificar();
							}
						}
					});
		}
		return jButtonIngresar;
	}

	/**
	 * This method initializes jButtonIngresarLote
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonIngresarLote() {
		if (jButtonIngresarLote == null) {
			jButtonIngresarLote = new JButton();
			jButtonIngresarLote.setEnabled(false);
			jButtonIngresarLote.setBounds(new Rectangle(417, 332, 185, 28));
			jButtonIngresarLote.setText("Ingresar Lote");
			jButtonIngresarLote
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (opcionModulo != 0) {
								detalleInventario item = validarItem();
								if (item != null) {

									if (modelo.getRowCount() == 0) {
										modelo.nuevoItem(item);
										insertarLista = true;

									} else {
										buscarEnLista(item);

									}
									if (insertarLista) {
										insertarLote(item);// inserta enla Bdd
										insertarLista = false;
									}// if insertarLista=true;

								}// if null
							}
							colocarCantidad();
						}// opcion de modulo

					});
		}
		return jButtonIngresarLote;
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
			jButtonLimpiar.setBounds(new Rectangle(480, 217, 186, 28));
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
	 * This method initializes jPanelEtiquetas
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			jLabelBodega = new JLabel();
			jLabelBodega.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBodega.setText("Bodega :");
			jLabelBodega.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaCantidad = new JLabel();
			jLabelFechaCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaCantidad.setText("Cantidad Disponible :");
			jLabelFechaCantidad.setBounds(new Rectangle(398, 598, 149, 17));
			jLabelFechaCantidad.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFechaCaducidad = new JLabel();
			jLabelFechaCaducidad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaCaducidad.setText("Fecha Caducidad :");
			jLabelFechaCaducidad
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelLongitud = new JLabel();
			jLabelLongitud.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelLongitud.setText("Total Adquirido :");
			jLabelLongitud.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelMedida = new JLabel();
			jLabelMedida.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelMedida.setText("Equivalente a 1 item :");
			jLabelMedida.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPrecioVenta = new JLabel();
			jLabelPrecioVenta.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPrecioVenta.setText("Precio de Venta :");
			jLabelPrecioVenta.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPrecioCompra = new JLabel();
			jLabelPrecioCompra.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPrecioCompra.setText("Precio de Compra :");
			jLabelPrecioCompra.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPagoRealizadoId = new JLabel();
			jLabelPagoRealizadoId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPagoRealizadoId.setText("Nombre Recibo de Compra :");
			jLabelPagoRealizadoId
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTipoDeProducto = new JLabel();
			jLabelTipoDeProducto.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipoDeProducto.setText("Tipo de Producto :");
			jLabelTipoDeProducto
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidadDeMedida = new JLabel();
			jLabelUnidadDeMedida.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelUnidadDeMedida.setText("Unidad de Medida :");
			jLabelUnidadDeMedida
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelIdProveedor = new JLabel();
			jLabelIdProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdProveedor.setText("Proveedor :");
			jLabelIdProveedor.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID de Producto :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Descripción :");
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(8);
			gridLayout.setHgap(25);
			gridLayout.setVgap(7);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(53, 52, 165, 194));
			jPanelEtiquetas.add(jLabelDescripcion, null);
			jPanelEtiquetas.add(jLabelId, null);
			jPanelEtiquetas.add(jLabelIdProveedor, null);
			jPanelEtiquetas.add(jLabelTipoDeProducto, null);
			jPanelEtiquetas.add(jLabelUnidadDeMedida, null);
			jPanelEtiquetas.add(jLabelPagoRealizadoId, null);
			jPanelEtiquetas.add(jLabelBodega, null);
			jPanelEtiquetas.add(jLabelMedida, null);
		}
		return jPanelEtiquetas;
	}

	/**
	 * This method initializes jPanelInputs
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelInputs() {
		if (jPanelInputs == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(8);
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(7);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(233, 52, 164, 193));
			jPanelInputs.add(getJTextFieldId(), null);
			jPanelInputs.add(getJTextFieldDescripcion(), null);
			jPanelInputs.add(getChoiceProveedor(), null);
			jPanelInputs.add(getChoiceTipoProducto(), null);
			jPanelInputs.add(getChoiceUnidadDeMedida(), null);
			jPanelInputs.add(getChoiceReciboDeCompra(), null);
			jPanelInputs.add(getChoiceBodega(), null);
			jPanelInputs.add(getjTextFieldEquivalente(), null);
		}
		return jPanelInputs;
	}

	/**
	 * This method initializes jTextFieldId
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setEnabled(false);
			jTextFieldId.setToolTipText("Identificador De Registro en Tabla");
			jTextFieldId.setText("0");
		}
		return jTextFieldId;
	}

	/**
	 * This method initializes jTextFieldDescripcion
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDescripcion() {
		if (jTextFieldDescripcion == null) {
			jTextFieldDescripcion = new JTextField();
			jTextFieldDescripcion
					.setToolTipText("Ingrese una descripción del producto");
			jTextFieldDescripcion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldDescripcion.getText().trim()
									.compareTo("") == 0
									&& opcionModulo != 0) {
								JOptionPane.showMessageDialog(null,
										"Este Campo no puede estar vacio!",
										"Aviso!", JOptionPane.ERROR_MESSAGE);
							} else {
								if (jTextFieldDescripcion.getText().trim()
										.compareTo("") != 0) {
									inventarioDp
											.setDescripcion(jTextFieldDescripcion
													.getText().trim());

									buscarItem();

								}// end else
							}
						}
					});
			jTextFieldDescripcion
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldDescripcion.setText(util
									.cortarCadenaString(jTextFieldDescripcion
											.getText(), 50));
						}

					});

		}
		return jTextFieldDescripcion;
	}

	private void limpiar() {
		inventarioVentana inventarioVentanaW = new inventarioVentana(
				UserActual, false, "", JDesktopPanePrin);
		inventarioVentanaW.setLocation(this.getX(), this.getY());
		inventarioVentanaW.getPreferredSize();
		inventarioVentanaW.setLocation(this.getX(), this.getY());
		JDesktopPanePrin.add(inventarioVentanaW);
		this.dispose();
		inventarioVentanaW.setVisible(true);

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {

		if (opcionModulo == 1
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			validarProducto();
			inventarioMd.insertar(con.getConexion(), inventarioDp);
			inventarioDp.setIdProducto(0);
			inventarioDp = inventarioMd.buscarInfoDeUnRegistro(con
					.getConexion(), inventarioDp);
			jTextFieldId.setText("" + inventarioDp.getIdProducto());
			jButtonIngresarLote.setEnabled(true);

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

		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			validarProducto();
			inventarioMd.modificar(con.getConexion(), inventarioDp);

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
		// cargarClases();
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			// inventarioMd.eliminar(con.getConexion(), inventarioDp);

		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// eliminar

	/**
	 * This method initializes ChoiceProveedor
	 * 
	 * @return javax.swing.Choice
	 */
	private JComboBox getChoiceProveedor() {
		if (ChoiceProveedor == null) {
			ChoiceProveedor = new JComboBox();
			cargarChoiceProveedores();
			// ChoiceProveedor.setToolTipText("Escoja el proveedor");
			ChoiceProveedor.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {

					// System.out.print("asd "+inventarioDp.getIdProveedor());
				}

			});
		}
		return ChoiceProveedor;
	}

	/**
	 * This method initializes ChoiceTipoProducto
	 * 
	 * @return javax.swing.Choice
	 */
	private JComboBox getChoiceTipoProducto() {
		if (ChoiceTipoProducto == null) {
			ChoiceTipoProducto = new JComboBox();
			cargarChoiceTipoProducto();
			// ChoiceTipoProducto.setToolTipText("Escoja el Tipo de Producto");

		}
		return ChoiceTipoProducto;
	}

	/**
	 * This method initializes ChoiceUnidadDeMedida
	 * 
	 * @return javax.swing.Choice
	 */
	private JComboBox getChoiceUnidadDeMedida() {
		if (ChoiceUnidadDeMedida == null) {
			ChoiceUnidadDeMedida = new JComboBox();
			cargarChoiceUnidadMedida();
			// ChoiceUnidadDeMedida.setToolTipText("Escoja una unidad de medida
			// para el producto");

		}
		return ChoiceUnidadDeMedida;
	}

	/**
	 * This method initializes ChoiceReciboDeCompra
	 * 
	 * @return javax.swing.Choice
	 */
	private JComboBox getChoiceReciboDeCompra() {
		if (ChoiceReciboDeCompra == null) {
			ChoiceReciboDeCompra = new JComboBox();
			cargarChoicePagoRealizado();
			// ChoiceReciboDeCompra.setToolTipText("Escoja el Recibo Con el que
			// se Adquiriço el producto");

		}
		return ChoiceReciboDeCompra;
	}

	/**
	 * This method initializes jTextFieldPrecioCompra
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecioCompra() {
		if (jTextFieldPrecioCompra == null) {
			jTextFieldPrecioCompra = new JTextField();
			jTextFieldPrecioCompra
					.setToolTipText("Ingrese el precio de Compra");
			jTextFieldPrecioCompra.setText("0");
			jTextFieldPrecioCompra
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {

							jTextFieldPrecioCompra.setText(util
									.cortarCadenaFloat(jTextFieldPrecioCompra
											.getText().toString()));
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});

		}
		return jTextFieldPrecioCompra;
	}

	/**
	 * This method initializes jTextFieldPrecioVenta
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecioVenta() {
		if (jTextFieldPrecioVenta == null) {
			jTextFieldPrecioVenta = new JTextField();
			jTextFieldPrecioVenta.setToolTipText("Ingrese el precio de Venta");
			jTextFieldPrecioVenta.setText("0");
			jTextFieldPrecioVenta
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldPrecioVenta.setText(util
									.cortarCadenaFloat(jTextFieldPrecioVenta
											.getText()));
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
			jTextFieldPrecioVenta
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldPrecioVenta.getText().compareTo("") != 0)
								inventarioDp.setPvp(Float
										.parseFloat(jTextFieldPrecioVenta
												.getText().trim()));
							else {
								inventarioDp.setPvp(Float.parseFloat("0"));
							}
						}
					});
		}
		return jTextFieldPrecioVenta;
	}

	/**
	 * This method initializes jTextFieldEquivalente
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldEquivalente() {
		if (jTextFieldEquivalente == null) {
			jTextFieldEquivalente = new JTextField();
			jTextFieldEquivalente
					.setToolTipText("Ingrese una cantidad equivalente a una unidad de producto");
			jTextFieldEquivalente.setText("1");
			jTextFieldEquivalente
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldEquivalente.setText(util
									.cortarCadenaFloat(jTextFieldEquivalente
											.getText()));
							colocarCantidad();
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);

						}
					});
			jTextFieldEquivalente
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldPrecioCompra.getText().compareTo("") != 0)
								inventarioDp.setEquivalente(Float
										.parseFloat(jTextFieldEquivalente
												.getText().trim()));
							else {
								inventarioDp.setPvp(Float.parseFloat("0"));
							}
						}
					});
		}
		return jTextFieldEquivalente;
	}

	/**
	 * This method initializes jTextFieldTotalBruto
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldTotalBruto() {
		if (jTextFieldTotalBruto == null) {
			jTextFieldTotalBruto = new JTextField();
			jTextFieldTotalBruto
					.setToolTipText("Ingrese el total en bruto adquirido del producto");
			jTextFieldTotalBruto.setText("0");
			jTextFieldTotalBruto
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldTotalBruto.setText(util
									.cortarCadenaFloat(jTextFieldTotalBruto
											.getText()));
							colocarCantidad();
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);

						}
					});

		}
		return jTextFieldTotalBruto;
	}

	/**
	 * This method initializes jTextFieldCantidadDisponible
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidadDisponible() {
		if (jTextFieldCantidadDisponible == null) {
			jTextFieldCantidadDisponible = new JTextField();
			jTextFieldCantidadDisponible.setToolTipText("Cantidad Disponible");
			jTextFieldCantidadDisponible.setText("0");
			jTextFieldCantidadDisponible.setBounds(new Rectangle(552, 627, 76,
					18));
			jTextFieldCantidadDisponible.setFont(new Font("Dialog", Font.BOLD,
					18));
			jTextFieldCantidadDisponible.setForeground(new Color(255, 0, 51));
			jTextFieldCantidadDisponible.setEditable(false);
		}
		return jTextFieldCantidadDisponible;
	}

	/**
	 * cargar Choice proveedores
	 */
	private void cargarChoiceProveedores() {
		ChoiceProveedor.removeAll();
		Object descripciones[] = proveedorMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			ChoiceProveedor.addItem("" + descripciones[i]);
		}
	}

	/**
	 * Choice Tipo de producto
	 */
	private void cargarChoiceTipoProducto() {
		ChoiceTipoProducto.removeAll();
		Object descripciones[] = tipoProductoMd
				.seleccionarDescripcionesTabla(con.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			ChoiceTipoProducto.addItem("" + descripciones[i]);
		}
	}

	/**
	 * Choice Unidad de Medida
	 */
	private void cargarChoiceUnidadMedida() {
		ChoiceUnidadDeMedida.removeAll();
		Object descripciones[] = unidadMedidaMd
				.seleccionarDescripcionesTabla(con.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			ChoiceUnidadDeMedida.addItem("" + descripciones[i]);
		}
	}

	/**
	 * Choice Recibo de Compra
	 */
	private void cargarChoicePagoRealizado() {
		ChoiceReciboDeCompra.removeAll();
		Object descripciones[] = pagoRealizadoMd
				.seleccionarDescripcionesTabla(con.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			ChoiceReciboDeCompra.addItem("" + descripciones[i]);
		}
	}

	/**
	 * busca si el producto existe en la base de datos
	 */
	private void buscarItem() {
		anterior = jTextFieldDescripcion.getText().trim();

		inventarioDp = inventarioMd.buscarInfoDeUnRegistro(con.getConexion(),
				inventarioDp);

		if (inventarioDp.getIdProducto() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			jButtonCalendario.setEnabled(true);
			jButtonIngresar.setEnabled(true);
			//

			opcionModulo = 1;
		} else {
			/**
			 * Activa Modificación
			 */
			opcionModulo = 2;
			jTextFieldDescripcion.setEnabled(false);
			jButtonIngresarLote.setEnabled(true);

			ChoiceProveedor.setSelectedItem(""
					+ proveedoresIdTablaDescripcionHash.get(""
							+ inventarioDp.getIdProveedor()));

			ChoiceTipoProducto.setSelectedItem(""
					+ tipoProductoIdTablaDescripcionHash.get(""
							+ inventarioDp.getIdTipoProducto()));
			ChoiceUnidadDeMedida.setSelectedItem(""
					+ unidadMedidaIdTAblaDescripcionHash.get(""
							+ inventarioDp.getUnidadDeMedida()));
			ChoiceReciboDeCompra.setSelectedItem(""
					+ pagoRealizadoIdTablaDescripcionHash.get(""
							+ inventarioDp.getIdPagoRealizado()));

			choiceBodega.setSelectedItem(""
					+ bodegaIdTablaDescripcionHash.get(""
							+ inventarioDp.getIdBodega()));

			jTextFieldCantidadDisponible.setText(""
					+ inventarioDp.getCantidad());
			jTextFieldId.setText("" + inventarioDp.getIdProducto());
			jTextFieldEquivalente.setText("" + inventarioDp.getEquivalente());
			jTextFieldPrecioVenta.setText("" + inventarioDp.getPvp());
			jTextFieldPrecioVentaSocio.setText("" + inventarioDp.getPvpSocio());
			jButtonCalendario.setEnabled(true);
			jButtonIngresar.setEnabled(true);
			jButtonIngresarLote.setEnabled(true);

			Object datos2[][] = inventarioMd.seleccionarDetalleProducto(con
					.getConexion(), inventarioDp.getIdProducto());
			if (datos2.length != 0) {
				for (int j = 0; j < datos2.length; j++) {
					float cantidad = Float.parseFloat("" + datos2[j][3]);
					String FechaCaducidad = "" + datos2[j][5];
					String FechaIngreso = "" + datos2[j][4];
					float precioCompra = Float.parseFloat("" + datos2[j][2]);
					detalleInventario item = new detalleInventario(cantidad,
							FechaIngreso, FechaCaducidad, precioCompra,
							new Boolean(true));
					modelo.nuevoItem(item);
				}

			}

			colocarCantidad();
			jButtonIngresar.setText("Modificar Producto");
		}// end else

	}

	private void bloquear() {
		jButtonIngresar.setEnabled(false);
		jTextFieldDescripcion.setEnabled(false);

	}

	/**
	 * This method initializes jTextFieldFecCaduca
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecCaduca() {
		// if (jTextFieldFecCaduca == null) {
		if (jTextFieldFecCaduca == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				jTextFieldFecCaduca = new JFormattedTextField(mascara);
				jTextFieldFecCaduca.setEnabled(false);
				jTextFieldFecCaduca.setText(util.fechaActual());
				jTextFieldFecCaduca.setEditable(false);
				jTextFieldFecCaduca
						.setToolTipText("Escoja la fecha de Caducidad con el botón de la derecha");
				jTextFieldFecCaduca
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {

								/**
								 * calendario1
								 */

								BufferComparacion = jTextFieldFecCaduca
										.getText();
								BufferComparacion = BufferComparacion
										.toString();
								jTextFieldFecCaduca.setEnabled(true);

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

								/**
								 * 
								 * calendario1
								 */
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}// funcion
		return jTextFieldFecCaduca;

	}

	/**
	 * This method initializes jButtonCalendario
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario2() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setEnabled(false);
			jButtonCalendario.setBounds(new Rectangle(335, 309, 26, 27));
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario.setText("");
			jButtonCalendario
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (opcionModulo == 2) {
								botonpressionado = true;
								fechaAnterior = jTextFieldFecCaduca.getText();
							}
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
							popup.show(jButtonCalendario, jButtonCalendario
									.getY() - 310,
									jButtonCalendario.getY() - 310);
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
								if (jTextFieldFecCaduca.getText().compareTo("") == 0) {

									jTextFieldFecCaduca.setText(fechaString);

								} else {
									jTextFieldFecCaduca.setText(fechaString);
									try {
										diaAnterior = jTextFieldFecCaduca
												.getText().substring(8, 10);// se
										// requiere
										// para
										// cerrar
										// el
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

		}
		return jButtonCalendario;
	}

	/**
	 * This method initializes choiceBodega
	 * 
	 * @return java.awt.Choice
	 */
	private JComboBox getChoiceBodega() {
		if (choiceBodega == null) {
			choiceBodega = new JComboBox();
			cargarChoiceBodega();

		}
		return choiceBodega;
	}

	public void cargarChoiceBodega() {
		choiceBodega.removeAll();
		Object descripciones[] = bodegaMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceBodega.addItem("" + descripciones[i]);
		}

	}

	private void colocarCantidad() {
		if (jTextFieldEquivalente.getText().trim().compareTo("") != 0
				&& jTextFieldTotalBruto.getText().trim().compareTo("") != 0) {
			float equiva = Float.parseFloat(""
					+ jTextFieldEquivalente.getText());
			float totalbruto = devolverTotalBruto();

			float itemsDispo = totalbruto / equiva;
			jTextFieldCantidadDisponible.setText(""
					+ util.Redondear("" + itemsDispo, 2));
			jTextFieldCantidadDisponible1.setText(""
					+ util.Redondear("" + totalbruto, 2));

		}

	}// colocarCantidad

	/**
	 * This method initializes jPanelEtiquetas11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas11() {
		if (jPanelEtiquetas11 == null) {
			GridLayout gridLayout31 = new GridLayout();
			gridLayout31.setRows(3);
			gridLayout31.setHgap(25);
			gridLayout31.setVgap(7);
			gridLayout31.setColumns(2);
			jPanelEtiquetas11 = new JPanel();
			jPanelEtiquetas11.setLayout(gridLayout31);
			jPanelEtiquetas11.setBounds(new Rectangle(31, 285, 166, 73));
			jPanelEtiquetas11.add(jLabelLongitud, null);
			jPanelEtiquetas11.add(jLabelFechaCaducidad, null);
			jPanelEtiquetas11.add(jLabelPrecioCompra, null);
		}
		return jPanelEtiquetas11;
	}

	/**
	 * This method initializes jPanelEtiquetas111
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas111() {
		if (jPanelEtiquetas111 == null) {
			GridLayout gridLayout311 = new GridLayout();
			gridLayout311.setRows(3);
			gridLayout311.setHgap(25);
			gridLayout311.setVgap(7);
			gridLayout311.setColumns(2);
			jPanelEtiquetas111 = new JPanel();
			jPanelEtiquetas111.setLayout(gridLayout311);
			jPanelEtiquetas111.setBounds(new Rectangle(211, 284, 120, 75));
			jPanelEtiquetas111.add(getjTextFieldTotalBruto(), null);
			jPanelEtiquetas111.add(getJTextFieldFecCaduca(), null);
			jPanelEtiquetas111.add(getJTextFieldPrecioCompra(), null);
		}
		return jPanelEtiquetas111;
	}

	/**
	 * This method initializes jPanelEtiquetas112
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas112() {
		if (jPanelEtiquetas112 == null) {
			jLabelPrecioVenta1 = new JLabel();
			jLabelPrecioVenta1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPrecioVenta1.setText("Precio de Socio :");
			jLabelPrecioVenta1.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout312 = new GridLayout();
			gridLayout312.setRows(3);
			gridLayout312.setHgap(25);
			gridLayout312.setVgap(7);
			gridLayout312.setColumns(2);
			jPanelEtiquetas112 = new JPanel();
			jPanelEtiquetas112.setLayout(gridLayout312);
			jPanelEtiquetas112.setBounds(new Rectangle(419, 60, 132, 85));
			jPanelEtiquetas112.add(jLabelPrecioVenta, null);
			jPanelEtiquetas112.add(jLabelPrecioVenta1, null);
		}
		return jPanelEtiquetas112;
	}

	/**
	 * This method initializes jPanelEtiquetas1121
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas1121() {
		if (jPanelEtiquetas1121 == null) {
			GridLayout gridLayout3121 = new GridLayout();
			gridLayout3121.setRows(3);
			gridLayout3121.setHgap(25);
			gridLayout3121.setVgap(7);
			gridLayout3121.setColumns(2);
			jPanelEtiquetas1121 = new JPanel();
			jPanelEtiquetas1121.setLayout(gridLayout3121);
			jPanelEtiquetas1121.setBounds(new Rectangle(569, 61, 122, 83));
			jPanelEtiquetas1121.add(getJTextFieldPrecioVenta(), null);
			jPanelEtiquetas1121.add(getJTextFieldPrecioVentaSocio(), null);
		}
		return jPanelEtiquetas1121;
	}

	/**
	 * This method initializes jTextFieldPrecioVentaSocio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecioVentaSocio() {
		if (jTextFieldPrecioVentaSocio == null) {
			jTextFieldPrecioVentaSocio = new JTextField();
			jTextFieldPrecioVentaSocio
					.setToolTipText("Ingrese el precio de Venta a consumidor Especial");
			jTextFieldPrecioVentaSocio.setText("0");
		}
		return jTextFieldPrecioVentaSocio;
	}

	/**
	 * This method initializes modelo
	 * 
	 * @return tableUtil.modeloTabla
	 */
	private modeloInventario getModelo() {
		if (modelo == null) {
			modelo = new modeloInventario();
		}
		return modelo;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(getModelo());
			jTable.setRowHeight(40);

			jTable.setRowHeight(40);
			// jTable.setRowSelectionAllowed(false);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(120);// cantidad
			jTable.getColumnModel().getColumn(1).setPreferredWidth(210);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(210);// medida
			jTable.getColumnModel().getColumn(3).setPreferredWidth(210);// precio
			jTable.getColumnModel().getColumn(4).setPreferredWidth(125);// precio

			renderTabla render = new renderTabla();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.setShowGrid(true);
			jTable
					.setToolTipText("Se puede Modificar el Subtotal y la Cantidad haciendo Doble click");

			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);

					if (modelo.getRowCount() > 0 && column == 04) {
						int res = pedirConfirmacion();

						if (res == 0 && modelo.getRowCount() > 0) {
							eliminarDetalle(row, column);
							modelo.borraItem(row);
							colocarTotal();
						}
					}

				}

			});

		}
		return jTable;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(46, 410, 630, 175));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	private detalleInventario validarItem() {
		detalleInventario item;
		try {
			float cantidad = Float.parseFloat(jTextFieldTotalBruto.getText());
			String FechaCaducidad = jTextFieldFecCaduca.getText().trim();
			String FechaIngreso = util.fechaActual();
			float precioCompra = Float.parseFloat(jTextFieldPrecioCompra
					.getText());

			item = new detalleInventario(cantidad, FechaCaducidad,
					FechaIngreso, precioCompra, new Boolean(true));

			if (util.compararFechasString(FechaCaducidad, FechaIngreso)) {
				item = null;

				JOptionPane.showMessageDialog(null, "La fecha de Caducidad"
						+ " debe ser superior a la fecha de Hoy! :", "Alerta!",
						JOptionPane.ERROR_MESSAGE);
			}
			if (jTextFieldPrecioCompra.getText().compareTo("0") == 0
					|| jTextFieldTotalBruto.getText().compareTo("0") == 0) {
				item = null;
				JOptionPane.showMessageDialog(null, "La cantidad o el precio"
						+ " de compra deben ser mayor a cero! :", "Alerta!",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception novalorFloat) {
			item = null;
		}
		return item;
	}

	/**
	 * Verifica que no haya repetidos en la lista
	 * 
	 * @param item
	 */
	private void buscarEnLista(detalleInventario item) {

		float cantidad = Float.parseFloat(jTextFieldTotalBruto.getText());
		String FechaCaducidad = jTextFieldFecCaduca.getText().trim();
		String FechaIngreso = util.fechaActual();
		float precioCompra = Float.parseFloat(jTextFieldPrecioCompra.getText());
		insertarLista = false;
		item = new detalleInventario(cantidad, FechaIngreso, FechaCaducidad,
				precioCompra, new Boolean(true));
		if (modelo.getValueAt(0, 1).toString().compareTo("" + FechaIngreso) == 0
				&& modelo.getValueAt(0, 2).toString().compareTo(
						"" + FechaCaducidad) == 0) {
			item = null;
		}
		for (int i = 0; i < modelo.getRowCount(); i++) {
			if (modelo.getValueAt(i, 1).toString().compareTo("" + FechaIngreso) == 0
					&& modelo.getValueAt(i, 2).toString().compareTo(
							"" + FechaCaducidad) == 0) {
				item = null;

			}
		}

		if (item != null) {
			modelo.nuevoItem(item);
			insertarLista = true;
		} else {
			JOptionPane
					.showMessageDialog(null,
							"No se puede agregar mas items de un lote existente!"
									+ " ", "Alerta!", JOptionPane.ERROR_MESSAGE);
		}

		if (modelo.getRowCount() != 0)
			colocarTotal();
	}// buscarEnLista

	/**
	 * coloca el total de items disponible de un producto
	 */
	public void colocarTotal() {
		float cantidad = 0;
		for (int i = 0; i < modelo.getRowCount(); i++) {
			cantidad = cantidad + (Float) modelo.getValueAt(i, 0);
		}
		jTextFieldCantidadDisponible.setText("" + cantidad);
	}

	/**
	 * valida el producto
	 */
	public void validarProducto() {

		inventarioDp.setDescripcion(jTextFieldDescripcion.getText().trim());
		inventarioDp.setIdProveedor(Integer.parseInt(""
				+ proveedoresHash.get("" + ChoiceProveedor.getSelectedItem())));
		inventarioDp.setIdTipoProducto(Integer.parseInt(""
				+ tipoProductoHash.get(""
						+ ChoiceTipoProducto.getSelectedItem())));
		inventarioDp.setUnidadDeMedida(Integer.parseInt(""
				+ unidadMedidaHash.get(""
						+ ChoiceUnidadDeMedida.getSelectedItem())));
		inventarioDp.setIdPagoRealizado(Integer.parseInt(""
				+ pagoRealizadoHash.get(""
						+ ChoiceReciboDeCompra.getSelectedItem())));
		inventarioDp.setIdBodega(Integer.parseInt(""
				+ bodegaHash.get("" + choiceBodega.getSelectedItem())));
		inventarioDp.setEquivalente(Float.parseFloat(""
				+ jTextFieldEquivalente.getText().trim()));
		inventarioDp.setPvp(Float.parseFloat(""
				+ jTextFieldPrecioVenta.getText().trim()));
		inventarioDp.setPvpSocio(Float.parseFloat(""
				+ jTextFieldPrecioVentaSocio.getText().trim()));
		System.out.print("\nprecioV: " + inventarioDp.getPvp());
		System.out.print("\nprecio V2: " + inventarioDp.getPvpSocio());

	}

	/**
	 * valida el detalle del producto
	 * 
	 */
	public void validarProductoDetalle() {
		// inventarioDetalleDP

	}

	/**
	 * dialogo de confirmacion de eliminacion
	 * 
	 * @return
	 */
	int pedirConfirmacion() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this,
				"Desea Eliminar el lote completo?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}

		return res;
	}

	public void eliminarDetalle(int row, int column) {
		if (opcionModulo == 1) {
			inventarioMd
					.buscarInfoDeUnRegistro(con.getConexion(), inventarioDp);
			InventarioDetalle inventarioDetalleDP1 = new InventarioDetalle(0,
					inventarioDp.getIdProducto(), (Float) modelo.getValueAt(
							row, 3), (Float) modelo.getValueAt(row, 0),
					(String) modelo.getValueAt(row, 1), (String) modelo
							.getValueAt(row, 2));
			inventarioMd.eliminarLote(con.getConexion(), inventarioDetalleDP1,
					UserActual);
		} else {

			InventarioDetalle inventarioDetalleDP1 = new InventarioDetalle(0,
					inventarioDp.getIdProducto(), (Float) modelo.getValueAt(
							row, 3), (Float) modelo.getValueAt(row, 0),
					(String) modelo.getValueAt(row, 1), (String) modelo
							.getValueAt(row, 2));
			inventarioMd.eliminarLote(con.getConexion(), inventarioDetalleDP1,
					UserActual);
		}

	}

	/**
	 * inserta un nuevo lote en la base de datos según el lote
	 * 
	 */
	private void insertarLote(detalleInventario item) {
		inventarioMd.buscarInfoDeUnRegistro(con.getConexion(), inventarioDp);
		InventarioDetalle inventarioDetalleDP1 = new InventarioDetalle(0,
				inventarioDp.getIdProducto(), item.getPrecioCompra(), item
						.getCantidad(), item.getFechaCaducidad(), item
						.getFechaIngreso());
		inventarioMd.insertarLote(con.getConexion(), inventarioDetalleDP1,
				UserActual);

	}

	public void verificarModificarConstructor(Boolean modificar1,
			String Descripcion1) {
		if (modificar1) {
			jTextFieldDescripcion.setText(Descripcion1);
			inventarioDp.setDescripcion(Descripcion1);
			buscarItem();

			// jButtonIngresar.setEnabled(false);
		}

	}

	/**
	 * crea una imagen en blanco para un producto
	 */
	public void crearImagenBlanco() {
		try {
			int numeroImagen = inventarioMd.maxIdProducto(con.getConexion());
			numeroImagen++;
			File fichero = new File("bin/productosIMG/" + numeroImagen + ".jpg");
			File ffile = new File("bin/images/sfoto.jpg");
			FileInputStream fis = new FileInputStream(ffile);
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(fichero));
			byte[] bytes = new byte[8096];
			int len = 0;

			while ((len = fis.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}

			out.flush();
			out.close();
			fis.close();

		} catch (IOException ec) {
			ec.fillInStackTrace();
		}
	}

	public float devolverTotalBruto() {
		float total = 0;
		try {
			if (modelo.getRowCount() > 0) {
				for (int i = 0; i < modelo.getRowCount(); i++) {
					total = total
							+ Float.parseFloat("" + modelo.getValueAt(i, 0));
				}
			}
		} catch (Exception nomunero) {

		}
		return total;

	}

	/**
	 * This method initializes jTextFieldCantidadDisponible1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidadDisponible1() {
		if (jTextFieldCantidadDisponible1 == null) {
			jTextFieldCantidadDisponible1 = new JTextField();
			jTextFieldCantidadDisponible1.setBounds(new Rectangle(552, 598, 76,
					21));
			jTextFieldCantidadDisponible1.setForeground(new Color(255, 0, 51));
			jTextFieldCantidadDisponible1.setToolTipText("Cantidad Disponible");
			jTextFieldCantidadDisponible1.setText("0");
			jTextFieldCantidadDisponible1.setEditable(false);
			jTextFieldCantidadDisponible1.setFont(new Font("Dialog", Font.BOLD,
					18));
		}
		return jTextFieldCantidadDisponible1;
	}

} // @jve:decl-index=0:visual-constraint="16,4"
