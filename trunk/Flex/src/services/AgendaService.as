package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Agenda;

	public class AgendaService extends RemoteObject{
		public function AgendaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/DBConnectionServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AgendaService";
			this.source="services.AgendaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en AgendaService, Detalle: "+event.fault.message);
		}
		
		public function addAgenda(agenda:Agenda):void{
			this.getOperation("addAgenda").send(agenda);
		}
		public function getAgenda(fecha:String):void{
			this.getOperation("getAgenda").send(fecha);
		}
		
	}
}