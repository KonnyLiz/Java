package empleados;


	import java.io.BufferedReader;
	//import java.awt.event.WindowAdapter;
	//import java.awt.event.WindowEvent;
	//import java.awt.image.BufferedImage;
	//import java.io.File;
	import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
	//import javax.imageio.ImageIO;
	import java.io.InputStreamReader;
		
	public class Prestaciones {
		private  String ID;
			   
			   static BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
			   
			public  static void main(String[] args) throws InterruptedException, IOException 
			{
				Scanner entrada = new Scanner(System.in);
				Manejodearchivos archivo = new Manejodearchivos();
				Empleado nuevo = new Empleado();
				Validacion v = new Validacion();
				int mien, res, cont=1;
				float isss=0f, afp=0f, renta=0f, total=0f;
		        	 
					
			        
			        do {
		        	System.out.println("----PRESTACIONES----:\n1-Agregar empleado\n2-Mostrar nomina\n");
		        	res = entrada.nextInt();
				switch(res) {
			
				case 1:
					
					 System.out.println("--Agregar empleado--\n");
					
					 System.out.println("Nombre:");
					nuevo.setnombre(v.getstring(entrada2.readLine().toUpperCase()));
					 
					 System.out.println("Apellido:");
					 nuevo.setapellido(v.getstring(entrada2.readLine().toUpperCase()));
					 System.out.println("Edad:");
					 nuevo.setedad(v.getint(entrada.next()));
					 System.out.println("Salario:");
					 nuevo.setsalario(entrada.nextFloat());
					
					 isss =  nuevo.getsalario()* 0.003f;
					 afp = (nuevo.getsalario() * 0.0625f);
					 renta = (nuevo.getsalario() * 0.010f);
					 total = nuevo.getsalario() - (isss + afp + renta);
					 
					archivo.escribirTextoArchivo("src/Empleado.txt", nuevo.getnombre()+" "+nuevo.getapellido()+" "+nuevo.getedad()+" "+nuevo.getsalario() + " ISSS: " + isss + " AFP: " + afp + " Renta: " + renta + " Salario neto: " + total);

					System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
					
					mien = entrada.nextInt();
					break;
				
				case 2:
					System.out.println("Mostrando listado de Empleados:\n");
					System.out.println(archivo.leerTextoArchivo("src/Empleado.txt"));
					
					System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
					 mien = entrada.nextInt();
					break;
									
				default:
					System.out.println("opcion no valida"); 
					
					System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
					 mien = entrada.nextInt();
					break;
				} 
				}while (mien==1);
				
		        
		    System.out.println("--------FIN DEL PROGRAMA------------");
			}
		        
}
