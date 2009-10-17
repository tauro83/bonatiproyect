//=======================================================================
// FECHA CREACIÓN: 14-10-09
// AUTOR: Esteban Cruz
// Comentario: Se declara la clase cirugia, una vez instanciada 
// representa el objeto de transferencia entre la capa lógica
// y la interfaz gráfica
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.CirugiaPurg")]
    
    /**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Esteban Cruz
    */
	public class CirugiaPurg
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		
		public var nombreCliente:String;
		public var apellidoPaterno:String;
		public var rutCliente:String;
		public var nombreMascota:String;
		public var tipo:String;
		public var veterinario:String;
	}
}