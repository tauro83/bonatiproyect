package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;	
	import transferObjects.Usuario;
	
	public class usuarioServices extends RemoteObject
	{
		public function usuarioServices()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="Administracion";
			this.source="logica.Administracion";			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ContactService, Detalle: "+event.fault.message);
		}
		
		
		public function nuevo(user:Usuario):void
		{
			//Alert.show("Detalle: "+user.nombre);
			//this.getOperation("toString").send(user);
			
			this.getOperation("addUsuario").send(user);
			
			//this.getOperation("toString").send(user);
		}
		
	}
}