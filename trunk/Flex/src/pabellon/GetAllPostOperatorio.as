package pabellon{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	
	
	public class GetAllPostOperatorio extends RemoteObject{
		public function GetAllPostOperatorio(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetAllPostOperatorio";
			this.source="Administracion.GetAllPostOperatorio";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en pabellon.GetAllPostOperatorio, Detalle: "+event.fault.message);
		}
		public function getAllPostOperatoio():void{
			this.getOperation("getAllPostOperatorio").send();
		}

	}
}