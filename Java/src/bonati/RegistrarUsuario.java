package bonati;

public class RegistrarUsuario {

	
	public String echo(String message)
	{
		return "Hola:"+message;
	}
	
	public String toString(String nombre,String contraseña,String cargo,String servicio,boolean escritura){
		String var ="";
		
		var = nombre+""+contraseña+""+cargo+""+servicio+""+""+escritura;		
		
		return var;
		
	}
	
}
