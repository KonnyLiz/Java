package Matriz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Escalar extends JFrame {

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
	private JTextField c11;
	private JTextField c12;
	private JTextField c13;
	private JTextField c21;
	private JTextField c22;
	private JTextField c23;
	private JTextField c31;
	private JTextField c32;
	private JTextField c33;
	private JLabel lblMatriz;
	private JTextField txtNum;
	private JLabel lblEscalar;
	private JButton btnAutorellenarEscalar;
	private JButton btnAutorellenar;
	private JButton btnLimpiar;
	private JLabel lblResultado;
	private JLabel lblProductoPorEscalar;
	private JButton btnRegresar;
	private JButton btnSalir;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escalar frame = new Escalar();
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
	public Escalar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		a11 = new JTextField();
		a11.setBounds(66, 83, 35, 20);
		contentPane.add(a11);
		a11.setColumns(10);
		
		a12 = new JTextField();
		a12.setColumns(10);
		a12.setBounds(111, 83, 35, 20);
		contentPane.add(a12);
		
		a13 = new JTextField();
		a13.setColumns(10);
		a13.setBounds(156, 83, 35, 20);
		contentPane.add(a13);
		
		a21 = new JTextField();
		a21.setColumns(10);
		a21.setBounds(66, 114, 35, 20);
		contentPane.add(a21);
		
		a22 = new JTextField();
		a22.setColumns(10);
		a22.setBounds(111, 114, 35, 20);
		contentPane.add(a22);
		
		a23 = new JTextField();
		a23.setColumns(10);
		a23.setBounds(156, 114, 35, 20);
		contentPane.add(a23);
		
		a31 = new JTextField();
		a31.setColumns(10);
		a31.setBounds(66, 145, 35, 20);
		contentPane.add(a31);
		
		a32 = new JTextField();
		a32.setColumns(10);
		a32.setBounds(111, 145, 35, 20);
		contentPane.add(a32);
		
		a33 = new JTextField();
		a33.setColumns(10);
		a33.setBounds(156, 145, 35, 20);
		contentPane.add(a33);
		
		c11 = new JTextField();
		c11.setEditable(false);
		c11.setColumns(10);
		c11.setBounds(145, 252, 35, 20);
		contentPane.add(c11);
		
		c12 = new JTextField();
		c12.setEditable(false);
		c12.setColumns(10);
		c12.setBounds(190, 252, 35, 20);
		contentPane.add(c12);
		
		c13 = new JTextField();
		c13.setEditable(false);
		c13.setColumns(10);
		c13.setBounds(235, 252, 35, 20);
		contentPane.add(c13);
		
		c21 = new JTextField();
		c21.setEditable(false);
		c21.setColumns(10);
		c21.setBounds(145, 283, 35, 20);
		contentPane.add(c21);
		
		c22 = new JTextField();
		c22.setEditable(false);
		c22.setColumns(10);
		c22.setBounds(190, 283, 35, 20);
		contentPane.add(c22);
		
		c23 = new JTextField();
		c23.setEditable(false);
		c23.setColumns(10);
		c23.setBounds(235, 283, 35, 20);
		contentPane.add(c23);
		
		c31 = new JTextField();
		c31.setEditable(false);
		c31.setColumns(10);
		c31.setBounds(145, 314, 35, 20);
		contentPane.add(c31);
		
		c32 = new JTextField();
		c32.setEditable(false);
		c32.setColumns(10);
		c32.setBounds(190, 314, 35, 20);
		contentPane.add(c32);
		
		c33 = new JTextField();
		c33.setEditable(false);
		c33.setColumns(10);
		c33.setBounds(235, 314, 35, 20);
		contentPane.add(c33);
		
		lblMatriz = new JLabel("Matriz:");
		lblMatriz.setBounds(10, 117, 46, 14);
		contentPane.add(lblMatriz);
		
		txtNum = new JTextField();
		txtNum.setBounds(66, 37, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		lblEscalar = new JLabel("Escalar:");
		lblEscalar.setBounds(10, 40, 46, 14);
		contentPane.add(lblEscalar);
		
		btnAutorellenarEscalar = new JButton("Autorellenar");
		btnAutorellenarEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtNum.setText(ram());
			}
		});
		btnAutorellenarEscalar.setBounds(246, 36, 104, 23);
		contentPane.add(btnAutorellenarEscalar);
		
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
		btnAutorellenar.setBounds(246, 144, 104, 23);
		contentPane.add(btnAutorellenar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNum.setText("");
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
		btnLimpiar.setBounds(246, 113, 104, 23);
		contentPane.add(btnLimpiar);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(61, 286, 74, 14);
		contentPane.add(lblResultado);
		
		lblProductoPorEscalar = new JLabel("Producto por Escalar");
		lblProductoPorEscalar.setBounds(133, 11, 137, 14);
		contentPane.add(lblProductoPorEscalar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu dg = new Menu();
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Escalar.this.dispose();
			}
		});
		btnRegresar.setBounds(10, 354, 89, 23);
		contentPane.add(btnRegresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(267, 354, 89, 23);
		contentPane.add(btnSalir);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int numeris;
		//pasar los datos del txt al arreglo
		        int matris[][]=new int[3][3];  
		        matris[0][0]=Integer.parseInt(a11.getText());
		        matris[0][1]=Integer.parseInt(a12.getText());
		        matris[0][2]=Integer.parseInt(a13.getText());
		        matris[1][0]=Integer.parseInt(a21.getText());
		        matris[1][1]=Integer.parseInt(a22.getText());
		        matris[1][2]=Integer.parseInt(a23.getText());
		        matris[2][0]=Integer.parseInt(a31.getText());
		        matris[2][1]=Integer.parseInt(a32.getText());
		        matris[2][2]=Integer.parseInt(a33.getText());
		      
		// aca lo que hace agarrar el valor del textfield a33  y guardarlos en la variables numeris
		        numeris=Integer.parseInt(txtNum.getText());
		        
		//aca lo muesta el resultado en el textfield final
		          c11.setText(String.valueOf (numeris * matris[0][0]));
		          c12.setText(String.valueOf (numeris * matris[0][1]));
		          c13.setText(String.valueOf (numeris * matris[0][2]));
		          c21.setText(String.valueOf (numeris * matris[1][0]));
		          c22.setText(String.valueOf (numeris * matris[1][1]));
		          c23.setText(String.valueOf (numeris * matris[1][2]));
		          c31.setText(String.valueOf (numeris * matris[2][0]));
		          c32.setText(String.valueOf (numeris * matris[2][1]));
		          c33.setText(String.valueOf (numeris * matris[2][2]));
			}
		});
		btnCalcular.setBounds(133, 185, 110, 33);
		contentPane.add(btnCalcular);
	}
	
	String ram(){
        Random  rnd = new Random();
	String num;
	num =  Integer.toString((int) (rnd.nextDouble() * 300 + -100));
	return num;
    }

}
