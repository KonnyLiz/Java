package empleados;
import java.io.IOException;
import java.util.Random;

public class Empleado {

	public String NumeroLinea;	
	public String nombre;
	public String apellido;
	public String edad;
	public float salario;


	Empleado (){
	}
	 
	void setnombre(String nom)
	{

		this.nombre=nom;
	}
	
	void setsalario(float sal)
	{
		this.salario=sal;
	}
	
	void setapellido(String apel){


	this.apellido=apel;
	}

	void setedad(String edad)
	{

	this.edad=edad;
	}

	String getnombre(){
		return this.nombre;
	}
	String getapellido(){
		return this.apellido;
	}
	String getedad(){
		return this.edad;
	}
	float getsalario(){
		return this.salario;
	}
	
	
}
