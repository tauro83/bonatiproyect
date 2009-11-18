//=======================================================================
// FECHA: CREACIÓN: 07/11/09
// AUTOR: Andrés Garrido
// Comentarios: Clase que establece la conexion con la capa logica y
// que elimina un registro en hoteleria
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	/** 
	 *  Clase que gesitiona la conexion. Mediante el constructor
	 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/
	public class EliminarHoteleriaService extends RemoteObject{
		
		/**
		 * Constructor de la clase, la cual indica que se conectara con el package Administracion
		 * conectándolas para enviar y/o recibir información
		 */	
		public function EliminarHoteleriaService(){
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EliminarHoteleriaService";
			this.source="Administracion.EliminarHoteleriaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event reaccion ante un error en la conexion con la capa 2
		 * se maneja este error por medio de un POPUP 
		 */		
		public function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EliminarMascotaService, detalle: "+event.fault.message);
		}
		
		/**
		 * @param fechaIngreso Fecha de ingreso de la mascota al hotel
 		 * @param fechaSalida Fecha de salida de la mascota al hotel
 		 * @param canil Numero del canil donde esta alojada la mascota
		 * Método que elimina (retira) una mascota de hotelería, dados la fecha de ingreso,
		 * la de la salida y el canil.
		 */		
		public function eliminarHoteleria(fechaIngreso:Date, fechaSalida:Date, canil:int):void{
			this.getOperation("eliminarHoteleria").send(fechaIngreso, fechaSalida, canil);
		}
	}
}