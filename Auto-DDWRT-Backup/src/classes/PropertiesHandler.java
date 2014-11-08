package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

//handles reading and writing of the properties file to save the parameters
public class PropertiesHandler {

	
		//check if the properties file exists already
		public static boolean PropertiesFileExists(){
			
			File f = new File("Auto-DDWRT-Backup.properties");
			
			if(f.exists() && !f.isDirectory()) 
				return true;
			else
				return false;
			
		}
	
		
		//writes a properties file to the classpath (the path the .jar is in)
		//this file saves the entered parameters of the GUI, so they can be loaded as a config in readPropertiesFile() when starting this program
		public static boolean writePropertiesFile(String ipAddress, String user, String password, String filepath, String filename, String includeDate){
			
			Properties prop = new Properties();
			OutputStream output = null;
			
			try {
		 
				output = new FileOutputStream("Auto-DDWRT-Backup.properties");
		 
				// set the properties value
				prop.setProperty("ipAddress", ipAddress);
				prop.setProperty("user", user);
				prop.setProperty("password", password);
				prop.setProperty("filepath", filepath);
				prop.setProperty("filename", filename);
				prop.setProperty("includeDate", includeDate);
		 
				// save properties to project root folder
				prop.store(output, null);
		 
			} 
			catch (IOException io) {
				io.printStackTrace();
				return false;
			} 
			finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
		 
			}
			
			return true;
			
		}//end writePropertiesFile()
	
		
		//reads the properties file from the classpath (the path the .jar is in)
		public static Properties readPropertiesFile(){
			
			Properties prop = new Properties();
			InputStream input = null;
		 
			try {
		 
				input = new FileInputStream("Auto-DDWRT-Backup.properties");
		 
				// load a properties file
				prop.load(input);
		 
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			return prop;
			
		}//end readPropertiesFile()
		
}//end class
