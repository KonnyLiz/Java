package empleados;
import java.io.BufferedReader;  	 // Leer un conjunto amplio de caracteres
import java.io.File;				//Acceder a propiedades y metodos que afectan archivos
import java.io.FileNotFoundException;//Para manejar exepciones en el manejo de archivos
import java.io.FileReader;			//Leer un archivo
import java.io.FileWriter;			//Escribir un archivo
import java.io.IOException			;//Manejar exepciones de lectura y escritura de archivos

public class Manejodearchivos {

	//LEER EL TEXTO DE UN ARCHIVO
	private BufferedReader lector;	
	public String leerTextoArchivo(String nombreArchivo) throws IOException {
		
	    String texto = "";  //sirve para retornar el texto leido
	    FileReader archivo = null;   //Objeto que permite acceder al archivo
	    String linea = "";
	    try {
	      archivo = new FileReader(nombreArchivo);
	      
	      lector = new BufferedReader(archivo);
	      
	      while ((linea = lector.readLine()) != null) {
	    	 	  	    	  
	        texto += linea + "\n";
	      }
	    } catch (FileNotFoundException e) {
	      throw new RuntimeException("Archivo no encontrado");
	    } catch (IOException e) {
	      throw new RuntimeException("Ocurrio un error de entrada/salida");
	    } finally {
	      if (archivo != null) {
	       
	          archivo.close();
	        
	      }
	    }
	    return texto;
	  }
	
	
//ESCRIBIR TEXTO EN UN ARCHIVO
public void escribirTextoArchivo(String nombreArchivo, String texto)  {

	  int n=0; 
	  FileReader archivo = null;  
	  String linea = "";
	  try {
	    archivo = new FileReader(nombreArchivo);
	    
	    lector = new BufferedReader(archivo);
	    
	    while ((linea = lector.readLine()) != null) {
	    	n+=1;
	    }
    	File f = new File(nombreArchivo);
        FileWriter salida=new FileWriter(f,true);
              //  BufferedWriter escritor = new BufferedWriter(salida);
       salida.append(n + " " + texto +'\n');
       salida.close(); 
  
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}