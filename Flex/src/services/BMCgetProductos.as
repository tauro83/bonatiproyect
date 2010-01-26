// ActionScript file
package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;	
	
	import util.host;
	
	public class BMCgetProductos extends RemoteObject
	{
		public function BMCgetProductos()
		{			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EliminarProductoService";
			this.source="Petshop.EliminarProductoService";
		}
		
		public function getProductos():void
		{
			this.getOperation("getProductosActivosTipo").send();
		}
	}
}