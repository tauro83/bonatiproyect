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
	import util.host;
	
	public class ClienteEliminadoService extends RemoteObject
	{
		public function ClienteEliminadoService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="ClienteElimPurgService";
			this.source="Administracion.ClienteElimPurgService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ClienteEliminadoService, Detalle: "+event.fault.message);
		}
		

		public function eliminarCliente(rut:String):void
		{
			this.getOperation("eliminarCliente").send(rut);
		}
		
		/**
		 * Se obtienen todos los clientes que están registrados en la base de datos
		 */ 
		public function getClientesActivos():void
		{
			this.getOperation("getClientesActivos").send();
		}
	}
}