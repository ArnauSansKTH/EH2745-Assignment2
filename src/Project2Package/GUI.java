package Project2Package;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Project2Package.GUIdisplay1;
import java.awt.Font;

public class GUI {

	private JFrame frame;

	private JTextField textFieldUsername1;
	private JPasswordField passwordfield1;
	
	protected static final String USERN = null;
	protected static final String PASSW = null;
	private JLabel lblAssignment;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUsername1 = new JTextField();
		textFieldUsername1.setBounds(30, 124, 500, 22);
		frame.getContentPane().add(textFieldUsername1);
		textFieldUsername1.setColumns(10);
		
		JLabel lblInsertUsername = new JLabel("Introduce MySQL username:");
		lblInsertUsername.setBounds(30, 80, 500, 16);
		frame.getContentPane().add(lblInsertUsername);
		
		JLabel lblIntroduceMysqlPassword_1 = new JLabel("Introduce MySQL password:");
		lblIntroduceMysqlPassword_1.setBounds(30, 187, 500, 16);
		frame.getContentPane().add(lblIntroduceMysqlPassword_1);
		
		passwordfield1 = new JPasswordField();
		passwordfield1.setBounds(30, 233, 500, 22);
		frame.getContentPane().add(passwordfield1);
		passwordfield1.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				KNN.run(textFieldUsername1.getText(),String.valueOf((passwordfield1.getPassword())));
				
				
				GUIdisplay1 display = new GUIdisplay1();
				display.setTitle("Final Cluster 1");
				display.setVisible(true);
				
				
				GUIdisplay2 display2 = new GUIdisplay2();
				display2.setTitle("Final Cluster 2");
				display2.setVisible(true);
				
				
				GUIdisplay3 display3 = new GUIdisplay3();
				display3.setTitle("Final Cluster 3");
				display3.setVisible(true);
				
				
				GUIdisplay4 display4 = new GUIdisplay4();
				display4.setTitle("Final Cluster 4");
				display4.setVisible(true);
				
				
			}
		});
		btnRun.setBounds(237, 334, 106, 44);
		frame.getContentPane().add(btnRun);
		
		lblAssignment = new JLabel("Assignment 2");
		lblAssignment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAssignment.setBounds(237, 34, 126, 31);
		frame.getContentPane().add(lblAssignment);
	

	}
}
