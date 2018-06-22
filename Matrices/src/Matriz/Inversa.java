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

public class Inversa extends JFrame {

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
	private JLabel lblInversa;
	private JLabel lblMatriz;
	private JButton btnLimpiar;
	private JButton btnAutorellenar;
	private JButton btnCalcular;
	private JLabel lblSuInversaEs;
	private JButton btnRegresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inversa frame = new Inversa();
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
	public Inversa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		a11 = new JTextField();
		a11.setBounds(29, 69, 35, 20);
		contentPane.add(a11);
		a11.setColumns(10);
		
		a12 = new JTextField();
		a12.setColumns(10);
		a12.setBounds(74, 69, 35, 20);
		contentPane.add(a12);
		
		a13 = new JTextField();
		a13.setColumns(10);
		a13.setBounds(119, 69, 35, 20);
		contentPane.add(a13);
		
		a21 = new JTextField();
		a21.setColumns(10);
		a21.setBounds(29, 100, 35, 20);
		contentPane.add(a21);
		
		a22 = new JTextField();
		a22.setColumns(10);
		a22.setBounds(74, 100, 35, 20);
		contentPane.add(a22);
		
		a23 = new JTextField();
		a23.setColumns(10);
		a23.setBounds(119, 100, 35, 20);
		contentPane.add(a23);
		
		a31 = new JTextField();
		a31.setColumns(10);
		a31.setBounds(29, 131, 35, 20);
		contentPane.add(a31);
		
		a32 = new JTextField();
		a32.setColumns(10);
		a32.setBounds(74, 131, 35, 20);
		contentPane.add(a32);
		
		a33 = new JTextField();
		a33.setColumns(10);
		a33.setBounds(119, 131, 35, 20);
		contentPane.add(a33);
		
		c11 = new JTextField();
		c11.setEditable(false);
		c11.setColumns(10);
		c11.setBounds(10, 254, 116, 20);
		contentPane.add(c11);
		
		c12 = new JTextField();
		c12.setEditable(false);
		c12.setColumns(10);
		c12.setBounds(136, 254, 116, 20);
		contentPane.add(c12);
		
		c13 = new JTextField();
		c13.setEditable(false);
		c13.setColumns(10);
		c13.setBounds(262, 254, 111, 20);
		contentPane.add(c13);
		
		c21 = new JTextField();
		c21.setEditable(false);
		c21.setColumns(10);
		c21.setBounds(10, 285, 116, 20);
		contentPane.add(c21);
		
		c22 = new JTextField();
		c22.setEditable(false);
		c22.setColumns(10);
		c22.setBounds(136, 285, 116, 20);
		contentPane.add(c22);
		
		c23 = new JTextField();
		c23.setEditable(false);
		c23.setColumns(10);
		c23.setBounds(262, 285, 111, 20);
		contentPane.add(c23);
		
		c31 = new JTextField();
		c31.setEditable(false);
		c31.setColumns(10);
		c31.setBounds(10, 316, 116, 20);
		contentPane.add(c31);
		
		c32 = new JTextField();
		c32.setEditable(false);
		c32.setColumns(10);
		c32.setBounds(136, 316, 116, 20);
		contentPane.add(c32);
		
		c33 = new JTextField();
		c33.setEditable(false);
		c33.setColumns(10);
		c33.setBounds(262, 316, 111, 20);
		contentPane.add(c33);
		
		lblInversa = new JLabel("Inversa");
		lblInversa.setBounds(145, 11, 46, 14);
		contentPane.add(lblInversa);
		
		lblMatriz = new JLabel("Matriz");
		lblMatriz.setBounds(74, 44, 46, 14);
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
		btnLimpiar.setBounds(190, 100, 120, 23);
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
		btnAutorellenar.setBounds(190, 131, 120, 23);
		contentPane.add(btnAutorellenar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [][] a = new int[3][3];
				//pasamos los datos de los txt al arreglo
		        a[0][0]=Integer.parseInt(a11.getText());
		        a[0][1]=Integer.parseInt(a12.getText());
		        a[0][2]=Integer.parseInt(a13.getText());
		        a[1][0]=Integer.parseInt(a21.getText());
		        a[1][1]=Integer.parseInt(a22.getText());
		        a[1][2]=Integer.parseInt(a23.getText());
		        a[2][0]=Integer.parseInt(a31.getText());
		        a[2][1]=Integer.parseInt(a32.getText());
		        a[2][2]=Integer.parseInt(a33.getText());
		        
		        //sacamos el determinante
		 int determinante,determinante1,determinante2;
		determinante = a[0][0] * a[1][1] * a[2] [2] + a[0] [1] *  a[1] [2] *  a[2] [0] +  a[1] [0] *  a[2] [1] *  a[0] [2] ;
		determinante1=a[2] [0] * a[1] [1] * a[0] [2] + a[1] [0] *a[0] [1] *a[2] [2] +a[2] [1]*a[1] [2]*a[0] [0];
		  determinante2=determinante-determinante1;
		  //encontramos la inverda de la matriz mediante cofactores
		  int resul11,resul12,resul13,resul21,resul22,resul23,resul31,resul32,resul33;

		        // cofactor 11
		resul11 = a[1][1]* a[2][2] - a[2][1]* a[1][2] ;
		resul11 = resul11 * 1;
		//cofactor 12
		resul12=a[1][0]* a[2][2] - a[2][0]* a[1][2] ;
		resul12 = resul12 * -1;
		//cofactor 1,3
		resul13=a[1][0]* a[2][1] - a[2][0]* a[1][1] ;
		resul13 = resul13 * 1;
		//cofactor 21
		resul21=a[0][1]* a[2][2] - a[2][1]* a[0][2] ;
		resul21 = resul21 * -1;
		//cofactor 22
		resul22=a[0][0]* a[2][2] - a[2][0]* a[0][2] ;
		resul22 = resul22 * 1;
		//cofactor 23
		resul23=a[0][0]* a[2][1] - a[2][0]* a[0][1] ;
		resul23 = resul23 * -1;
		//cofactor 31
		resul31=a[0][1]* a[1][2] - a[1][1]* a[0][2] ;
		resul31 = resul31 * 1;
		//cofactor 32
		resul32=a[0][0]* a[1][2] - a[1][0]* a[0][2] ;
		resul32 = resul32 * -1;
		//cofactor 33
		resul33=a[0][0]* a[1][1] - a[1][0]* a[0][1] ;
		resul33 = resul33 * 1;
		  //mostramos los resultados en los txt de resultados
		  c11.setText(String.valueOf (resul11 + "/" +  determinante2));
		  c21.setText(String.valueOf (resul12 + "/" +  determinante2));
		  c31.setText(String.valueOf (resul13 + "/" +  determinante2));
		  c12.setText(String.valueOf (resul21 + "/" +  determinante2));
		  c22.setText(String.valueOf (resul22 + "/" +  determinante2));
		  c32.setText(String.valueOf (resul23 + "/" +  determinante2));
		  c13.setText(String.valueOf (resul31 + "/" +  determinante2));
		  c23.setText(String.valueOf (resul32 + "/" +  determinante2));
		  c33.setText(String.valueOf (resul33 + "/" +  determinante2));
			}
		});
		btnCalcular.setBounds(119, 171, 106, 30);
		contentPane.add(btnCalcular);
		
		lblSuInversaEs = new JLabel("Su inversa es:");
		lblSuInversaEs.setBounds(106, 229, 80, 14);
		contentPane.add(lblSuInversaEs);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu dg = new Menu(); 
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Inversa.this.dispose();
			}
		});
		btnRegresar.setBounds(10, 362, 89, 23);
		contentPane.add(btnRegresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(239, 362, 89, 23);
		contentPane.add(btnSalir);
	}
	
	String ram(){
        Random  rnd = new Random();
	String num;
	num =  Integer.toString((int) (rnd.nextDouble() * 300 + -100));
	return num;
    }

}
