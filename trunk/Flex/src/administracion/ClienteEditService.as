package administracion
{
	
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cliente;

	public class ClienteEditService extends RemoteObject
	{
       
       	public function ClienteEditService()
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
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ClienteEditService, Detalle: "+event.fault.message);
		}
		
		public function insertClienteE(person:Cliente):void
		{
			this.getOperation("insertClienteE").send(person);
		}
		public function getAllClientesE():void
		{
			this.getOperation("getAllClientesE").send();
		}
	}
}