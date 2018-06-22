package Matriz;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Multi extends JFrame {

	private JPanel contentPane;
	private JTextField a11;//desde aquí
	private JTextField a12;
	private JTextField a13;
	private JTextField a21;
	private JTextField a22;
	private JTextField a23;
	private JTextField a31;
	private JTextField a32;
	private JTextField a33;//hasta aqui, serian los txt del ingreso de datos de la matriz A
	private JTextField b11;//desde aquí
	private JTextField b12;
	private JTextField b13;
	private JTextField b21;
	private JTextField b22;
	private JTextField b23;
	private JTextField b31;
	private JTextField b32;
	private JTextField b33;//hasta aqui, serian los txt del ingreso de datos de la matriz B
	private JTextField c11;//desde aquí
	private JTextField c12;
	private JTextField c13;
	private JTextField c21;
	private JTextField c22;
	private JTextField c23;
	private JTextField c31;
	private JTextField c32;
	private JTextField c33;//hasta aqui, serian los txt de la matriz resultante
	private int i;//indice para los for
	private int j;//indice para los for
	private int k;//indice para los for
	private JButton btnRegresar;//para regresar al menu principla
	private JButton btnSalir;//para salir de la app
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Multi frame = new Multi();
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
	public Multi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSumaRestaMultiplicacion = new JLabel("Suma, Resta, Multiplicacion");
		lblSumaRestaMultiplicacion.setBounds(177, 11, 168, 14);
		contentPane.add(lblSumaRestaMultiplicacion);
		
		//construyendo los JTextField de la matriz A
		a11 = new JTextField();
		a11.setBounds(10, 61, 35, 20);
		contentPane.add(a11);
		a11.setColumns(10);
		
		a12 = new JTextField();
		a12.setColumns(10);
		a12.setBounds(55, 61, 35, 20);
		contentPane.add(a12);
		
		a13 = new JTextField();
		a13.setColumns(10);
		a13.setBounds(100, 61, 35, 20);
		contentPane.add(a13);
		
		a21 = new JTextField();
		a21.setColumns(10);
		a21.setBounds(10, 92, 35, 20);
		contentPane.add(a21);
		
		a22 = new JTextField();
		a22.setColumns(10);
		a22.setBounds(55, 92, 35, 20);
		contentPane.add(a22);
		
		a23 = new JTextField();
		a23.setColumns(10);
		a23.setBounds(100, 92, 35, 20);
		contentPane.add(a23);
		
		a31 = new JTextField();
		a31.setColumns(10);
		a31.setBounds(10, 123, 35, 20);
		contentPane.add(a31);
		
		a32 = new JTextField();
		a32.setColumns(10);
		a32.setBounds(55, 123, 35, 20);
		contentPane.add(a32);
		
		a33 = new JTextField();
		a33.setColumns(10);
		a33.setBounds(100, 123, 35, 20);
		contentPane.add(a33);
		
		JLabel lblMatrizA = new JLabel("Matriz A");
		lblMatrizA.setBounds(54, 36, 46, 14);
		contentPane.add(lblMatrizA);
		
		//construyendo los JTextField de la matriz B
		b11 = new JTextField();
		b11.setColumns(10);
		b11.setBounds(301, 61, 35, 20);
		contentPane.add(b11);
		
		b12 = new JTextField();
		b12.setColumns(10);
		b12.setBounds(346, 61, 35, 20);
		contentPane.add(b12);
		
		b13 = new JTextField();
		b13.setColumns(10);
		b13.setBounds(391, 61, 35, 20);
		contentPane.add(b13);
		
		b21 = new JTextField();
		b21.setColumns(10);
		b21.setBounds(301, 92, 35, 20);
		contentPane.add(b21);
		
		b22 = new JTextField();
		b22.setColumns(10);
		b22.setBounds(346, 92, 35, 20);
		contentPane.add(b22);
		
		b23 = new JTextField();
		b23.setColumns(10);
		b23.setBounds(391, 92, 35, 20);
		contentPane.add(b23);
		
		b31 = new JTextField();
		b31.setColumns(10);
		b31.setBounds(301, 123, 35, 20);
		contentPane.add(b31);
		
		b32 = new JTextField();
		b32.setColumns(10);
		b32.setBounds(346, 123, 35, 20);
		contentPane.add(b32);
		
		b33 = new JTextField();
		b33.setColumns(10);
		b33.setBounds(391, 123, 35, 20);
		contentPane.add(b33);
		
		JLabel lblMatrizB = new JLabel("Matriz B");
		lblMatrizB.setBounds(345, 36, 46, 14);
		contentPane.add(lblMatrizB);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pasamos todos los datos de los jtextfield a los arreglos
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
		     
		        int [][] b = new int[3][3];
		        b[0][0]=Integer.parseInt(b11.getText());
		        b[0][1]=Integer.parseInt(b12.getText());
		        b[0][2]=Integer.parseInt(b13.getText());
		        b[1][0]=Integer.parseInt(b21.getText());
		        b[1][1]=Integer.parseInt(b22.getText());
		        b[1][2]=Integer.parseInt(b23.getText());
		        b[2][0]=Integer.parseInt(b31.getText());
		        b[2][1]=Integer.parseInt(b32.getText());
		        b[2][2]=Integer.parseInt(b33.getText());
		       
		        //hacemos la suma
		        int [][] c = new int[3][3];
		       
		        for(int y=0; y<3; y++)
		        {
		        	for(int x=0; x<3; x++)
		        	{
		        	c[x][y]=  a[x][y] +  b[x][y];
		        	}
		        }
		         //pasamos los datos obtenidos a los respectivos jtextfield
		         c11.setText(String.valueOf (c[0][0]));
		         c12.setText(String.valueOf (c[0][1]));
		         c13.setText(String.valueOf (c[0][2]));
		         c21.setText(String.valueOf (c[1][0]));
		         c22.setText(String.valueOf (c[1][1]));
		         c23.setText(String.valueOf (c[1][2]));
		         c31.setText(String.valueOf (c[2][0]));
		         c32.setText(String.valueOf (c[2][1]));
		         c33.setText(String.valueOf (c[2][2]));
			}
		});
		btnSumar.setBounds(158, 58, 129, 23);
		contentPane.add(btnSumar);
		
		JButton btnRestar = new JButton("Restar");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pasamos los datos de los jtextfiel a los arreglos
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
		     
		        int [][] b = new int[3][3];
		        b[0][0]=Integer.parseInt(b11.getText());
		        b[0][1]=Integer.parseInt(b12.getText());
		        b[0][2]=Integer.parseInt(b13.getText());
		        b[1][0]=Integer.parseInt(b21.getText());
		        b[1][1]=Integer.parseInt(b22.getText());
		        b[1][2]=Integer.parseInt(b23.getText());
		        b[2][0]=Integer.parseInt(b31.getText());
		        b[2][1]=Integer.parseInt(b32.getText());
		        b[2][2]=Integer.parseInt(b33.getText());
		       int [][] c = new int[3][3];
		       
		       //realizamos la resta
		       for(int y=0; y<3; y++)
		        {
		        	for(int x=0; x<3; x++)
		        	{
		        	c[x][y]=  a[x][y] - b[x][y];
		        	}
		        }
		       //pasamos los resultados a los txt respectivos
		         c11.setText(String.valueOf (c[0][0]));
		         c12.setText(String.valueOf (c[0][1]));
		         c13.setText(String.valueOf (c[0][2]));
		         c21.setText(String.valueOf (c[1][0]));
		         c22.setText(String.valueOf (c[1][1]));
		         c23.setText(String.valueOf (c[1][2]));
		         c31.setText(String.valueOf (c[2][0]));
		         c32.setText(String.valueOf (c[2][1]));
		         c33.setText(String.valueOf (c[2][2]));
			}
		});
		btnRestar.setBounds(158, 89, 129, 23);
		contentPane.add(btnRestar);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		     
		        int [][] b = new int[3][3];
		        b[0][0]=Integer.parseInt(b11.getText());
		        b[0][1]=Integer.parseInt(b12.getText());
		        b[0][2]=Integer.parseInt(b13.getText());
		        b[1][0]=Integer.parseInt(b21.getText());
		        b[1][1]=Integer.parseInt(b22.getText());
		        b[1][2]=Integer.parseInt(b23.getText());
		        b[2][0]=Integer.parseInt(b31.getText());
		        b[2][1]=Integer.parseInt(b32.getText());
		        b[2][2]=Integer.parseInt(b33.getText());
		       int [][] c = new int[3][3];
		       
		         for (i=0; i<=2; i++){
		             for (j=0; j<=2; j++){
		             
		                 for (k = 0; k <=2; k++) { 
		                      for (k = 0; k <=2; k++) { 
		                    c[i][j] += a[i][k] * b[k][j];
		                      }
		                 }
		             }
		             }
		        
		         c11.setText(String.valueOf (c[0][0]));
		         c12.setText(String.valueOf (c[0][1]));
		         c13.setText(String.valueOf (c[0][2]));
		         c21.setText(String.valueOf (c[1][0]));
		         c22.setText(String.valueOf (c[1][1]));
		         c23.setText(String.valueOf (c[1][2]));
		         c31.setText(String.valueOf (c[2][0]));
		         c32.setText(String.valueOf (c[2][1]));
		         c33.setText(String.valueOf (c[2][2]));
			}
		});
		btnMultiplicar.setBounds(158, 120, 129, 23);
		contentPane.add(btnMultiplicar);
		
		JButton btnLimpiarMA = new JButton("Limpiar");
		btnLimpiarMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnLimpiarMA.setBounds(10, 154, 125, 23);
		contentPane.add(btnLimpiarMA);
		
		JButton btnAutorellenarMA = new JButton("Autorellenar");
		btnAutorellenarMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnAutorellenarMA.setBounds(10, 179, 125, 23);
		contentPane.add(btnAutorellenarMA);
		
		JButton btnLimpiarMB = new JButton("Limpiar");
		btnLimpiarMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				b11.setText("");
			       b12.setText("");
			       b13.setText("");
			       b21.setText("");
			       b22.setText("");
			       b23.setText("");
			       b31.setText("");
			       b32.setText("");
			       b33.setText("");
			}
		});
		btnLimpiarMB.setBounds(301, 154, 125, 23);
		contentPane.add(btnLimpiarMB);
		
		JButton btnAutorellenarMB = new JButton("Autorellenar");
		btnAutorellenarMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 b11.setText(ram());
			       b12.setText(ram());
			       b13.setText(ram());
			       b21.setText(ram());
			       b22.setText(ram());
			       b23.setText(ram());
			       b31.setText(ram());
			       b32.setText(ram());
			       b33.setText(ram());
			}
		});
		btnAutorellenarMB.setBounds(301, 179, 125, 23);
		contentPane.add(btnAutorellenarMB);
		
		//construyendo los JTextField de la matriz resultante
		c11 = new JTextField();
		c11.setEditable(false);
		c11.setColumns(10);
		c11.setBounds(191, 235, 35, 20);
		contentPane.add(c11);
		
		c12 = new JTextField();
		c12.setEditable(false);
		c12.setColumns(10);
		c12.setBounds(236, 235, 35, 20);
		contentPane.add(c12);
		
		c13 = new JTextField();
		c13.setEditable(false);
		c13.setColumns(10);
		c13.setBounds(281, 235, 35, 20);
		contentPane.add(c13);
		
		c21 = new JTextField();
		c21.setEditable(false);
		c21.setColumns(10);
		c21.setBounds(191, 266, 35, 20);
		contentPane.add(c21);
		
		c22 = new JTextField();
		c22.setEditable(false);
		c22.setColumns(10);
		c22.setBounds(236, 266, 35, 20);
		contentPane.add(c22);
		
		c23 = new JTextField();
		c23.setEditable(false);
		c23.setColumns(10);
		c23.setBounds(281, 266, 35, 20);
		contentPane.add(c23);
		
		c31 = new JTextField();
		c31.setEditable(false);
		c31.setColumns(10);
		c31.setBounds(191, 297, 35, 20);
		contentPane.add(c31);
		
		c32 = new JTextField();
		c32.setEditable(false);
		c32.setColumns(10);
		c32.setBounds(236, 297, 35, 20);
		contentPane.add(c32);
		
		c33 = new JTextField();
		c33.setEditable(false);
		c33.setColumns(10);
		c33.setBounds(281, 297, 35, 20);
		contentPane.add(c33);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(100, 269, 81, 14);
		contentPane.add(lblResultado);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu dg = new Menu();//creamos una instancia del jframe que queremos abrir
				dg.setLocationRelativeTo(null); //centra el jframe que va a abrir
				dg.setVisible(true);//sirve para mostrar el otro jframe
				Multi.this.dispose();//cierra el actual jframe
			}
		});
		btnRegresar.setBounds(10, 344, 89, 23);
		contentPane.add(btnRegresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);//nos permite salir de la app
			}
		});
		btnSalir.setBounds(349, 344, 89, 23);
		contentPane.add(btnSalir);
	}
	  //metodo creado para obtener un numero aleatorio entre el -100 y 200
	  static String ram(){
		  Random  rnd = new Random();
		  String num;
		  num =  Integer.toString((int) (rnd.nextDouble() * 300 + -100));
		  return num;
	  }
	  
}
