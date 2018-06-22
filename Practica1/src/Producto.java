import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class Producto extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private JTextField txtexistencia;
	private JTable table;
	Conexion c = new Conexion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(171, 11, 109, 14);
		contentPane.add(lblProductos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(62, 37, 68, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(62, 62, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblExistencia = new JLabel("Existencia:");
		lblExistencia.setBounds(62, 87, 68, 14);
		contentPane.add(lblExistencia);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(156, 34, 124, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(156, 59, 124, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtexistencia = new JTextField();
		txtexistencia.setText("");
		txtexistencia.setBounds(156, 84, 124, 20);
		contentPane.add(txtexistencia);
		txtexistencia.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				c.insertar(txtnombre.getText(), txtprecio.getText(), txtexistencia.getText());
				txtnombre.setText("");
				txtprecio.setText("");
				txtexistencia.setText("");
			}
		});
		btnAgregar.setBounds(131, 125, 89, 23);
		contentPane.add(btnAgregar);
		
		JRadioButton rdbtnNombre = new JRadioButton("Nombre");
		rdbtnNombre.setBounds(62, 186, 89, 23);
		contentPane.add(rdbtnNombre);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(62, 165, 89, 14);
		contentPane.add(lblOrdenarPor);
		
		JRadioButton rdbtnprecio = new JRadioButton("Precio");
		rdbtnprecio.setBounds(156, 186, 80, 23);
		contentPane.add(rdbtnprecio);
		
		JRadioButton rdbtnExistencia = new JRadioButton("Existencia");
		rdbtnExistencia.setBounds(243, 186, 109, 23);
		contentPane.add(rdbtnExistencia);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Nombre", "Precio", "Existencia"
				}
			));
			table.setBounds(44, 210, 364, 159);
			contentPane.add(table);
			
			
		
		ActionListener sliceActionListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	 
			if(rdbtnNombre.isSelected() == true ){
			try 
			{	
				table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
				c.ordenar(table, "Nombre", "asc");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			if(rdbtnprecio.isSelected() == true){
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "Precio", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
			if(rdbtnExistencia.isSelected() == true){
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "Existencia", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			}
		};
		ButtonGroup gp = new ButtonGroup();
	      gp.add(rdbtnNombre);
			gp.add(rdbtnprecio);
			gp.add(rdbtnExistencia);
			 rdbtnExistencia.addActionListener(sliceActionListener);
			 rdbtnNombre.addActionListener(sliceActionListener);
			 rdbtnprecio.addActionListener(sliceActionListener);
			 
	}
	}
			      
			      
			    
