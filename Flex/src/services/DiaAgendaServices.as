//=======================================================================
// FECHA CREACIÓN: 05/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase que comunica con java (capa 2)
//=======================================================================

package services{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.DiaAgenda;

    /**
	 * Clase utilizada para comunicar con DiaAgendaService de la capa 2 (Java)
	 * @author  Sebastian Arancibia
	 * @version 1, 05/10/2009
	 */
	public class DiaAgendaServices extends RemoteObject{
		public function DiaAgendaServices(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			//Destino capa 2 
			this.destination="DiaAgendaServices";
			this.source="Agenda.DiaAgendaServices";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento para capturar fallas
		 * */
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DiaAgendaServices, Detalle: "+event.fault.message);
		}
		/**
		 * @param fecha Fecha de la cual se quieren capturar las citas
		 * */
		public function getDiaAgenda(fecha:String):void{
			this.getOperation("getDiaAgenda").send(fecha);
		}
		
	}
}