//=======================================================================
// FECHA CREACIÓN: 24/11/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto de detalle de pago
//=======================================================================


package transferObjects{
	import flash.utils.ByteArray;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.DetallePago")]
	
	/**
	 * Clase utilizada para representar el objeto Hoteleria
	 *
	 * @author  Sebastian Arancibia
	 * @version 0.1, 24/11/09
	 */
	public class DetallePago{
		public var codigoProducto:String;
		public var cantidad:int;
		public var subtotal:int;
		public var fecha:Date;
		public var hora:String;
	}
}