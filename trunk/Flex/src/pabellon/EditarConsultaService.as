package pabellon
{
	
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Consulta;


	public class EditarConsultaService extends RemoteObject
	{
		public function EditarConsultaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarConsultaService";
			this.source="Pabellon.EditarConsultaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	@author  "Raúl López"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarConsultaService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Raúl López"
			 * 	@Fecha  14 Octubre
			 *  @Descripcion Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Preoperatorio, para enviarlo a la capa2. 		
			 * */
		public function editarConsulta(consulta:Consulta):void
		{
			this.getOperation("editarConsulta").send(consulta);
		}
	

	}
	
}