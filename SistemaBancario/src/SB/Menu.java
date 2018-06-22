package SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

static BufferedReader entrada2 = new BufferedReader (new InputStreamReader(System.in));
	
	public  static void main(String[] args) throws InterruptedException, IOException

	{
		
		Scanner entrada = new Scanner(System.in);
		ManejoDeArchivos archivo = new ManejoDeArchivos();
		Usuario us = new Usuario();
		Validacion v = new Validacion();
		int mien=0;
		float f=0f, sal = 0f;
		
		 System.out.println("Usuario: " + us.getUsuario() + "\nIngrese contraseña:\n");
		String d = v.getstring(entrada2.readLine());
		 if ( d.equals(us.getContraseña()))
		{
			 do {
				 System.out.println("Sistema Bancario:\n1-Abonar a una cuenta\n2-Retirar de una cuenta\n3-Ver saldo actual");
			    	 int res = Integer.parseInt(v.getint(entrada.next()));
			    	 
			    	 switch(res) {
			    	 
			    	 case 1:
			    		 System.out.println("--Abonar a una cuenta--");
			    		 System.out.println("Monto:");
			    		 f=Float.parseFloat(v.getfloat(entrada.next()));
			    		 sal = archivo.buscar("src/Usuario.txt");
			    		 sal = sal + f;
			    		 us.setSaldo(sal);
			    		 archivo.escribirTextoArchivo("src/Usuario.txt", "$ " + us.getSaldo() );
			    		 
			    		 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
			    		 mien = Integer.parseInt(v.getint(entrada.next()));

			    		 break;
			    	
			    	 case 2:
			    		 System.out.println("--Retirar a una cuenta--");
			    		 System.out.println("Monto:");
			    		 f=Float.parseFloat(v.getfloat(entrada.next()));
			    		 sal = archivo.buscar("src/Usuario.txt");
			    		 if (sal >f){
			    			  sal = sal - f;
			    		 us.setSaldo(sal);
			    		 archivo.escribirTextoArchivo("src/Usuario.txt", "$ " + us.getSaldo() );
			    		 
			    		 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
			    		 mien = Integer.parseInt(v.getint(entrada.next()));
			    		 }
			    		 else{
			    			 System.out.println("No se puede realizar transaccion\nEl monto es mayor al saldo\n¿Desea realizar otra accion?\n1-si\n2-no");
				    		 mien = Integer.parseInt(v.getint(entrada.next()));
			    		 }
			    		 
			    		break; 
			    		
			    	 case 3:
			    		 System.out.println("--Saldo--");
			    		 System.out.println(archivo.leerTextoArchivo("src/Usuario.txt"));
			    		 
			    		 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
			    		 mien = Integer.parseInt(v.getint(entrada.next()));
			    		 break;
			    		 
			    		 default:	 
				    		 System.out.println("Opcion no valida\n¿Desea realizar otra accion?\n1-si\n2-no");
				    		 mien = Integer.parseInt(v.getint(entrada.next()));
				    		 break;

			    	 }
			 }while (mien==1);
		}
		else
		{
			 System.out.println("Contraseña incorrecta");
		}
		
	}
	
}
