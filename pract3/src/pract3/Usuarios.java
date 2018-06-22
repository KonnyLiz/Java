package pract3; 

import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios extends JFrame implements ActionListener,WindowStateListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtnombre;
	private JButton btnNewButton_1;
	private JTextField txtdepto;
	private JTextField txtnumlic;
	private JLabel lblnumlic;
	private String fila0, fila1, fila2, fila3;
	private JTextField txtid;
	private JLabel lblId;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
					frame.setVisible(true);
					//aqui se agrega el windowlistener sin eso no podemos escuchar el estado del formulario....lo del frame
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
	public Usuarios() throws ClassNotFoundException, SQLException {
		Conexion c = new Conexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.addWindowStateListener(this);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 129, 376, 133);
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
				txtnombre.setText(fila1);
				txtnumlic.setText(fila2);
				txtdepto.setText(fila3);
				txtid.setText(fila0);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				c.Eliminar(Integer.parseInt(txtid.getText()));
				JOptionPane.showMessageDialog(null, "Eliminado");
				table.setModel(mod());
				txtnombre.setText("");
				txtnumlic.setText("");
				txtdepto.setText("");
				txtid.setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(67, 273, 89, 23);
		contentPane.add(btnNewButton);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(189, 67, 207, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 70, 46, 14);
		contentPane.add(lblNombre);
		
		btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.Editar(Integer.parseInt(txtid.getText()),txtnombre.getText(), txtnumlic.getText(), txtdepto.getText());
					JOptionPane.showMessageDialog(null, "Cambios Guardados");
					table.setModel(mod());
					txtnombre.setText("");
					txtnumlic.setText("");
					txtdepto.setText("");
					txtid.setText("");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(166, 273, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtdepto = new JTextField();
		txtdepto.setColumns(10);
		txtdepto.setBounds(189, 98, 207, 20);
		contentPane.add(txtdepto);
		
		JLabel lbldepto = new JLabel("Departamento:");
		lbldepto.setBounds(10, 101, 136, 14);
		contentPane.add(lbldepto);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.insertar(txtnombre.getText(), txtnumlic.getText(), txtdepto.getText());
					JOptionPane.showMessageDialog(null, "Guardado");
					table.setModel(modelo);
					table.setModel(mod());
					txtnombre.setText("");
					txtnumlic.setText("");
					txtdepto.setText("");
					txtid.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAgregar.setBounds(265, 273, 89, 23);
		contentPane.add(btnAgregar);
		
		txtnumlic = new JTextField();
		txtnumlic.setColumns(10);
		txtnumlic.setBounds(189, 36, 207, 20);
		contentPane.add(txtnumlic);
		
		lblnumlic = new JLabel("Numero de Licencia:");
		lblnumlic.setBounds(10, 39, 136, 14);
		contentPane.add(lblnumlic);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(189, 5, 101, 20);
		contentPane.add(txtid);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(10, 8, 136, 14);
		contentPane.add(lblId);
	}
	//sirve para poder escuchar el estado de la ventana en si si ewst abierta cerra o se minimisa/
	protected void addWindowStateListener(Runnable runnable) throws ClassNotFoundException, SQLException{
		table.setModel(mod());
	}
		
private DefaultTableModel mod() throws SQLException {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Numero de licencia");
		modelo.addColumn("Nombre");
		modelo.addColumn("Departamento");
		
	Conexion con =new Conexion();
	
	ArrayList<String> datos= new ArrayList<String>();
	datos= con.retornarusuarios();
	Iterator<String> iterador = datos.iterator();
	while(iterador.hasNext()){
		String[] parte=iterador.next().split(",");
		modelo.addRow(new Object[]{parte[0],parte[1],parte[2], parte[3]});
		}
			return modelo;
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
