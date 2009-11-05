//=======================================================================
// FECHA CREACIÓN:  28/09/2009
// AUTOR: Raul Lopez
// …. Clase que conecta con capa 2
//=======================================================================

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
	
			/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
			 * Y la direccion en la cual esta levantado la capa 2.		 		
			 * */
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
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarCitaService, Detalle: "+event.fault.message);
		}
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que envia a la capa 2, la cita que fue editada, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Cita, para enviarlo a la capa2. 		
			 * */
		public function insertCitaE(person:Cita):void
		{
			this.getOperation("insertCitaE").send(person);
		}
		
			/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de todos las citas del sistema.	 		
			 * */
		public function getAllCitasE():void
		{
			this.getOperation("getAllCitasE").send();
		}
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de una cita en particular, esto lo hace  buscando con un rut unico 		
		 * */
		public function getCita(rut:String):void
		{
			this.getOperation("getCita").send(rut);
		}

	}
}