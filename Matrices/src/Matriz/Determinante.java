package Matriz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Determinante extends JFrame {

	private JPanel contentPane;
	private JTextField a11;
	private JTextField a12;
	private JTextField a13;
	private JTextField a21;
	private JTextField a22;
	private JTextField a23;
	private JTextField a31;
	private JTextField a32;
	private JTextField a33;
	private JLabel lblDeterminante;
	private JLabel lblMatriz;
	private JButton btnLimpiar;
	private JButton btnAutorellenar;
	private JButton btnCalcular;
	private JTextField txtDeterminante;
	private JLabel lblResultados;
	private JButton btnRegresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Determinante frame = new Determinante();
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
	public Determinante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		a11 = new JTextField();
		a11.setBounds(21, 61, 35, 20); 
		a11.setText("0");
		contentPane.add(a11);
		a11.setColumns(10);
		
		a12 = new JTextField();
		a12.setColumns(10);
		a12.setBounds(66, 61, 35, 20);
		a12.setText("0");
		contentPane.add(a12);
		
		a13 = new JTextField();
		a13.setColumns(10);
		a13.setBounds(111, 61, 35, 20);
		a13.setText("0");
		contentPane.add(a13);
		
		a21 = new JTextField();
		a21.setColumns(10);
		a21.setBounds(21, 92, 35, 20);
		a21.setText("0");
		contentPane.add(a21);
		
		a22 = new JTextField();
		a22.setColumns(10);
		a22.setBounds(66, 92, 35, 20);
		a22.setText("0");
		contentPane.add(a22);
		
		a23 = new JTextField();
		a23.setColumns(10);
		a23.setBounds(111, 92, 35, 20);
		a23.setText("0");
		contentPane.add(a23);
		
		a31 = new JTextField();
		a31.setColumns(10);
		a31.setBounds(21, 123, 35, 20);
		a31.setText("0");
		contentPane.add(a31);
		
		a32 = new JTextField();
		a32.setColumns(10);
		a32.setBounds(66, 123, 35, 20);
		a32.setText("0");
		contentPane.add(a32);
		
		a33 = new JTextField();
		a33.setColumns(10);
		a33.setBounds(111, 123, 35, 20);
		a33.setText("0");
		contentPane.add(a33);
		
		lblDeterminante = new JLabel("Determinante");
		lblDeterminante.setBounds(143, 11, 88, 14);
		contentPane.add(lblDeterminante);
		
		lblMatriz = new JLabel("Matriz");
		lblMatriz.setBounds(66, 36, 46, 14);
		contentPane.add(lblMatriz);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 a11.setText("");
			       a12.setText("");
			       a13.setText("");
			       a21.setText("");
			       a22.setText("");
			       a23.setText("");
			       a31.setText("");
			       a32.setText("");
			       a33.setText("");
			}
		});
		btnLimpiar.setBounds(189, 91, 109, 23);
		contentPane.add(btnLimpiar);
		
		btnAutorellenar = new JButton("Autorellenar");
		btnAutorellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a11.setText(ram());
			       a12.setText(ram());
			       a13.setText(ram());
			       a21.setText(ram());
			       a22.setText(ram());
			       a23.setText(ram());
			       a31.setText(ram());
			       a32.setText(ram());
			       a33.setText(ram());
			}
		});
		btnAutorellenar.setBounds(189, 122, 109, 23);
		contentPane.add(btnAutorellenar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int [][] a = new int[3][3];
		        a[0][0]=Integer.parseInt(a11.getText());
		        a[0][1]=Integer.parseInt(a12.getText());
		        a[0][2]=Integer.parseInt(a13.getText());
		        a[1][0]=Integer.parseInt(a21.getText());
		        a[1][1]=Integer.parseInt(a22.getText());
		        a[1][2]=Integer.parseInt(a23.getText());
		        a[2][0]=Integer.parseInt(a31.getText());
		        a[2][1]=Integer.parseInt(a32.getText());
		        a[2][2]=Integer.parseInt(a33.getText());
		        //declaramos variables para guardar datos y encontramos determinante
		     int determinante,determinante1,determinante2;
		determinante = a[0][0] * a[1][1] * a[2] [2] + a[0] [1] *  a[1] [2] *  a[2] [0] +  a[1] [0] *  a[2] [1] *  a[0] [2] ;
		determinante1=a[2][0] * a[1] [1] * a[0] [2] + a[1] [0] *a[0] [1] *a[2] [2] +a[2] [1]*a[1] [2]*a[0] [0];
		  determinante2=determinante-determinante1;
		txtDeterminante.setText(String.valueOf(determinante2));
			}
		});
		btnCalcular.setBounds(100, 161, 99, 38);
		contentPane.add(btnCalcular);
		
		txtDeterminante = new JTextField();
		txtDeterminante.setEditable(false);
		txtDeterminante.setBounds(174, 222, 86, 20);
		contentPane.add(txtDeterminante);
		txtDeterminante.setColumns(10);
		
		lblResultados = new JLabel("Su determinante es:");
		lblResultados.setBounds(50, 225, 114, 14);
		contentPane.add(lblResultados);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu dg = new Menu();
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Determinante.this.dispose();
			}
		});
		btnRegresar.setBounds(10, 267, 89, 23);
		contentPane.add(btnRegresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(226, 267, 89, 23);
		contentPane.add(btnSalir);
	}
	
	String ram(){
    Random  rnd = new Random();
	String num;
	num =  Integer.toString((int) (rnd.nextDouble() * 10 + 1));
	return num;
    }

}
