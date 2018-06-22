package SB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ManejoDeArchivos {
	private BufferedReader lector;	
	public void escribirTextoArchivo(String nombreArchivo, String texto)  {
		FileReader archivo=null;
		String linea="";
		String lineas="";
		try {
		     archivo = new FileReader(nombreArchivo);
			 lector = new BufferedReader(archivo);
			 lineas=texto;
		    
	File f = new File(nombreArchivo);
	    	
	        FileWriter salida=new FileWriter(f,false);
	        salida.append(lineas+'\n');
	      
	        salida.close(); 
		    } catch (IOException e) {
		      e.printStackTrace();
		    }	
		
	}

		    	 
public float buscar(String nombreArchivo) throws IOException {
		
	    String texto = "";
	    FileReader archivo = null;
	    String linea = "";
	    try {
	      archivo = new FileReader(nombreArchivo);
	      
	      lector = new BufferedReader(archivo);
	      
	      while ((linea = lector.readLine()) != null) {
	    	  String[] f = linea.split(" ");
	    	  if(linea.indexOf(f[1])!=-1)
	    	  {
	    		  String h=f[1];
	    		  return Float.parseFloat(h) ;	    		  
	    	  }
	    	 
	        //texto += linea + "\n";
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
	    return 0;
	  }

public String leerTextoArchivo(String nombreArchivo) throws IOException {
	
    String texto = ""; 
    FileReader archivo = null; 
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

}
