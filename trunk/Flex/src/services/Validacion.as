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
		
		public static function sinNumero(nombre:String):Boolean
		{
			var correcta:Boolean = true;
			
			if(nombre.search("1")!=-1 || nombre.search("2")!=-1 || nombre.search("3")!=-1 || nombre.search("4")!=-1 || nombre.search("5")!=-1 || nombre.search("6")!=-1 || nombre.search("7")!=-1 || nombre.search("8")!=-1 || nombre.search("9")!=-1 || nombre.search("0")!=-1)
			{
				correcta = false;
			}
			
			else
			{
				correcta = true;
			}
			return correcta;
		}
		
		public static function Numero(numero:String):Boolean
		{
			var correcta:Boolean = true;
			
			if(numero.search("1")!=-1 || numero.search("2")!=-1 || numero.search("3")!=-1 || numero.search("4")!=-1 || numero.search("5")!=-1 || numero.search("6")!=-1 || numero.search("7")!=-1 || numero.search("8")!=-1 || numero.search("9")!=-1 || numero.search("0")!=-1)
			{
				correcta = true;
			}
			
			else
			{
				correcta = false;
			}
			return correcta;
		}		
	}
}