package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;

	public class BusquedaService extends RemoteObject
	{
		public function BusquedaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/DBConnectionServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BusquedaService";
			this.source="services.BusquedaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en BusquedaService, Detalle: "+event.fault.message);
		}
		
		public function getAllUsuarios():void
		{
			this.getOperation("getAllUsuarios").send();
		}
		
		public function getAllClientes():void
		{
			this.getOperation("getAllClientes").send();
		}
		
	}
}