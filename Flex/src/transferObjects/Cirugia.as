package transferObjects
{
	import mx.collections.ArrayCollection;
	import mx.controls.List;
	
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Cirugia")]
    
	public class Cirugia
	{
		public var clienteRut:String;
		public var clienteRut2:String;
		public var mascotaNombre:String;
		public var hora:String;
		public var fecha:String;
		public var costo:String;
		public var veterinario:String;
		public var ayudante:String;
		public var diagnostico:String;
		public var tiposCirugias:ArrayCollection;

	}
}