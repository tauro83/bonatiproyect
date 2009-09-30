package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Mascota2;

	public class EditFichaService extends RemoteObject
	{
		public function EditFichaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditFichaService";
			this.source="Administracion.EditFichaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en UsuarioEditService, Detalle: "+event.fault.message);
		}
		
		/*public function insertFichaE(nueva:Mascota):void
		{
			this.getOperation("insertFichaE").send(nueva);
		}*/
		public function getAllUsuariosE():void
		{
			this.getOperation("getMascotaE").send();
		}
		
	}
}