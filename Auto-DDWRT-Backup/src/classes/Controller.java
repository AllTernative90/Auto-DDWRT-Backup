package classes;

import java.io.IOException;

//implements settings from Interface ISettings
//calls DateGenerator and HttpBasicAuth classes
public class Controller implements ISettings {

	public static void main(String[] args) throws IOException {
    	
    	String fileDate = "";
    	
//		generate Date for fileName
		if (printDateInFileName == true){
		    DateGenerator myDate = new DateGenerator();
		    String[] dateArray = myDate.generateDate();
		    fileDate = " - " + dateArray[0]+ "-" + dateArray[1]+ "-" +dateArray[2];
		}

//		call the HttpBasicAuth class to handle the authentification and backup
		HttpBasicAuth HttpAuthentication = new HttpBasicAuth();
	  	HttpAuthentication.getBackupFile(sourceURL,HTTPuser,HTTPpassword,filePath,fileName,fileExt,fileDate);
		
	}

}
