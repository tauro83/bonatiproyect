/**
 * @Author Jimmy Muñoz
 * @Version 1
*/
package transferObjects
{
	import mx.collections.ArrayCollection;
	import mx.controls.List;
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Cirugia")]
    
	public class Cirugia
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
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
		public var estado:String;
		public var clienteNombre:String;
		public var clienteApellido:String;
		public var mascotaRaza:String;
		public var mascotaSexo:String;
		public var servicio:String;
	}
}