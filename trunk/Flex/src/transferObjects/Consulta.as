package transferObjects
{
	
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Consulta")]
    
	public class Consulta
	{
	//****************************
	public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
	//****************************
		public var rut:String;
		public var nombre:String;
		public var responsable:String;
		public var servicio:String;
		public var fecha:String;
		public var hora:String;	
		public var anamnesis:String;
		public var costo:String;
		public var estado:int;

	}
}