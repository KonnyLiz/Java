package ventanas;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import reportes.OdtLlenarForm;
import tableUtil.detalleOdtLista;
import tableUtil.modeloOdtLista;
import tableUtil.renderTablaOdt;
import Utilitarios.utilitarios;
import clases.ordenDeTrabajo;
import clasesBdd.conexionBdd;
import clasesBdd.ordenTrabajoBdd;
import javax.swing.JTextArea;
import java.awt.Font;

public class ListaOrdenesTrabajoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private modeloOdtLista modelo = null;
	String User1;
	JDesktopPane JDesktopPanePrin;
	Utilitarios.utilitarios util=new utilitarios();  //  @jve:decl-index=0:
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	ordenTrabajoBdd ordenTrabajoMd = new ordenTrabajoBdd(); // @jve:decl-index=0:
	Object items[][] = ordenTrabajoMd.seleccionarOdtEncabezadosTodos(conn
			.getConexion()); // @jve:decl-index=0:
	int rowTemp = 0;
	int columnTemp = 0;
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldNombre = null;
	private JLabel jLabelEstado = null;
	private JLabel jLabelPrecio = null;
	private JTextField jTextFieldPrecio = null;
	private JTextArea jTextAreaOdt = null;

	/**
	 * This is the default constructor
	 *
	 * /** This is the default constructor
	 */
	public ListaOrdenesTrabajoPanel(String User2, JDesktopPane desktopPane) {
		super();
		initialize();
		JDesktopPanePrin = desktopPane;
		User1 = User2;
		cargarDatos();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(932, 561);
		this.setLayout(null);
		this.add(getJPanel(), null);
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelPrecio = new JLabel();
			jLabelPrecio.setBounds(new Rectangle(32, 37, 63, 20));
			jLabelPrecio.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelPrecio.setText("Precio :");
			jLabelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelEstado = new JLabel();
			jLabelEstado.setBounds(new Rectangle(852, 10, 60, 48));
			jLabelEstado.setForeground(new Color(255, 0, 51));
			jLabelEstado.setText("");
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(31, 10, 63, 23));
			jLabelBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelBuscar.setText("Buscar :");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(0, 41, 929, 506));
			jPanel.add(getJButton(), null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(jLabelBuscar, null);
			jPanel.add(getJTextFieldNombre(), null);
			jPanel.add(jLabelEstado, null);
			jPanel.add(jLabelPrecio, null);
			jPanel.add(getJTextFieldPrecio(), null);
			jPanel.add(getJTextAreaOdt(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(327, 436, 122, 29));
			jButton.setText("Actualizar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						items = ordenTrabajoMd
								.seleccionarOdtEncabezadosTodos(conn
										.getConexion()); // @jve:decl-index=0:
						while (modelo.getRowCount() != 0) {
							for (int i = 0; i < modelo.getRowCount(); i++) {
								modelo.borraItem(i);

							}

						}

					} catch (Exception vacioArreglo) {

					}
					cargarDatos();
					System.out.print("datos cargados");
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 64, 831, 356));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloOdtLista
	 */
	private modeloOdtLista getModelo() {
		if (modelo == null) {
			modelo = new modeloOdtLista();
		}
		return modelo;
	}

	/**
	 * This method initializes jTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(getModelo());
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable.setRowHeight(40);
			// jTable.setRowSelectionAllowed(false);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);

			jTable.getColumnModel().getColumn(0).setPreferredWidth(160);// cliente
			jTable.getColumnModel().getColumn(1).setPreferredWidth(90);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(90);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(90);// total
			jTable.getColumnModel().getColumn(4).setPreferredWidth(90);// abono
			jTable.getColumnModel().getColumn(5).setPreferredWidth(90);// saldo
			jTable.getColumnModel().getColumn(6).setPreferredWidth(160);// entregar
			jTable.getColumnModel().getColumn(7).setPreferredWidth(70);// facturar
			jTable.getColumnModel().getColumn(8).setPreferredWidth(50);// ver

			renderTablaOdt render = new renderTablaOdt();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);
					rowTemp = row;
					columnTemp = column;
					if (modelo.getRowCount() > 0 && column > 05) {
						// System.out.print(column);
						switch (column) {
						case 6:
							int anular=pedirConfirmacionEntregar();
							if(anular==0){
								ordenTrabajoMd.modificarEntregado(conn
										.getConexion(), ""
										+ modelo.getValueAt(row, 9));
								modelo.borraItem(row);
							}



							break;

						case 7:
							ordenDeTrabajo ordenDeTrabajoDp = new ordenDeTrabajo(
									0, 0, 0, "", "", 0, "", "", "", 0, 0, 0, "");
							int idTabla = Integer.parseInt(""
									+ modelo.getValueAt(row, 9));
							ordenDeTrabajoDp = ordenTrabajoMd
									.seleccionarOdtEncabezado(conn
											.getConexion(), idTabla);

							reciboVentana facturaVentanaW = new reciboVentana(
									""
											+ ordenDeTrabajoDp
													.getNumeroOrdenTrabajo(),
									true, null, false, User1, JDesktopPanePrin,
									Float.parseFloat(""
											+ modelo.getValueAt(row, 3)));
							facturaVentanaW.getPreferredSize();
							JDesktopPanePrin.add(facturaVentanaW);
							facturaVentanaW.setVisible(true);
							modelo.borraItem(row);

							break;
						case 8:
							verReporte("" + modelo.getValueAt(row, 9));
							break;

						}// switch
					}// if

				}

			});

		}
		return jTable;
	}

	private void cargarDatos() {
		for (int i = 0; i < items.length; i++) {
			if (items[i][0] != null) {

				detalleOdtLista itemClase = new detalleOdtLista(""
						+ items[i][0], "" + items[i][1], "" + items[i][2],
						Float.parseFloat("" + items[i][3]), Float.parseFloat(""
								+ items[i][4]), Float.parseFloat(""
								+ items[i][5]), new Boolean(true), new Boolean(
								true), new Boolean(true), "" + items[i][6]);

				modelo.nuevoItem(itemClase);

			}
		}

	}

	private void verReporte(String numero) {
		OdtLlenarForm reporteJasper = new OdtLlenarForm();
		int numero2 = Integer.parseInt(numero);
		reporteJasper.recibirDatosExternos(numero2);
		// System.out.print("id:"+ordenDeTrabajoDP.getIdOrdenDeTrabajo());

	}

	/**
	 * This method initializes jTextFieldNombre
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(103, 10, 123, 20));
			jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (jTextFieldNombre.getText().length() > 3) {
						String texto = jTextFieldNombre.getText().trim()
								.toUpperCase();
						if (modelo.getRowCount() != 0) {
							boolean existeEnLista = false;
							String coincidencias = "";
							int contador=0; int contador2Filas=9;
							for (int i = 0; i < modelo.getRowCount(); i++) {
								if (modelo.getValueAt(i, 0).toString()
										.toUpperCase().indexOf(texto) == 0) {
									jTable.setRowSelectionInterval(i, i);
									jTable.findComponentAt(i, 0);
									String espacio="";
									if (contador >contador2Filas){
										 espacio="\n   ";
										 contador=0;
										 contador2Filas=18;
									}
									else
										 espacio=" ";

									coincidencias += " "
											+ modelo.getValueAt(i, 2) +espacio ;
									contador++;
									jTextAreaOdt
											.setText("Encontrado en la lista: ODT#: "
													+ modelo.getValueAt(i, 2)
													+ "   Otras ODT similares Números: "
													+ coincidencias);
									existeEnLista = true;

								} else {
									if (!existeEnLista) {
										jTextAreaOdt
												.setText("No se encontró coincidencias !");

									}

								}

							}
						}
					}
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {

				}
			});
		}
		return jTextFieldNombre;
	}

	int pedirConfirmacionEntregar() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this, "Desea establecer como entregado?.",
				"Confirmar acción", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}
		return res;
	}

	/**
	 * This method initializes jTextFieldPrecio
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPrecio() {
		if (jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setBounds(new Rectangle(103, 37, 94, 20));
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumerosInput(e);
				}
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (jTextFieldPrecio.getText().length() > 1) {
						float texto = Float.parseFloat(jTextFieldPrecio.getText().trim());
						if (modelo.getRowCount() != 0) {
							boolean existeEnLista = false;
							String coincidencias = "";
							int contador=0;int contador2Filas=9;
							for (int i = 0; i < modelo.getRowCount(); i++) {
								if (Float.parseFloat(modelo.getValueAt(i, 4).toString())>=texto ) {
									jTable.setRowSelectionInterval(i, i);
									jTable.findComponentAt(i, 0);
									String espacio="";
									if (contador >contador2Filas){
										 espacio="\n  ";
										 contador=0;
										 contador2Filas=18;
									}
									else
										 espacio=" ";

									coincidencias += " "
											+ modelo.getValueAt(i, 2) +espacio ;
									contador++;
									jTextAreaOdt
											.setText("Encontrado en la lista: ODT#: "
													+ modelo.getValueAt(i, 2)
													+ "   Otras ODT similares Números: "
													+ coincidencias);
									existeEnLista = true;

								} else {
									if (!existeEnLista) {
										jTextAreaOdt
												.setText("No se encontró coincidencias !");

									}

								}

							}
						}
					}
				}
			});
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldPrecio.setText(""
							+ util.cortarCadenaFloat(jTextFieldPrecio.getText()
									.trim()));
				}
			});
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jTextAreaOdt
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaOdt() {
		if (jTextAreaOdt == null) {
			jTextAreaOdt = new JTextArea();
			jTextAreaOdt.setBounds(new Rectangle(242, 7, 599, 52));
			jTextAreaOdt.setFont(new Font("Dialog", Font.BOLD, 12));
			jTextAreaOdt.setRows(5);
			jTextAreaOdt.setForeground(Color.red);
			jTextAreaOdt.setEditable(false);

		}
		return jTextAreaOdt;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
