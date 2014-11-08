package classes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	public JTextField textField_IP,textField_User,passwordField,textField_Filepath,textField_Filename;
	public JButton btn_BackupNow, btn_Preset;
	public JCheckBox chckbx_Date;
	private JLabel lbl_User;
	private JLabel lbl_Password;
	private JLabel lbl_Router;
	private JLabel lbl_File;
	private JLabel lbl_Filepath;
	private JLabel lbl_Filename;


	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Auto-DDWRT-Backup");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lbl_IP = new JLabel("IP-Adress of Router / Source File");
		contentPane.add(lbl_IP);
		
		textField_IP = new JTextField();
		textField_IP.setText("http://192.168.0.1:80/nvrambak.bin");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_IP, 5, SpringLayout.SOUTH, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_IP, 0, SpringLayout.WEST, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_IP, -20, SpringLayout.EAST, contentPane);
		contentPane.add(textField_IP);
		textField_IP.setColumns(10);
		
		lbl_User = new JLabel("User");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_User, 10, SpringLayout.SOUTH, textField_IP);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_User, 0, SpringLayout.WEST, lbl_IP);
		contentPane.add(lbl_User);
		
		textField_User = new JTextField();
		textField_User.setText("admin");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_User, 5, SpringLayout.SOUTH, lbl_User);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_User, 0, SpringLayout.WEST, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_User, 0, SpringLayout.EAST, textField_IP);
		contentPane.add(textField_User);
		textField_User.setColumns(10);
		
		lbl_Password = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_Password, 10, SpringLayout.SOUTH, textField_User);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Password, 0, SpringLayout.WEST, lbl_IP);
		contentPane.add(lbl_Password);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 5, SpringLayout.SOUTH, lbl_Password);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textField_IP);
		contentPane.add(passwordField);
		
		lbl_Router = new JLabel("Router-Settings");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_IP, 10, SpringLayout.SOUTH, lbl_Router);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Router, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_IP, 10, SpringLayout.WEST, lbl_Router);
		lbl_Router.setFont(new Font("Tahoma", Font.BOLD, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_Router, 5, SpringLayout.NORTH, contentPane);
		contentPane.add(lbl_Router);
		
		lbl_File = new JLabel("File-Settings");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_File, 20, SpringLayout.SOUTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_File, 0, SpringLayout.WEST, lbl_Router);
		lbl_File.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lbl_File);
		
		lbl_Filepath = new JLabel("File-Path");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_Filepath, 10, SpringLayout.SOUTH, lbl_File);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Filepath, 10, SpringLayout.WEST, lbl_Router);
		contentPane.add(lbl_Filepath);
		
		textField_Filepath = new JTextField();
		textField_Filepath.setText("H:/_250/_Daten/_Backups/Backups Router/");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_Filepath, 5, SpringLayout.SOUTH, lbl_Filepath);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_Filepath, 0, SpringLayout.WEST, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_Filepath, 0, SpringLayout.EAST, passwordField);
		contentPane.add(textField_Filepath);
		textField_Filepath.setColumns(10);
		
		lbl_Filename = new JLabel("File-Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_Filename, 10, SpringLayout.SOUTH, textField_Filepath);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Filename, 0, SpringLayout.WEST, textField_Filepath);
		contentPane.add(lbl_Filename);
		
		textField_Filename = new JTextField();
		textField_Filename.setText("DD-WRT v24-sp2 (122413)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_Filename, 5, SpringLayout.SOUTH, lbl_Filename);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_Filename, 0, SpringLayout.WEST, lbl_IP);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_Filename, 0, SpringLayout.EAST, textField_Filepath);
		contentPane.add(textField_Filename);
		textField_Filename.setColumns(10);
		
		chckbx_Date = new JCheckBox("Include current date in file name");
		chckbx_Date.setSelected(true);
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbx_Date, 10, SpringLayout.SOUTH, textField_Filename);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbx_Date, 0, SpringLayout.WEST, textField_Filename);
		contentPane.add(chckbx_Date);
		
		btn_BackupNow = new JButton("Backup Now!");
		sl_contentPane.putConstraint(SpringLayout.WEST, btn_BackupNow, 0, SpringLayout.WEST, chckbx_Date);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btn_BackupNow, 40, SpringLayout.SOUTH, chckbx_Date);
		contentPane.add(btn_BackupNow);
		
		btn_Preset = new JButton("Save Preset");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btn_Preset, 0, SpringLayout.NORTH, btn_BackupNow);
		sl_contentPane.putConstraint(SpringLayout.EAST, btn_Preset, 0, SpringLayout.EAST, textField_Filename);
		contentPane.add(btn_Preset);
		
	}
	
	public void addActionListeners(ActionListener al1, ActionListener al2){
	    btn_Preset.addActionListener(al1);
	    btn_BackupNow.addActionListener(al2);
	}
}
