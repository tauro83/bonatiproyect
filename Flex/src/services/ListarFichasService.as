/**
 * @Author	Camilo Verdugo 
*/
package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
		
	public class ListarFichasService extends RemoteObject
	{
		/**
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function ListarFichasService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetFichas";
			this.source="Administracion.GetFichas";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * 
		 * @param event evento retornado de la capa logica, en caso de producirse un error de conexion
		 * 
		 */		
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en getFichas, Detalle: "+event.fault.message);
		}
		
		/**
		 * 
		 * @param rut valor que permitira identificar al cliente, dueño de la mascota
		 * que se esta solicitando, para cargar los datos en la ficha.
		 * 
		 */		
		public function getCliente(rut:String):void
		{
			this.getOperation("getCliente").send(rut);
		}
		
		/**
		 * 
		 * @param rut	Valor para obtener el listado de atenciones desde la capa 2
		 * @param nombre	Segundo valor necesario para obtener las atenciones recibidas por una mascota
		 * 
		 */		
		public function getAtenciones(rut:String,nombre:String):void
		{
			this.getOperation("getAtenciones").send(rut,nombre);
		}
		
		/**
		 *	Metodo que realiza un llamado al metodo getMascotas de la capa 2, para obtener el listado el
		 *  cual sera utilizado para cargar la ficha.
		 * 
		 */		
		public function getMascotas():void
		{
			this.getOperation("getMascotas").send();
		}
		
	}
}