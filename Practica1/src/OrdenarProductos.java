import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class OrdenarProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private JTextField txtexistencia;
	Conexion c = new Conexion();
	private JTable table;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenarProductos frame = new OrdenarProductos();
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
	public OrdenarProductos() {
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
		txtnombre.setBounds(145, 34, 124, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(145, 59, 124, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtexistencia = new JTextField();
		txtexistencia.setText("");
		txtexistencia.setBounds(145, 84, 124, 20);
		contentPane.add(txtexistencia);
		txtexistencia.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Precio", "Existencias"
			}
		));
		table.setBounds(55, 171, 351, 201);
		contentPane.add(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				c.insertar(txtnombre.getText(), txtprecio.getText(), txtexistencia.getText());
				txtnombre.setText("");
				txtprecio.setText("");
				txtexistencia.setText("");
		
			try {
				c.ordenar(table, "Nombre", "asc");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnAgregar.setBounds(171, 119, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnid = new JButton("ID");
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (i%2==0)
				{
				i++;
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "ID", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else{
					i++;
					try {
						table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
						c.ordenar(table, "ID", "desc");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			}
		});
		btnid.setBounds(55, 149, 89, 23);
		contentPane.add(btnid);
		
		JButton btnnombre = new JButton("Nombre");
		btnnombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (i%2==0)
				{
				i++;
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "Nombre", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else{
					i++;
					try {
						table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
						c.ordenar(table, "Nombre", "desc");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		});
		btnnombre.setBounds(142, 149, 89, 23);
		contentPane.add(btnnombre);
		
		JButton btnPrecio = new JButton("Precio");
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i%2==0)
				{
				i++;
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "Precio", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else{
					i++;
					try {
						table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
						c.ordenar(table, "Precio", "desc");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnPrecio.setBounds(229, 149, 89, 23);
		contentPane.add(btnPrecio);
		
		JButton btnExistencia = new JButton("Existencia");
		btnExistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i%2==0)
				{
				i++;
				try {
					table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
					c.ordenar(table, "Existencia", "asc");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else{
					i++;
					try {
						table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Nombre", "Precio", "Existencia"}));
						c.ordenar(table, "Existencia", "desc");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnExistencia.setBounds(317, 149, 89, 23);
		contentPane.add(btnExistencia);
		
		
		
		
		
		
		
	}
}
