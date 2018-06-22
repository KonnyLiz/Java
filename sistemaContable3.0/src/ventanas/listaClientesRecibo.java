package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import tableUtil.modeloCliente;
import tableUtil.renderCliente;
import Utilitarios.utilitarios;
import clases.arregloClientesListaTempHash;
import clasesBdd.clientesBdd;
import clasesBdd.conexionBdd;
import clasesBdd.tipoProductoBdd;

public class listaClientesRecibo extends JDialog {
	// public class listaClientesVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private modeloCliente modelo = null; // @jve:decl-index=0:
	private JScrollPane jScrollPane = null;
	private JLabel Administraciónproveedor = null;
	String User1;
	String rol;
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	clientesBdd clienteMd = new clientesBdd(); // @jve:decl-index=0:

	int rowTemp = 0;
	int columnTemp = 0;
	private JLabel Administraciónproveedor1 = null;
	tipoProductoBdd tipoProductoMd = new tipoProductoBdd();
	JDesktopPane JDesktopPanePrin;
	private JTextField jTextFieldRuc = null;
	private JPanel jPanelContenedor1 = null;
	private JTextField jTextFieldCliente = null;
	utilitarios util = new utilitarios(); // @jve:decl-index=0:
	private JLabel Administraciónproveedor11 = null;

	/**
	 *
	 * This is the default constructor
	 */
	public listaClientesRecibo() {
		// public listaInventarioVentana() {
		super();

		initialize();

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(639, 375);
		this.setContentPane(getJContentPane());
		this.setTitle("Lista de Clientes");

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				cerrar();
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
			Administraciónproveedor11 = new JLabel();
			Administraciónproveedor11.setBounds(new Rectangle(29, 76, 184, 22));
			Administraciónproveedor11.setForeground(Color.blue);
			Administraciónproveedor11
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor11.setText("Nombre :");
			Administraciónproveedor11
					.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor1 = new JLabel();
			Administraciónproveedor1.setForeground(Color.blue);
			Administraciónproveedor1
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor1.setText("R.U.C :");
			Administraciónproveedor1.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-1, 9, 660, 20));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor.setText("Lista de Clientes");
			Administraciónproveedor.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(Administraciónproveedor, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJPanelContenedor1(), null);

			jContentPane.add(getJTextFieldCliente(), null);
			jContentPane.add(Administraciónproveedor11, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloTabla
	 */
	private modeloCliente getModelo() {
		if (modelo == null) {
			modelo = new modeloCliente();
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
						String dato = modelo.getValueAt(rowTemp, 0).toString()
								.trim();
						if (dato.compareToIgnoreCase("no hay registros") != 0) {
							String ruc = modelo.getValueAt(rowTemp, 2)
									.toString().trim();
							jTextFieldRuc.setText(""
									+ modelo.getValueAt(row, 2));
							jTextFieldCliente.setText(""
									+ modelo.getValueAt(row, 1));

						} else {
							if (dato.compareToIgnoreCase("no hay registros") == 0)
								JOptionPane.showMessageDialog(null,
										"Registro Inválido!", "Alerta!",
										JOptionPane.INFORMATION_MESSAGE);
						}
					}// if
				}
			});
			jTable.getColumnModel().getColumn(0).setPreferredWidth(200);// cliente
			jTable.getColumnModel().getColumn(1).setPreferredWidth(200);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(120);// numero
			jTable.getColumnModel().getColumn(3).setPreferredWidth(190);// total
			jTable.getColumnModel().getColumn(4).setPreferredWidth(45);// ver

			renderCliente render = new renderCliente();
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
			jScrollPane.setBounds(new Rectangle(31, 120, 585, 191));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

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

	/**
	 * This method initializes jTextFieldRuc
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRuc() {
		if (jTextFieldRuc == null) {
			jTextFieldRuc = new JTextField();
			jTextFieldRuc.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldRuc.setText(util.cortarCadenaString(jTextFieldRuc
							.getText().trim(), 13));
					if (jTextFieldRuc.getText().length() > 2)
						buscar(jTextFieldRuc.getText().toString());

				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					util.soloNumeros(e);
				}
			});

			jTextFieldRuc.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusGained(java.awt.event.FocusEvent e) {
					jTextFieldRuc.selectAll();
				}
			});
			jTextFieldRuc.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jContentPane
							.addKeyListener(new java.awt.event.KeyAdapter() {
								@Override
								public void keyPressed(java.awt.event.KeyEvent e) {
									char c = e.getKeyChar();
									if (c == KeyEvent.VK_ESCAPE)
										cerrar();
								}
							});

				}
			});
		}
		return jTextFieldRuc;
	}

	/**
	 * This method initializes jPanelContenedor1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelContenedor1() {
		if (jPanelContenedor1 == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(20);
			gridLayout.setVgap(20);
			gridLayout.setColumns(2);
			jPanelContenedor1 = new JPanel();
			jPanelContenedor1.setLayout(gridLayout);
			jPanelContenedor1.setBounds(new Rectangle(29, 40, 391, 23));
			jPanelContenedor1.add(Administraciónproveedor1, null);
			jPanelContenedor1.add(getJTextFieldRuc(), null);
		}
		return jPanelContenedor1;
	}

	/**
	 * This method initializes jTextFieldCliente
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCliente() {
		if (jTextFieldCliente == null) {
			jTextFieldCliente = new JTextField();
			jTextFieldCliente.setBounds(new Rectangle(233, 76, 366, 23));
			jTextFieldCliente.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextFieldCliente.setText(util.cortarCadenaString(
							jTextFieldCliente.getText(), 90));
					buscarNombre(jTextFieldCliente.getText().trim());
				}

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {

				}
			});
			jTextFieldCliente
					.addFocusListener(new java.awt.event.FocusAdapter() {
						@Override
						public void focusGained(java.awt.event.FocusEvent e) {
							jTextFieldCliente.selectAll();
						}
					});
		}
		return jTextFieldCliente;
	}

	/**
	 * busca registros por el ruc en la base de datos
	 *
	 * @param texto
	 */
	public void buscar(String texto) {
		borrarTabla();
		borrarTabla();
		borrarTabla();
		borrarTabla();
		Object items[][] = clienteMd.seleccionarClientesBuscados(conn
				.getConexion(), texto); // @jve:decl-index=0:
		for (int i = 0; i < items.length; i++) {

			if (items[i][0] != null) {
				arregloClientesListaTempHash itemClase = new arregloClientesListaTempHash(
						items[i][0].toString(), items[i][2].toString(),
						items[i][1].toString(), items[i][3].toString(),
						new Boolean(true));

				modelo.nuevoItem(itemClase);
			}

		}
		if (modelo.getRowCount() == 0) {
			arregloClientesListaTempHash itemClase = new arregloClientesListaTempHash(
					"No hay Registros", "", "", "", new Boolean(true));

			modelo.nuevoItem(itemClase);
		}

	}

	/**
	 * busca registro por nombre en la base de datos
	 *
	 * @param texto
	 */

	public void buscarNombre(String texto) {
		borrarTabla();
		borrarTabla();
		borrarTabla();
		borrarTabla();
		Object items[][] = clienteMd.seleccionarClientesBuscadosNombre(conn
				.getConexion(), texto); // @jve:decl-index=0:
		for (int i = 0; i < items.length; i++) {

			if (items[i][0] != null) {
				arregloClientesListaTempHash itemClase = new arregloClientesListaTempHash(
						items[i][0].toString(), items[i][2].toString(),
						items[i][1].toString(), items[i][3].toString(),
						new Boolean(true));

				modelo.nuevoItem(itemClase);
			}

		}
		if (modelo.getRowCount() == 0) {
			arregloClientesListaTempHash itemClase = new arregloClientesListaTempHash(
					"No hay Registros", "", "", "", new Boolean(true));

			modelo.nuevoItem(itemClase);
		}

	}

	private void cargarDatos() {
		/*
		 * for(int i=0;i<items.length;i++){ if(items[i][0]!=null){
		 * detalleProductosInventario itemClase= new detalleProductosInventario(
		 * items[i][0].toString(), items[i][1].toString(),
		 * items[i][2].toString(), items[i][3].toString(),
		 * items[i][4].toString(), new Boolean(true) );
		 * if(items[i][0].toString().compareTo(""+ChoiceTipoProducto.getSelectedItem())==0 )
		 * modelo.nuevoItem(itemClase); } }
		 */
	}

	/**
	 * cierra la ventana
	 */
	public void cerrar() {
		this.setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}

	public String devolverRuc() {
		return jTextFieldRuc.getText().trim();
	}

	public String devolverNombre() {
		return jTextFieldRuc.getText().trim();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
