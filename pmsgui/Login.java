package pmsgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class Login {

	JFrame frame;
	JTextField textField;
	JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 694, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(232, 0, 454, 256);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(196, 29, 100, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(106, 93, 99, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(106, 131, 99, 21);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField.setBounds(234, 95, 124, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(234, 130, 124, 21);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = false;
				try {
					JFrame f = new JFrame();
					Conn c = new Conn();
					String user = textField.getText();
					String pass = passwordField.getText();
					ResultSet rs = c.st.executeQuery("SELECT * FROM project_management_system.login");
					while(rs.next()) {
						if(rs.getString(1).equals(user) && rs.getString(2).equals(pass)) {
							frame.setVisible(false);
							flag = true;
							PreparedStatement ps = c.conn.prepareStatement("UPDATE project_management_system.loggedin SET username = (?), password = (?)");
							ps.setString(1, user);
							ps.setString(2, pass);
							ps.executeUpdate();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										User window = new User();
										window.userFrame.setVisible(true);
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
						
					}
					if(!flag) {
						JOptionPane.showMessageDialog(f, "Invalid username or password");
					}
					}catch(Exception e) {
						
					}
			}
				
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnNewButton.setBounds(106, 198, 65, 23);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUp window = new SignUp();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBounds(215, 198, 81, 23);
		panel.add(btnSignUp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Front window = new Front();
							window.frontFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(341, 198, 72, 23);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\login.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 234, 256);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
