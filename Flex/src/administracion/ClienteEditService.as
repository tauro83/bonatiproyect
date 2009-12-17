package administracion
{
	
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Cliente;

	public class ClienteEditService extends RemoteObject
	{
       
	    /**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  20 Septiembre
			 *  @Descripcion Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
			 * Y la direccion en la cual esta levantado la capa 2.		 		
		 * */
       	public function ClienteEditService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="ClienteEditService";
			this.source="Administracion.ClienteEditService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  20 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
		* */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en ClienteEditService, Detalle: "+event.fault.message);
		}
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  20 Septiembre
			 *  @Descripcion Metodo que envia a la capa 2, la cita que fue editada, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Cliente, para enviarlo a la capa2. 		
			 * */
		public function insertClienteE(person:Cliente, rutete:String):void
		{
			this.getOperation("insertClienteE").send(person,rutete);
		}
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  20 Septiembre
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de todos los clientes del sistema.	 		
			 * */
		public function getAllClientesE():void
		{
			this.getOperation("getAllClientesE").send();
		}
	}
}