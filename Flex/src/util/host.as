package util{
	public class host{
		 
	
		public static function getUrl():String
		{
			//REMOTE
			var s1:String="http://clinicabonati.hostjava.net:9939/VeterinariaServer/messagebroker/amf";
			
			//LOCAL
			var s2:String="http://localhost:8080/VeterinariaServer/messagebroker/amf";
			return s2;
		}
	}
	
	
	
	
}
