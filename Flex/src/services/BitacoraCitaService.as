package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.BitacoraCita;

	public class BitacoraCitaService extends RemoteObject{
		public function BitacoraCitaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/DBConnectionServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BitacoraCitaService";
			this.source="Agenda.BitacoraCitaService";
			
			//this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en BitacoraCitaService, Detalle: "+event.fault.message);
		}
		public function getAllBitacoraCita():void{
			Alert.show("* GetAllBitacoraCita");
			this.getOperation("getAllBitacoraCita").send();
		}	
	}
}