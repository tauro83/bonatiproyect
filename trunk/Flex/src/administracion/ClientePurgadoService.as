//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR: Victor Silva
// Comentario: Clase que realiza la  conexion con la capa 2, para esto mapea
// una instancia de ClienteEliminado
//=======================================================================

package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	
	public class ClientePurgadoService extends RemoteObject
	{
		public function ClientePurgadoService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="ClienteEditService";
			this.source="Administracion.ClienteEditService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ClientePurgadoService, Detalle: "+event.fault.message);
		}
		

		public function purgarCliente(rut:String):void
		{
			this.getOperation("purgarCliente").send(rut);
		}
		
		public function reactivarCliente(rut:String):void
		{
			this.getOperation("reactivarCliente").send(rut);
		}
		/**
		 * Se obtienen todos los clientes que están registrados en la base de datos
		 */ 
		public function getClientesEliminados():void
		{
			this.getOperation("getClientesEliminados").send();
		}
	}
}