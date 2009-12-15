//Veterinaria
package util
{
	import mx.collections.ArrayCollection;
	
	/**
	 * Permite verificar los tests que estan disponibles segun la configuración del archivo "properties/AvailableTests.xml"
	 **/
	public class Properties
	{
		[Bindable][Embed(source="properties.xml")]
		[Bindable]public static var settingClass:Class;
		 
		
		/**
		 * Obtiene un mensaje segun el tipo, el lenguaje y el identificador especificado de los definidos en el xml 
		 **/
		public static function  getMensaje(tipoMensaje:String,key:String):String
		{
			try
			{
				var xml:XML = new XML(settingClass.data)
				for each (var _tipoMensaje:XML in xml.tipos.tipoMensaje)
				{
					if( _tipoMensaje.@name == tipoMensaje)
					{
						for each (var mensaje:XML in _tipoMensaje.mensajes.mensaje)
						{
							if(mensaje.@key == key)
							{
								return mensaje.toString();
							}
						} 
					}
				}
			}
			catch(e:Error)
			{
				throw new Error("Error leyendo la funcion getMessage \n Detail:\n"+e.message);
			}
			return "Mensaje No encontrado";
		}

	}
}