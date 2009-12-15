//=======================================================================
// FECHA CREACIÓN: 16-11-09
// AUTOR: Nicolas Delgado 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	
	import transferObjects.anuPeluqueria;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Nicolas Delgado
	 */
	public class anularPeluqueria extends RemoteObject
	{
		public function anularPeluqueria()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="anularPeluqueria";
			this.source="Administracion.anularPeluqueria";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en anularPeluqueria, Detalle: "+event.fault.message);
		}
		
		/**
		* Este metodo envia el estado de un registro de peluquería y si este se encuentra en 0 
		* es cambiado a 2.
		*/ 
		public function anular(estado:int,nombreMascota:String,hora:String):void
		{
			this.getOperation("anular").send(estado,nombreMascota,hora);
			
		}
		
		/**
		* Este metoso envia el estado de un registro de peluquería y si este se encuentra en 0 
		* es cambiado 1.
		*/  
		public function eliminar(estado:int,nombreMascota:String,hora:String):void
		{
			this.getOperation("eliminar").send(estado,nombreMascota,hora);
		}
		
		/**
		* Este metoso envia el estado de un registro de peluquería y si este se encuentra en 1 
		* es cambiado 0.
		*/  
		public function deseliminar(estado:int,nombreMascota:String,hora:String):void
		{
			this.getOperation("deseliminar").send(estado,nombreMascota,hora);
		}
		
		/**
		* Este metodo se encar de obtener todos los registro de peluquería que se encuentran al 
		* interior de la base de datos. 
		*/ 
		public function getAllVacunaciones():void
		{
			this.getOperation("getAllVacunaciones").send();
		}
		
		/**
		* Este metodo se encar de obtener todos los registro de peluquería que se encuentran al 
		* interior de la base de datos. 
		*/ 
		public function getAllVacunacionesU(nombreMascota:String):void
		{
			this.getOperation("getAllVacunacionesU").send(nombreMascota);
		}
		
		/**
		* Este metodo se encar de obtener todos los registro de peluquería que se encuentran al 
		* interior de la base de datos. 
		*/ 
		public function getAllVacunacionesA():void
		{
			this.getOperation("getAllVacunacionesA").send();
		}
	}
}
