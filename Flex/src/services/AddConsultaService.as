package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Consulta;
	
	public class AddConsultaService extends RemoteObject
	{
		
		/*
		 *Corresponde al constructor de la componente registrar una consulta que se encarga de pasar los objetos
		 *obtenido en ella componente y se encarga de pasarle estos objetos a la capa 2. 
		 */
		public function AddConsultaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddConsultaService";
			this.source="Administracion.AddConsultaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/*
		 *Este metodo se encarga de mencionar los posibles errores que podrian ocurrir en el sistema a 
		 *causa de esta componente y se encarga de mostrarselo al usuario atraves de pop up para que sea 
		 *visible para el usuario. 
		 */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en consultaService, Detalle: "+event.fault.message);
		}
		
		
		public function AddConsulta(consulta:Consulta):void
		{
			this.getOperation("addConsulta").send(consulta);
		}
		

		public function getCliente(rutCliente:String):void
		{
			this.getOperation("getCliente").send(rutCliente);
		}
		
	

		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		

	}
}