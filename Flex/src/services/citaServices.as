//=======================================================================
// FECHA: CREACIÓN: 03 Octubre
// AUTOR: Victor Silva
// Comentarios: Clase que conecta con la capa logica y
//				realiza la accion de registrar una cita en el calendario
//=======================================================================



package services
{
	
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cita;
	
	
	/**
	 * 	@author  "Victor Silva"
	 * 	@Fecha  03 Octubre
	 *  @Descripcion Clase que gesitiona la conexion. Mediante el constructor
	 *  			 Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/
	public class citaServices extends RemoteObject
	{
		public function citaServices()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCita";
			this.source="Administracion.AddCita";
			//this.source="services.citaServices";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en citaServices, Detalle: "+event.fault.message);
		}
		
			/**
		 * @author "Victor Silva
		 * @Fecha 	03 Octubre
		 * @param cita es una instancia del transferObject Cita, instanciado en la capa logica.
		 * @param addCita es el metodo de la clase Administracion de la capa logica.
		 * */
		public function addCita(cita:Cita):void
		{
			this.getOperation("addCita").send(cita);
		}
		
			/**
		 * Se obtienen todos los clientes que están registrados en la base de datos
		 */ 
		public function getClientesActivos():void
		{
			this.getOperation("getClientesActivos").send();
		}

		public function getMascotas(rut:String):void
		{
			this.getOperation("getMascotas").send(rut);
		}

	}
}