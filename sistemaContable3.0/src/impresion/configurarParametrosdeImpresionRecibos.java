package impresion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Utilitarios.utilitarios;
import clases.cliente;
import clases.ordenDeTrabajo;
import clases.ordenTrabajoDetalle;

public class configurarParametrosdeImpresionRecibos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel23 = null;
	private JLabel jLabelNombre = null;
	private JLabel jLabelBiuscar141 = null;
	private JLabel jLabelTelefono = null;
	private JPanel jPanel231 = null;
	private JTextField jTextFieldXNombre = null;
	private JTextField jTextFieldXTel = null;
	private JTextField jTextFieldXFEcha = null;
	private JLabel jLabelNombre1 = null;
	private JLabel jLabelNombre11 = null;
	private JPanel jPanel2311 = null;
	private JTextField jTextFieldYNombre1 = null;
	private JTextField jTextFieldYFEcha1 = null;
	private JTextField jTextFieldYTel1 = null;
	private JLabel jLabelTelefono1 = null;
	private JTextField jTextFieldXNomArc = null;
	private JTextField jTextFieldYNombArch = null;
	private JLabel jLabelTelefono11 = null;
	private JTextField jTextFieldXTT = null;
	private JTextField jTextFieldYTT = null;
	private JLabel jLabelTelefono111 = null;
	private JTextField jTextFieldXItems = null;
	private JTextField jTextFieldYItems = null;
	private JLabel jLabelValorT = null;
	private JLabel jLabelAbono = null;
	private JLabel jLabelPrecio = null;
	private JLabel jLabelTelefono11111 = null;
	private JTextField jTextFieldXValorT = null;
	private JTextField jTextFieldXValorTrab = null;
	private JTextField jTextFieldXAbono = null;
	private JTextField jTextFieldXSaldo = null;
	private JTextField jTextFieldXObservaciones = null;
	private JTextField jTextFieldYIAbono = null;
	private JTextField jTextFieldYSaldo = null;
	private JTextField jTextFieldYObservaciones = null;
	private JLabel jLabelTelefono111111 = null;
	private JTextField jTextFieldTamLetra = null;
	private JLabel jLabelTelefono1111111 = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private JPanel jPanel232 = null;
	private JLabel jLabelUnidad = null;
	private JLabel jLabelUnidad1 = null;
	private JLabel jLabelUnidad2 = null;
	private JLabel jLabelUnidad3 = null;
	private JLabel jLabelUnidad4 = null;
	private JLabel jLabelUnidad5 = null;
	private JLabel jLabelUnidad6 = null;
	private JLabel jLabelUnidad7 = null;
	private JLabel jLabelUnidad8 = null;
	private JLabel jLabelUnidad9 = null;
	private JLabel jLabelUnidad10 = null;
	private JLabel jLabelUnidad11 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JRadioButton jRadioButton = null;
	impresionFacturaPanel facturaPanel = new impresionFacturaPanel();
	impresionProformaPanel ProformaPanel = new impresionProformaPanel();

	/**
	 * This is the default constructor
	 */
	public configurarParametrosdeImpresionRecibos() {
		super();
		initialize();
		this.setClosable(true);
		this.setIconifiable(true);
		cargarDatos();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(758, 445);
		this.setContentPane(getJContentPane());
		this.setTitle("Configuración de Parámetros de Impresión");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelNombre11 = new JLabel();
			jLabelNombre11.setBounds(new Rectangle(255, 6, 58, 19));
			jLabelNombre11.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNombre11.setText("y");
			jLabelNombre11.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelNombre1 = new JLabel();
			jLabelNombre1.setBounds(new Rectangle(172, 6, 61, 21));
			jLabelNombre1.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNombre1.setText("x");
			jLabelNombre1.setHorizontalAlignment(SwingConstants.CENTER);
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJPanel23(), null);
			jPanel.add(getJPanel231(), null);
			jPanel.add(jLabelNombre1, null);
			jPanel.add(jLabelNombre11, null);
			jPanel.add(getJPanel2311(), null);
			jPanel.add(getJPanel232(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTabbedPane
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setName("Orden De Trabajo");
			jTabbedPane.addTab("Orden De Trabajo", null, getJPanel(), null);
			jTabbedPane.addTab("Factura", null, facturaPanel, null);
			jTabbedPane.addTab("Proforma", null, ProformaPanel, null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel23
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jLabelTelefono1111111 = new JLabel();
			jLabelTelefono1111111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono1111111.setText("Negrilla :");
			jLabelTelefono1111111
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono111111 = new JLabel();
			jLabelTelefono111111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono111111.setText("Tamaño Letra :");
			jLabelTelefono111111
					.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono11111 = new JLabel();
			jLabelTelefono11111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono11111.setText("Observaciones :");
			jLabelTelefono11111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPrecio = new JLabel();
			jLabelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPrecio.setText("Saldo:");
			jLabelPrecio.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelAbono = new JLabel();
			jLabelAbono.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelAbono.setText("Abono :");
			jLabelAbono.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorT = new JLabel();
			jLabelValorT.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorT.setText("Valor Del Trabajo :");
			jLabelValorT.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono111 = new JLabel();
			jLabelTelefono111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono111.setText("Items :");
			jLabelTelefono111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono11 = new JLabel();
			jLabelTelefono11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono11.setText("Tipo Trabajo :");
			jLabelTelefono11.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono1 = new JLabel();
			jLabelTelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono1.setText("Nombre Archivo :");
			jLabelTelefono1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono = new JLabel();
			jLabelTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono.setText("Teléfono :");
			jLabelTelefono.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBiuscar141 = new JLabel();
			jLabelBiuscar141.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBiuscar141.setText("Fecha :");
			jLabelBiuscar141.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelNombre = new JLabel();
			jLabelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNombre.setText("Nombre :");
			jLabelNombre.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout23 = new GridLayout();
			gridLayout23.setRows(12);
			gridLayout23.setVgap(10);
			gridLayout23.setHgap(10);
			jPanel23 = new JPanel();
			jPanel23.setLayout(gridLayout23);
			jPanel23.setBounds(new Rectangle(10, 32, 143, 336));
			jPanel23.add(jLabelNombre, null);
			jPanel23.add(jLabelBiuscar141, null);
			jPanel23.add(jLabelTelefono, null);
			jPanel23.add(jLabelTelefono1, null);
			jPanel23.add(jLabelTelefono11, null);
			jPanel23.add(jLabelTelefono111, null);
			jPanel23.add(jLabelValorT, null);
			jPanel23.add(jLabelAbono, null);
			jPanel23.add(jLabelPrecio, null);
			jPanel23.add(jLabelTelefono11111, null);
			jPanel23.add(jLabelTelefono111111, null);
			jPanel23.add(jLabelTelefono1111111, null);
		}
		return jPanel23;
	}

	/**
	 * This method initializes jPanel231
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel231() {
		if (jPanel231 == null) {
			GridLayout gridLayout231 = new GridLayout();
			gridLayout231.setRows(12);
			gridLayout231.setVgap(10);
			gridLayout231.setHgap(10);
			jPanel231 = new JPanel();
			jPanel231.setLayout(gridLayout231);
			jPanel231.setBounds(new Rectangle(174, 33, 58, 333));
			jPanel231.add(getJTextFieldXNombre(), null);
			jPanel231.add(getJTextFieldXFEcha(), null);
			jPanel231.add(getJTextFieldXTel(), null);
			jPanel231.add(getJTextFieldXNomArc(), null);
			jPanel231.add(getJTextFieldXTT(), null);
			jPanel231.add(getJTextFieldXItems(), null);
			jPanel231.add(getJTextFieldXValorT(), null);
			jPanel231.add(getJTextFieldXAbono(), null);
			jPanel231.add(getJTextFieldXSaldo(), null);
			jPanel231.add(getJTextFieldXObservaciones(), null);
			jPanel231.add(getJTextFieldTamLetra(), null);
			jPanel231.add(getJRadioButton(), null);
		}
		return jPanel231;
	}

	/**
	 * This method initializes jTextFieldXNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXNombre() {
		if (jTextFieldXNombre == null) {
			jTextFieldXNombre = new JTextField();
			jTextFieldXNombre.setText("0");
			jTextFieldXNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXNombre.setText(util
							.cortarCadenaFloat(jTextFieldXNombre.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
		}
		return jTextFieldXNombre;
	}

	/**
	 * This method initializes jTextFieldXTel
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXTel() {
		if (jTextFieldXTel == null) {
			jTextFieldXTel = new JTextField();
			jTextFieldXTel.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXTel
							.setText(util.cortarCadenaFloat(jTextFieldXTel
									.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXTel;
	}

	/**
	 * This method initializes jTextFieldXFEcha
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXFEcha() {
		if (jTextFieldXFEcha == null) {
			jTextFieldXFEcha = new JTextField();
			jTextFieldXNombre.setText("0");
			jTextFieldXFEcha.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXFEcha.setText(util
							.cortarCadenaFloat(jTextFieldXFEcha.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXFEcha;
	}

	/**
	 * This method initializes jPanel2311
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2311() {
		if (jPanel2311 == null) {
			GridLayout gridLayout2311 = new GridLayout();
			gridLayout2311.setRows(12);
			gridLayout2311.setVgap(10);
			gridLayout2311.setHgap(10);
			jPanel2311 = new JPanel();
			jPanel2311.setLayout(gridLayout2311);
			jPanel2311.setBounds(new Rectangle(257, 31, 56, 336));
			jPanel2311.add(getJTextFieldYNombre1(), null);
			jPanel2311.add(getJTextFieldYFEcha1(), null);
			jPanel2311.add(getJTextFieldYTel1(), null);
			jPanel2311.add(getJTextFieldYNombArch(), null);
			jPanel2311.add(getJTextFieldYTT(), null);
			jPanel2311.add(getJTextFieldYItems(), null);
			jPanel2311.add(getJTextFieldXValorTrab(), null);
			jPanel2311.add(getJTextFieldYIAbono(), null);
			jPanel2311.add(getJTextFieldYSaldo(), null);
			jPanel2311.add(getJTextFieldYObservaciones(), null);
		}
		return jPanel2311;
	}

	/**
	 * This method initializes jTextFieldYNombre1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYNombre1() {
		if (jTextFieldYNombre1 == null) {
			jTextFieldYNombre1 = new JTextField();
			jTextFieldXNombre.setText("0");
			jTextFieldYNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXNombre.setText(util
							.cortarCadenaFloat(jTextFieldXNombre.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYNombre1;
	}

	/**
	 * This method initializes jTextFieldYFEcha1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYFEcha1() {
		if (jTextFieldYFEcha1 == null) {
			jTextFieldYFEcha1 = new JTextField();
			jTextFieldXNombre.setText("0");
			jTextFieldYFEcha1.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYFEcha1.setText(util
							.cortarCadenaFloat(jTextFieldYFEcha1.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYFEcha1;
	}

	/**
	 * This method initializes jTextFieldYTel1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYTel1() {
		if (jTextFieldYTel1 == null) {
			jTextFieldYTel1 = new JTextField();
			jTextFieldYTel1.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYTel1
							.setText(util.cortarCadenaFloat(jTextFieldYTel1
									.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYTel1;
	}

	/**
	 * This method initializes jTextFieldXNomArc
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXNomArc() {
		if (jTextFieldXNomArc == null) {
			jTextFieldXNomArc = new JTextField();
			jTextFieldXNomArc.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXNomArc.setText(util
							.cortarCadenaFloat(jTextFieldXNomArc.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});

		}
		return jTextFieldXNomArc;
	}

	/**
	 * This method initializes jTextFieldYNombArch
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYNombArch() {
		if (jTextFieldYNombArch == null) {
			jTextFieldYNombArch = new JTextField();
			jTextFieldYNombArch.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYNombArch.setText(util
							.cortarCadenaFloat(jTextFieldYNombArch.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYNombArch;
	}

	/**
	 * This method initializes jTextFieldXTT
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXTT() {
		if (jTextFieldXTT == null) {
			jTextFieldXTT = new JTextField();
			jTextFieldXTT.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXTT.setText(util.cortarCadenaFloat(jTextFieldXTT
							.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXTT;
	}

	/**
	 * This method initializes jTextFieldYTT
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYTT() {
		if (jTextFieldYTT == null) {
			jTextFieldYTT = new JTextField();
			jTextFieldYTT.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYTT.setText(util.cortarCadenaFloat(jTextFieldYTT
							.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYTT;
	}

	/**
	 * This method initializes jTextFieldXItems
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXItems() {
		if (jTextFieldXItems == null) {
			jTextFieldXItems = new JTextField();
			jTextFieldXItems.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXItems.setText(util
							.cortarCadenaFloat(jTextFieldXItems.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXItems;
	}

	/**
	 * This method initializes jTextFieldYItems
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYItems() {
		if (jTextFieldYItems == null) {
			jTextFieldYItems = new JTextField();
			jTextFieldYItems.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYItems.setText(util
							.cortarCadenaFloat(jTextFieldYItems.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYItems;
	}

	/**
	 * This method initializes jTextFieldXValorT
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXValorT() {
		if (jTextFieldXValorT == null) {
			jTextFieldXValorT = new JTextField();
			jTextFieldXValorT.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXValorT.setText(util
							.cortarCadenaFloat(jTextFieldXValorT.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXValorT;
	}

	/**
	 * This method initializes jTextFieldXValorTrab
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXValorTrab() {
		if (jTextFieldXValorTrab == null) {
			jTextFieldXValorTrab = new JTextField();
			jTextFieldXValorTrab
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldXValorTrab.setText(util
									.cortarCadenaFloat(jTextFieldXValorTrab
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e); // TODO Auto-generated
							// Event stub keyTyped()
						}
					});
		}
		return jTextFieldXValorTrab;
	}

	/**
	 * This method initializes jTextFieldXAbono
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXAbono() {
		if (jTextFieldXAbono == null) {
			jTextFieldXAbono = new JTextField();
			jTextFieldXAbono.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXAbono.setText(util
							.cortarCadenaFloat(jTextFieldXAbono.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXAbono;
	}

	/**
	 * This method initializes jTextFieldXSaldo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXSaldo() {
		if (jTextFieldXSaldo == null) {
			jTextFieldXSaldo = new JTextField();
			jTextFieldXSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXSaldo.setText(util
							.cortarCadenaFloat(jTextFieldXSaldo.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXSaldo;
	}

	/**
	 * This method initializes jTextFieldXObservaciones
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXObservaciones() {
		if (jTextFieldXObservaciones == null) {
			jTextFieldXObservaciones = new JTextField();
			jTextFieldXObservaciones
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldXObservaciones.setText(util
									.cortarCadenaFloat(jTextFieldXObservaciones
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
		}
		return jTextFieldXObservaciones;
	}

	/**
	 * This method initializes jTextFieldYIAbono
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYIAbono() {
		if (jTextFieldYIAbono == null) {
			jTextFieldYIAbono = new JTextField();
			jTextFieldYIAbono.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYIAbono.setText(util
							.cortarCadenaFloat(jTextFieldYIAbono.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYIAbono;
	}

	/**
	 * This method initializes jTextFieldYSaldo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYSaldo() {
		if (jTextFieldYSaldo == null) {
			jTextFieldYSaldo = new JTextField();
			jTextFieldYSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYSaldo.setText(util
							.cortarCadenaFloat(jTextFieldYSaldo.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYSaldo;
	}

	/**
	 * This method initializes jTextFieldYObservaciones
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYObservaciones() {
		if (jTextFieldYObservaciones == null) {
			jTextFieldYObservaciones = new JTextField();
			jTextFieldYObservaciones
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldYObservaciones.setText(util
									.cortarCadenaFloat(jTextFieldYObservaciones
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e);
						}
					});
		}
		return jTextFieldYObservaciones;
	}

	/**
	 * This method initializes jTextFieldTamLetra
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTamLetra() {
		if (jTextFieldTamLetra == null) {
			jTextFieldTamLetra = new JTextField();
			jTextFieldTamLetra.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldTamLetra.setText(util
							.cortarCadenaFloat(jTextFieldTamLetra.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
			});
		}
		return jTextFieldTamLetra;
	}

	/**
	 * This method initializes jPanel232
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel232() {
		if (jPanel232 == null) {
			jLabelUnidad11 = new JLabel();
			jLabelUnidad11.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad11.setText("cm");
			jLabelUnidad11.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad10 = new JLabel();
			jLabelUnidad10.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad10.setText("cm");
			jLabelUnidad10.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad9 = new JLabel();
			jLabelUnidad9.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad9.setText("cm");
			jLabelUnidad9.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad8 = new JLabel();
			jLabelUnidad8.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad8.setText("cm");
			jLabelUnidad8.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad7 = new JLabel();
			jLabelUnidad7.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad7.setText("cm");
			jLabelUnidad7.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad6 = new JLabel();
			jLabelUnidad6.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad6.setText("cm");
			jLabelUnidad6.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad5 = new JLabel();
			jLabelUnidad5.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad5.setText("cm");
			jLabelUnidad5.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad4 = new JLabel();
			jLabelUnidad4.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad4.setText("cm");
			jLabelUnidad4.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad3 = new JLabel();
			jLabelUnidad3.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad3.setText("cm");
			jLabelUnidad3.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad2 = new JLabel();
			jLabelUnidad2.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad2.setText("cm");
			jLabelUnidad2.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad1 = new JLabel();
			jLabelUnidad1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad1.setText("cm");
			jLabelUnidad1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad = new JLabel();
			jLabelUnidad.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad.setText("cm");
			jLabelUnidad.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout232 = new GridLayout();
			gridLayout232.setRows(12);
			gridLayout232.setVgap(10);
			gridLayout232.setHgap(10);
			jPanel232 = new JPanel();
			jPanel232.setLayout(gridLayout232);
			jPanel232.setBounds(new Rectangle(327, 33, 66, 271));
			jPanel232.add(jLabelUnidad, null);
			jPanel232.add(jLabelUnidad1, null);
			jPanel232.add(jLabelUnidad2, null);
			jPanel232.add(jLabelUnidad11, null);
			jPanel232.add(jLabelUnidad10, null);
			jPanel232.add(jLabelUnidad9, null);
			jPanel232.add(jLabelUnidad8, null);
			jPanel232.add(jLabelUnidad7, null);
			jPanel232.add(jLabelUnidad6, null);
			jPanel232.add(jLabelUnidad5, null);
			jPanel232.add(jLabelUnidad4, null);
			jPanel232.add(jLabelUnidad3, null);
		}
		return jPanel232;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(584, 33, 132, 27));
			jButton.setText("Imprimir Prueba");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					imprimir();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(583, 71, 128, 27));
			jButton1.setText("Guardar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					grabarCambios(validar());
				}
			});
		}
		return jButton1;
	}

	/**
	 * Guardar Cambios
	 */
	private String[] validar() {
		Boolean bandera;
		if (jRadioButton.isSelected())
			bandera = true;
		else
			bandera = false;

		String[] arr = {

		jTextFieldXNombre.getText().trim(),
				jTextFieldYNombre1.getText().trim(),

				jTextFieldXFEcha.getText().trim(),
				jTextFieldYFEcha1.getText().trim(),

				jTextFieldXTel.getText().trim(),
				jTextFieldYTel1.getText().trim(),

				jTextFieldXNomArc.getText().trim(),
				jTextFieldYNombArch.getText().trim(),

				jTextFieldXTT.getText().trim(), jTextFieldYTT.getText().trim(),

				jTextFieldXItems.getText().trim(),
				jTextFieldYItems.getText().trim(),

				jTextFieldXValorT.getText().trim(),
				jTextFieldXValorTrab.getText().trim(),

				jTextFieldXAbono.getText().trim(),
				jTextFieldYIAbono.getText().trim(),

				jTextFieldXSaldo.getText().trim(),
				jTextFieldYSaldo.getText().trim(),

				jTextFieldXObservaciones.getText().trim(),
				jTextFieldYObservaciones.getText().trim(),

				jTextFieldTamLetra.getText().trim(), bandera.toString()

		};

		return arr;
	}

	public void grabarCambios(String arr[]) {
		try {

			setContents(new File("bin/ConfigImpresion/odtparam.txt"), arr);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static public void setContents(File aFile, String[] aContents)
			throws FileNotFoundException, IOException {
		if (aFile == null) {
			throw new IllegalArgumentException(
					"El Archivo no debería estar Vacío!.");
		}
		if (!aFile.exists()) {
			throw new FileNotFoundException("El archivo no existe!: " + aFile);
		}
		if (!aFile.isFile()) {
			throw new IllegalArgumentException("Directorio Inválido!: " + aFile);
		}
		if (!aFile.canWrite()) {
			throw new IllegalArgumentException(
					"El archivo esta protegido contra Escritura!: " + aFile);
		}

		// use buffering
		Writer output = new BufferedWriter(new FileWriter(aFile));
		String cadenaTemp = "";
		try {
			int contar = 0;
			while (contar < aContents.length) {
				// FileWriter always assumes default encoding is OK!
				if (aContents[contar].compareTo("") == 0)
					cadenaTemp = cadenaTemp + "0"
							+ System.getProperty("line.separator");
				else
					cadenaTemp = cadenaTemp + aContents[contar]
							+ System.getProperty("line.separator");

				contar++;
			}// while
			output.write(cadenaTemp);
		}

		finally {
			output.close();
		}
	}

	static String[] getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();
		String arr[] = { "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "" };
		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!

			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				int cont = 0;
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					arr[cont] = "" + line;
					// contents.append(line);
					contents.append(System.getProperty("line.separator"));
					cont++;
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return arr;
	}

	private void cargarDatos() {
		String arr[] = getContents(new File("bin/ConfigImpresion/odtparam.txt"));

		jTextFieldXNombre.setText(arr[0]);
		jTextFieldYNombre1.setText(arr[1]);

		jTextFieldXFEcha.setText(arr[2]);
		jTextFieldYFEcha1.setText(arr[3]);

		jTextFieldXTel.setText(arr[4]);
		jTextFieldYTel1.setText(arr[5]);

		jTextFieldXNomArc.setText(arr[6]);
		jTextFieldYNombArch.setText(arr[7]);

		jTextFieldXTT.setText(arr[8]);
		jTextFieldYTT.setText(arr[9]);

		jTextFieldXItems.setText(arr[10]);
		jTextFieldYItems.setText(arr[11]);

		jTextFieldXValorT.setText(arr[12]);
		jTextFieldXValorTrab.setText(arr[13]);

		jTextFieldXAbono.setText(arr[14]);
		jTextFieldYIAbono.setText(arr[15]);

		jTextFieldXSaldo.setText(arr[16]);
		jTextFieldYSaldo.setText(arr[17]);

		jTextFieldXObservaciones.setText(arr[18]);
		jTextFieldYObservaciones.setText(arr[19]);

		jTextFieldTamLetra.setText(arr[20]);
		jRadioButton.setSelected(new Boolean(arr[21]));

	}

	/**
	 * This method initializes jRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
		}
		return jRadioButton;
	}

	/**
	 * imprime Patron de Prueba
	 */
	private void imprimir() {
		impresionOdtParametros pj = new impresionOdtParametros();
		ordenDeTrabajo od = new ordenDeTrabajo(
				1,
				2,
				1000,
				"0000000000",
				"01254585455841544785458745152544878545451212124545787878454541215454858",
				1234, "2009-05-05", "prueba.cdr", "tipo trabajo", 23, 10, 14,
				"Ingresado");
		ordenTrabajoDetalle ordenTrabajoDetalle[] = {
				new ordenTrabajoDetalle(3, "producto de pruebA", 1, 1, 12, 122,
						10),
				new ordenTrabajoDetalle(3, "producto de pruebA 2", 1, 1, 2,
						122, 3),
				new ordenTrabajoDetalle(13, "producto de pruebA 3", 1, 1, 12,
						122, 10) };

		cliente clientedp = new cliente(1, "000000000000", "Consumidor Final",
				"2222222", "", "", "", "");
		int idOrdendeTrabajo;
		try {
			pj.imprimir(od, ordenTrabajoDetalle, clientedp);
			pj.dispose();
		} catch (Exception NoPrint) {
			NoPrint.printStackTrace();
			// JOptionPane.showMessageDialog(null, "Impresión Cancelada ",
			// "Alerta!", JOptionPane.ERROR_MESSAGE);
		}
	}

}
