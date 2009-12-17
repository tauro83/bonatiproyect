package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	
	public class PurgarConsultaService extends RemoteObject
	{
		public function PurgarConsultaService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PurgarConsultaService";
			this.source="Pabellon.PurgarConsultaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PurgarConsulta Service, Detalle: "+event.fault.message);
		}


			/**
		 * @author "Victor Silva
		 * @Fecha 	27 Octubre
		 * @param Consulta es una instancia del transferObject Consulta, instanciado en la capa logica.
		 * @param purgarConsulta es el metodo de la clase PurgarConsultaService de la capa logica.
		 * */
		public function anularConsulta(hora:String,fecha:String,servicio:String):void
		{
			this.getOperation("anularConsulta").send(hora,fecha,servicio);
		}
	}
}