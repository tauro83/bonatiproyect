package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Usuario;

	public class UsuarioEditService extends RemoteObject
	{
		public function UsuarioEditService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="UsuarioEditService";
			this.source="Administracion.UsuarioEditService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en UsuarioEditService, Detalle: "+event.fault.message);
		}
		
		public function insertUsuarioE(person:Usuario):void
		{
			this.getOperation("insertUsuarioE").send(person);
		}
		public function getAllUsuariosE():void
		{
			this.getOperation("getAllUsuariosE").send();
		}
		
	}
}