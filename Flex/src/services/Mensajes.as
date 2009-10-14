package services
{
	import mx.messaging.channels.StreamingAMFChannel;
    import mx.collections.ArrayCollection;

	public class Mensajes
	{
		
		
		public static function getMensajePopup(index:int):String
		{
			 var popup:Array = new Array(
				 "asdsa"
			 );
			 return popup[0];
		}
		
		public static function getMensajeError(index:int):String
		{
			 var error:Array = new Array(
				 "Corrija los datos antes de registrar",
				 "Ingrese un nombre más largo",
				 "Ingrese un nombre de usuario más largo",
				 "Ingrese una contraseña sin espacios en blanco y más larga",
				 "Ingrese una contraseña que coincida con la anterior",
				 "Ingrese un apellido paterno más largo",
				 "Usuario previamente registrado, elija otro nombre de usuario"
			 );
			 return error[index];
		}
		
		public static function getMensajeToolTip(index:int):String
		{
			 var toolTip:Array = new Array(
				 "a",
				 "b",
				 "c"
			 );
			 return toolTip[index];
		}

	}
}