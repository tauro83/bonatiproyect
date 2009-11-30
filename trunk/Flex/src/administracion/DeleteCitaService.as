//=======================================================================
// FECHA CREACI�N:  28/09/2009
// AUTOR: Raul Lopez
// �. Clase que conecta con capa 2
//=======================================================================

package administracion
{
	
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class DeleteCitaService extends RemoteObject{
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
			 * Y la direccion en la cual esta levantado la capa 2.		 		
		* */
	
		public function DeleteCitaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="DeleteCitaService";
			this.source="Administracion.DeleteCitaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
			
		}
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
		* */
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteCitaService, Detalle: "+event.fault.message);
		}
		
		/**
		 	 * 	@author  "Raul Lopez"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que envia a la capa 2, la cita que fue eliminada, 
			 * para eliminarlo de la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro el rut del cliente, para encontrar la cita a eliminar, para enviarlo a la capa2. 		
			 * */
		public function purgarCita(fecha:String, hora:String, servicio:String, responsable:String):void{
			this.getOperation("purgarCita").send( fecha, hora, servicio, responsable);
		}

	}
		
		
}