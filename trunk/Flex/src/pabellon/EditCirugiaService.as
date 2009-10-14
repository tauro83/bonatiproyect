package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cirugia;

	public class EditCirugiaService extends RemoteObject
	{
			/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  11 Octubre de 2009
			 *  @Descripcion Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
			 * Y la direccion en la cual esta levantado la capa 2.		 		
			 * */
		public function EditCirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditCirugiaService";
			this.source="Clinica.EditCirugiaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  11 Octubre de 2009
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditCirugiaService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  11 de Octubre de 2009
			 *  @Descripcion Metodo que envia a la capa 2, la cirugia que fue editada, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Cirugia, para enviarlo a la capa 2. 		
			 * */
		public function updateCirugia(cirugia:Cirugia):void
		{
			this.getOperation("updateCirugia").send(cirugia);
		}
		
		/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  11 de Octubre de 2009
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de todos las cirugias del sistema que
			 *   compartan los atributos enviados en el objeto.	 		
			 * */
		public function getCirugias(cirugia: Cirugia):void
		{
			this.getOperation("getCirugias").send(cirugia);
		}
		
	}
}