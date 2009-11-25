//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package avisoWeb
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
	public class AvisoWebService extends RemoteObject
	{
		public function AvisoWebService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AvisoWebService";
			this.source="Peluqueria.AvisoWebService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AvisoWebService, Detalle: "+event.fault.message);
		}
		/**
		 * Se obtienen todos los usuarios que están registrados en la base de datos
		 */ 
		public function getAllAvisoWeb():void
		{
			this.getOperation("getAllAvisoWeb").send();
		}
		public function upAvisoWeb(aviso:AvisoWeb):void
		{
			this.getOperation("upAvisoWeb").send(aviso);
		}
	}
}