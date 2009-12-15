//=======================================================================
// FECHA CREACIÓN: 24/11/09
// AUTOR: Cristian Bravo 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package petShop
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Cristian Bravo
	 */
	public class EditarPagoService extends RemoteObject
	{
		public function EditarPagoService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarPagoService";
			this.source="petShop.EditarPagoService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarPagoService, Detalle: "+event.fault.message);
		}
		/**
		 * Se obtienen todos los pagos que están registrados en la base de datos
		 */ 
		public function getAllPagos():void
		{
			this.getOperation("getAllPagos").send();
		}
		public function upEditarPago(pago:EditarPago):void
		{
			this.getOperation("upEditarPago").send(pago);
		}
		
	}
}