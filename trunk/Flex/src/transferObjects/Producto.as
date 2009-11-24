package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Producto")]
    
	public class Producto
	{

		
		public var nombre:String;
		public var categoria:String;
		public var codigo:String;
		public var precio:String;
		public var descripcion:String;
	}
}