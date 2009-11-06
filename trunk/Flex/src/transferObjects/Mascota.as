//=======================================================================
// FECHA CREACIÓN: 10/09/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto mascota
//=======================================================================


package transferObjects{
	import flash.utils.ByteArray;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Mascota")]
	
	/**
	 * Clase utilizada para representar el objeto Mascota
	 *
	 * @author  Sebastian Arancibia
	 * @version 0.1, 22/09/09
	 */
	public class Mascota{
		/** Rut del dueno de la mascota*/
		public var rutCliente:String;
		
		/** Nombre de la mascota*/
		public var nombre:String;
		
		/** Feca de nacimiento de la mascota*/
		public var fechaNacimiento:String;
		
		/** Especie de la mascota*/
		public var claseAnimal:String;
		
		/** Raza de la mascota*/
		public var raza:String;
		
		/** Sexo de la mascota*/
		public var sexo:String;
		
		/** Estado de la mascota en el sistema*/
		public var estado:Boolean;
	}
}