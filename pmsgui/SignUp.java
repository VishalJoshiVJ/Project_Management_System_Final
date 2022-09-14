package pmsgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class SignUp {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sign Up");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 697, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(236, 11, 437, 324);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 23, 98, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(72, 78, 79, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(72, 125, 79, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(72, 173, 117, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		textField.setBounds(212, 76, 106, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 123, 106, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(212, 171, 106, 20);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				String user = textField.getText();
				String pass = passwordField.getText();
				String confirmPass = passwordField_1.getText();
				boolean flag = false;
				
				if(pass.equals(confirmPass)) {
					try {
						Conn c = new Conn();
						PreparedStatement ps = c.conn.prepareStatement("INSERT INTO project_management_system.login VALUES(?,?)");
						ps.setString(1, user);
						ps.setString(2, pass);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(f, "Sign Up successful");
						frame.setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Login window = new Login();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(f, "Something went wrong");
					}
					
					
				}else {
					JOptionPane.showMessageDialog(f, "Passwords are not matching");
				}
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnNewButton.setBounds(106, 247, 83, 23);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.frame.setVisible(true);
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
		btnCancel.setBounds(229, 247, 79, 23);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\signup.jpg"));
		lblNewLabel_4.setBounds(0, 0, 235, 346);
		frame.getContentPane().add(lblNewLabel_4);
	}

}
