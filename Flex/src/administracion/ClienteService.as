package services
{
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cliente;
	
	import util.host;

	public class ClienteService extends RemoteObject
	{
		public function ClienteService(destination:String=null)
		{
			super(destination);
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCliente";
			this.source="Administracion.AddCliente";	
		}
		
		public function regCliente(user:Cliente):void
		{
			
		    this.getOperation("AddCliente").send(user);
		
		}
		
		public function consultarCli(user:Cliente):void
		{
			this.getOperation("ConsultarCli").send(user);
		}
	}
}

