package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Utilitarios.utilitarios;
import clases.alertas;
import clasesBdd.alertasBdd;
import clasesBdd.conexionBdd;

import com.toedter.calendar.JCalendar;

public class alertaRecordatorioVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelId1 = null;
	private JLabel jLabelDescripcion = null;
	private JLabel jLabelFechaInicio = null;
	private JLabel jLabelFechaFin = null;
	private JLabel jLabelEstado = null;
	private JLabel jLabelDescripcion2 = null;
	private JTextArea jTextAreaDescripcionAdicional = null;
	private JTextField jTextFieldIdAlerta = null;
	private JTextField jTextFieldDescripcion = null;
	private JTextField jTextFieldFechaInicial = null;
	private JTextField jTextFieldFechaFin = null;
	private Choice choiceEstado = null;
	private JLabel AdministracióndeAlertasyRecordatorios = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JButton jButtonCalendario = null;
	private JButton jButtonCalendario2 = null;
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
	private JScrollPane jScrollPaneareatexto = null;
	private JPanel jPanelOpciones = null;
	private JPanel jPanelInputs = null;
	private JPanel jPanelBotones = null;

	/*
	 * fin de variables de uso del calendario
	 * 
	 */
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	int opcionModulo = 0;

	alertas alertaDp = new alertas(0, "", null, null, "", "no encontro"); // @jve:decl-index=0:
	alertasBdd alertaMd = new alertasBdd(); // @jve:decl-index=0:
	conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	utilitarios util = new utilitarios(); // @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public alertaRecordatorioVentana() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(549, 464);
		this.setContentPane(getJContentPane());
		this.setClosable(true);
		this.setIconifiable(true);
		this.setTitle("Alertas y Recordatorios");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			AdministracióndeAlertasyRecordatorios = new JLabel();
			AdministracióndeAlertasyRecordatorios.setBounds(new Rectangle(119,
					15, 380, 21));
			AdministracióndeAlertasyRecordatorios.setFont(new Font("Dialog",
					Font.BOLD, 13));
			AdministracióndeAlertasyRecordatorios.setForeground(Color.blue);
			AdministracióndeAlertasyRecordatorios
					.setText("Administración de Alertas y Recordatorios");
			jLabelDescripcion2 = new JLabel();
			jLabelDescripcion2.setBackground(null);
			jLabelDescripcion2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion2.setText("Descripcion Adicional :");
			jLabelEstado = new JLabel();
			jLabelEstado.setBackground(null);
			jLabelEstado.setToolTipText("Escoja una opción");
			jLabelEstado.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelEstado.setText("Estado :");
			jLabelFechaFin = new JLabel();
			jLabelFechaFin.setBackground(null);
			jLabelFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaFin.setText("Fecha de Finalizacion :");
			jLabelFechaInicio = new JLabel();
			jLabelFechaInicio.setBackground(null);
			jLabelFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelFechaInicio.setText("Fecha de Inicio :");
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setBackground(null);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDescripcion.setText("Descripción :");
			jLabelId1 = new JLabel();
			jLabelId1.setBackground(null);
			jLabelId1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabelId1.setText("I.D. Alerta :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(null);
			jContentPane.setEnabled(false);
			jContentPane.add(AdministracióndeAlertasyRecordatorios, null);
			jContentPane.add(getJButtonCalendario(), null);
			jContentPane.add(getJButtonCalendario2(), null);

			jContentPane.add(getJScrollPaneareatexto(), null);
			jContentPane.add(getJPanelOpciones(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(getJPanelBotones(), null);
		}
		return jContentPane;
	}

	/**
	 * Creacion de Objetos de alertas
	 */

	/**
	 * This method initializes jTextAreaDescripcionAdicional
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaDescripcionAdicional() {
		if (jTextAreaDescripcionAdicional == null) {
			jTextAreaDescripcionAdicional = new JTextArea();
			jTextAreaDescripcionAdicional.setEditable(true);
			jTextAreaDescripcionAdicional.setEnabled(true);
			jTextAreaDescripcionAdicional
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							if (jTextAreaDescripcionAdicional.getText() == "")
								jTextAreaDescripcionAdicional
										.setText("Sin Descripción");
						}
					});

			jTextAreaDescripcionAdicional
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {

						}
					});
		}
		return jTextAreaDescripcionAdicional;
	}

	/**
	 * This method initializes jTextFieldIdAlerta
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIdAlerta() {
		if (jTextFieldIdAlerta == null) {
			jTextFieldIdAlerta = new JTextField();
			jTextFieldIdAlerta.setEditable(false);
			// jTextFieldIdAlerta.set
			jTextFieldIdAlerta.setToolTipText("Identificador de alerta");
			jTextFieldIdAlerta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			jTextFieldIdAlerta.setEnabled(false);
		}
		return jTextFieldIdAlerta;
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
					.setToolTipText("Escriba un nombre para Identificar el registro");
			jTextFieldDescripcion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldDescripcion.getText().trim()
									.compareTo("") == 0
									&& opcionModulo == 0) {
								JOptionPane.showMessageDialog(null,
										"Este Campo no puede estar vacio!",
										"Aviso!", JOptionPane.ERROR_MESSAGE);
								jTextFieldFechaInicial.setEnabled(false);
								jTextFieldFechaFin.setEnabled(false);
								jButtonIngresar.setEnabled(false);

							} else

								alertaDp.setDescripcion(jTextFieldDescripcion
										.getText().trim());// setea el objeto
							// descripcion
							alertaDp = alertaMd.buscarInfoDeUnRegistro(con
									.getConexion(), alertaDp);

							if (alertaDp.getDescripcion2().compareTo(
									"no encontro") == 0) {// determina si se
								// inserta o
								// actualiza o borra
								/**
								 * codigo de insertar
								 */
								if (opcionModulo == 0) {
									jButtonIngresar.setEnabled(true);
									jTextFieldFechaInicial.setEnabled(true);
									jButtonCalendario.setEnabled(true);
									opcionModulo = 1;
								}

							} else {
								if (opcionModulo == 0) {
									jTextFieldDescripcion.setEnabled(false);
									/**
									 * codigo de modificar o eliminar
									 */
									cargarDatos();
									jButtonIngresar.setEnabled(false);
									jButtonModificar.setEnabled(true);
									jButtonEliminar.setEnabled(true);
									jTextFieldFechaInicial.setEnabled(true);
									jButtonCalendario.setEnabled(true);
									opcionModulo = 2;
								}// end else
							}
						}
					});
		}
		return jTextFieldDescripcion;
	}

	/**
	 * This method initializes jTextFieldFechaInicial
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFechaInicial() {
		try {
			MaskFormatter mascara = new MaskFormatter("####-##-##");
			jTextFieldFechaInicial = new JFormattedTextField(mascara);
			jTextFieldFechaInicial.setEnabled(false);
			jTextFieldFechaInicial.setText(util.fechaActual());
			jTextFieldFechaInicial
					.setToolTipText("Escoja la fecha de inicio con el botón de la derecha");

		} catch (Exception e) {
			e.printStackTrace();
		}

		jTextFieldFechaInicial
				.addCaretListener(new javax.swing.event.CaretListener() {

					public void caretUpdate(javax.swing.event.CaretEvent e) {
						BufferComparacion = jTextFieldFechaInicial.getText();
						BufferComparacion = BufferComparacion.toString();

						try {
							BufferComparacion = BufferComparacion.substring(8,
									10).trim();
						} catch (Exception e1) {
							BufferComparacion = "01";
							/** en caso de ser null el textfield */
						}

						if (diaAnterior.compareToIgnoreCase(BufferComparacion) != 0) {

							popup.setVisible(false);

						} else {
							popup.setVisible(true);
						}

						if (jTextFieldFechaInicial.getText() != "") {
							jTextFieldFechaFin.setEnabled(true);
							jButtonCalendario2.setEnabled(true);
						}

					}
				});

		jTextFieldFechaInicial
				.addFocusListener(new java.awt.event.FocusAdapter() {
					@Override
					public void focusGained(java.awt.event.FocusEvent e) {
						alertaDp.setFechaInicio(jTextFieldFechaInicial
								.getText());
					}
				});
		return jTextFieldFechaInicial;
	}

	/**
	 * This method initializes jTextFieldFechaFin
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFechaFin() {
		try {
			MaskFormatter mascara = new MaskFormatter("####-##-##");
			jTextFieldFechaFin = new JFormattedTextField(mascara);
			jTextFieldFechaFin.setEnabled(false);
			jTextFieldFechaFin.setText(util.fechaActual());
			jTextFieldFechaFin
					.setToolTipText("Escoja la fecha de Finalización con el botón de la derecha");

		} catch (Exception e) {
			e.printStackTrace();
		}

		jTextFieldFechaFin
				.addCaretListener(new javax.swing.event.CaretListener() {
					public void caretUpdate(javax.swing.event.CaretEvent e) {
						BufferComparacion = jTextFieldFechaFin.getText();
						BufferComparacion = BufferComparacion.toString();

						try {
							BufferComparacion = BufferComparacion.substring(8,
									10).trim();
						} catch (Exception e1) {
							BufferComparacion = "01";
							/** en caso de ser null el textfield */
						}

						if (diaAnterior.compareToIgnoreCase(BufferComparacion) != 0) {

							popup2.setVisible(false);

						} else {
							popup2.setVisible(true);
						}

						if (jTextFieldFechaFin.getText() != "") {
							choiceEstado.setEnabled(true);

						}
					}
				});
		jTextFieldFechaFin.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				alertaDp.setFechaDinalizacion(jTextFieldFechaFin.getText());
			}
		});
		return jTextFieldFechaFin;

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
			choiceEstado
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {
							if ((e.getPropertyName().equals("enabled"))) {

							}
						}
					});
			choiceEstado.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					alertaDp.setEstado(choiceEstado.getSelectedItem());
				}
			});
			choiceEstado.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					if (jTextFieldFechaFin.isEnabled()) {
						jTextAreaDescripcionAdicional.setEnabled(true);
						jTextAreaDescripcionAdicional.setEditable(true);
					}// end if
				}
			});
			choiceEstado.add("Activado");
			choiceEstado.add("Desactivado");
		}
		return choiceEstado;
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
							int verificar = validar();
							if (verificar == 1) {

								alertaMd.insertar(con.getConexion(), alertaDp);
								jButtonIngresar.setEnabled(false);
								jTextFieldDescripcion.setEnabled(false);
							}
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
							int verificar = validar();
							if (verificar == 1) {
								alertaMd.modificar(con.getConexion(), alertaDp);
								jButtonModificar.setEnabled(false);
								jButtonEliminar.setEnabled(false);
								jTextFieldDescripcion.setEnabled(false);
							}
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
							int verificar = validar();
							if (verificar == 1) {
								int puntoControl = JOptionPane
										.showConfirmDialog(
												null,
												"Desea Eliminar este Registro del sistema?",
												"Confirmar Eliminación",
												JOptionPane.YES_NO_OPTION);

								if (puntoControl != 1) {
									alertaMd.eliminar(con.getConexion(),
											alertaDp);
									jButtonModificar.setEnabled(false);
									jButtonEliminar.setEnabled(false);
									jTextFieldDescripcion.setEnabled(false);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Eliminación cancelada! ", "Aviso!",
										JOptionPane.INFORMATION_MESSAGE);
							}// fin del dialogo de confirmación
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
							jTextFieldDescripcion.setEnabled(true);
							jTextFieldIdAlerta.setText("");
							jTextFieldDescripcion.setText("");
							jTextFieldFechaInicial.setText("00000000");
							jTextFieldFechaInicial.setEnabled(false);
							jTextFieldFechaFin.setText("00000000");
							jTextFieldFechaFin.setEnabled(false);
							jTextFieldDescripcion.setText("");
							jButtonIngresar.setEnabled(false);
							jButtonModificar.setEnabled(false);
							jButtonEliminar.setEnabled(false);
							choiceEstado.setEnabled(false);
							jButtonCalendario.setEnabled(false);
							jButtonCalendario2.setEnabled(false);
							jTextAreaDescripcionAdicional.setText("");
							jTextFieldDescripcion.setEnabled(true);
							alertaDp = new alertas(0, "", null, null, "",
									"no encontro"); // @jve:decl-index=0:
							opcionModulo = 0;
						}
					});
		}
		return jButtonLimpiar;
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
								if (jTextFieldFechaInicial.getText().compareTo(
										"") == 0) {

									jTextFieldFechaInicial.setText(fechaString);

								} else {
									jTextFieldFechaInicial.setText(fechaString);
									try {
										diaAnterior = jTextFieldFechaInicial
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
			jButtonCalendario.setBounds(new Rectangle(361, 113, 25, 24));
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
							popup.show(jButtonCalendario, x + 170, y - 140);
						}
					});

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
			/*
			 * Código de Inicialización del calendario boton
			 */
			this.jcalendar2 = new JCalendar();
			jcalendar2
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {

							if ((e.getPropertyName().equals("calendar"))) {

								Date fecha = jcalendar2.getCalendar().getTime();
								String fechaString = formatofecha.format(fecha);
								if (jTextFieldFechaFin.getText().compareTo("") == 0) {

									jTextFieldFechaFin.setText(fechaString);

								} else {
									jTextFieldFechaFin.setText(fechaString);
									diaAnterior = jTextFieldFechaFin.getText()
											.substring(8, 10);// se requiere
									// para cerrar
									// el popup

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

			jButtonCalendario2.setBounds(new Rectangle(362, 150, 25, 24));
			jButtonCalendario2.setIcon(new ImageIcon(getClass().getResource(
					"/UtilJpg/calendario1.png")));
			jButtonCalendario2.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonCalendario2.setEnabled(false);
			jButtonCalendario2.setText("");
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
							popup2.show(jButtonCalendario2, x + 170, y - 140);
						}
					});
		}
		return jButtonCalendario2;
	}

	/* add-ons requeridos para los calendarios */

	/**
	 * Sets the date. Fires the property change "date".
	 * 
	 * @param date
	 *            the new date.
	 */
	public void setDate(Date date) {
		if (getParent() != null) {
			getParent().validate();
		}
	}

	/**
	 * Sets the date format string. E.g "MMMMM d, yyyy" will result in "July 21,
	 * 2004" if this is the selected date and locale is English.
	 * 
	 * @param dateFormatString
	 *            The dateFormatString to set.
	 */
	public void setDateFormatString(String dateFormatString) {
		dateFormatString = dateFormatString.toString();
		invalidate();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method initializes jScrollPaneareatexto
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneareatexto() {
		if (jScrollPaneareatexto == null) {
			jScrollPaneareatexto = new JScrollPane();
			jScrollPaneareatexto.setBounds(new Rectangle(232, 213, 188, 70));
			jScrollPaneareatexto
					.setViewportView(getJTextAreaDescripcionAdicional());
			jScrollPaneareatexto
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							alertaDp
									.setDescripcion2(jTextAreaDescripcionAdicional
											.getText().trim());
						}
					});
		}
		return jScrollPaneareatexto;
	}

	/**
	 * This method initializes jPanelOpciones
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelOpciones() {
		if (jPanelOpciones == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(6);
			gridLayout.setHgap(25);
			gridLayout.setVgap(12);
			gridLayout.setColumns(1);
			jPanelOpciones = new JPanel();
			jPanelOpciones.setLayout(gridLayout);
			jPanelOpciones.setBounds(new Rectangle(52, 52, 165, 185));
			jPanelOpciones.add(jLabelId1, null);
			jPanelOpciones.add(jLabelDescripcion, null);
			jPanelOpciones.add(jLabelFechaInicio, null);
			jPanelOpciones.add(jLabelFechaFin, null);
			jPanelOpciones.add(jLabelEstado, null);
			jPanelOpciones.add(jLabelDescripcion2, null);
		}
		return jPanelOpciones;
	}

	/**
	 * This method initializes jPanelInputs
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelInputs() {
		if (jPanelInputs == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(5);
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(12);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(233, 52, 123, 151));
			jPanelInputs.add(getJTextFieldIdAlerta(), null);
			jPanelInputs.add(getJTextFieldDescripcion(), null);
			jPanelInputs.add(getJTextFieldFechaInicial(), null);
			jPanelInputs.add(getJTextFieldFechaFin(), null);
			jPanelInputs.add(getChoiceEstado(), null);
		}
		return jPanelInputs;
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
			jPanelBotones.setBounds(new Rectangle(52, 315, 425, 28));
			jPanelBotones.add(getJButtonIngresar(), null);
			jPanelBotones.add(getJButtonModificar(), null);
			jPanelBotones.add(getJButtonEliminar(), null);
			jPanelBotones.add(getJButtonLimpiar(), null);
		}
		return jPanelBotones;
	}

	public int validar() {
		int permitir = 1;
		alertaDp.setFechaInicio(jTextFieldFechaInicial.getText());
		alertaDp.setFechaDinalizacion(jTextFieldFechaFin.getText());
		alertaDp.setDescripcion2(jTextAreaDescripcionAdicional.getText());
		alertaDp.setEstado(choiceEstado.getSelectedItem());
		if (jTextFieldDescripcion.getText().compareTo("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null, "Ingrese una Descripción",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		if (jTextFieldFechaInicial.getText().compareTo("0000-00-00") == 0) {
			permitir = 0;
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"Ingrese una Fecha Válida Inicio", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		if (jTextFieldFechaFin.getText().compareTo("0000-00-00") == 0) {
			permitir = 0;
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"Ingrese una Válida de Finalización", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		if (jTextAreaDescripcionAdicional.getText().compareToIgnoreCase("") == 0) {
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"No se ha Ingresado una Descripción", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		Utilitarios.utilitarios utilitarios1 = new utilitarios();
		if (!utilitarios1.compararFechasString(alertaDp.getFechaInicio(),
				alertaDp.getFechaDinalizacion())) {
			permitir = 0;
			JOptionPane.showMessageDialog(null,
					"La fecha inicial no debe ser superior a la fecha inicial",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return permitir;
	}// end validar

	public void cargarDatos() {
		jTextFieldIdAlerta.setText("" + alertaDp.getAlerta());
		jTextFieldDescripcion.setText(alertaDp.getDescripcion());
		jTextFieldFechaInicial.setText(alertaDp.getFechaInicio());
		jTextFieldFechaFin.setText(alertaDp.getFechaDinalizacion());
		choiceEstado.select(alertaDp.getEstado());
		jTextAreaDescripcionAdicional.setText(alertaDp.getDescripcion2());
	}

} // @jve:decl-index=0:visual-constraint="10,10"
