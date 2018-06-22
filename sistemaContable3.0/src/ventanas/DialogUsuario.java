package ventanas;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import md5.MD5;
import Utilitarios.utilitarios;
import clases.rol;
import clases.user;
import clasesBdd.conexionBdd;
import clasesBdd.rolBdd;
import clasesBdd.userBdd;

/**
 *
 */

/**
 * @author Plotter
 * 
 */
class DialogUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbllogo = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;
	private JPanel jPanelInputs = null;
	private JTextField jTextFieldId = null;
	private JPanel jPanelEtiquetas = null;
	private JLabel jLabelUserName = null;
	private JLabel jLabelPass = null;
	private JPasswordField jPasswordField = null;
	private JLabel jLabelRol = null;
	private Choice choiceRol = null;
	private rolBdd rolMd = new rolBdd();
	private userBdd userMd = new userBdd();
	int contador = 0;
	MD5 md5class = new MD5(); // @jve:decl-index=0:
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private rol rolDp = new rol(0, ""); // @jve:decl-index=0:
	java.util.Hashtable<Object, Object> rolHash = rolMd.seleccionarDescripcionesTablaHash(con
			.getConexion()); // @jve:decl-index=0:
	java.util.Hashtable<Object, Object> userUnamePassHash = userMd
			.seleccionarDatosIDRolUserUnameConTablaHash(con.getConexion()); // @jve:decl-index=0:
	java.util.Hashtable<Object, Object> userDescripcionIdRolHash = userMd
			.seleccionarDatosDescripcionIdRolTablaHash(con.getConexion()); // @jve:decl-index=0:
	java.util.Hashtable<Object, Object> userUserNameIdRolHash = userMd
			.seleccionarUserNameIdRolTablaHash(con.getConexion()); // @jve:decl-index=0:
	utilitarios util = new utilitarios();
	user userDp = new user(0, 0, "", "", ""); // @jve:decl-index=0:
	/**
	 * Datos de prueba de roles
	 */

	int admin = 0;
	int tuser = 0;
	Boolean activarAceptar = false; // @jve:decl-index=0:
	/**
	 * solo si hace click sobre el textarea para corregir algo escrito
	 */
	int textoSeleccionado = 0;

	/**
	 * @param owner
	 */
	public DialogUsuario(JFrame owner, String title, boolean modal) {// JFrame
		// ownerasdeasd
		super(owner, title, modal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public DialogUsuario() {
		this(new JFrame(), "Dialog_usuarios", false);

	}

	private void initialize() {
		this.setSize(473, 242);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setTitle("Ingreso al Sistema");
		this.setContentPane(getJContentPane());
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {

			}

		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			lbllogo = new JLabel();
			lbllogo.setBounds(new Rectangle(5, 9, 169, 196));
			/* Manejo de imágenes en un label */
			lbllogo.setIcon(new ImageIcon(getClass().getResource(
					"/images/logoLogin.JPG")));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbllogo, null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
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
			gridLayout2.setVgap(30);
			gridLayout2.setHgap(22);
			gridLayout2.setColumns(2);
			jPanelBotones = new JPanel();
			jPanelBotones.setLayout(gridLayout2);
			jPanelBotones.setBounds(new Rectangle(228, 168, 225, 25));
			jPanelBotones.add(getJButtonAceptar(), null);
			jPanelBotones.add(getJButtonCancelar(), null);
		}
		return jPanelBotones;
	}

	/**
	 * This method initializes jButtonAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setEnabled(false);
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							doclick();
						}
					});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setEnabled(true);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							System.exit(1);

						}
					});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jPanelInputs
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelInputs() {
		if (jPanelInputs == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(3);
			gridLayout1.setVgap(13);
			gridLayout1.setHgap(6);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(339, 16, 116, 111));
			jPanelInputs.add(getJTextFieldId(), null);
			jPanelInputs.add(getJPasswordField(), null);
			jPanelInputs.add(getChoiceRol(), null);
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
			jTextFieldId.setEnabled(true);
			jTextFieldId.setText("");
			jTextFieldId.setToolTipText("Ingrese el Nombre de Usuario");
			jTextFieldId.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					userDp.setUserName(jTextFieldId.getText().trim());
					clases.rol rolDp = new rol(0, "");
					rolDp.setDescripcion(jTextFieldId.getText().trim());
					if (userUserNameIdRolHash.get(userDp.getUserName()) != null
							&& jTextFieldId.getText().trim().compareTo("") != 0) {
						String rol = ""
								+ userUserNameIdRolHash.get(userDp
										.getUserName());
						choiceRol
								.select("" + userDescripcionIdRolHash.get(rol));
					} else {
						if (jTextFieldId.getText().trim().compareTo("") != 0)
							JOptionPane.showMessageDialog(null,
									"El Usuario Ingresado no existe!",
									"Alerta!", JOptionPane.ERROR_MESSAGE);
					}

				}
			});
			jTextFieldId.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (textoSeleccionado == 1) {
						jTextFieldId.setText("" + e.getKeyChar());
						textoSeleccionado = 0;
					}
					util.soloLetras(e);

				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					jTextFieldId.setText(util.cortarCadenaString(jTextFieldId
							.getText().trim(), 30));
				}
			});
			jTextFieldId.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextFieldId.selectAll();
					textoSeleccionado = 1;
				}
			});
		}
		return jTextFieldId;
	}

	/**
	 * This method initializes jPanelEtiquetas
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			jLabelRol = new JLabel();
			jLabelRol.setText("Rol :");
			jLabelRol.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelRol.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPass = new JLabel();
			jLabelPass.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPass.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPass.setText("Contraseña:");
			jLabelUserName = new JLabel();
			jLabelUserName.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelUserName.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUserName.setText("Nombre de Usuario :");
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(3);
			gridLayout.setVgap(12);
			gridLayout.setHgap(25);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(192, 16, 133, 108));
			jPanelEtiquetas.add(jLabelUserName, null);
			jPanelEtiquetas.add(jLabelPass, null);
			jPanelEtiquetas.add(jLabelRol, null);
		}
		return jPanelEtiquetas;
	}

	/**
	 * This method initializes jPasswordField
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					if (jPasswordField.getText().compareTo("") != 0) {
						userDp.setContrasena(jPasswordField.getText());
						userDp.setContrasena(codificarClave());

						jButtonAceptar.setEnabled(true);
					} else
						jButtonAceptar.setEnabled(false);
				}
			});
			jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (!activarAceptar) {
						jButtonAceptar.setEnabled(true);
						activarAceptar = true;
					}
					if (textoSeleccionado == 1) {

						textoSeleccionado = 0;
					}

				}
			});
			jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jPasswordField.selectAll();
					textoSeleccionado = 1;
				}
			});
		}
		return jPasswordField;
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
		}
		cargarChoice();
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

	public void cerrar() {
		this.setVisible(false);
	}

	public void doclick() {
		// System.out.print(userUnamePassHash.get(jTextFieldId
		// .getText()));

		if (userDp.getContrasena().compareTo(
				"" + userUnamePassHash.get(jTextFieldId.getText())) == 0) {
			cerrar();
			PantallaPrincipal pPrincipalVentana = new PantallaPrincipal(userDp
					.getUserName(), choiceRol.getSelectedItem());
			pPrincipalVentana.getPreferredSize();
			pPrincipalVentana.setVisible(true);

		} else {

			JOptionPane.showMessageDialog(null,
					"Contraseña  o usuario Inválido!", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
