package administracion
{
	
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class DeleteCitaService extends RemoteObject{
		
	
		public function DeleteCitaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="DeleteCitaService";
			this.source="Administracion.DeleteCitaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
			
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteCitaService, Detalle: "+event.fault.message);
		}
		public function purgarCita(cliente:String):void{
			this.getOperation("purgarCita").send(cliente);
		}

	}
		
		
}