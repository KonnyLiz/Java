import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class clientes extends JFrame  implements ActionListener,WindowStateListener {

	private JPanel contentPane;
	private JTextField txtdui;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtfecha;
	private JTextField txtemail;
	private JTextField txtdepto;
	private JTextField txtdir;
	private JTextField txtid;
	private JTable table;

	private DefaultTableModel modelo = new DefaultTableModel();

	private String fila0, fila1, fila2, fila3, fila4, fila5, fila6, fila7;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientes frame = new clientes();
					frame.setVisible(true);
					frame.addWindowStateListener(this);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public clientes() throws ClassNotFoundException, SQLException {
		Conexion c = new Conexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.addWindowStateListener(this);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 247, 626, 210);
		contentPane.add(scrollPane);
		
		this.addWindowStateListener(this);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fila0=table.getValueAt(table.getSelectedRow(),0).toString();
				fila1=table.getValueAt(table.getSelectedRow(),1).toString();
				fila2=table.getValueAt(table.getSelectedRow(),2).toString();
				fila3=table.getValueAt(table.getSelectedRow(),3).toString();
				fila4=table.getValueAt(table.getSelectedRow(),4).toString();
				fila5=table.getValueAt(table.getSelectedRow(),5).toString();
				fila6=table.getValueAt(table.getSelectedRow(),6).toString();
				fila7=table.getValueAt(table.getSelectedRow(),7).toString();

				txtid.setText(fila0);
				txtdui.setText(fila1);
				txtnombre.setText(fila2);
				txtapellido.setText(fila3);
				txtfecha.setText(fila4);
				txtemail.setText(fila5);
				txtdepto.setText(fila6);
				txtdir.setText(fila7);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 97, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDui = new JLabel("DUI:");
		lblDui.setBounds(40, 72, 46, 14);
		contentPane.add(lblDui);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(40, 122, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(40, 147, 124, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(40, 172, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(40, 197, 83, 14);
		contentPane.add(lblDepartamento);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(40, 222, 62, 14);
		contentPane.add(lblDireccin);
		
		txtdui = new JTextField();
		txtdui.setBounds(175, 69, 171, 20);
		contentPane.add(txtdui);
		txtdui.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(175, 94, 171, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(175, 119, 171, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(175, 144, 171, 20);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(175, 169, 171, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtdepto = new JTextField();
		txtdepto.setBounds(175, 194, 171, 20);
		contentPane.add(txtdepto);
		txtdepto.setColumns(10);
		
		txtdir = new JTextField();
		txtdir.setBounds(175, 219, 171, 20);
		contentPane.add(txtdir);
		txtdir.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(40, 47, 46, 14);
		contentPane.add(lblId);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setBounds(175, 38, 171, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JButton button = new JButton("Eliminar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Eliminar(Integer.parseInt(txtid.getText()));
					JOptionPane.showMessageDialog(null, "Eliminado");
					table.setModel(mod());
					limpiar();
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setBounds(406, 68, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				c.Editar(Integer.parseInt(txtid.getText()),txtnombre.getText(), txtapellido.getText(), txtfecha.getText(), txtdui.getText(), txtemail.getText(), txtdepto.getText(), txtdir.getText());
				JOptionPane.showMessageDialog(null, "Guardado");
				table.setModel(mod());
				limpiar();
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		button_1.setBounds(406, 113, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Agregar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.insertar(txtnombre.getText(), txtapellido.getText(), txtfecha.getText(), txtdui.getText(), txtemail.getText(), txtdepto.getText(), txtdir.getText());
					JOptionPane.showMessageDialog(null, "Guardado");
					table.setModel(mod());
					limpiar();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_2.setBounds(406, 163, 89, 23);
		contentPane.add(button_2);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblClientes.setBounds(229, 13, 46, 14);
		contentPane.add(lblClientes);
	}
	
	protected void addWindowStateListener(Runnable runnable) throws ClassNotFoundException, SQLException{
		table.setModel(mod());
	}
		
private DefaultTableModel mod() throws SQLException {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("DUI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha Nacimiento");
		modelo.addColumn("E-mail");
		modelo.addColumn("Departamento");
		modelo.addColumn("Dirección");
		
	Conexion con =new Conexion();
	
	ArrayList<String> datos= new ArrayList<String>();
	datos= con.retorna();
	Iterator<String> iterador = datos.iterator();
	while(iterador.hasNext()){
		String[] parte=iterador.next().split(",");
		modelo.addRow(new Object[]{parte[0], parte[1], parte[2], parte[3], parte[4], parte[5], parte[6], parte[7]});
		}
	return modelo;
			
	}
	
	private void limpiar() {
		txtdui.setText("");
		txtnombre.setText("");
		txtapellido.setText("");
		txtfecha.setText("");
		txtemail.setText("");
		txtdepto.setText("");
		txtdir.setText("");
		txtid.setText("");
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
