package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.vacunacionesObj")]
	
	public class vacunacionesObj
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		
		public var nombreCliente:String;
		public var apellidoPaterno:String;
		public var rutCliente:String;
		public var nombreMascota:String;
		public var tipo:String;
		public var veterinario:String;
		public var sexo:String;
		public var servicio:String;
		public var hora:String;
		public var fechaVacu:String;
		public var raza:String;
		public var descripcion:String;
		public var estado:String;
	}
}