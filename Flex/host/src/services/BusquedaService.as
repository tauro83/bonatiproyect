//=======================================================================
// FECHA CREACIÓN: 06/10/09
// AUTOR: Esteban Cruz
// Script de busqueda del sistema, dentro de esta se pueden realizar 
// busquedas para: Mascota, Cliente, Atencion, Producto, Aviso, Usuario
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;

	public class BusquedaService extends RemoteObject
	{
		public function BusquedaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="BusquedaService";
			this.source="Administracion.BusquedaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 *  event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 *  @author  "Esteban Cruz"
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en BusquedaService, Detalle: "+event.fault.message);
		}
		
		/**
		 *  Trata de obtener todos los usuarios registrados en la base de datos
		 *  @author  "Esteban Cruz"
	 	 *  @return Lista con todos los usuarios registrados
	 	 */
		public function getAllUsuarios():void
		{
			this.getOperation("getAllUsuarios").send();
		}
		
		/**
		 *  Trata de obtener todos los clientes registrados en la base de datos
		 *  @author  "Esteban Cruz"
	 	 *  @return Lista con todos los clientes registrados
	 	 */
		public function getAllClientes():void
		{
			this.getOperation("getAllClientes").send();
		}
		
		/**
		 *  Trata de obtener todos las mascotas registrados en la base de datos
	 	 *  @author  "Esteban Cruz"
	 	 *  @return Lista con todos las mascotas registrados
	 	 **/
		public function getAllMascotas():void
		{
			this.getOperation("getAllMascotas").send();
		}
		
		/**
		 *  Trata de obtener todos las atenciones registrados en la base de datos
	 	 *  @author  "Esteban Cruz"
	 	 *  @return Lista con todos las atenciones registrados
	 	 **/
		public function getAllAtenciones():void
		{
			this.getOperation("getAllAtenciones").send();
		}
		
		/**
		 *  Trata de obtener todos los productos registrados en la base de datos
	 	 *  @author  "Esteban Cruz"
	 	 *  @return Lista con todos los productos registrados
	 	 **/
		public function getAllProductos():void
		{
			this.getOperation("getAllProductos").send();
		}
		
	}
}