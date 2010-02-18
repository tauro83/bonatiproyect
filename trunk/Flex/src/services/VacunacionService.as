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
	import util.host;
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
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="VacunacionService";
			this.source="Policlinico.VacunacionService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @author  "Esteban Cruz"
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en VacunacionService, Detalle: "+event.fault.message);
		}
		/**
		 * Se anula una vacunación, cambiandole el estado a 2
		 * @author  "Esteban Cruz"
		 */ 
		public function anular(nombre:String, fecha:String, hora:String):void
		{
			this.getOperation("anular").send(nombre, fecha, hora);
			
		}
		
		/**
		 * Se elimina una vacunación, cambiandole el estado a 1
		 * @author  "Esteban Cruz"
		 */ 
		public function eliminar(nombre:String, fecha:String, hora:String):void
		{
			this.getOperation("eliminar").send(nombre, fecha, hora);
		}
		
		/**
		 * Se obtienen todas las vacunaciones que están registradas en la base de datos
		 * @author  "Esteban Cruz"
		 */ 
		public function getAllVacunaciones():void
		{
			this.getOperation("getAllVacunaciones").send();
		}
		
		public function getAllVacunacionesAnul():void
		{
			this.getOperation("getAllVacunacionesAnul").send();
		}

		public function getAllVacunacionesTodo():void
		{
			this.getOperation("getAllVacunacionesTodo").send();
		}
		
		/**
		 * Se obtienen todas las vacunaciones que están registradas en la base de datos
		 * @author  "Esteban Cruz"
		 */ 
		public function getAllVacunacionesU(rut:String, nombre:String):void
		{
			this.getOperation("getAllVacunacionesU").send(rut, nombre);
		}
		
		public function getAllVacunacionesU2(rut:String, nombre:String):void
		{
			this.getOperation("getAllVacunacionesU2").send(rut, nombre);
		}
	}
}