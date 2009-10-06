package services
{
	// @autor Camilo Verdugo

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	
	/**
	 * 	@author  "Camilo Verdugo"
	 * 	@Fecha  20 Septiembre
	 *  @Descripcion Clase que gesitiona la conexion. Mediante el constructor
	 *  			 Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/

	public class GetCliente extends RemoteObject
	{
		/**
		 * @author "Camilo Verdugo"
		 * @Fecha 22 Septiembre
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function GetCliente()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetFichas";
			this.source="Administracion.GetFichas";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en getFichas, Detalle: "+event.fault.message);
		}
		
		
		public function getAtenciones(rut:String,nombre:String):void
		{
			this.getOperation("getAtenciones").send(rut,nombre);
		}
		
		
		
	}
}
