//=======================================================================
// FECHA CREACIÓN:  28/09/2009
// AUTOR: Jimmy Muñoz
// …. Clase que conecta con capa 2
//=======================================================================


package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
		
	import transferObjects.Usuario;

	public class UsuarioEditService extends RemoteObject
	{
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
			 * Y la direccion en la cual esta levantado la capa 2.		 		
			 * */
		public function UsuarioEditService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="UsuarioEditService";
			this.source="Administracion.UsuarioEditService";
			
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
			Alert.show("Error en UsuarioEditService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Usuario, para enviarlo a la capa2. 		
			 * */
		public function insertUsuarioE(person:Usuario):void
		{
			this.getOperation("insertUsuarioE").send(person);
		}
		
		/**
		 	 * 	@author  "Jimmy Muñoz"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que solicita a la capa 2 los datos de todos los usuarios del sistema.	 		
			 * */
		public function getAllUsuariosE():void
		{
			this.getOperation("getAllUsuariosE").send();
		}
		
	}
}