/**
 * @Author Jimmy Muñoz
 * @Version 1
*/
package transferObjects
{
	import mx.collections.ArrayCollection;
	
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Vacunacion")]
    
	public class Vacunacion
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
		public var estado:String;
		public var clienteNombre:String;
		public var clienteApellido:String;
		public var raza:String;
		public var sexo:String;
	}
}