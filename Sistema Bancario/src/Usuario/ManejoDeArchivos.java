package Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoDeArchivos {
	
	private BufferedReader OV_1_lector;
	
	public String OV_1_LeerTextoArchivo(String OV_1_nombrearchivo) throws IOException {
		
		String OV_1_Texto= " ";
		FileReader OV_1_archivo= null;
		String OV_1_Linea= " ";
		try {
		      OV_1_archivo = new FileReader(OV_1_nombrearchivo);
		      
		      OV_1_lector = new BufferedReader(OV_1_archivo);
		      
		      while ((OV_1_Linea = OV_1_lector.readLine()) != null) {
		    	 	  	    	  
		        OV_1_Texto += OV_1_Linea + "\n";
		      }
		    } catch (FileNotFoundException e) {
		      throw new RuntimeException("Archivo no encontrado");
		    } catch (IOException e) {
		      throw new RuntimeException("Ocurrio un error de entrada/salida");
		    } finally {
		      if (OV_1_archivo != null) {
		       
		          OV_1_archivo.close();
		        
		      }
		    }
		    return OV_1_Texto;
		  }
		
		
	
	public void OV_1_escribirTextoArchivo(String OV_1_nombreArchivo, float g)  {

		  int n=0; 
		  FileReader OV_1_archivo = null;  
		  String OV_1_linea = "";
		  try {
		    OV_1_archivo = new FileReader(OV_1_nombreArchivo);
		    
		    OV_1_lector = new BufferedReader(OV_1_archivo);
		    
		    while ((OV_1_linea = OV_1_lector.readLine()) != null) {
		    	n+=1;
		    }
	    	File f = new File(OV_1_nombreArchivo);
	        FileWriter salida=new FileWriter(f,true);
	              //  BufferedWriter escritor = new BufferedWriter(salida);
	       salida.append(n + " " + g +'\n');
	       salida.close(); 
	  
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }

	public float buscar(String nombreArchivo,float sal) throws IOException {
		
	    String texto = ""; 
	    FileReader archivo = null;  
	    String linea = "";
	    try {
	      archivo = new FileReader(nombreArchivo);
	      
	      OV_1_lector = new BufferedReader(archivo);
	      
	      while ((linea = OV_1_lector.readLine()) != null) {
	    	
	    	  String[] m = linea.split(" ");
	    	  if(linea.indexOf(m[4])!=-1)
	    	  {
	    		  return m[4];	    		  
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

	}
	
	

