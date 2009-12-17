//=======================================================================
// FECHA CREACIÓN:  10/09/2009
// AUTOR: Sebastian Arancibia
// …. Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
// Y la direccion en la cual esta levantado la capa 2.
//=======================================================================


package services{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Mascota;

	/**
	 * Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
	 * Y la direccion en la cual esta levantado la capa 2.
	 * @author Sebastian Arancibia
	 * @version 10/09/2009
	 * @langversion ActionScript 3.0
	*/

	public class AddMascotaService extends RemoteObject{
		/**
		 *  Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
		 *  Y la direccion en la cual esta levantado la capa 2.
	 	 * 	@author  Sebastian Arancibia	 		
		 * */
		public function AddMascotaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddMascotaService";
			this.source="Administracion.AddMascotaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 *   Metodo que en caso de error, muestra en a traves de 
		 *  un popup, esto se debe a que estos son errores de sistema, por lo 
		 *  tanto es necesario informarlo de otra forma.
	 	 * 	@author  Sebastian Arancibia
	 	 * 	@param event Evento de posible error en comunicacion con capa 2	 		
		 * */
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en AddMascotaService, Detalle: "+event.fault.message);
		}
		
		/**
		 *  Metodo que solicita a la capa 2 los datos de un cliente del sistema que
		 *  compartan los atributos enviados en el objeto,
	 	 * 	@author  Sebastian Arancibia
	 	 *  @param rutCliente Rut del cliente que se quiere retornar
		 * */
		public function getCliente(rutCliente:String):void{
			this.getOperation("getCliente").send(rutCliente);
		}
		
		/**
		 *  Metodo que envia en objeto Mascota para que sea guardado en la base de datos
	 	 * 	@author  Sebastian Arancibia
	 	 *  @param mascota Objeto de mascota que se quiere agregar a la base de datos
		 * */
		public function addMascota(mascota:Mascota, usuario:String):void{
			this.getOperation("addMascota").send(mascota, usuario);
		}
		
		/**
		 * Metodo que solicita a la capa 2 los datos de todos las mascotas
		 * @author  Sebastian Arancibia
		 **/
		public function getAllMascotas():void{
			this.getOperation("getAllMascotas").send();
		}
		/**
		 * Metodo que solicita a la capa 2 los datos de todos las mascotas del sistema que
		 * compartan los atributos enviados  
		 * @author  Sebastian Arancibia
		 * @param rutCliente Rut del cliente de las mascotas que se quiere retornar
		 **/
		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		

	}
}