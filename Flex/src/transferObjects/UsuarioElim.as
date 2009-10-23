//=======================================================================
// FECHA CREACIÓN: 20/09/09 
// AUTOR: Erwin Díaz
// Comentario: Se declara la clase usuario, una vez instanciada 
// representa el objeto de transferencia entre la capa lógica
// y la interfaz gráfica
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Person")]
    
    /**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Erwin Díaz
    */
	public class UsuarioElim
	{
		public var checkbox:CheckBox = new CheckBox;
		public var nombre:String;
		public var apellido:String;
		public var cargo:String;
		public var usuario:String;
		public var servicio:String;
		public var registrar:String;
		public var editar:String;
		public var eliminar:String;
		public var purgar:String;
		
		public var sel:Boolean;
		
	}
}