package peluqueria
{
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	public class EditarPeluService
	{
		public function EditarPeluService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarPeluService";
			this.source="Peluqueria.EditarPeluService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
				/**
		 	 * 	@author  "Raúl López"
			 * 	@Fecha  10 Noviembre
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
			 * 	@Fecha  10 Noviembre
			 *  @Descripcion Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Preoperatorio, para enviarlo a la capa2. 		
			 * */
		/*
		public function editarPeluqueria(pelu:Peluqueria):void
		{
			this.getOperation("editarPeluqueria").send(pelu);
		}
		
		public function getAllPeluquerias(rutillo:String,nombreMascota:String):void
		{
			this.getOperation("getAllPeluquerias").send(rutillo, nombreMascota);
		}
        */
	}
}