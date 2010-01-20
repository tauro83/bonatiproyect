//Veterinaria
package util
{
	import mx.collections.ArrayCollection;
	
	/**
	 * Permite verificar los tests que estan disponibles segun la configuración del archivo "properties/AvailableTests.xml"
	 **/
	public class PropiedadesCanil
	{
		[Embed(source="caniles.xml")]
		[Bindable]
		public static var settingClass:Class;
	
				
		/**
		 * Obtiene un mensaje segun el tipo, el lenguaje y el identificador especificado de los definidos en el xml 
		 **/
		 import mx.controls.Alert;
		public static function  getCaniles(key:String):String
		{
			try
			{
				var xml:XML = new XML(settingClass.data)
				for each (var _tipoPropiedad:XML in xml.tipos.tipoPropiedad)
				{
					if( _tipoPropiedad.@name == "Canil")
					{
						for each (var propiedad:XML in _tipoPropiedad.propiedades.propiedad)
						{
							if(propiedad.@key == key)
							{
								return propiedad.toString();
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