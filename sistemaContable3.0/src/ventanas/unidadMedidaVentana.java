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
import clases.unidadMedida;
import clasesBdd.conexionBdd;
import clasesBdd.unidadMedidaBdd;

public class unidadMedidaVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administraci�ndeclientes = null;
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JTextField jTextFieldDescripcion = null;
	private JPanel jPanelInputs2 = null;
	private Choice choiceExistentes = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private unidadMedida unidadMedidaDp = new unidadMedida(0, "", ""); // @jve:decl-index=0:
	private unidadMedidaBdd unidadMedidaMd = new unidadMedidaBdd();
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	/**
	 * Opci�n de trabajo del m�dulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private JLabel jLabelNomenclatura = null;
	private JTextField jTextFieldNomenclatura = null;

	/**
	 * This is the default constructor
	 */
	public unidadMedidaVentana() {
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
		this.setTitle("Administraci�n Tipos de Unidad de Medida");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administraci�ndeclientes = new JLabel();
			Administraci�ndeclientes.setBounds(new Rectangle(119, 15, 305, 21));
			Administraci�ndeclientes.setForeground(Color.blue);
			Administraci�ndeclientes
					.setText("Administraci�n de Tipos de Unidad De Medida");
			Administraci�ndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraci�ndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administraci�ndeclientes, null);
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
			jLabelNomenclatura = new JLabel();
			jLabelNomenclatura.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNomenclatura.setText("Nomenclatura :");
			jLabelNomenclatura.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID de Unidad de Medida :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Descripci�n :");
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
			jPanelEtiquetas.add(jLabelNomenclatura, null);
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
			jPanelInputs.add(getJTextFieldNomenclatura(), null);
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
					.setToolTipText("Modifica la Descripci�n de la Unidad de Medida");
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
								unidadMedidaDp
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
											.getText(), 40));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloLetras(e);
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
			GridLayout gridLayout22 = new GridLayout();
			gridLayout22.setRows(5);
			gridLayout22.setHgap(6);
			gridLayout22.setVgap(13);
			gridLayout22.setColumns(1);
			jPanelInputs2 = new JPanel();
			jPanelInputs2.setLayout(gridLayout22);
			jPanelInputs2.setBounds(new Rectangle(375, 53, 106, 162));
			jPanelInputs2.add(getChoiceExistentes(), null);
		}
		return jPanelInputs2;
	}

	/**
	 * This method initializes choiceExistentes
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceExistentes() {
		if (choiceExistentes == null) {
			choiceExistentes = new Choice();
			choiceExistentes.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					choiceExistentes.setEnabled(false);
					unidadMedidaDp.setDescripcion(choiceExistentes
							.getSelectedItem());
					opcionModulo = 2;
					buscarItem();

				}
			});
			cargarChoice();

		}
		return choiceExistentes;
	}

	private void buscarItem() {
		anterior = jTextFieldDescripcion.getText().trim();
		unidadMedidaDp = unidadMedidaMd.buscarInfoDeUnRegistro(con
				.getConexion(), unidadMedidaDp);

		if (unidadMedidaDp.getIdUnidadMedida() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			jTextFieldNomenclatura.setEditable(true);
			jButtonIngresar.setEnabled(true);
			jButtonModificar.setEnabled(false);
			jButtonEliminar.setEnabled(false);
			opcionModulo = 1;
		} else {
			/**
			 * Activa Modificaci�n
			 */
			opcionModulo = 2;
			anterior = jTextFieldId.getText();
			jTextFieldId.setEnabled(false);
			choiceExistentes.setEnabled(false);
			jTextFieldId.setText("" + unidadMedidaDp.getIdUnidadMedida());
			jTextFieldDescripcion.setText(unidadMedidaDp.getDescripcion());
			jTextFieldNomenclatura.setText(unidadMedidaDp.getNomenclatura());
			jTextFieldNomenclatura.setEditable(true);
			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
		}// end else

	}

	private void limpiar() {

		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldDescripcion.setEnabled(true);
		jTextFieldDescripcion.setText("");
		jTextFieldId.setText("");
		choiceExistentes.setEnabled(true);
		opcionModulo = 0;
		unidadMedidaDp = new unidadMedida(0, "", "");
		jTextFieldNomenclatura.setEditable(false);
		jTextFieldNomenclatura.setText("");

	}// fin limpiar

	/**
	 * Funci�n de Ingreso
	 */
	private void insertar() {
		if (opcionModulo == 1
				&& jTextFieldDescripcion.getText().compareTo("") != 0
				&& jTextFieldNomenclatura.getText().compareTo("") != 0) {
			unidadMedidaMd.insertar(con.getConexion(), unidadMedidaDp);
			cargarChoice();
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"El campo Descripci�n  o el campo Nomenclatura Est�n Vacios! ",
							"Aviso!", JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// insertar

	/**
	 * Funcion de Modificaci�n
	 */
	private void modificar() {
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0
				&& jTextFieldNomenclatura.getText().compareTo("") != 0) {
			unidadMedidaMd.modificar(con.getConexion(), unidadMedidaDp);
			cargarChoice();
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"El campo Descripci�n  o el campo Nomenclatura Est�n Vacios! ",
							"Aviso!", JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// modificar

	/**
	 * Funci�n de Eliminaci�n
	 */
	private void eliminar() {
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0
				&& jTextFieldNomenclatura.getText().compareTo("") != 0) {
			unidadMedidaMd.eliminar(con.getConexion(), unidadMedidaDp);
			cargarChoice();
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"El campo Descripci�n  o el campo Nomenclatura Est�n Vacios! ",
							"Aviso!", JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// eliminar

	private void cargarChoice() {
		choiceExistentes.removeAll();
		Object descripciones[] = unidadMedidaMd
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
	 * This method initializes jTextFieldNomenclatura
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNomenclatura() {
		if (jTextFieldNomenclatura == null) {
			jTextFieldNomenclatura = new JTextField();
			jTextFieldNomenclatura
					.setToolTipText("Modifica la Nomenclatura de unidad de M�dida");
			jTextFieldNomenclatura
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							unidadMedidaDp
									.setNomenclatura(jTextFieldNomenclatura
											.getText().trim());
						}
					});
			jTextFieldNomenclatura
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldNomenclatura.setText(util
									.cortarCadenaString(jTextFieldNomenclatura
											.getText(), 6));

						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloLetras(e);
						}
					});
		}
		return jTextFieldNomenclatura;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
