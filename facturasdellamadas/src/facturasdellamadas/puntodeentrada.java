package facturasdellamadas;
import java.io.BufferedReader;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//import javax.imageio.ImageIO;
import java.io.InputStreamReader;
public class puntodeentrada {
			
		   static Scanner entrada;
		   Facturar factura1= new Facturar();
		   static BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
		   //INICIANDO LA LLAMADA
		public  static void main(String[] args) throws InterruptedException, IOException 
		{
			//imagen
			Imagen p = new Imagen();
			p.show();
			 Cliente nuevo = new Cliente();
			 Float tot;
			 int mien;
			
			 Facturar factura1= new Facturar();
			boolean llamada=true;
			Float ho=0f, min= 0f, seg=0f, inicios = 0f, iniciom = 0f, inicioh = 0f, finals=0f, finalm = 0f, finalh = 0f;
			 Scanner entrada=new Scanner(System.in);
			 Float totd=0f;
			Tiempo t= null; 
			 ManejoDeArchivos archivo = new ManejoDeArchivos();
			
			
	        do {
	        	 
				System.out.println("¿que desea hacer?:\n1- Realizar llamada\n2-Datos del telefono\n3-Agregar nuevo cliente\n4-Estadistica por edad\n5-Listar clientes\n6-buscar cliente\n7-Editar cliente");
		        int res = entrada.nextInt();
	        	
			switch(res) {
		
			case 1:
				
				 do
				 {
				 System.out.println("Presione: \n m -- iniciar llamada\n c -- finalizar llamada");
				
				 if(entrada.next().toLowerCase().equals("m"))
				 {
				  t= new Tiempo();
				 System.out.println("Iniciando: ");
				 String x= t.iniciarTiempo();
				 inicioh = Float.parseFloat(x.substring(0, 2));
				 iniciom = Float.parseFloat(x.substring(3, 5));
				 inicios=Float.parseFloat(x.substring(6, 8));
				 System.out.println("----------------------------------------");
				 }
				
				 if(entrada.next().toLowerCase().equals("c")  )
				{	 System.out.println("----------------------------------------");
					String yy= t.detener();
					 System.out.println("Finalizado");
			       finalh = Float.parseFloat(yy.substring(0, 2));
			       finalm=Float.parseFloat(yy.substring(3, 5));
			       finals=Float.parseFloat(yy.substring(6,8));
			       
			       if (inicioh < finalh)
			       {
			    	   ho = finalh-inicioh;
			       }
			       else 
			       {
			    	   ho = (finalh-inicioh)*(-1);
			       }
			       
			       if (iniciom < finalm)
			       {
			    	   min = finalm-iniciom;
			       }
			       else 
			       {
			    	   min = (finalm-iniciom)*(-1);
			       }
			       if (inicios < finals)
			       {
			    	   seg = finals-inicios;
			       }
			       else 
			       {
			    	   seg = (finals-inicios)*(-1);
			       }
			       
				}
				
				//factura1.RegistrarDatosLlamada(entrada.nextFloat());
				
				float delta=(ho*60)+ min + (seg/60);
				factura1.RegistrarDatosLlamada(delta);
				tot=factura1.CalcularTotalLlamada(1);
				totd+=tot;
				
				System.out.println("Total de la llamada:"+tot.toString());
				System.out.println("¿Desea registrar otra llamada?\n s -- si");
				
				if(entrada.next().toLowerCase().equals("s"))
				{
					llamada=true;	
				}
				
				else
				{
					llamada=false;
				}
				
			   }while(llamada==true);
				
			 
				 System.out.println("Total de la llamada:"+totd.toString());
			
				 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
				break;
			
			case 2:
				//DATOS DEL TELEFONO
				factura1.Tel.AsignarVariables("Samsung Galaxy", "Android", 2014);
				factura1.Marcacion.SetNumeroTelefono("7777-8654");
				System.out.println("Modelo de tel: "+ factura1.Tel.GetModelo());
				System.out.println("Sistema Operativo: "+ factura1.Tel.GetSO());
				System.out.println("Version: "+ factura1.Tel.GetAnio());
				System.out.println("Linea: "+ factura1.Marcacion.GetNumeroTelefono());
				
				System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
				break;
				
			case 3:
				 System.out.print("Linea:");
				 nuevo.setNumeroLinea(entrada2.readLine());

				 System.out.println("Nombre:\n");
				 nuevo.setNombre(entrada2.readLine().toUpperCase());
				 
				 System.out.println("Apellido:");
				 nuevo.setApellido(entrada2.readLine().toUpperCase());
				 System.out.println("Edad:");
				 nuevo.setEdad(entrada.nextInt());
				 archivo.escribirTextoArchivo("src/Cliente.txt", nuevo.getNumeroLinea()+" "+nuevo.getnombre()+" "+nuevo.getapellido()+" "+nuevo.getedad());
				 
				 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
				 break;
				
			case 4:
				 System.out.println("Ingrese edad");
		         System.out.println(archivo.estadistica("src/Cliente.txt", entrada.nextInt()));
		         
		         System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
		         break;
		         
			case 5:
				//listar clientes
				System.out.println("Mostrando listado de clientes:\n");
				System.out.println(archivo.leerTextoArchivo("src/Cliente.txt"));
				
				System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
				break;
				
			case 6:
				System.out.println("ingrese el nombre o numero de telefono del cliente");
	        	 System.out.println(archivo.buscar("src/Cliente.txt", entrada.next().toUpperCase()));
	        	 
	        	 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
	        	 break;
	        	 
			case 7:
				//modificar un cliente
				System.out.println("ingrese el numero de linea:");
		          System.out.println(archivo.buscar("src/Cliente.txt", entrada2.readLine()));
		          System.out.println("Ingrese el numero de elemento a modificar\n1-Nombre:\n2-Apellido\n3-Edad\n");
		          
		        	   System.out.println("Ingrese el nuevo nombre:"); 
		        	   archivo.editar("src/Clientes.txt", "7473-0585", "7473-0587 ASTRID BONILLA 30");
		           
		        System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				mien = entrada.nextInt();
				break;
				
			default:
				System.out.println("opcion no valida"); 
				
				System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				 mien = entrada.nextInt();
				break;
			} 
			
	        } while (mien==1);
	        
	    System.out.println("--------FIN DEL PROGRAMA------------");
			 
		}

	}

