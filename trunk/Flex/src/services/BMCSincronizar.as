package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Cliente;

	public class BMCSincronizar extends RemoteObject
	{
		public function BMCSincronizar()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BMC";
			this.source="BMC.BMC";	
		}
		
		public function conectar():void
		{			
		    this.getOperation("obtenerReporteDiario").send();
		
		}
		
	}
}
