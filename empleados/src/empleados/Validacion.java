package empleados;
import java.util.Scanner;
public class Validacion {

	Scanner sc;
	
	Validacion()
	{
		sc = new Scanner(System.in);
	}
	
public String getstring(String s1)
{
	int e=1;
	do{
	if (s1.matches("^[A-Za-z ]*$"))
		{
		e=7;
			return s1;
		}
	 System.out.println("Ingrese caracteres validos");
	s1 = sc.nextLine();
	}while(e==1);
	return "";
}
	
public String getint(String s1)
{
	int e=1;
	do{
	if (s1.matches("[0-9]*"))
		{
		e=7;
			return s1;
		}
	 System.out.println("Ingrese caracteres validos");
	s1 = sc.next();
	}while(e==1);
	return "";
}

public String getfloat(String s1)
{
	int e=1;
	do{
	if (s1.matches("[:dígito:]+"))
		{
		e=7;
			return s1;
		}
	 System.out.println("Ingrese caracteres validos");
	s1 = sc.next();
	}while(e==1);
	return "";
}
	
}
