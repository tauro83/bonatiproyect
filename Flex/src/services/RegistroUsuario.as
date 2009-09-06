package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class RegistroUsuario extends RemoteObject
	{
		public function RegistroUsuario()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/Bonati/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;

			this.destination="RegistrarUsuario";
			this.source="bonati.RegistrarUsuario";			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EchoService, Detalle: "+event.fault.message);
		}
		public function addUsuario(nombre:String,contraseña:String,cargo:String,servicio:String,lectura:String, escritura:String):void
		{
			this.getOperation("toString").send(nombre,contraseña,cargo,servicio, lectura, escritura);
		}
		
		public function echo(nombre:String):void
		{
			this.getOperation("echo").send(nombre);
		}
		
	}
}