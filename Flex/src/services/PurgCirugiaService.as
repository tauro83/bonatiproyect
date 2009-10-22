//=======================================================================
// FECHA CREACIÓN: 14-10-09
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
	
	import transferObjects.CirugiaPurg;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Esteban Cruz
	 */
	public class PurgCirugiaService extends RemoteObject
	{
		public function PurgCirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PurgCirugiaService";
			this.source="Pabellon.PurgCirugiaService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PurgCirugiaService, Detalle: "+event.fault.message);
		}
		/**
		 * @param clave String que se le entrega a la acapa lógica para eliminar una cirugia
		 */ 
		public function setEstado(estado:String):void
		{
			this.getOperation("setEstado").send(estado);
			
		}
		/**
		 * Se obtienen todas las cirugias que están registradas en la base de datos
		 */ 
		public function getAllCirugias():void
		{
			this.getOperation("getAllCirugias").send();
		}
		
		/**
		 * Se obtienen todas las cirugias que están registradas en la base de datos
		 */ 
		public function getAllCirugiasU(rut:String):void
		{
			this.getOperation("getAllCirugiasU").send(rut);
		}
	}
}