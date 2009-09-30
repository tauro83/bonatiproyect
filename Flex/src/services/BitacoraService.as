package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Bitacora;

	public class BitacoraService extends RemoteObject{
		public function BitacoraService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/DBConnectionServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BitacoraService";
			this.source="services.BitacoraService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en BitacoraService, Detalle: "+event.fault.message);
		}
		
		public function addBitacora(bitacora:Bitacora):void{
			this.getOperation("addBitacora").send(bitacora);
		}
		public function getAllBitacora():void{
			this.getOperation("getAllBitacora").send();
		}	
	}
}