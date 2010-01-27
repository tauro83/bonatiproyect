//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package services
{	
	
	import TransferObjects.AvisoWeb;
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import util.host;
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
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AvisoWebService";
			this.source="WebAviso.AvisoWebService";
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
		 * Función que permite anular un aviso web
		 * @autor Erwin Díaz
		 */
		public function anulAviso(id:String):void
		{
			this.getOperation("anulAviso").send(id);
		}
		/**
		 * Función que permite eliminar un aviso web
		 * @autor Erwin Díaz
		 */
		public function delAviso(id:String):void
		{
			this.getOperation("delAviso").send(id);
		}
		/**
		 * Función que obtiene todos los avisos que están desactivados.
		 * @autor Erwin Díaz
		 */
		public function getAllAvisoWebA():void
		{
			this.getOperation("getAllAvisoWebA").send();
		}
		
		/**
		 * Se obtienen todos los usuarios que están registrados en la base de datos
		 * @autor Erwin Díaz
		 */ 
		public function getAllAvisoWeb():void
		{
			this.getOperation("getAllAvisoWeb").send();
		}
		/**
		 * Actualiza un aviso web
		 * @autor Erwin Díaz
		 */
 		public function upAvisoWeb(aviso:AvisoWeb):void
		{
			this.getOperation("upAvisoWeb").send(aviso);
		} 
		public function registrar(aviso:AvisoWeb):void
		{
			this.getOperation("registrar").send(aviso);
		}
	}
}