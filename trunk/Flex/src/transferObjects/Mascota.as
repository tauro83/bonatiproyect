//=======================================================================
// FECHA CREACIÓN: 10/09/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto mascota
//=======================================================================


package transferObjects{
	[Bindable]
    [RemoteClass(alias="TransferObjects.Mascota")]
	
	/**
	 * Clase utilizada para representar el objeto Mascota
	 *
	 * @author  Sebastian Arancibia
	 * @version 0.1, 22/09/09
	 */
	public class Mascota{
		public var id:String;
		public var rutCliente:String;
		public var nombre:String;
		public var fechaNacimiento:String;
		public var claseAnimal:String;
		public var raza:String;
		public var sexo:String;
	}
}