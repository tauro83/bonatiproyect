//=======================================================================
// FECHA: CREACIÓN: 07/11/09
// AUTOR: Andrés Garrido
// Comentarios: TransferObject homólogo al existente en la capa 2
//=======================================================================

package transferObjects{	

	[Bindable]
    [RemoteClass(alias="TransferObjects.Alojamiento")]
    
    /**
	 * Clase que encapsula los datos de un alojamiento en hoteleria, 
	 * esta clase posee una equivalente en la capa 2 de tal forma 
	 * que se pueda hacer una mapeo directo desde las capas.
	 */  
	public class Alojamiento{
		public function Alojamiento(){
			
		}
		
	}
}