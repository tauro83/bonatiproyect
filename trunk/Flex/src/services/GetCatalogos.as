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
	import util.host;
	import transferObjects.CatPeluqueria;
		
	public class GetCatalogos extends RemoteObject
	{		
		/** 
		 *  Clase que gesitiona la conexion. Mediante el constructor
		 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
		 * 	@author  "Camilo Verdugo"
		*/		
		public function GetCatalogos()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetCatalogos";
			this.source="Peluqueria.GetCatalogos";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * Muestra el mensaje de error en un popup
		 * @author  "Camilo Verdugo"
		 * 
		 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error de conexion, Detalle: "+event.fault.message);
		}
		
		/**
		 * Obtiene los catalogos desde la capa logica
		 * @author  "Camilo Verdugo"
		 * 
		 * */
		public function getCatalogo():void
		{
			this.getOperation("getCatalogos").send();
		}
		/** 
		 *  Metodo que envia un catalogo editado a la capa 2
		 * 	@author  "Camilo Verdugo"
		*/
		public function editCatalogo(cat:CatPeluqueria):void
		{
			this.getOperation("editCatalogo").send(cat);
		}

	}
}