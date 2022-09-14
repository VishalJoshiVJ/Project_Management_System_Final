package pmsgui;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AddStudent {

	JFrame addStdFrame,f;
	JTextField nameTf;
	JTextField usnTf;
	JTextField rollTf;
	JTextField emailTf;
	JTextField addressTf;
	JTextField phoneTf;

	

	/**
	 * Create the application.
	 */
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addStdFrame = new JFrame("Academic Project Management System");
		addStdFrame.setBounds(100, 100, 808, 495);
		addStdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addStdFrame.getContentPane().setLayout(null);
		
		f = new JFrame();
		
		
		
		JLabel lblEnterStudentDetails = new JLabel("Enter Student Details");
		lblEnterStudentDetails.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblEnterStudentDetails.setBounds(283, 25, 301, 49);
		addStdFrame.getContentPane().add(lblEnterStudentDetails);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameLbl.setBounds(173, 121, 46, 14);
		addStdFrame.getContentPane().add(nameLbl);
		
		JLabel usnLbl = new JLabel("USN");
		usnLbl.setFont(new Font("Arial", Font.BOLD, 14));
		usnLbl.setBounds(173, 159, 46, 14);
		addStdFrame.getContentPane().add(usnLbl);
		
		JLabel rollLbl = new JLabel("Roll Number");
		rollLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rollLbl.setBounds(174, 197, 119, 14);
		addStdFrame.getContentPane().add(rollLbl);
		
		JLabel emailLbl = new JLabel("Email ID");
		emailLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailLbl.setBounds(174, 234, 79, 14);
		addStdFrame.getContentPane().add(emailLbl);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setFont(new Font("Arial", Font.BOLD, 14));
		addressLbl.setBounds(174, 271, 79, 14);
		addStdFrame.getContentPane().add(addressLbl);
		
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phoneLbl.setBounds(174, 305, 119, 14);
		addStdFrame.getContentPane().add(phoneLbl);
		
		nameTf = new JTextField();
		nameTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		nameTf.setBounds(426, 120, 207, 20);
		addStdFrame.getContentPane().add(nameTf);
		nameTf.setColumns(10);
		
		usnTf = new JTextField();
		usnTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		usnTf.setBounds(426, 158, 207, 20);
		addStdFrame.getContentPane().add(usnTf);
		usnTf.setColumns(10);
		
		rollTf = new JTextField();
		rollTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rollTf.setBounds(426, 196, 207, 20);
		addStdFrame.getContentPane().add(rollTf);
		rollTf.setColumns(10);
		
		emailTf = new JTextField();
		emailTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		emailTf.setBounds(426, 233, 207, 20);
		addStdFrame.getContentPane().add(emailTf);
		emailTf.setColumns(10);
		
		addressTf = new JTextField();
		addressTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		addressTf.setBounds(426, 270, 207, 20);
		addStdFrame.getContentPane().add(addressTf);
		addressTf.setColumns(10);
		
		phoneTf = new JTextField();
		phoneTf.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		phoneTf.setBounds(426, 303, 207, 20);
		addStdFrame.getContentPane().add(phoneTf);
		phoneTf.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				String user = null;
				try {
					Conn c = new Conn();
					ResultSet rs = c.st.executeQuery("SELECT * FROM project_management_system.loggedin");
					while(rs.next()) {
						user = rs.getString(1);
					}
					String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?)";
					PreparedStatement ps = c.conn.prepareStatement(sql);
					ps.setString(1, usnTf.getText());
					ps.setString(2, nameTf.getText());
					ps.setInt(3, Integer.parseInt(rollTf.getText()));
					ps.setString(4, emailTf.getText());
					ps.setString(5, addressTf.getText());
					ps.setString(6, phoneTf.getText());
					ps.setString(7, user);
					ps.executeUpdate();
					flag = true;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(f, "Something went wrong");
				}
				
				if(flag) {
					JOptionPane.showMessageDialog(f, "Student Added Successfully");
				}
				
				addStdFrame.setVisible(false);
				
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
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		submit.setBackground(Color.BLACK);
		submit.setBounds(264, 385, 89, 23);
		addStdFrame.getContentPane().add(submit);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {		//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				addStdFrame.setVisible(false);
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
		cancel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(428, 385, 89, 23);
		addStdFrame.getContentPane().add(cancel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\project-management.jpg"));
		lblNewLabel_6.setBounds(0, 0, 792, 456);
		addStdFrame.getContentPane().add(lblNewLabel_6);
	}
}
