package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Person;

	public class PersonService extends RemoteObject
	{
		public function PersonService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PersonService";
			this.source="services.PersonService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PersonService, Detalle: "+event.fault.message);
		}
		
		public function insertPerson(person:Person):void
		{
			this.getOperation("insertPerson").send(person);
		}
		public function getAllPersons():void
		{
			this.getOperation("getAllPersons").send();
		}
		
		///////////////////////////////////////////////////////////////
		public function existLogin(login:Person):void
		{
			this.getOperation("existLogin").send(login);
		}
		
	}
}