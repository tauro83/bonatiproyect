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
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Esteban Cruz
	 */
	public class CirugiaService extends RemoteObject
	{
		public function CirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="CirugiaService";
			this.source="Pabellon.CirugiaService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @author  "Esteban Cruz"
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en CirugiaService, Detalle: "+event.fault.message);
		}
		/**
		 * Se anula una cirugia, cambiandole el estado a 2
		 * @author  "Esteban Cruz"
		 */ 
		public function anularCirugia(nombre:String, fecha:String, hora:String):void
		{
			this.getOperation("anularCirugia").send(nombre, fecha, hora);
			
		}
		
		/**
		 * Se elimina una cirugia, cambiandole el estado a 1
		 * @author  "Esteban Cruz"
		 */ 
		public function eliminarCirugia(nombre:String, fecha:String, hora:String):void
		{
			this.getOperation("eliminarCirugia").send(nombre, fecha, hora);
		}
		
		/**
		 * Se obtienen todas las cirugias que están registradas en la base de datos
		 * @author  "Esteban Cruz"
		 */ 
		public function getAllCirugias():void
		{
			this.getOperation("getAllCirugias").send();
		}
		
		/**
		 * Se obtienen todas las cirugias que están registradas en la base de datos
		 * @author  "Esteban Cruz"
		 */ 
		public function getAllCirugiasU(rut:String, nombre:String):void
		{
			this.getOperation("getAllCirugiasU").send(rut, nombre);
		}
	}
}