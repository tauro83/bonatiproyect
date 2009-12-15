//=======================================================================
// FECHA CREACIÓN:  11/11/2009
// AUTOR: Jimmy Muñoz
// Clase que conecta con capa 2
//=======================================================================

package peluqueria
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Peluqueria;


	public class AddPeluqueriaService extends RemoteObject
	{
		public function AddPeluqueriaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddPeluqueriaService";
			this.source="peluqueria.AddPeluqueriaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.
			 * @author  "Jimmy Muñoz"		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AddPeluqueriaService, Detalle: "+event.fault.message);
		}
		
		
		/**
			 * 	Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Param Recibe como parametro un objeto de la clase Usuario, para enviarlo a la capa2. 		
			 * */
		public function addPeluqueria(peluqueria:Peluqueria):void
		{
			this.getOperation("addPeluqueria").send(peluqueria);
		}
		
		/**
			 * 	Metodo que solicita a la capa 2 los datos de un cliente del sistema
			 * para verificar su existencia.
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Param recibe un String que es el rut del cliente, del cual se quieren obtener los datos.	 		
			 * */
		public function getCliente(rutCliente:String):void{
			this.getOperation("getCliente").send(rutCliente);
		}
		
	
		/**
		 * 	Metodo que solicita a la capa 2 los datos de las mascotas de un determinado cliente.
		 * 	@author  "Jimmy Muñoz"	 		
		 * 	@Param recibe un String que es el rut del cliente, del cual se quieren obtener los datos.
		 */
		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		
		/**
		 * 
		 * Metodo que solicita a la capa 2 los datos de todas las cirugias.
		 * 	@author  "Jimmy Muñoz"	 		
		 * */
		public function getTiposServicios():void{
			this.getOperation("getTiposServicios").send();
		}
		
		/**
		 * Metodo que solicita a la capa 2 los datos de todos los usuarios del sistema
		 * que sean veterinarios.
		 * 	@author  "Jimmy Muñoz"	 		
		* */
		public function getTiposPeluqueros():void{
			this.getOperation("getTiposPeluqueros").send();
		}
		
		/**
		 * metodo que obtiene el nombre de un peluquero.
		 * 	@author  "Jimmy Muñoz"	 		
		* */
		public function getResponsable():void{
			this.getOperation("getResponsable").send();
		}


	}
}