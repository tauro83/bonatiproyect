package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.anuPeluqueria")]
	
	public class anuPeluqueria
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		
		public var rutCliente:String;
		public var nombreCliente:String;
		public var apellido:String;
		public var raza:String;
		public var sexo:String;
		public var nombreMascota:String;
		public var costo:String;
		public var servicio:String;
		public var hora:String;
		public var fecha:String;
		public var descripcion:String;
		public var estado:String;
	}
}
