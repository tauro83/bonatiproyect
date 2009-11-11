//=======================================================================
// FECHA: CREACIÓN: 20/08/09
// AUTOR: Camilo Verdugo
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar un usuario
//=======================================================================
package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
		
	public class GetCatalogos extends RemoteObject
	{
		
			
		public function GetCatalogos()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetCatalogos";
			this.source="Peluqueria.GetCatalogos";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * Muestra el mensaje de error
		 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en getFichas, Detalle: "+event.fault.message);
		}
		
		/**
		 * Obtiene los catalogos
		 * */
		public function getCatalogo():void
		{
			this.getOperation("getCatalogos").send();
		}

	}
}