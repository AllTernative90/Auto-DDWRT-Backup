package classes;

//these settings can be adjusted to your liking
public interface ISettings {

	final String sourceURL = "http://192.168.0.1:80/nvrambak.bin";
	final String HTTPuser = "admin";
	final String HTTPpassword = "password";

	final String filePath = "D:/";
	final String fileName = "DD-WRT v24-sp2 (122413)";
	final String fileExt  = ".bin";
	boolean printDateInFileName = true; //adds "- year-month-day" to fileName
	
}
