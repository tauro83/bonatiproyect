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
			
			if(contrasena.length<3)
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
		
		/*public static function Email(email:String):Boolean
		{
		

         if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/.test(email)){
              return true;
		 }          
		 else {
		
		 return false;
		
		}
		}*/
		
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  04 Noviembre
			 * Metodo que verifica que el rut este ingresado correctamente.
			 * @param rut: el rut sin el digitoverificador. rutVer: digito verificador.
			 */
        	public static function validaRut(rut:String, rutVer:String):Boolean{
        		var Numero:String = rut;
        		var Dv:String = rutVer;
				var suma:int = 0;
				var rut:String = Numero;
				var NumMag:int = 2;
				var Resto:int = 0;
				var j:int ;
				var i:int;
				var DigVer:Array = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "K", "0");
				var ParteNumerica:Array = new Array();
				
				if (rut.length == 0) { 

				}
				for ( j =0, i =0; j < rut.length; j++){
					if (rut.charAt(j) != ' ' && rut.charAt(j) != '.' && rut.charAt(j) != '-'){
						ParteNumerica[i] = rut.charAt(i);
						++i;
					}
				}
				
				for (i=ParteNumerica.length-1; i>=0; i--, NumMag++){
					suma += ParteNumerica[i] * NumMag;
					trace(suma +' '+ ParteNumerica[i] +' '+ NumMag);
					if (NumMag>6){
						NumMag =1;	
					}	
				}
					
				Resto = 11-(suma%11);
				if(DigVer[Resto] != Dv.toUpperCase()){
					return false;
				}
				else{
					return true;
				}
		
        	}
		
	}
}