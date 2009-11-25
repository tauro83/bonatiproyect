//=======================================================================
// FECHA: CREACIÓN: 23/11/09
// AUTOR: Sebastian Arancibia
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar un pago
//=======================================================================

package petshop
{
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.DetallePago;
	import mx.rpc.events.FaultEvent;
	import mx.controls.Alert;
	
	/** 
	 *  Clase que gesitiona la conexion. Mediante el constructor
	 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	 * 	@author  "Sebastian Arancibia"
	*/
	public class RegistrarPagoService extends RemoteObject
	{
		/**
		 * Constructor de la clase
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function RegistrarPagoService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="RegistrarPagoService";
			this.source="Petshop.RegistrarPagoService";
			this.addEventListener(FaultEvent.FAULT,error);
		}
		
		private function error(event:FaultEvent):void{
			Alert.show("Error en RegistrarPagoService, Detalle: "+event.fault.message);
		}
		
		/**
		 * Envia un objeto un producto a la capa 2
		 * @param p es una instancia del transferObject Pago, instanciado en la capa logica.
		 * */
		public function registrarPago(p:DetallePago):void
		{
			//this.getOperation("...").send(prod);
		}
	}
}