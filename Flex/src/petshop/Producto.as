//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz
// Comentarios: TransferObject que es instanciado 
// 				al registrar editar o eliminar un aviso 
//=======================================================================

package petshop
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="Petshop.Producto")]
	/**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Erwin Díaz
    */
	public class Producto
	{
		public var nombre:String;
		public var precio:String;
		public var categoria:String;
		public var codigo:String;
		
	}
}