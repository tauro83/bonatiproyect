//=======================================================================
// FECHA CREACIÓN:  05/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
// Y la direccion en la cual esta levantado la capa 2.
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.BitacoraCita;

	/**
	 * Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
	 * Y la direccion en la cual esta levantado la capa 2.
	 * @author Sebastian Arancibia
	 * @version 05/10/2009
	 * @langversion ActionScript 3.0
	*/
	public class BitacoraCitaService extends RemoteObject{
		
		/**
		 *  Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
		 *  Y la direccion en la cual esta levantado la capa 2.
	 	 * 	@author  Sebastian Arancibia	 		
		 * */
		public function BitacoraCitaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BitacoraCitaService";
			this.source="Agenda.BitacoraCitaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 *   Metodo que en caso de error, muestra en a traves de 
		 *  un popup, esto se debe a que estos son errores de sistema, por lo 
		 *  tanto es necesario informarlo de otra forma.
	 	 * 	@author  Sebastian Arancibia
	 	 * 	@param event Evento de posible error en comunicacion con capa 2	 		
		 * */
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en BitacoraCitaService, Detalle: "+event.fault.message);
		}
		/**
		 * Metodo que solicita a la capa 2 los datos de todos las mascotas
		 * @author  Sebastian Arancibia
		 **/
		public function getAllBitacoraCita():void{
			this.getOperation("getAllBitacoraCita").send();
		}	
	}
}