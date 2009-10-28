package transferObjects
{
	import mx.collections.ArrayCollection;
	
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Vacuna")]
    
	public class Vacuna
	{
		public var clienteRut:String;
		public var mascotaNombre:String;
		public var hora:String;
		public var fecha:Date;
		public var fechaCaducidad:Date;
		public var costo:String;
		public var veterinario:String;
		public var descripcion:String;
		public var tiposVacunas:ArrayCollection;

	}
}