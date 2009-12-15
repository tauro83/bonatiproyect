//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Esteban Cruz
// DESCRIPCION: TransferObject que se encarga de recibir los datos
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Producto")]
    
	public class Producto
	{
		public var nombre:String;
		public var categoria:String;
		public var codigo:String;
		public var precio:String;
		public var descripcion:String;
	}
}