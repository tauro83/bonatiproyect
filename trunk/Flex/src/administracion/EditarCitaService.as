package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cita;
	
	
	public class EditarCitaService extends RemoteObject
	{
		public function EditarCitaService()
		
		{
		
		    super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarCitaService";
			this.source="Administracion.EditarCitaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		
		}
		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarCitaService, Detalle: "+event.fault.message);
		}
		
		public function insertCitaE(person:Cita):void
		{
			this.getOperation("insertCitaE").send(person);
		}
		public function getAllCitasE():void
		{
			this.getOperation("getAllCitasE").send();
		}
		public function getCita(rut:String):void
		{
			this.getOperation("getCita").send(rut);
		}

	}
}