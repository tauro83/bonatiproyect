//=======================================================================
// FECHA CREACIÓN: 02/12/09
// AUTOR: Erwin Díaz
// Comentarios: Clase que se encarga de realizar la conexion entre la capa
// 				lógica y la interfaz
//=======================================================================

package modbitacora
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Erwin Díaz
	 */
	public class bitacoraService extends RemoteObject
	{
		public function bitacoraService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BitacoraService";
			this.source="Bitacora.BitacoraService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @autor Erwin Díaz
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en bitacoraService, Detalle: "+event.fault.message);
		}
		
		/**
		* Este metodo se encar de obtener todos los registro que se encuentran anulados en 
		* la base de datos.
		* @autor Erwin Díaz
		*/ 
		public function getAllEventos():void
		{
			this.getOperation("getAllEventos").send();
		}
	}
}
