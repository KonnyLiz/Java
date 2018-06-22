package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Utilitarios.utilitarios;
import clases.cliente;
import clases.tipoCliente;
import clasesBdd.clientesBdd;
import clasesBdd.conexionBdd;
import clasesBdd.tipoClienteBdd;

import com.toedter.calendar.JCalendar;

public class clienteVentanaAdm extends JInternalFrame {
	// public class clienteVentanaAdm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administracióndeclientes = null;
	private JLabel jLabelCedula = null;
	private JLabel jLabelNombre = null;
	private JLabel jLabelTelefono = null;
	private JLabel jLabelClienteDesde = null;
	private JLabel jLabelDirección = null;
	private JLabel jLabelSexo = null;
	private JLabel jLabelTipoCliente = null;
	private JTextField jTextFieldCedula = null;
	private JTextField jTextFieldNombre = null;
	private JTextField jTextFieldClienteDesde = null;
	private JTextField jTextFieldDireccion = null;
	private Choice choiceSexo = null;
	private Choice choiceTipoCliente = null;
	private JTextField jTextFieldTelefono = null;
	private JLabel jLabelEmail = null;
	private JTextField jTextFieldEmail = null;
	private JButton jButtonseleccionarFecha = null;

	/**
	 * objetos del usuario
	 */
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	tipoClienteBdd tpMd = new tipoClienteBdd(); // @jve:decl-index=0:
	conexionBdd con = new conexionBdd();
	cliente clienteDp = new cliente(0, "", "", "", "", "", "", ""); // @jve:decl-index=0:
	clientesBdd clienteMd = new clientesBdd();
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	int opcionModulo = 0;
	/**
	 * Permite saber si el usuario estubo haciendo algúna acción
	 */
	boolean generandoInformacion = false;
	/**
	 * para uso del calendario
	 */
	/**
	 * Advierte cuando la fecha esta mal ingresada
	 */
	int banderaFecha = 0;
	protected SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd"); // @jve:decl-index=0:
	protected JCalendar jcalendar; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup;
	String diaAnterior = "01"; // @jve:decl-index=0:
	String BufferComparacion = "01"; // @jve:decl-index=0:
	protected boolean isInitialized;

	/**
	 * This is the default constructor
	 */
	public clienteVentanaAdm() {
		super();
		initialize();
	}

	public clienteVentanaAdm(String ruc) {
		super();
		initialize();
		jTextFieldCedula.setText(ruc);
		clienteDp.setCiRuc(ruc);
		cargarDatos();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(543, 424);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración Clientes");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(119, 15, 273, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes.setText("Administración de Clientes");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJButtonseleccionarFecha(), null);
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
			jPanelBotones.setBounds(new Rectangle(51, 346, 425, 28));
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
	 * This method initializes jPanelEtiquetas
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			jLabelEmail = new JLabel();
			jLabelEmail.setText("Email :");
			jLabelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipoCliente = new JLabel();
			jLabelTipoCliente.setText("Tipo de Cliente :");
			jLabelTipoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipoCliente.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelSexo = new JLabel();
			jLabelSexo.setText("Sexo :");
			jLabelSexo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDirección = new JLabel();
			jLabelDirección.setText("Dirección :");
			jLabelDirección.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelClienteDesde = new JLabel();
			jLabelClienteDesde.setText("Cliente Desde :");
			jLabelClienteDesde.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono = new JLabel();
			jLabelTelefono.setText("Teléfonos :");
			jLabelTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Nombre :");
			jLabelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCedula = new JLabel();
			jLabelCedula.setText("Cédula o Ruc :");
			jLabelCedula.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(8);
			gridLayout.setHgap(20);
			gridLayout.setVgap(12);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(53, 50, 165, 251));
			jPanelEtiquetas.add(jLabelCedula, null);
			jPanelEtiquetas.add(jLabelNombre, null);
			jPanelEtiquetas.add(jLabelTelefono, null);
			jPanelEtiquetas.add(jLabelClienteDesde, null);
			jPanelEtiquetas.add(jLabelDirección, null);
			jPanelEtiquetas.add(jLabelSexo, null);
			jPanelEtiquetas.add(jLabelTipoCliente, null);
			jPanelEtiquetas.add(jLabelEmail, null);
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
			gridLayout1.setHgap(20);
			gridLayout1.setVgap(12);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(231, 49, 137, 251));
			jPanelInputs.add(getJTextFieldCedula(), null);
			jPanelInputs.add(getJTextFieldNombre(), null);
			jPanelInputs.add(getJTextFieldTelefono(), null);
			jPanelInputs.add(getJTextFieldClienteDesde(), null);
			jPanelInputs.add(getJTextFieldDireccion(), null);
			jPanelInputs.add(getChoiceSexo(), null);
			jPanelInputs.add(getChoiceTipoCliente(), null);
			jPanelInputs.add(getJTextFieldEmail(), null);
		}
		return jPanelInputs;
	}

	/**
	 * This method initializes jTextFieldCedula
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCedula() {
		if (jTextFieldCedula == null) {
			try {

				jTextFieldCedula = new JFormattedTextField();
				jTextFieldCedula
						.setToolTipText("Ingrese el número de Cédula o Ruc");

			} catch (Exception e) {

				e.printStackTrace();
			}
			jTextFieldCedula
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							clienteDp.setCiRuc(jTextFieldCedula.getText()
									.trim());
							if (jTextFieldCedula.getText().trim().compareTo("") != 0
									&& opcionModulo == 0) {
								jTextFieldNombre.setEnabled(true);
								cargarDatos();
							} else {
								if (generandoInformacion
										&& jTextFieldCedula.getText().trim()
												.compareTo("") == 0)
									JOptionPane.showMessageDialog(null,
											"Este Campo no puede estar vacío!",
											"Alerta!",
											JOptionPane.ERROR_MESSAGE);
							}

						}
					});
			jTextFieldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCedula.setText(util.cortarCadenaString(
							jTextFieldCedula.getText(), 13));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCedula.setText(util.cortarCadenaString(
							jTextFieldCedula.getText().trim(), 13));
					generandoInformacion = true;
				}
			});
		}
		return jTextFieldCedula;
	}

	/**
	 * This method initializes jTextFieldNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();

			jTextFieldNombre.setToolTipText("Ingrese el nombre del cliente");
			jTextFieldNombre.setEnabled(false);
			jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNombre.setText(util.cortarCadenaString(
							jTextFieldNombre.getText(), 90));
				}

			});
			jTextFieldNombre
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							clienteDp.setNombre(jTextFieldNombre.getText()
									.trim());
							if (jTextFieldNombre.getText().compareTo("") != 0) {
								jTextFieldTelefono.setEnabled(true);
								jTextFieldTelefono.setFocusable(true);
								choiceTipoCliente.setEnabled(true);
								choiceSexo.setEnabled(true);

							}
						}
					});
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldClienteDesde
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldClienteDesde() {
		if (jTextFieldClienteDesde == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				jTextFieldClienteDesde = new JFormattedTextField(mascara);

				jTextFieldClienteDesde.setText(util.fechaActual());
				jTextFieldClienteDesde.setToolTipText("Ingrese la fecha");
				jTextFieldClienteDesde.setEditable(false);
				jTextFieldClienteDesde.setEnabled(false);
				jTextFieldClienteDesde
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {
								BufferComparacion = jTextFieldClienteDesde
										.getText();
								BufferComparacion = BufferComparacion
										.toString();
								clienteDp
										.setClienteDesde(jTextFieldClienteDesde
												.getText());
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

								if (jTextFieldClienteDesde.getText() != "") {

									jTextFieldDireccion.setEnabled(true);

								}

							}
						});
				jTextFieldClienteDesde
						.setToolTipText("Escoja la fecha de inicio con el botón de la derecha");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return jTextFieldClienteDesde;
	}

	/**
	 * This method initializes jTextFieldDireccion
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDireccion() {
		if (jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion
					.setToolTipText("Ingrese la Dirección  del cliente");
			jTextFieldDireccion.setEnabled(false);
			jTextFieldDireccion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							clienteDp.setDireccion(jTextFieldDireccion
									.getText().trim());
							if (jTextFieldDireccion.getText().compareTo("") != 0) {
								choiceSexo.setEnabled(true);
							}
						}
					});
			jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldDireccion.setText(util.cortarCadenaString(
							jTextFieldDireccion.getText(), 50));
				}
			});
		}
		return jTextFieldDireccion;
	}

	/**
	 * This method initializes choiceSexo
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceSexo() {
		if (choiceSexo == null) {
			choiceSexo = new Choice();
			choiceSexo.setEnabled(false);
			choiceSexo.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					clienteDp.setSexo(choiceSexo.getSelectedItem());
					if (choiceSexo.isEnabled()) {
						choiceTipoCliente.setEnabled(true);
					}

				}
			});
			choiceSexo.addItem("Masculino");
			choiceSexo.addItem("Femenino");
		}
		return choiceSexo;
	}

	/**
	 * This method initializes choiceTipoCliente
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceTipoCliente() {
		if (choiceTipoCliente == null) {
			choiceTipoCliente = new Choice();
			choiceTipoCliente.setEnabled(false);
			choiceTipoCliente
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							if (choiceTipoCliente.isEnabled()) {
								choiceTipoCliente.setEnabled(true);
								jTextFieldEmail.setEnabled(true);
								choiceTipoCliente.transferFocus();
							}
						}
					});
			choiceTipoCliente.removeAll();
			Object descripciones[] = tpMd.seleccionarDescripcionesTabla(con
					.getConexion());
			for (int i = 0; i < descripciones.length; i++) {
				choiceTipoCliente.addItem("" + descripciones[i]);
			}
		}
		return choiceTipoCliente;
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
				jTextFieldTelefono.setText("(02)222-2222/(09)999-9999");
				jTextFieldTelefono
						.setToolTipText("Ingrese el número o números de teléfono");
				jTextFieldTelefono.setEnabled(false);
				jTextFieldTelefono
						.addFocusListener(new java.awt.event.FocusAdapter() {
							@Override
							public void focusLost(java.awt.event.FocusEvent e) {
								clienteDp.setTelefono(jTextFieldTelefono
										.getText().trim());
								if (jTextFieldTelefono.getText().compareTo("") != 0) {
									jTextFieldClienteDesde.setEnabled(true);
									jButtonseleccionarFecha.setEnabled(true);
									jTextFieldTelefono.transferFocus();
								}
							}
						});
				jTextFieldCedula
						.setToolTipText("Escoja la fecha de inicio con el botón de la derecha");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jTextFieldTelefono;
	}

	/**
	 * This method initializes jTextFieldEmail
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setText("SinCorreo@sistema.ec");
			jTextFieldEmail.setEnabled(false);
			jTextFieldEmail
					.setToolTipText("Ingrese una Dirección de correo electrónico (OPCIONAL)");
			jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.cortarCadenaString(jTextFieldEmail.getText().trim(),
							90);

				}

				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (!util.isEmail(jTextFieldEmail.getText().trim())) {

					}
				}
			});
			jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					clienteDp.setEmail((jTextFieldEmail.getText().trim()
							.toString()));

				}
			});
			jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldEmail.setText(util.cortarCadenaString(
							jTextFieldEmail.getText(), 200));
				}
			});
		}
		return jTextFieldEmail;
	}

	/**
	 * This method initializes jButtonseleccionarFecha
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonseleccionarFecha() {
		if (jButtonseleccionarFecha == null) {
			jButtonseleccionarFecha = new JButton();
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
								if (jTextFieldClienteDesde.getText().compareTo(
										"") == 0) {

									jTextFieldClienteDesde.setText(fechaString);

								} else {
									jTextFieldClienteDesde.setText(fechaString);
									try {
										diaAnterior = jTextFieldClienteDesde
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
			jButtonseleccionarFecha.setBounds(new Rectangle(374, 143, 29, 24));
			jButtonseleccionarFecha
					.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonseleccionarFecha.setIcon(new ImageIcon(getClass()
					.getResource("/UtilJpg/calendario1.png")));
			jButtonseleccionarFecha.setEnabled(false);
			jButtonseleccionarFecha.setText("");
			jButtonseleccionarFecha
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							int x = jButtonseleccionarFecha.getWidth()
									- (int) popup.getPreferredSize().getWidth();
							int y = jButtonseleccionarFecha.getY()
									+ jButtonseleccionarFecha.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar.setCalendar(calendar);
							popup.show(jButtonseleccionarFecha, x + 170,
									y - 140);
						}
					});
		}
		return jButtonseleccionarFecha;
	}

	public void cargarDatos() {
		devolverTc();

		clienteDp.setCiRuc(jTextFieldCedula.getText().trim());
		clienteDp.setNombre(jTextFieldNombre.getText().trim());
		clienteDp.setTelefono(jTextFieldTelefono.getText().trim());
		clienteDp.setDireccion(jTextFieldDireccion.getText().trim());
		clienteDp.setEmail((jTextFieldEmail.getText().trim().toString()));
		/**
		 * detección de acción
		 */
		clientesBdd clienteMd = new clientesBdd();
		clienteDp = clienteMd.buscarInfoDeUnRegistro(con.getConexion(),
				clienteDp);

		jTextFieldCedula.setEnabled(true);
		jTextFieldCedula.setEditable(false);

	}// cargarDatos

	public void devolverTc() {
		tipoCliente tcDp = new tipoCliente(0, "");
		tcDp.setDescripcion(choiceTipoCliente.getSelectedItem());
		tcDp = tpMd.buscarInfoDeUnRegistro(con.getConexion(), tcDp);
		clienteDp.setIdTc(tcDp.getIdTc());
		// clienteDp.setSexo(choiceSexo.getSelectedItem());
		clienteDp = clienteMd.buscarInfoDeUnRegistro(con.getConexion(),
				clienteDp);

		jTextFieldNombre.setEnabled(true);
		jTextFieldCedula.transferFocus();
		// System.out.print("fdfd:"+clienteDp.getSexo());
		if (clienteDp.getSexo().compareTo("") != 0) {
			/**
			 * se modifica o se elimina
			 */
			opcionModulo = 2;
			jTextFieldCedula.setEnabled(false);
			jButtonseleccionarFecha.setEnabled(true);

			jTextFieldNombre.setText(clienteDp.getNombre());
			jTextFieldTelefono.setText(clienteDp.getTelefono());
			jTextFieldClienteDesde.setText(clienteDp.getClienteDesde());
			jTextFieldDireccion.setText(clienteDp.getDireccion());
			choiceSexo.select(clienteDp.getSexo());

			devolverIdTc();
			jTextFieldEmail.setText(clienteDp.getEmail());
			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
			popup.setVisible(false);

		} else {

			/**
			 * nuevo Registro
			 */
			opcionModulo = 1;
			jButtonIngresar.setEnabled(true);
			jButtonModificar.setEnabled(false);
			jButtonEliminar.setEnabled(false);
		}// end else

	}// devolverTc

	/**
	 * opciones con la base de datos insertar modifcar eliminar
	 */

	private void insertar() {
		if (opcionModulo == 1) {
			if (cargarObjetos() == 1) {
				// System.out.print(""+clienteDp.getDireccion());

				clienteMd.insertar(con.getConexion(), clienteDp);
				bloqueo();

			}

		}
	}// insertar

	private void modificar() {

		cargarObjetos();
		if (opcionModulo == 2) {

			if (cargarObjetos() == 1) {
				clienteMd.modificar(con.getConexion(), clienteDp);
				bloqueo();

			} else {

			}

		}
	}// modificar

	private void eliminar() {
		if (opcionModulo == 2) {
			if (cargarObjetos() == 1) {
				clienteMd.eliminar(con.getConexion(), clienteDp);
				bloqueo();
			}
		}
	}// eliminar

	private void limpiar() {
		/*
		 * opcionModulo = 0; cliente clienteDp = new cliente(0, "", "", "", "",
		 * "", "", ""); // @jve:decl-index=0: clienteDp.setCiRuc("");
		 * opcionModulo = 0; jButtonIngresar.setEnabled(false);
		 * jButtonModificar.setEnabled(false);
		 * jButtonEliminar.setEnabled(false); jTextFieldCedula.setText("");
		 * jTextFieldCedula.setEnabled(true); jTextFieldNombre.setText("");
		 * jTextFieldNombre.setEnabled(false); jTextFieldTelefono.setText("");
		 * jTextFieldTelefono.setEnabled(false);
		 * jTextFieldDireccion.setText("");
		 * jTextFieldDireccion.setEnabled(false);
		 * jTextFieldEmail.setText("SinCorreo@sistema.ec");
		 * jTextFieldEmail.setEnabled(false);
		 * jTextFieldTelefono.setText("(02)222-2222/(09)999-9999");
		 * jTextFieldClienteDesde.setText(util.fechaActual());
		 */

		clienteVentanaAdm clienteVentana = new clienteVentanaAdm();
		// clienteVentana.setBounds(this.getX(), this.getY(),this.getWidth() ,
		// this.getHeight());
		clienteVentana.getPreferredSize();
		clienteVentana.setLocation(this.getX(), this.getY());
		this.getParent().add(clienteVentana);
		this.dispose();
		clienteVentana.setVisible(true);
		// clienteVentanaAdm cliente
	}// limpiar

	private int cargarObjetos() {
		int permitir = 1;
		clienteDp.setCiRuc(jTextFieldCedula.getText());
		if (clienteDp.getCiRuc().compareTo("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"El campo Cédula o Ruc está Vacío! ", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}
		clienteDp.setNombre(jTextFieldNombre.getText());
		if (clienteDp.getNombre().compareTo("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null, "El campo Nombre está Vacío! ",
					"Alerta!", JOptionPane.ERROR_MESSAGE);
		}
		clienteDp.setTelefono(jTextFieldTelefono.getText());
		clienteDp.setClienteDesde(jTextFieldClienteDesde.getText());
		clienteDp.setDireccion(jTextFieldDireccion.getText());
		clienteDp.setSexo(choiceSexo.getSelectedItem());
		tipoCliente tcDp = new tipoCliente(0, choiceTipoCliente
				.getSelectedItem());
		tcDp = tpMd.buscarInfoDeUnRegistro(con.getConexion(), tcDp);
		clienteDp.setIdTc(tcDp.getIdTc());
		return permitir;

	}// cargarObjetos

	public void bloqueo() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldCedula.setEnabled(false);
	}

	/**
	 * devuelve el id de un tipo de cliente
	 */
	public void devolverIdTc() {

		tipoCliente tcDp = new tipoCliente(0, "");
		tcDp.setIdTc(clienteDp.getIdTc());
		tcDp = tpMd.buscarInfoDeUnRegistro2(con.getConexion(), tcDp);
		choiceTipoCliente.select(tcDp.getDescripcion());
	}

} // @jve:decl-index=0:visual-constraint="10,10"
