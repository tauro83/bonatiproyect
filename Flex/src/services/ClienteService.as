package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cliente;

	public class ClienteService extends RemoteObject
	{
		public function ClienteService(destination:String=null)
		{
			super(destination);
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCliente";
			this.source="Administracion.AddCliente";	
			
			
			
		}
		
		public function regCliente(user:Cliente):void{
			
		    this.getOperation("AddCliente").send(user);
		
		}
		
	}
}


////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
