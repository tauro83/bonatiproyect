package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Mascota;
	
	
	public class EditarMascotaService extends RemoteObject
	{
		public function EditarMascotaService()
		{
		
		    super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarMascotaService";
			this.source="Administracion.EditarMascotaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		
		}
		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarMascotaService, Detalle: "+event.fault.message);
		}
		
		public function insertMascotaE(person:Mascota):void
		{
			this.getOperation("insertMascotaE").send(person);
		}
		public function getAllMascotasE():void
		{
			this.getOperation("getAllMascotasE").send();
		}
		public function getMascota(rut:String):void
		{
			this.getOperation("getMascota").send(rut);
		}

	}
}