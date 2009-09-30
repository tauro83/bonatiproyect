package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;

	public class Cliente extends RemoteObject
	{
		public function Cliente()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/Bonati/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;

			this.destination="Cliente";
			this.source="bonati.Cliente";			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EchoService, Detalle: "+event.fault.message);
		}
		public function agregarCliente(nombre:String,apellido:String,apellido2:String,rut:String,rut2:String,telefono:String,telefono2:String,celular:String,celular2:String,direccion:String,region:String,comuna:String,email:String,email2:String):void
		{
			this.getOperation("toString").send(nombre,apellido,rut,rut2,telefono,telefono2,celular,celular2,direccion,region,comuna,email,email2);
		}
		
	}
}