package services
{
	import mx.messaging.channels.StreamingAMFChannel;
	
	public class Validacion
	{		
		
		public static function espaciosEnBlanco(palabra:String):Boolean
		{			
			
			if(palabra.search(" ")==-1){
					return true;
			}
			return false;
		}
		
		public static function longitudMinima(palabra:String):Boolean
		{
			if(palabra.length>4){
				return true;
			}
			return false;
		}
		
		
		/*
			Comprueba:  Longitud mayor a 4
						Sin espacios en blanco
		*/
		public static function contrasena(contrasena:String):Boolean
		{
			var correcta:Boolean = true;
			
			if(contrasena.search(" ")!=-1){
				correcta = false;
			}
			
			if(contrasena.length<4){
				correcta = false;
			}
			return correcta;
		}
		
				
	}
}