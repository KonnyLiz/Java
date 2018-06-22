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

public class Transpuesta extends JFrame {

	private JPanel contentPane;
	private JTextField a11;//desde aquí
	private JTextField a12;
	private JTextField a13;
	private JTextField a21;
	private JTextField a22;
	private JTextField a23;
	private JTextField a31;
	private JTextField a32;
	private JTextField a33;
	private JTextField c11;
	private JTextField c12;
	private JTextField c13;
	private JTextField c21;
	private JTextField c22;
	private JTextField c23;
	private JTextField c31;
	private JTextField c32;
	private JTextField c33;
	private JLabel lblTranspuesta;
	private JLabel lblMatriz;
	private JLabel lblLaMatrizTranspuesta;
	private JButton btnLimpiar;
	private JButton btnAutorellenar;
	private JButton btnCalcular;
	private JButton btnSalir;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transpuesta frame = new Transpuesta();
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
	public Transpuesta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		a11 = new JTextField();
		a11.setBounds(35, 61, 35, 20);
		contentPane.add(a11);
		a11.setColumns(10);
		
		a12 = new JTextField();
		a12.setColumns(10);
		a12.setBounds(80, 61, 35, 20);
		contentPane.add(a12);
		
		a13 = new JTextField();
		a13.setColumns(10);
		a13.setBounds(125, 61, 35, 20);
		contentPane.add(a13);
		
		a21 = new JTextField();
		a21.setColumns(10);
		a21.setBounds(35, 92, 35, 20);
		contentPane.add(a21);
		
		a22 = new JTextField();
		a22.setColumns(10);
		a22.setBounds(80, 92, 35, 20);
		contentPane.add(a22);
		
		a23 = new JTextField();
		a23.setColumns(10);
		a23.setBounds(125, 92, 35, 20);
		contentPane.add(a23);
		
		a31 = new JTextField();
		a31.setColumns(10);
		a31.setBounds(35, 123, 35, 20);
		contentPane.add(a31);
		
		a32 = new JTextField();
		a32.setColumns(10);
		a32.setBounds(80, 123, 35, 20);
		contentPane.add(a32);
		
		a33 = new JTextField();
		a33.setColumns(10);
		a33.setBounds(125, 123, 35, 20);
		contentPane.add(a33);
		
		c11 = new JTextField();
		c11.setEditable(false);
		c11.setColumns(10);
		c11.setBounds(229, 224, 35, 20);
		contentPane.add(c11);
		
		c12 = new JTextField();
		c12.setEditable(false);
		c12.setColumns(10);
		c12.setBounds(274, 224, 35, 20);
		contentPane.add(c12);
		
		c13 = new JTextField();
		c13.setEditable(false);
		c13.setColumns(10);
		c13.setBounds(316, 224, 35, 20);
		contentPane.add(c13);
		
		c21 = new JTextField();
		c21.setEditable(false);
		c21.setColumns(10);
		c21.setBounds(229, 255, 35, 20);
		contentPane.add(c21);
		
		c22 = new JTextField();
		c22.setEditable(false);
		c22.setColumns(10);
		c22.setBounds(274, 255, 35, 20);
		contentPane.add(c22);
		
		c23 = new JTextField();
		c23.setEditable(false);
		c23.setColumns(10);
		c23.setBounds(316, 255, 35, 20);
		contentPane.add(c23);
		
		c31 = new JTextField();
		c31.setEditable(false);
		c31.setColumns(10);
		c31.setBounds(229, 286, 35, 20);
		contentPane.add(c31);
		
		c32 = new JTextField();
		c32.setEditable(false);
		c32.setColumns(10);
		c32.setBounds(274, 286, 35, 20);
		contentPane.add(c32);
		
		c33 = new JTextField();
		c33.setEditable(false);
		c33.setColumns(10);
		c33.setBounds(316, 286, 35, 20);
		contentPane.add(c33);
		
		lblTranspuesta = new JLabel("Transpuesta");
		lblTranspuesta.setBounds(125, 11, 91, 14);
		contentPane.add(lblTranspuesta);
		
		lblMatriz = new JLabel("Matriz");
		lblMatriz.setBounds(80, 36, 46, 14);
		contentPane.add(lblMatriz);
		
		lblLaMatrizTranspuesta = new JLabel("La matriz transpuesta es:");
		lblLaMatrizTranspuesta.setBounds(22, 258, 190, 14);
		contentPane.add(lblLaMatrizTranspuesta);
		
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
		btnLimpiar.setBounds(209, 91, 115, 23);
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
		btnAutorellenar.setBounds(209, 122, 115, 23);
		contentPane.add(btnAutorellenar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor1 =Integer.parseInt(a11.getText());
                int valor2 =Integer.parseInt(a12.getText());
                int valor3 =Integer.parseInt(a13.getText());
                int valor4 =Integer.parseInt(a21.getText());
                int valor5 =Integer.parseInt(a22.getText());
                int valor6 =Integer.parseInt(a23.getText());
                int valor7 =Integer.parseInt(a31.getText());
                int valor8 =Integer.parseInt(a32.getText());
                int valor9 =Integer.parseInt(a33.getText());
                
                c11.setText(String.valueOf (valor1));
                c12.setText(String.valueOf (valor4)); 
                c13.setText(String.valueOf (valor7)); 
                c21.setText(String.valueOf (valor2)); 
                c22.setText(String.valueOf (valor5)); 
                c23.setText(String.valueOf (valor8)); 
                c31.setText(String.valueOf (valor3)); 
                c32.setText(String.valueOf (valor6)); 
                c33.setText(String.valueOf (valor9));
			}
		});
		btnCalcular.setBounds(114, 154, 112, 35);
		contentPane.add(btnCalcular);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(242, 342, 89, 23);
		contentPane.add(btnSalir);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu dg = new Menu();
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Transpuesta.this.dispose();
			}
		});
		btnRegresar.setBounds(10, 342, 89, 23);
		contentPane.add(btnRegresar);
	}
	
	String ram(){
    Random  rnd = new Random();
	String num;
	num =  Integer.toString((int) (rnd.nextDouble() * 300 + -100));
	return num;
    }

}
