import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class listadodepto extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listadodepto frame = new listadodepto();
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
	public listadodepto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ResultSetMetaData rsm;
				DefaultTableModel dtm = null;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String servidor = "jdbc:mysql://localhost/practica1";
					con = (Connection) DriverManager.getConnection(servidor,"root","1234");
					ps = (PreparedStatement) con.prepareStatement("select * from departamento");
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
					dtm = (DefaultTableModel)table.getModel();
					
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
				
		});
		btnCargar.setBounds(67, 185, 89, 23);
		contentPane.add(btnCargar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descripcion", "Id", "Depto"
			}
		));
		table.setBounds(42, 57, 371, 120);
		contentPane.add(table);
	}
}
