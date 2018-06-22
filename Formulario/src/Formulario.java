
import java.awt.event.*;
import java.awt.Color;
import java.awt.color.*;
import javax.swing.*;

public class Formulario extends JFrame { //Clase para los formularios

	public static void main(String[] args){
	
		Formulario f = new Formulario();//para manejar formularios
		JLabel linea = new JLabel();//para manejar los label
		JTextField lineatxt = new JTextField(); //para manejar el txt
		Cliente c = new Cliente();//para manejar la clase cliente
		ManejoDeArchivos archivo = new ManejoDeArchivos();
		
		f.setLayout(null);
		f.setSize(600, 400);
		f.setTitle("Primer ventana sin autogenerar");
		f.getContentPane().setBackground(Color.gray);
		
		linea.setVisible(true);
		linea.setSize(40, 20);
		linea.setLocation(20, 30);
		linea.setText("Linea:");
		f.add(linea);
		
		lineatxt.setVisible(true);
		lineatxt.setSize(80, 20);
		lineatxt.setLocation(100, 30);
		lineatxt.setText("linea");
		f.add(lineatxt);
		
		JLabel nombre = new JLabel();
		nombre.setVisible(true);
		nombre.setSize(60, 20);
		nombre.setLocation(20, 50);
		nombre.setText("Nombre:");
		f.add(nombre);
		
		JLabel apellido = new JLabel();
		apellido.setVisible(true);
		apellido.setSize(60, 20);
		apellido.setLocation(20, 70);
		apellido.setText("Apellido:");
		f.add(apellido);
		
		JTextField nomtxt = new JTextField();
		nomtxt.setVisible(true);
		nomtxt.setSize(80, 20);
		nomtxt.setLocation(100, 50);
		nomtxt.setText("");
		f.add(nomtxt);
		
		JTextField apeltxt = new JTextField();
		apeltxt.setVisible(true);
		apeltxt.setSize(80, 20);
		apeltxt.setLocation(100, 70);
		apeltxt.setText("");
		f.add(apeltxt);
		
		JButton boton = new JButton();//para manejar los botones
		boton.setVisible(true);
		boton.setSize(80, 20);
		boton.setLocation(60, 100);
		boton.setText("Guardar");
		f.add(boton);
		boton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						f.setTitle("ahorita no joven, estoy cambiando titulo");
					//c.setNumeroLinea(lineatxt.getText()); c.setNombre(nomtxt.getText()); c.setApellido(apeltxt.getText());
						archivo.escribirTextoArchivo("src/Cliente.txt", lineatxt.getText() + " " + nomtxt.getText() + " "+  apeltxt.getText());
					}
					
				});
		
		
		
		
		
		f.setVisible(true);
	}
}
