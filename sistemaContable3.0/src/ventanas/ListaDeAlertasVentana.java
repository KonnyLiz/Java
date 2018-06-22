package ventanas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import tableUtil.modeloAlertas;
import tableUtil.renderAlertas;
import clases.alertaTablaObj;
import clases.alertas;
import clasesBdd.alertasBdd;
import clasesBdd.conexionBdd;

public class ListaDeAlertasVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jPanelEtiquetas = null;
	private JLabel Administracióndeclientes = null;
	private Label labelOpcion = null;
	private Choice choiceOpcion = null;
	private JButton jButtonAceptar = null;
	conexionBdd conn = new conexionBdd(); // @jve:decl-index=0:
	alertasBdd alertaMd = new alertasBdd(); // @jve:decl-index=0:
	int ItemSelected = 0;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	modeloAlertas modelo = new modeloAlertas(); // @jve:decl-index=0:
	int filaQueCambio = 0;

	/**
	 * This is the default constructor
	 */
	public ListaDeAlertasVentana() {
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
		this.setSize(777, 465);
		this.setContentPane(getJContentPane());
		this.setTitle("Administracion -> Lista de Alertas ");

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(-1, 15, 604, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes
					.setText("Administración Lista de Alertas Ventana");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new Dimension(603, 319));
			jContentPane.add(getJPanelEtiquetas(), null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelEtiquetas
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelEtiquetas() {
		if (jPanelEtiquetas == null) {
			labelOpcion = new Label();
			labelOpcion.setText("Escoja Una Opción: ");
			labelOpcion.setFont(new Font("Dialog", Font.BOLD, 12));
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(25);
			gridLayout.setVgap(12);
			gridLayout.setColumns(3);
			jPanelEtiquetas = new JPanel();
			jPanelEtiquetas.setLayout(gridLayout);
			jPanelEtiquetas.setBounds(new Rectangle(40, 50, 382, 22));
			jPanelEtiquetas.add(labelOpcion, null);
			jPanelEtiquetas.add(getChoiceOpcion(), null);
			jPanelEtiquetas.add(getJButtonAceptar(), null);
		}
		return jPanelEtiquetas;
	}

	/**
	 * This method initializes choiceOpcion
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getChoiceOpcion() {
		if (choiceOpcion == null) {
			choiceOpcion = new Choice();
			choiceOpcion.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					ItemSelected = choiceOpcion.getSelectedIndex();
				}
			});
			choiceOpcion.add("Todas las Alertas");
			choiceOpcion.add("Alertas pendientes ");
		}
		return choiceOpcion;
	}

	/**
	 * This method initializes jButtonAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (choiceOpcion.getSelectedItem().compareTo(
									"Todas las Alertas") == 0) {
								limpiarGrilla();
								limpiarGrilla();
								limpiarGrilla();
								Object[][] alertas = alertaMd
										.seleccionarEventosTodos(conn
												.getConexion());
								cargarItems(alertas);

							} else {
								limpiarGrilla();
								limpiarGrilla();
								limpiarGrilla();
								Object[][] alertas = alertaMd
										.seleccionarEventosMes(conn
												.getConexion());
								cargarItems(alertas);

							}
							//
							// Object[][] seleccionarEventosMes(Connection conn)

						}// fin action performed

					});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(19, 85, 725, 297));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(modelo);
			jTable.setRowHeight(40);
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTable.setShowGrid(true);
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable
					.setToolTipText("Se puede Modificar  los datos  haciendo Doble click");
			jTable.getColumnModel().getColumn(0).setPreferredWidth(50);// id
			jTable.getColumnModel().getColumn(1).setPreferredWidth(320);// desc
			jTable.getColumnModel().getColumn(2).setPreferredWidth(124);// fecha
			// 1
			jTable.getColumnModel().getColumn(3).setPreferredWidth(124);// fecha
			// 2
			jTable.getColumnModel().getColumn(4).setPreferredWidth(70);// estado
			jTable.getColumnModel().getColumn(5).setPreferredWidth(280);// descr
			// 2
			jTable.getColumnModel().getColumn(6).setPreferredWidth(70);// modificar
			jTable.getColumnModel().getColumn(7).setPreferredWidth(70);// eliminar
			renderAlertas render = new renderAlertas();
			jTable.setDefaultRenderer(String.class, render);
			jTable.setDefaultRenderer(Integer.class, render);
			jTable.setDefaultRenderer(Boolean.class, render);
			jTable.getModel().addTableModelListener(new TableModelListener() {

				public void tableChanged(TableModelEvent e) {
					filaQueCambio = e.getLastRow();
				}
			});
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTable.columnAtPoint(click);
					int row = jTable.rowAtPoint(click);
					if (modelo.getRowCount() > 0 && column == 07) {
						int res = pedirConfirmacion();
						if (res == 0) {

							eliminar(validarObjeto());
							modelo.borraItem(row);

						}
					}
					if (modelo.getRowCount() > 0 && column == 06) {
						int res = pedirConfirmacion2();
						if (res == 0) {
							modificar(validarObjeto());

						}
					}

				}

			});

		}
		return jTable;
	}

	/**
	 * pide confirmación antes de eliminar
	 * 
	 * @return
	 */
	int pedirConfirmacion() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this, "Desea Eliminar el Item?",
				"Confirmar acción", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}
		return res;
	}

	/**
	 * pide confirmación antes de eliminar
	 * 
	 * @return
	 */
	int pedirConfirmacion2() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this,
				"Desea Modificar la información?", "Confirmar acción",
				JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}
		return res;
	}

	/**
	 * limpia la griila de elementos
	 */
	public void limpiarGrilla() {
		if (modelo.getRowCount() >= 0) {
			try {
				int cont = 0;
				while (modelo.getRowCount() != 0) {
					modelo.borraItem(cont);
					cont++;
				}

			} catch (Exception muchosElementos) {

			}
		}
	}

	/**
	 * carga los items a la tabla recibe el objeto
	 */
	public void cargarItems(Object[][] alertas) {
		for (int i = 0; i < alertas.length; i++) {
			alertaTablaObj objeto = new alertaTablaObj();
			objeto.setAlerta("" + alertas[i][0]);
			objeto.setDescripcion("" + alertas[i][1]);
			objeto.setFechaInicio("" + alertas[i][2]);
			objeto.setFechaFinalizacionAlerta("" + alertas[i][3]);
			objeto.setEstado("" + alertas[i][4]);
			objeto.setDescripcion2("" + alertas[i][5]);
			objeto.setEliminar(true);
			objeto.setModificar(true);
			modelo.nuevoItem(objeto);
		}
	}// cargarItems

	public void modificar(alertas objeto) {
		alertaMd.modificar(conn.getConexion(), objeto);
	}

	public void eliminar(alertas objeto) {
		alertaMd.eliminar(conn.getConexion(), objeto);
	}

	/**
	 * valida la clase
	 * 
	 * @return
	 */
	public alertas validarObjeto() {
		alertas alertasDp = new alertas(0, "", "", "", "", "");
		alertasDp.setAlerta(Integer.parseInt(""
				+ modelo.getValueAt(filaQueCambio, 0)));
		alertasDp.setDescripcion("" + modelo.getValueAt(filaQueCambio, 1));
		alertasDp.setFechaInicio("" + modelo.getValueAt(filaQueCambio, 2));
		alertasDp
				.setFechaDinalizacion("" + modelo.getValueAt(filaQueCambio, 3));
		alertasDp.setEstado("" + modelo.getValueAt(filaQueCambio, 4));
		alertasDp.setDescripcion2("" + modelo.getValueAt(filaQueCambio, 5));
		return alertasDp;
	}

} // @jve:decl-index=0:visual-constraint="17,2"

