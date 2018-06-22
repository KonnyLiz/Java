package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Utilitarios.utilitarios;
import clases.tipoTrabajo;
import clasesBdd.conexionBdd;
import clasesBdd.tipoTrabajoBdd;

public class tipoTrabajoVentana extends JInternalFrame {

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
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JTextField jTextFieldDescripcion = null;
	private JPanel jPanelInputs2 = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private tipoTrabajo tipoTrabajoDp = new tipoTrabajo(0, "", 0, 0); // @jve:decl-index=0:
	private tipoTrabajoBdd tipoTrabajoMd = new tipoTrabajoBdd();
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private JLabel jLabelId1Precio1 = null;
	private JLabel jLabelId1Precio2 = null;
	private JTextField jTextFieldPrecio = null;
	private JTextField jTextFieldPrecioMin = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private Choice choiceExistentes = null;
	private JLabel jLabelId1RegistrosExistentes = null;

	/**
	 * This is the default constructor
	 */
	public tipoTrabajoVentana() {
		super();
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
		this.setSize(542, 396);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración Tipos de Tipos de Trabajo");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(119, 15, 305, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes
					.setText("Administración de Tipos de Trabajo");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJPanelInputs2(), null);
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
			jPanelBotones.setBounds(new Rectangle(52, 315, 425, 28));
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
			jLabelId1Precio2 = new JLabel();
			jLabelId1Precio2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Precio2.setText("Precio mínmo :");
			jLabelId1Precio2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Precio1 = new JLabel();
			jLabelId1Precio1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Precio1.setText("Precio :");
			jLabelId1Precio1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID de Tipo de Trabajo :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Descripción :");
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setHgap(25);
			gridLayout.setVgap(12);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(52, 52, 165, 163));
			jPanelEtiquetas.add(jLabelDescripcion, null);
			jPanelEtiquetas.add(jLabelId, null);
			jPanelEtiquetas.add(jLabelId1Precio1, null);
			jPanelEtiquetas.add(jLabelId1Precio2, null);
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
			gridLayout1.setRows(5);
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(13);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(233, 52, 123, 163));
			jPanelInputs.add(getJTextFieldId(), null);
			jPanelInputs.add(getJTextFieldDescripcion(), null);
			jPanelInputs.add(getJTextFieldPrecio(), null);
			jPanelInputs.add(getJTextFieldPrecioMin(), null);
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
			jTextFieldId.setText("");
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
					.setToolTipText("Modifica la Información del Tipo del tipo de Trabajo");
			jTextFieldDescripcion
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldDescripcion.getText().trim()
									.compareTo("") == 0
									&& opcionModulo != 0) {
								JOptionPane.showMessageDialog(null,
										"Este Campo no puede estar vacio!",
										"Aviso!", JOptionPane.ERROR_MESSAGE);
							} else {
								tipoTrabajoDp
										.setDescripcion(jTextFieldDescripcion
												.getText().trim());
								buscarItem();

							}// end else
						}
					});
			jTextFieldDescripcion
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldDescripcion.setText(util
									.cortarCadenaString(jTextFieldDescripcion
											.getText(), 50));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.verificarTexto(e);
						}
					});

		}
		return jTextFieldDescripcion;
	}

	/**
	 * This method initializes jPanelInputs2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelInputs2() {
		if (jPanelInputs2 == null) {
			jLabelId1RegistrosExistentes = new JLabel();
			jLabelId1RegistrosExistentes
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1RegistrosExistentes
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1RegistrosExistentes.setText("Registros Existentes :");
			GridLayout gridLayout22 = new GridLayout();
			gridLayout22.setRows(1);
			gridLayout22.setHgap(17);
			gridLayout22.setVgap(13);
			gridLayout22.setColumns(2);
			jPanelInputs2 = new JPanel();
			jPanelInputs2.setLayout(gridLayout22);
			jPanelInputs2.setBounds(new Rectangle(84, 232, 285, 36));
			jPanelInputs2.add(jLabelId1RegistrosExistentes, null);
			jPanelInputs2.add(getChoiceExistentes(), null);
		}
		return jPanelInputs2;
	}

	private void buscarItem() {
		anterior = jTextFieldDescripcion.getText().trim();
		tipoTrabajoDp = tipoTrabajoMd.buscarInfoDeUnRegistro(con.getConexion(),
				tipoTrabajoDp);

		if (tipoTrabajoDp.getIdTp() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			choiceExistentes.setEnabled(false);
			jTextFieldPrecio.setEnabled(true);
			jButtonIngresar.setEnabled(true);
			jButtonModificar.setEnabled(false);
			jButtonEliminar.setEnabled(false);
			opcionModulo = 1;
		} else {
			/**
			 * Activa Modificación
			 */
			opcionModulo = 2;
			anterior = jTextFieldId.getText();
			jTextFieldId.setEnabled(false);
			jTextFieldPrecio.setEnabled(true);
			choiceExistentes.setEnabled(false);
			jTextFieldId.setText("" + tipoTrabajoDp.getIdTp());
			jTextFieldDescripcion.setText(tipoTrabajoDp.getDescripcion());
			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
			jTextFieldPrecio.setText("" + tipoTrabajoDp.getPrecio1());
			jTextFieldPrecio.setEnabled(true);
			jTextFieldPrecioMin.setText("" + tipoTrabajoDp.getPrecio2());
			jTextFieldPrecioMin.setEnabled(true);
		}// end else

	}

	private void limpiar() {

		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldDescripcion.setEnabled(true);
		jTextFieldDescripcion.setText("");
		jTextFieldId.setText("");
		jTextFieldPrecio.setText("");
		jTextFieldPrecioMin.setText("");
		jTextFieldPrecio.setEnabled(false);
		jTextFieldPrecioMin.setEnabled(false);
		choiceExistentes.setEnabled(true);
		opcionModulo = 0;
		tipoTrabajoDp = new tipoTrabajo(0, "", 0, 0);

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {
		if (opcionModulo == 1
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {

			tipoTrabajoMd.insertar(con.getConexion(), tipoTrabajoDp);
			cargarChoice();
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
			tipoTrabajoMd.modificar(con.getConexion(), tipoTrabajoDp);
			cargarChoice();
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
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			tipoTrabajoMd.eliminar(con.getConexion(), tipoTrabajoDp);
			cargarChoice();
		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// eliminar

	private void cargarChoice() {
		choiceExistentes.removeAll();
		Object descripciones[] = tipoTrabajoMd
				.seleccionarDescripcionesTabla(con.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceExistentes.addItem("" + descripciones[i]);
		}
	}

	private void bloquear() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
	}

	/**
	 * This method initializes jTextFieldPrecio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecio() {
		if (jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio
					.setToolTipText("Modifica la Información del precio normal del producto");
			jTextFieldPrecio.setEnabled(false);
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldPrecio.setText(util
							.cortarCadenaFloat(jTextFieldPrecio.getText()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldPrecio
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							try {
								tipoTrabajoDp
										.setPrecio1(Float
												.parseFloat(jTextFieldPrecio
														.getText()));
							} catch (Exception s) {
								s.printStackTrace();
							}
							jTextFieldPrecioMin.setEnabled(true);
						}
					});
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jTextFieldPrecioMin
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecioMin() {
		if (jTextFieldPrecioMin == null) {
			jTextFieldPrecioMin = new JTextField();
			jTextFieldPrecioMin
					.setToolTipText("Modifica el Precio Mínimo del producto");
			jTextFieldPrecioMin.setEnabled(false);
			jTextFieldPrecioMin.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldPrecioMin.setText(util
							.cortarCadenaFloat(jTextFieldPrecioMin.getText()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldPrecioMin
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							try {
								tipoTrabajoDp.setPrecio2(Float
										.parseFloat(jTextFieldPrecioMin
												.getText()));
							} catch (Exception E1) {
								E1.printStackTrace();
							}
						}
					});
		}
		return jTextFieldPrecioMin;
	}

	/**
	 * This method initializes choiceExistentes
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceExistentes() {
		if (choiceExistentes == null) {
			choiceExistentes = new Choice();
			cargarChoice();
			choiceExistentes.addItemListener(new java.awt.event.ItemListener() {

				public void itemStateChanged(java.awt.event.ItemEvent e) {
					choiceExistentes.setEnabled(false);
					tipoTrabajoDp.setDescripcion(choiceExistentes
							.getSelectedItem());
					opcionModulo = 2;

					buscarItem();

				}
			});
		}
		return choiceExistentes;
	}

} // @jve:decl-index=0:visual-constraint="10,10"

