//=======================================================================
// FECHA CREACIÓN: 23/11/09
// AUTOR: Erwin Díaz 
// Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package petshop
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
	 * @autor Erwin Díaz
	 */
	public class ElimPagoService extends RemoteObject
	{
		public function ElimPagoService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="ElimPagoService";
			this.source="Petshop.ElimPagoService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ElimPagoService, Detalle: "+event.fault.message);
		}
		/**
		 * @param clave String que se le entrega a la acapa lógica para eliminar un pago
		 */ 
		public function deletePagoH(fecha:String, hora:String):void
		{
			this.getOperation("deletePagoH").send(fecha, hora);
		}
		/**
		 * @param clave String que se le entrega a la acapa lógica para eliminar un pago
		 */ 
		public function deletePago(fecha:String, hora:String):void
		{
			this.getOperation("deletePago").send(fecha, hora);
		}
		/**
		 * Se obtienen todos los pagos que están registrados en la base de datos
		 */ 
		public function getAllPagos():void
		{
			this.getOperation("getAllPagos").send();
		}
		/**
		 * Se obtienen todos los pagos que están registrados en la base de datos
		 */ 
		public function getAllPagosE():void
		{
			this.getOperation("getAllPagosE").send();
		}
		
	}
}
