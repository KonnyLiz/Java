package Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Menu {

	private String OV_1_NumeroCuenta;
	static BufferedReader OV_1_entrada2 = new BufferedReader (new InputStreamReader(System.in));
	
	public  static void main(String[] args) throws InterruptedException, IOException

	{
		Scanner OV_1_entrada = new Scanner(System.in);
		ManejoDeArchivos OV_1_archivo = new ManejoDeArchivos();
		Usuario OV_1_nuevo = new Usuario();
		Validacion OV_1_v = new Validacion();
		int OV_1_mien, OV_1_Abono = 0, OV_1_res=0, OV_1_cont=0;
		
		float f = 0;
		float OV_1_Saldo=0f;
		
		float OV_1_Total= 0f;

        do {
    	System.out.println("Sistema Bancario:\n1-Abonar a una cuenta\n2-Retirar de una cuenta\n3-Ver saldo actual");
    	OV_1_res = OV_1_entrada.nextInt();
	switch(OV_1_res) {

	case 1:
		
		 System.out.println("Abonar a una cuenta");
		
		 System.out.println("Monto:");
		f = OV_1_entrada.nextFloat();
		OV_1_archivo.buscar("src/Usuario.Txt", OV_1_Saldo);
		 OV_1_Saldo=( f+ OV_1_Saldo);
		 OV_1_archivo.OV_1_escribirTextoArchivo("src/Usuario.Txt", OV_1_Saldo);

		System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
		OV_1_mien = OV_1_entrada.nextInt();
		break;
	
	
	case 2:
		
		 System.out.println("Retirar de una cuenta");
		
		 System.out.println("Monto: ");
		 f = OV_1_entrada.nextFloat();
		 
		 if (f < OV_1_Saldo){
			 OV_1_Saldo = (OV_1_Saldo-f); 
			 OV_1_archivo.OV_1_escribirTextoArchivo("src/Usuario.Txt", OV_1_Saldo );
			 System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
				OV_1_mien = OV_1_entrada.nextInt();
				break;
		 }
		 else
		 {
			 
			 System.out.println("No se puede realizar transaccion\n¿Desea realizar otra accion?\n1-si\n2-no");
				OV_1_mien = OV_1_entrada.nextInt();
				break;
		 }
	case 3:
		System.out.println("Mostrando Saldo actual");
		System.out.println(OV_1_archivo.OV_1_LeerTextoArchivo(("src/Usuario.Txt")));
		
		System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
		 OV_1_mien = OV_1_entrada.nextInt();
		break;
						
	default:
		System.out.println("opcion no valida"); 
		
		System.out.println("¿Desea realizar otra accion?\n1-si\n2-no");
		 OV_1_mien = OV_1_entrada.nextInt();
		break;
		
	
	} 
	}while (OV_1_mien==1);
	
    
System.out.println("---FIN DEL PROGRAMA---");
}


	}
	

