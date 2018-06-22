package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Utilitarios.utilitarios;
import clases.proveedor;
import clasesBdd.conexionBdd;
import clasesBdd.proveedoresBdd;

public class proveedorVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JButton jButtonIngresar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonLimpiar = null;
	private JPanel jPanelEtiquetas = null;
	private JPanel jPanelInputs = null;
	private JLabel Administraciónproveedor = null;
	private JLabel jLabelId = null;
	private JLabel jLabelDescripcion = null;
	private JTextField jTextFieldId = null;
	private JTextField jTextFieldDescripcion = null;
	private JPanel jPanelInputs2 = null;
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private proveedor proveedorDp = new proveedor(0, "", "", "", "", "", "", ""); // @jve:decl-index=0:
	private proveedoresBdd proveedorMd = new proveedoresBdd();
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private JLabel jLabelId1Telefono1 = null;
	private JLabel jLabelId1Telefono2 = null;
	private JTextField jTextFieldTel1 = null;
	private JTextField jTextFieldTel2 = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private Choice choiceExistentes = null;
	private JLabel jLabelId1RegistrosExistentes = null;
	private JLabel jLabelId1Pais = null;
	private JLabel jLabelId1Ciudad = null;
	private JLabel jLabelId1Contacto = null;
	private JLabel jLabelId1Ruc = null;
	private JTextField jTextFieldPais = null;
	private JTextField jTextFieldCiudad = null;
	private JTextField jTextFieldContacto = null;
	private JTextField jTextFieldRuc = null;

	/**
	 * This is the default constructor
	 */
	public proveedorVentana() {
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
		this.setSize(543, 464);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración de proveedores");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(119, 15, 305, 21));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor.setText("Administración de Proveedor");
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administraciónproveedor, null);
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
			jPanelBotones.setBounds(new Rectangle(54, 379, 425, 28));
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
			jLabelId1Ruc = new JLabel();
			jLabelId1Ruc.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Ruc.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Ruc.setText("R.U.C :");
			jLabelId1Contacto = new JLabel();
			jLabelId1Contacto.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Contacto.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Contacto.setText("Contacto :");
			jLabelId1Ciudad = new JLabel();
			jLabelId1Ciudad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Ciudad.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Ciudad.setText("Ciudad :");
			jLabelId1Pais = new JLabel();
			jLabelId1Pais.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Pais.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Pais.setText("País :");
			jLabelId1Telefono2 = new JLabel();
			jLabelId1Telefono2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Telefono2.setText("Teléfono 2 :");
			jLabelId1Telefono2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Telefono1 = new JLabel();
			jLabelId1Telefono1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Telefono1.setText("Teléfono 1 :");
			jLabelId1Telefono1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID de Proveedor :");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Descripción :");
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(8);
			gridLayout.setHgap(25);
			gridLayout.setVgap(7);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(52, 52, 165, 246));
			jPanelEtiquetas.add(jLabelDescripcion, null);
			jPanelEtiquetas.add(jLabelId, null);
			jPanelEtiquetas.add(jLabelId1Telefono1, null);
			jPanelEtiquetas.add(jLabelId1Telefono2, null);
			jPanelEtiquetas.add(jLabelId1Pais, null);
			jPanelEtiquetas.add(jLabelId1Ciudad, null);
			jPanelEtiquetas.add(jLabelId1Contacto, null);
			jPanelEtiquetas.add(jLabelId1Ruc, null);
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
			gridLayout1.setHgap(6);
			gridLayout1.setVgap(7);
			gridLayout1.setColumns(1);
			jPanelInputs = new JPanel();
			jPanelInputs.setLayout(gridLayout1);
			jPanelInputs.setBounds(new Rectangle(233, 52, 123, 242));
			jPanelInputs.add(getJTextFieldId(), null);
			jPanelInputs.add(getJTextFieldDescripcion(), null);
			jPanelInputs.add(getjTextFieldTel1(), null);
			jPanelInputs.add(getjTextFieldTel2(), null);
			jPanelInputs.add(getJTextFieldPais(), null);
			jPanelInputs.add(getJTextFieldCiudad(), null);
			jPanelInputs.add(getJTextFieldContacto(), null);
			jPanelInputs.add(getJTextFieldRuc(), null);
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
					.setToolTipText("Ingrese una descripción o el nombre de la empresa");
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
								proveedorDp
										.setDescripcion(jTextFieldDescripcion
												.getText().trim());
								jTextFieldTel1.setEnabled(true);
								jTextFieldTel2.setEnabled(true);
								jTextFieldPais.setEnabled(true);
								jTextFieldPais.setEnabled(true);
								jTextFieldCiudad.setEnabled(true);
								jTextFieldContacto.setEnabled(true);
								jTextFieldRuc.setEnabled(true);
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
			jPanelInputs2.setBounds(new Rectangle(75, 317, 285, 36));
			jPanelInputs2.add(jLabelId1RegistrosExistentes, null);
			jPanelInputs2.add(getChoiceExistentes(), null);
		}
		return jPanelInputs2;
	}

	private void buscarItem() {
		anterior = jTextFieldDescripcion.getText().trim();
		proveedorDp = proveedorMd.buscarInfoDeUnRegistro(con.getConexion(),
				proveedorDp);

		if (proveedorDp.getIdProveedor() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			choiceExistentes.setEnabled(false);
			jTextFieldTel1.setEnabled(true);
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
			jTextFieldTel1.setEnabled(true);
			choiceExistentes.setEnabled(false);
			jTextFieldId.setText("" + proveedorDp.getIdProveedor());
			jTextFieldDescripcion.setText(proveedorDp.getDescripcion());
			jButtonIngresar.setEnabled(false);
			jButtonModificar.setEnabled(true);
			jButtonEliminar.setEnabled(true);
			jTextFieldTel1.setText("" + proveedorDp.getTelefono());
			jTextFieldTel1.setEnabled(true);
			jTextFieldTel2.setText("" + proveedorDp.getTelefono2());
			jTextFieldTel2.setEnabled(true);
			jTextFieldPais.setText("" + proveedorDp.getPais());
			jTextFieldPais.setEnabled(true);
			jTextFieldCiudad.setText("" + proveedorDp.getCiudad());
			jTextFieldCiudad.setEnabled(true);
			jTextFieldContacto.setText("" + proveedorDp.getContacto());
			jTextFieldContacto.setEnabled(true);
			jTextFieldRuc.setText("" + proveedorDp.getRuc());
			jTextFieldRuc.setEnabled(true);
		}// end else

	}

	private void bloquear() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
	}

	/**
	 * This method initializes jTextFieldTel1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldTel1() {
		if (jTextFieldTel1 == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("(###)###-######");
				jTextFieldTel1 = new JFormattedTextField(mascara);
				jTextFieldTel1
						.setToolTipText("Ingrese el teléfono del proveedor");
				jTextFieldTel1.setText("(002)333-003333");
				jTextFieldTel1.setEnabled(false);
			} catch (Exception e) {
				e.printStackTrace();
			}

			jTextFieldTel1.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					try {
						proveedorDp.setTelefono(jTextFieldTel1.getText());
					} catch (Exception s) {
						s.printStackTrace();
					}
					jTextFieldTel2.setEnabled(true);
				}
			});
		}

		return jTextFieldTel1;
	}

	/**
	 * This method initializes jTextFieldTel2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getjTextFieldTel2() {
		if (jTextFieldTel2 == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("(###)###-######");
				jTextFieldTel2 = new JFormattedTextField(mascara);
				jTextFieldTel2.setText("(002)333-003333");
				jTextFieldTel2
						.setToolTipText("Ingrese el teléfono del proveedor");
				jTextFieldTel2.setEnabled(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jTextFieldTel2.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					try {
						proveedorDp.setTelefono2(jTextFieldTel2.getText());
					} catch (Exception E1) {
						E1.printStackTrace();
					}
				}
			});
		}
		return jTextFieldTel2;
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
					proveedorDp.setDescripcion(choiceExistentes
							.getSelectedItem());
					opcionModulo = 2;

					buscarItem();

				}
			});
		}
		return choiceExistentes;
	}

	/**
	 * This method initializes jTextFieldPais
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPais() {
		if (jTextFieldPais == null) {
			jTextFieldPais = new JTextField();
			jTextFieldPais.setEnabled(false);
			jTextFieldPais.setToolTipText("Ingrese el País del proveedor");
			jTextFieldPais.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldPais.setText(util.cortarCadenaString(
							jTextFieldPais.getText().trim(), 30));
				}
			});
			jTextFieldPais.addFocusListener(new java.awt.event.FocusListener() {
				public void focusLost(java.awt.event.FocusEvent e) {
					proveedorDp.setPais(jTextFieldPais.getText().trim());
				}

				public void focusGained(java.awt.event.FocusEvent e) {
				}
			});
		}
		return jTextFieldPais;
	}

	/**
	 * This method initializes jTextFieldCiudad
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCiudad() {
		if (jTextFieldCiudad == null) {
			jTextFieldCiudad = new JTextField();
			jTextFieldCiudad.setEnabled(false);
			jTextFieldCiudad.setToolTipText("Ingrese la ciudad del proveedor");
			jTextFieldCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCiudad.setText(util.cortarCadenaString(
							jTextFieldCiudad.getText().trim(), 30));
				}
			});
			jTextFieldCiudad
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							proveedorDp.setCiudad(jTextFieldCiudad.getText()
									.trim());
						}
					});

		}
		return jTextFieldCiudad;
	}

	/**
	 * This method initializes jTextFieldContacto
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldContacto() {
		if (jTextFieldContacto == null) {
			jTextFieldContacto = new JTextField();
			jTextFieldContacto.setEnabled(false);
			jTextFieldContacto
					.setToolTipText("Ingrese el nombre del Contacto en la empresa");
			jTextFieldContacto.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldContacto.setText(util.cortarCadenaString(
							jTextFieldContacto.getText(), 30));
				}
			});
			jTextFieldContacto
					.addFocusListener(new java.awt.event.FocusListener() {
						public void focusLost(java.awt.event.FocusEvent e) {
							proveedorDp.setContacto(jTextFieldContacto
									.getText().trim());
						}

						public void focusGained(java.awt.event.FocusEvent e) {
						}
					});
			jTextFieldContacto
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusLost(java.awt.event.FocusEvent e) {
							System.out.println("focusLost()"); // TODO
							// Auto-generated
							// Event stub
							// focusLost()
						}
					});
		}
		return jTextFieldContacto;
	}

	/**
	 * This method initializes jTextFieldRuc
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRuc() {
		if (jTextFieldRuc == null) {
			jTextFieldRuc = new JTextField();
			jTextFieldRuc.setEnabled(false);
			jTextFieldRuc.setToolTipText("Ingrese el Ruc del Proveedor");
			jTextFieldRuc.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldRuc.setText(util.cortarCadenaString(jTextFieldRuc
							.getText().trim(), 30));
				}
			});
			jTextFieldRuc.addFocusListener(new java.awt.event.FocusListener() {
				public void focusLost(java.awt.event.FocusEvent e) {
					proveedorDp.setRuc(jTextFieldRuc.getText().trim());
				}

				public void focusGained(java.awt.event.FocusEvent e) {
				}
			});
		}

		return jTextFieldRuc;
	}

	private void validar() {
		proveedorDp.setRuc(jTextFieldRuc.getText().trim());
		proveedorDp.setRuc(jTextFieldRuc.getText().trim());
		proveedorDp.setContacto(jTextFieldContacto.getText().trim());
		proveedorDp.setCiudad(jTextFieldCiudad.getText().trim());
		proveedorDp.setPais(jTextFieldPais.getText().trim());
		proveedorDp.setTelefono2(jTextFieldTel2.getText());
		proveedorDp.setTelefono(jTextFieldTel1.getText());

	}

	private void limpiar() {

		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
		jTextFieldDescripcion.setEnabled(true);
		jTextFieldDescripcion.setText("");
		jTextFieldId.setText("");
		jTextFieldTel1.setText("");
		jTextFieldTel2.setText("");
		jTextFieldTel1.setEnabled(false);
		jTextFieldTel2.setEnabled(false);
		choiceExistentes.setEnabled(true);
		jTextFieldPais.setEnabled(false);
		jTextFieldPais.setText("");
		jTextFieldCiudad.setText("");
		jTextFieldCiudad.setEnabled(false);
		jTextFieldContacto.setEnabled(false);
		jTextFieldContacto.setText("");
		jTextFieldRuc.setText("");
		jTextFieldRuc.setEnabled(false);
		opcionModulo = 0;
		proveedorDp = new proveedor(0, "", "", "", "", "", "", "");

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {
		validar();
		if (opcionModulo == 1
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {

			proveedorMd.insertar(con.getConexion(), proveedorDp);
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
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			proveedorMd.modificar(con.getConexion(), proveedorDp);
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
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			proveedorMd.eliminar(con.getConexion(), proveedorDp);
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
		Object descripciones[] = proveedorMd.seleccionarDescripcionesTabla(con
				.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			choiceExistentes.addItem("" + descripciones[i]);
		}
	}

}
