package bonati;

public class RegistrarUsuario {

	
	public String echo(String message)
	{
		return "Hola:"+message;
	}
	
	public String toString(String nombre,String contraseņa,String cargo,String servicio,String lectura,String escritura){
		String var ="";
		
		var = nombre+""+contraseņa+""+cargo+""+servicio+""+""+lectura+""+escritura;		
		
		return var;
		
	}
	
}
