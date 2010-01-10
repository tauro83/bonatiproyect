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
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param Consulta es una instancia del transferObject Consulta, instanciado en la capa logica.
		 * @param purgarConsulta es el metodo de la clase PurgarConsultaService de la capa logica.
		 * */
		public function anularConsulta(hora:String,fecha:String,servicio:String):void
		{
			this.getOperation("anularConsulta").send(hora,fecha,servicio);
		}
		
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param metodo que carga las consultas activas de un cliente, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarConsultas(rut:String):void
		{
			this.getOperation("cargarConsultas").send(rut);
		}
		
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param metodo que carga las consultas nulas de un cliente, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarConsultasNulas(rut:String):void
		{
			this.getOperation("cargarConsultasNulas").send(rut);
		}
		
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param metodo que carga todas las consultas de un cliente, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarConsultasTodas(rut:String):void
		{
		this.getOperation("cargarConsultasTodas").send(rut);	
			
		}
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param carga todas las consultas activas del sistema, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarTodasActivas():void
		{
			this.getOperation("cargarTodasActivas").send();
		}
		
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param carga todas las consultas nulas del sistema, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarTodasNulas():void
		{
		this.getOperation("cargarTodasNulas").send();	
		}
	
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param carga todas las consultas del sistema, se comunica con la capa logica
		 * con las clase respectiva
		 * */
		public function cargarTodas():void
		{
		this.getOperation("cargarTodas").send();	
		}
	
		/**
		 * @author Victor Silva
		 * @Fecha 	27 Octubre
		 * @param busca el nombre y rut del cliente basandose en una consulta
		 * */
		public function ConsultarCliente(rut:String):void
		{
		this.getOperation("consultarCliente").send(rut);
	}
}
}