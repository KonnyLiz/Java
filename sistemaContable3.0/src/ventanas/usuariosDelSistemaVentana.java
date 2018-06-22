package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import md5.MD5;
import Utilitarios.utilitarios;
import clases.user;
import clasesBdd.conexionBdd;
import clasesBdd.rolBdd;
import clasesBdd.userBdd;

public class usuariosDelSistemaVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administracióndelsistema = null;
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldUserName = null;
	private JPasswordField jTextFieldClave = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	MD5 md5class = new MD5(); // @jve:decl-index=0:
	private user userInit = new user(0, 0, "", "noClave", "noClave"); // @jve:decl-index=0:
	private user userDp = new user(0, 0, "", "", ""); // @jve:decl-index=0:
	private userBdd userMd = new userBdd(); // @jve:decl-index=0:
	private rolBdd rolMd = new rolBdd();
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	Hashtable<Object, Object> rolHash = rolMd.seleccionarDescripcionesTablaHash(con
			.getConexion()); // @jve:decl-index=0:
	Hashtable rolHashCodigoDescrip = rolMd
			.seleccionarClaveDescripcionesTablaHash(con.getConexion()); // @jve:decl-index=0:
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private JLabel jLabelContrasena = null;
	private JPasswordField jTextFieldClave2 = null;
	private JLabel jLabelIdClave2 = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JLabel jLabelRol = null;
	private JTextField jTextFieldIdUser = null;
	private Choice choiceRol = null;
	private JLabel jLabelContraAnterior = null;
	private JPasswordField jPasswordFieldAnterior = null;

	/**
	 * This is the default constructor
	 */
	public usuariosDelSistemaVentana() {
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
		this.setTitle("Administración Tipos de Usuarios del Sistema");
		cargarObjetoInit();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndelsistema = new JLabel();
			Administracióndelsistema.setBounds(new Rectangle(119, 15, 305, 21));
			Administracióndelsistema.setForeground(Color.blue);
			Administracióndelsistema.setText("Usuarios del Sistema");
			Administracióndelsistema
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndelsistema.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndelsistema, null);
			jContentPane.add(getJPanelBotones(), null);
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
			jLabelContraAnterior = new JLabel();
			jLabelContraAnterior.setText("Contraseña Anterior :");
			jLabelContraAnterior
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelContraAnterior.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelRol = new JLabel();
			jLabelRol.setText("Rol del Usuario :");
			jLabelRol.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelRol.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdClave2 = new JLabel();
			jLabelIdClave2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdClave2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelIdClave2.setText("Repetir Contraseña :");
			jLabelContrasena = new JLabel();
			jLabelContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelContrasena.setText("Contraseña :");
			jLabelContrasena.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("Nombre de Usuario en el Sistema :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Id de Usuario Tabla :");
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(6);
			gridLayout.setHgap(10);
			gridLayout.setVgap(16);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(35, 45, 210, 206));
			jPanelEtiquetas.add(jLabelId, null);
			jPanelEtiquetas.add(jLabelDescripcion, null);
			jPanelEtiquetas.add(jLabelRol, null);
			jPanelEtiquetas.add(jLabelContraAnterior, null);
			jPanelEtiquetas.add(jLabelContrasena, null);
			jPanelEtiquetas.add(jLabelIdClave2, null);
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
			gridLayout1.setRows(6);
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(13);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(256, 43, 123, 211));
			jPanelInputs.add(getJTextFieldIdUser(), null);
			jPanelInputs.add(getJTextFieldUserName(), null);
			jPanelInputs.add(getChoiceRol(), null);
			jPanelInputs.add(getJPasswordFieldAnterior(), null);
			jPanelInputs.add(getjTextFieldClave(), null);
			jPanelInputs.add(getJTextFieldClave2(), null);
		}
		return jPanelInputs;
	}

	/**
	 * This method initializes jTextFieldUserName
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUserName() {
		if (jTextFieldUserName == null) {
			jTextFieldUserName = new JTextField();
			jTextFieldUserName.setToolTipText("Ingrese el nombre de usuario");
			jTextFieldUserName.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldUserName.setText(util.cortarCadenaString(
							jTextFieldUserName.getText().trim(), 20));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloLetras(e);
				}
			});
			jTextFieldUserName
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							userDp.setUserName(jTextFieldUserName.getText()
									.trim());
							if (jTextFieldUserName.getText().trim().compareTo(
									"") != 0) {
								cargarDatos();
							} else {
								if (opcionModulo != 0)
									JOptionPane.showMessageDialog(null,
											"Este Campo no puede estar vacío!",
											"Alerta!",
											JOptionPane.ERROR_MESSAGE);
							}

						}
					});
		}
		return jTextFieldUserName;
	}

	/**
	 * This method initializes jTextFieldClave
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldClave() {
		if (jTextFieldClave == null) {
			jTextFieldClave = new JPasswordField();
			jTextFieldClave.setText("noClave");
			jTextFieldClave.setEnabled(false);
			jTextFieldClave.setToolTipText("Ingrese la Nueva Contraseña ");
			jTextFieldClave.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					if (jTextFieldClave.getText().trim().compareTo("") == 0
							&& opcionModulo != 0) {
						JOptionPane.showMessageDialog(null,
								"Este Campo no puede estar vacio!", "Aviso!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						jTextFieldClave2.setEnabled(true);
						userDp.setContrasena(jTextFieldClave.getText());

					}// end else
				}
			});
			jTextFieldClave.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldClave.setText(util.cortarCadenaString(
							jTextFieldClave.getText(), 40));
				}

			});
		}
		return jTextFieldClave;
	}

	/**
	 * This method initializes jTextFieldClave2
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldClave2() {
		if (jTextFieldClave2 == null) {
			jTextFieldClave2 = new JPasswordField();
			jTextFieldClave2.setText("noClave");
			jTextFieldClave2.setEnabled(false);
			jTextFieldClave2
					.setToolTipText("Re-escriba la contraseña escrita en la casilla anterior");
			jTextFieldClave2.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldClave2.setText(util.cortarCadenaString(
							jTextFieldClave2.getText(), 40));
				}

			});
			jTextFieldClave2
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							if (jTextFieldClave2.getText().compareTo(
									jTextFieldClave.getText()) != 0) {
								JOptionPane
										.showMessageDialog(
												null,
												"Las claves ingresadas son diferentes ",
												"Aviso!",
												JOptionPane.INFORMATION_MESSAGE);

							} else {

							}
						}
					});
		}
		return jTextFieldClave2;
	}

	/**
	 * carga las caracteristicas iniciales de la ventana
	 */
	private void cargarObjetoInit() {

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
			jPanelBotones.setBounds(new Rectangle(48, 289, 425, 28));
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
							ingresar();
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
	 * This method initializes jTextFieldIdUser
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIdUser() {
		if (jTextFieldIdUser == null) {
			jTextFieldIdUser = new JTextField();
			jTextFieldIdUser.setEditable(false);
			jTextFieldIdUser.setText("0");
			jTextFieldIdUser.setEnabled(false);
		}
		return jTextFieldIdUser;
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
			choiceRol.removeAll();
			Object descripciones[] = rolMd.seleccionarDescripcionesTabla(con
					.getConexion());
			for (int i = 0; i < descripciones.length; i++) {
				choiceRol.addItem("" + descripciones[i]);
			}

		}
		return choiceRol;
	}

	public void cargarDatos() {
		if (jTextFieldUserName.getText().trim().compareTo("") != 0) {
			userDp = userMd.buscarInfoDeUnRegistro(con.getConexion(), userDp);

			if (userDp.getIdUser() != 0 && opcionModulo == 0) {
				opcionModulo = 2;// activa modificación y eliminación
				userInit.setContrasena(userDp.getContrasena());
				choiceRol.setEnabled(true);
				choiceRol.select(""
						+ rolHashCodigoDescrip.get(userDp.getIdRol()));

				jLabelContraAnterior.setVisible(true);
				jPasswordFieldAnterior.setVisible(true);
				jPasswordFieldAnterior.setEnabled(true);
				jTextFieldIdUser.setText("" + userDp.getIdUser());
				jButtonIngresar.setEnabled(false);
				jButtonModificar.setEnabled(true);
				jButtonEliminar.setEnabled(true);
			} else {
				opcionModulo = 1;// activa insertar
				jTextFieldUserName.setEnabled(false);
				choiceRol.setEnabled(true);
				jPasswordFieldAnterior.setVisible(false);
				jLabelContraAnterior.setVisible(false);
				jTextFieldClave.setEnabled(true);
				jButtonIngresar.setEnabled(true);
				jButtonModificar.setEnabled(false);
				jButtonEliminar.setEnabled(false);
			}// end else1
		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Cédula o Ruc está Vacío! ", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}// end else2

	}

	public void bloqueo() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldUserName.setEnabled(false);
	}

	/**
	 * This method initializes jPasswordFieldAnterior
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getJPasswordFieldAnterior() {
		if (jPasswordFieldAnterior == null) {
			jPasswordFieldAnterior = new JPasswordField();
			jPasswordFieldAnterior.setText("noClave");
			jPasswordFieldAnterior
					.setToolTipText("Para cambiar la contraseña Ingrese aquí la anterior");
			jPasswordFieldAnterior.setEnabled(false);
			jPasswordFieldAnterior
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jPasswordFieldAnterior.setText(util
									.cortarCadenaString(jPasswordFieldAnterior
											.getText(), 40));
						}
					});
			jPasswordFieldAnterior
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							userDp.setContrasena(jPasswordFieldAnterior
									.getText());
							String contraseñaIngresada = codificarClave();
							if (opcionModulo == 2
									&& contraseñaIngresada.compareTo(userInit
											.getContrasena()) == 0) {

								if (userInit.getContrasena().compareTo(
										contraseñaIngresada) == 0) {
									JOptionPane.showMessageDialog(null,
											"Ingrese la nueva Contraseña! ",
											"Aviso!",
											JOptionPane.INFORMATION_MESSAGE);
									jPasswordFieldAnterior.setEnabled(false);
									jTextFieldClave.setEnabled(true);
									jTextFieldClave2.setEnabled(false);
								} else {
									JOptionPane.showMessageDialog(null,
											"Contraseña Inválida! ", "Aviso!",
											JOptionPane.INFORMATION_MESSAGE);

								}

							}// end if comparar contraseñas
						}
					});
		}
		return jPasswordFieldAnterior;
	}

	/**
	 * Función de Ingreso
	 */
	private void ingresar() {
		validar();
		String md5clave = codificarClave();
		int res = JOptionPane.showConfirmDialog(this,
				"Desea guadar los cambios?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Cambios Guardados! ",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
			if (jTextFieldClave2.getText().compareTo("noClave") != 0
					&& jTextFieldClave.getText().compareTo("noClave") != 0)
				userDp.setContrasena(md5clave);
			else {
				userDp.setContrasena(userInit.getContrasena());
			}
			userMd.insertar(con.getConexion(), userDp);
			bloqueo();

		} else {
			JOptionPane.showMessageDialog(null, "No se realizó cambios!",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		}
	}// ingresar

	/**
	 * Funcion de Modificación
	 */
	private void modificar() {
		validar();
		String md5clave = codificarClave();
		int res = JOptionPane.showConfirmDialog(this,
				"Desea guadar los cambios?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Cambios Guardados! ",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
			if (jTextFieldClave2.getText().compareTo("noClave") != 0
					&& jTextFieldClave.getText().compareTo("noClave") != 0)
				userDp.setContrasena(md5clave);
			else {
				userDp.setContrasena(userInit.getContrasena());
			}
			userMd.modificar(con.getConexion(), userDp);
			bloqueo();

		} else {
			JOptionPane.showMessageDialog(null, "No se realizó cambios!",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		}
	}// modificar

	/**
	 * eliminar
	 */
	private void eliminar() {
		validar();
		String md5clave = codificarClave();
		int res = JOptionPane.showConfirmDialog(this,
				"Desea guadar los cambios?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Cambios Guardados! ",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
			if (jTextFieldClave2.getText().compareTo("noClave") != 0
					&& jTextFieldClave.getText().compareTo("noClave") != 0)
				userDp.setContrasena(md5clave);
			else {
				userDp.setContrasena(userInit.getContrasena());
			}
			userMd.eliminar(con.getConexion(), userDp);
			bloqueo();

		} else {
			JOptionPane.showMessageDialog(null, "No se realizó cambios!",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		}
	}// modificar

	private void limpiar() {
		opcionModulo = 0;
		userInit = new user(0, 0, "", "noClave", "noClave"); // @jve:decl-index=0:
		userDp = new user(0, 0, "", "", ""); // @jve:decl-index=0:
		jTextFieldIdUser.setText("0");
		jTextFieldUserName.setEnabled(true);
		jTextFieldUserName.setText("");
		jTextFieldClave.setText("noClave");
		jTextFieldClave2.setText("noClave");
		jPasswordFieldAnterior.setText("noClave");
		jTextFieldClave.setEnabled(false);
		jTextFieldClave2.setEnabled(false);
		jPasswordFieldAnterior.setEnabled(false);
		jButtonIngresar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		choiceRol.setEnabled(false);

	}

	public String codificarClave() {

		MD5 md51 = new MD5();
		try {
			md51.Update(userDp.getContrasena(), null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hash1 = md51.asHex();
		return hash1;
	}

	public void validar() {
		userDp.setUserName(jTextFieldUserName.getText().trim());
		userDp.setIdRol(Integer.parseInt(""
				+ rolHash.get(choiceRol.getSelectedItem())));

		//

	}

} // @jve:decl-index=0:visual-constraint="10,10"
