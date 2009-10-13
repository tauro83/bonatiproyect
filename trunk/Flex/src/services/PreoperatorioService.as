package services
{
	// @autor Nicolas Delgado

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	
	/**
	 * 	@author  "Nicolas Delgado"
	 * 	@Fecha   13 Octubre
	 *  @Descripcion Esta clase  gesitiona la conexion. Mediante el constructor
	 *  			 Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/

	public class PreoperatorioService extends RemoteObject
	{
		/**
		 * @author "Nicolas Delgado"
		 * @Fecha  13 Octubre
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function PreoperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PreoperatorioService";
			this.source="Administracion.PreoperatorioService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		
		
		
	}
}