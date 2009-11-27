//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Cristian Bravo 
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
	
	import transferObjects.aviWeb;
	
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Cristian Bravo
	 */
	 
	public class RegistroAvisoWebService extends RemoteObject
	{
		public function RegistroAvisoWebService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="RegistroAvisoWebService";
			this.source="AvisoWeb.RegistroAvisoWebService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en RegistroAvisoWebService, Detalle: "+event.fault.message);
		}
		
		/**
		 * Se obtienen todos los avisos que están registrados en la base de datos
		 */ 
		 
		public function getAllAvisoWeb():void
		{
			this.getOperation("getAllAvisoWeb").send();
		}
		
		/**
		 * Funcion que realiza la conexion para el registro de un aviso web
		 */ 
		
		public function registroAvisoWeb(aviso:aviWeb):void
		{
			this.getOperation("registroAvisoWeb").send(aviso);
		}
		
		/**
		 * Funcion que requiere obtener el Id de un aviso web.
		 */ 
		
		public function getUltimo():void
		{
			this.getOperation("getUltimo").send();
		}
		
	}
}