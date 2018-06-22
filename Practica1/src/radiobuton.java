import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.*;
public class radiobuton extends JFrame {

	private JPanel contentPane;
	private JTextField txtbuscar;
	private JTable tabladepto;
	private JTable tablecliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radiobuton frame = new radiobuton();
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
	public radiobuton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(10, 11, 46, 14);
		contentPane.add(lblBuscar);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(89, 8, 167, 20);
		contentPane.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JRadioButton rbtcliente = new JRadioButton("Clientes");
		rbtcliente.setBounds(124, 61, 109, 23);
		contentPane.add(rbtcliente);
		
		JRadioButton rbtdepto = new JRadioButton("Departamentos");
		rbtdepto.setBounds(124, 35, 132, 23);
		contentPane.add(rbtdepto);
		
		tabladepto = new JTable();
		tabladepto.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPane.add(tabladepto);
		
		tablecliente = new JTable();
		tablecliente.setBounds(41, 91, 343, 219);
		contentPane.add(tablecliente);
		
		JLabel lblEn = new JLabel("En:");
		lblEn.setBounds(89, 37, 46, 14);
		contentPane.add(lblEn);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//acciones del boton
				//para radiobuton del cliente
				
				if (rbtcliente.isSelected()==true && rbtdepto.isSelected()==true){
					JOptionPane.showMessageDialog(null, "Solo seleccione una opción");
				}
				else
				{
				if (rbtcliente.isSelected()==true){
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ResultSetMetaData rsm;
				DefaultTableModel dtm = null;
				tabladepto.setVisible(false);
				tablecliente.setVisible(true);
				tablecliente.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "Nombre", "Apellido", "Telefono", "id_departamento"
						}
					));
					tablecliente.getColumnModel().getColumn(4).setPreferredWidth(109);
					tablecliente.setBorder(new LineBorder(Color.DARK_GRAY));
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String servidor = "jdbc:mysql://localhost/practica1";
					con = (Connection) DriverManager.getConnection(servidor,"root","1234");
					ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cliente WHERE nombre LIKE '%" + txtbuscar.getText() + "%'");
					rs = ps.executeQuery();
					rsm = rs.getMetaData();
					
					ArrayList<Object[]> data = new ArrayList<>();
					while (rs.next()){
						Object[] rows= new Object[rsm.getColumnCount()];
						for(int i=0; i<rows.length; i++)
						{
							rows[i] = rs.getObject(i+1);
						}
						data.add(rows);
					}
					dtm = (DefaultTableModel)tablecliente.getModel();
					
					for(int i=0; i<data.size(); i++)
					{
						dtm.addRow(data.get(i));
					}
				}catch (ClassNotFoundException e){
					e.printStackTrace();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				}
			
			
			//rbdepartamentos
			 if (rbtdepto.isSelected()==true){
				
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ResultSetMetaData rsm;
					DefaultTableModel dtm = null;
					tabladepto.setVisible(true);
					tablecliente.setVisible(false);
					tabladepto.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID", "Departamento", "Descripci\u00F3n"
							}
						));
						tabladepto.getColumnModel().getColumn(1).setPreferredWidth(102);
						tabladepto.setBounds(41, 91, 343, 219);
						
					
					//tabladepto.;
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						String servidor = "jdbc:mysql://localhost/practica1";
						con = (Connection) DriverManager.getConnection(servidor,"root","1234");
						ps = (PreparedStatement) con.prepareStatement("SELECT * FROM departamento WHERE Nombre LIKE '%" + txtbuscar.getText() + "%'");
						rs = ps.executeQuery();
						rsm = rs.getMetaData();
						
						ArrayList<Object[]> data = new ArrayList<>();
						while (rs.next()){
							Object[] rows= new Object[rsm.getColumnCount()];
							for(int i=0; i<rows.length; i++)
							{
								rows[i] = rs.getObject(i+1);
							}
							data.add(rows);
						}
						dtm = (DefaultTableModel)tabladepto.getModel();
						
						for(int i=0; i<data.size(); i++)
						{
							dtm.addRow(data.get(i));
						}
					}catch (ClassNotFoundException e){
						e.printStackTrace();
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
					}
				}
				
			}
		});
		btBuscar.setBounds(262, 49, 89, 23);
		contentPane.add(btBuscar);
	}
}
