//=======================================================================
// FECHA: CREACIÓN: 07/11/09
// AUTOR: Andrés Garrido
// Comentarios: TransferObject homólogo al existente en la capa 2
//=======================================================================

package transferObjects{
	import mx.messaging.channels.StreamingAMFChannel;
	

	[Bindable]
    [RemoteClass(alias="TransferObjects.Alojamiento")]
    
    /**
	 * Clase que encapsula los datos de un alojamiento en hoteleria, 
	 * esta clase posee una equivalente en la capa 2 de tal forma 
	 * que se pueda hacer una mapeo directo desde las capas.
	 */  
	public class Alojamiento{
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
	}
}