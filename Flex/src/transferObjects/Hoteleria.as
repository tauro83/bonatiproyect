//=======================================================================
// FECHA CREACIÓN: 10/09/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto hoteleria
//=======================================================================


package transferObjects{
	import flash.utils.ByteArray;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Hoteleria")]
	
	/**
	 * Clase utilizada para representar el objeto Hoteleria
	 *
	 * @author  Sebastian Arancibia
	 * @version 0.1, 22/09/09
	 */
	public class Hoteleria{
		public var servicio:String;
		public var hora:String;
		public var fechaIngreso:Date;
		public var costo:String;
		public var responsable:String;
		public var cliente:String;
		public var mascota:String;
		public var canil:int;
		public var fechaSalida:Date;
		public var comentario:String;
		public var diasEstadia:int;
		public var eliminado:Boolean;
		
		//DatosParaEdicion
		public var nuevaFechaIngreso:Date;
		public var nuevaFechaSalida:Date;
		public var nuevoCanil:int;
	}
}