package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
		
	public class GetEstadisticasPeluqueria extends RemoteObject
	{
		
		public function GetEstadisticasPeluqueria()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetEstadisticas";
			this.source="Peluqueria.GetEstadisticas";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error obteniendoEstadisticas, Detalle: "+event.fault.message);
		}
		
		public function getEstadisticas(inicio:String,fin:String):void
		{
			//this.getOperation("obtenerEstadisticas").send();
			this.getOperation("obtenerEstadisticas").send(inicio,fin);
		}

	}
}