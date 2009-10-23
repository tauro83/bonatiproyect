// ActionScript file
//=======================================================================
// FECHA: CREACIÓN: 19 Septiembre
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
	
		
	public class GetEstadisticasClinica extends RemoteObject
	{
		
		/**
		 * 	@author  Andres Garrido
		 * 	@Fecha  13 Septiembre
		 *  @Descripcion Constructor de la clase, establece los datos de conexion de los servicios de JBos
		 *  			 Indica el package y el nombre de la clase de la capa 2 a la que es referida.
		*/
		public function GetEstadisticasClinica(){
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetEstadisticasClinica";
			this.source="Clinica.GetEstadisticasClinica";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * 	@author  "Camilo Verdugo"
		 * 	@Fecha  19 Septiembre
		 *  @Descripcion Constructor de la clase, establece los datos de conexion de los servicios de JBos
		 *  			 Indica el package y el nombre de la clase de la capa 2 a la que es referida.
		*/
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error obteniendoEstadisticas, Detalle: "+event.fault.message);
		}
		
		/**
		 * 	@author  "Camilo Verdugo"
		 * 	@Fecha  19 Septiembre
		 *  @Descripcion Metodo que llama al metodo de la capa 2 y manda dos parametros
		 *  el cual indica el rango de fechas para obtener las atenciones.	
		*/
		public function getEstadisticas(tipo:int,inicio:String,fin:String):void
		{
			this.getOperation("obtenerEstadisticas").send(tipo,inicio,fin);
		}

	}
}