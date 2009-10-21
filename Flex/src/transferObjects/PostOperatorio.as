package transferObjects{
	[Bindable]
    [RemoteClass(alias="TransferObjects.PostOperatorio")]
	public class PostOperatorio extends Atencion{
		public var medicamentos:String;
		public var alimentos:String;
		public var indicaciones:String;
		public var nombreMascota:String;
		public var nombreCliente:String;
		public var rut:String;
		public var apellidoDueño:String;
		public function PostOperatorio():void{
			
		}
	}
}