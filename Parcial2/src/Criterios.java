import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Criterios extends JFrame {

	private JPanel contentPane;
	private JTextField txtbuscar;
	private JTable tb;
	private JTable tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Criterios frame = new Criterios();
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
	public Criterios() {
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
		
		JRadioButton rbtdui = new JRadioButton("DUI");
		rbtdui.setBounds(124, 61, 109, 23);
		contentPane.add(rbtdui);
		
		JRadioButton rbtdepto = new JRadioButton("Departamentos");
		rbtdepto.setBounds(124, 35, 132, 23);
		contentPane.add(rbtdepto);
		
		tb = new JTable();
		tb.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "DUI", "Nombre", "Apellido", "Fecha de nacimiento", "Email", "Departamento", "Direccion"}));
		tb.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPane.add(tb);
		
		tb2 = new JTable();
		tb2.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "DUI", "Nombre", "Apellido", "Fecha de nacimiento", "Email", "Departamento", "Direccion"}));
		tb2.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPane.add(tb2);
		
		JLabel lblEn = new JLabel("En:");
		lblEn.setBounds(89, 37, 46, 14);
		contentPane.add(lblEn);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				if (rbtdui.isSelected()==true && rbtdepto.isSelected()==true){
					JOptionPane.showMessageDialog(null, "Solo seleccione una opción");
				}
				else
				{
				if (rbtdui.isSelected()==true){
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ResultSetMetaData rsm;
				DefaultTableModel dtm = null;
				tb2.setVisible(false);
				tb.setVisible(true);
				tb.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "DUI", "Nombre", "Apellido", "Fecha de nacimiento", "Email", "Departamento", "Direccion"}));
					tb.getColumnModel().getColumn(7).setPreferredWidth(109);
					tb.setBorder(new LineBorder(Color.DARK_GRAY));
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String servidor = "jdbc:mysql://localhost/parcial2";
					con = (Connection) DriverManager.getConnection(servidor,"root","1234");
					ps = (PreparedStatement) con.prepareStatement("SELECT * FROM `clientes` WHERE `DUI`='%" + txtbuscar.getText() + "%'");
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
					dtm = (DefaultTableModel)tb.getModel();
					
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
					tb2.setVisible(true);
					tb.setVisible(false);
					tb2.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "DUI", "Nombre", "Apellido", "Fecha de nacimiento", "Email", "Departamento", "Direccion"}));
						tb2.getColumnModel().getColumn(7).setPreferredWidth(109);
						tb2.setBorder(new LineBorder(Color.DARK_GRAY));
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						String servidor = "jdbc:mysql://localhost/parcial2";
						con = (Connection) DriverManager.getConnection(servidor,"root","1234");
						ps = (PreparedStatement) con.prepareStatement("SELECT * FROM clientes WHERE Departamento='%" + txtbuscar.getText() + "%'");
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
						dtm = (DefaultTableModel)tb2.getModel();
						
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
		}});
		btBuscar.setBounds(262, 49, 89, 23);
		contentPane.add(btBuscar);
	}
}
