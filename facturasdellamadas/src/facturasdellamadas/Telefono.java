package facturasdellamadas;

public class Telefono {


	  private String Modelo;

	  private String SO;

	  private Integer A�o;

	    
	Telefono() {
	  }

	  public void AsignarVariables(String mo, String so, Integer anio) {
	  this.Modelo=mo;
	  this.SO=so;
	  this.A�o=anio;
	  
	  }

	  public String GetModelo() {
	  return this.Modelo;
	  }

	  public String GetSO() {
	  return this.SO;
	  }

	  public Integer GetAnio() {
	  return this.A�o;
	  }

	
}
