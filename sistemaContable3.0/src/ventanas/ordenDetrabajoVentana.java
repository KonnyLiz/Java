package ventanas;

import impresion.impresionOdtParametros;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.MaskFormatter;

import reportes.OdtLlenarForm;
import tableUtil.detalleOdtRecibo;
import tableUtil.modeloTabla;
import tableUtil.renderTabla;
import Utilitarios.utilitarios;
import clases.arregloClientesTempHash;
import clases.arregloTempTipoTrabajo;
import clases.cliente;
import clases.empleado;
import clases.ordenDeTrabajo;
import clases.ordenTrabajoDetalle;
import clasesBdd.clientesBdd;
import clasesBdd.conexionBdd;
import clasesBdd.empleadoBdd;
import clasesBdd.ordenTrabajoBdd;
import clasesBdd.tipoTrabajoBdd;
import clasesBdd.userBdd;

public class ordenDetrabajoVentana extends JInternalFrame {
	//public class ordenDetrabajoVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel Administraciónproveedor = null;
	private JPanel jPanelEtiquetas = null;
	private JLabel jLabelDescripcion = null;

	private JLabel jLabelBiuscar = null;
	private JTextField jTextFieldIdBusqueda = null;
	private Choice choiceOpcion = null;
	private JComboBox choiceItem = null;
	private JPanel jPanel = null;
	private JLabel jLabelDescripcion12 = null;
	private JTextField jTextFieldCantidad = null;
	private JButton jButton = null;
	private JLabel jLabelFecha = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private JLabel jLabelBiuscar1 = null;
	private JLabel jLabelBiuscar11 = null;
	private JTextField jTextFieldNombre = null;
	private JTextField jTextFieldRucCedula = null;
	private JLabel jLabelBiuscar111 = null;
	private JPanel jPanel2 = null;
	private JTextField jTextFieldImpresion = null;
	private JPanel jPanel21 = null;
	private JLabel jLabelBiuscar12 = null;
	private TextArea output = null;
	private JLabel jLabelDescripcion121 = null;
	private JLabel jLabelDescripcion1211 = null;
	private JLabel jLabelDescripcion12111 = null;
	private JTextField jTextFieldAbono = null;
	private JTextField jTextFieldSaldo = null;
	private JTextField jTextFieldTotal = null;
	private Choice choiceOpcionEncargado = null;
	private JLabel jLabelDescripcion111 = null;
	private JTextField jTextFieldMedidfax = null;
	private JTextField jTextFieldMedidaY = null;
	private JLabel jLabelDescripcion1121 = null;
	private JPanel jPanel22 = null;
	private JLabel jLabelBiuscar13 = null;
	private JLabel jLabelBiuscar1111 = null;
	private JTextField jTextFieldPrecio = null;
	private JLabel jLabelDescripcion122 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	JList jList11 = new JList();

	int rowTemp = 0;
	int columnTemp = 0;
	int idTablaOdt = 0;
	conexionBdd conn = new conexionBdd();
	tipoTrabajoBdd tipoTrabajoMd = new tipoTrabajoBdd(); // @jve:decl-index=0:
	empleadoBdd empleadoMd = new empleadoBdd(); // @jve:decl-index=0:
	clientesBdd clienteMd = new clientesBdd(); // @jve:decl-index=0:
	ordenTrabajoBdd ordenTMd = new ordenTrabajoBdd(); // @jve:decl-index=0:
	userBdd userMd = new userBdd();
	Hashtable tipoTrabajoIdDescrip = tipoTrabajoMd.seleccionarTablaHash(conn
			.getConexion(), "codigos"); // @jve:decl-index=0:
	Hashtable tipoTrabajoDescripId = tipoTrabajoMd.seleccionarTablaHash(conn
			.getConexion(), "Descripciones"); // @jve:decl-index=0:
	Hashtable empleadosIdDescrip = empleadoMd.seleccionarTablaHash(conn
			.getConexion(), "codigos"); // @jve:decl-index=0:
	Hashtable empleadosDescripId = empleadoMd.seleccionarTablaHash(conn
			.getConexion(), "Descripciones"); // @jve:decl-index=0:
	Hashtable<String, arregloClientesTempHash> clientesListaHash = clienteMd
			.seleccionarDatosClientesHashOdt(conn.getConexion()); // @jve:decl-index=0:
	Hashtable UsersTablaHashUserNamId = userMd.seleccionarUserNameIdTablaHash(
			conn.getConexion(), "descripcion"); // @jve:decl-index=0:
	// @jve:decl-index=0:
	boolean ventanaClienteAbierta = false;
	listaClientesRecibo lista = new listaClientesRecibo();

	/**
	 * Variables de usuario
	 */
	String usuarioActual = ""; // @jve:decl-index=0:
	cliente clienteDp = new cliente(0, "", "", "", "", "", "", ""); // @jve:decl-index=0:
	ordenDeTrabajo ordenDeTrabajoDP = new ordenDeTrabajo(0, 0, 0, "", "", 0,
			"", "", "", 0, 0, 0, ""); // @jve:decl-index=0:
	ordenTrabajoDetalle ordenTrabajoDetalleDP[] = {
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0),
			new ordenTrabajoDetalle(0, "", 0, 0, 0, 0, 0), }; // @jve:decl-index=0:

	// bug del primer item
	boolean primerItem = true;

	/**
	 * pruebas de la tabla
	 *
	 */
	modeloTabla modelo = new modeloTabla(); // @jve:decl-index=0:
	/**
	 * Detector de row cambiado
	 */
	int filaQueCambio = 0;

	private JPanel jPanel221 = null;
	private JPanel jPanel2211 = null;
	private JPanel jPanel23 = null;
	private JLabel jLabelBiuscar14 = null;
	private JTextField jTextFieldArchivo = null;
	private JButton jButton1 = null;
	private JLabel jLabelBiuscar141 = null;
	private JLabel jLabelBiuscar142 = null;
	private JTextField jTextFieldITelefono = null;
	private JButton jButtonAceptar = null;
	private JLabel jLabelDescripcion11211 = null;
	/**
	 * Opcion de Módulo para clientes
	 */
	Boolean ExisteCliente = true; // @jve:decl-index=0:
	int opcionModulo = 0;

	private JButton jButtonLimpiar = null;
	private JLabel jLabelFecha1 = null;
	private utilitarios util1 = null;  //  @jve:decl-index=0:
	private JButton jButtonImprimir = null;
	private JPanel jPanel22111 = null;
	private JButton jButtonVerReporte = null;
	private JButton jButtonBuscarCliente = null;
	private JScrollPane jScrollPane1Lista11 = null;  //  @jve:decl-index=0:visual-constraint="790,257"

	/**
	 * This is the default constructor
	 */
	//public ordenDetrabajoVentana() {
	public ordenDetrabajoVentana(String usuario) {

		super();
		usuarioActual = usuario;
		// usuarioActual="usera";//comentar
		initialize();
		// choiceOpcion.select(1);
		lista.setAlwaysOnTop(true);
		lista.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				jTextFieldRucCedula.setText(lista.devolverRuc());
				ventanaClienteAbierta = false;
				lista.cerrar();
				jTextFieldRucCedula.selectAll();
				jTextFieldRucCedula.requestFocus();
				jTextFieldRucCedula.transferFocus();

			}
		});

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {

		jList11.setBounds(new Rectangle(5000, 5, 280, 116));
		//jList11.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList11.setVisible(false);
		javax.swing.JScrollPane barra = new javax.swing.JScrollPane(jList11);

		jList11.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				jList11.setVisible(false);
			}
		});
		jList11
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent e) {

						jList11.transferFocus();

					}
				});
		jList11.addFocusListener(new java.awt.event.FocusAdapter() {

			public void focusLost(java.awt.event.FocusEvent e) {

				if (jTextFieldIdBusqueda.getText().trim() != "") {
					String Cadena = "" + jList11.getSelectedValue();

					if (Cadena
							.compareTo("No hay mas registros con esta Descripción") != 0) {

						buscarItem(Cadena);

					}
				}// if1jTextFieldIdBusqueda.getText().trim()!="
			}
		});
		this.setSize(766, 662);
		this.setContentPane(getJContentPane());
		this.setTitle(" Orden De Trabajo ");
		this.setClosable(true);
		this.setIconifiable(true);

	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFecha1 = new JLabel();
			jLabelFecha1.setBounds(new Rectangle(619, 55, 40, 23));
			jLabelFecha1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelFecha1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFecha1.setText("Fecha:");
			jLabelFecha1.setForeground(Color.blue);
			jLabelDescripcion11211 = new JLabel();
			jLabelDescripcion11211.setBounds(new Rectangle(488, 259, 21, 16));
			jLabelDescripcion11211
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion11211.setText("cm");
			jLabelDescripcion11211.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion122 = new JLabel();
			jLabelDescripcion122.setBounds(new Rectangle(497, 222, 82, 17));
			jLabelDescripcion122
					.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelDescripcion122.setText("PRECIO : $ ");
			jLabelDescripcion122.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelDescripcion1121 = new JLabel();
			jLabelDescripcion1121.setBounds(new Rectangle(382, 256, 11, 16));
			jLabelDescripcion1121
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion1121.setText("x");
			jLabelDescripcion1121.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion111 = new JLabel();
			jLabelDescripcion111.setBounds(new Rectangle(13, 427, 80, 23));
			jLabelDescripcion111
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion111.setText("Encargado A :");
			jLabelDescripcion111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion12111 = new JLabel();
			jLabelDescripcion12111
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion12111.setText("Saldo :$");
			jLabelDescripcion12111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion1211 = new JLabel();
			jLabelDescripcion1211
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion1211.setText("Total :$");
			jLabelDescripcion1211.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion121 = new JLabel();
			jLabelDescripcion121
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion121.setText("Abono :$");
			jLabelDescripcion121.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar111 = new JLabel();
			jLabelBiuscar111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar111.setText("IMPRESION :");
			jLabelBiuscar111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar11 = new JLabel();
			jLabelBiuscar11.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar11.setText("RUC/CEDULA :");
			jLabelBiuscar11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar1 = new JLabel();
			jLabelBiuscar1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar1.setText("Nombre :");
			jLabelBiuscar1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(662, 55, 75, 23));
			jLabelFecha.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelFecha.setText("" + util.fechaActual());
			jLabelFecha.setForeground(Color.blue);

			jLabelFecha.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDescripcion12 = new JLabel();
			jLabelDescripcion12.setBounds(new Rectangle(19, 222, 82, 22));
			jLabelDescripcion12.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion12.setText("Cantidad :");
			jLabelDescripcion12.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar = new JLabel();
			jLabelBiuscar.setBounds(new Rectangle(22, 36, 124, 26));
			jLabelBiuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar.setText("Escoja Una Opción :");
			jLabelBiuscar.setHorizontalAlignment(SwingConstants.RIGHT);
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-1, 10, 752, 24));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor
					.setText("Administración de Ordenes de Trabajo");
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(Administraciónproveedor, null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(jLabelBiuscar, null);
			jContentPane.add(getJTextFieldIdBusqueda(), null);
			jContentPane.add(getChoiceOpcion(), null);
			jContentPane.add(getChoiceItem(), null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(jLabelDescripcion12, null);
			jContentPane.add(getJTextFieldCantidad(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJPanel21(), null);
			jContentPane.add(getOutput(), null);
			jContentPane.add(getJTextFieldAbono(), null);
			jContentPane.add(getJTextFieldSaldo(), null);
			jContentPane.add(getJTextFieldTotal(), null);
			jContentPane.add(getChoiceOpcionEncargado(), null);
			jContentPane.add(jLabelDescripcion111, null);
			jContentPane.add(getJTextFieldMedidfax(), null);
			jContentPane.add(getJTextFieldMedidaY(), null);
			jContentPane.add(jLabelDescripcion1121, null);
			jContentPane.add(getJPanel22(), null);
			jContentPane.add(jLabelDescripcion, null);
			jContentPane.add(getJTextFieldPrecio(), null);
			jContentPane.add(jLabelDescripcion122, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJPanel221(), null);
			jContentPane.add(getJPanel2211(), null);
			jContentPane.add(jLabelDescripcion11211, null);
			jContentPane.add(jLabelFecha1, null);
			jContentPane.add(jList11, null);
			jContentPane.add(getJPanel22111(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelEtiquetas
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion.setText("Número de ODT:");
			jLabelDescripcion.setBounds(new Rectangle(50, 66, 97, 23));
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(25);
			gridLayout.setVgap(7);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(545, 6, 199, 42));
		}
		return jPanelEtiquetas;
	}

	/**
	 * This method initializes jTextFieldIdBusqueda
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIdBusqueda() {
		if (jTextFieldIdBusqueda == null) {
			jTextFieldIdBusqueda = new JTextField();
			jTextFieldIdBusqueda.setBounds(new Rectangle(155, 67, 120, 23));
			jTextFieldIdBusqueda.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldIdBusqueda.setForeground(new Color(254, 0, 0));
			jTextFieldIdBusqueda
					.setToolTipText("Ingrese el Id del Recibo para Buscar");
			jTextFieldIdBusqueda.setText("0");
			jTextFieldIdBusqueda.setEditable(true);
			jTextFieldIdBusqueda.setEnabled(true);
			jTextFieldIdBusqueda.setVisible(true);
			jTextFieldIdBusqueda
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							if (choiceOpcion.getSelectedItem().compareTo(
									"Modificar ODT") == 0) {
								jList11.setVisible(true);
								jList11.setLocation(
										jTextFieldIdBusqueda.getX(),
										jTextFieldIdBusqueda.getY() + 30);

							    jList11.setVisible(true);
								llenarListaOdt(jTextFieldIdBusqueda.getText()
										.trim());
							}
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);

						}
					});

		}
		return jTextFieldIdBusqueda;
	}

	/**
	 * This method initializes choiceOpcion
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceOpcion() {
		if (choiceOpcion == null) {
			choiceOpcion = new Choice();
			choiceOpcion.setBounds(new Rectangle(153, 38, 135, 25));

			choiceOpcion.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if (choiceOpcion.getSelectedItem().compareTo(
							"Seleccione una") != 0)
						if (choiceOpcion.getSelectedItem().compareTo(
								"Nueva ODT") == 0) {
							opcionModulo = 1;
							// jTextFieldIdBusqueda.setVisible(false);

						}
					if (choiceOpcion.getSelectedItem().compareTo(
							"Modificar ODT") == 0) {
						opcionModulo = 2;
						jButtonAceptar.setText("Modificar");
						jPanel.setVisible(false);

					}
					if (choiceOpcion.getSelectedItem()
							.compareTo("Eliminar ODT") == 0) {
						opcionModulo = 3;
						// jTextFieldIdBusqueda.setVisible(true);
						jButtonAceptar.setText("Eliminar");
					}
					choiceOpcion.setEnabled(false);
				}
			});
			choiceOpcion.addItem("Seleccione una");
			choiceOpcion.addItem("Nueva ODT");
			choiceOpcion.addItem("Modificar ODT");
			// choiceOpcion.addItem("Eliminar ODT");

		}
		return choiceOpcion;
	}

	/**
	 * This method initializes choiceItem
	 *
	 * @return java.awt.Choice
	 */
	private JComboBox getChoiceItem() {
		if (choiceItem == null) {
			choiceItem = new JComboBox();
			choiceItem.addItem("Seleccione uno");
			choiceItem.setBounds(new Rectangle(292, 222, 182, 21));
			choiceItem.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if (choiceItem.getSelectedItem().toString()
							.compareToIgnoreCase("Seleccione uno") != 0) {

						arregloTempTipoTrabajo arregloValoresItem = (arregloTempTipoTrabajo) tipoTrabajoDescripId
								.get(choiceItem.getSelectedItem());
						jTextFieldMedidfax.setText("1");
						jTextFieldMedidaY.setText("1");
						jTextFieldPrecio
								.setText("" + arregloValoresItem.precio);
						jTextFieldCantidad.setText("1");
					}
				}
			});
			cargarChoiceItems();
		}
		return choiceItem;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(1, 92, 743, 118));
			jPanel.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));

			jPanel.add(getJPanel2(), null);
			jPanel.add(getJTextFieldRucCedula(), null);
			jPanel.add(getJTextFieldNombre(), null);
			jPanel.add(getJTextFieldImpresion(), null);
			jPanel.add(getJPanel23(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJTextFieldArchivo(), null);
			jPanel.add(getJTextFieldITelefono(), null);
			jPanel.add(getJButtonBuscarCliente(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextFieldCantidad
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setText("1");
			jTextFieldCantidad.setBounds(new Rectangle(110, 220, 73, 24));
			jTextFieldCantidad
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldCantidad.selectAll();
						}
					});
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(""
							+ util.cortarCadenaFloat(jTextFieldCantidad
									.getText().trim()));
					try {
						Float.parseFloat(jTextFieldCantidad.getText().trim());

					} catch (Exception noflotante) {
						jTextFieldCantidad.setText("1");
					}
					jTextFieldPrecio.setText("" + valorarItem());
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);

				}
			});

		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(589, 256, 116, 22));
			jButton.setText("Añadir a Lista");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (choiceItem.getSelectedItem().toString().compareTo(
							"Seleccione uno") != 0) {
						if (modelo.getRowCount() > 10)
							JOptionPane.showMessageDialog(null,
									"No se pueden Ingresar mas Items!! ",
									"Alerta!", JOptionPane.ERROR_MESSAGE);
						else {
							detalleOdtRecibo item = validarItem();
							if (modelo.getRowCount() <= 0) {
								modelo.nuevoItem(item);
								jTextFieldTotal.setText(util
										.cortarCadenaFloat(jTextFieldPrecio
												.getText().trim()));
								jTextFieldSaldo.setText(""
										+ util.Redondear(""
												+ util.cortarCadenaFloat(""
														+ calcularSaldo()), 2));
							}

							else {
								buscarEnLista(item, false);
								jTextFieldSaldo.setText(""
										+ util.Redondear(""
												+ util.cortarCadenaFloat(""
														+ calcularSaldo()), 2));
							}

						}
					}

				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jTextFieldNombre
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldNombre.setForeground(new Color(254, 0, 0));
			jTextFieldNombre.setToolTipText("Ingrese el Nombre del Cliente!");
			jTextFieldNombre.setText("Consumidor Final");
			jTextFieldNombre.setEditable(true);
			jTextFieldNombre.setBounds(new Rectangle(112, 44, 230, 23));
			jTextFieldNombre.setEnabled(true);
			jTextFieldNombre
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldNombre.selectAll();
						}
					});
			jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					cliente clienteDP = new cliente(0, jTextFieldRucCedula
							.getText().trim(), "" + jTextFieldNombre.getText(),
							"", "", "", "", "");
					clientesBdd clienteMd = new clientesBdd();
					clienteDP = clienteMd.buscarInfoDeUnRegistroPorNombre(conn
							.getConexion(), clienteDP);
					if (clienteDP.getSexo() != "") {
						jTextFieldRucCedula.setText(clienteDP.getCiRuc());
						jTextFieldNombre.setText(clienteDP.getNombre());
						jTextFieldITelefono.setText(clienteDP.getTelefono());

						ExisteCliente = true;

					} else {
						// jTextFieldNombre.setText(" nombre del Nuevo
						// Cliente");
						ExisteCliente = false;

					}
				}
			});

		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldRucCedula
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRucCedula() {
		if (jTextFieldRucCedula == null) {
			jTextFieldRucCedula = new JTextField();
			jTextFieldRucCedula.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldRucCedula.setForeground(new Color(254, 0, 0));
			jTextFieldRucCedula
					.setToolTipText("Ingrese el Id del Recibo para Buscar");
			jTextFieldRucCedula.setText("00000000000");
			jTextFieldRucCedula.setEditable(true);
			jTextFieldRucCedula.setBounds(new Rectangle(112, 12, 119, 24));
			jTextFieldRucCedula.setEnabled(true);
			jTextFieldRucCedula.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(""
							+ util.cortarCadenaFloat(jTextFieldCantidad
									.getText().trim()));
					jTextFieldCantidad.setText(""
							+ util.cortarCadenaString(""
									+ jTextFieldCantidad.getText().trim(), 13));

				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldRucCedula
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldRucCedula.selectAll();
						}

						public void focusLost(java.awt.event.FocusEvent e) {
							cliente clienteDP = new cliente(0,
									jTextFieldRucCedula.getText().trim(), "",
									"", "", "", "", "");
							clientesBdd clienteMd = new clientesBdd();
							clienteDP = clienteMd.buscarInfoDeUnRegistro(conn
									.getConexion(), clienteDP);
							System.out.print("Sexo:" + clienteDP.getSexo());
							if (clienteDP.getSexo().compareTo("") != 0) {
								jTextFieldNombre.setText(clienteDP.getNombre());
								jTextFieldITelefono.setText(clienteDP
										.getTelefono());
								ExisteCliente = true;

							} else {
								jTextFieldNombre
										.setText(" nombre del Nuevo Cliente");
								ExisteCliente = false;

							}

						}
					});

		}
		return jTextFieldRucCedula;
	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(3);
			gridLayout2.setVgap(10);
			gridLayout2.setHgap(10);
			jPanel2 = new JPanel();
			jPanel2.setBounds(new Rectangle(10, 14, 96, 85));
			jPanel2.setLayout(gridLayout2);
			jPanel2.add(jLabelBiuscar11, null);
			jPanel2.add(jLabelBiuscar1, null);
			jPanel2.add(jLabelBiuscar111, null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jTextFieldImpresion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldImpresion() {
		if (jTextFieldImpresion == null) {
			jTextFieldImpresion = new JTextField();
			jTextFieldImpresion.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldImpresion.setForeground(new Color(254, 0, 0));
			jTextFieldImpresion
					.setToolTipText("Especifique una descripción para los materiales a usar");
			jTextFieldImpresion.setEditable(true);
			jTextFieldImpresion.setBounds(new Rectangle(111, 77, 220, 24));
			jTextFieldImpresion.setEnabled(true);
			jTextFieldNombre
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldNombre.selectAll();
						}
					});
			jTextFieldImpresion.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldImpresion.setText(""
							+ util.cortarCadenaString(jTextFieldImpresion
									.getText(), 30));
				}
			});
			jTextFieldImpresion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldImpresion.selectAll();
						}
					});
		}
		return jTextFieldImpresion;
	}

	/**
	 * This method initializes jPanel21
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			jLabelBiuscar12 = new JLabel();
			jLabelBiuscar12.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar12.setText("Observación :");
			jLabelBiuscar12.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout21 = new GridLayout();
			gridLayout21.setRows(3);
			gridLayout21.setVgap(10);
			gridLayout21.setHgap(10);
			jPanel21 = new JPanel();
			jPanel21.setLayout(gridLayout21);
			jPanel21.setBounds(new Rectangle(13, 506, 79, 82));
			jPanel21.add(jLabelBiuscar12, null);
		}
		return jPanel21;
	}

	/**
	 * This method initializes output
	 *
	 * @return java.awt.TextArea
	 */
	private TextArea getOutput() {
		if (output == null) {
			output = new TextArea();
			output.setBounds(new Rectangle(101, 508, 610, 71));
		}
		return output;
	}

	/**
	 * This method initializes jTextFieldAbono
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldAbono() {
		if (jTextFieldAbono == null) {
			jTextFieldAbono = new JTextField();
			jTextFieldAbono.setText("0");
			jTextFieldAbono.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldAbono.setForeground(new Color(254, 0, 0));

			jTextFieldAbono.setBounds(new Rectangle(442, 429, 73, 24));
			jTextFieldAbono.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldAbono.setText(""
							+ util.cortarCadenaFloat(jTextFieldAbono.getText()
									.trim()));

					jTextFieldSaldo.setText(""
							+ util.Redondear(""
									+ util.cortarCadenaFloat(""
											+ calcularSaldo()), 2));

				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});

		}
		return jTextFieldAbono;
	}

	/**
	 * This method initializes jTextFieldSaldo
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldSaldo() {
		if (jTextFieldSaldo == null) {
			jTextFieldSaldo = new JTextField();
			jTextFieldSaldo.setText("0");
			jTextFieldSaldo.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldSaldo.setForeground(new Color(254, 0, 0));
			jTextFieldSaldo.setEditable(false);
			jTextFieldSaldo.setBounds(new Rectangle(647, 430, 73, 24));

		}
		return jTextFieldSaldo;
	}

	/**
	 * This method initializes jTextFieldTotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTotal() {
		if (jTextFieldTotal == null) {
			jTextFieldTotal = new JTextField();
			jTextFieldTotal.setBounds(new Rectangle(647, 466, 93, 29));
			jTextFieldTotal.setText("0");
			jTextFieldTotal.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldTotal.setEditable(false);
			jTextFieldTotal.setForeground(new Color(254, 0, 0));

		}
		return jTextFieldTotal;
	}

	/**
	 * This method initializes choiceOpcionEncargado
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceOpcionEncargado() {
		if (choiceOpcionEncargado == null) {
			choiceOpcionEncargado = new Choice();
			choiceOpcionEncargado.setBounds(new Rectangle(99, 429, 155, 21));
			cargarChoiceEmpleados();
		}
		return choiceOpcionEncargado;
	}

	/**
	 * This method initializes jTextFieldMedidfax
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldMedidfax() {
		if (jTextFieldMedidfax == null) {
			jTextFieldMedidfax = new JTextField();
			jTextFieldMedidfax.setText("1");
			jTextFieldMedidfax.setBounds(new Rectangle(294, 253, 85, 24));
			jTextFieldMedidfax
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldMedidfax.selectAll();
						}
					});
			jTextFieldMedidfax.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldMedidfax.setText(""
							+ util.cortarCadenaFloat(jTextFieldMedidfax
									.getText().trim()));
					jTextFieldPrecio.setText("" + valorarItem());
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);

				}// key typed
			});
		}
		return jTextFieldMedidfax;
	}

	/**
	 * This method initializes jTextFieldMedidaY
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldMedidaY() {
		if (jTextFieldMedidaY == null) {
			jTextFieldMedidaY = new JTextField();
			jTextFieldMedidaY.setBounds(new Rectangle(400, 253, 85, 24));
			jTextFieldMedidaY.setText("1");
			jTextFieldMedidaY
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldMedidaY.selectAll();
						}
					});
			jTextFieldMedidaY.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldMedidaY.setText(""
							+ util.cortarCadenaFloat(jTextFieldMedidaY
									.getText().trim()));
					jTextFieldPrecio.setText("" + valorarItem());
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						jButton.doClick();

					}
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
					jTextFieldPrecio.setText("" + valorarItem());
				}
			});

		}
		return jTextFieldMedidaY;
	}

	/**
	 * This method initializes jPanel22
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel22() {
		if (jPanel22 == null) {
			jLabelBiuscar1111 = new JLabel();
			jLabelBiuscar1111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar1111.setText("Medidas :");
			jLabelBiuscar1111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar13 = new JLabel();
			jLabelBiuscar13.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar13.setText("ITEM :");
			jLabelBiuscar13.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout22 = new GridLayout();
			gridLayout22.setRows(2);
			gridLayout22.setVgap(10);
			gridLayout22.setHgap(10);
			jPanel22 = new JPanel();
			jPanel22.setLayout(gridLayout22);
			jPanel22.setBounds(new Rectangle(197, 221, 90, 55));
			jPanel22.add(jLabelBiuscar13, null);
			jPanel22.add(jLabelBiuscar1111, null);
		}
		return jPanel22;
	}

	/**
	 * This method initializes jTextFieldPrecio
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecio() {
		if (jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setBounds(new Rectangle(586, 222, 84, 24));
			jTextFieldPrecio.setText("0");
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldPrecio.setText(""
							+ util.cortarCadenaFloat(jTextFieldPrecio.getText()
									.trim()));
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						jButton.doClick();
					}
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);

				}
			});
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(21, 278, 700, 139));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(modelo);
			jTable.setRowHeight(40);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable
					.setToolTipText("Se puede Modificar el Subtotal y la Cantidad haciendo Doble click");
			jTable.getModel().addTableModelListener(new TableModelListener() {

				public void tableChanged(TableModelEvent e) {
					filaQueCambio = e.getLastRow();
				}
			});

			jTable.setRowSelectionAllowed(false);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(80);// cantidad
			jTable.getColumnModel().getColumn(1).setPreferredWidth(210);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(110);// medida
			jTable.getColumnModel().getColumn(3).setPreferredWidth(100);// precio
			// u
			jTable.getColumnModel().getColumn(4).setPreferredWidth(125);// precio
			// t
			jTable.getColumnModel().getColumn(5).setPreferredWidth(50);// elim
			renderTabla render = new renderTabla();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);

			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);
					rowTemp = row;
					columnTemp = column;
					if (modelo.getRowCount() > 0 && column == 05) {
						int res = pedirConfirmacion();
						if (res == 0) {
							modelo.borraItem(row);
							JOptionPane.showMessageDialog(null,
									"Item Eliminado! ", "Aviso!",
									JOptionPane.INFORMATION_MESSAGE);
							colocarTotal();
							jTextFieldSaldo.setText(""
									+ util.Redondear(""
											+ util.cortarCadenaFloat(""
													+ calcularSaldo()), 2));
						}
					}

				}

			});

			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					float precioU = (Float) modelo.getValueAt(filaQueCambio, 3);
					float nuevaCantidad = (Float) modelo.getValueAt(
							filaQueCambio, 0);
					float subtotal = precioU * nuevaCantidad;

					String descripcion = (String) modelo.getValueAt(
							filaQueCambio, 1);
					String medida = (String) modelo
							.getValueAt(filaQueCambio, 2);
					detalleOdtRecibo nuevoItem = new detalleOdtRecibo(
							nuevaCantidad, descripcion, medida, precioU,
							subtotal, new Boolean(true));
					buscarEnLista(nuevoItem, true);
					jTextFieldSaldo.setText(""
							+ util.Redondear(""
									+ util.cortarCadenaFloat(""
											+ calcularSaldo()), 2));
				}
			});
		}
		return jTable;
	}

	/**
	 * This method initializes jPanel221
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel221() {
		if (jPanel221 == null) {
			GridLayout gridLayout221 = new GridLayout();
			gridLayout221.setRows(2);
			gridLayout221.setVgap(10);
			gridLayout221.setHgap(10);
			jPanel221 = new JPanel();
			jPanel221.setLayout(gridLayout221);
			jPanel221.setBounds(new Rectangle(522, 427, 120, 69));
			jPanel221.add(jLabelDescripcion12111, null);
			jPanel221.add(jLabelDescripcion1211, null);
		}
		return jPanel221;
	}

	/**
	 * This method initializes jPanel2211
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2211() {
		if (jPanel2211 == null) {
			GridLayout gridLayout2211 = new GridLayout();
			gridLayout2211.setRows(2);
			gridLayout2211.setVgap(10);
			gridLayout2211.setHgap(10);
			jPanel2211 = new JPanel();
			jPanel2211.setLayout(gridLayout2211);
			jPanel2211.setBounds(new Rectangle(308, 429, 126, 68));
			jPanel2211.add(jLabelDescripcion121, null);
		}
		return jPanel2211;
	}

	/**
	 * This method initializes jPanel23
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jLabelBiuscar142 = new JLabel();
			jLabelBiuscar142.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar142.setText("Teléfono :");
			jLabelBiuscar142.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar141 = new JLabel();
			jLabelBiuscar141.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar141.setText("");
			jLabelBiuscar141.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar14 = new JLabel();
			jLabelBiuscar14.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar14.setText("Archivo :");
			jLabelBiuscar14.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout23 = new GridLayout();
			gridLayout23.setRows(3);
			gridLayout23.setVgap(10);
			gridLayout23.setHgap(10);
			jPanel23 = new JPanel();
			jPanel23.setBounds(new Rectangle(450, 17, 107, 94));
			jPanel23.setLayout(gridLayout23);
			jPanel23.add(jLabelBiuscar14, null);
			jPanel23.add(jLabelBiuscar141, null);
			jPanel23.add(jLabelBiuscar142, null);
		}
		return jPanel23;
	}

	/**
	 * This method initializes jTextFieldArchivo
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldArchivo() {
		if (jTextFieldArchivo == null) {
			jTextFieldArchivo = new JTextField();
			jTextFieldArchivo.setFont(new Font("Dialog", Font.PLAIN, 15));
			jTextFieldArchivo.setForeground(new Color(254, 0, 0));
			jTextFieldArchivo
					.setToolTipText("Ingrese el Id del Recibo para Buscar");
			jTextFieldArchivo.setText("");
			jTextFieldArchivo.setEditable(true);
			jTextFieldArchivo.setBounds(new Rectangle(572, 17, 167, 25));
			jTextFieldArchivo.setEnabled(true);
			jTextFieldArchivo
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldArchivo.selectAll();
						}
					});
			jTextFieldArchivo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldArchivo.setText(""
							+ util.cortarCadenaString(jTextFieldArchivo
									.getText().trim(), 254));
				}
			});
		}
		return jTextFieldArchivo;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar Archivo");
			jButton1.setBounds(new Rectangle(609, 44, 129, 24));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String nombreArchivo = cargarfotoDiscoDuro("bufferBank");

						jTextFieldArchivo.setText(nombreArchivo);
					} catch (Exception ed) {
						ed.printStackTrace();
					}
				}
			});
		}
		return jButton1;
	}

	public String cargarfotoDiscoDuro(String ArchSalida) {

		String nombredelaImagen = null;
		Frame parent = new Frame();
		parent.setSize(new Dimension(124, 135));
		FileDialog fd = new FileDialog(parent, "Seleecione un archivo:",
				FileDialog.LOAD);
		fd.setDirectory("c:\\");
		fd.setVisible(true);
		String selectedItem = fd.getFile();
		if (selectedItem == null) {
			JOptionPane.showMessageDialog(null,
					"No se ha seleccionado un archivo!", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		} else {
			File ffile = new File(fd.getDirectory() + File.separator
					+ fd.getFile());
			nombredelaImagen = fd.getDirectory() + File.separator
					+ fd.getFile();

		}
		return nombredelaImagen;
	}// end cargar foto

	public float calcular(modeloTabla modelo) {
		float result = 0;
		result = (Float) modelo.getValueAt(rowTemp, 0)
				* (Float) modelo.getValueAt(rowTemp, 3);
		return result;
	}

	/**
	 * This method initializes jTextFieldITelefono
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldITelefono() {
		if (jTextFieldITelefono == null) {
			try {
				MaskFormatter mascara = new MaskFormatter(
						"(##)###-####/(##)###-####");
				jTextFieldITelefono = new JFormattedTextField(mascara);
				jTextFieldITelefono.setText("(02)222-2222/(09)999-9999");
				jTextFieldITelefono.setBounds(new Rectangle(575, 86, 161, 25));
				jTextFieldITelefono
						.setToolTipText("Ingrese el número o números de teléfono");
				jTextFieldITelefono
						.addFocusListener(new java.awt.event.FocusAdapter() {
							public void focusGained(java.awt.event.FocusEvent e) {
								jTextFieldITelefono.selectAll();
							}
						});

				jTextFieldITelefono
						.addFocusListener(new java.awt.event.FocusAdapter() {
							public void focusLost(java.awt.event.FocusEvent e) {

								if (jTextFieldITelefono.getText().compareTo("") != 0) {
									jTextFieldITelefono.setEnabled(true);
									jTextFieldITelefono.transferFocus();
								}
							}
						});

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jTextFieldITelefono;
	}

	public void cargarChoiceEmpleados() {
		Object[] descripciones = empleadosDescripId.keySet().toArray();
		for (int i = 0; i < descripciones.length; i++) {
			choiceOpcionEncargado.addItem((String) descripciones[i]);
		}
	}// end cargarChoiceEmpleados

	public void cargarChoiceItems() {
		Object[] descripciones = tipoTrabajoDescripId.keySet().toArray();
		for (int i = 0; i < descripciones.length; i++) {
			choiceItem.addItem((String) descripciones[i]);
		}
	}// end cargarChoiceItems

	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setEnabled(true);
			jButtonAceptar.setName("jButtonAceptar");
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							jTextFieldSaldo.setText("" + calcularSaldo());

							if (jTextFieldIdBusqueda.getText().compareTo("0") != 0) {

								if (modelo.getRowCount() == 0
										|| opcionModulo == 0) {
									JOptionPane
											.showMessageDialog(
													null,
													"La orden de trabajo no tiene Items!, o no se selecciono una opción para la ODT",
													"Aviso",
													JOptionPane.ERROR_MESSAGE);

								} else {
									validar();

									if (opcionModulo == 1) {
										if (!ExisteCliente) {
											clienteDp.setIdTc(2);
											clienteDp.setSexo("Masculino");
											clienteMd.insertar(conn
													.getConexion(), clienteDp);
											/*
											 * System.out.print("Cliente:");
											 * System.out.print("\nruc:"+clienteDp.getCiRuc());
											 * System.out.print("\ntipo:"+clienteDp.getIdTc());
											 * System.out.print("\nNombre:"+clienteDp.getNombre());
											 * System.out.print("\nsexo:"+clienteDp.getSexo());
											 */

										}
										/*
										 * System.out.print("\nODT Cabeza:");
										 * System.out.print("\nODT
										 * Ci_ruc:"+ordenDeTrabajoDP.getCiRuc());
										 * System.out.print("\nODT
										 * Numero:"+ordenDeTrabajoDP.getNumeroOrdenTrabajo());
										 * System.out.print("\nODT
										 * ID:"+ordenDeTrabajoDP.getIdOrdenDeTrabajo());
										 */
										// System.out.print("\nODT
										// Cabeza:"+ordenDeTrabajoDP.get);
										ordenTMd.insertar(conn.getConexion(),
												ordenDeTrabajoDP);
										for (int i = 0; i < modelo
												.getRowCount(); i++) {
											float cantidadItem = (Float) ordenTrabajoDetalleDP[i]
													.getCantidad();
											for (int j = 0; j < cantidadItem; j++)
												ordenTMd
														.insertarDetalle(
																conn
																		.getConexion(),
																ordenTrabajoDetalleDP[i]);

										}
										jButtonAceptar.setEnabled(false);
										jButtonVerReporte.setEnabled(true);
										jButtonImprimir.setEnabled(true);

									}
									if (opcionModulo == 2) {
										ordenDeTrabajoDP
												.setIdOrdenDeTrabajo(idTablaOdt);
										ordenTMd.modificar(conn.getConexion(),
												ordenDeTrabajoDP);

										ordenTrabajoDetalleDP[0]
												.setIdOtNoUser(idTablaOdt);
										ordenTMd.eliminarDetalle(conn
												.getConexion(),
												ordenTrabajoDetalleDP[0]);
										for (int i = 0; i < modelo
												.getRowCount(); i++) {
											float cantidadItem = (Float) ordenTrabajoDetalleDP[i]
													.getCantidad();
											for (int j = 0; j < cantidadItem; j++) {
												ordenTrabajoDetalleDP[i]
														.setIdOtNoUser(idTablaOdt);
												ordenTMd
														.insertarDetalle(
																conn
																		.getConexion(),
																ordenTrabajoDetalleDP[i]);

											}
										}
										jButtonAceptar.setEnabled(false);
										jButtonVerReporte.setEnabled(true);
										jButtonImprimir.setEnabled(true);
									}
									if (opcionModulo == 3) {
										idTablaOdt = Integer
												.parseInt(jTextFieldIdBusqueda
														.getText().trim());
										calcularSaldo();
										System.out.println("ID TABLA:"
												+ idTablaOdt);
										ordenTrabajoDetalleDP[0]
												.setIdOtNoUser(idTablaOdt);
										ordenDeTrabajoDP
												.setIdUsuario(idTablaOdt);
										ordenTMd.eliminarDetalle(conn
												.getConexion(),
												ordenTrabajoDetalleDP[0]);
										ordenTMd.eliminar(conn.getConexion(),
												ordenDeTrabajoDP);
										jButtonAceptar.setEnabled(false);
									}

								}
							} else {
								JOptionPane
										.showMessageDialog(
												null,
												"Ingrese el número de la Orden de Trabajo!",
												"Aviso",
												JOptionPane.ERROR_MESSAGE);
							}
						}
					});
		}
		return jButtonAceptar;
	}

	/**
	 * validad las clases cliente y orden de trabajo ingresadas
	 */
	public void validar() {
		calcularSaldo();
		/**
		 * user
		 */
		// System.out.print(usuarioActual);
		ordenDeTrabajoDP.setIdUsuario((Integer) UsersTablaHashUserNamId
				.get(usuarioActual));

		/**
		 * Cliente
		 */
		clienteDp.setCiRuc(jTextFieldRucCedula.getText().trim());
		clienteDp.setNombre(jTextFieldNombre.getText().trim());
		clienteDp.setTelefono(jTextFieldITelefono.getText().trim());
		clienteDp.setClienteDesde(jLabelFecha.getText());
		/**
		 * ODT
		 */
		if (opcionModulo == 1)
			ordenDeTrabajoDP.setIdOrdenDeTrabajo(ordenTMd.idParaNuevaOdt(conn
					.getConexion()));
		if (opcionModulo == 2)
			ordenDeTrabajoDP.setIdOrdenDeTrabajo(Integer
					.parseInt(jTextFieldIdBusqueda.getText().trim()));
		if (opcionModulo == 1 || opcionModulo == 2)
			ordenDeTrabajoDP.setNumeroOrdenTrabajo(Integer
					.parseInt(jTextFieldIdBusqueda.getText().trim()));
		ordenDeTrabajoDP.setCiRuc(jTextFieldRucCedula.getText().trim());
		ordenDeTrabajoDP
				.setNombredelArchivo(jTextFieldArchivo.getText().trim());
		ordenDeTrabajoDP.setImpresion(jTextFieldImpresion.getText().trim());
		ordenDeTrabajoDP.setIdEmpleadoDiseñador((Integer) empleadosDescripId
				.get(choiceOpcionEncargado.getSelectedItem()));
		ordenDeTrabajoDP.setObservacion(output.getText());
		ordenDeTrabajoDP.setAbono(Float.parseFloat(jTextFieldAbono.getText()
				.trim()));
		ordenDeTrabajoDP.setSaldo(Float.parseFloat(jTextFieldSaldo.getText()
				.trim()));
		ordenDeTrabajoDP.setPrecio(Float.parseFloat(jTextFieldTotal.getText()
				.trim()));
		ordenDeTrabajoDP.setFecha(jLabelFecha.getText());
		if (opcionModulo == 3) {
			ordenDeTrabajoDP.setEstado("ELIMINADO");
		} else {
			ordenDeTrabajoDP.setEstado("PENDIENTE");
		}

		/**
		 * detalle de la ODT
		 */
		limpiarDetalleClase();
		for (int i = 0; i < modelo.getRowCount(); i++) {
			ordenTrabajoDetalleDP[i].setCantidad((Float) modelo
					.getValueAt(i, 0));
			ordenTrabajoDetalleDP[i].setDescripcion(""
					+ modelo.getValueAt(i, 1));
			int xPos = modelo.getValueAt(i, 2).toString().lastIndexOf("x");
			float medidaX = Float.parseFloat(modelo.getValueAt(i, 2).toString()
					.substring(0, xPos));
			float medidaY = Float.parseFloat(modelo.getValueAt(i, 2).toString()
					.substring((xPos + 1),
							modelo.getValueAt(i, 2).toString().length()));
			ordenTrabajoDetalleDP[i].setMedidaX(medidaX);
			ordenTrabajoDetalleDP[i].setMedidaY(medidaY);
			ordenTrabajoDetalleDP[i].setPrecio((Float) modelo.getValueAt(i, 3));
			ordenTrabajoDetalleDP[i].setIdOtNoUser(ordenDeTrabajoDP
					.getIdOrdenDeTrabajo());

		}
	}// validar

	/**
	 * dialogo de confirmacion de eliminacion
	 *
	 * @return
	 */
	int pedirConfirmacion() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this, "Desea Eliminar el Item?",
				"Confirmar acción", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}

		return res;
	}

	/**
	 * calcula el precio de un trabajo según medidas introducidas si es menor a
	 * 1 devuelve de la tabla el valor mínimo del trabajo
	 *
	 * @return
	 */
	private float valorarItem() {
		float valorItem = 0;
		try {
			float medidaObtenida = ((Float.parseFloat(jTextFieldMedidfax
					.getText()) * Float.parseFloat(jTextFieldMedidaY.getText())));

			arregloTempTipoTrabajo arregloValoresItem = (arregloTempTipoTrabajo) tipoTrabajoDescripId
					.get(choiceItem.getSelectedItem());
			if (medidaObtenida <= 1) {

				float precioObtenido = arregloValoresItem.precioMin;
				float precioObteidoxCantidad = Float
						.parseFloat(jTextFieldCantidad.getText())
						* precioObtenido;
				valorItem = precioObteidoxCantidad;

			} else {
				float precioObtenido = ((Float.parseFloat("" + medidaObtenida) * Float
						.parseFloat("" + arregloValoresItem.precio)));
				float precioObteidoxCantidad = Float
						.parseFloat(jTextFieldCantidad.getText())
						* precioObtenido;
				valorItem = precioObteidoxCantidad;
			}
		} catch (Exception noFloat) {

		}
		return valorItem;
	}// end valorar item

	/**
	 * calcula el saldo para el textfield abono
	 *
	 * @return
	 */
	private float calcularSaldo() {
		float saldo = 0;
		try {

			saldo = Float.parseFloat(jTextFieldTotal.getText())
					- Float.parseFloat(jTextFieldAbono.getText());

		} catch (Exception ex) {
			saldo = 0;
		}
		return saldo;
	}// calcular saldo

	/**
	 * Verifica el item a ser insertado en la grilla
	 *
	 * @return
	 */

	private detalleOdtRecibo validarItem() {
		detalleOdtRecibo item;
		try {
			float cantidad = Float.parseFloat(jTextFieldCantidad.getText());
			String descripcion = choiceItem.getSelectedItem().toString();
			String medidas = "" + jTextFieldMedidfax.getText() + "x"
					+ jTextFieldMedidaY.getText();
			float precioUnitario = Float.parseFloat(jTextFieldPrecio.getText())
					/ cantidad;
			precioUnitario = util.Redondear("" + precioUnitario, 2);
			float subT = Float.parseFloat(jTextFieldPrecio.getText());
			subT = util.Redondear("" + subT, 2);
			item = new detalleOdtRecibo(cantidad, descripcion, medidas,
					precioUnitario, subT, new Boolean(true));
		} catch (Exception novalorFloat) {
			item = new detalleOdtRecibo(0, "asdasd", "121x12", 0, 0,
					new Boolean(true));
		}
		return item;
	}

	/**
	 * Verifica que no haya repetidos en la lista
	 *
	 * @param item
	 */
	private void buscarEnLista(detalleOdtRecibo item, Boolean cambioFila) {

		boolean bandera = true;// si es tru inserta nueva
		if (cambioFila == true) {
			modelo.borraItem(filaQueCambio);
			modelo.nuevoItemEnPosicion(item, filaQueCambio);
		} else {

			for (int i = 0; i < modelo.getRowCount(); i++) {
				float cantidad = Float.parseFloat(jTextFieldCantidad.getText());
				float cantidadAnt = (Float) modelo.getValueAt(i, 0);
				float cantidadFinal = cantidad + cantidadAnt;// nueva cant 0
				String Descripcion = (String) modelo.getValueAt(i, 1);// descrip
				// 1
				String medidas = "" + jTextFieldMedidfax.getText() + "x"
						+ jTextFieldMedidaY.getText(); // medida 2
				float valorUnitario = (Float) modelo.getValueAt(i, 3);// valor
				// unitario
				// 3
				float subtotal = valorUnitario * cantidadFinal;// subtotal 4
				int posicion = i;
				if (choiceItem.getSelectedItem().toString().compareTo(
						"" + modelo.getValueAt(i, 1)) == 0
						&& medidas.compareTo("" + modelo.getValueAt(i, 2)) == 0
						&& bandera == true) {
					modelo.borraItem(i);
					detalleOdtRecibo nuevoItem = new detalleOdtRecibo(
							cantidadFinal, Descripcion, medidas, valorUnitario,
							subtotal, new Boolean(true));
					modelo.nuevoItemEnPosicion(nuevoItem, posicion);
					bandera = false;
				}

			}
			if (bandera == true) {
				modelo.nuevoItem(item);
			}
		}

		colocarTotal();
	}// buscarEnLista

	/**
	 * Suma el total de todos los items y lo coloca en el textfield total
	 */

	private void colocarTotal() {
		float total = 0;

		for (int i = 0; i < modelo.getRowCount(); i++) {

			total = total + (Float) modelo.getValueAt(i, 4);

		}
		total = Float.parseFloat("" + util.cortarCadenaFloat("" + total));
		jTextFieldTotal.setText("" + total);
	}// colocarTotal

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
					.setToolTipText("Limpia los campos de la Orden de Trabajo");
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
	 * reinicia el módulo para empezar de 0
	 */

	private void limpiar() {
	//	 ordenDetrabajoVentana OdtVentana= new ordenDetrabajoVentana();

		ordenDetrabajoVentana OdtVentana = new ordenDetrabajoVentana(
				this.usuarioActual);
		OdtVentana.getPreferredSize();
		OdtVentana.setLocation(this.getX(), this.getY());
		this.getParent().add(OdtVentana);
		this.dispose();

		OdtVentana.setVisible(true);
	}// limpiar

	/**
	 * limpia la clase para almacenar nuevos objetos
	 */
	public void limpiarDetalleClase() {
		for (int i = 0; i < ordenTrabajoDetalleDP.length; i++) {
			ordenTrabajoDetalleDP[i] = new ordenTrabajoDetalle(0, "", 0, 0, 0,
					0, 0);
		}

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
	 * Busca una ODT de la Base De Datos
	 */
	private void buscarOdt() {

	}

	/**
	 * Llena una lista con objetos de manera dinámica
	 *
	 * @param numeroOdt
	 */
	void llenarListaOdt(String numeroOdt) {
		int bandera = 0;
		jList11.setEnabled(true);
		jList11.removeAll();
		jList11.setVisible(true);
		jList11.setBackground(Color.white);
		Object[][] listaDeOdtBusqueda = ordenTMd.seleccionarOdtLista(conn
				.getConexion(), numeroOdt);

		if (listaDeOdtBusqueda != null) {

			Object lista[] = new Object[listaDeOdtBusqueda.length];
			for (int i = 0; i < listaDeOdtBusqueda.length - 1; i++) {

				if (listaDeOdtBusqueda[i][0] == null) {
					lista[i] = "No hay mas registros con esta Descripción";
					i = listaDeOdtBusqueda.length;
				} else
					lista[i] = listaDeOdtBusqueda[i][0];

			}
			jList11.setListData(lista);
		}

	}

	/**
	 * Busca un regisro en la Bdd y pobla la jTable
	 *
	 */
	private modeloTabla buscarItem(String busqueda) {

		Object[][] listaModelo = null;


		Object[][] listaDeOdtBusqueda = ordenTMd.seleccionarOdtLista(conn
				.getConexion(), jTextFieldIdBusqueda.getText().trim());
		jTextFieldIdBusqueda.setEnabled(false);
		Boolean continuar = true;
		int i = 0;
		int numeroOdtTabla = 0;
		while (continuar) {
			String ItemdeLista = listaDeOdtBusqueda[i][0].toString();// verifica

			// si es
			// el
			// requerido

			if (ItemdeLista.compareTo(busqueda) == 0) {
				numeroOdtTabla = Integer
						.parseInt((String) listaDeOdtBusqueda[i][1]);// saca
				// de el
				// arreglo
				// el #
				// de id
				idTablaOdt = numeroOdtTabla;
				continuar = false;
			}// if
			i++;
			if (i > 20)
				continuar = false;
		}// while

		listaModelo = ordenTMd.seleccionarOdtDetalle(conn.getConexion(), ""
				+ numeroOdtTabla);

		for (int j = 0; j < listaModelo.length; j++)
			if (listaModelo[j][0] != null) {

				float cantidad = Float.parseFloat(listaModelo[j][0].toString());
				detalleOdtRecibo nuevoItem = new detalleOdtRecibo(cantidad, ""
						+ listaModelo[j][1], "" + listaModelo[j][2], Float
						.parseFloat(listaModelo[j][3].toString()), Float
						.parseFloat(listaModelo[j][4].toString()), new Boolean(
						true));
				modelo.nuevoItem(nuevoItem);
			}
		cargarCampos(numeroOdtTabla);
		calcularSaldo();
		return modelo;

	}

	private void cargarCampos(int numeroOdtTabla) {
		ordenDeTrabajo ordenDeTrabajoDp = ordenTMd.seleccionarOdtEncabezado(
				conn.getConexion(), numeroOdtTabla);
		jTextFieldRucCedula.setText(ordenDeTrabajoDp.getCiRuc());
		jTextFieldImpresion.setText(ordenDeTrabajoDp.getImpresion());
		jTextFieldArchivo.setText(ordenDeTrabajoDp.getNombredelArchivo());
		jTextFieldAbono.setText("" + ordenDeTrabajoDp.getAbono());
		jTextFieldSaldo.setText("" + ordenDeTrabajoDp.getSaldo());
		jTextFieldTotal.setText("" + ordenDeTrabajoDp.getPrecio());
		empleado empDp=new empleado(numeroOdtTabla, numeroOdtTabla, usuarioActual, usuarioActual, usuarioActual, usuarioActual, usuarioActual, usuarioActual, usuarioActual, 0, usuarioActual, usuarioActual, usuarioActual, null);
		empDp.setIdEMp(ordenDeTrabajoDp.getIdEmpleadoDiseñador());
		String EmpleadoString=empleadoMd.buscarNombreEmpRegistro(conn.getConexion(), empDp).getNombre();
		choiceOpcionEncargado.select(EmpleadoString);
		System.out.println(EmpleadoString);
		output.setText(ordenDeTrabajoDp.getObservacion());
		jLabelFecha.setText(ordenDeTrabajoDp.getFecha());
		/**
		 * Cliente
		 */
		clienteDp.setCiRuc(jTextFieldRucCedula.getText().trim());
		clienteDp = clienteMd.buscarInfoDeUnRegistro(conn.getConexion(),
				clienteDp);
		jTextFieldNombre.setText(clienteDp.getNombre());
		jTextFieldITelefono.setText(clienteDp.getTelefono());

	}

	/**
	 * This method initializes jButtonImprimir
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setText("Imprimir");

			jButtonImprimir.setEnabled(false);
			jButtonImprimir
					.setToolTipText("Imprime los Datos de la Orden de Trabajo");
			jButtonImprimir
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								impresionOdtParametros odtImpresion = new impresionOdtParametros();
								odtImpresion.imprimir(ordenDeTrabajoDP,
										ordenTrabajoDetalleDP, clienteDp);
							} catch (Exception NoPrinter) {
								JOptionPane.showMessageDialog(null,
										"No hay una impresora Instalada!",
										"Aviso", JOptionPane.ERROR_MESSAGE);

							}

						}
					});
		}
		return jButtonImprimir;
	}

	/**
	 * This method initializes jPanel22111
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel22111() {
		if (jPanel22111 == null) {
			GridLayout gridLayout22111 = new GridLayout();
			gridLayout22111.setRows(1);
			gridLayout22111.setVgap(10);
			gridLayout22111.setColumns(4);
			gridLayout22111.setHgap(10);
			jPanel22111 = new JPanel();
			jPanel22111.setLayout(gridLayout22111);
			jPanel22111.setBounds(new Rectangle(122, 591, 509, 28));
			jPanel22111.add(getJButtonAceptar(), null);
			jPanel22111.add(getJButtonImprimir(), null);
			jPanel22111.add(getJButtonVerReporte(), null);
			jPanel22111.add(getJButtonLimpiar(), null);
		}
		return jPanel22111;
	}

	/**
	 * This method initializes jButtonVerReporte
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerReporte() {
		if (jButtonVerReporte == null) {
			jButtonVerReporte = new JButton();
			jButtonVerReporte.setText("Ver Reporte");
			jButtonVerReporte.setEnabled(false);
			jButtonVerReporte
					.setToolTipText("Muestra una versión Imprimible de la Orden de Trabajo");
			jButtonVerReporte
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verReporte();
						}
					});
		}
		return jButtonVerReporte;
	}

	private void verReporte() {
		OdtLlenarForm reporteJasper = new OdtLlenarForm();
		reporteJasper.recibirDatosExternos(ordenDeTrabajoDP
				.getIdOrdenDeTrabajo());

	}

	/**
	 * This method initializes jButtonBuscarCliente
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscarCliente() {
		if (jButtonBuscarCliente == null) {
			jButtonBuscarCliente = new JButton();
			jButtonBuscarCliente.setBounds(new Rectangle(348, 9, 37, 38));
			jButtonBuscarCliente.setToolTipText("Buscar Cliente");
			jButtonBuscarCliente.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/usuario.png")));
			jButtonBuscarCliente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							lista.getPreferredSize();
							lista.setLocation(jTextFieldRucCedula.getX(),
									jTextFieldRucCedula.getY() + 280);

							lista
									.addFocusListener(new java.awt.event.FocusAdapter() {
										public void focusLost(
												java.awt.event.FocusEvent e) {
											ventanaClienteAbierta = false;
											lista.dispose();
										}
									});
							lista.setVisible(true);
							ventanaClienteAbierta = true;
						}
					});
		}
		return jButtonBuscarCliente;
	}

	/**
	 * This method initializes jScrollPane1Lista11
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1Lista11() {
		if (jScrollPane1Lista11 == null) {
			jScrollPane1Lista11 = new JScrollPane();

			jScrollPane1Lista11.add(jList11);
		}
		return jScrollPane1Lista11;
	}
} // @jve:decl-index=0:visual-constraint="10,10"

