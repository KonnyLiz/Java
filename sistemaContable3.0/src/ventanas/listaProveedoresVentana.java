package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clasesBdd.conexionBdd;
import clasesBdd.proveedoresBdd;

public class listaProveedoresVentana extends JInternalFrame {
	/**
	 * declaracion de la tabla
	 */
	DefaultTableModel modeloDatos = new DefaultTableModel(); // @jve:decl-index=0:visual-constraint="641,118"

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel Administracióndeclientes = null;
	conexionBdd conexion = new conexionBdd(); // @jve:decl-index=0:
	proveedoresBdd proveedorMd = new proveedoresBdd(); // @jve:decl-index=0:
	int rows = 0;
	int cols = 0;

	/**
	 * Datos de la tabla
	 * 
	 */
	Object[] etiquetasColumna = { "DESCRIPCION DEL PROVEEDOR ", "TELEFONO 1",
			"TELEFONO 2", "PAIS", "CIUDAD", "CONTACTO", };

	private JScrollPane jScrollPaneDatos = null;
	private JTable jTableDatos = null;

	/**
	 * This is the default constructor
	 */
	public listaProveedoresVentana() {
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
		this.setSize(607, 417);
		this.setContentPane(getJContentPane());
		this.setTitle("Administracion -> Lista de Proveedores ");

		for (int i = 0; i < etiquetasColumna.length; i++) {
			modeloDatos.addColumn(etiquetasColumna[i]);

		}

		rows = etiquetasColumna.length;
		cols = 10;
		Object temporal[][] = proveedorMd.seleccionarTodos(conexion
				.getConexion());
		if (temporal.length == 0)
			JOptionPane.showMessageDialog(null,
					"No hay registros para mostrar! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
		for (int i = 0; i < modeloDatos.getRowCount(); i++)
			modeloDatos.removeRow(i);
		for (int i = 0; i < temporal.length; i++) {
			modeloDatos.addRow(temporal[i]);

		}

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Administracióndeclientes = new JLabel();
			Administracióndeclientes.setBounds(new Rectangle(168, 19, 273, 21));
			Administracióndeclientes.setForeground(Color.blue);
			Administracióndeclientes
					.setText("Administración Lista de empleados ");
			Administracióndeclientes
					.setHorizontalAlignment(SwingConstants.CENTER);
			Administracióndeclientes.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(Administracióndeclientes, null);
			jContentPane.add(getJScrollPaneDatos(), null);

		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneDatos
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneDatos() {
		if (jScrollPaneDatos == null) {
			jScrollPaneDatos = new JScrollPane();
			jScrollPaneDatos.setBounds(new Rectangle(17, 63, 563, 250));
			jScrollPaneDatos.setViewportView(getJTableDatos());
		}
		return jScrollPaneDatos;
	}

	/**
	 * This method initializes jTableDatos
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTableDatos() {
		if (jTableDatos == null) {
			jTableDatos = new JTable(modeloDatos);
			jTableDatos.setShowGrid(true);
			jTableDatos.setEnabled(false);
			jTableDatos.setRowSelectionAllowed(false);
			jTableDatos.setGridColor(SystemColor.controlDkShadow);
			jTableDatos.setPreferredScrollableViewportSize(new Dimension(500,
					70));
			// double[] porcentajes={5000,130,130,130,130,130,130,130,160,160};
			jTableDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// int vColIndex = 0;
			// TableColumn col =
			// jTableDatos.getColumnModel().getColumn(vColIndex);
			// int width = 100;
			// col.setPreferredWidth(width);

		}
		return jTableDatos;
	}

} // @jve:decl-index=0:visual-constraint="10,10"

