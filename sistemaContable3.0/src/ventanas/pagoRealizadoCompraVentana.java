package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.pagoRealizado;
import clasesBdd.conexionBdd;
import clasesBdd.pagoRealizadoBdd;

//public class pagoRealizadoCompraVentana extends JInternalFrame {
	public class pagoRealizadoCompraVentana extends JFrame {
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
	private conexionBdd con = new conexionBdd(); // @jve:decl-index=0:
	private pagoRealizado pagoRealizadoDp = new pagoRealizado(0, "", "", null,
			"", null, "", null, "", null); // @jve:decl-index=0:
	private pagoRealizadoBdd pagoRealizadoMd = new pagoRealizadoBdd(); // @jve:decl-index=0:
	/**
	 * Opción de trabajo del módulo en 1 se activa insertar, 2 modificar, en 3
	 * eliminar
	 */
	private int opcionModulo = 0;
	private String anterior;
	private JTextField jTextFieldFoto1 = null;
	private JLabel jLabelId1Foto1 = null;

	private JButton jButtonFoto1 = null;

	private JLabel jLabelDocumentoAduana = null;

	private JTextField jTextFieldFoto2 = null;

	private JButton jButtonFoto2 = null;

	private JLabel jLabelDocumentoImportacion = null;

	private JTextField jTextFieldFoto3 = null;

	private JButton jButtonFoto3 = null;

	private JLabel jLabelDocumentoFactura = null;

	private JTextField jTextFieldFoto4 = null;

	private JButton jButtonFoto4 = null;

	private JPanel jPanelButtons2 = null;

	/**
	 * This is the default constructor
	 */
	public pagoRealizadoCompraVentana() {
		super();
		initialize();
		//this.setClosable(true);
		//this.setIconifiable(true);
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(542, 396);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración Pago Realizado por Compras o Gastos");
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
					.setText("Administración de Documentos de Importación");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelBotones(), null);
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(getJPanelInputs(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJPanelButtons2(), null);
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
			jLabelDocumentoFactura = new JLabel();
			jLabelDocumentoFactura.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDocumentoFactura.setText("Archivo factura Pago :");
			jLabelDocumentoFactura
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDocumentoImportacion = new JLabel();
			jLabelDocumentoImportacion
					.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDocumentoImportacion
					.setText("Archivo documentos Importación :");
			jLabelDocumentoImportacion
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDocumentoAduana = new JLabel();
			jLabelDocumentoAduana.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelDocumentoAduana.setText("Archivo documentos Aduana :");
			jLabelDocumentoAduana
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId1Foto1 = new JLabel();
			jLabelId1Foto1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId1Foto1.setText("Archivo Pago Bancario :");
			jLabelId1Foto1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setText("ID Pago:");
			jLabelDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId = new JLabel();
			jLabelId.setText("Descripción :");
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(6);
			gridLayout.setHgap(25);
			gridLayout.setVgap(12);
			gridLayout.setColumns(1);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(21, 52, 196, 200));
			jPanelEtiquetas.add(jLabelDescripcion, null);
			jPanelEtiquetas.add(jLabelId, null);
			jPanelEtiquetas.add(jLabelId1Foto1, null);
			jPanelEtiquetas.add(jLabelDocumentoAduana, null);
			jPanelEtiquetas.add(jLabelDocumentoImportacion, null);
			jPanelEtiquetas.add(jLabelDocumentoFactura, null);
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
			jPanelInputs.setBounds(new Rectangle(233, 52, 123, 201));
			jPanelInputs.add(getJTextFieldId(), null);
			jPanelInputs.add(getJTextFieldDescripcion(), null);
			jPanelInputs.add(getJTextFieldFoto1(), null);
			jPanelInputs.add(getJTextFieldFoto2(), null);
			jPanelInputs.add(getJTextFieldFoto3(), null);
			jPanelInputs.add(getJTextFieldFoto4(), null);
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
	 * This method initializes jTextFieldDescripcion
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDescripcion() {
		if (jTextFieldDescripcion == null) {
			jTextFieldDescripcion = new JTextField();
			jTextFieldDescripcion
					.setToolTipText("Modifica la Información del Tipo de Cliente");
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
								pagoRealizadoDp
										.setDescripcion(jTextFieldDescripcion
												.getText().trim());
								buscarItem();
							}// end else
						}
					});

		}
		return jTextFieldDescripcion;
	}

	/**
	 * This method initializes jTextFieldFoto1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFoto1() {
		if (jTextFieldFoto1 == null) {
			jTextFieldFoto1 = new JTextField();
			jTextFieldFoto1.setEditable(false);
		}
		return jTextFieldFoto1;
	}

	/**
	 * This method initializes jButtonFoto1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFoto1() {
		if (jButtonFoto1 == null) {
			jButtonFoto1 = new JButton();
			jButtonFoto1.setText(".....");
			jButtonFoto1.setEnabled(false);
			jButtonFoto1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String nombreArchivo = cargarfotoDiscoDuro("bufferBank");
						pagoRealizadoDp
								.setNombreArchivoPagoBancario(nombreArchivo);
						jTextFieldFoto1.setText(nombreArchivo);
						// mostrarJpgImg(nombreArchivo);
					} catch (Exception ed) {
						ed.printStackTrace();
					}
				}
			});
		}
		return jButtonFoto1;
	}

	/**
	 * This method initializes jTextFieldFoto2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFoto2() {
		if (jTextFieldFoto2 == null) {
			jTextFieldFoto2 = new JTextField();
			jTextFieldFoto2.setEditable(false);
		}
		return jTextFieldFoto2;
	}

	/**
	 * This method initializes jButtonFoto2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFoto2() {
		if (jButtonFoto2 == null) {
			jButtonFoto2 = new JButton();
			jButtonFoto2.setText(".....");
			jButtonFoto2.setEnabled(false);
			jButtonFoto2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					String nombreArchivo = cargarfotoDiscoDuro("bufferDocAduana");
					pagoRealizadoDp.setNombredocumentosAduana(nombreArchivo);
					jTextFieldFoto2.setText(nombreArchivo);
					// mostrarJpgImg(nombreArchivo);

				}
			});
		}
		return jButtonFoto2;
	}

	/**
	 * This method initializes jTextFieldFoto3
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFoto3() {
		if (jTextFieldFoto3 == null) {
			jTextFieldFoto3 = new JTextField();
			jTextFieldFoto3.setEditable(false);
		}
		return jTextFieldFoto3;
	}

	/**
	 * This method initializes jButtonFoto3
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFoto3() {
		if (jButtonFoto3 == null) {
			jButtonFoto3 = new JButton();
			jButtonFoto3.setText(".....");
			jButtonFoto3.setEnabled(false);
			jButtonFoto3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nombreArchivo = cargarfotoDiscoDuro("bufferDocImport");
					jTextFieldFoto3.setText(nombreArchivo);
					pagoRealizadoDp
							.setNombreArchivoDocumentosImportacion(nombreArchivo);

					// mostrarJpgImg(nombreArchivo);

				}
			});
		}
		return jButtonFoto3;
	}

	/**
	 * This method initializes jTextFieldFoto4
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFoto4() {
		if (jTextFieldFoto4 == null) {
			jTextFieldFoto4 = new JTextField();
			jTextFieldFoto4.setEditable(false);
		}
		return jTextFieldFoto4;
	}

	/**
	 * This method initializes jButtonFoto4
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonFoto4() {
		if (jButtonFoto4 == null) {
			jButtonFoto4 = new JButton();
			jButtonFoto4.setEnabled(false);
			jButtonFoto4.setText(".....");
			jButtonFoto4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nombreArchivo = cargarfotoDiscoDuro("bufferDocFact");
					pagoRealizadoDp.setNombreArchivoFactura(nombreArchivo);
					jTextFieldFoto4.setText(nombreArchivo);
					// mostrarJpgImg(nombreArchivo);

				}
			});
		}
		return jButtonFoto4;
	}

	/**
	 * This method initializes jPanelButtons2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelButtons2() {
		if (jPanelButtons2 == null) {
			GridLayout gridLayoutButtons = new GridLayout();
			gridLayoutButtons.setRows(4);
			gridLayoutButtons.setHgap(6);
			gridLayoutButtons.setVgap(13);
			gridLayoutButtons.setColumns(1);
			jPanelButtons2 = new JPanel();
			jPanelButtons2.setLayout(gridLayoutButtons);
			jPanelButtons2.setBounds(new Rectangle(362, 124, 62, 126));
			jPanelButtons2.add(getJButtonFoto1(), null);
			jPanelButtons2.add(getJButtonFoto2(), null);
			jPanelButtons2.add(getJButtonFoto3(), null);
			jPanelButtons2.add(getJButtonFoto4(), null);
		}
		return jPanelButtons2;
	}

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
		// ventImg.cambiar(nombreArchivo);

	}

	/*
	 * Muestra menú para cargar una imagen
	 *
	 *
	 *
	 */

	public String cargarfotoDiscoDuro(String NombreArchivo) {

		String nombredelaImagen = null;
		Frame parent = new Frame();
		parent.setSize(new Dimension(129, 39));
		FileDialog fd = new FileDialog(parent, "Selecione un archivo:",
				FileDialog.LOAD);
		fd.setVisible(true);
		String selectedItem = fd.getFile();
		if (selectedItem == null) {
			JOptionPane.showMessageDialog(null,
					"No se ha seleccionado un archivo!", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		} else {
			File ffile = new File(fd.getDirectory() + File.separator
					+ fd.getFile());
			// System.out.print(fd.getDirectory()+ fd.getFile());
			nombredelaImagen = fd.getDirectory() + fd.getFile();

			try {

				File fichero = new File("bin/imagesBuff/" + NombreArchivo
						+ ".jpg");
				if (ffile.length() > 1800000) {
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
		}
		return nombredelaImagen;
	}// end cargar foto

	private void buscarItem() {
		pagoRealizadoDp = pagoRealizadoMd.buscarInfoDeUnRegistro(con
				.getConexion(), pagoRealizadoDp);

		if (pagoRealizadoDp.getIdPagoRealizado() == 0) {
			/**
			 * inicia la insercion en tabla
			 */
			jButtonFoto1.setEnabled(true);
			jButtonFoto2.setEnabled(true);
			jButtonFoto3.setEnabled(true);
			jButtonFoto4.setEnabled(true);
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
			jTextFieldId.setText("" + pagoRealizadoDp.getIdPagoRealizado());
			jTextFieldDescripcion.setText(pagoRealizadoDp.getDescripcion());
			jTextFieldFoto1.setText(pagoRealizadoDp
					.getNombreArchivoPagoBancario());
			jTextFieldFoto2
					.setText(pagoRealizadoDp.getNombredocumentosAduana());
			jTextFieldFoto3.setText(pagoRealizadoDp
					.getNombreArchivoDocumentosImportacion());
			jTextFieldFoto4.setText(pagoRealizadoDp.getNombreArchivoFactura());
			jButtonFoto1.setEnabled(true);
			jButtonFoto2.setEnabled(true);
			jButtonFoto3.setEnabled(true);
			jButtonFoto4.setEnabled(true);
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
		jTextFieldFoto1.setText("");
		jTextFieldFoto2.setText("");
		jTextFieldFoto3.setText("");
		jTextFieldFoto4.setText("");
		jTextFieldId.setText("0");
		opcionModulo = 0;
		pagoRealizadoDp = new pagoRealizado(0, "", "", null, "", null, "",
				null, "", null); // @jve:decl-index=0:

	}// fin limpiar

	/**
	 * Función de Ingreso
	 */
	private void insertar() {
		cargarObjeto();
		if (opcionModulo == 1
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			pagoRealizadoMd.insertar(con.getConexion(), pagoRealizadoDp);

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
		cargarObjeto();
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			pagoRealizadoMd.modificar(con.getConexion(), pagoRealizadoDp);

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
		cargarObjeto();
		if (opcionModulo == 2
				&& jTextFieldDescripcion.getText().compareTo("") != 0) {
			pagoRealizadoMd.eliminar(con.getConexion(), pagoRealizadoDp);

		} else {
			JOptionPane.showMessageDialog(null,
					"El campo Descripción Está Vacio! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

		}// end else
		bloquear();
	}// eliminar

	private void bloquear() {
		jButtonIngresar.setEnabled(false);
		jButtonModificar.setEnabled(false);
		jButtonEliminar.setEnabled(false);
	}

	/*
	 * void mostrar(){ System.out.print("\ndesc:
	 * "+pagoRealizadoDp.getDescripcion()); System.out.print("\narchivoImp:
	 * "+pagoRealizadoDp.getNombreArchivoDocumentosImportacion());
	 * System.out.print("\nfactura:
	 * "+pagoRealizadoDp.getNombreArchivoFactura());
	 * System.out.print("\npagoBancario:
	 * "+pagoRealizadoDp.getNombreArchivoPagoBancario());
	 * System.out.print("\ndoc aduana:
	 * "+pagoRealizadoDp.getNombredocumentosAduana()); }
	 */
	void cargarObjeto() {
		pagoRealizadoDp.setDescripcion(jTextFieldDescripcion.getText().trim());
		pagoRealizadoDp.setIdPagoRealizado(Integer.parseInt(jTextFieldId
				.getText().trim()));
		pagoRealizadoDp.setNombreArchivoDocumentosImportacion(jTextFieldFoto3
				.getText().trim());
		pagoRealizadoDp.setNombreArchivoFactura(jTextFieldFoto4.getText()
				.trim());
		pagoRealizadoDp.setNombreArchivoPagoBancario(jTextFieldFoto1.getText()
				.trim());
		pagoRealizadoDp.setNombredocumentosAduana(jTextFieldFoto2.getText()
				.trim());

	}

} // @jve:decl-index=0:visual-constraint="10,10"

