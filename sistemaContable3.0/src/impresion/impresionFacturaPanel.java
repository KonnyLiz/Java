package impresion;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Utilitarios.utilitarios;
import clases.cliente;
import clases.proforma;
import clases.proformaDetalle;

public class impresionFacturaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel23 = null;
	private JLabel jLabelNombre = null;
	private JLabel jLabelBiuscar141 = null;
	private JLabel jLabelTelefono = null;
	private JLabel jLabelTelefono1 = null;
	private JLabel jLabelTelefono111 = null;
	private JLabel jLabelValorT = null;
	private JLabel jLabelAbono = null;
	private JLabel jLabelPrecio = null;
	private JLabel jLabelTelefono11111 = null;
	private JLabel jLabelTelefono111111 = null;
	private JLabel jLabelTelefono1111111 = null;
	private JPanel jPanel231 = null;
	private JTextField jTextFieldXNombre = null;
	private JTextField jTextFieldXFEcha = null;
	private JTextField jTextFieldXTel = null;
	private JTextField jTextFieldDireccion = null;
	private JTextField jTextFieldXItems = null;
	private JTextField jTextFieldXSubtotalTX = null;
	private JTextField jTextFieldXIva0 = null;
	private JTextField jTextFieldXIva12 = null;
	private JTextField jTextFieldXTotal = null;
	private JTextField jTextFieldTamLetra = null;
	private JRadioButton jRadioButton = null;
	private JPanel jPanel2311 = null;
	private JTextField jTextFieldYNombre1 = null;
	private JTextField jTextFieldYFEcha1 = null;
	private JTextField jTextFieldYTel1 = null;
	private JTextField jTextFieldYDireccion = null;
	private JTextField jTextFieldYItems = null;
	private JTextField jTextFieldXSubtotalTY = null;
	private JTextField jTextFieldYIva0 = null;
	private JTextField jTextFieldYIva12 = null;
	private JTextField jTextFieldYTotal = null;
	private JPanel jPanel232 = null;
	private JLabel jLabelUnidad = null;
	private JLabel jLabelUnidad1 = null;
	private JLabel jLabelUnidad11 = null;
	private JLabel jLabelUnidad10 = null;
	private JLabel jLabelUnidad9 = null;
	private JLabel jLabelUnidad8 = null;
	private JLabel jLabelUnidad7 = null;
	private JLabel jLabelUnidad6 = null;
	private JLabel jLabelUnidad5 = null;
	private JButton jButton1 = null;
	private JButton jButton = null;
	private JLabel jLabelNombre1 = null;
	private JLabel jLabelNombre11 = null;
	private JPanel jPanel23111 = null;
	private JTextField jTextFieldCantidad = null;
	private JTextField jTextFieldYDetalle = null;
	private JTextField jTextFieldVUnitario = null;
	private JTextField jTextFieldVTotal = null;
	private JLabel jLabelNombre12 = null;
	private JLabel jLabelUnidad91 = null;
	private JLabel jLabelNombre2 = null;
	private JTextField jTextFieldXCiRUC = null;
	private JTextField jTextFieldYCiRUC1 = null;
	private JLabel jLabelUnidad51 = null;
	utilitarios util = new utilitarios();

	/**
	 * This is the default constructor
	 */
	public impresionFacturaPanel() {
		super();
		initialize();
		cargarDatos();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabelNombre12 = new JLabel();
		jLabelNombre12.setBounds(new Rectangle(409, 119, 291, 24));
		jLabelNombre12.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelNombre12
				.setText("  Cantidad           Detalle          V. Unitario         V. Total");
		jLabelNombre12.setHorizontalAlignment(SwingConstants.LEFT);
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
		this.setSize(767, 392);
		this.setLayout(null);
		this.add(getJPanel23(), null);
		this.add(getJPanel231(), null);
		this.add(getJPanel2311(), null);
		this.add(getJPanel232(), null);
		this.add(getJButton1(), null);
		this.add(getJButton(), null);
		this.add(jLabelNombre1, null);
		this.add(jLabelNombre11, null);
		this.add(getJPanel23111(), null);
		this.add(jLabelNombre12, null);
		this.add(jLabelUnidad91, null);
	}

	/**
	 * This method initializes jPanel23
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jLabelNombre2 = new JLabel();
			jLabelNombre2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNombre2.setText("Ruc/Ci :");
			jLabelNombre2.setHorizontalTextPosition(SwingConstants.RIGHT);
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
			jLabelTelefono11111.setText("Total :");
			jLabelTelefono11111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPrecio = new JLabel();
			jLabelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPrecio.setText("IVA 12% :");
			jLabelPrecio.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelAbono = new JLabel();
			jLabelAbono.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelAbono.setText("IVA % :");
			jLabelAbono.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelValorT = new JLabel();
			jLabelValorT.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelValorT.setText("Subtotal :");
			jLabelValorT.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono111 = new JLabel();
			jLabelTelefono111.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono111.setText("Items :");
			jLabelTelefono111.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTelefono1 = new JLabel();
			jLabelTelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTelefono1.setText("Dirección :");
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
			jPanel23.add(jLabelBiuscar141, null);
			jPanel23.add(jLabelNombre, null);
			jPanel23.add(jLabelNombre2, null);
			jPanel23.add(jLabelTelefono, null);
			jPanel23.add(jLabelTelefono1, null);
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
			jPanel231.add(getJTextFieldXFEcha(), null);
			jPanel231.add(getJTextFieldXNombre(), null);
			jPanel231.add(getJTextFieldXCiRUC(), null);
			jPanel231.add(getJTextFieldXTel(), null);
			jPanel231.add(getJTextFieldDireccion(), null);
			jPanel231.add(getJTextFieldXItems(), null);
			jPanel231.add(getJTextFieldXSubtotalTX(), null);
			jPanel231.add(getJTextFieldXIva0(), null);
			jPanel231.add(getJTextFieldXIva12(), null);
			jPanel231.add(getJTextFieldXTotal(), null);
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
			jTextFieldXNombre.addKeyListener(new java.awt.event.KeyAdapter() {
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
		return jTextFieldXNombre;
	}

	/**
	 * This method initializes jTextFieldXFEcha
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXFEcha() {
		if (jTextFieldXFEcha == null) {
			jTextFieldXFEcha = new JTextField();
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
	 * This method initializes jTextFieldDireccion
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDireccion() {
		if (jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldDireccion.setText(util
							.cortarCadenaFloat(jTextFieldDireccion.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldDireccion;
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
	 * This method initializes jTextFieldXSubtotalTX
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXSubtotalTX() {
		if (jTextFieldXSubtotalTX == null) {
			jTextFieldXSubtotalTX = new JTextField();
			jTextFieldXSubtotalTX
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldXSubtotalTX.setText(util
									.cortarCadenaFloat(jTextFieldXSubtotalTX
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e); // TODO Auto-generated
							// Event stub keyTyped()
						}
					});
		}
		return jTextFieldXSubtotalTX;
	}

	/**
	 * This method initializes jTextFieldXIva0
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXIva0() {
		if (jTextFieldXIva0 == null) {
			jTextFieldXIva0 = new JTextField();
			jTextFieldXIva0.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXIva0
							.setText(util.cortarCadenaFloat(jTextFieldXIva0
									.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXIva0;
	}

	/**
	 * This method initializes jTextFieldXIva12
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXIva12() {
		if (jTextFieldXIva12 == null) {
			jTextFieldXIva12 = new JTextField();
			jTextFieldXIva12.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXIva12.setText(util
							.cortarCadenaFloat(jTextFieldXIva12.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXIva12;
	}

	/**
	 * This method initializes jTextFieldXTotal
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXTotal() {
		if (jTextFieldXTotal == null) {
			jTextFieldXTotal = new JTextField();
			jTextFieldXTotal.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXTotal.setText(util
							.cortarCadenaFloat(jTextFieldXTotal.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXTotal;
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
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldTamLetra;
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
			jPanel2311.add(getJTextFieldYFEcha1(), null);
			jPanel2311.add(getJTextFieldYNombre1(), null);
			jPanel2311.add(getJTextFieldYCiRUC1(), null);
			jPanel2311.add(getJTextFieldYTel1(), null);
			jPanel2311.add(getJTextFieldYDireccion(), null);
			jPanel2311.add(getJTextFieldYItems(), null);
			jPanel2311.add(getJTextFieldXSubtotalTY(), null);
			jPanel2311.add(getJTextFieldYIva0(), null);
			jPanel2311.add(getJTextFieldYIva12(), null);
			jPanel2311.add(getJTextFieldYTotal(), null);
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
			jTextFieldYNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYNombre1.setText(util
							.cortarCadenaFloat(jTextFieldYNombre1.getText()
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
	 * This method initializes jTextFieldYDireccion
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYDireccion() {
		if (jTextFieldYDireccion == null) {
			jTextFieldYDireccion = new JTextField();
			jTextFieldYDireccion
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldYDireccion.setText(util
									.cortarCadenaFloat(jTextFieldYDireccion
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e); // TODO Auto-generated
							// Event stub keyTyped()
						}
					});
		}
		return jTextFieldYDireccion;
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
	 * This method initializes jTextFieldXSubtotalTY
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXSubtotalTY() {
		if (jTextFieldXSubtotalTY == null) {
			jTextFieldXSubtotalTY = new JTextField();
			jTextFieldXSubtotalTY
					.addKeyListener(new java.awt.event.KeyAdapter() {
						@Override
						public void keyReleased(java.awt.event.KeyEvent e) {
							jTextFieldXSubtotalTY.setText(util
									.cortarCadenaFloat(jTextFieldXSubtotalTY
											.getText().trim()));
						}

						@Override
						public void keyTyped(java.awt.event.KeyEvent e) {
							util.soloNumerosInput(e); // TODO Auto-generated
							// Event stub keyTyped()
						}
					});
		}
		return jTextFieldXSubtotalTY;
	}

	/**
	 * This method initializes jTextFieldYIva0
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYIva0() {
		if (jTextFieldYIva0 == null) {
			jTextFieldYIva0 = new JTextField();
			jTextFieldXIva0.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXIva0
							.setText(util.cortarCadenaFloat(jTextFieldXIva0
									.getText().trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYIva0;
	}

	/**
	 * This method initializes jTextFieldYIva12
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYIva12() {
		if (jTextFieldYIva12 == null) {
			jTextFieldYIva12 = new JTextField();
			jTextFieldYIva12.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXIva12.setText(util
							.cortarCadenaFloat(jTextFieldXIva12.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYIva12;
	}

	/**
	 * This method initializes jTextFieldYTotal
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYTotal() {
		if (jTextFieldYTotal == null) {
			jTextFieldYTotal = new JTextField();
			jTextFieldXTotal.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXTotal.setText(util
							.cortarCadenaFloat(jTextFieldXTotal.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYTotal;
	}

	/**
	 * This method initializes jPanel232
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel232() {
		if (jPanel232 == null) {
			jLabelUnidad51 = new JLabel();
			jLabelUnidad51.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad51.setText("cm");
			jLabelUnidad51.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad91 = new JLabel();
			jLabelUnidad91.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad91.setText("cm");
			jLabelUnidad91.setBounds(new Rectangle(712, 150, 28, 18));
			jLabelUnidad91.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad5 = new JLabel();
			jLabelUnidad5.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad5.setText("cm");
			jLabelUnidad5.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad6 = new JLabel();
			jLabelUnidad6.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad6.setText("cm");
			jLabelUnidad6.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad7 = new JLabel();
			jLabelUnidad7.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad7.setText("cm");
			jLabelUnidad7.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad8 = new JLabel();
			jLabelUnidad8.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad8.setText("cm");
			jLabelUnidad8.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad9 = new JLabel();
			jLabelUnidad9.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad9.setText("cm");
			jLabelUnidad9.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad10 = new JLabel();
			jLabelUnidad10.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad10.setText("cm");
			jLabelUnidad10.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad11 = new JLabel();
			jLabelUnidad11.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad11.setText("cm");
			jLabelUnidad11.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad1 = new JLabel();
			jLabelUnidad1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad1.setText("cm");
			jLabelUnidad1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelUnidad = new JLabel();
			jLabelUnidad.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUnidad.setText("cm");
			jLabelUnidad.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridLayout gridLayout232 = new GridLayout();
			gridLayout232.setRows(10);
			gridLayout232.setVgap(10);
			gridLayout232.setHgap(10);
			jPanel232 = new JPanel();
			jPanel232.setLayout(gridLayout232);
			jPanel232.setBounds(new Rectangle(325, 33, 66, 276));
			jPanel232.add(jLabelUnidad, null);
			jPanel232.add(jLabelUnidad1, null);
			jPanel232.add(jLabelUnidad11, null);
			jPanel232.add(jLabelUnidad10, null);
			jPanel232.add(jLabelUnidad9, null);
			jPanel232.add(jLabelUnidad8, null);
			jPanel232.add(jLabelUnidad7, null);
			jPanel232.add(jLabelUnidad6, null);
			jPanel232.add(jLabelUnidad5, null);
			jPanel232.add(jLabelUnidad51, null);
		}
		return jPanel232;
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
	 * This method initializes jPanel23111
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23111() {
		if (jPanel23111 == null) {
			GridLayout gridLayout23111 = new GridLayout();
			gridLayout23111.setRows(1);
			gridLayout23111.setVgap(10);
			gridLayout23111.setColumns(4);
			gridLayout23111.setHgap(10);
			jPanel23111 = new JPanel();
			jPanel23111.setLayout(gridLayout23111);
			jPanel23111.setBounds(new Rectangle(413, 148, 290, 21));
			jPanel23111.add(getJTextFieldCantidad(), null);
			jPanel23111.add(getJTextFieldYDetalle(), null);
			jPanel23111.add(getJTextFieldVUnitario(), null);
			jPanel23111.add(getJTextFieldVTotal(), null);
		}
		return jPanel23111;
	}

	/**
	 * This method initializes jTextFieldCantidad
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCantidad.setText(util
							.cortarCadenaFloat(jTextFieldCantidad.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});

		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes jTextFieldYDetalle
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYDetalle() {
		if (jTextFieldYDetalle == null) {
			jTextFieldYDetalle = new JTextField();
			jTextFieldYDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYDetalle.setText(util
							.cortarCadenaFloat(jTextFieldYDetalle.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYDetalle;
	}

	/**
	 * This method initializes jTextFieldVUnitario
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldVUnitario() {
		if (jTextFieldVUnitario == null) {
			jTextFieldVUnitario = new JTextField();
			jTextFieldVUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldVUnitario.setText(util
							.cortarCadenaFloat(jTextFieldVUnitario.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldVUnitario;
	}

	/**
	 * This method initializes jTextFieldVTotal
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldVTotal() {
		if (jTextFieldVTotal == null) {
			jTextFieldVTotal = new JTextField();
			jTextFieldVTotal.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldVTotal.setText(util
							.cortarCadenaFloat(jTextFieldVTotal.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldVTotal;
	}

	/**
	 * This method initializes jTextFieldXCiRUC
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldXCiRUC() {
		if (jTextFieldXCiRUC == null) {
			jTextFieldXCiRUC = new JTextField();
			jTextFieldXCiRUC.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldXCiRUC.setText(util
							.cortarCadenaFloat(jTextFieldXCiRUC.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldXCiRUC;
	}

	/**
	 * This method initializes jTextFieldYCiRUC1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldYCiRUC1() {
		if (jTextFieldYCiRUC1 == null) {
			jTextFieldYCiRUC1 = new JTextField();
			jTextFieldYCiRUC1.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldYCiRUC1.setText(util
							.cortarCadenaFloat(jTextFieldYCiRUC1.getText()
									.trim()));
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e); // TODO Auto-generated Event
					// stub keyTyped()
				}
			});
		}
		return jTextFieldYCiRUC1;
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

		jTextFieldXFEcha.getText().trim(), jTextFieldYFEcha1.getText().trim(),

		jTextFieldXNombre.getText().trim(),
				jTextFieldYNombre1.getText().trim(),

				jTextFieldXCiRUC.getText().trim(),
				jTextFieldYCiRUC1.getText().trim(),

				jTextFieldXTel.getText().trim(),
				jTextFieldYTel1.getText().trim(),

				jTextFieldDireccion.getText().trim(),
				jTextFieldYDireccion.getText().trim(),

				jTextFieldXItems.getText().trim(),
				jTextFieldYItems.getText().trim(),

				jTextFieldXSubtotalTX.getText().trim(),
				jTextFieldXSubtotalTY.getText().trim(),

				jTextFieldXIva0.getText().trim(),
				jTextFieldYIva0.getText().trim(),

				jTextFieldXIva12.getText().trim(),
				jTextFieldYIva12.getText().trim(),

				jTextFieldXTotal.getText().trim(),
				jTextFieldYTotal.getText().trim(),

				jTextFieldCantidad.getText().trim(),
				jTextFieldYDetalle.getText().trim(),
				jTextFieldVUnitario.getText().trim(),
				jTextFieldVTotal.getText().trim(),

				jTextFieldTamLetra.getText().trim(), bandera.toString()

		};

		return arr;
	}

	public void grabarCambios(String arr[]) {
		try {

			setContents(new File("bin/ConfigImpresion/facturaparam.txt"), arr);

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
	}// set content

	static String[] getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();
		String arr[] = { "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "" };
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
		String arr[] = getContents(new File(
				"bin/ConfigImpresion/facturaparam.txt"));

		jTextFieldXFEcha.setText(arr[0]);
		jTextFieldYFEcha1.setText("" + arr[1]);

		jTextFieldXNombre.setText(arr[2]);
		jTextFieldYNombre1.setText(arr[3]);

		jTextFieldXCiRUC.setText(arr[4]);
		jTextFieldYCiRUC1.setText(arr[5]);

		jTextFieldXTel.setText(arr[6]);
		jTextFieldYTel1.setText(arr[7]);

		jTextFieldDireccion.setText(arr[8]);
		jTextFieldYDireccion.setText(arr[9]);

		jTextFieldXItems.setText(arr[10]);
		jTextFieldYItems.setText(arr[11]);

		jTextFieldXSubtotalTX.setText(arr[12]);
		jTextFieldXSubtotalTY.setText(arr[13]);

		jTextFieldXIva0.setText(arr[14]);
		jTextFieldYIva0.setText(arr[15]);

		jTextFieldXIva12.setText(arr[16]);
		jTextFieldYIva12.setText(arr[17]);

		jTextFieldXTotal.setText(arr[18]);
		jTextFieldYTotal.setText(arr[19]);

		jTextFieldCantidad.setText(arr[20]);
		jTextFieldYDetalle.setText(arr[21]);
		jTextFieldVUnitario.setText(arr[22]);
		jTextFieldVTotal.setText(arr[23]);

		jTextFieldTamLetra.setText(arr[24]);
		jRadioButton.setSelected(new Boolean(arr[25]));

	}

	/**
	 * imprime Patron de Prueba
	 */
	private void imprimir() {
		impresionFacturaParametros pj = new impresionFacturaParametros();
		proforma proformaDp = new proforma(1, "00000000000", "2009-01-01",
				"Quito", 10, 12, 2, "Prueba Estado");
		proformaDetalle proformaDetalleDp[] = {
				new proformaDetalle(3, 1, 8, "producto de pruebA", 12, 13, 10,
						80),
				new proformaDetalle(3, 1, 1, "producto de pruebA 2", 12, 13,
						10, 10),
				new proformaDetalle(3, 1, 2, "producto de pruebA 3", 12, 13,
						10, 20) };
		cliente clientedp = new cliente(1, "000000000000", "Consumidor Final",
				"2222222", "123123", "Direccion calle s/n", "123123", "123123");
		int idOrdendeTrabajo;
		try {
			pj.imprimir(proformaDp, proformaDetalleDp, clientedp);
			pj.dispose();
		} catch (Exception NoPrint) {
			NoPrint.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impresión Cancelada ",
					"Alerta!", JOptionPane.ERROR_MESSAGE);
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
