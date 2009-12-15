package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.aviWeb")]
	
	 /**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Nicolas Delgado
    */
	public class aviWeb
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		
		public var id:int; 
		public var nombre:String; 
		public var apaterno:String; 
		public var telefono0:String; 
		public var telefono:String; 
		public var celular:String;
		public var celular0:String;
		public var asunto:String; 
		public var descripcion:String; 
		public var responsable:String; 
		public var estado:int;
	}
}
