package Matriz;
//Importando las librerias a utilizar.
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 316);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatrices = new JLabel("Matrices");
		lblMatrices.setBounds(186, 11, 133, 14);
		contentPane.add(lblMatrices);
		
		JButton btnProductoPorEscalar = new JButton("Producto por Escalar");
		btnProductoPorEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escalar dg = new Escalar(); 
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnProductoPorEscalar.setBounds(227, 94, 204, 23);
		contentPane.add(btnProductoPorEscalar);
		
		JLabel lblElijaLaOperacin = new JLabel("Elija la operaci\u00F3n que desea realizar:");
		lblElijaLaOperacin.setBackground(Color.GRAY);
		lblElijaLaOperacin.setBounds(122, 54, 251, 14);
		contentPane.add(lblElijaLaOperacin);
		
		JButton btnInversa = new JButton("Inversa");
		btnInversa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inversa dg = new Inversa();//creamos una instancia del jframe que queremos abrir
				dg.setLocationRelativeTo(null); //centra el jframe que va a abrir
				dg.setVisible(true);//sirve para mostrar el otro jframe
				Menu.this.dispose();//cierra el actual jframe
			}
		});
		btnInversa.setBounds(13, 184, 204, 23);
		contentPane.add(btnInversa);
		
		JButton btnDeterminante = new JButton("Determinante");
		btnDeterminante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Determinante dg = new Determinante();
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnDeterminante.setBounds(115, 138, 204, 23);
		contentPane.add(btnDeterminante);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);//nos permite salir de la app
			}
		});
		btnSalir.setBounds(129, 243, 188, 23);
		contentPane.add(btnSalir);
		
		JButton btnSumaRestaMultiplicacin = new JButton("Suma, Resta, Multiplicaci\u00F3n");
		btnSumaRestaMultiplicacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Multi dg = new Multi();
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnSumaRestaMultiplicacin.setBounds(13, 94, 204, 23);
		contentPane.add(btnSumaRestaMultiplicacin);
		
		JButton btnTranspuesta = new JButton("Transpuesta");
		btnTranspuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transpuesta dg = new Transpuesta(); 
				dg.setLocationRelativeTo(null); 
				dg.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnTranspuesta.setBounds(227, 184, 204, 23);
		contentPane.add(btnTranspuesta);
		
		
	}
}
