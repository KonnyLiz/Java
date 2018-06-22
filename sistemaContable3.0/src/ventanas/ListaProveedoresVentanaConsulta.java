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
import javax.swing.WindowConstants;

import tableUtil.ModeloProveedor;
import tableUtil.RenderProveedorLista;
import Utilitarios.utilitarios;
import clases.ArregloProveedorTemp;
import clasesBdd.conexionBdd;
import clasesBdd.proveedoresBdd;
import clasesBdd.tipoProductoBdd;

public class ListaProveedoresVentanaConsulta extends JDialog {
	// public class listaClientesVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private ModeloProveedor modelo = null; // @jve:decl-index=0:
	private JScrollPane jScrollPane = null;
	private JLabel Administraciónproveedor = null;
	String User1;
	String rol;
	/**
	 * VARIABLES DE MODULO
	 */
	conexionBdd conn = new conexionBdd();
	proveedoresBdd proveedorMd = new proveedoresBdd(); // @jve:decl-index=0:

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
	public ListaProveedoresVentanaConsulta() {
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
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Lista de Proveedores");

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				cerrar();
			}
		});

		this.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
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
			Administraciónproveedor1.setText("Contacto:");
			Administraciónproveedor1.setFont(new Font("Dialog", Font.BOLD, 13));
			Administraciónproveedor = new JLabel();
			Administraciónproveedor.setBounds(new Rectangle(-1, 9, 625, 20));
			Administraciónproveedor.setForeground(Color.blue);
			Administraciónproveedor
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administraciónproveedor.setText("Lista de Proveedores");
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
	private ModeloProveedor getModelo() {
		if (modelo == null) {
			modelo = new ModeloProveedor();
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

							jTextFieldRuc.setText(""
									+ modelo.getValueAt(row, 2));
							jTextFieldCliente.setText(""
									+ modelo.getValueAt(row, 0));

							if(columnTemp==3){
								JOptionPane.showMessageDialog(null,
										"Acción no Válida!", "Alerta!",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} else {
							if (dato.compareToIgnoreCase("no hay registros") == 0)
								JOptionPane.showMessageDialog(null,
										"Registro Inválido!", "Alerta!",
										JOptionPane.INFORMATION_MESSAGE);
						}
					}// if
				}
			});

			jTable.getColumnModel().getColumn(0).setPreferredWidth(200);// Desc
			jTable.getColumnModel().getColumn(1).setPreferredWidth(200);// Contacto
			jTable.getColumnModel().getColumn(2).setPreferredWidth(100);// ruc
			jTable.getColumnModel().getColumn(3).setPreferredWidth(50);// editar


			RenderProveedorLista render = new RenderProveedorLista();
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
		Object items[][] = proveedorMd.seleccionarProveedoresBuscadosRUC(conn
				.getConexion(), texto); // @jve:decl-index=0:
		for (int i = 0; i < items.length; i++) {

			if (items[i][0] != null) {
				ArregloProveedorTemp itemClase = new ArregloProveedorTemp(
						items[i][0].toString(), items[i][2].toString(),
						items[i][1].toString(),
						new Boolean(true));

				modelo.nuevoItem(itemClase);
			}

		}
		if (modelo.getRowCount() == 0) {
			ArregloProveedorTemp itemClase = new ArregloProveedorTemp(
					"No hay Registros", "", "", new Boolean(true));

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
		Object items[][] = proveedorMd.seleccionarProveedoresBuscadosDescripcion(conn
				.getConexion(), texto); // @jve:decl-index=0:
		for (int i = 0; i < items.length; i++) {

			if (items[i][0] != null) {
				ArregloProveedorTemp itemClase = new ArregloProveedorTemp(
						items[i][0].toString(), items[i][2].toString(),
						items[i][1].toString(),
						new Boolean(true));

				modelo.nuevoItem(itemClase);
			}

		}
		if (modelo.getRowCount() == 0) {
			ArregloProveedorTemp itemClase = new ArregloProveedorTemp(
					"No hay Registros", "", "", new Boolean(true));

			modelo.nuevoItem(itemClase);
		}

	}


	/**
	 * cierra la ventana
	 */
	public void cerrar() {
		this.setVisible(true);
		this.dispose();
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
		return jTextFieldCliente.getText().trim();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
