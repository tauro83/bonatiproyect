//=======================================================================
// FECHA CREACIÓN: 24/10/09
// AUTOR: Erwin Díaz
// Comentarios: TransferObject que es instanciado 
// en la el componente Catálogo de Peluquería
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.CatPeluqueria")]
	/**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Erwin Díaz
    */
	public class CatPeluqueria
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		public var servicio:String;
		public var nombre:String;
		public var precio:String;
		public var descripcion:String;
	}
}