import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Formulario1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtdesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario1 frame = new Formulario1();
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
	public Formulario1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(36, 23, 46, 14);
		contentPane.add(lblnombre);
		
		JLabel lbldescripcion = new JLabel("Descripci\u00F3n:");
		lbldescripcion.setBounds(36, 65, 66, 14);
		contentPane.add(lbldescripcion);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(142, 20, 139, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtdesc = new JTextField();
		txtdesc.setBounds(142, 62, 139, 20);
		contentPane.add(txtdesc);
		txtdesc.setColumns(10);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//driver de conexion
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//cadena de conexion
					String servidor = "jdbc:mysql://localhost/practica1";
					con=DriverManager.getConnection(servidor, "root", "1234");
					
					Statement estado= (Statement) con.createStatement();
					estado.execute("insert into departamento values(NULL, '"+txtnombre.getText()+"', '"+txtdesc.getText()+"')");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		btnguardar.setBounds(109, 116, 86, 20);
		contentPane.add(btnguardar);
	}
}
