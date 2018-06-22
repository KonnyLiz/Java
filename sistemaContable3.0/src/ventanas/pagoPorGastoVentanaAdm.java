package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import reportes.comprobanteEgresoLlenarForm;
import tableUtil.modeloTablaPagosProveedor;
import tableUtil.renderTablaPagoProveedores;
import Utilitarios.utilitarios;
import clases.arregloTempHash;
import clases.arregloTempHash2Items;
import clases.comprasGastos;
import clases.comprobanteEgreso;
import clases.cuentasBancos;
import clases.pagoGastoProvedoresClassModeloTabla;
import clases.pagosPorGastos;
import clases.tipoPago;
import clasesBdd.comprasGastosBdd;
import clasesBdd.conexionBdd;
import clasesBdd.cuentasBancosBdd;
import clasesBdd.pagoPorGastosBdd;
import clasesBdd.tipoPagoBdd;

import com.toedter.calendar.JCalendar;

public class pagoPorGastoVentanaAdm extends JInternalFrame {
	// public class pagoPorGastoVentanaAdm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JLabel jLabelBiuscar = null;
	private JTextField jTextFieldIdBusqueda = null;
	private JPanel jPanelSeparador = null;
	private JPanel jPanelEtiquetas = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JList jListExistentes = null;
	private JPanel jPanelEtiquetas1 = null;
	private JLabel jLabelComprobantePago = null;
	private JLabel jLabelTipoPago = null;
	private JLabel jLabelCuentaQuePago = null;
	private JLabel jLabelTotalPagado = null;
	private JLabel jLabelPlazoPago = null;
	private JLabel jLabelPlazoPago1 = null;
	private JPanel jPanelEtiquetas11 = null;
	private JTextField jTextFieldNumeroDocumentoPago = null;
	private Choice choiceTipoPago = null;
	private Choice choiceCuentaOrigen = null;
	private JTextField jTextFieldTotal = null;
	private JButton jButtonCalendario = null;
	private JTextField jTextFieldFecha = null;
	private JTextField jTextFieldBeneficiario = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	pagoPorGastosBdd pagoPorGastoMd = new pagoPorGastosBdd(); // @jve:decl-index=0:
	pagosPorGastos pagoPorGastosDp = new pagosPorGastos(0, 0, 0, 0, 0, 0, 0,
			"", "", ""); // @jve:decl-index=0:
	comprasGastosBdd comprasGastosMd = new comprasGastosBdd(); // @jve:decl-index=0:
	comprasGastos comprasGastosDp = new comprasGastos(0, 0, "", "", 0, 0, 0,
			"", 0, 0, ""); // @jve:decl-index=0:
	comprobanteEgreso comprobanteEgresoDp = new comprobanteEgreso(0, 0, "", 0,
			"", ""); // @jve:decl-index=0:
	int Id_com_gas = 0;
	tipoPago tipoPagoDp = new tipoPago(0, "");
	tipoPagoBdd tipoPagoMd = new tipoPagoBdd();

	cuentasBancos cuentasBancosDP = new cuentasBancos(0, 0, "", "", "");
	cuentasBancosBdd cuentasBancosMd = new cuentasBancosBdd();

	conexionBdd conn = new conexionBdd(); // @jve:decl-index=0:
	// contiene los totales pagados de las deudas
	// pendientes
	Hashtable temp1 = pagoPorGastoMd
			.seleccionarTotalesPagadosDeudasObjetoTablaHash(conn.getConexion()); // @jve:decl-index=0:
	Hashtable temp = comprasGastosMd
			.seleccionarDescripcionesObjetoTablaHash(conn.getConexion()); // @jve:decl-index=0:
	Hashtable tempTipoPagos = tipoPagoMd
			.seleccionarCodigoObjetoCodigoDesripcionTablaHash(conn
					.getConexion()); // @jve:decl-index=0:
	Hashtable tempCuentas = cuentasBancosMd
			.seleccionarCuentasIdNumCuentaHash(conn.getConexion()); // @jve:decl-index=0:
	Hashtable tempTipoPagosValidar = tipoPagoMd
			.seleccionarCodigoObjetoDesripcionCodigoTablaHash(conn
					.getConexion()); // @jve:decl-index=0:
	Hashtable tempCuentasValidar = cuentasBancosMd
			.seleccionarCuentasNumCuentaIdHash(conn.getConexion()); // @jve:decl-index=0:

	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private int existenItems = 1;
	private int opcionModulo = 0;
	private boolean busqueda = false;
	/**
	 * para uso del calendario
	 */

	int banderaFecha = 0;
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup; // @jve:decl-index=0:visual-constraint="586,10"
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	protected boolean isInitialized;
	private JLabel jLabel = null;
	private JLabel jLabelTotalPagado1 = null;
	private JLabel jLabelSaldo = null;
	JDesktopPane JDesktopPanePrin;
	private modeloTablaPagosProveedor modelo = null; // @jve:decl-index=0:
	private JTable jTable = null;
	// @jve:decl-index=0:
	private JScrollPane jScrollPane = null;
	int rowTemp = 0;
	int columnTemp = 0;
	pagoGastoProvedoresClassModeloTabla descripciones[] = comprasGastosMd
			.seleccionarDescripciones(con.getConexion());

	/**
	 * This is the default constructor
	 */
	// public pagoPorGastoVentanaAdm() {
	public pagoPorGastoVentanaAdm(JDesktopPane JDesktopPanePrin1) {
		super();
		JDesktopPanePrin = JDesktopPanePrin1;
		initialize();
		cargarLista();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(809, 621);
		this.setContentPane(getJContentPane());
		this.setTitle(" Pagos Realizados por una compra o gasto");
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(46, 21, 309, 27));
			jLabel.setForeground(new Color(239, 11, 0));
			jLabel
					.setText("Ingrese El \" ID de Pago\"  Para Buscar información   => ");
			jLabel.setVisible(false);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJLabelBiuscar(), null);
			jContentPane.add(getJTextFieldIdBusqueda(), null);
			jContentPane.add(getJPanelSeparador(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJTextFieldId(), null);
			jContentPane.add(getJPanelEtiquetas1(), null);
			jContentPane.add(getJPanelEtiquetas11(), null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
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
			jPanelBotones.setBounds(new Rectangle(157, 537, 438, 30));
			jPanelBotones.add(getJButtonIngresar(), null);
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
	 * This method initializes jLabelBiuscar
	 *
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabelBiuscar() {
		if (jLabelBiuscar == null) {
			jLabelBiuscar = new JLabel();
			jLabelBiuscar.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar.setText("Buscar Pago :");
			jLabelBiuscar.setBounds(new Rectangle(606, 24, 79, 23));
			jLabelBiuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
		}
		return jLabelBiuscar;
	}

	/**
	 * This method initializes jTextFieldIdBusqueda
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIdBusqueda() {
		if (jTextFieldIdBusqueda == null) {
			jTextFieldIdBusqueda = new JTextField();
			jTextFieldIdBusqueda.setBounds(new Rectangle(688, 23, 95, 23));
			jTextFieldIdBusqueda.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldIdBusqueda.setForeground(new Color(254, 0, 0));
			jTextFieldIdBusqueda
					.setToolTipText("Ingrese el Id del Recibo para Buscar");
			jTextFieldIdBusqueda.setText("0");
			jTextFieldIdBusqueda.setEditable(true);
			jTextFieldIdBusqueda.setEnabled(true);
			jTextFieldIdBusqueda
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							buscarItem();
						}
					});
			jTextFieldIdBusqueda
					.addMouseListener(new java.awt.event.MouseAdapter() {
						@Override
						public void mouseExited(java.awt.event.MouseEvent e) {
							jLabel.setVisible(false);
							jLabel
									.setText("Ingrese El \" ID de Pago\"  Para Buscar información   => ");

						}

						@Override
						public void mouseEntered(java.awt.event.MouseEvent e) {
							if (existenItems == 0) {

								jTextFieldIdBusqueda.setEnabled(false);
								jLabel.setText("No hay Items para mostrar! ");

							}
							jLabel.setVisible(true);
						}
					});

			jTextFieldIdBusqueda
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
			jTextFieldIdBusqueda
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							jTextFieldIdBusqueda.setText(util
									.cortarCadenaString(jTextFieldIdBusqueda
											.getText().trim(), 12));
							busqueda = true;
						}
					});
		}
		return jTextFieldIdBusqueda;
	}

	/**
	 * This method initializes jPanelSeparador
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelSeparador() {
		if (jPanelSeparador == null) {
			jPanelSeparador = new JPanel();
			jPanelSeparador.setLayout(new GridBagLayout());
			jPanelSeparador.setBounds(new Rectangle(4, 58, 794, 4));
			jPanelSeparador.setBorder(BorderFactory
					.createEtchedBorder(EtchedBorder.LOWERED));
		}
		return jPanelSeparador;
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
			jLabelDescripcion.setText("ID de Pago :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(25);
			gridLayout.setVgap(12);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(39, 70, 133, 25));
			jPanelEtiquetas.add(jLabelDescripcion, null);
		}
		return jPanelEtiquetas;
	}

	/**
	 * This method initializes jTextFieldId
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setBounds(new Rectangle(178, 72, 80, 23));
			jTextFieldId.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldId.setForeground(new Color(254, 0, 0));
			jTextFieldId.setToolTipText("Identificador De Registro en Tabla");
			String secuenciaSiguiente = ""
					+ pagoPorGastoMd.seleccionarMaxAutoIncrementTabla(con
							.getConexion());
			jTextFieldId.setText("" + secuenciaSiguiente);
			jTextFieldId.setEditable(false);
			jTextFieldId.setEnabled(true);
		}
		return jTextFieldId;
	}

	/**
	 * This method initializes jPanelEtiquetas1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas1() {
		if (jPanelEtiquetas1 == null) {
			jLabelTotalPagado1 = new JLabel();
			jLabelTotalPagado1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTotalPagado1.setText("Saldo :");
			jLabelTotalPagado1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPlazoPago1 = new JLabel();
			jLabelPlazoPago1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPlazoPago1.setText("Beneficiario o cuenta de Destino  :");
			jLabelPlazoPago1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPlazoPago = new JLabel();
			jLabelPlazoPago.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPlazoPago.setText("Plazo de pago :");
			jLabelPlazoPago.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTotalPagado = new JLabel();
			jLabelTotalPagado.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTotalPagado.setText("Total Pagado :");
			jLabelTotalPagado.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelCuentaQuePago = new JLabel();
			jLabelCuentaQuePago.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCuentaQuePago.setText("Numero de Cuenta de Origen :");
			jLabelCuentaQuePago.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTipoPago = new JLabel();
			jLabelTipoPago.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipoPago.setText("Tipo De Pago :");
			jLabelTipoPago.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelComprobantePago = new JLabel();
			jLabelComprobantePago.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelComprobantePago.setText("Número de Documento de pago  :");
			jLabelComprobantePago
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(8);
			gridLayout1.setHgap(25);
			gridLayout1.setVgap(12);
			gridLayout1.setColumns(1);
			jPanelEtiquetas1 = new JPanel();
			jPanelEtiquetas1.setLayout(gridLayout1);
			jPanelEtiquetas1.setBounds(new Rectangle(170, 281, 206, 243));
			jPanelEtiquetas1.add(jLabelComprobantePago, null);
			jPanelEtiquetas1.add(jLabelTipoPago, null);
			jPanelEtiquetas1.add(jLabelCuentaQuePago, null);
			jPanelEtiquetas1.add(jLabelTotalPagado, null);
			jPanelEtiquetas1.add(jLabelTotalPagado1, null);
			jPanelEtiquetas1.add(jLabelPlazoPago, null);
			jPanelEtiquetas1.add(jLabelPlazoPago1, null);
		}
		return jPanelEtiquetas1;
	}

	/**
	 * This method initializes jPanelEtiquetas11
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas11() {
		if (jPanelEtiquetas11 == null) {
			jLabelSaldo = new JLabel();
			jLabelSaldo.setText("0");
			jLabelSaldo.setFont(new Font("Dialog", Font.BOLD, 20));
			jLabelSaldo.setForeground(new Color(0, 130, 255));
			GridLayout gridLayout11 = new GridLayout();
			gridLayout11.setRows(8);
			gridLayout11.setHgap(25);
			gridLayout11.setVgap(12);
			gridLayout11.setColumns(1);
			jPanelEtiquetas11 = new JPanel();
			jPanelEtiquetas11.setLayout(gridLayout11);
			jPanelEtiquetas11.setBounds(new Rectangle(409, 279, 161, 245));
			jPanelEtiquetas11.add(getJTextFieldNumeroDocumentoPago(), null);
			jPanelEtiquetas11.add(getChoiceTipoPago(), null);
			jPanelEtiquetas11.add(getChoiceCuentaOrigen(), null);
			jPanelEtiquetas11.add(getJTextFieldTotal(), null);
			jPanelEtiquetas11.add(jLabelSaldo, null);
			jPanelEtiquetas11.add(getJTextFieldFecha(), null);
			jPanelEtiquetas11.add(getJTextFieldBeneficiario(), null);
		}
		return jPanelEtiquetas11;
	}

	/**
	 * This method initializes jTextFieldNumeroDocumentoPago
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumeroDocumentoPago() {
		if (jTextFieldNumeroDocumentoPago == null) {
			jTextFieldNumeroDocumentoPago = new JTextField();
			jTextFieldNumeroDocumentoPago.setEnabled(false);
			jTextFieldNumeroDocumentoPago.setForeground(new Color(254, 0, 0));
			jTextFieldNumeroDocumentoPago
					.setToolTipText("Ingrese el Número de Comprobante de Pago");
			jTextFieldNumeroDocumentoPago.setText("0");
			jTextFieldNumeroDocumentoPago.setEditable(true);
			jTextFieldNumeroDocumentoPago.setFont(new Font("Dialog",
					Font.PLAIN, 20));
			jTextFieldNumeroDocumentoPago
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldNumeroDocumentoPago.setText(""
									+ util.cortarCadenaString(
											jTextFieldNumeroDocumentoPago
													.getText().trim(), 11));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
			jTextFieldNumeroDocumentoPago
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							choiceTipoPago.setEnabled(true);
							choiceCuentaOrigen.setEnabled(true);
							jTextFieldTotal.setEnabled(true);
						}
					});
		}
		return jTextFieldNumeroDocumentoPago;
	}

	/**
	 * This method initializes choiceTipoPago
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceTipoPago() {
		if (choiceTipoPago == null) {
			choiceTipoPago = new Choice();
			choiceTipoPago.setEnabled(false);
			cargarListaTipoPago();
		}
		return choiceTipoPago;
	}

	/**
	 * This method initializes choiceCuentaOrigen
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceCuentaOrigen() {
		if (choiceCuentaOrigen == null) {
			choiceCuentaOrigen = new Choice();
			choiceCuentaOrigen.setEnabled(false);
			cargarCuentasOrigen();
		}
		return choiceCuentaOrigen;
	}

	/**
	 * This method initializes jTextFieldTotal
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTotal() {
		if (jTextFieldTotal == null) {
			jTextFieldTotal = new JTextField();
			jTextFieldTotal.setEnabled(false);
			jTextFieldTotal.setForeground(new Color(254, 0, 0));
			jTextFieldTotal.setToolTipText("Ingrese el total Pagado");
			jTextFieldTotal.setText("0");
			jTextFieldTotal.setEditable(true);
			jTextFieldTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
			jTextFieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (Float.parseFloat(jTextFieldTotal.getText()) > Float
							.parseFloat(jLabelSaldo.getText()))
						jTextFieldTotal.setText(jLabelSaldo.getText());
					jTextFieldTotal.setText(""
							+ util.cortarCadenaString(jTextFieldTotal.getText()
									.trim(), 15));

				}

			});
			jTextFieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldTotal.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					jButtonCalendario.setEnabled(true);
					jTextFieldBeneficiario.setEnabled(true);
				}
			});
		}
		return jTextFieldTotal;
	}

	/**
	 * This method initializes jButtonCalendario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
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
			jButtonCalendario.setBounds(new Rectangle(575, 438, 28, 25));
			jButtonCalendario.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario.setEnabled(false);
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
							popup.show(jButtonCalendario, x + 200, y - 350);
						}
					});
		}
		return jButtonCalendario;
	}

	/**
	 * This method initializes jTextFieldFecha
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha() {
		if (jTextFieldFecha == null) {
			jTextFieldFecha = new JTextField();
			jTextFieldFecha.setText(util.fechaActual());
			jTextFieldFecha.setEnabled(true);
			jTextFieldFecha.setEditable(false);
			jTextFieldFecha
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							BufferComparacion = jTextFieldFecha.getText();
							BufferComparacion = BufferComparacion.toString();
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
		}
		return jTextFieldFecha;
	}

	/**
	 * This method initializes jTextFieldBeneficiario
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldBeneficiario() {
		if (jTextFieldBeneficiario == null) {
			jTextFieldBeneficiario = new JTextField();
			jTextFieldBeneficiario.setEnabled(false);
		}
		return jTextFieldBeneficiario;
	}

	/**
	 * Funciones de usuario
	 */
	private void buscarItem() {
		pagoPorGastosDp.setIdPagoPorGasto(Integer.parseInt(jTextFieldIdBusqueda
				.getText().trim()));
		pagoPorGastosDp = pagoPorGastoMd.buscarInfoDeUnRegistro(conn
				.getConexion(), pagoPorGastosDp);
		Id_com_gas = pagoPorGastosDp.getIdCompraGasto();

		if (pagoPorGastosDp.getBeneficiario().trim() == "") {
			if (busqueda)
				JOptionPane.showMessageDialog(null, "El registro no Existe! ",
						"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			opcionModulo = 2;
			jButtonEliminar.setEnabled(true);
			// jButtonModificar.setEnabled(true);
			jTextFieldNumeroDocumentoPago.setEnabled(true);
			jTextFieldIdBusqueda.setEnabled(false);

			jTextFieldNumeroDocumentoPago.setText(""
					+ pagoPorGastosDp.getNumeroComprobante());
			arregloTempHash2Items claseTemporalTiposPago = new arregloTempHash2Items(
					"", "");
			arregloTempHash2Items claseTemporalCuentas = new arregloTempHash2Items(
					"", "");
			jLabelSaldo.setVisible(false);
			claseTemporalTiposPago = (arregloTempHash2Items) tempTipoPagos.get(pagoPorGastosDp.getIdTipoDePago());
			choiceTipoPago.select("" + pagoPorGastosDp.getIdTipoDePago());
			/**/

			claseTemporalCuentas = (arregloTempHash2Items) tempCuentas.get(pagoPorGastosDp.getIdCuentaTablaBanco());
			try {
				choiceCuentaOrigen
						.select("" + claseTemporalCuentas.descripcion);
			} catch (Exception a1) {
			}

			jTextFieldTotal.setText("" + pagoPorGastosDp.getTotal());

			// jTextFieldTotal.setText(temporal.totalPagado);
			// jLabelRetencion1.setText(temporal.totalRet);
			// busqueda del total pagado para el saldo
			/*
			 * arregloTempHash temporal2 = (arregloTempHash) temp1
			 * .get(temporalSaldo.id_tabla);
			 */
			try {/*
					 * jLabelSaldo .setText("" +
					 * (Float.parseFloat(temporalSaldo.totalPagado) - Float
					 * .parseFloat(temporal2.totalPagado) - Float
					 * .parseFloat(temporalSaldo.totalRet)));
					 */
			} catch (Exception stringVacio) {
				/*
				 * jLabelSaldo.setText("" +
				 * (Float.parseFloat(temporalSaldo.totalPagado) - Float
				 * .parseFloat(temporalSaldo.totalRet)));
				 */
			}
			jTextFieldFecha.setText(pagoPorGastosDp.getPlazoDePago());
			jTextFieldBeneficiario.setText(pagoPorGastosDp.getBeneficiario());
		}

	}

	private void limpiar() {

		pagoPorGastoVentanaAdm pagoporGastosVentana = new pagoPorGastoVentanaAdm(
				JDesktopPanePrin);
		// facturaVentana facturaVentanaW= new
		// facturaVentana(null,false,null,false);
		pagoporGastosVentana.getPreferredSize();
		pagoporGastosVentana.setLocation(this.getX(), this.getY());
		JDesktopPanePrin.add(pagoporGastosVentana);
		this.dispose();
		pagoporGastosVentana.setVisible(true);

	}

	private void insertar() {
		validar();

		pagoPorGastoMd.insertar(conn.getConexion(), pagoPorGastosDp);

		pagoPorGastoMd.insertarComEgreso(conn.getConexion(),
				comprobanteEgresoDp);
		comprobanteEgresoLlenarForm reporteJasper = new comprobanteEgresoLlenarForm();
		reporteJasper.recibirDatosExternos(comprobanteEgresoDp);
		jButtonIngresar.setEnabled(false);

	}

	private void modificar() {
		validar();
		pagoPorGastoMd.modificar(conn.getConexion(), pagoPorGastosDp);
	}

	private void eliminar() {
		validar();

		comprasGastosBdd comprasGastosMd = new comprasGastosBdd();
		comprasGastos comprasGastosBddDP = new comprasGastos(0, 0, "", "", 0,
				0, 0, "", 0, 0, "");
		comprasGastosBddDP.setIdCompraGasto(Id_com_gas);
		comprasGastosMd.modificarEstadoCompra(conn.getConexion(),
				comprasGastosBddDP);
		pagoPorGastoMd.eliminar(conn.getConexion(), pagoPorGastosDp);

		pagoPorGastoMd.eliminarComEgreso(conn.getConexion(),
				comprobanteEgresoDp);

		jButtonIngresar.setEnabled(false);
	}

	/**
	 * carga items "deudas" a la grilla
	 */
	private void cargarLista() {
		borrarTabla();
		borrarTabla();
		borrarTabla();
		borrarTabla();
		borrarTabla();
		borrarTabla();

		for (int i = 0; i < descripciones.length; i++) {
			if (descripciones[i] != null) {

				pagoGastoProvedoresClassModeloTabla item = new pagoGastoProvedoresClassModeloTabla(
						descripciones[i].getIdTabla(), descripciones[i]
								.getTipo(), descripciones[i]
								.getNumeroComprobante(), descripciones[i]
								.getFecha(), descripciones[i].getDetalle(),
						descripciones[i].getProveedor(), true, descripciones[i]
								.getTotalFacturado());
				modelo.nuevoItem(item);

			}

		}

		if (modelo.getRowCount() == 0) {
			pagoGastoProvedoresClassModeloTabla item = new pagoGastoProvedoresClassModeloTabla(
					"Sin Datos", "Sin Datos", "Sin Datos", "", "", "", true, "");
			modelo.nuevoItem(item);
		}
	}// cargarLista

	private void cargarListaTipoPago() {
		choiceTipoPago.removeAll();
		Object descripciones[] = tipoPagoMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceTipoPago.add("" + descripciones[i]);
		}

	}// cargarListaTipoPago

	private void cargarCuentasOrigen() {
		choiceCuentaOrigen.removeAll();
		Object descripciones[] = cuentasBancosMd
				.seleccionarDescripcionesTabla(con.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceCuentaOrigen.add("" + descripciones[i]);
		}

	}// cargarLista

	private void validar() {

		pagoPorGastosDp.setNumeroComprobante(Integer
				.parseInt(jTextFieldNumeroDocumentoPago.getText()));
		comprobanteEgresoDp.setNumeroRecibo(pagoPorGastosDp
				.getNumeroComprobante());// comprobante de egreso
		pagoPorGastosDp.setIdTipoDePago(Integer.parseInt(""
				+ tempTipoPagosValidar.get(""
						+ choiceTipoPago.getSelectedItem())));
		pagoPorGastosDp
				.setIdCuentaTablaBanco(Integer.parseInt(""
						+ tempCuentasValidar.get(choiceCuentaOrigen
								.getSelectedItem())));
		pagoPorGastosDp.setTotal(Float.parseFloat(""
				+ jTextFieldTotal.getText().trim()));
		comprobanteEgresoDp.setTotal(pagoPorGastosDp.getTotal());// comprobante
		// Egreso
		pagoPorGastosDp.setBeneficiario(jTextFieldBeneficiario.getText());
		pagoPorGastosDp.setPlazoDePago(jTextFieldFecha.getText());
		comprobanteEgresoDp.setFecha(jTextFieldFecha.getText());// comprobante
		// Egreso

		// Egreso
		if (modelo.getValueAt(rowTemp, 1).toString().compareToIgnoreCase(
				"FACTURA") == 0) {
			comprobanteEgresoDp.setTipoComprobante("FACTURA");
		} else {
			comprobanteEgresoDp.setTipoComprobante("NOTA DE VENTA");
		}
		comprobanteEgresoDp.setDescripcion("Pago de deuda a:" + ": "
				+ modelo.getValueAt(rowTemp, 5) + "  Número del recibo : "
				+ modelo.getValueAt(rowTemp, 2));
		comprobanteEgresoDp.setIdComprobante(pagoPorGastoMd
				.seleccionarMaxAutoIncrementTablaComprobanteEgreso(conn
						.getConexion()));
		pagoPorGastosDp.setIdCompraPago(Integer.parseInt(modelo.getValueAt(
				rowTemp, 0).toString()));
		busqueda = false;
		pagoPorGastosDp.setFechaGeneracionDeuda(util.fechaActual());

	}// validar

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloProducto
	 */
	private modeloTablaPagosProveedor getModelo() {
		if (modelo == null) {
			modelo = new modeloTablaPagosProveedor();
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

			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(40);// id
			jTable.getColumnModel().getColumn(1).setPreferredWidth(100);// tipo
			jTable.getColumnModel().getColumn(2).setPreferredWidth(120);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(90);// fecha
			jTable.getColumnModel().getColumn(4).setPreferredWidth(210);// detalle
			jTable.getColumnModel().getColumn(5).setPreferredWidth(110);// proveedor
			jTable.getColumnModel().getColumn(6).setPreferredWidth(50);// proveedor
			jTable.getColumnModel().getColumn(7).setPreferredWidth(1);// vacio
			renderTablaPagoProveedores render = new renderTablaPagoProveedores();
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

					if (modelo.getRowCount() > 0) {

						String dato = modelo.getValueAt(rowTemp, 0).toString()
								.trim();//
						if (dato.compareToIgnoreCase("Sin Datos") != 0) {

							if (opcionModulo == 0 && columnTemp == 6) {

								jButtonIngresar.setEnabled(true);
								jTextFieldIdBusqueda.setEnabled(false);
								// busqueda de la compra o gasto realizado para
								// obtener el código y el total
								String idTabla = dato;
								arregloTempHash temporal2 = (arregloTempHash) temp1
										.get(idTabla);

								try {
									Float saldo = Float.parseFloat(""
											+ modelo.getValueAt(rowTemp, 7))
											- Float.parseFloat(""
													+ temporal2.totalPagado);
									jLabelSaldo.setText("" + saldo);
									jLabelSaldo
											.setText(""
													+ util.Redondear(""
															+ jLabelSaldo
																	.getText(),
															2));
								} catch (Exception stringVacio) {
									Float saldo = Float.parseFloat(""
											+ modelo.getValueAt(rowTemp, 7));
									jLabelSaldo.setText("" + saldo);
								}
								jTextFieldNumeroDocumentoPago.setEnabled(true);
							}// if modulo opción

						} else {
							if (dato.compareToIgnoreCase("no hay registros") == 0)
								JOptionPane.showMessageDialog(null,
										"Registro Inválido!", "Alerta!",
										JOptionPane.INFORMATION_MESSAGE);
						}
					}// if
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
			jScrollPane.setBounds(new Rectangle(39, 106, 734, 166));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * borra la tabla
	 */
	private void borrarTabla() {
		try {
			int cont = 0;
			while (modelo.getRowCount() != 0) {
				modelo.borraItem(cont);
				cont++;
			}

		} catch (Exception fueraDeLimite) {
			int cont = 0;
		}

	}

} // @jve:decl-index=0:visual-constraint="-78,37"
