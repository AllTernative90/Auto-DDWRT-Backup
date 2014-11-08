package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class Controller{

	public static void main(String[] args) {
		
		//create the GUI
		createGUI(); 
		
	}
	
	
	//create a GUI element, check if a properties file exists and update the GUI with those values
	public static void createGUI(){
		
		GUI gui = new GUI();
    	gui.setVisible(true);
    	
    	//check if a properties file exists and load its values
    	if (PropertiesHandler.PropertiesFileExists()){
    		
    		//read properties file
       		Properties prop = PropertiesHandler.readPropertiesFile();
        	
        	//fill in the textfields from the properties file
        	gui.textField_IP.setText(prop.getProperty("ipAddress"));
        	gui.textField_User.setText(prop.getProperty("user"));
        	gui.passwordField.setText(prop.getProperty("password"));
        	gui.textField_Filepath.setText(prop.getProperty("filepath"));
        	gui.textField_Filename.setText(prop.getProperty("filename"));
        	
        	if (prop.getProperty("includeDate").equals("false")){
        		gui.chckbx_Date.setSelected(false);
        	}
        	
    	}
    	
    	//add the listeners to the buttons
    	addListeners(gui);
    	
	}

	//write the parameters set in the GUI to file
	public static void writeProperties(GUI gui){
		
		//get parameters from GUI
		String ipAddress = gui.textField_IP.getText();
		String user = gui.textField_User.getText();
		String password = gui.passwordField.getText();
		String filepath = gui.textField_Filepath.getText();
		String filename = gui.textField_Filename.getText();
		String includeDate = ""+ gui.chckbx_Date.isSelected();
		
		//write the file
		if(PropertiesHandler.writePropertiesFile(ipAddress, user, password, filepath, filename, includeDate)){
			OptionPanes.notifyPresetSaved(gui);
		}
		
	}
	
	
	//backup the router config file 
	public static void backup(GUI gui){
		
    	String fileDate = "";
    	String fileExt  = ".bin";
    	
    	//get parameters from GUI
    	String ipAddress = gui.textField_IP.getText();
		String user = gui.textField_User.getText();
		String password = gui.passwordField.getText();
		String filepath = gui.textField_Filepath.getText();
		String filename = gui.textField_Filename.getText();
		
		
		//check if the path ends with "/" or "\" - if not, display a Popup
		if (!(filepath.endsWith("/") || filepath.endsWith("\\")))
			OptionPanes.notifyFilepathEnd(gui);
			
    	//generate Date for fileName
		if (gui.chckbx_Date.isSelected()){
		    DateGenerator myDate = new DateGenerator();
		    String[] dateArray = myDate.generateDate();
		    fileDate = " - " + dateArray[0]+ "-" + dateArray[1]+ "-" +dateArray[2];
		}

		//call the HttpBasicAuth class to handle the authentification and backup
		HttpBasicAuth HttpAuthentication = new HttpBasicAuth();
		
	  	try{
	  		if(HttpAuthentication.getBackupFile(ipAddress, user, password, filepath, filename, fileExt, fileDate))
	  			OptionPanes.notifyBackupSuccess(gui);
	  	}
	  	catch(IOException e){
	  		OptionPanes.notifyConnectionError(gui, e.getMessage());
	  	}
	  	
	}
	
	
	//add listeners to the buttons
	public static void addListeners(final GUI gui){
    	gui.addActionListeners(new ActionListener() {
		       public void actionPerformed(ActionEvent btn_Preset) {
		    	   writeProperties(gui);
		       }
		   },
		   new ActionListener() {
		       public void actionPerformed(ActionEvent btn_BackupNow) {
		    	   backup(gui);
		       }
		   });
    	}
}
