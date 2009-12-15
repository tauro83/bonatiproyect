//=======================================================================
// FECHA: CREACIÓN: 19/08/09 
// AUTOR: Camilo Verdugo
// Comentarios: Clase que hace la conexion a la capa logica y hace el llamado para la obtencion
//				de atenciones.
//=======================================================================
package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
		
	public class GetEstadisticasPeluqueria extends RemoteObject
	{
		
		/** 
		 *  Constructor de la clase, establece los datos de conexion de los servicios de JBos
		 *  Indica el package y el nombre de la clase de la capa 2 a la que es referida.
		*/
		public function GetEstadisticasPeluqueria()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetEstadisticas";
			this.source="Peluqueria.GetEstadisticas";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/** 
		 *  Constructor de la clase, establece los datos de conexion de los servicios de JBos
		 *  Indica el package y el nombre de la clase de la capa 2 a la que es referida.
		 * 	@author  "Camilo Verdugo"
		*/
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error obteniendoEstadisticas, Detalle: "+event.fault.message);
		}
		
		/** 
		 *  Metodo que llama al metodo de la capa 2 y manda dos parametros
		 *  el cual indica el rango de fechas para obtener las atenciones.	
		*/
		public function getEstadisticas(inicio:String,fin:String):void
		{
			this.getOperation("obtenerEstadisticas").send(inicio,fin);
		}

	}
}