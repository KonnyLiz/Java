package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import tableUtil.detalleProductosInventario;
import tableUtil.modeloProducto;
import tableUtil.renderProductoLista;
import clasesBdd.conexionBdd;
import clasesBdd.inventarioBdd;
import clasesBdd.tipoProductoBdd;

public class listaInventarioVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private modeloProducto modelo = null; // @jve:decl-index=0:
	private JScrollPane jScrollPane = null;
	private JButton jButton = null;
	private JLabel Administraciónproveedor = null;
	String User1;
	String rol;
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	inventarioBdd inventarioMd = new inventarioBdd(); // @jve:decl-index=0:
	Object items[][] = inventarioMd.seleccionarProductos(conn.getConexion()); // @jve:decl-index=0:
	int rowTemp = 0;
	int columnTemp = 0;
	private JLabel Administraciónproveedor1 = null;
	private JComboBox ChoiceTipoProducto = null;
	tipoProductoBdd tipoProductoMd = new tipoProductoBdd();
	private JButton jButton1 = null;
	JDesktopPane JDesktopPanePrin;

	/**
	 * This is the default constructor
	 */
	public listaInventarioVentana(String User, String rol1,
			JDesktopPane JDesktopPanePrin1) {
		// public listaInventarioVentana() {
		super();
		User1 = User;
		JDesktopPanePrin = JDesktopPanePrin1;
		rol = rol1;
		initialize();
		cargarDatos();

		this.setClosable(true);
		this.setIconifiable(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(667, 492);
		this.setContentPane(getJContentPane());
		this.setTitle("Administrar Ordenes de productos por Lista");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administraciónproveedor1 = new JLabel();
			Administraciónproveedor1.setBounds(new Rectangle(2, 44, 172, 22));
			Administraciónproveedor1.setForeground(Color.blue);
			Administraciónproveedor1
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor1.setText("Tipos de Producto :");
			Administraciónproveedor1.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-1, 9, 660, 20));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor
					.setText("Administración de productos  por lista");
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(Administraciónproveedor, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(Administraciónproveedor1, null);
			jContentPane.add(getChoiceTipoProducto(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modelo
	 * 
	 * @return tableUtil.modeloTabla
	 */
	private modeloProducto getModelo() {
		if (modelo == null) {
			modelo = new modeloProducto();
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

			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);
					rowTemp = row;
					columnTemp = column;

					if (modelo.getRowCount() > 0) {

						if (columnTemp == 5) {
							if (rol.compareToIgnoreCase("ADMIN") == 0) {
								inventarioVentana inventarioVentanaW = new inventarioVentana(
										User1, new Boolean(true),
										(String) modelo.getValueAt(rowTemp, 1),
										JDesktopPanePrin);
								inventarioVentanaW.getPreferredSize();
								JDesktopPanePrin.add(inventarioVentanaW);
								inventarioVentanaW.setVisible(true);
							} else {
								JOptionPane
										.showMessageDialog(
												null,
												"No se puede mostar esta información por privilegios de usuario! ",
												"Aviso!",
												JOptionPane.INFORMATION_MESSAGE);

							}

						}
					}// if
				}
			});
			jTable.getColumnModel().getColumn(0).setPreferredWidth(140);// cliente
			jTable.getColumnModel().getColumn(1).setPreferredWidth(90);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(120);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(80);// total
			jTable.getColumnModel().getColumn(4).setPreferredWidth(100);// ver
			jTable.getColumnModel().getColumn(5).setPreferredWidth(60);// ver
			renderProductoLista render = new renderProductoLista();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);

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
			jScrollPane.setBounds(new Rectangle(34, 101, 585, 311));
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
			jButton.setBounds(new Rectangle(280, 422, 122, 29));
			jButton.setText("Actualizar");
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
				detalleProductosInventario itemClase = new detalleProductosInventario(
						items[i][0].toString(), items[i][1].toString(),
						items[i][2].toString(), items[i][3].toString(),
						items[i][4].toString(), new Boolean(true)

				);
				if (items[i][0].toString().compareTo(
						"" + ChoiceTipoProducto.getSelectedItem()) == 0)
					modelo.nuevoItem(itemClase);

			}
		}
	}

	private void actualizar() {
		// listaInventarioVentana ordenDeTrabajoListaVentanaW=new
		// listaInventarioVentana(User1);
		listaInventarioVentana ordenDeTrabajoListaVentanaW = new listaInventarioVentana(
				User1, rol, JDesktopPanePrin);
		ordenDeTrabajoListaVentanaW.getPreferredSize();
		JDesktopPanePrin.add(ordenDeTrabajoListaVentanaW);
		this.dispose();
		ordenDeTrabajoListaVentanaW.setVisible(true);

	}

	/**
	 * This method initializes ChoiceTipoProducto
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getChoiceTipoProducto() {
		if (ChoiceTipoProducto == null) {
			ChoiceTipoProducto = new JComboBox();
			ChoiceTipoProducto.setBounds(new Rectangle(179, 44, 165, 21));
			cargarChoiceTipoProducto();
		}
		return ChoiceTipoProducto;
	}

	/**
	 * Choice Tipo de producto
	 */
	private void cargarChoiceTipoProducto() {

		Object descripciones[] = tipoProductoMd
				.seleccionarDescripcionesTabla(conn.getConexion());
		for (int i = 0; i < descripciones.length; i++) {
			ChoiceTipoProducto.addItem(descripciones[i]);
		}
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(353, 43, 80, 23));
			jButton1.setText("Mostrar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					borrarTabla();
					borrarTabla();
					borrarTabla();
					borrarTabla();
					borrarTabla();
					borrarTabla();
					cargarDatos();
				}
			});
		}
		return jButton1;
	}

	/**
	 * borra la tabla
	 */
	private void borrarTabla() {
		try {
			int cont = 0;
			while (modelo.getRowCount() != 0) {
				modelo.borraItem(cont);
				cont++;
			}

		} catch (Exception fueraDeLimite) {
			int cont = 0;
		}

	}

} // @jve:decl-index=0:visual-constraint="10,10"
