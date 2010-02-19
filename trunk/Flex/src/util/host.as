package util{
	public class host{
		 
	
		public static function getUrl():String
		{
			var s1:String="http://cbonati.dontexist.org:8080/VeterinariaServer/messagebroker/amf";
			var s2:String="http://localhost:8080/VeterinariaServer/messagebroker/amf";
			return s2;
		}
		public static function getServlet():String
		{
			var s1:String="http://cbonati.dontexist.org:8080/VeterinariaServer/FileUploadServlet";
			var s2:String="http://localhost:8080/VeterinariaServer/FileUploadServlet";
			return s2;
		}
	}
}
