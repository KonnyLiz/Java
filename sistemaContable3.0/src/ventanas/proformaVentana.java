package ventanas;

import impresion.impresionFacturaParametros;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.MaskFormatter;

import reportes.proformaLlenarForm;
import tableUtil.detalleRecibo;
import tableUtil.modeloRecibo;
import tableUtil.renderRecibo;
import Utilitarios.utilitarios;
import clases.arregloClientesTempHash;
import clases.arregloProductosTempHash;
import clases.cliente;
import clases.proforma;
import clases.proformaDetalle;
import clasesBdd.clientesBdd;
import clasesBdd.conexionBdd;
import clasesBdd.inventarioBdd;
import clasesBdd.ordenTrabajoBdd;
import clasesBdd.proformaBdd;
import clasesBdd.setupBdd;
import clasesBdd.tipoProductoBdd;
import clasesBdd.userBdd;

public class proformaVentana extends JInternalFrame {
	// public class proformaVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Choice choice = null;
	private JLabel Administraciónproveedor = null;
	private JPanel jPanel2 = null;
	private JLabel jLabelBiuscar11 = null;
	private JLabel jLabelBiuscar1 = null;
	private JLabel jLabelBiuscar111 = null;
	private JPanel jPanel21 = null;
	private JTextField jTextFieldOdt = null;
	/**
	 * pruebas de la tabla
	 *
	 */
	modeloRecibo modelo = new modeloRecibo(); // @jve:decl-index=0:
	/**
	 * Detector de row cambiado
	 */
	int filaQueCambio = 0;
	int rowTemp = 0;
	int columnTemp = 0;
	boolean ExisteCliente = true;

	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JTextField jTextFieldCantidad = null;
	private JLabel jLabelDescripcion12 = null;
	private JLabel jLabelDescripcion121 = null;
	private JTextField jTextFieldValor = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JPanel jPanel22 = null;
	private JLabel jLabelBiuscar112 = null;
	private JLabel jLabelBiuscar12 = null;
	private JLabel jLabelBiuscar1111 = null;
	private JPanel jPanel221 = null;
	private JTextField jTextFieldSubtotal = null;
	private JTextField jTextFieldIva0 = null;
	private JTextField jTextFieldIva12 = null;
	private JLabel jLabelBiuscar11111 = null;
	private JTextField jTextFieldTotal = null;
	utilitarios util = new utilitarios();
	String estado = null;
	/**
	 * listas hash
	 */
	inventarioBdd inventarioMd = new inventarioBdd();
	tipoProductoBdd tpMd = new tipoProductoBdd();
	ordenTrabajoBdd odtMd = new ordenTrabajoBdd(); // @jve:decl-index=0:
	setupBdd setupMd = new setupBdd();
	conexionBdd conn = new conexionBdd();
	clientesBdd clienteMd = new clientesBdd(); // @jve:decl-index=0:
	proformaBdd proformaMd = new proformaBdd(); // @jve:decl-index=0:
	Hashtable<String, arregloProductosTempHash> listaProductosDescripcionArreglo = inventarioMd
			.seleccionarDescripcionesTablaHash(conn.getConexion()); // @jve:decl-index=0:
	Hashtable<Object, Object> listaTiposProductosDescripcionArreglo = tpMd
			.seleccionarDescripcionesTablaHash(conn.getConexion());
	Hashtable<String, arregloClientesTempHash> clientesListaHash = clienteMd
			.seleccionarDatosClientesHashOdt(conn.getConexion()); // @jve:decl-index=0:
	Object IvaImpresora[][] = setupMd
			.seleccionarIvaImpresoraSetupTablaHash(conn.getConexion()); // @jve:decl-index=0:
	cliente clienteDp = new cliente(0, "", "", "", "", "", "", ""); // @jve:decl-index=0:
	proforma proformaDp = new proforma(0, "", "", "", 0, 0, 0, ""); // @jve:decl-index=0:

	int sigProforma = Integer.parseInt(""
			+ proformaMd.idParaNuevaProforma(conn.getConexion()));

	/**
	 * parametros para impresión
	 */
	proforma proformaDP = new proforma(0, "", "", "", 0, 0, 0, ""); // @jve:decl-index=0:
	proformaDetalle proformaDetalleDP[] = {
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0),
			new proformaDetalle(0, 0, 0, "", 0, 0, 0, 0) }; // @jve:decl-index=0:

	userBdd userMd = new userBdd();
	private JCheckBox jCheckBoxAplicaIva = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JPanel jPanel3 = null;
	private JTextField jTextFieldFechaEmision = null;
	private JTextField jTextFieldRUC = null;
	private JTextField jTextFieldCliente = null;
	private JTextField jTextFieldDireccion = null;
	private JTextField jTextFieldTelefono = null;
	private JComboBox choiceTipoProducto = null;
	private JComboBox choiceProductos = null;
	private JTextField jTextFieldUniodad = null;
	private JButton jButton1 = null;
	private JPanel jPanel4 = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonImprimir = null;
	private JButton jButtonVerReporte = null;
	private JButton jButtonLimpiar = null;
	private JPanel jPanel23 = null;
	private JLabel jLabelNumeroRecibo = null;
	private JPanel jPanel31 = null;
	private utilitarios util1 = null;
	private JTextField jTextFieldNumeroRecibo = null;
	String User = "usera";// comentar
	private JButton jButtonBuscarCliente = null;
	boolean ventanaClienteAbierta = false;
	listaClientesRecibo lista = new listaClientesRecibo();

	/**
	 * This is the default constructor
	 */

	public proformaVentana() {
		// public facturaVentana(String numeroOdt,boolean facturarOdt,String
		// proformaNumero, boolean facturarProforma,String User) {

		super();

		initialize();
		verificarDatosExternos();
		cargarComboxProductos("" + choiceTipoProducto.getSelectedItem());
		this.setClosable(true);
		this.setIconifiable(true);
		lista.setAlwaysOnTop(true);
		lista.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				jTextFieldRUC.setText(lista.devolverRuc());
				ventanaClienteAbierta = false;
				lista.cerrar();
				jTextFieldRUC.selectAll();
				jTextFieldRUC.requestFocus();
				jTextFieldRUC.transferFocus();

			}
		});
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(668, 658);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración de Notas de Proformas");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelDescripcion121 = new JLabel();
			jLabelDescripcion121.setBounds(new Rectangle(208, 241, 438, 21));
			jLabelDescripcion121.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelDescripcion121
					.setText("      Tipo de Producto                          Producto                                            VALOR");
			jLabelDescripcion121.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDescripcion12 = new JLabel();
			jLabelDescripcion12.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelDescripcion12.setText("Cantidad :");
			jLabelDescripcion12.setHorizontalAlignment(SwingConstants.LEFT);
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-2, 4, 662, 25));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor.setText("Administración de Proformas");
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getChoice(), null);
			jContentPane.add(Administraciónproveedor, null);
			jContentPane.add(getJPanel2(), null);
			jContentPane.add(getJPanel21(), null);
			jContentPane.add(jLabelBiuscar111, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabelDescripcion121, null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getjTextFieldValor(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJPanel22(), null);
			jContentPane.add(getJPanel221(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJPanel3(), null);
			jContentPane.add(getJTextFieldDireccion(), null);
			jContentPane.add(getJTextFieldTelefono(), null);
			jContentPane.add(getChoiceTipoProducto(), null);
			jContentPane.add(getChoiceProductos(), null);
			jContentPane.add(getJTextFieldUniodad(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJPanel4(), null);
			jContentPane.add(getJPanel23(), null);
			jContentPane.add(getJPanel31(), null);
			jContentPane.add(getJButtonBuscarCliente(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes choice
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(new Rectangle(144, 39, 132, 21));
			choice.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					estado = choice.getSelectedItem();// diferencia a una nota
					// de una factura
					choice.setEnabled(false);
					sugerirNumero();
				}
			});

			choice.addItem("Escoja un opción");
			choice.addItem("Nota de Venta");
			choice.addItem("Factura");

		}
		return choice;
	}

	/**
	 * Chequea los datos del constructor para saber si debe procesar datos
	 * externos en la factura
	 *
	 * @return
	 *
	 */
	private void verificarDatosExternos() {

	}

	/**
	 * This method initializes jPanel2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabelBiuscar111 = new JLabel();
			jLabelBiuscar111.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelBiuscar111.setText("<= Opcional");
			jLabelBiuscar111.setForeground(Color.red);
			jLabelBiuscar111.setBounds(new Rectangle(376, 67, 78, 26));
			jLabelBiuscar111.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelBiuscar1 = new JLabel();
			jLabelBiuscar1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelBiuscar1.setText("Orden de Trabajo :");
			jLabelBiuscar1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar11 = new JLabel();
			jLabelBiuscar11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar11.setText("Escoja una Opción :");
			jLabelBiuscar11.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(2);
			gridLayout2.setVgap(10);
			gridLayout2.setHgap(10);
			jPanel2 = new JPanel();
			jPanel2.setLayout(gridLayout2);
			jPanel2.setBounds(new Rectangle(14, 36, 123, 54));
			jPanel2.add(jLabelBiuscar11, null);
			jPanel2.add(jLabelBiuscar1, null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel21
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			GridLayout gridLayout21 = new GridLayout();
			gridLayout21.setRows(1);
			gridLayout21.setVgap(10);
			gridLayout21.setHgap(10);
			jPanel21 = new JPanel();
			jPanel21.setLayout(gridLayout21);
			jPanel21.setBounds(new Rectangle(146, 67, 129, 24));
			jPanel21.add(getJTextFieldOdt(), null);
		}
		return jPanel21;
	}

	/**
	 * This method initializes jTextFieldOdt
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldOdt() {
		if (jTextFieldOdt == null) {
			jTextFieldOdt = new JTextField();
			jTextFieldOdt.setText("0");
			jTextFieldOdt.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldOdt.setText(""
							+ util.cortarCadenaString(jTextFieldOdt.getText()
									.trim(), 6));
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
					if (choice.isEnabled()) {
						choice.select(2);
						choice.setEnabled(false);
						estado = choice.getSelectedItem();// diferencia a una
						// nota de una
						// factura
					}
				}
			});
			jTextFieldOdt.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					if (jTextFieldOdt.getText().compareTo("0") != 0
							&& jTextFieldOdt.getText().trim().compareTo("") != 0) {

					}
				}
			});
		}
		return jTextFieldOdt;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(27, 320, 607, 142));
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
					.setToolTipText("Se puede Modificar  la Cantidad haciendo Doble click");
			jTable.getModel().addTableModelListener(new TableModelListener() {

				public void tableChanged(TableModelEvent e) {
					filaQueCambio = e.getLastRow();
				}
			});
			jTable.setRowSelectionAllowed(false);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(100);// cantidad
			jTable.getColumnModel().getColumn(1).setPreferredWidth(210);// desc210
			jTable.getColumnModel().getColumn(2).setPreferredWidth(100);// vunitario
			jTable.getColumnModel().getColumn(3).setPreferredWidth(124);// vtotal
			jTable.getColumnModel().getColumn(4).setPreferredWidth(70);// eliminar
			renderRecibo render = new renderRecibo();
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
					if (modelo.getRowCount() > 0 && column == 04) {
						int res = pedirConfirmacion();
						if (res == 0) {
							modelo.borraItem(row);
							JOptionPane.showMessageDialog(null,
									"Item Eliminado! ", "Aviso!",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}

			});

			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {

					float precioU = (Float) modelo.getValueAt(filaQueCambio, 2);
					float nuevaCantidad = (Float) modelo.getValueAt(
							filaQueCambio, 0);
					float subtotal = precioU * nuevaCantidad;
					String descripcion = (String) modelo.getValueAt(
							filaQueCambio, 1);
					detalleRecibo nuevoItem = new detalleRecibo(nuevaCantidad,
							descripcion, precioU, subtotal, new Boolean(true));
					buscarEnLista(nuevoItem, true);
					colocarTotal();

				}
			});
		}
		return jTable;
	}

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
	 * Verifica que no haya repetidos en la lista
	 *
	 * @param item
	 */
	private void buscarEnLista(detalleRecibo item, Boolean cambioFila) {

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
				float valorUnitario = (Float) modelo.getValueAt(i, 2);// valor
				// unitario
				// 3
				float subtotal = valorUnitario * cantidadFinal;// subtotal 4
				int posicion = i;
				Object producto = choiceProductos.getSelectedItem();
				if (producto.toString().compareTo("" + modelo.getValueAt(i, 1)) == 0
						&& bandera == true) {
					modelo.borraItem(i);
					detalleRecibo nuevoItem = new detalleRecibo(cantidadFinal,
							Descripcion, valorUnitario, subtotal, new Boolean(
									true));
					modelo.nuevoItemEnPosicion(nuevoItem, posicion);
					bandera = false;
				}

			}
			if (bandera == true) {
				modelo.nuevoItem(item);
			}
		}

		// colocarTotal();
	}// buscarEnLista

	/**
	 * This method initializes jTextFieldCantidad
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setText("1");
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(""
							+ util.cortarCadenaString(jTextFieldCantidad
									.getText().trim(), 6));
					if (choiceProductos.getSelectedItem().toString().compareTo(
							"Escoja un Producto") != 0) {
						colocarPrecio();
						try {
							arregloProductosTempHash productoSolicitado = listaProductosDescripcionArreglo
									.get("" + choiceProductos.getSelectedItem());
							float cantDisponible = productoSolicitado
									.getTotalBruto();
							float cantidadSolicitada = Float.parseFloat(""
									+ jTextFieldCantidad.getText().trim());
							if (cantidadSolicitada > cantDisponible) {
								JOptionPane.showMessageDialog(null,
										"La cantidad Ingresada es superior al disponible, Disponible: "
												+ cantDisponible
												+ "   "
												+ productoSolicitado
														.getUmedida(),
										"Aviso!",
										JOptionPane.INFORMATION_MESSAGE);
								jTextFieldCantidad.setText("1");
							}
						} catch (Exception convertProblem) {
							convertProblem.printStackTrace();
						}
					}
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
					if (jTextFieldCantidad.getText().compareTo("") == 0)
						jTextFieldCantidad.setText("1");
				}
			});
			jTextFieldCantidad
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldCantidad.selectAll();
						}
					});
		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes jTextFieldValor
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldValor() {
		if (jTextFieldValor == null) {
			jTextFieldValor = new JTextField();
			jTextFieldValor.setBounds(new Rectangle(567, 265, 74, 26));
			jTextFieldValor.setEditable(false);
			jTextFieldValor.setText("0");
		}
		return jTextFieldValor;
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
			gridLayout.setHgap(20);
			gridLayout.setVgap(20);
			gridLayout.setColumns(3);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.setBounds(new Rectangle(11, 263, 151, 26));
			jPanel.add(jLabelDescripcion12, null);
			jPanel.add(getJTextFieldCantidad(), null);
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
			jButton.setBounds(new Rectangle(500, 297, 135, 22));
			jButton.setText("Añadir a Lista");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object producto = choiceProductos.getSelectedItem();
					if (producto.toString().compareTo("Escoja un Producto") != 0
							&& choice.getSelectedItem().compareTo(
									"Escoja un opción") != 0) {

						if (modelo.getRowCount() > 10)
							JOptionPane.showMessageDialog(null,
									"No se pueden Ingresar mas Items!! ",
									"Alerta!", JOptionPane.ERROR_MESSAGE);
						else {
							detalleRecibo item = validarItem();
							if (modelo.getRowCount() <= 0) {
								modelo.nuevoItem(item);
								colocarTotal();

							}

							else
								buscarEnLista(item, false);
							colocarTotal();

						}
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"No se ha seleccionado un Item!, o lista sin productos a mostrar ",
										"Alerta!", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel22
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel22() {
		if (jPanel22 == null) {
			jLabelBiuscar11111 = new JLabel();
			jLabelBiuscar11111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar11111.setText("TOTAL :");
			jLabelBiuscar11111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar1111 = new JLabel();
			jLabelBiuscar1111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar1111.setText("IVA 12% :");
			jLabelBiuscar1111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar12 = new JLabel();
			jLabelBiuscar12.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar12.setText("IVA 0% :");
			jLabelBiuscar12.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar112 = new JLabel();
			jLabelBiuscar112.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar112.setText("SUBTOTAL :");
			jLabelBiuscar112.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout22 = new GridLayout();
			gridLayout22.setRows(4);
			gridLayout22.setVgap(10);
			gridLayout22.setHgap(10);
			jPanel22 = new JPanel();
			jPanel22.setLayout(gridLayout22);
			jPanel22.setBounds(new Rectangle(409, 471, 118, 110));
			jPanel22.add(jLabelBiuscar112, null);
			jPanel22.add(jLabelBiuscar12, null);
			jPanel22.add(jLabelBiuscar1111, null);
			jPanel22.add(jLabelBiuscar11111, null);
		}
		return jPanel22;
	}

	/**
	 * This method initializes jPanel221
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel221() {
		if (jPanel221 == null) {
			GridLayout gridLayout221 = new GridLayout();
			gridLayout221.setRows(4);
			gridLayout221.setVgap(6);
			gridLayout221.setHgap(10);
			jPanel221 = new JPanel();
			jPanel221.setLayout(gridLayout221);
			jPanel221.setBounds(new Rectangle(541, 471, 104, 109));
			jPanel221.add(getjTextFieldSubtotal(), null);
			jPanel221.add(getjTextFieldIva0(), null);
			jPanel221.add(getjTextFieldIva12(), null);
			jPanel221.add(getjTextFieldTotal(), null);
		}
		return jPanel221;
	}

	/**
	 * This method initializes jTextFieldSubtotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldSubtotal() {
		if (jTextFieldSubtotal == null) {
			jTextFieldSubtotal = new JTextField();
			jTextFieldSubtotal.setEditable(false);
			jTextFieldSubtotal.setForeground(new Color(51, 51, 244));
			jTextFieldSubtotal.setFont(new Font("Dialog", Font.BOLD, 24));
			jTextFieldSubtotal.setText("0");
		}
		return jTextFieldSubtotal;
	}

	/**
	 * This method initializes jTextFieldIva0
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldIva0() {
		if (jTextFieldIva0 == null) {
			jTextFieldIva0 = new JTextField();
			jTextFieldIva0.setEditable(false);
			jTextFieldIva0.setForeground(new Color(51, 51, 244));
			jTextFieldIva0.setFont(new Font("Dialog", Font.BOLD, 24));
			jTextFieldIva0.setText("0");
		}
		return jTextFieldIva0;
	}

	/**
	 * This method initializes jTextFieldIva12
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldIva12() {
		if (jTextFieldIva12 == null) {
			jTextFieldIva12 = new JTextField();
			jTextFieldIva12.setEditable(false);
			jTextFieldIva12.setForeground(new Color(51, 51, 244));
			jTextFieldIva12.setFont(new Font("Dialog", Font.BOLD, 24));
			jTextFieldIva12.setText("0");
		}
		return jTextFieldIva12;
	}

	/**
	 * This method initializes jTextFieldTotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldTotal() {
		if (jTextFieldTotal == null) {
			jTextFieldTotal = new JTextField();
			jTextFieldTotal.setEditable(false);
			jTextFieldTotal.setForeground(new Color(251, 0, 0));
			jTextFieldTotal.setFont(new Font("Dialog", Font.BOLD, 24));
			jTextFieldTotal.setText("0");
		}
		return jTextFieldTotal;
	}

	/**
	 * validad las clases cliente y orden de trabajo ingresadas
	 */

	/**
	 * Verifica el item a ser insertado en la grilla
	 *
	 * @return
	 */

	private detalleRecibo validarItem() {
		detalleRecibo item;
		try {
			float cantidad = Float.parseFloat(jTextFieldCantidad.getText());
			String descripcion = choiceProductos.getSelectedItem().toString();
			arregloProductosTempHash producto = listaProductosDescripcionArreglo
					.get(descripcion);
			float precioUnitario = producto.getPvp();
			precioUnitario = util.Redondear("" + precioUnitario, 2);
			float subT = cantidad * precioUnitario;
			subT = util.Redondear("" + subT, 2);
			item = new detalleRecibo(cantidad, descripcion, precioUnitario,
					subT, new Boolean(true));
		} catch (Exception novalorFloat) {
			item = new detalleRecibo(0, "asdasd", 0, 0, new Boolean(true));
		}
		return item;
	}

	/**
	 * This method initializes jCheckBoxAplicaIva
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxAplicaIva() {
		if (jCheckBoxAplicaIva == null) {
			jCheckBoxAplicaIva = new JCheckBox();
			jCheckBoxAplicaIva.setText("Aplica cobro del I.V.A");
			jCheckBoxAplicaIva.setSelected(true);

		}
		return jCheckBoxAplicaIva;
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Teléfono :");
			jLabel3 = new JLabel();
			jLabel3.setText("Dirección :");
			jLabel2 = new JLabel();
			jLabel2.setText("R.U.C. :");
			jLabel1 = new JLabel();
			jLabel1.setText("Cliente :");
			jLabel = new JLabel();
			jLabel.setText("Fecha Emision :");
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(5);
			gridLayout1.setHgap(5);
			gridLayout1.setVgap(5);
			gridLayout1.setColumns(1);
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout1);
			jPanel1.setBounds(new Rectangle(14, 105, 123, 128));
			jPanel1.add(jLabel, null);
			jPanel1.add(jLabel2, null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(jLabel3, null);
			jPanel1.add(jLabel4, null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel3
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(3);
			gridLayout3.setVgap(5);
			gridLayout3.setHgap(5);
			jPanel3 = new JPanel();
			jPanel3.setLayout(gridLayout3);
			jPanel3.setBounds(new Rectangle(149, 107, 155, 71));
			jPanel3.add(getJTextFieldFechaEmision(), null);
			jPanel3.add(getJTextFieldRUC(), null);
			jPanel3.add(getJTextFieldCliente(), null);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jTextFieldFechaEmision
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFechaEmision() {
		if (jTextFieldFechaEmision == null) {
			jTextFieldFechaEmision = new JTextField();
			jTextFieldFechaEmision.setEditable(false);
			jTextFieldFechaEmision.setFont(new Font("Dialog", Font.BOLD, 18));
			jTextFieldFechaEmision.setForeground(new Color(249, 51, 51));
			jTextFieldFechaEmision.setText("" + util.fechaActual());
		}
		return jTextFieldFechaEmision;
	}

	/**
	 * This method initializes jTextFieldRUC
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRUC() {
		if (jTextFieldRUC == null) {
			jTextFieldRUC = new JTextField();
			jTextFieldRUC.setText("0000000000000");
			jTextFieldRUC.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					jTextFieldRUC.selectAll();
				}
			});
			jTextFieldRUC.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldRUC.setText(""
							+ util.cortarCadenaString(jTextFieldRUC.getText()
									.trim(), 13));
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldRUC.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					cliente clienteDP = new cliente(0, jTextFieldRUC.getText()
							.trim(), "", "", "", "", "", "");
					clientesBdd clienteMd = new clientesBdd();
					clienteDP = clienteMd.buscarInfoDeUnRegistro(conn
							.getConexion(), clienteDP);
					if (clienteDP.getSexo().compareTo("") != 0) {
						jTextFieldCliente.setText(clienteDP.getNombre());
						jTextFieldTelefono.setText(clienteDP.getTelefono());
						jTextFieldDireccion.setText(clienteDP.getDireccion());
						ExisteCliente = true;

					} else {
						jTextFieldCliente.setText(" nombre del Nuevo Cliente");
						ExisteCliente = false;

					}

				}
			});
		}
		return jTextFieldRUC;
	}

	/**
	 * This method initializes jTextFieldCliente
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCliente() {
		if (jTextFieldCliente == null) {
			jTextFieldCliente = new JTextField();

			jTextFieldCliente.setForeground(new Color(51, 60, 255));
			jTextFieldCliente.setText("Consumidor Final");
			jTextFieldCliente
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldCliente.selectAll();
						}
					});
			jTextFieldCliente.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCliente.setText(""
							+ util.cortarCadenaString(jTextFieldCliente
									.getText(), 50));
				}
			});
			jTextFieldCliente.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					cliente clienteDP = new cliente(0, jTextFieldRUC.getText()
							.trim(), "" + jTextFieldCliente.getText(), "", "",
							"", "", "");
					clientesBdd clienteMd = new clientesBdd();
					clienteDP = clienteMd.buscarInfoDeUnRegistroPorNombre(conn
							.getConexion(), clienteDP);
					if (clienteDP.getSexo() != null) {
						jTextFieldRUC.setText(clienteDP.getCiRuc());
						jTextFieldCliente.setText(clienteDP.getNombre());
						jTextFieldTelefono.setText(clienteDP.getTelefono());
						jTextFieldDireccion.setText(clienteDP.getDireccion());
						ExisteCliente = true;

					} else {
						jTextFieldCliente.setText(" nombre del Nuevo Cliente");
						ExisteCliente = false;
					}
				}
			});
		}
		return jTextFieldCliente;
	}

	/**
	 * This method initializes jTextFieldDireccion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDireccion() {
		if (jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.setBounds(new Rectangle(149, 184, 318, 20));
			jTextFieldDireccion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldDireccion.selectAll();
						}
					});
			jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldDireccion.setText(""
							+ util.cortarCadenaString(jTextFieldDireccion
									.getText(), 50));
				}
			});
		}
		return jTextFieldDireccion;
	}

	/**
	 * This method initializes jTextFieldTelefono
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTelefono() {
		if (jTextFieldTelefono == null) {

			try {
				MaskFormatter mascara = new MaskFormatter(
						"(##)###-####/(##)###-####");
				jTextFieldTelefono = new JFormattedTextField(mascara);
				jTextFieldTelefono.setBounds(new Rectangle(149, 210, 155, 20));
				jTextFieldTelefono.setText("(02)222-2222/(09)999-9999");
				jTextFieldTelefono
						.addFocusListener(new java.awt.event.FocusAdapter() {
							public void focusGained(java.awt.event.FocusEvent e) {
								jTextFieldTelefono.selectAll();
							}
						});
				jTextFieldTelefono
						.setToolTipText("Ingrese el número o números de teléfono");

			} catch (Exception e) {
				e.printStackTrace();
			}

			jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {

				}
			});
		}
		return jTextFieldTelefono;
	}

	/**
	 * This method initializes choiceTipoProducto
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getChoiceTipoProducto() {
		if (choiceTipoProducto == null) {
			choiceTipoProducto = new JComboBox();
			cargarChoiceTipoProdItems();

			choiceTipoProducto.setBounds(new Rectangle(209, 267, 125, 21));

			choiceTipoProducto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cargarComboxProductos(""
									+ choiceTipoProducto.getSelectedItem());
						}
					});

		}
		return choiceTipoProducto;
	}

	/**
	 * This method initializes choiceProductos
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getChoiceProductos() {
		if (choiceProductos == null) {
			choiceProductos = new JComboBox();
			choiceProductos.setBounds(new Rectangle(344, 267, 190, 21));
			choiceProductos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (choiceProductos.isFocusOwner()) {
								if (choiceProductos.getSelectedItem()
										.toString().compareTo(
												"Escoja un Producto") != 0) {
									arregloProductosTempHash productoSolicitado = listaProductosDescripcionArreglo
											.get(""
													+ choiceProductos
															.getSelectedItem());
									productoSolicitado = listaProductosDescripcionArreglo
											.get(""
													+ choiceProductos
															.getSelectedItem());
									productoSolicitado = listaProductosDescripcionArreglo
											.get(""
													+ choiceProductos
															.getSelectedItem());
									jTextFieldUniodad.setText(""
											+ productoSolicitado.getUmedida());
									colocarPrecio();
								}
							}
						}
					});

			choiceProductos.addItem("Escoja un Producto");
		}
		return choiceProductos;
	}

	public void cargarChoiceTipoProdItems() {
		Object[] descripciones = listaTiposProductosDescripcionArreglo.keySet()
				.toArray();
		for (int i = 0; i < descripciones.length; i++) {
			choiceTipoProducto.addItem((String) descripciones[i]);
		}
	}// end cargarChoiceItems

	public void cargarComboxProductos(String TipoProducto) {

		choiceProductos.removeAllItems();
		choiceProductos.addItem("Escoja un Producto");

		// selecciono el codigo del tipo de prod en un objeto
		// arregloProductosTempHash
		// ObjetoTipoProducto=(arregloProductosTempHash)listaTiposProductosDescripcionArreglo.get(""+choiceTipoProducto.getSelectedItem());
		Hashtable<String, arregloProductosTempHash> listaProdSolicitados = inventarioMd
				.seleccionarDescripcionesPorTipoProductoTablaHash(conn
						.getConexion(), TipoProducto);
		Object[] descripciones = listaProdSolicitados.keySet().toArray();
		for (int i = 0; i < descripciones.length; i++) {
			choiceProductos.addItem((String) descripciones[i]);
		}

	}// end cargarChoiceItems

	private void colocarPrecio() {
		arregloProductosTempHash productoSolicitado = listaProductosDescripcionArreglo
				.get("" + choiceProductos.getSelectedItem());
		float precio = productoSolicitado.getPvp();

		float cantidad = 0;
		try {
			cantidad = Float.parseFloat(jTextFieldCantidad.getText().trim());

		} catch (Exception Ex) {
			cantidad = 1;
			jTextFieldValor.setText("1");
		}
		jTextFieldValor.setText("" + util.Redondear("" + precio * cantidad, 2));

	}

	/**
	 * This method initializes jTextFieldUniodad
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUniodad() {
		if (jTextFieldUniodad == null) {
			jTextFieldUniodad = new JTextField();
			jTextFieldUniodad.setBounds(new Rectangle(167, 264, 31, 21));
			jTextFieldUniodad.setEditable(false);
			jTextFieldUniodad.setEnabled(true);
		}
		return jTextFieldUniodad;
	}

	/**
	 * Suma el total de todos los items y lo coloca en el textfield total
	 */

	private void colocarTotal() {
		float total = 0;
		float iva = Float.parseFloat("" + IvaImpresora[0][0]);
		iva = iva / 100;
		for (int i = 0; i < modelo.getRowCount(); i++) {
			total = total + ((Float) modelo.getValueAt(i, 3));
		}
		if (jCheckBoxAplicaIva.isSelected() && estado.compareTo("Factura") == 0) {

			jTextFieldSubtotal.setText("" + util.Redondear("" + total, 2));
			jTextFieldIva0.setText("0");
			float procentajeIva = total * iva;
			jTextFieldIva12.setText("" + util.Redondear("" + procentajeIva, 2));
			total = total + (total * iva);
			jTextFieldTotal.setText("" + util.Redondear("" + total, 2));

		} else {
			jTextFieldSubtotal.setText("" + total);
			jTextFieldIva0.setText("0");
			jTextFieldIva12.setText("0");
			jTextFieldTotal.setText("" + total);
		}

	}// colocarTotal

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(288, 66, 79, 25));
			jButton1.setText("Aceptar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cargarItemsDatosOdt();
				}
			});
		}
		return jButton1;
	}

	private void cargarItemsDatosOdt() {
		if (modelo.getRowCount() > 10)
			JOptionPane.showMessageDialog(null,
					"No se pueden Ingresar mas Items!! ", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		else {

			Object arreglo[][] = odtMd.solicitarItems(conn.getConexion(),
					modelo.getRowCount(), 10, jTextFieldOdt.getText().trim());
			if (arreglo.length == 0) {
				JOptionPane
						.showMessageDialog(
								null,
								"No se puede insertar Datos a recibo,no hay items o no hay suficientes celdas para insertar! ",
								"Alerta!", JOptionPane.ERROR_MESSAGE);
			} else {
				jButton1.setEnabled(false);
				for (int i = 0; i < arreglo.length; i++) {
					float cantidad = Float.parseFloat("" + arreglo[i][0]);
					cantidad = util.Redondear("" + cantidad, 2);
					String descripción = "" + arreglo[i][1];
					float iva = (Float.parseFloat("" + IvaImpresora[0][0]) / 100);
					iva = iva + 1;
					float Precio = Float.parseFloat("" + arreglo[i][2]) / iva;
					Precio = util.Redondear("" + Precio, 2);
					float subtotal = Precio * cantidad;
					subtotal = util.Redondear("" + subtotal, 2);
					detalleRecibo item = new detalleRecibo(cantidad,
							descripción, Precio, subtotal, new Boolean(true));

					if (modelo.getRowCount() <= 0) {
						modelo.nuevoItem(item);

						// /
						// jTextFieldTotal.setText(""+util.Redondear(""+jTextFieldTotal.getText(),2));
					} else
						buscarEnLista(item, false);

				}

			}// else
		}// else

		colocarTotal();
	}// cargarItemsDatosOdt()

	/**
	 * This method initializes jPanel4
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridLayout gridLayout4 = new GridLayout();
			gridLayout4.setRows(1);
			gridLayout4.setHgap(20);
			gridLayout4.setVgap(20);
			gridLayout4.setColumns(3);
			jPanel4 = new JPanel();
			jPanel4.setLayout(gridLayout4);
			jPanel4.setBounds(new Rectangle(47, 589, 546, 26));
			jPanel4.add(getJButtonAceptar(), null);
			jPanel4.add(getJButtonImprimir(), null);
			jPanel4.add(getJButtonVerReporte(), null);
			jPanel4.add(getJButtonLimpiar(), null);
		}
		return jPanel4;
	}

	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (modelo.getRowCount() == 0) {
								JOptionPane.showMessageDialog(null,
										"La Proforma no tiene Items!", "Aviso",
										JOptionPane.ERROR_MESSAGE);

							} else {
								int estado1 = validar();
								if (estado1 == 1) {
									jButtonImprimir.setEnabled(true);
									jButtonVerReporte.setEnabled(true);
								}
							}// else
						}
					});
		}
		return jButtonAceptar;
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
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								impresionFacturaParametros ReciboImpresion = new impresionFacturaParametros();
								ReciboImpresion.imprimir(proformaDP,
										proformaDetalleDP, clienteDp);
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
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							proformaLlenarForm reporteJasper = new proformaLlenarForm();
							reporteJasper.recibirDatosExternos(proformaDp
									.getIdProforma());
						}
					});
		}
		return jButtonVerReporte;
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
	 * This method initializes jPanel23
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jLabelNumeroRecibo = new JLabel();
			jLabelNumeroRecibo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNumeroRecibo.setText("Recibo Número :");
			jLabelNumeroRecibo.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout23 = new GridLayout();
			gridLayout23.setRows(2);
			gridLayout23.setVgap(10);
			gridLayout23.setHgap(10);
			jPanel23 = new JPanel();
			jPanel23.setLayout(gridLayout23);
			jPanel23.setBounds(new Rectangle(379, 107, 154, 60));
			jPanel23.add(jLabelNumeroRecibo, null);
			jPanel23.add(getJCheckBoxAplicaIva(), null);
		}
		return jPanel23;
	}

	/**
	 * This method initializes jPanel31
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel31() {
		if (jPanel31 == null) {
			GridLayout gridLayout31 = new GridLayout();
			gridLayout31.setRows(1);
			gridLayout31.setVgap(5);
			gridLayout31.setHgap(5);
			jPanel31 = new JPanel();
			jPanel31.setFont(new Font("Dialog", Font.BOLD, 12));
			jPanel31.setLayout(gridLayout31);
			jPanel31.setBounds(new Rectangle(542, 107, 103, 26));
			jPanel31.add(getJTextFieldNumeroRecibo(), null);
		}
		return jPanel31;
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
	 * This method initializes jTextFieldNumeroRecibo
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumeroRecibo() {
		if (jTextFieldNumeroRecibo == null) {
			jTextFieldNumeroRecibo = new JTextField();
			jTextFieldNumeroRecibo.setForeground(new Color(51, 60, 255));
			jTextFieldNumeroRecibo.setFont(new Font("Dialog", Font.PLAIN, 18));
			jTextFieldNumeroRecibo.setText("");
			jTextFieldNumeroRecibo
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldNumeroRecibo.selectAll();
						}
					});
			jTextFieldNumeroRecibo
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldNumeroRecibo.setText(util
									.cortarCadenaFloat(""
											+ jTextFieldNumeroRecibo.getText()
													.trim()));
						}

						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
		}
		return jTextFieldNumeroRecibo;
	}

	private void limpiar() {

		proformaVentana proformaVentanaW = new proformaVentana();
		// facturaVentana facturaVentanaW= new
		// facturaVentana(null,false,null,false);
		proformaVentanaW.getPreferredSize();
		proformaVentanaW.setLocation(this.getX(), this.getY());
		this.getParent().add(proformaVentanaW);
		this.dispose();

		proformaVentanaW.setVisible(true);
	}

	/**
	 * valida las clases antes de ingresar
	 */
	private int validar() {
		cliente clienteDP = new cliente(0, jTextFieldRUC.getText().trim(), "",
				"", "", "", "", "");
		clientesBdd clienteMd = new clientesBdd();
		clienteDp = clienteMd.buscarInfoDeUnRegistro(conn.getConexion(),
				clienteDP);
		if (clienteDp.getSexo().length() == 0)
			ExisteCliente = false;

		int estado1 = 0;
		if (jTextFieldNumeroRecibo.getText().trim().compareTo("") != 0) {
			clienteDp.setCiRuc(jTextFieldRUC.getText().trim());
			clienteDp.setNombre(jTextFieldCliente.getText().trim());
			clienteDp.setClienteDesde(util.fechaActual());
			clienteDp.setDireccion(jTextFieldDireccion.getText().trim());
			clienteDp.setTelefono(jTextFieldTelefono.getText().trim());
			clienteDp.setSexo("Masculino");
			clienteDp.setIdTc(1);
			if (!ExisteCliente) {
				clienteMd.insertar(conn.getConexion(), clienteDp);
			}
			proformaDp.setCiRuc(clienteDp.getCiRuc());
			proformaDp.setCiudad("QUITO");
			proformaDp.setFecha(util.fechaActual());
			proformaDp.setIdProforma(proformaMd.idParaNuevaProforma(conn
					.getConexion()));

			proformaDp.setIva(Float
					.parseFloat(jTextFieldIva12.getText().trim()));
			proformaDp.setSubtotal(Float.parseFloat(jTextFieldSubtotal
					.getText().trim()));
			proformaDp.setTotal(Float.parseFloat(jTextFieldTotal.getText()
					.trim()));
			proformaDp.setIdProforma(Integer.parseInt(jTextFieldNumeroRecibo
					.getText().trim()));
			proformaDP.setCiRuc(clienteDp.getCiRuc());
			proformaDP.setCiudad("QUITO");
			proformaDP.setFecha("" + util.fechaActual());
			proformaDP.setIva(Float
					.parseFloat(jTextFieldIva12.getText().trim()));
			proformaDP.setSubtotal(Float.parseFloat(jTextFieldSubtotal
					.getText().trim()));
			proformaDP.setTotal(Float.parseFloat(jTextFieldTotal.getText()
					.trim()));
			proformaDp.setEstado("PENDIENTE");
			proformaMd.insertar(conn.getConexion(), proformaDp);
			System.out.print("aa:" + proformaDp.getEstado());
			for (int i = 0; i < modelo.getRowCount(); i++) {
				float cantidad = (Float) modelo.getValueAt(i, 0);
				proformaDetalle proformaDetalleDp1 = new proformaDetalle(0, 0,
						0, "", 0, 0, 0, 0);
				proformaDetalleDp1.setIdProforma(proformaDp.getIdProforma());
				proformaDetalleDp1.setIdDescripcion((String) modelo.getValueAt(
						i, 1));
				proformaDetalleDp1.setIdPrecio((Float) modelo.getValueAt(i, 2));
				proformaDetalleDp1.setIdMedidaX(0);
				proformaDetalleDp1.setIdMedidaY(0);
				arregloProductosTempHash productoSolicitado = listaProductosDescripcionArreglo
						.get(proformaDetalleDp1.getIdDescripcion());
				proformaDetalleDp1.setIdPro(productoSolicitado.getIdProd());
				proformaDetalleDP[i].setCantidad((Float) modelo
						.getValueAt(i, 0));
				proformaDetalleDP[i].setIdDescripcion(proformaDetalleDp1
						.getIdDescripcion());
				proformaDetalleDP[i].setIdPro(1);
				proformaDetalleDP[i].setTotal((Float) modelo.getValueAt(i, 3));

				for (int j = 0; j < cantidad; j++) {
					estado1 = proformaMd.insertarDetalle(conn.getConexion(),
							proformaDetalleDp1);

				}
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Ingrese el número del Recibo ", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}
		return estado1;
	}

	private void sugerirNumero() {
		if (estado.compareTo("Factura") == 0)
			jTextFieldNumeroRecibo.setText("" + sigProforma);
		else
			jTextFieldNumeroRecibo.setText("" + sigProforma);
	}

	/**
	 * This method initializes jButtonBuscarCliente
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscarCliente() {
		if (jButtonBuscarCliente == null) {
			jButtonBuscarCliente = new JButton();
			jButtonBuscarCliente.setBounds(new Rectangle(307, 133, 37, 38));
			jButtonBuscarCliente.setToolTipText("Buscar Cliente");
			jButtonBuscarCliente.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/usuario.png")));
			jButtonBuscarCliente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							lista.getPreferredSize();
							lista.setLocation(jTextFieldRUC.getX() + 80,
									jTextFieldRUC.getY() + 280);

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

} // @jve:decl-index=0:visual-constraint="10,10"
