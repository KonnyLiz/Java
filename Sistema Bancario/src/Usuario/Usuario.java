package Usuario; 
import java.io.IOException;
public class Usuario {

	
		
		public String OV_1_NumeroCuenta;
		public String OV_1_Abono;
		public String OV_1_Retiro;
		public String OV_1_Contraseña;
		public float OV_1_Saldo;
		
		Usuario() {
			
		}
		
		void setOV_1_Abono(String string)
		{
			this.OV_1_Abono=string;
			
			
		}
		void setOV_1_Apellido(String apell)
		{
			String ret = null;
			this.OV_1_Retiro=ret;
		}
			void setOV_1_NumeroCuenta(String NumCue)
			{
				this.OV_1_NumeroCuenta=NumCue;
			}
			void setOV_1_Contraseña(String Cont)
			{
				this.OV_1_Contraseña=Cont;
			}
			
			void setOV_1_Saldo(float Sal)
			{
				this.OV_1_Saldo=Sal;
			}
			
			String getOV_1_Nombre(){
				return this.OV_1_Abono;
			}
			String getOV_1_Apellido(){
				return this.OV_1_Retiro;
			}
			String getOV_1_NumeroCuenta(){
				return this.OV_1_NumeroCuenta;
			}
			String getOV_1_Contraseña(){
				return this.OV_1_Contraseña;
			}
			float getOV_1_Saldo(){
				return this.OV_1_Saldo;
			

			}

			public float getOV_1_Abono() {
				
				return 0;
			}

			public void setOV_1_Retiro(String getstring) {
				// TODO Auto-generated method stub
				
			}

			public float getOV_1_Retiro() {
				// TODO Auto-generated method stub
				return 0;
			}

			public float getOV_1_Saldo(String string) {
				// TODO Auto-generated method stub
				return 0;
			}

			public float getOV_1_Retiro(String string) {
				// TODO Auto-generated method stub
				return 0;
			}
	}