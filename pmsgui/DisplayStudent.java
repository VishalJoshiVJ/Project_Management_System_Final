package pmsgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

class StudentNotAddedException extends Exception {
	String msg = new String();

	public StudentNotAddedException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}

public class DisplayStudent{

	JFrame displayStdFrame;
	private JTextField usnTf;

	

	/**
	 * Create the application.
	 */
	public DisplayStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayStdFrame = new JFrame("Academic Project Management System");
		displayStdFrame.setBounds(100, 100, 808	, 495);
		displayStdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayStdFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(299, 21, 260, 33);
		displayStdFrame.getContentPane().add(lblNewLabel);
		
		JLabel usnLbl = new JLabel("Enter USN");
		usnLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		usnLbl.setBounds(89, 95, 71, 14);
		displayStdFrame.getContentPane().add(usnLbl);
		
		usnTf = new JTextField();
		usnTf.setBounds(190, 92, 121, 20);
		displayStdFrame.getContentPane().add(usnTf);
		usnTf.setColumns(10);
		
		
		
		JLabel nameLbl = new JLabel("");
		nameLbl.setBackground(Color.WHITE);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameLbl.setBounds(128, 144, 94, 14);
		displayStdFrame.getContentPane().add(nameLbl);
		
		JLabel usn1Lbl = new JLabel("");
		usn1Lbl.setFont(new Font("Arial", Font.BOLD, 14));
		usn1Lbl.setBounds(128, 184, 94, 14);
		displayStdFrame.getContentPane().add(usn1Lbl);
		
		JLabel rollLbl = new JLabel("");
		rollLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rollLbl.setBounds(128, 222, 110, 18);
		displayStdFrame.getContentPane().add(rollLbl);
		
		JLabel addressLbl = new JLabel("");
		addressLbl.setFont(new Font("Arial", Font.BOLD, 14));
		addressLbl.setBounds(128, 263, 94, 14);
		displayStdFrame.getContentPane().add(addressLbl);
		
		JLabel emailLbl = new JLabel("");
		emailLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailLbl.setBounds(128, 302, 110, 14);
		displayStdFrame.getContentPane().add(emailLbl);
		
		JLabel phoneLbl = new JLabel("");
		phoneLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phoneLbl.setBounds(128, 343, 127, 18);
		displayStdFrame.getContentPane().add(phoneLbl);
		
		JLabel nameOpLbl = new JLabel("");
		nameOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameOpLbl.setBounds(327, 144, 203, 20);
		displayStdFrame.getContentPane().add(nameOpLbl);
		
		JLabel usn1OpLbl = new JLabel("");
		usn1OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		usn1OpLbl.setBounds(326, 184, 244, 20);
		displayStdFrame.getContentPane().add(usn1OpLbl);
		
		JLabel rollOpLbl = new JLabel("");
		rollOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rollOpLbl.setBounds(326, 222, 244, 20);
		displayStdFrame.getContentPane().add(rollOpLbl);
		
		JLabel addressOpLbl = new JLabel("");
		addressOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		addressOpLbl.setBounds(327, 263, 260, 20);
		displayStdFrame.getContentPane().add(addressOpLbl);
		
		JLabel emailOpLbl = new JLabel("");
		emailOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailOpLbl.setBounds(327, 302, 276, 20);
		displayStdFrame.getContentPane().add(emailOpLbl);
		
		JLabel phoneOpLbl = new JLabel("");
		phoneOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phoneOpLbl.setBounds(327, 343, 276, 20);
		displayStdFrame.getContentPane().add(phoneOpLbl);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usn = usnTf.getText();
				
				JFrame f = new JFrame();
				
				boolean flag = false;
				String user = null;
				
				 try{
					 Conn c = new Conn();
					 
					 ResultSet rs = c.st.executeQuery("SELECT * FROM project_management_system.loggedin");
						while(rs.next()) {
							user = rs.getString(1);
						}
					 
					 PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.student WHERE USN = (?) AND USER = (?)");
					 ps.setString(1, usn);
					 ps.setString(2, user);
					 rs = ps.executeQuery();
					while(rs.next()){
						nameLbl.setText("Name : ");
						usn1Lbl.setText("USN : ");
						rollLbl.setText("Roll Number : ");
						addressLbl.setText("Address : ");
						emailLbl.setText("Email ID : ");
						phoneLbl.setText("Phone Number : ");
						
						
						nameOpLbl.setText(rs.getString(1));
						usn1OpLbl.setText(rs.getString(2));
						rollOpLbl.setText(Integer.toString(rs.getInt(3)));
						addressOpLbl.setText(rs.getString(4));
						emailOpLbl.setText(rs.getString(5));
						phoneOpLbl.setText(rs.getString(6));
						
						flag = true;
						
						
						
					}
				}
				 catch(Exception e1) {
					 JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				 }
				
				try {
				if(!flag) {
					throw new StudentNotAddedException("Student not present");
				}
				}catch(StudentNotAddedException e1) {
					JOptionPane.showMessageDialog(f, e1.getMessage());
				}
			}
		});
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Times New Roman", Font.BOLD, 13));
		display.setBounds(574, 91, 89, 23);
		displayStdFrame.getContentPane().add(display);
		
		JButton home = new JButton(" Home");
		home.addActionListener(new ActionListener() {		//Open Home Page on clicking button
			public void actionPerformed(ActionEvent e) {
				displayStdFrame.setVisible(false);
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
		});
		home.setForeground(Color.WHITE);
		home.setBackground(Color.BLACK);
		home.setFont(new Font("Times New Roman", Font.BOLD, 13));
		home.setBounds(574, 394, 89, 23);
		displayStdFrame.getContentPane().add(home);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\pms1.jpeg"));
		lblNewLabel_14.setBounds(0, 0, 792, 456);
		displayStdFrame.getContentPane().add(lblNewLabel_14);
	}

}
