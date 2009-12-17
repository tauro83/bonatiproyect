//=======================================================================
// FECHA CREACIÓN:  13/10/09
// AUTOR: Jimmy Muñoz
// Clase que conecta con capa 2
//=======================================================================

package pabellon
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Cirugia;
	import transferObjects.tiposCir;


	public class AddCirugiaService extends RemoteObject
	{
		public function AddCirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCirugiaService";
			this.source="Pabellon.AddCirugiaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.	
			 * @author  "Jimmy Muñoz"	 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AddCirugiaService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * @author  "Jimmy Muñoz"
			 * 	@Param Recibe como parametro un objeto de la clase Usuario, para enviarlo a la capa2. 		
			 * */
		public function addCirugia(cirugia:Cirugia):void
		{
			this.getOperation("addCirugia").send(cirugia);
		}
		
		/**
		 	 * Metodo que solicita a la capa 2 los datos de un cliente del sistema
			 * para verificar su existencia.
			 * @author  "Jimmy Muñoz"
			 * 	@Param recibe un String que es el rut del cliente, del cual se quieren obtener los datos.	 		
			 * */
		public function getCliente(rutCliente:String):void{
			this.getOperation("getCliente").send(rutCliente);
		}
		
	
		/**
		 	 * Metodo que solicita a la capa 2 los datos de las mascotas de un determinado cliente.	
		 	 * @author  "Jimmy Muñoz" 		
			 * 	@Param recibe un String que es el rut del cliente, del cual se quieren obtener los datos.
			  */
		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		
		/**
		 	 * Metodo que solicita a la capa 2 los datos de todas las cirugias.	
		 	 * @author  "Jimmy Muñoz" 		
			 * */
		public function getTiposCirugias():void{
			this.getOperation("getTiposCirugias").send();
		}
		
		/**
		 	 * Metodo que solicita a la capa 2 los datos de todos los usuarios del sistema
			 * que sean veterinarios.	
			 * @author  "Jimmy Muñoz" 		
			 * */
		public function getTiposVeterinarios():void{
			this.getOperation("getTiposVeterinarios").send();
		}
		
		/**
		 	 * Metodo que solicita a la capa 2 los datos de todos los usuarios del sistema
			 * que sean ayudantes y veterinarios.
			 * @author  "Jimmy Muñoz"	 		
			 * */
		public function getTiposAyudantes():void{
			this.getOperation("getTiposAyudantes").send();
		}

	}
}