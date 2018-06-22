import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txttel;
	private JTextField txtdepto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(27, 48, 76, 14);
		contentPane.add(lblnombre);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setBounds(27, 76, 76, 14);
		contentPane.add(lblapellido);
		
		JLabel lbltel = new JLabel("Telefono:");
		lbltel.setBounds(27, 107, 76, 14);
		contentPane.add(lbltel);
		
		JLabel iddepto = new JLabel("Id Departamento:");
		iddepto.setBounds(27, 138, 104, 14);
		contentPane.add(iddepto);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(152, 45, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(152, 73, 86, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		txttel = new JTextField();
		txttel.setBounds(152, 104, 86, 20);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		txtdepto = new JTextField();
		txtdepto.setBounds(152, 135, 86, 20);
		contentPane.add(txtdepto);
		txtdepto.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//driver de conexion
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//cadena de conexion
					String servidor = "jdbc:mysql://localhost/practica1";
					con=DriverManager.getConnection(servidor, "root", "1234");
					
					Statement estado= (Statement) con.createStatement();
					estado.execute("insert into cliente values(NULL, '"+txtnombre.getText()+"', '"+txtapellido.getText()+"', '"+txttel.getText()+"', '"+txtdepto.getText()+"')");
					JOptionPane.showMessageDialog(null, "Guardado");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(89, 171, 89, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblcliente = new JLabel("Agregar Nuevo Cliente");
		lblcliente.setFont(new Font("Chiller", Font.PLAIN, 24));
		lblcliente.setBounds(49, 11, 201, 26);
		contentPane.add(lblcliente);
	}

}
