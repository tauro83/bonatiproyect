//=======================================================================
// FECHA CREACIÓN: 27-10-09
// AUTOR: Esteban Cruz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.vacunacionesObj;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Esteban Cruz
	 */
	public class VacunacionService extends RemoteObject
	{
		public function VacunacionService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="VacunacionService";
			this.source="Policlinico.VacunacionService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en VacunacionService, Detalle: "+event.fault.message);
		}
		/**
		 * Se anula una vacunación, cambiandole el estado a 2
		 */ 
		public function anular(estado:String):void
		{
			this.getOperation("anular").send(estado);
			
		}
		
		/**
		 * Se elimina una vacunación, cambiandole el estado a 1
		 */ 
		public function eliminar(estado:String):void
		{
			this.getOperation("eliminar").send(estado);
		}
		
		/**
		 * Se obtienen todas las vacunaciones que están registradas en la base de datos
		 */ 
		public function getAllVacunaciones():void
		{
			this.getOperation("getAllVacunaciones").send();
		}
		
		/**
		 * Se obtienen todas las vacunaciones que están registradas en la base de datos
		 */ 
		public function getAllVacunacionesU(rut:String):void
		{
			this.getOperation("getAllVacunacionesU").send(rut);
		}
	}
}