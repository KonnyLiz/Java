package SB;

public class Usuario {

	public String NumeroCuenta;
	public String Usuario;
	public float Retiro;
	public String Contrase�a;
	public float Saldo;
	
	Usuario() {
		
	}
	
	public String getNumeroDeCuenta()
	{
		return this.NumeroCuenta="001";
	}
	
	public String getContrase�a()
	{
		return "admin";
	}
	
	public String getUsuario()
	{
		return "Oscar Vigil";
	}
	
	public void setSaldo(float sal)
	{
		this.Saldo=sal;
	}
	
	public float getSaldo()
	{
		return this.Saldo;
	}
	
}
