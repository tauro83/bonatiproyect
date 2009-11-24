package petshop
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class EliminarProductoService extends RemoteObject
	{
		public function EliminarProductoService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EliminarProductoService";
			this.source="Petshop.EliminarProductoService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EliminarProductoService, Detalle: "+event.fault.message);
		}
		

		public function eliminarProducto(rut:String):void
		{
			this.getOperation("eliminarProducto").send(rut);
		}
		
		/**
		 * Se obtienen todos los clientes que están registrados en la base de datos
		 */ 
		public function getProductosActivos():void
		{
			this.getOperation("getProductosActivos").send();
		}

	}
}