package clases;

public class reporteDescripciones {
int id;
String Descripcion;



/**
 * Constructor de la clase reporteDescripciones
 * @param id
 * @param descripcion
 */

public reporteDescripciones(int id, String descripcion) {
	super();
	this.id = id;
	Descripcion = descripcion;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripcion() {
	return Descripcion;
}
public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}



}
