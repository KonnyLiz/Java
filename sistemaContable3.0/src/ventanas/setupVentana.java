package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.UnsupportedEncodingException;

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
import clases.setup;
import clasesBdd.conexionBdd;
import clasesBdd.setupBdd;

public class setupVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonModificar = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administracióndelsistema = null;
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JPasswordField jTextFieldClave = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	MD5 md5class = new MD5(); // @jve:decl-index=0:
	private setup setupDpInit = new setup(0, "", ""); // @jve:decl-index=0:
	private setup setupDp = new setup(-1, "sin clave", "sin clave"); // @jve:decl-index=0:
	private setupBdd setupMd = new setupBdd(); // @jve:decl-index=0:
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private JLabel jLabelNomenclatura = null;
	private JTextField jTextFieldImpresora = null;
	private JPasswordField jTextFieldClave2 = null;
	private JLabel jLabelIdClave2 = null;
	private JLabel jLabelPorcentaje = null;

	/**
	 * This is the default constructor
	 */
	public setupVentana() {
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
		this.setTitle("Administración de Configuración del Sistema");
		cargarObjetoInit();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelPorcentaje = new JLabel();
			jLabelPorcentaje.setBounds(new Rectangle(361, 50, 22, 22));
			jLabelPorcentaje.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelPorcentaje.setText("%");
			jLabelPorcentaje.setFont(new Font("Impact", Font.BOLD, 24));
			jLabelPorcentaje.setHorizontalAlignment(SwingConstants.LEFT);
			Administracióndelsistema = new JLabel();
			Administracióndelsistema.setBounds(new Rectangle(119, 15, 305, 21));
			Administracióndelsistema.setForeground(Color.blue);
			Administracióndelsistema.setText("Administración del Sistema");
			Administracióndelsistema
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndelsistema.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndelsistema, null);
			jContentPane.add(jLabelPorcentaje, null);
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
			gridLayout2.setColumns(1);
			jPanelBotones = new JPanel();
			jPanelBotones.setLayout(gridLayout2);
			jPanelBotones.setBounds(new Rectangle(226, 251, 113, 28));
			jPanelBotones.add(getJButtonModificar(), null);
		}
		return jPanelBotones;
	}

	/**
	 * This method initializes jButtonModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setEnabled(true);
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
	 * This method initializes jPanelEtiquetas
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			jLabelIdClave2 = new JLabel();
			jLabelIdClave2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelIdClave2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelIdClave2.setText("Repetir Contraseña :");
			jLabelNomenclatura = new JLabel();
			jLabelNomenclatura.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNomenclatura.setText("Nombre De la Impresora :");
			jLabelNomenclatura.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("Valor Del Impuesto I.V.A :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Clave de Administración :");
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
			jPanelEtiquetas.add(jLabelIdClave2, null);
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
			jPanelInputs.add(getjTextFieldClave(), null);
			jPanelInputs.add(getJTextFieldClave2(), null);
			jPanelInputs.add(getjTextFieldImpresora(), null);
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
			jTextFieldId.setToolTipText("Valor del I.V.A.");
			jTextFieldId.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldId.setText(util.cortarCadenaString(jTextFieldId
							.getText().trim(), 2));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
			jTextFieldId.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					setupDp.setIva(Float.parseFloat(jTextFieldId.getText()));
				}
			});
		}
		return jTextFieldId;
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
			jTextFieldClave
					.setToolTipText("Modifica la contraseña Maestra del sistema");
			jTextFieldClave.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					if (jTextFieldClave.getText().trim().compareTo("") == 0
							&& opcionModulo != 0) {
						JOptionPane.showMessageDialog(null,
								"Este Campo no puede estar vacio!", "Aviso!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						setupDp.setClaveAdministracion(jTextFieldClave
								.getText().trim());

					}// end else
				}
			});
			jTextFieldClave.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldClave.setText(util.cortarCadenaString(
							jTextFieldClave.getText(), 40));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloLetras(e);
				}
			});
		}
		return jTextFieldClave;
	}

	/**
	 * Función de Ingreso
	 */

	/**
	 * Funcion de Modificación
	 */
	private void modificar() {
		MD5 md5 = new MD5();
		try {
			md5.Update(setupDp.getClaveAdministracion(), null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hash = md5.asHex();

		int res = JOptionPane.showConfirmDialog(this,
				"Desea guadar los cambios?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		String respuesta = null;
		if (res == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Cambios Guardados! ",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
			if (jTextFieldClave2.getText().compareTo("noClave") != 0
					&& jTextFieldClave.getText().compareTo("noClave") != 0)
				setupDp.setClaveAdministracion(hash);
			else {
				setupDp.setClaveAdministracion(setupDpInit
						.getClaveAdministracion());
			}
			setupMd.modificar(con.getConexion(), setupDp);

		} else {
			JOptionPane.showMessageDialog(null, "No se realizó cambios!",
					"Aviso!", JOptionPane.INFORMATION_MESSAGE);
		}

	}// modificar

	/**
	 * This method initializes jTextFieldImpresora
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldImpresora() {
		if (jTextFieldImpresora == null) {
			jTextFieldImpresora = new JTextField();
			jTextFieldImpresora
					.setToolTipText("Ingrese el nombre de la impresora a utilizar");
			jTextFieldImpresora
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							setupDp.setImpresoraNombre(jTextFieldImpresora
									.getText().trim());
						}
					});
			jTextFieldImpresora.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldImpresora.setText(util.cortarCadenaString(
							jTextFieldImpresora.getText(), 6));

				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloLetras(e);
				}
			});
		}
		return jTextFieldImpresora;
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
			jTextFieldClave2
					.setToolTipText("Verifica que la contraseña escrita sea la misma");
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
								setupDp.setClaveAdministracion(jTextFieldClave2
										.getText().trim());
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
		setupMd.buscarInfoDeUnRegistro(con.getConexion(), setupDpInit);
		jTextFieldId.setText("" + setupDpInit.getIva());
		jTextFieldImpresora.setText(setupDpInit.getImpresoraNombre());
		setupDp.setClaveAdministracion(setupDpInit.getClaveAdministracion());
		setupDp.setImpresoraNombre(setupDpInit.getImpresoraNombre());
		setupDp.setIva(setupDpInit.getIva());

	}

} // @jve:decl-index=0:visual-constraint="10,10"

