// ActionScript file
//=======================================================================
// FECHA: CREACIÓN: 31 Octubre
// AUTOR: Camilo Verdugo
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de obtener y enviar las configuraciones que correponden
//				A los menus desplegables del sistema
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;	
	import transferObjects.ConfiguracionVacuna;
	
	/**
	 * 	@author  "Camilo Verdugo"
	 * 	@Fecha  31 Octubre
	 *  @Descripcion Clase que gesitiona la conexion. Mediante el constructor
	 *  			 Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/
	public class configuracionServices extends RemoteObject
	{
		/**
		 * Constructor de la clase, la cual indica que se conectara con el package Configuracion, en particular
		 * con la clase Configurar 
		 */		
		public function configuracionServices() 
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="Configurar";
			this.source="Configuracion.Configurar";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * 
		 * @param event reaccion ante un error en la conexion con la capa 2
		 * se maneja este error por medio de un POPUP 
		 */		
		public function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error obteniendo configuraciones: "+event.fault.message);
		}
		
		/**
		 * 
		 * @param tipo indica que configuracion esta solicitando, los tipos pueden ser:
		 * Servicio, Especie, Cargo, obteniendo las configuraciones para cada uno de esos tipos
		 * 
		 */		
		public function getConfiguraciones(tipo:String):void
		{
			this.getOperation("getConfiguracion").send(tipo);
		}
		
		/**
		 * obtenien un arrayCollection de vacunas, las cuales seran cargadas en el popup  
		 */		
		public function getConfiguracioneVacunas():void
		{
			this.getOperation("getConfiguracionVacuna").send();
		}
		
		/**
		 * @param tipo indica que configuracion esta solicitando, los tipos pueden ser:
		 * Servicio, Especie, Cargo, obteniendo las configuraciones para cada uno de esos tipos
		 * @param nombre valor que sera seteado en la configuracion, por ejemplo: Policlinico, Ayudante
		 * segun corresponda el tipo especificado 
		 */		
		public function regConfiguracion(tipo:String, nombre:String):void
		{
			this.getOperation("regConfiguracion").send(tipo,nombre);
		}
		/**
		 * @param tipo indica que configuracion esta solicitando, los tipos pueden ser:
		 * Servicio, Especie, Cargo, obteniendo las configuraciones para cada uno de esos tipos
		 * @param nombre valor que sera eliminado de la configuracion, por ejemplo: Policlinico, Ayudante
		 * segun corresponda el tipo especificado 
		 */		
		public function elimConfiguracion(tipo:String, nombre:String):void
		{
			this.getOperation("elimConfiguracion").send(tipo,nombre);
		}
				
		/**
		 * @param cv objeto que registra una vacuna 
		 */			
		public function regConfiguracionVacuna(cv:ConfiguracionVacuna):void
		{
			this.getOperation("regConfiguracionVacuna").send(cv);
		}
		/**
		 * @param nombre valor que sera eliminado de la tabla de vacunas
		 */	
		public function elimConfiguracionVacuna(nombre:String):void
		{
			this.getOperation("elimConfiguracionVacuna").send(nombre);
		}
	}
}