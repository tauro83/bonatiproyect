// ActionScript file
//=======================================================================
// FECHA: CREACIÓN: 31 Octubre
// AUTOR: Camilo Verdugo
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de obtener y enviar las configuraciones que correponden
//				A los menus desplegables del sistema
//=======================================================================

package services
{
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.rpc.events.FaultEvent;
	import mx.controls.Alert;
	
	public class configuracionServices extends RemoteObject
	{
		public function configuracionServices() 
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="Configurar";
			this.source="Configuracion.Configurar";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		public function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error obteniendo configuraciones: "+event.fault.message);
		}
		
		public function getConfiguraciones(tipo:String):void
		{
			this.getOperation("getConfiguracion").send(tipo);
		}
		
		public function getConfiguracioneVacunas():void
		{
			this.getOperation("getConfiguracionVacuna").send();
		}

	}
}