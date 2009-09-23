//=======================================================================
// FECHA: CREACIÓN: 20 Septiembre
// AUTOR: Camilo Verdugo
// Comentarios: Clase que comprueba los campos de los formularios.
//=======================================================================

package services
{
	import mx.messaging.channels.StreamingAMFChannel;
	
	/**
	 * 	@author  "Camilo Verdugo"
	 * 	@Fecha  20 Septiembre
	 *  @Descripcion Clase que contiene metodos estaticos que validan distantas valores para los atributos
	 * 				 de las entradas de texto
	*/
	public class Validacion
	{		
		
		/**
	 	 * 	@author  "Camilo Verdugo"
		 * 	@Fecha  20 Septiembre
		 *  @Descripcion Metodo que comprueba la no existencia de espacios en blancos intermedios		 		
		 * */
		public static function espaciosEnBlanco(palabra:String):Boolean
		{						
			if(palabra.search(" ")==-1)
			{
					return true;
			}
			return false;
		}
		
		/**
	 	 * 	@author  "Camilo Verdugo"
		 * 	@Fecha  20 Septiembre
		 *  @Descripcion Metodo que comprueba que el parametro tenga una logitud mayor a 4 caracteres	 		
		 * */
		public static function longitudMinima(palabra:String):Boolean
		{
			if(palabra.length>4)
			{
				return true;
			}
			return false;
		}
		
		
		/**
	 	 * 	@author  "Camilo Verdugo"
		 * 	@Fecha  20 Septiembre
		 *  @Descripcion Metodo que comprueba que el parametro tenga una logitud mayor a 4 caracteres
		 * 					y que no contenga espacios en blanco	 		
		 * */
		public static function contrasena(contrasena:String):Boolean
		{
			var correcta:Boolean = true;
			
			if(contrasena.search(" ")!=-1)
			{
				correcta = false;
			}
			
			if(contrasena.length<4)
			{
				correcta = false;
			}
			return correcta;
		}
		
				
	}
}