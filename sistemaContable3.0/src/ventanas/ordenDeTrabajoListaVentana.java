package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
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
import tableUtil.renderTabla;
import clases.ordenDeTrabajo;
import clasesBdd.conexionBdd;
import clasesBdd.ordenTrabajoBdd;

public class ordenDeTrabajoListaVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private modeloOdtLista modelo = null;
	private JScrollPane jScrollPane = null;
	private JButton jButton = null;
	private JLabel Administraciónproveedor = null;
	String User1;
	JDesktopPane JDesktopPanePrin;
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	ordenTrabajoBdd ordenTrabajoMd = new ordenTrabajoBdd(); // @jve:decl-index=0:
	Object items[][] = ordenTrabajoMd.seleccionarOdtEncabezadosTodos(conn
			.getConexion()); // @jve:decl-index=0:
	int rowTemp = 0;
	int columnTemp = 0;
	private JPanel jPanel = null; // @jve:decl-index=0:visual-constraint="-7,584"
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldNombre = null;

	/**
	 * This is the default constructor
	 */
	public ordenDeTrabajoListaVentana(String User,
			JDesktopPane JDesktopPanePrin1) {
		// public ordenDeTrabajoListaVentana() {
		super();
		User1 = User;
		JDesktopPanePrin = JDesktopPanePrin1;
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
		this.setSize(950, 524);
		// this.setContentPane(getJContentPane());
		// this.setTitle("Administrar Ordenes de trabajo por Lista");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor
					.setText("Administración de Ordenes de Trabajo por lista");
			Administraciónproveedor.setBounds(new Rectangle(2, 17, 938, 20));
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloTabla
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
						case 6:
							int anular=pedirConfirmacionEntregar();
							if(anular==0){
							ordenTrabajoMd.modificarEntregado(conn
									.getConexion(), ""
									+ modelo.getValueAt(row, 9));
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
									new Float(0));
							facturaVentanaW.getPreferredSize();
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

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(19, 115, 894, 339));
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
			jButton.setBounds(new Rectangle(392, 470, 122, 29));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					actualizar();
				}
			});
		}
		return jButton;
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

	private void actualizar() {
		ordenDeTrabajoListaVentana ordenDeTrabajoListaVentanaW = new ordenDeTrabajoListaVentana(
				User1, JDesktopPanePrin);
		ordenDeTrabajoListaVentanaW.getPreferredSize();
		ordenDeTrabajoListaVentanaW.setVisible(true);

	}

	private void verReporte(String numero) {
		OdtLlenarForm reporteJasper = new OdtLlenarForm();
		int numero2 = Integer.parseInt(numero);
		reporteJasper.recibirDatosExternos(numero2);
		// System.out.print("id:"+ordenDeTrabajoDP.getIdOrdenDeTrabajo());

	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(32, 44, 55, 23));
			jLabelBuscar.setText("Buscar :");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setSize(new Dimension(932, 526));
			jPanel.add(getJButton(), null);
			jPanel.add(Administraciónproveedor, null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(jLabelBuscar, null);
			jPanel.add(getJTextFieldNombre(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextFieldNombre
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(94, 48, 137, 22));
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
} // @jve:decl-index=0:visual-constraint="10,10"
