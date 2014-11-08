package classes;

import javax.swing.JOptionPane;

public class OptionPanes {
	
	
	public static void notifyFilepathEnd(GUI gui){
		JOptionPane.showMessageDialog(gui.passwordField,
				"Filepath does not end with '/' or '\\'.\nFile might have been saved to wrong path." );	
	}
	
	public static void notifyConnectionError(GUI gui, String errorMessage){
		JOptionPane.showMessageDialog(gui.passwordField,
				"Connection couldn't be established. Check Router-Settings (IP/User/Password) \n\nError Message:\n"+errorMessage );	
	}
	
	public static void notifyPresetSaved(GUI gui){
		JOptionPane.showMessageDialog(gui.passwordField,
				"Preset saved.");	
	}
	
	public static void notifyBackupSuccess(GUI gui){
		JOptionPane.showMessageDialog(gui.passwordField,
				"Backup has been saved successfully.");	
	}

}
