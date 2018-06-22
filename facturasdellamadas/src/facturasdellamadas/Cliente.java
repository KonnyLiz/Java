package facturasdellamadas;

import java.io.IOException;
public class Cliente {

	public String NumeroLinea;	
	public String nombre;
	public String apellido;
	public int edad;



	Cliente (){
	}


	int estadisticasporedad(int edad) throws IOException
	{
	ManejoDeArchivos archivo=new ManejoDeArchivos();

	return archivo.estadistica("src/Cliente.txt", edad);

	}
	 
	 

	void setNumeroLinea(String num)
	{

		this.NumeroLinea=num;
	}


	void setNombre(String nom)
	{

		this.nombre=nom;
	}

	void setApellido(String apel){


	this.apellido=apel;
	}

	void setEdad(int edad)
	{

	this.edad=edad;
	}


	String getNumeroLinea(){
		return this.NumeroLinea;
	}

	String getnombre(){
		return this.nombre;
	}
	String getapellido(){
		return this.apellido;
	}
	int getedad(){
		return this.edad;
	}


	}
