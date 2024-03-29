//=======================================================================
// FECHA: CREACIÓN: 20/08/09
// AUTOR: Camilo Verdugo
// Comentarios: TransferObject que es instanciado en la el componente RegistroUsuario
//				Luego es enviado por usuarioServices a la capa 2. Esta clase encapsula los atributos
//				De un usuario de sistema.
//=======================================================================
package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Usuario")]
	public class Usuario
	{
		
	
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;

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