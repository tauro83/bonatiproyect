package bonati;

public class RegistrarUsuario {

	
	public String echo(String message)
	{
		return "Hola:"+message;
	}
	
	public String toString(String nombre,String contrase�a,String cargo,String servicio,boolean escritura){
		String var ="";
		
		var = nombre+""+contrase�a+""+cargo+""+servicio+""+""+escritura;		
		
		return var;
		
	}
	
}
