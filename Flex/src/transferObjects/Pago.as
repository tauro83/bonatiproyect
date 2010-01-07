//=======================================================================
// FECHA: CREACIÓN: 23/11/09
// AUTOR: Erwin Díaz
// Comentarios: Transfiere los datos de un pago entre la capa lógica 
//				y la base de datos
//=======================================================================
package transferObjects
{
	import mx.collections.ArrayCollection;
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Pago")]
	public class Pago
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		public var fecha:String;
		public var hora:String;
		public var total:int;
		public var detalle:ArrayCollection;
		public var fechaPago:Date;
		
	}
}