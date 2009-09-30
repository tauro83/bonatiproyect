package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.Person")]
	public class Bitacora
	{
		public var usuario:String;
		public var accion:String;
		public var fechaAccion:String;
		public var horaAccion:String;
		public var fechaCita:String;
		public var horaCita:String;
		public var cliente:String;
		public var mascota:String;
	}
}