package Usuario;
import java.util.Scanner;
public class Validacion {

	Scanner OV_1_sc;
	
	Validacion ()
	{
		OV_1_sc= new Scanner(System.in);
	}
		
		public String getstring(String OV_1_s1)
		{
			int e=1;
			do{
			if (OV_1_s1.matches("^[0-9]*$"))
				{
				e=7;
					return OV_1_s1;
				}
			 System.out.println("Ingrese caracteres validos");
			OV_1_s1 = OV_1_sc.nextLine();
			}while(e==1);
			return "";
		}
			
		public String getint(String OV_1_s1)
		{
			int e=1;
			do{
			if (OV_1_s1.matches("[0-9]*"))
				{
				e=7;
					return OV_1_s1;
				}
			 System.out.println("Ingrese caracteres validos");
			OV_1_s1 = OV_1_sc.next();
			}while(e==1);
			return "";
		}

		public String getfloat(String OV_1_s1)
		{
			int e=1;
			do{
			if (OV_1_s1.matches("[0-9]*\\."))
				{
				e=7;
					return OV_1_s1;
				}
			 System.out.println("Ingrese caracteres validos");
			OV_1_s1 = OV_1_sc.next();
			}while(e==1);
			return "";
		}
			
		

		
	}
	

