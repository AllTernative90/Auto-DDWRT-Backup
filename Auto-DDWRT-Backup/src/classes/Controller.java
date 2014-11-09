package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class Controller{

	static GUI gui;
	
	static String ipAddress = "";
	static String user = "";
	static String password = "";
	static String filepath = "";
	static String filename = "";
	static String includeDate = "";
	
	public static void main(String[] args) {
		
		//create the GUI
		createGUI(); 
		
	}
	
	
	//create a GUI element, check if a properties file exists and update the GUI with those values
	public static void createGUI(){
		
		gui = new GUI();
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
    	addListeners();
    	
	}
	
	
	public static void getParametersFromGUI(){
		ipAddress = gui.textField_IP.getText();
		user = gui.textField_User.getText();
		password = gui.passwordField.getText();
		filepath = gui.textField_Filepath.getText();
		filename = gui.textField_Filename.getText();
		includeDate = ""+ gui.chckbx_Date.isSelected();
	}
	

	//write the parameters set in the GUI to file
	public static void writeProperties(){
		
		//get parameters from GUI
		getParametersFromGUI();
		
		//write the file
		if(PropertiesHandler.writePropertiesFile(ipAddress, user, password, filepath, filename, includeDate)){
			OptionPanes.notifyPresetSaved(gui);
		}
		
	}
	
	
	//backup the router config file 
	public static void backup(){
		
    	String fileDate = "";
    	String fileExt  = ".bin";
    	
    	//get parameters from GUI
    	getParametersFromGUI();
		
		
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
	public static void addListeners(){
    	gui.addActionListeners(new ActionListener() {
		       public void actionPerformed(ActionEvent btn_Preset) {
		    	   writeProperties();
		       }
		   },
		   new ActionListener() {
		       public void actionPerformed(ActionEvent btn_BackupNow) {
		    	   backup();
		       }
		   });
    	}
}
