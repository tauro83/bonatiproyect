//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz
// Comentarios: TransferObject que es instanciado 
// 				al registrar editar o liminar un aviso 
//=======================================================================

package avisoWeb
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.AvisoWeb")]
	/**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Erwin Díaz
    */
	public class AvisoWeb
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		public var nombre:String;
		public var telefono0:String;
		public var telefono:String;
		public var celular:String;
		public var celular0:String;
		public var asunto:String;
		public var descripcion:String;
	}
}