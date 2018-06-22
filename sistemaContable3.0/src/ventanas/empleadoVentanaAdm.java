package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Dialog.dialogMostrarImagen;
import Utilitarios.utilitarios;
import clases.empleado;
import clases.rol;
import clasesBdd.conexionBdd;
import clasesBdd.empleadoBdd;
import clasesBdd.rolBdd;

import com.toedter.calendar.JCalendar;

import filtros.FiltroFicheros;

public class empleadoVentanaAdm extends JInternalFrame {
//	public class empleadoVentanaAdm extends JFrame {
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
	private JLabel jLabelFEchaIngreso = null;
	private JLabel jLabelEstado = null;
	private JLabel jLabelCargo = null;
	private JLabel jLabelSalario = null;
	private JLabel jLabelDireccion = null;
	private JLabel jLabelTelefono = null;
	private JLabel jLabesexo = null;
	private JLabel jLabelFoto = null;
	private JLabel jLabelRol = null;
	private JLabel jLabelFechaDeNacimiento = null;
	/**
	 * Variables del usuario
	 *
	 */
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	int opcionModulo = 0;

	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	rolBdd rolMd = new rolBdd(); // @jve:decl-index=0:
	conexionBdd con = new conexionBdd();
	empleado empleadoDp = new empleado(0, 0, "", null, "", "", null, "", "", 0,
			"no existe", "", "", null); // @jve:decl-index=0:
	empleadoBdd empleadoMd = new empleadoBdd();
	rol rolDp = new rol(0, ""); // @jve:decl-index=0:
	int intercambiar = 1;
	private JButton jButtonCalendario = null;
	private JButton jButtonCalendario2 = null;
	private JTextField jTextFieldCEdula = null;
	private JTextField jTextFieldNombre = null;
	private JTextField jTextFieldDireccion = null;
	private JTextField jTextFieldTelefono = null;
	private JTextField jTextFieldFechaNac = null;
	private Choice choiceSexo = null;
	private JTextField jTextFieldFechaIngreso = null;
	private Choice choiceRol = null;
	private Choice choiceEstado = null;
	private JTextField jTextFieldSalario = null;
	private JTextField jTextFieldFoto = null;

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
	protected boolean isInitialized;
	/**
	 * calendario 2
	 */
	protected JCalendar jcalendar2; // @jve:decl-index=0:visual-constraint="565,56"
	protected JPopupMenu popup2;
	private JButton jButtonAbrirArchivo = null;
	private Choice choiceCargo = null;
	ImageIcon icono = null;
	protected JPopupMenu popup3;
	private JButton jButtonVerFoto = null;

	/**
	 * This is the default constructor
	 */
	public empleadoVentanaAdm() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(587, 534);
		this.setContentPane(getJContentPane());
		this.setClosable(true);
		this.setIconifiable(true);
		this.setTitle("Administración de Empleados");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(187, 16, 273, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes.setText("Administración de Empleados");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(getJButtonCalendario2(), null);
			jContentPane.add(getJButtonAbrirArchivo(), null);
			jContentPane.add(getJButtonVerFoto(), null);
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
			jPanelBotones.setBounds(new Rectangle(76, 448, 425, 28));
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
			jLabelFechaDeNacimiento = new JLabel();
			jLabelFechaDeNacimiento.setText("Fecha De Nacimiento :");
			jLabelFechaDeNacimiento
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelRol = new JLabel();
			jLabelRol.setText("Rol :");
			jLabelRol.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFoto = new JLabel();
			jLabelFoto.setText("Foto :");
			jLabelFoto.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabesexo = new JLabel();
			jLabesexo.setText("Sexo :");
			jLabesexo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono = new JLabel();
			jLabelTelefono.setText("Teléfono :");
			jLabelTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDireccion = new JLabel();
			jLabelDireccion.setText("Dirección :");
			jLabelDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelSalario = new JLabel();
			jLabelSalario.setText("Salario :");
			jLabelSalario.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCargo = new JLabel();
			jLabelCargo.setText("Cargo :");
			jLabelCargo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelEstado = new JLabel();
			jLabelEstado.setText("Estado :");
			jLabelEstado.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFEchaIngreso = new JLabel();
			jLabelFEchaIngreso.setText("Fecha de Ingreso :");
			jLabelFEchaIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Nombre :");
			jLabelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCedula = new JLabel();
			jLabelCedula.setText("Cédula :");
			jLabelCedula.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(12);
			gridLayout.setHgap(25);
			gridLayout.setVgap(4);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(50, 50, 165, 366));
			jPanelEtiquetas.add(jLabelCedula, null);
			jPanelEtiquetas.add(jLabelNombre, null);
			jPanelEtiquetas.add(jLabelDireccion, null);
			jPanelEtiquetas.add(jLabelTelefono, null);
			jPanelEtiquetas.add(jLabelFechaDeNacimiento, null);
			jPanelEtiquetas.add(jLabesexo, null);
			jPanelEtiquetas.add(jLabelFEchaIngreso, null);
			jPanelEtiquetas.add(jLabelRol, null);
			jPanelEtiquetas.add(jLabelCargo, null);
			jPanelEtiquetas.add(jLabelEstado, null);
			jPanelEtiquetas.add(jLabelSalario, null);
			jPanelEtiquetas.add(jLabelFoto, null);
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
			gridLayout1.setRows(12);
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(5);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(233, 52, 146, 363));
			jPanelInputs.add(getJTextFieldCEdula(), null);
			jPanelInputs.add(getJTextFieldNombre(), null);
			jPanelInputs.add(getJTextFieldDireccion(), null);
			jPanelInputs.add(getJTextFieldTelefono(), null);
			jPanelInputs.add(getJTextFieldFechaNac(), null);
			jPanelInputs.add(getChoiceSexo(), null);
			jPanelInputs.add(getJTextFieldFechaIngreso(), null);
			jPanelInputs.add(getChoiceRol(), null);
			jPanelInputs.add(getChoiceCargo(), null);
			jPanelInputs.add(getChoiceEstado(), null);
			jPanelInputs.add(getJTextFieldSalario(), null);
			jPanelInputs.add(getJTextFieldFoto(), null);
		}
		return jPanelInputs;
	}

	/**
	 * This method initializes jButtonCalendario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setBounds(new Rectangle(389, 171, 30, 29));
			jButtonCalendario.setEnabled(false);
			jButtonCalendario.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
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
							popup.show(jButtonCalendario, x + 180, y - 195);
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
								if (jTextFieldFechaNac.getText().compareTo("") == 0) {

									jTextFieldFechaNac.setText(fechaString);

								} else {
									jTextFieldFechaNac.setText(fechaString);
									try {
										diaAnterior = jTextFieldFechaNac
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
	 * This method initializes jButtonCalendario2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCalendario2() {
		if (jButtonCalendario2 == null) {
			jButtonCalendario2 = new JButton();
			jButtonCalendario2.setBounds(new Rectangle(389, 232, 28, 30));
			jButtonCalendario2.setEnabled(false);
			jButtonCalendario2.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario2.setText("");
			jButtonCalendario2
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							/**
							 * action permorfed para el boton del calendario
							 */
							int x = jButtonCalendario2.getWidth()
									- (int) popup.getPreferredSize().getWidth();
							int y = jButtonCalendario2.getY()
									+ jButtonCalendario2.getHeight();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							jcalendar2.setCalendar(calendar);
							popup2.show(jButtonCalendario2, x + 180, y - 255);
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
								// diaAnterior=jTextFieldFechaInicial.getText().substring(8,10);
								Date fecha = jcalendar2.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								if (jTextFieldFechaIngreso.getText().compareTo(
										"") == 0) {

									jTextFieldFechaIngreso.setText(fechaString);

								} else {
									jTextFieldFechaIngreso.setText(fechaString);
									try {
										diaAnterior = jTextFieldFechaIngreso
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
	 * This method initializes jTextFieldCEdula
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCEdula() {
		if (jTextFieldCEdula == null) {
			jTextFieldCEdula = new JTextField();
			jTextFieldCEdula.setNextFocusableComponent(jTextFieldNombre);
			jTextFieldCEdula.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCEdula.setText(util.cortarCadenaString(
							jTextFieldCEdula.getText(), 13));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldCEdula
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							empleadoDp.setRuc(jTextFieldCEdula.getText());
							buscarRegistro();

						}
					});

		}
		return jTextFieldCEdula;
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
			jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNombre.setText(util.cortarCadenaString(
							jTextFieldNombre.getText(), 101));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.verificarTexto(e);
				}
			});
			jTextFieldNombre
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							empleadoDp.setNombre(jTextFieldNombre.getText());
							jTextFieldDireccion.setEnabled(true);
							jTextFieldNombre.transferFocus();
						}
					});
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldDireccion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDireccion() {
		if (jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.setEnabled(false);
			jTextFieldDireccion.setToolTipText("Ingrese la Dirección");
			jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldDireccion.setText(util.cortarCadenaString(
							jTextFieldDireccion.getText(), 60));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {

				}
			});
			jTextFieldDireccion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							empleadoDp.setDireccion(jTextFieldDireccion
									.getText());
							jTextFieldTelefono.setEnabled(true);
							jTextFieldDireccion.transferFocus();

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
				jTextFieldTelefono.setText("(02)333-3333/(09)888-8888");
				jTextFieldTelefono.setEnabled(false);
				jTextFieldTelefono
						.setToolTipText("Ingrese el número de teléfono");

				jTextFieldTelefono
						.addFocusListener(new java.awt.event.FocusAdapter() {
							@Override
							public void focusLost(java.awt.event.FocusEvent e) {
								empleadoDp.setTelefono(jTextFieldTelefono
										.getText());
								jButtonCalendario.setEnabled(true);
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return jTextFieldTelefono;
	}

	/**
	 * This method initializes jTextFieldFechaNac
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFechaNac() {
		if (jTextFieldFechaNac == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				jTextFieldFechaNac = new JFormattedTextField(mascara);
				jTextFieldFechaNac.setEnabled(false);
				jTextFieldFechaNac.setText(util.fechaActual());
				jTextFieldFechaNac.setEditable(false);
				jTextFieldFechaNac
						.setToolTipText("Escoja la fecha de Nacimiento con el botón de la derecha");
				jTextFieldFechaNac
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {
								jButtonCalendario2.setEnabled(true);
								choiceRol.setEnabled(true);
								choiceCargo.setEnabled(true);
								choiceEstado.setEnabled(true);
								jTextFieldSalario.setEnabled(true);
								/**
								 * calendario1
								 */
								choiceSexo.setEnabled(true);
								BufferComparacion = jTextFieldFechaNac
										.getText();
								BufferComparacion = BufferComparacion
										.toString();
								jTextFieldFechaNac.setEnabled(true);

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

								empleadoDp
										.setFechaNacimiento(jTextFieldFechaNac
												.getText());
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
		return jTextFieldFechaNac;
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
					empleadoDp.setSexo(choiceSexo.getSelectedItem());
					jButtonCalendario2.setEnabled(true);
				}
			});
			choiceSexo.addItem("Masculino");
			choiceSexo.addItem("Femenino");
		}
		return choiceSexo;
	}

	/**
	 * This method initializes jTextFieldFechaIngreso
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFechaIngreso() {
		if (jTextFieldFechaIngreso == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####-##-##");
				jTextFieldFechaIngreso = new JFormattedTextField(mascara);
				jTextFieldFechaIngreso.setEnabled(false);
				jTextFieldFechaIngreso.setText(util.fechaActual());
				jTextFieldFechaIngreso
						.setToolTipText("Escoja la fecha de Ingreso con el botón de la derecha");

				jTextFieldFechaIngreso
						.addCaretListener(new javax.swing.event.CaretListener() {
							public void caretUpdate(
									javax.swing.event.CaretEvent e) {
								/**
								 * calendario1
								 */
								BufferComparacion = jTextFieldFechaIngreso
										.getText();
								BufferComparacion = BufferComparacion
										.toString();

								try {
									BufferComparacion = BufferComparacion
											.substring(8, 10).trim();
								} catch (Exception e1) {
									BufferComparacion = "01";
									/** en caso de ser null el textfield */
								}

								if (diaAnterior
										.compareToIgnoreCase(BufferComparacion) != 0) {

									popup2.setVisible(false);

								} else {
									popup2.setVisible(true);
								}

								empleadoDp
										.setFechaIngreso(jTextFieldFechaIngreso
												.getText());
								/**
								 *
								 * calendario1
								 */
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jTextFieldFechaIngreso;
	}

	/**
	 * This method initializes choiceRol
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceRol() {
		if (choiceRol == null) {
			choiceRol = new Choice();
			choiceRol.setEnabled(false);
			choiceRol.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					rolDp.setDescripcion(choiceSexo.getSelectedItem());
					rolDp = rolMd.buscarInfoDeUnRegistro(con.getConexion(),
							rolDp);
					empleadoDp.setIdRol(rolDp.getId());
				}
			});
			cargarChoice();

		}
		return choiceRol;
	}

	private void cargarChoice() {
		choiceRol.removeAll();
		Object descripciones[] = rolMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceRol.addItem("" + descripciones[i]);
		}
	}

	/**
	 * This method initializes choiceEstado
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceEstado() {
		if (choiceEstado == null) {
			choiceEstado = new Choice();
			choiceEstado.setEnabled(false);
			choiceEstado.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					empleadoDp.setEstado(choiceEstado.getSelectedItem());
				}
			});
			choiceEstado.addItem("Activo");
			choiceEstado.addItem("Desactivado");
		}
		return choiceEstado;
	}

	/**
	 * This method initializes jTextFieldSalario
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldSalario() {
		if (jTextFieldSalario == null) {
			try {

				jTextFieldSalario = new JTextField();
				jTextFieldSalario.setEnabled(true);
				jTextFieldSalario.setText("0");
				jTextFieldSalario
						.setToolTipText("Ingrese el salario del trabajador");
				jTextFieldSalario
						.addFocusListener(new java.awt.event.FocusAdapter() {
							@Override
							public void focusLost(java.awt.event.FocusEvent e) {
								if (jTextFieldSalario.getText().trim() == "") {
									jTextFieldSalario.setText("0");
								}
								empleadoDp
										.setSalario(Float
												.parseFloat(jTextFieldSalario
														.getText()));
							}
						});
				jTextFieldSalario
						.addKeyListener(new java.awt.event.KeyAdapter() {
							@Override
							public void keyReleased(java.awt.event.KeyEvent e) {
								jTextFieldSalario.setText(util
										.cortarCadenaFloat(jTextFieldSalario
												.getText()));
							}

							@Override
							public void keyTyped(java.awt.event.KeyEvent e) {
								util.verificar(e);
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return jTextFieldSalario;
	}

	/**
	 * This method initializes jTextFieldFoto
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFoto() {
		if (jTextFieldFoto == null) {
			jTextFieldFoto = new JTextField();
			jTextFieldFoto.setEditable(false);
		}
		return jTextFieldFoto;
	}

	/**
	 * This method initializes jButtonAbrirArchivo
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAbrirArchivo() {
		if (jButtonAbrirArchivo == null) {
			jButtonAbrirArchivo = new JButton();
			jButtonAbrirArchivo.setBounds(new Rectangle(384, 381, 93, 24));
			jButtonAbrirArchivo.setToolTipText("Abrir un archivo de Imagen");
			jButtonAbrirArchivo.setText("Explorar");
			jButtonAbrirArchivo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String nombreArchivo = cargarfotoDiscoDuro();
							// System.out.print("C:\\workspace\\sistemaContable3.0\\src\\images\\chica.jpg");
							mostrarJpgImg(nombreArchivo);
							jTextFieldFoto.setText(nombreArchivo);

						}
					});
		}
		return jButtonAbrirArchivo;
	}

	/**
	 * proceso imagenes
	 */

	/**
	 * This method initializes choiceCargo
	 *
	 * @return java.awt.Choice
	 */
	private Choice getChoiceCargo() {
		if (choiceCargo == null) {
			choiceCargo = new Choice();
			choiceCargo.setEnabled(false);
			choiceCargo.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					empleadoDp.setCargo(choiceCargo.getSelectedItem());
				}
			});
			choiceCargo.addItem("Diseño");
			choiceCargo.addItem("Bodeguero");
			choiceCargo.addItem("Vendedor");
			choiceCargo.addItem("Adm Almacén");
			choiceCargo.addItem("Contador");
			choiceCargo.addItem("Sistemas");
			choiceCargo.addItem("Secretaria");
		}
		return choiceCargo;
	}

	public void validarClases() {
		empleadoDp.setRuc(jTextFieldCEdula.getText());
		empleadoDp.setNombre(jTextFieldNombre.getText().trim());
		empleadoDp.setDireccion(jTextFieldDireccion.getText());
		empleadoDp.setTelefono(jTextFieldTelefono.getText());
		empleadoDp.setFechaNacimiento(jTextFieldFechaNac.getText());
		empleadoDp.setSexo(choiceSexo.getSelectedItem());
		empleadoDp.setFechaIngreso(jTextFieldFechaIngreso.getText());
		rolDp.setDescripcion(choiceRol.getSelectedItem());
		rolDp = rolMd.buscarInfoDeUnRegistro(con.getConexion(), rolDp);
		empleadoDp.setIdRol(rolDp.getId());
		empleadoDp.setEstado(choiceEstado.getSelectedItem());
		empleadoDp.setSalario(Float.parseFloat(jTextFieldSalario.getText()));
		empleadoDp.setCargo(choiceCargo.getSelectedItem());
		// empleadoDp.setFoto();

	}

	/**
	 * Comprueba que no haya fallos en el formulario
	 *
	 * @return
	 */
	private int cargarObjetos() {
		int permitir = 1;
		if (empleadoDp.getRuc().compareTo("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"El campo Cédula o Ruc está Vacío! ", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}

		if (empleadoDp.getNombre().compareTo("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null, "El campo Nombre está Vacío! ",
					"Alerta!", JOptionPane.ERROR_MESSAGE);
		}
		if (util.compararFechasString(jTextFieldFechaIngreso.getText(),
				jTextFieldFechaNac.getText())) {
			permitir = 0;
			JOptionPane
					.showMessageDialog(
							null,
							"La fecha de Ingreso, no puede ser Menor a la Fecha de Ingreso! ",
							"Alerta!", JOptionPane.ERROR_MESSAGE);
		}
		return permitir;

	}// cargarObjetos()

	/*
	 * Muestra menú para cargar una imagen
	 *
	 *
	 *
	 */

	public String cargarfotoDiscoDuro() {
        String nombredelaImagen=null;

		Frame parent = new Frame();
		  JFileChooser fc= new JFileChooser();
	        fc.addChoosableFileFilter(new FiltroFicheros());
	        fc.setAcceptAllFileFilterUsed(false);
	        int returnVal = fc.showDialog(parent,"Aceptar");
/**
 * carga la imagen a un archivo temp a subir
 * a la base de datos
 */
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	    //  System.out.println(""+fc.getCurrentDirectory() +"ddd :" +fc.getSelectedFile().toString());
	        	File ffile = new File(""+fc.getSelectedFile());

				nombredelaImagen =  ""+fc.getSelectedFile();

				try {

					File fichero = new File("bin/buffer.jpg");
					if (ffile.length() > 80000) {
						JOptionPane.showMessageDialog(null,
								"La imagen escogida es muy grande! ", "Alerta!",
								JOptionPane.ERROR_MESSAGE);
						ffile = new File("bin/images/sfoto.jpg");
						nombredelaImagen = "bin/images/sfoto.jpg";

					}

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
	            File file = fc.getSelectedFile();

	        } else {
	        	JOptionPane.showMessageDialog(null,
						"No se ha seleccionado un archivo!", "Aviso",
						JOptionPane.ERROR_MESSAGE);
	        }


		return nombredelaImagen;
	}// end cargar foto

	public void mostrarJpgImg(String nombreArchivo) {
		final ventanas.mostrarImagen ventImg = new ventanas.mostrarImagen(null);
		ventImg.setBounds(0, 0, ventImg.getHeight(), ventImg.getWidth());
		ventImg.actualizaImagen(nombreArchivo);
		ventImg.setVisible(true);
		ventImg.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				ventImg.setVisible(false);

			}
		});

	}

	public void buscarRegistro() {
		if (jTextFieldCEdula.getText().trim().compareTo("") != 0) {
			empleadoDp = empleadoMd.buscarInfoDeUnRegistro(con.getConexion(),
					empleadoDp);

			if (empleadoDp.getDireccion().compareTo("no existe") != 0
					&& opcionModulo == 0) {
				opcionModulo = 2;// activa modificación y eliminación
				empleadoMd.cargarImgFromBdd(con.getConexion(), empleadoDp);
				jTextFieldNombre.setEnabled(true);
				rolDp.setDescripcion(choiceRol.getSelectedItem());// busco el
				// rol
				rolMd.buscarInfoDeUnRegistro(con.getConexion(), rolDp);
				jTextFieldCEdula.setText(empleadoDp.getRuc());
				jTextFieldNombre.setText(empleadoDp.getNombre() + " "
						+ empleadoDp.getApellido());
				jTextFieldDireccion.setText(empleadoDp.getDireccion());
				jTextFieldTelefono.setText(empleadoDp.getTelefono());
				jTextFieldFechaNac.setText(empleadoDp.getFechaNacimiento());
				jTextFieldFechaIngreso.setText(empleadoDp.getFechaIngreso());
				jTextFieldSalario.setText("" + empleadoDp.getSalario());
				choiceSexo.select(empleadoDp.getSexo());
				choiceRol.select(rolDp.getDescripcion());
				choiceCargo.select(empleadoDp.getCargo());
				choiceEstado.select(empleadoDp.getEstado());
				jButtonCalendario.setEnabled(true);
				jTextFieldFoto.setText("buffer.jpg");
				jButtonCalendario2.setEnabled(true);
				jButtonIngresar.setEnabled(false);
				jButtonModificar.setEnabled(true);
				jButtonEliminar.setEnabled(true);
				jTextFieldCEdula.setEnabled(false);
				jButtonVerFoto.setEnabled(true);
				popup2.setVisible(false);
				popup.setVisible(false);
				jTextFieldCEdula.setEditable(false);

			} else {
				jTextFieldSalario.setEnabled(false);
				jTextFieldNombre.setEnabled(true);
				opcionModulo = 1;// activa insertar
				jTextFieldFoto.setText("sfoto.png");
				jTextFieldNombre.setEnabled(true);
				jButtonIngresar.setEnabled(true);
				jButtonModificar.setEnabled(false);
				jButtonEliminar.setEnabled(false);
				jTextFieldCEdula.setEditable(false);
			}// end else1
		} else {
			if (opcionModulo != 0)
				JOptionPane.showMessageDialog(null,
						"El campo Cédula o Ruc está Vacío! ", "Alerta!",
						JOptionPane.ERROR_MESSAGE);
		}// end else2

	}// buscarRegistro

	public void limpiar() {
		empleadoVentanaAdm empleadoVentanaw = new empleadoVentanaAdm();
		empleadoVentanaw.getPreferredSize();
		empleadoVentanaw.getLocation(this.getLocation());
		super.getDesktopPane().add(empleadoVentanaw);
		empleadoVentanaw.setVisible(true);
		this.dispose();
	}// end limpiar

	public void insertar() {
		validarClases();

		if (cargarObjetos() == 1 && opcionModulo == 1) {
			empleadoMd.insertar(con.getConexion(), empleadoDp);
			bloqueo();
		}

	}// insertar

	public void modificar() {
		validarClases();
		if (cargarObjetos() == 1 & opcionModulo == 2) {
			empleadoMd.modificar(con.getConexion(), empleadoDp);
			bloqueo();
		}

	}// modificar

	public void eliminar() {
		validarClases();
		if (cargarObjetos() == 1 && opcionModulo == 2) {
			empleadoMd.eliminar(con.getConexion(), empleadoDp);
			bloqueo();
		}
	}// eliminar

	public void bloqueo() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldCEdula.setEnabled(false);
	}

	/**
	 * This method initializes jButtonVerFoto
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerFoto() {
		if (jButtonVerFoto == null) {
			jButtonVerFoto = new JButton();
			jButtonVerFoto.setBounds(new Rectangle(389, 52, 82, 23));
			jButtonVerFoto.setEnabled(false);
			jButtonVerFoto.setText("ver foto");
			jButtonVerFoto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							dialogMostrarImagen ProgressBarTestPro = new dialogMostrarImagen();
							ProgressBarTestPro.setVisible(true);
							ProgressBarTestPro.isAlwaysOnTop();
							// ProgressBarTestPro.dispose();

						}
					});
		}
		return jButtonVerFoto;
	}

} // @jve:decl-index=0:visual-constraint="10,10"

