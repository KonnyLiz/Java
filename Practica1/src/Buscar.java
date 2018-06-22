import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtbuscardepto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
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
					ps = (PreparedStatement) con.prepareStatement("SELECT c.nombre, c.apellido, d.Nombre  FROM departamento as d, cliente as c WHERE c.id = d.id and d.Nombre LIKE '%" + txtbuscardepto.getText() + "%'");
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
		btnBuscar.setBounds(232, 30, 89, 23);
		contentPane.add(btnBuscar);
		
		txtbuscardepto = new JTextField();
		txtbuscardepto.setBounds(57, 31, 165, 20);
		contentPane.add(txtbuscardepto);
		txtbuscardepto.setColumns(10);
	}

}
