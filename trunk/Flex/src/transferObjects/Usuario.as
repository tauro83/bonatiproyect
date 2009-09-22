package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.Usuario")]
	public class Usuario
	{
		public var nombre:String;
		public var apellidoPaterno:String;
		public var apellidoMaterno:String;
		public var usuario:String;
		public var cargo:String;
		public var contrasena:String;
		public var servicio:String;
		public var permisoRegistrar:Boolean;
		public var permisoEditar:Boolean;
		public var permisoEliminar:Boolean;
		public var permisoPurgar:Boolean;	
		
	}
}