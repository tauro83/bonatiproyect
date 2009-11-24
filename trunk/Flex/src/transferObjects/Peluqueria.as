package transferObjects
{
	import mx.collections.ArrayCollection;
	[Bindable]
    [RemoteClass(alias="TransferObjects.Peluqueria")]
	public class Peluqueria
	{
		public var rutCliente:String;
		public var nombreMascota:String;
		public var responsable:String;
		public var servicio:String;
		public var fecha:Date;
		public var costo:String;
		public var hora:String;
		public var nombre:String;
		public var descripcion:String;
		public var tiposServicios:ArrayCollection;
		public var tiposNombres:ArrayCollection;

	}
}