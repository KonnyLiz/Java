package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tableUtil.modeloPagoPorReciboVenta;
import tableUtil.renderTablaPagoRecibo;
import Utilitarios.utilitarios;
import clases.tipoPagoRecibo;
import clasesBdd.conexionBdd;
import clasesBdd.tipoPagoBdd;
import clasesBdd.tipoPagoReciboBdd;

import com.toedter.calendar.JCalendar;

public class TipodePagoRecibo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel1 = null;
	private JLabel jLabelidtablapagorecibo = null;
	private JLabel jLabelIdTipoPago = null;
	private JLabel jLabelCantidad = null;
	private JLabel jLabelFecha = null;
	private JLabel Administraciónproveedor = null;
	private JLabel Administraciónproveedor1 = null;
	private JLabel Administraciónproveedor11 = null;
	private JLabel jLabelNumero = null;
	private JLabel jLabelTipoComprobante = null;
	private JPanel jPanel11 = null;
	private JLabel jLabelidtablapagorecibo1 = null;
	private JLabel jLabelIdTipoPago1 = null;
	private JLabel jLabelCantidad1 = null;
	private JTextField jTextFieldFecha = null;
	utilitarios util = new utilitarios();
	private JTextField jTextFieldFecha1 = null;
	private utilitarios util1 = null;
	private JButton jButtonCalendario = null;
	private JTextField jTextField2 = null;
	private JTextField jTextFieldCantidad = null;
	private JComboBox choiceTipoPago = null;
	private JComboBox jComboBoxEstado = null;
	private JTextArea jTextArea = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable = null;

	modeloPagoPorReciboVenta modelo = new modeloPagoPorReciboVenta();
	/*
	 * para uso del calendario
	 */
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="701,66"
	protected JPopupMenu popup;
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	protected boolean isInitialized;

	conexionBdd conn = new conexionBdd(); // @jve:decl-index=0:
	private JButton jButton = null;

	tipoPagoBdd tpMd = new tipoPagoBdd();
	Object[][] ArregloTipoPago = tpMd.seleccionarVectorDescripcionesCodigo(conn
			.getConexion()); // @jve:decl-index=0:
	renderTablaPagoRecibo render = null;
	private JLabel jLabelNumero1 = null;
	private JLabel jLabelSaldo = null;
	/**
	 * VARIABLES INICIALES DEL MODULO
	 */
	int tipoRecibo = 0;
	int idReciboTabla = 0;
	float saldo = 0;

	private JButton jButtonAceptar = null;
	private JPanel jPanel = null;
	private JButton jButton1 = null;

	/**
	 * This is the default constructor
	 */
	// public TipodePagoRecibo() {//version de prueba
	public TipodePagoRecibo(int tipoRecibo1, int idReciboTabla1, float saldo1) {
		super();

		tipoRecibo = tipoRecibo1;
		idReciboTabla = idReciboTabla1;// numero de recibo en papel
		saldo = util.Redondear("" + saldo1, 2);

		initialize();
		this.setClosable(true);
		this.setIconifiable(true);

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(636, 515);
		this.setTitle("Administración de Pago para recibos de venta");
		this.setContentPane(getJContentPane());

		mostarDatos(idReciboTabla, tipoRecibo);
		jTextField2.setText("" + idReciboTabla);
		jLabelNumero.setText("" + idReciboTabla);
		if (tipoRecibo != 2)
			jLabelTipoComprobante.setText("Nota de Venta");
		else
			jLabelTipoComprobante.setText("Factura");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelSaldo = new JLabel();
			jLabelSaldo.setBounds(new Rectangle(147, 228, 99, 25));
			jLabelSaldo.setForeground(Color.blue);

			jLabelSaldo.setText("0");
			jLabelSaldo.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelNumero1 = new JLabel();
			jLabelNumero1.setBounds(new Rectangle(23, 228, 116, 23));
			jLabelNumero1.setForeground(Color.red);
			jLabelNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNumero1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelNumero1.setText("Saldo : ");
			jLabelNumero1.setFont(new Font("Dialog", Font.BOLD, 13));
			jLabelTipoComprobante = new JLabel();
			jLabelTipoComprobante.setBounds(new Rectangle(183, 37, 143, 24));
			jLabelTipoComprobante.setForeground(Color.red);
			jLabelTipoComprobante.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelTipoComprobante
					.setHorizontalTextPosition(SwingConstants.CENTER);

			jLabelTipoComprobante.setFont(new Font("Dialog", Font.BOLD, 13));
			jLabelNumero = new JLabel();
			jLabelNumero.setBounds(new Rectangle(396, 36, 76, 25));
			jLabelNumero.setForeground(Color.red);
			jLabelNumero.setHorizontalAlignment(SwingConstants.CENTER);

			jLabelNumero.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNumero.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor11 = new JLabel();
			Administraciónproveedor11.setBounds(new Rectangle(328, 36, 65, 25));
			Administraciónproveedor11.setForeground(Color.blue);
			Administraciónproveedor11
					.setHorizontalAlignment(SwingConstants.RIGHT);
			Administraciónproveedor11.setText("Número :");
			Administraciónproveedor11
					.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor1 = new JLabel();
			Administraciónproveedor1.setBounds(new Rectangle(1, 36, 178, 25));
			Administraciónproveedor1.setForeground(Color.blue);
			Administraciónproveedor1
					.setHorizontalAlignment(SwingConstants.RIGHT);
			Administraciónproveedor1.setText("Tipo de Comprobante :");
			Administraciónproveedor1.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-5, 5, 642, 20));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor
					.setText("Tipo de pago para recibos de venta");
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(Administraciónproveedor, null);
			jContentPane.add(Administraciónproveedor1, null);
			jContentPane.add(Administraciónproveedor11, null);
			jContentPane.add(jLabelNumero, null);
			jContentPane.add(jLabelTipoComprobante, null);
			jContentPane.add(getJPanel11(), null);
			jContentPane.add(getJTextFieldFecha(), null);
			jContentPane.add(getJTextFieldFecha1(), null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextFieldCantidad(), null);
			jContentPane.add(getChoiceTipoPago(), null);
			jContentPane.add(getJComboBoxEstado(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabelNumero1, null);
			jContentPane.add(jLabelSaldo, null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setText("Fecha :");
			jLabelFecha.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabelFecha.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCantidad = new JLabel();
			jLabelCantidad.setText("Cantidad :");
			jLabelCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdTipoPago = new JLabel();
			jLabelIdTipoPago.setText("Tipo de Pago :");
			jLabelIdTipoPago.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelidtablapagorecibo = new JLabel();
			jLabelidtablapagorecibo.setText("Id Tabla :");
			jLabelidtablapagorecibo
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelidtablapagorecibo
					.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setHgap(12);
			gridLayout1.setVgap(12);
			gridLayout1.setColumns(1);
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout1);
			jPanel1.setBounds(new Rectangle(21, 74, 117, 139));
			jPanel1.add(jLabelidtablapagorecibo, null);
			jPanel1.add(jLabelIdTipoPago, null);
			jPanel1.add(jLabelCantidad, null);
			jPanel1.add(jLabelFecha, null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jLabelCantidad1 = new JLabel();
			jLabelCantidad1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCantidad1.setText("Estado :");
			jLabelIdTipoPago1 = new JLabel();
			jLabelIdTipoPago1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdTipoPago1.setText("Plazo :");
			jLabelidtablapagorecibo1 = new JLabel();
			jLabelidtablapagorecibo1
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelidtablapagorecibo1.setText("Detalle :");
			jLabelidtablapagorecibo1
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout11 = new GridLayout();
			gridLayout11.setRows(4);
			gridLayout11.setHgap(12);
			gridLayout11.setVgap(12);
			gridLayout11.setColumns(1);
			jPanel11 = new JPanel();
			jPanel11.setLayout(gridLayout11);
			jPanel11.setBounds(new Rectangle(317, 74, 117, 139));
			jPanel11.add(jLabelIdTipoPago1, null);
			jPanel11.add(jLabelCantidad1, null);
			jPanel11.add(jLabelidtablapagorecibo1, null);
		}
		return jPanel11;
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
			jTextFieldFecha.setBounds(new Rectangle(150, 185, 77, 25));
			jTextFieldFecha.setEditable(false);
		}
		return jTextFieldFecha;
	}

	/**
	 * This method initializes jTextFieldFecha1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFecha1() {
		if (jTextFieldFecha1 == null) {
			String string = getUtil1().fechaActual();
			jTextFieldFecha1 = new JTextField();
			jTextFieldFecha1.setBounds(new Rectangle(446, 75, 95, 24));
			jTextFieldFecha1.setEditable(false);
			jTextFieldFecha1.setText(string);
		}
		return jTextFieldFecha1;
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
	 * This method initializes jButtonCalendario
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario.setBounds(new Rectangle(555, 76, 28, 24));
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
	 * This method initializes jTextField2
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(151, 74, 84, 24));
			jTextField2.setText("" + idReciboTabla);
			jTextField2.setEditable(false);
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextFieldCantidad
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(new Rectangle(151, 148, 88, 25));
			jTextFieldCantidad.setText("0");
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(util
							.cortarCadenaFloat(jTextFieldCantidad.getText()));

				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
					// jTextFieldCantidad.setText(""+Float.parseFloat(""+jTextFieldCantidad.getText()));
				}
			});
			jTextFieldCantidad
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							jTextFieldCantidad.setText(""
									+ Float.parseFloat(""
											+ jTextFieldCantidad.getText()));
						}
					});
		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes choiceTipoPago
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getChoiceTipoPago() {
		if (choiceTipoPago == null) {
			choiceTipoPago = new JComboBox();
			cargarChoice();
			choiceTipoPago.setBounds(new Rectangle(151, 111, 155, 25));
		}
		return choiceTipoPago;
	}

	/**
	 * This method initializes jComboBoxEstado
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxEstado() {
		if (jComboBoxEstado == null) {
			jComboBoxEstado = new JComboBox();
			jComboBoxEstado.addItem("Pendiente");
			jComboBoxEstado.addItem("Pagado");
			jComboBoxEstado.setBounds(new Rectangle(446, 111, 100, 25));
		}
		return jComboBoxEstado;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setFont(new Font("Dialog", Font.PLAIN, 12));
			jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {

				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(util.cortarCadenaString(
							jTextFieldCantidad.getText(), 50));
				}
			});
		}
		return jTextArea;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(446, 149, 157, 66));
			jScrollPane.setViewportView(getJTextArea());

		}
		return jScrollPane;
	}

	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(24, 277, 582, 144));
			jScrollPane1.setViewportView(getJTable());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(modelo);
			jTable.setToolTipText("Registros Encontrados!");
			jTable.setRowSelectionAllowed(true);
			render = new renderTablaPagoRecibo();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(20);//
			jTable.getColumnModel().getColumn(1).setPreferredWidth(100);//
			jTable.getColumnModel().getColumn(2).setPreferredWidth(130);//
			jTable.getColumnModel().getColumn(3).setPreferredWidth(130);//
			jTable.getColumnModel().getColumn(4).setPreferredWidth(130);//
			jTable.getColumnModel().getColumn(5).setPreferredWidth(90);//
			jTable.getColumnModel().getColumn(6).setPreferredWidth(80);//
			jTable.getColumnModel().getColumn(7).setPreferredWidth(220);//
			jTable.setRowHeight(40);
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);

					if (modelo.getRowCount() > 0) {

						if (column == 6) {
							int res = pedirConfirmacion(""
									+ modelo.getValueAt(row, 1), ""
									+ modelo.getValueAt(row, 2));
							if (res == 0) {
								colocarSaldo(modelo.getValueAt(row, 2), 1);
								modelo.borraItem(row);

							} else {
								JOptionPane.showMessageDialog(null,
										"Eliminación Cancelada! ", "Alerta!",
										JOptionPane.ERROR_MESSAGE);
							}

						}
					}// if
				}
			});

		}
		return jTable;
	}

	/**
	 * carga las opciones para el choice
	 */
	private void cargarChoice() {

		tipoPagoBdd tpMd = new tipoPagoBdd();

		choiceTipoPago.removeAll();
		Object descripciones[] = tpMd.seleccionarDescripcionesTabla(conn
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceTipoPago.addItem("" + descripciones[i]);
		}
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(472, 245, 114, 27));
			jButton.setText("Añadir");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					float cantidad = Float.parseFloat(""
							+ util.Redondear(jTextFieldCantidad.getText()
									.trim(), 2));
					if (saldo > 0 && cantidad <= saldo && cantidad != 0)
						insertarPago();

					else
						JOptionPane
								.showMessageDialog(
										null,
										"No se puede agregar mas pagos!, la cantidad es inválida o el saldo es 0",
										"Aviso! ",
										JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return jButton;
	}

	/**
	 * inserta un elemento en la tabla
	 */
	/**
	 * inserta un pago según las opciones escogidas en pantalla
	 */

	public void insertarPago() {

		tipoPagoRecibo tipoPagoReciboObj1 = new tipoPagoRecibo();
		tipoPagoReciboObj1.setIdRecibo(Integer.parseInt("" + idReciboTabla));
		tipoPagoReciboObj1.setIdTipoPagoReciboPK(Integer.parseInt("" + 0));// cambiar
		// por
		// el
		// real
		tipoPagoReciboObj1
				.setCantidad("" + jTextFieldCantidad.getText().trim());

		tipoPagoReciboObj1.setFecha(jTextFieldFecha.getText());
		tipoPagoReciboObj1.setPlazo(jTextFieldFecha1.getText());
		tipoPagoReciboObj1.setEstado(jComboBoxEstado.getSelectedItem()
				.toString());
		tipoPagoReciboObj1.setDetalle(jTextArea.getText());
		tipoPagoReciboObj1.setTipoPagoString(choiceTipoPago.getSelectedItem()
				.toString());
		tipoPagoReciboObj1.setEliminar(new Boolean(true));
		colocarSaldo(tipoPagoReciboObj1.getCantidad(), 2);
		tipoPagoReciboObj1.setEliminar(new Boolean(true));
		modelo.nuevoItem(tipoPagoReciboObj1);

	}

	/**
	 * pide confirmación para la eliminación de un item en la tabla
	 * 
	 * @param pago
	 * @param cantidad
	 * @return
	 */

	int pedirConfirmacion(String pago, String cantidad) {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this, "Desea Eliminar el pago  :"
				+ pago + ", por la cantidad de: " + cantidad + "?  ",
				"Confirmar acción", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}

		return res;
	}

	/**
	 * carga los datos iniciales del recibo requerido 2010 ahora carga tipo de
	 * recibo bug corregido
	 * 
	 * @param idReciboTabla
	 */
	public void mostarDatos(int idReciboTabla, int tipoRecibo1) {
		System.out.println("num recibo" + idReciboTabla + " tipo rec:"
				+ tipoRecibo);
		jLabelSaldo.setText("" + util.Redondear("" + saldo, 2));

		tipoPagoReciboBdd tipoPagoReciboBdd1 = new tipoPagoReciboBdd();
		Object pagos[][] = tipoPagoReciboBdd1.seleccionarTipoPagoTotal(conn
				.getConexion(), idReciboTabla, tipoRecibo1);

		if (pagos.length != 0) {
			for (int i = 0; i < pagos.length; i++) {
				tipoPagoRecibo tipoPagoReciboObj1 = new tipoPagoRecibo();
				tipoPagoReciboObj1.setIdRecibo(Integer.parseInt(""
						+ idReciboTabla));
				tipoPagoReciboObj1.setIdTipoPagoReciboPK(idReciboTabla);// cambiar
				// por
				// el
				// real

				tipoPagoReciboObj1.setCantidad("" + pagos[i][0]);
				tipoPagoReciboObj1.setFecha("" + pagos[i][2]);
				tipoPagoReciboObj1.setPlazo("" + pagos[i][3]);
				tipoPagoReciboObj1.setEliminar(new Boolean(true));
				tipoPagoReciboObj1.setIdTipoPago(Integer.parseInt(""
						+ pagos[i][4]));
				for (int j = 0; j < ArregloTipoPago.length; j++) {
					if (ArregloTipoPago[j][1] != null) {

						if (ArregloTipoPago[j][1].toString().compareTo(
								"" + pagos[i][4]) == 0) {
							tipoPagoReciboObj1.setTipoPagoString(""
									+ ArregloTipoPago[j][0]);

						}
					}
				}// for

				tipoPagoReciboObj1.setEstado("" + pagos[i][5]);
				tipoPagoReciboObj1.setDetalle("" + pagos[i][1]);
				tipoPagoReciboObj1.setEliminar(new Boolean(true));
				modelo.nuevoItem(tipoPagoReciboObj1);
				colocarSaldo(pagos[i][0], 2);
			}
		}

	}

	/**
	 * coloca el saldo la opt=1 es sumar la opt=2 es restar
	 * 
	 * @param cantidad
	 * @param opt
	 */
	public void colocarSaldo(Object cantidad, int opt) {
		if (opt == 1) {
			saldo = saldo + Float.parseFloat("" + cantidad);

		}

		else {
			saldo = saldo - Float.parseFloat("" + cantidad);
		}
		saldo = util.Redondear("" + saldo, 2);
		jLabelSaldo.setText("" + util.Redondear("" + saldo, 2));

	}

	/**
	 * This method initializes jButtonAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Guardar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							aceptar();
						}
					});
		}
		return jButtonAceptar;
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
			gridLayout.setColumns(2);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.setBounds(new Rectangle(177, 441, 261, 25));
			jPanel.add(getJButtonAceptar(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Cancelar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButton1;
	}

	/**
	 * cierra la ventana
	 */
	public void salir() {
		this.dispose();

	}

	/**
	 * guarda los cambios
	 */
	public void aceptar() {
		int estado = 0;
		tipoPagoReciboBdd tipoPagoReciboBdd1 = new tipoPagoReciboBdd();
		tipoPagoRecibo tipoPagoReciboDP1 = new tipoPagoRecibo();
		// numero del recibo en papel no se repite
		tipoPagoReciboDP1.setIdRecibo(idReciboTabla);
		tipoPagoReciboBdd1.eliminar(conn.getConexion(), tipoPagoReciboDP1);
		//
		for (int i = 0; i < modelo.getRowCount(); i++) {
			tipoPagoReciboDP1.setTipoRecibo(tipoRecibo);
			tipoPagoReciboDP1.setIdRecibo(Integer.parseInt("" + idReciboTabla));
			for (int j = 0; j < ArregloTipoPago.length; j++)
				if (modelo.getValueAt(i, 1).toString().compareTo(
						"" + ArregloTipoPago[j][0]) == 0) {

					tipoPagoReciboDP1.setIdTipoPago(Integer.parseInt(""
							+ ArregloTipoPago[j][1]));// cambiar por el real

				}
			tipoPagoReciboDP1.setCantidad("" + modelo.getValueAt(i, 2));
			tipoPagoReciboDP1.setFecha("" + modelo.getValueAt(i, 3));
			tipoPagoReciboDP1.setPlazo("" + modelo.getValueAt(i, 4));
			tipoPagoReciboDP1.setEstado("" + modelo.getValueAt(i, 5));
			tipoPagoReciboDP1.setDetalle("" + modelo.getValueAt(i, 7));
			estado = tipoPagoReciboBdd1.insertar(conn.getConexion(),
					tipoPagoReciboDP1);
		}
		if (estado == 1)
			JOptionPane.showMessageDialog(null, "Se ha Modificado un Pago! ",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane
					.showMessageDialog(
							null,
							"problema al almacenar pago!, no existen Pagos para almacenar! ",
							"Aviso!", JOptionPane.INFORMATION_MESSAGE);
	}
} // @jve:decl-index=0:visual-constraint="10,10"
