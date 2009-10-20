//=======================================================================
// FECHA CREACIÓN:  28/09/2009
// AUTOR: Jimmy Muñoz
// …. Clase que conecta con capa 2
//=======================================================================

package pabellon
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cirugia;
	import transferObjects.tiposCir;


	public class AddCirugiaService extends RemoteObject
	{
		public function AddCirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCirugiaService";
			this.source="Pabellon.AddCirugiaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AddCirugiaService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Usuario, para enviarlo a la capa2. 		
			 * */
		public function addCirugia(cirugia:Cirugia):void
		{
			this.getOperation("addCirugia").send(cirugia);
		}
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de todos los usuarios del sistema.	 		
			 * */
		public function getCliente(rutCliente:String):void{
			this.getOperation("getCliente").send(rutCliente);
		}
		
		public function getAllMascotas():void{
			this.getOperation("getAllMascotas").send();
		}
		
		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		
		public function getTiposCirugias():void{
			this.getOperation("getTiposCirugias").send();
		}
		
		public function getTiposVeterinarios():void{
			this.getOperation("getTiposVeterinarios").send();
		}
		
		public function getTiposAyudantes():void{
			this.getOperation("getTiposAyudantes").send();
		}

	}
}