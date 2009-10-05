package services{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.DiaAgenda;

	public class DiaAgendaServices extends RemoteObject{
		public function DiaAgendaServices(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			
			this.destination="DiaAgendaServices";
			this.source="Agenda.DiaAgendaServices";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DiaAgendaServices, Detalle: "+event.fault.message);
		}
		public function getDiaAgenda(fecha:String):void{
			this.getOperation("getDiaAgenda").send(fecha);
			//Alert.show("Manda: "+fecha);
		}
		
	}
}