package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import tableUtil.ModeloClientesCuentasPorCobrar;
import tableUtil.ModeloCuentasporCobrarClienteDeudasDeRecibo;
import tableUtil.RenderClienteDeudas;
import tableUtil.modeloDeudasPorCliente;
import clases.PagoDeReciboPorClienteTemp;
import clases.arregloClientesListaTempHash;
import clasesBdd.clientesBdd;
import clasesBdd.conexionBdd;

public class CuentasPorCobrarVentana extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel AdministraciónTitulo = null;
	private JTable jTableClientes = null;
	private ModeloClientesCuentasPorCobrar modelo = null;//modelo cliente
	private JScrollPane jScrollPaneClientes = null;
	private JLabel LableClientes = null;
	private JLabel LableClientesDeudas = null;
	private JScrollPane jScrollPaneDeudas = null;
	private JTable jTableClientesDeudas = null;
	private ModeloCuentasporCobrarClienteDeudasDeRecibo modelodeudas = null;//deudas  //  @jve:decl-index=0:
	private modeloDeudasPorCliente modelodeudasTabla2 = null;//deudas  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public CuentasPorCobrarVentana() {
		super();
		initialize();
		
		cargarCLientes();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(692, 548);
		this.setContentPane(getJContentPane());
		this.setTitle("Administración de cuentas por cobrar");
		this.setClosable(true);
		this.setIconifiable(true);
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LableClientesDeudas = new JLabel();
			LableClientesDeudas.setBounds(new Rectangle(-2, 273, 688, 21));
			LableClientesDeudas.setForeground(Color.blue);
			LableClientesDeudas.setHorizontalAlignment(SwingConstants.CENTER);
			LableClientesDeudas.setText("Detalle de deudas");
			LableClientesDeudas.setFont(new Font("Dialog", Font.BOLD, 13));
			LableClientes = new JLabel();
			LableClientes.setBounds(new Rectangle(0, 43, 686, 24));
			LableClientes.setForeground(Color.blue);
			LableClientes.setHorizontalAlignment(SwingConstants.CENTER);
			LableClientes.setText("Lista de Clientes con Deudas pendientes");
			LableClientes.setFont(new Font("Dialog", Font.BOLD, 13));
			AdministraciónTitulo = new JLabel();
			AdministraciónTitulo.setBounds(new Rectangle(-1, 6, 686, 24));
			AdministraciónTitulo.setForeground(Color.blue);
			AdministraciónTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			AdministraciónTitulo.setText("Administración de Cuentas por Cobrar");
			AdministraciónTitulo.setFont(new Font("Dialog", Font.BOLD, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(AdministraciónTitulo, null);
			jContentPane.add(getJScrollPaneClientes(), null);
			jContentPane.add(LableClientes, null);
			jContentPane.add(LableClientesDeudas, null);
			jContentPane.add(getJScrollPaneDeudas(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modelo
	 *
	 * @return tableUtil.modeloTabla
	 */
	private ModeloClientesCuentasPorCobrar getModelo() {
		if (modelo == null) {
			modelo = new ModeloClientesCuentasPorCobrar();
		}
		return modelo;
	}

	/**
	 * This method initializes jTableClientes
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTableClientes() {
		if (jTableClientes == null) {
			jTableClientes = new JTable(getModelo());
			jTableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTableClientes.setRowHeight(40);
			jTableClientes.setRowSelectionAllowed(false);
			jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableClientes.setShowGrid(true);
			//jTableClientes.setToolTipText("Se puede Modificar el Subtotal y la Cantidad haciendo Doble click");
			jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(120);// cliente
			jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(200);// desc
			jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(120);// numero
			jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(120);// total
			jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(50);// ver
			jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(60);// ver
			jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(0);// ver
			RenderClienteDeudas render = new RenderClienteDeudas();
			jTableClientes.setDefaultRenderer(String.class, render);
			jTableClientes.setDefaultRenderer(Integer.class, render);
			jTableClientes.setDefaultRenderer(Boolean.class, render);
			jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Point click = new Point(e.getX(), e.getY());
					int column = jTableClientes.columnAtPoint(click);
					int row = jTableClientes.rowAtPoint(click);
					CargarDeudasCliente(row);



				}
			});
		}
		return jTableClientes;
	}

	/**
	 * This method initializes jScrollPaneClientes
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneClientes() {
		if (jScrollPaneClientes == null) {
			jScrollPaneClientes = new JScrollPane();
			jScrollPaneClientes.setBounds(new Rectangle(14, 75, 645, 167));
			jScrollPaneClientes.setViewportView(getJTableClientes());
		}
		return jScrollPaneClientes;
	}

	/**
	 * This method initializes jScrollPaneDeudas
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneDeudas() {
		if (jScrollPaneDeudas == null) {
			jScrollPaneDeudas = new JScrollPane();
			jScrollPaneDeudas.setBounds(new Rectangle(17, 302, 630, 184));
			jScrollPaneDeudas.setViewportView(getJTableClientesDeudas());
		}
		return jScrollPaneDeudas;
	}

	/**
	 * This method initializes modelodeudas
	 *
	 * @return tableUtil.modeloTabla
	 */
	private ModeloCuentasporCobrarClienteDeudasDeRecibo getModelodeudas() {
		if (modelodeudas == null) {
			modelodeudas = new ModeloCuentasporCobrarClienteDeudasDeRecibo();
		}
		return modelodeudas;
	}

	private modeloDeudasPorCliente getModelodeudasTabla2() {
		if (modelodeudasTabla2 == null) {
			modelodeudasTabla2 = new modeloDeudasPorCliente();
		}
		return modelodeudasTabla2;
	}
	/**
	 * This method initializes jTableClientesDeudas
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTableClientesDeudas() {
		if (jTableClientesDeudas == null) {
			jTableClientesDeudas = new JTable( getModelodeudasTabla2());
			//jTableClientesDeudas.setToolTipText("Se puede Modificar el Subtotal y la Cantidad haciendo Doble click");
			jTableClientesDeudas.setRowHeight(40);
			jTableClientesDeudas.setRowSelectionAllowed(false);
			jTableClientesDeudas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableClientesDeudas.setShowGrid(true);
			jTableClientesDeudas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTableClientesDeudas.getColumnModel().getColumn(0).setPreferredWidth(120);// cliente
			jTableClientesDeudas.getColumnModel().getColumn(1).setPreferredWidth(120);// desc
			jTableClientesDeudas.getColumnModel().getColumn(2).setPreferredWidth(80);// numero
			jTableClientesDeudas.getColumnModel().getColumn(3).setPreferredWidth(200);// total
			jTableClientesDeudas.getColumnModel().getColumn(4).setPreferredWidth(120);// ver
			RenderClienteDeudas render = new RenderClienteDeudas();
			jTableClientesDeudas.setDefaultRenderer(String.class, render);
			jTableClientesDeudas.setDefaultRenderer(Integer.class, render);
			jTableClientesDeudas.setDefaultRenderer(Boolean.class, render);
		}
		return jTableClientesDeudas;
	}
public void cargarCLientes(){
	conexionBdd con=new conexionBdd();
	clientesBdd clienteMd=new clientesBdd();
	Object[][] Clientes=clienteMd.seleccionarClientesConDeudas(con.getConexion() );
	for(int i=0;i< Clientes.length;i++){
		arregloClientesListaTempHash item= new arregloClientesListaTempHash(""+Clientes[i][3],""+Clientes[i][0],""+Clientes[i][1],""+Clientes[i][2],true,""+Clientes[i][4],""+Clientes[i][5]);

		modelo.nuevoItem(item);

	}



}
public void CargarDeudasCliente(int row){
	conexionBdd con=new conexionBdd();
	clientesBdd clientesMd= new clientesBdd();
	Object [][] arreglo=clientesMd.seleccionarDeudasPorClientesyRecibo(con.getConexion(),""+modelo.getValueAt(row, 6),""+modelo.getValueAt(row, 5));
	if(arreglo[0][0].toString().compareToIgnoreCase("")==0){
		PagoDeReciboPorClienteTemp item2=new PagoDeReciboPorClienteTemp("No hay Registros","","","","");
		modelodeudasTabla2.nuevoItem(item2);
	}else{
		borrarTabla();
		borrarTabla();
		borrarTabla();

		for(int i=0;i< arreglo.length;i++){
			PagoDeReciboPorClienteTemp item2=new PagoDeReciboPorClienteTemp(""+arreglo[i][0],""+arreglo[i][1],""+arreglo[i][2],""+arreglo[i][3],""+arreglo[i][4]);
			modelodeudasTabla2.nuevoItem(item2);
		}
	}


}

/**
 * borra la tabla
 */
private void borrarTabla() {
	try {
		int cont = 0;
		while (modelodeudasTabla2.getRowCount() != 0) {
			modelodeudasTabla2.borraItem(cont);
			cont++;
		}

	} catch (Exception fueraDeLimite) {
		int cont = 0;
	}

}



}  //  @jve:decl-index=0:visual-constraint="4,7"
