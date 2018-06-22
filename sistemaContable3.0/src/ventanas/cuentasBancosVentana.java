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
import clases.bancos;
import clases.cuentasBancos;
import clasesBdd.bancosBdd;
import clasesBdd.conexionBdd;
import clasesBdd.cuentasBancosBdd;

public class cuentasBancosVentana extends JInternalFrame {

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
	private JTextField jTextFieldNumCuenta = null;
	private JPanel jPanelInputs2 = null;
	private Choice choiceExistentes = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private cuentasBancos cuentasBancosDp = new cuentasBancos(0, 0, "", "", ""); // @jve:decl-index=0:
	private bancosBdd bancosMd = new bancosBdd(); // @jve:decl-index=0:
	private cuentasBancosBdd cuentasBancosMd = new cuentasBancosBdd();
	private bancos bancosDp = new bancos(0, "", "", ""); // @jve:decl-index=0:
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private JLabel jLabelBancos = null;
	private JLabel jLabelCiudad = null;
	private Choice choiceBancos = null;
	private JLabel jLabeTipoCuenta = null;
	private Choice choiceTiposCuentas = null;
	private JTextField jTextFieldPropietario = null;
	java.util.Hashtable<Object, Object> cuentasBancosStringCodigoHash = bancosMd
			.seleccionarCodigosPorElStringTablaHash(con.getConexion()); // @jve:decl-index=0:
	java.util.Hashtable<Object, bancos> cuentasBancosCodigoStringHash = bancosMd
			.seleccionarDescripcionesPorElCodigoTablaHash(con.getConexion()); // @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public cuentasBancosVentana() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(542, 396);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración Tipos de Cuentas Bancarias");
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
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(109, 15, 347, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes
					.setText("Administración de Cuentas por Bancos ");
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
			jLabeTipoCuenta = new JLabel();
			jLabeTipoCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabeTipoCuenta.setText("Tipo Cuenta :");
			jLabeTipoCuenta.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelCiudad = new JLabel();
			jLabelCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCiudad.setText("Propietario :");
			jLabelCiudad.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBancos = new JLabel();
			jLabelBancos.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBancos.setText("Banco :");
			jLabelBancos.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID de Cuenta en la Tabla :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Numero de Cuenta :");
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
			jPanelEtiquetas.add(jLabelBancos, null);
			jPanelEtiquetas.add(jLabeTipoCuenta, null);
			jPanelEtiquetas.add(jLabelCiudad, null);
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
			jPanelInputs.add(getJTextFieldNumCuenta(), null);
			jPanelInputs.add(getChoiceBancos(), null);
			jPanelInputs.add(getChoiceTiposCuentas(), null);
			jPanelInputs.add(getJTextFieldPropietario(), null);
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
	 * This method initializes jTextFieldNumCuenta
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumCuenta() {
		if (jTextFieldNumCuenta == null) {
			jTextFieldNumCuenta = new JTextField();
			jTextFieldNumCuenta.setToolTipText("Ingrese el Número de cuenta");
			jTextFieldNumCuenta
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldNumCuenta.getText().trim().compareTo(
									"") == 0
									&& opcionModulo != 0) {
								JOptionPane.showMessageDialog(null,
										"Este Campo no puede estar vacio!",
										"Aviso!", JOptionPane.ERROR_MESSAGE);
							} else {
								cuentasBancosDp
										.setNumeroCuenta(jTextFieldNumCuenta
												.getText().trim());
								buscarItem();
							}// end else
						}
					});
			jTextFieldNumCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldNumCuenta.setText(util.cortarCadenaString(
							jTextFieldNumCuenta.getText().trim(), 25));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
		}
		return jTextFieldNumCuenta;
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
					cuentasBancosDp.setNumeroCuenta(choiceExistentes
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
		anterior = jTextFieldNumCuenta.getText().trim();
		cuentasBancosDp = cuentasBancosMd.buscarInfoDeUnRegistro(con
				.getConexion(), cuentasBancosDp);

		if (cuentasBancosDp.getIdBanco() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			// jTextFieldTelefono.setEnabled(true);
			// jTextFieldCiudad.setEnabled(true);
			choiceBancos.setEnabled(true);
			choiceTiposCuentas.setEnabled(true);
			jTextFieldPropietario.setEnabled(true);
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
			choiceExistentes.setEnabled(false);
			jTextFieldId.setText("" + cuentasBancosDp.getIdBanco());
			jTextFieldNumCuenta.setText(cuentasBancosDp.getNumeroCuenta());
			choiceBancos.setEnabled(true);
			choiceTiposCuentas.setEnabled(true);
			jTextFieldPropietario.setEnabled(true);
			choiceBancos.select("" + bancosDp.getDescripcionBanco());
			choiceTiposCuentas.select(cuentasBancosDp.getTipoCuenta());
			jTextFieldPropietario.setText(cuentasBancosDp
					.getPropietarioCuenta());
			bancos bancoDp = new bancos(0, "", "", "");
			bancoDp = cuentasBancosCodigoStringHash
					.get(cuentasBancosDp.getIdBanco());
			choiceBancos.select(bancoDp.getDescripcionBanco());
			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
		}// end else

	}

	private void limpiar() {

		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldNumCuenta.setEnabled(true);
		jTextFieldNumCuenta.setText("");
		jTextFieldId.setText("0");
		choiceExistentes.setEnabled(true);
		jTextFieldPropietario.setText("");
		// jTextFieldCiudad.setText("");
		// jTextFieldCiudad.setEnabled(false);
		opcionModulo = 0;
		cuentasBancosDp = new cuentasBancos(0, 0, "", "", "");

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {
		validar();
		if (opcionModulo == 1
				&& jTextFieldNumCuenta.getText().compareTo("") != 0) {
			cuentasBancosMd.insertar(con.getConexion(), cuentasBancosDp);
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
		validar();
		if (opcionModulo == 2
				&& jTextFieldNumCuenta.getText().compareTo("") != 0) {
			cuentasBancosMd.modificar(con.getConexion(), cuentasBancosDp);
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
		validar();
		if (opcionModulo == 2
				&& jTextFieldNumCuenta.getText().compareTo("") != 0) {
			cuentasBancosMd.eliminar(con.getConexion(), cuentasBancosDp);
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
		Object descripciones[] = cuentasBancosMd
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

	private void validar() {
		cuentasBancosDp.setIdBanco(Integer.parseInt(""
				+ cuentasBancosStringCodigoHash.get(""
						+ choiceBancos.getSelectedItem())));
		cuentasBancosDp.setTipoCuenta(choiceTiposCuentas.getSelectedItem());
		cuentasBancosDp.setPropietarioCuenta(jTextFieldPropietario.getText()
				.trim());
	}

	/**
	 * This method initializes choiceBancos
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceBancos() {
		if (choiceBancos == null) {
			choiceBancos = new Choice();
			choiceBancos.setEnabled(false);
			choiceBancos.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					cuentasBancosDp.setIdBanco(Integer.parseInt(""
							+ cuentasBancosStringCodigoHash.get(""
									+ choiceBancos.getSelectedItem())));

				}
			});
		}
		return choiceBancos;
	}

	/**
	 * This method initializes choiceTiposCuentas
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceTiposCuentas() {
		if (choiceTiposCuentas == null) {
			choiceTiposCuentas = new Choice();
			choiceTiposCuentas.setEnabled(false);
			choiceTiposCuentas
					.addItemListener(new java.awt.event.ItemListener() {
						public void itemStateChanged(java.awt.event.ItemEvent e) {
							cuentasBancosDp.setTipoCuenta(choiceTiposCuentas
									.getSelectedItem());
						}
					});
			choiceTiposCuentas.addItem("Corriente");
			choiceTiposCuentas.addItem("Ahorros");
		}
		cargarChoiceBancos();
		return choiceTiposCuentas;
	}

	public void cargarChoiceBancos() {

		Object descripciones[] = bancosMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceBancos.addItem("" + descripciones[i]);
		}
	}

	/**
	 * This method initializes jTextFieldPropietario
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPropietario() {
		if (jTextFieldPropietario == null) {
			jTextFieldPropietario = new JTextField();
			jTextFieldPropietario
					.setToolTipText("Modifica el nombre del propietario de la cuenta");
			jTextFieldPropietario.setEnabled(false);
			jTextFieldPropietario
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldPropietario.setText(util
									.cortarCadenaString(jTextFieldPropietario
											.getText().trim(), 80));
						}

					});
			jTextFieldPropietario
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							cuentasBancosDp
									.setPropietarioCuenta(jTextFieldPropietario
											.getText().trim());
						}
					});
		}
		return jTextFieldPropietario;
	}

} // @jve:decl-index=0:visual-constraint="10,10"

