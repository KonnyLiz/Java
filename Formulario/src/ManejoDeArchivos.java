
import java.io.BufferedReader;  	 // Leer un conjunto amplio de caracteres
import java.io.File;				//Acceder a propiedades y metodos que afectan archivos
import java.io.FileNotFoundException;//Para manejar exepciones en el manejo de archivos
import java.io.FileReader;			//Leer un archivo
import java.io.FileWriter;			//Escribir un archivo
import java.io.IOException			;//Manejar exepciones de lectura y escritura de archivos

public class ManejoDeArchivos {

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
	
	
	//BUSCAR POR UNA PALABRA O FRASE EN UN ARCHIVO
public String buscar(String nombreArchivo,String palabra) throws IOException {
		
	    String texto = "";  //sirve para retornar el texto leido
	    FileReader archivo = null;  //Objeto que permite acceder al archivo
	    String linea = "";
	    try {
	      archivo = new FileReader(nombreArchivo);
	      
	      lector = new BufferedReader(archivo);
	      
	      while ((linea = lector.readLine()) != null) {
	    	
	    	  if(linea.indexOf(palabra)!=-1)
	    	  {
	    		  return linea;	    		  
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
	    return "No se encontro la palabra especificada";
	  }

//estadistica por edad
//hay que partir la linea en datos, usando split
public int estadistica(String nombreArchivo,int edad) throws IOException {
	
    String texto = "";  //sirve para retornar el texto leido
    FileReader archivo = null;  //Objeto que permite acceder al archivo
    String linea = "";
    int i=0;
    try {
      archivo = new FileReader(nombreArchivo);
      
      lector = new BufferedReader(archivo);
      
      while ((linea = lector.readLine()) != null) {
    	
    	  if(linea.indexOf(edad)!=-1)
    	  {
    		  i++;
    		  return i;	    		  
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


//ESCRIBIR TEXTO EN UN ARCHIVO
public void escribirTextoArchivo(String nombreArchivo, String texto)  {
	
	
    try {
    	File f = new File(nombreArchivo);
        FileWriter salida=new FileWriter(f,true);
              //  BufferedWriter escritor = new BufferedWriter(salida);
       salida.append(texto+'\n');
       salida.append('\n');
     
   
        salida.close(); 
    	
    	
    	
    
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
public void editar(String nombreArchivo, String parametro,String texto) {
	FileReader archivo=null;
	String linea="";
	String lineas="";
	try {
	     archivo = new FileReader(nombreArchivo);
		 lector = new BufferedReader(archivo);
		 //int cont=0;
		 
		 
	      while ((linea = lector.readLine()) != null) {
	    	  if(linea.indexOf(parametro)!=-1)
	    	  { 	  	    	  
	    		linea=texto;
	    	  }	
	    	  lineas += linea+"\n";
	    	  
	   } 
	    
	    
File f = new File(nombreArchivo);
    	
        FileWriter salida=new FileWriter(f,false);
        salida.append(lineas+'\n');
      
        salida.close(); 
	    } catch (IOException e) {
	      e.printStackTrace();
	    }	
	
}

}