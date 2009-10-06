//@author Camilo Verdugo
package transferObjects
{
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Atencion")]
	public class Atencion
	{
		public var clienteRut:String;
		public var mascotaNombre:String;
		public var servicio:String;
		public var hora:String;
		public var fecha:String;
		public var costo:String;
	}

