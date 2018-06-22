package ventanas;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import paneles.listaRecibosPanel;
import reportes.proformaLlenarForm;
import tableUtil.detalleProformaLista;
import tableUtil.modeloProformaLista;
import tableUtil.renderTabla;
import clases.proforma;
import clasesBdd.conexionBdd;
import clasesBdd.proformaBdd;

public class listaProformasVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable jTable = null;
	private modeloProformaLista modelo = null;
	private JScrollPane jScrollPane = null;
	private JButton jButton = null;
	ListaOrdenesTrabajoPanel ListaOrdenesTrabajoPanelP = null;
	listaRecibosPanel listaRecibosPanelP = null;// @jve:decl-index=
	String User1;
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	proformaBdd proformaMd = new proformaBdd(); // @jve:decl-index=0:
	Object items[][] = proformaMd.seleccionarOdtEncabezadosTodos(conn
			.getConexion()); // @jve:decl-index=0:
	int rowTemp = 0;
	int columnTemp = 0;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel = null;
	JDesktopPane desktopPane1;

	/**
	 * This is the default constructor
	 * 
	 * @param desktopPane
	 * @param desktopPane
	 */
	public listaProformasVentana(String User, JDesktopPane desktopPane) {
		// public listaProformasVentana() {
		super();
		User1 = "User";
		desktopPane1 = desktopPane;
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
		this.setSize(919, 605);
		// this.setContentPane(getJContentPane());
		this.setResizable(false);
		ListaOrdenesTrabajoPanelP = new ListaOrdenesTrabajoPanel(User1,
				desktopPane1);
		listaRecibosPanelP = new listaRecibosPanel(desktopPane1);
		this.setContentPane(getJTabbedPane());
		this.setTitle("Consulta de proformas - Ordenes de Trabajo - Facturas");
		actualizar();

	}

	/**
	 * This method initializes modelo
	 * 
	 * @return tableUtil.modeloTabla
	 */
	private modeloProformaLista getModelo() {
		if (modelo == null) {
			modelo = new modeloProformaLista();
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
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(60);// numero
			jTable.getColumnModel().getColumn(1).setPreferredWidth(150);// cliente
			jTable.getColumnModel().getColumn(2).setPreferredWidth(70);// fecha
			jTable.getColumnModel().getColumn(3).setPreferredWidth(90);// subto
			jTable.getColumnModel().getColumn(4).setPreferredWidth(90);// total
			jTable.getColumnModel().getColumn(5).setPreferredWidth(70);// iva
			jTable.getColumnModel().getColumn(6).setPreferredWidth(90);// estado
			jTable.getColumnModel().getColumn(7).setPreferredWidth(130);// verpro
			jTable.getColumnModel().getColumn(8).setPreferredWidth(130);// recibo
			jTable.getColumnModel().getColumn(9).setPreferredWidth(50);// kill
			renderTabla render = new renderTabla();
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
						case 7:
							verReporte("" + modelo.getValueAt(row, 0));

							break;

						case 8:
							if (modelo.getValueAt(row, 6).toString().trim()
									.compareTo("") != 0) {
								int idTabla = Integer.parseInt(""
										+ modelo.getValueAt(row, 0));
								reciboVentana facturaVentanaW = new reciboVentana(
										"", false, "" + idTabla, true, User1,
										desktopPane1, Float.parseFloat(""
												+ modelo.getValueAt(row, 4)));
								facturaVentanaW.getPreferredSize();
								desktopPane1.add(facturaVentanaW);
								facturaVentanaW.setVisible(true);
								modelo.borraItem(row);
							} else {

								JOptionPane.showMessageDialog(null,
										"No se puede modificar este Registro!",
										"Aviso! ",
										JOptionPane.INFORMATION_MESSAGE);
							}

							break;
						case 9:
							int idTabla2 = Integer.parseInt(""
									+ modelo.getValueAt(row, 0));
							proforma proformaDp = new proforma(0, "", "", "",
									0, 0, 0, "");
							proformaDp.setIdProforma(idTabla2);
							proformaBdd proformaMd = new proformaBdd();
							proformaMd.eliminar(conn.getConexion(), proformaDp);
							jButton.doClick();
							break;

						}// switch
					}// if

				}

			});

		}
		return jTable;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(22, 47, 860, 404));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Actualizar");
			jButton.setBounds(new Rectangle(326, 464, 122, 29));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					actualizar();
				}
			});
		}
		return jButton;
	}

	private void actualizar() {
		items = proformaMd.seleccionarOdtEncabezadosTodos(conn.getConexion()); // @jve:decl-index=0:
		limpiarGrilla();
		limpiarGrilla();
		limpiarGrilla();
		for (int i = 0; i < items.length; i++) {
			if (items[i][0] != null) {

				detalleProformaLista itemClase = new detalleProformaLista(""
						+ items[i][0], "" + items[i][1], "" + items[i][2], ""
						+ items[i][3], "" + items[i][4], "" + items[i][5], ""
						+ items[i][6], new Boolean(true), new Boolean(true),
						new Boolean(true)

				);

				modelo.nuevoItem(itemClase);

			}
		}

	}

	private void verReporte(String numero) {
		proformaLlenarForm reporteJasper = new proformaLlenarForm();
		int numeroProforma = Integer.parseInt(numero);
		reporteJasper.recibirDatosExternos(numeroProforma);

	}

	/**
	 * This method initializes jTabbedPane
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Proformas", null, getJPanel(), null);
			jTabbedPane.addTab("Ordenes De Trabajo", null,
					ListaOrdenesTrabajoPanelP, null);
			jTabbedPane.addTab("Recibos de Venta", null, listaRecibosPanelP,
					null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			// jPanel.add(Administraciónproveedor, null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(getJButton(), null);
		}
		return jPanel;
	}

	public void limpiarGrilla() {
		try {
			do {
				for (int i = 0; i < modelo.getColumnCount(); i++) {
					modelo.borraItem(i);
				}
			} while (modelo.getRowCount() != 0);
		} catch (Exception FilasNull) {

		}
	}

} // @jve:decl-index=0:visual-constraint="41,10"
